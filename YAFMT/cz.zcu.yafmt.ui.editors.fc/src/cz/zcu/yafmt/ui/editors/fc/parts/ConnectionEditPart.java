package cz.zcu.yafmt.ui.editors.fc.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import cz.zcu.yafmt.ui.editors.fc.figures.ConnectionFigure;
import cz.zcu.yafmt.ui.editors.fc.model.Connection;

public class ConnectionEditPart extends AbstractConnectionEditPart {

    Connection connection;

    public ConnectionEditPart(Connection connection) {
        this.connection = connection;
        setModel(connection);
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    protected IFigure createFigure() {
        return new ConnectionFigure();
    }

    @Override
    protected void refreshVisuals() {
        ConnectionFigure figure = (ConnectionFigure) getFigure();
        figure.setGrayed(connection.getTarget().getParent() == null);
    }
    
    // ===================================================================
    //  Policies
    // ===================================================================

    @Override
    protected void createEditPolicies() {
    }

}
