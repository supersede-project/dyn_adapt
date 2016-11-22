package cz.zcu.yafmt.ui.actions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.swt.widgets.Control;

public class ExportGraphicalEditorAsImageAction extends ExportAsImageAction {

    public static final String ID = "cz.zcu.yafmt.ui.actions.ExportGraphicalEditorAsImageAction";

    private GraphicalEditor editor;

    public ExportGraphicalEditorAsImageAction(GraphicalEditor editor) {
        this.editor = editor;
        setId(ID);
    }

    private GraphicalViewer getGraphicalViewer() {
        return (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
    }

    @Override
    protected Control getControl() {
        GraphicalViewer viewer = getGraphicalViewer();
        return (viewer != null) ? viewer.getControl() : null;
    }

    @Override
    protected IFigure getFigure() {
        GraphicalViewer viewer = getGraphicalViewer();
        if(viewer == null)
            return null;
        LayerManager layerManager = (LayerManager) viewer.getEditPartRegistry().get(LayerManager.ID);
        return layerManager.getLayer(LayerConstants.PRINTABLE_LAYERS);
    }

}
