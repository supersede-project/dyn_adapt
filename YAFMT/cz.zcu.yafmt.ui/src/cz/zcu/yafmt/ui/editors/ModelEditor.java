package cz.zcu.yafmt.ui.editors;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.zcu.yafmt.ui.CommonUIPlugin;
import cz.zcu.yafmt.ui.actions.EditorZoomComboContributioItem;
import cz.zcu.yafmt.ui.pages.EditorContentOutlinePage;
import cz.zcu.yafmt.ui.pages.EditorPropertySheetPage;
import cz.zcu.yafmt.ui.parts.EditorRootEditPart;
import cz.zcu.yafmt.ui.tools.MiddleButtonPanningSelectionTool;
import cz.zcu.yafmt.ui.util.EditorAutoCloser;
import cz.zcu.yafmt.ui.util.SelectionWrapper;
import cz.zcu.yafmt.ui.util.UnwrappingSelectionProvider;
import cz.zcu.yafmt.ui.validation.IProblemManager;
import cz.zcu.yafmt.ui.validation.ModelMarkerDescriptor;
import cz.zcu.yafmt.ui.validation.ResourceProblemManager;

public abstract class ModelEditor extends GraphicalEditorWithFlyoutPalette implements IGotoMarker {

    private IContentOutlinePage contentOutlinePage;
    private IPropertySheetPage propertySheetPage;
    private EditorAutoCloser editorAutoCloser;
    private UnwrappingSelectionProvider selectionProvider;
    private ResourceProblemManager problemManager;

    public ModelEditor() {
        editorAutoCloser = new EditorAutoCloser(this);
        setEditDomain(createDefaultEditDomain());
    }
    
    private DefaultEditDomain createDefaultEditDomain() {
        DefaultEditDomain editDomain = new DefaultEditDomain(this);
        editDomain.setDefaultTool(new MiddleButtonPanningSelectionTool());
        editDomain.setActiveTool(editDomain.getDefaultTool());
        return editDomain;
    }

    // ==================================================================================
    //  Basic initialization
    // ==================================================================================

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if(!(input instanceof IFileEditorInput))
            throw new PartInitException("Invalid input: Must be IFileEditorInput");

        super.init(site, input);
        setPartName(input.getName());

