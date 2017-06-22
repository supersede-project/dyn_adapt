package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;

import cz.zcu.yafmt.ui.editors.fm.commands.DeleteConnectionCommand;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;

public class ConnectionEditPolicy extends org.eclipse.gef.editpolicies.ConnectionEditPolicy {

    @Override
    protected Command getDeleteCommand(GroupRequest request) {
        Connection connection = (Connection) getHost().getModel();
        return new DeleteConnectionCommand(connection);
    }

}
