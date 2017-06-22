package cz.zcu.yafmt.ui.pages;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.zcu.yafmt.ui.util.DelayedRunner;

public class EditorContentOutlinePage extends ContentOutlinePage implements ISelectionListener {

    private CTabFolder tabFolder;
    private ScrollableThumbnail minimapThumbmail;
    private TreeViewer treeViewer;
    
    protected FreeformGraphicalRootEditPart rootEditPart;
    protected Object input;
    protected IContentProvider contentProvider;
    protected ILabelProvider labelProvider;
    
    private DelayedRunner refreshDelayedRunner = new DelayedRunner();
    private DelayedRunner selectionDelayedRunner = new DelayedRunner();

    public EditorContentOutlinePage(GraphicalEditor editor, Object input, IContentProvider contentProvider, ILabelProvider labelProvider) {
        this.rootEditPart = (FreeformGraphicalRootEditPart) editor.getAdapter(EditPart.class);
        this.input = input;
        this.contentProvider = contentProvider;
        this.labelProvider = labelProvider;
    }
    
    @Override
    public Control getControl() {
        return tabFolder;
    }
    
    @Override
    public void setFocus() {
        tabFolder.setFocus();
    }
    
    @Override
    protected TreeViewer getTreeViewer() {
        return treeViewer;
    }
    
    @Override
    public ISelection getSelection() {
        return (treeViewer == null) ? StructuredSelection.EMPTY : treeViewer.getSelection();
    }
    
    @Override
    public void setSelection(ISelection selection) {
        if(treeViewer != null)
            treeViewer.setSelection(selection);
    }
    
    // ==================================================================
    //  Basic initialization
    // ==================================================================

    @Override
    public void init(IPageSite pageSite) {
        super.init(pageSite);
        pageSite.getPage().addSelectionListener(this);
    }

    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        minimapThumbmail.deactivate();
        super.dispose();
    }

    @Override
    public void createControl(Composite parent) {
        tabFolder = new CTabFolder(parent, SWT.BOTTOM); // Use CTabFolder, because TabFolder looks ugly.
        createTabControls(tabFolder);
        tabFolder.setSelection(0);
    }

    protected void createTabControls(Composite parent) {
        createTreeView();
        createMinimap(parent);
    }

    protected void addTabControl(Control control, String title) {
        CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
        tabItem.setText(title);
        tabItem.setControl(control);
    }
    
    // ==================================================================
    //  Tabs initialization
    // ==================================================================

    private void createTreeView() {
        treeViewer = new TreeViewer(tabFolder) {
            
            @Override
            public void refresh(Object element) {
                refresh(false);
            }
            
            @Override
            public void refresh(Object element, final boolean updateLabels) {
                // Sometimes many refresh events are generated at once and it really slows down the work.
                refreshDelayedRunner.run(500, new Runnable() {
                    @Override
                    public void run() {
                        performRefresh(updateLabels);
                    }
                });
            }
            
            private void performRefresh(boolean updateLabels) {
                super.refresh(getRoot(), updateLabels);
            }
            
        };
        treeViewer.addSelectionChangedListener(this);
        treeViewer.setContentProvider(contentProvider);
        treeViewer.setLabelProvider(labelProvider);
        treeViewer.setInput(input);

        addTabControl(treeViewer.getControl(), "Tree View");
    }

    private void createMinimap(Composite parent) {
        minimapThumbmail = new ScrollableThumbnail();
        minimapThumbmail.setViewport((Viewport) rootEditPart.getFigure());
        minimapThumbmail.setSource(createMinimapThumbmailFigure(minimapThumbmail, rootEditPart));

        Canvas canvas = new Canvas(parent, SWT.NONE);
        LightweightSystem lightweightSystem = new LightweightSystem(canvas);
        lightweightSystem.setContents(minimapThumbmail);

        addTabControl(canvas, "Minimap");
    }
    
    protected IFigure createMinimapThumbmailFigure(Thumbnail thumbmail, FreeformGraphicalRootEditPart rootEditPart) {
        return rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS);
    }
    
    // ==================================================================
    //  Event handling
    // ==================================================================

    @Override
    public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
        // Sometimes many selection events are generated at once and it really slows down the work.
        selectionDelayedRunner.run(50, new Runnable() {            
            @Override
            public void run() {
                IWorkbenchPart activePart = getSite().getPage().getActivePart();
                if((part != activePart) || (part instanceof ContentOutline) || (part instanceof PropertySheet))
                    return;

                // Forward selection to the TreeViewer.
                if(!getSelection().equals(selection))
                    setSelection(selection);
            }
        });
    }

}