        try {
            doLoad((IFileEditorInput) input);
            problemManager = new ResourceProblemManager(((IFileEditorInput) input).getFile());
        }
        catch(Exception ex) {
            String path = ((IFileEditorInput) input).getFile().getFullPath().toString();
            throw new PartInitException("Unable to load " + path, ex);
        }

        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorAutoCloser);
    }

    @Override
    public void dispose() {
        problemManager.restoreState();
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorAutoCloser);
        super.dispose();
    }

    // ==================================================================================
    //  Editor initialization
    // ==================================================================================
            
    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();

        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setRootEditPart(new EditorRootEditPart());
        viewer.setEditPartFactory(getEditPartFactory());

        ContextMenuProvider contextMenuProvider = getContextMenuProvider();
        if(contextMenuProvider != null)
            viewer.setContextMenu(contextMenuProvider);
        
        // Viewer propertis.
        viewer.setProperty(SnapToGrid.PROPERTY_GRID_SPACING, new Dimension(15, 15)); // Grid size
        viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.MOD1), MouseWheelZoomHandler.SINGLETON); // Zooming with CTRL + mouse wheel.

        // Actions need original selection provider.
        createActionsLate();
        setActionsSelectionProvider(viewer);
    }

    @Override
    protected void hookGraphicalViewer() {
        super.hookGraphicalViewer();

        // Provide unwrapped selections for rest of the world.
        selectionProvider = new UnwrappingSelectionProvider(getGraphicalViewer());
        getSite().setSelectionProvider(selectionProvider);
    }

    @Override
    protected void initializeGraphicalViewer() {
        getGraphicalViewer().setContents(getModel());
        problemManager.saveState();
    }
    
    // ==================================================================================
    //  Providers
    // ==================================================================================
    
    protected ScalableFreeformRootEditPart getRootEditPart() {
        return (ScalableFreeformRootEditPart) getGraphicalViewer().getRootEditPart();
    }

    protected UnwrappingSelectionProvider getSelectionProvider() {
        return selectionProvider;
    }
    
    protected IProblemManager getProblemManager() {
        return problemManager;
    }

    @Override
    protected PaletteRoot getPaletteRoot() {
        return null;
    }

    protected ContextMenuProvider getContextMenuProvider() {
        return null;
    }

    protected abstract EObject getModel();

    protected abstract EditPartFactory getEditPartFactory();

    protected abstract ILabelProvider getLabelProvider();

    protected abstract IPropertySourceProvider getPropertySourceProvider();

    protected abstract IContentProvider getContentProvider();

    // ==================================================================================
    //  Actions
    // ==================================================================================

    private void fixGEFActionDefinitionId(ActionFactory factory) {
        IAction gefAction = getActionRegistry().getAction(factory.getId());
        if((gefAction != null) && (gefAction.getActionDefinitionId() == null))
            gefAction.setActionDefinitionId(factory.getCommandId());
    }
    
    @SuppressWarnings("unchecked")
    protected void createAction(IAction action) {
        getActionRegistry().registerAction(action);
        if(action instanceof SelectionAction)
            getSelectionActions().add(action.getId());
    }
    
    @Override
    protected void createActions() {
        super.createActions();
        // GEF actions are missing definitions IDs which are needed to display assigned keyboard shortcuts.
        fixGEFActionDefinitionId(ActionFactory.UNDO);
        fixGEFActionDefinitionId(ActionFactory.REDO);
        fixGEFActionDefinitionId(ActionFactory.DELETE);
    }

    protected void createActionsLate() {
        ZoomManager zoomManager = getRootEditPart().getZoomManager();
        zoomManager.setZoomLevels(new double[] { 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.85, 1.0, 1.2, 1.4, 1.6, 1.8, 2.0, 2.25, 2.5, 2.75, 3.0, 3.5, 4.0, 5.0 });
        EditorZoomComboContributioItem.contributeZoomLevels(zoomManager);
        createAction(new ZoomInAction(zoomManager));
        createAction(new ZoomOutAction(zoomManager));
    }

    private void setActionsSelectionProvider(ISelectionProvider selectionProvider) {
        for(Iterator<?> it = getActionRegistry().getActions(); it.hasNext();) {
            IAction action = (IAction) it.next();
            if(action instanceof SelectionAction)
                ((SelectionAction) action).setSelectionProvider(selectionProvider);
        }
    }

    // ==================================================================================
    //  Event handling
    // ==================================================================================

    @Override
    public void commandStackChanged(EventObject event) {
        super.commandStackChanged(event);
        firePropertyChange(PROP_DIRTY);
        updateActions(getSelectionActions());
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        super.selectionChanged(part, selection); // Update all selection actions.

        // Ignore invalid selections.
        IEditorPart activeEditor = getSite().getPage().getActiveEditor();
        IWorkbenchPart activePart = getSite().getPage().getActivePart();
        if((this != activeEditor) || (part != activePart) || (part == this) || (part instanceof PropertySheet))
            return;

        // Apply selection to the editor if it differs.
        selection = SelectionWrapper.toEditPartsSelection(selection, getGraphicalViewer().getEditPartRegistry());
        if(!getGraphicalViewer().getSelection().equals(selection))
            applySelection(selection);
    }

    private void applySelection(ISelection selection) {
        getGraphicalViewer().setSelection(selection);
        if(selection.isEmpty())
            return;

        // Center viewport to last selected object.
        if(selection instanceof IStructuredSelection) {
            Object[] objects = ((IStructuredSelection) selection).toArray();
            for(int i = objects.length - 1; i >= 0; i--) {
                if(objects[i] instanceof GraphicalEditPart) {
                    centerViewportToEditPart((GraphicalEditPart) objects[i]);
                    break;
                }
            }
        }
    }

    private void centerViewportToEditPart(GraphicalEditPart editPart) {
        Viewport viewport = ((FigureCanvas) getGraphicalControl()).getViewport(); 
        Point point = editPart.getFigure().getBounds().getCenter();
        int x = point.x - viewport.getSize().width / 2;
        int y = point.y - viewport.getSize().height / 2;
        viewport.setViewLocation(x, y);
    }
    
    // ==================================================================================
    //  Markers
    // ==================================================================================
    
    @Override
    public void gotoMarker(IMarker marker) {
        try {
            if(!marker.exists() || !marker.getType().equals(ModelMarkerDescriptor.MARKER_ID))
                return;
            
            String uriFragments = marker.getAttribute(ModelMarkerDescriptor.OBJECTS_URI_ID, null);
            if(uriFragments == null)
                return;
            
            Resource resource = getModel().eResource();
            if(resource == null)
                return;
            
            final List<Object> markerObjects = new ArrayList<Object>();
            for(String uriFragment: uriFragments.split(ModelMarkerDescriptor.URI_FRAGMENTS_SEPARATOR)) {
                EObject object = resource.getEObject(uriFragment);
                if(object != null)
                    markerObjects.add(object);
            }
            
            if(!markerObjects.isEmpty()) {
                // When user double-click the marker in problems view the
                // editor is activated and gotoMarker is called. But then, 
                // the problems view is activated again which causes invalidation
                // of editor selection that was done in gotoMarker method.
                // We have to call the selection code in asynchronous thread
                // and reactivate the editor manually. However this is causing
                // ugly effect switching twice between editor and problem view.
                getSite().getShell().getDisplay().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        getSite().getPage().activate(ModelEditor.this);
                        gotoMarker(markerObjects);
                    }
                });
            }
        }
        catch(CoreException ex) {
            CommonUIPlugin.getAccess().logError(ex);
        }
    }
    
    protected void gotoMarker(List<Object> markerObjects) {
        ISelection selection = new StructuredSelection(markerObjects);
        applySelection(SelectionWrapper.toEditPartsSelection(selection, getGraphicalViewer().getEditPartRegistry()));
    }

    // ==================================================================================
    //  Save and Load operations
    // ==================================================================================

    protected abstract void doLoad(IFileEditorInput input) throws Exception;

    protected abstract void doSave() throws Exception;
    
    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            doSave();
            if(getGraphicalViewer() != null) {
                getEditDomain().getCommandStack().markSaveLocation();
                firePropertyChange(PROP_DIRTY);
                problemManager.saveState();
            }
        }
        catch(Exception ex) {
            MessageDialog.openError(getSite().getShell(), "Unable to save " + getEditorInput().getName(), ex.getMessage());
        }
    }

    public void doSaveAs() {
        SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
        dialog.open();

        IPath path = dialog.getResult();
        if(path == null)
            return;

        setInputWithNotify(new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(path)));
        setPartName(getEditorInput().getName());
        doSave(null);
    }

    public boolean isSaveAsAllowed() {
        return true;
    }
    
    protected void executeWorkspaceOperation(WorkspaceModifyOperation operation) throws Exception {
        getSite().getWorkbenchWindow().run(true, false, operation);
    }

    // ==================================================================================
    //  Adapters
    // ==================================================================================

    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == IPropertySheetPage.class) {
            if(propertySheetPage == null)
                propertySheetPage = new EditorPropertySheetPage(this, getPropertySourceProvider());
            return propertySheetPage;
        }

        if(type == IContentOutlinePage.class) {
            if(contentOutlinePage == null)
                contentOutlinePage = new EditorContentOutlinePage(this, getModel(), getContentProvider(), getLabelProvider());
            return contentOutlinePage;
        }
        
        if(type == ZoomManager.class)
            return getRootEditPart().getZoomManager();
        if(type == IProblemManager.class)
            return problemManager;

        return super.getAdapter(type);
    }

}
