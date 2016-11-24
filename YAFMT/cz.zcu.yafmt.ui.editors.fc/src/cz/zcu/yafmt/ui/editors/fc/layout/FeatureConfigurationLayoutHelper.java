package cz.zcu.yafmt.ui.editors.fc.layout;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editparts.LayerManager;

import cz.zcu.yafmt.ui.editors.fc.parts.ConnectionEditPart;

public class FeatureConfigurationLayoutHelper implements TreeLayout.Helper {

    private GraphicalViewer viewer;

    public void setGraphicalViewer(GraphicalViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public IFigure getTreeParentFigure(IFigure figure) {
        Object part = viewer.getVisualPartMap().get(figure);
        if(!(part instanceof NodeEditPart))
            return null;

        for(Object connectionPart: ((NodeEditPart) part).getSourceConnections()) {
            if(connectionPart instanceof ConnectionEditPart) {
                Object targetPart = ((ConnectionEditPart) connectionPart).getTarget();
                if(targetPart instanceof GraphicalEditPart)
                    return ((GraphicalEditPart) targetPart).getFigure();
            }
        }
        return null;
    }

    @Override
    public List<IFigure> getTreeChildrenFigures(IFigure figure) {
        Object part = viewer.getVisualPartMap().get(figure);
        if(!(part instanceof NodeEditPart))
            return null;

        List<IFigure> figures = new ArrayList<IFigure>();
        for(Object connectionPart: ((NodeEditPart) part).getTargetConnections()) {
            if(connectionPart instanceof ConnectionEditPart) {
                Object sourcePart = ((ConnectionEditPart) connectionPart).getSource();
                if(sourcePart instanceof GraphicalEditPart)
                    figures.add(((GraphicalEditPart) sourcePart).getFigure());
            }
        }
        return figures;
    }

    @Override
    public List<Connection> getConnectionFigures() {
        LayerManager layerManager = (LayerManager) viewer.getEditPartRegistry().get(LayerManager.ID);
        LayeredPane printableLayers = (LayeredPane) layerManager.getLayer(LayerConstants.PRINTABLE_LAYERS);
        IFigure connectionLayer = printableLayers.getLayer(LayerConstants.CONNECTION_LAYER);

        List<?> children = connectionLayer.getChildren();
        List<Connection> connections = new ArrayList<Connection>(children.size());
        for(Object child: children) {
            if(child instanceof Connection)
                connections.add((Connection) child);
        }
        return connections;
    }

}
