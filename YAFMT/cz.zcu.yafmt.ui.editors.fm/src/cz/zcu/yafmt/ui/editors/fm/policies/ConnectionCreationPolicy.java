package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.commands.AddConnectionCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.ReconnectSourceCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.ReconnectTargetCommand;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;

public class ConnectionCreationPolicy extends GraphicalNodeEditPolicy {

    @Override
    protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
        EObject source = (EObject) getHost().getModel();
        if(!(source instanceof Feature) && !(source instanceof Group))
            return null;

        request.setStartCommand(new AddConnectionCommand(source));
        return request.getStartCommand();
    }

    @Override
    protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
        EObject target = (EObject) getHost().getModel();
        if(!(target instanceof Feature))
            return null;

        Feature feature = (Feature) target;
        if(feature.isRoot())
            return null;

        AddConnectionCommand command = (AddConnectionCommand) request.getStartCommand();
        if(EcoreUtil.isAncestor(target, command.getSource()))
            return null;

        command.setTarget(feature);
        return command;
    }

    @Override
    protected Command getReconnectSourceCommand(ReconnectRequest request) {
        EObject newTarget = (EObject) request.getTarget().getModel();
        if(!(newTarget instanceof Feature))
            return null;

        Connection connection = (Connection) request.getConnectionEditPart().getModel();
        if((newTarget == connection.getTarget()) || (newTarget.eContainer() == connection.getSource()))
            return null;

        if(EcoreUtil.isAncestor(newTarget, connection.getSource()))
            return null;

        return new ReconnectSourceCommand(connection, (Feature) newTarget);
    }

    @Override
    protected Command getReconnectTargetCommand(ReconnectRequest request) {
        EObject newSource = (EObject) request.getTarget().getModel();
        if(!(newSource instanceof Feature) && !(newSource instanceof Group))
            return null;

        Connection connection = (Connection) request.getConnectionEditPart().getModel();
        if(newSource == connection.getSource())
            return null;

        if(EcoreUtil.isAncestor(connection.getTarget(), newSource))
            return null;

        return new ReconnectTargetCommand(connection, newSource);
    }

}
