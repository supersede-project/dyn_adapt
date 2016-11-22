package cz.zcu.yafmt.ui.views.fm.actions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.widgets.Control;
import org.eclipse.zest.core.viewers.GraphViewer;

import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.ui.actions.ExportAsImageAction;

public class ExportGraphViewerAsImageAction extends ExportAsImageAction {

    public static final String ID = "cz.zcu.yafmt.ui.views.fm.actions.ExportGraphViewerAsImageAction";

    private GraphViewer viewer;

    public ExportGraphViewerAsImageAction(GraphViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    protected Control getControl() {
        return viewer.getGraphControl();
    }

    @Override
    protected IFigure getFigure() {
        return viewer.getGraphControl().getRootLayer();
    }

    @Override
    protected String getDefaultName() {
        Object input = viewer.getInput();
        return (input instanceof FeatureModel) ? ((FeatureModel) input).getName().trim() : null;
    }

}
