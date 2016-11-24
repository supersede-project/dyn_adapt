package cz.zcu.yafmt.ui.views.fm.graph;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;

import cz.zcu.yafmt.ui.views.fm.actions.ExportGraphViewerAsImageAction;
import cz.zcu.yafmt.ui.views.fm.decorations.IDecoration;
import cz.zcu.yafmt.ui.views.fm.figures.NodeFigure;

public class DecoratableGraphViewer extends GraphViewer {

    public static final int BACK_DECORATION_LAYER_INDEX = 0;
    public static final int ZEST_LAYER_INDEX = 1;
    public static final int FRONT_DECORATION_LAYER_INDEX = 2;

    private IAction exportAsImageAction = new ExportGraphViewerAsImageAction(this);
    private IDecorationSelecionProvider decorationSelectionProvider;
    
    private List<NodeFigure> highlightedFigures = new ArrayList<NodeFigure>();
    private List<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

    public DecoratableGraphViewer(Composite composite, int style) {
        super(composite, style);
        createDecorationLayers();
        createContextMenu();
        createListeners();
    }
    
    public void setDecorationSelectionProvider(IDecorationSelecionProvider decorationSelectionProvider) {
        this.decorationSelectionProvider = decorationSelectionProvider;
    }
    
    // =========================================================================
    //  Initialization
    // =========================================================================
    
    private void createDecorationLayers() {
        graph.getRootLayer().add(createDecorationLayer(), BACK_DECORATION_LAYER_INDEX);
        graph.getRootLayer().add(createDecorationLayer(), FRONT_DECORATION_LAYER_INDEX);
    }

    private IFigure createDecorationLayer() {
        FreeformLayer layer = new FreeformLayer();
        layer.setLayoutManager(new FreeformLayout());
        return layer;
    }

    private void createContextMenu() {
        MenuManager manager = new MenuManager();
        manager.setRemoveAllWhenShown(true);
        manager.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                manager.add(exportAsImageAction);
            }
        });
        graph.setMenu(manager.createContextMenu(graph));
    }
    
    private void createListeners() {
        graph.addMouseListener(new GraphMouseListener());
    }
    
    // =========================================================================
    //  Highlighting
    // =========================================================================

    private void clearHighlight() {
        // Hide old selection.
        for(NodeFigure figure: highlightedFigures)
            figure.setHighlighted(false);
        highlightedFigures.clear();
    }
    
    private void revealHightlight() {
        // Show new selection.
        for(Object node: graph.getSelection()) {
            if(node instanceof GraphNode) {
                IFigure figure = ((GraphNode) node).getNodeFigure();
                if(figure instanceof NodeFigure) {
                    ((NodeFigure) figure).setHighlighted(true);
                    highlightedFigures.add((NodeFigure) figure);
                }
            }
        }
    }
    
    public void refreshHightlight() {
        clearHighlight();
        revealHightlight();
    }

    // =========================================================================
    //  Events
    // =========================================================================
        
    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        super.addSelectionChangedListener(listener);
        selectionChangedListeners.add(listener);
    }
    
    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.remove(listener);
        super.removeSelectionChangedListener(listener);
    }
    
    @Override
    protected void fireDoubleClick(DoubleClickEvent event) {
        super.fireDoubleClick(event);
        refreshHightlight(); // Must be called after.
    }
        
    @Override
    protected void firePostSelectionChanged(SelectionChangedEvent event) {
        refreshHightlight(); // Must be called before.
        super.firePostSelectionChanged(event);
    }
    
    @Override
    protected void fireSelectionChanged(final SelectionChangedEvent event) {
        // The original one does not work at all.
        for(final ISelectionChangedListener listener: selectionChangedListeners) {
            SafeRunnable.run(new SafeRunnable() {
                public void run() {
                    listener.selectionChanged(event);
                }
            });
        }
    }
    
    private void decorationClicked(IDecoration decoration) {
        if(decorationSelectionProvider == null)
            return;
        
        // Retrieve selection.
        ISelection selection = decorationSelectionProvider.getSelectionForDecoration(decoration);
        if((selection == null) || selection.isEmpty())
            return;
        
        // Clear highlight and selection without generating events.
        clearHighlight();
        graph.setSelection(null);
        
        // Send selection changed event.
        SelectionChangedEvent event = new SelectionChangedEvent(this, selection);
        fireSelectionChanged(event);
        firePostSelectionChanged(event);
    }
        
    public void moveViewportToSelection(ISelection selection) {
        if(selection.isEmpty())
            return;

        // Zoom to the last selected object
        Object[] objects = ((IStructuredSelection) selection).toArray();
        for(int i = objects.length - 1; i >= 0; i--) {
            GraphItem item = findGraphItem(objects[i]);
            if(item instanceof GraphNode) {
                Point p = ((GraphNode) item).getLocation();
                Viewport vp = graph.getViewport();
                vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);
                return;
            }
        }
    }
        
    // =========================================================================
    //  Internal Listeners
    // =========================================================================
    
    private class GraphMouseListener extends MouseAdapter {
        
        @Override
        public void mouseDown(MouseEvent event) {
            Point viewLocation = graph.getViewport().getViewLocation();
            int x = viewLocation.x + event.x;
            int y = viewLocation.y + event.y;

            IFigure figure = graph.getFigureAt(x, y);            
            if(figure instanceof IDecoration)
                decorationClicked((IDecoration) figure);
        }
        
    }

}
