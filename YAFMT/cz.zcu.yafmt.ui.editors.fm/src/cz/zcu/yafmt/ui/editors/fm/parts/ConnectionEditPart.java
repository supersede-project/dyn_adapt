package cz.zcu.yafmt.ui.editors.fm.parts;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__LOWER;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__UPPER;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.figures.ConnectionFigure;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;
import cz.zcu.yafmt.ui.editors.fm.policies.ConnectionEditPolicy;
import cz.zcu.yafmt.ui.editors.fm.policies.ConnectionSelectionPolicy;

public class ConnectionEditPart extends AbstractConnectionEditPart {

    private Connection connection;
    private Adapter connectionTargetAdapter;

    public ConnectionEditPart(Connection connection) {
        this.connection = connection;
        this.connectionTargetAdapter = new ConnectionTargetAdapter();
        setModel(connection);
    }

    // ===================================================================
    //  Initialization
    // ===================================================================

    @Override
    public void activate() {
        super.activate();
        connection.getTarget().eAdapters().add(connectionTargetAdapter);
    }

    @Override
    public void deactivate() {
        connection.getTarget().eAdapters().remove(connectionTargetAdapter);
        super.deactivate();
    }

    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    protected IFigure createFigure() {
        return new ConnectionFigure(connection);
    }

    public ConnectionFigure getFigure() {
        return (ConnectionFigure) super.getFigure();
    }

    @Override
    protected void refreshVisuals() {
        getFigure().refresh();
    }

    // ===================================================================
    //  Policies
    // ===================================================================

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ConnectionSelectionPolicy());
        installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy());
        installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
    }

    // ===================================================================
    //  Events
    // ===================================================================

    private class ConnectionTargetAdapter extends AdapterImpl {

        @Override
        public void notifyChanged(Notification notification) {
            switch(notification.getFeatureID(Feature.class)) {
                case FEATURE__LOWER:
                case FEATURE__UPPER:
                    refreshVisuals();
                    break;
            }
        }
    }

}
