package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.commands.DeleteGroupCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.SetGroupCardinalityCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.parts.GroupEditPart;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class GroupEditPolicy extends ComponentEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_MAKE_GROUP_XOR.equals(type))
            return createSetGroupCardinalityCommand(true);
        if(RequestConstants.REQ_MAKE_GROUP_OR.equals(type))
            return createSetGroupCardinalityCommand(false);
        return super.getCommand(request);
    }

    private Command createSetGroupCardinalityCommand(boolean xorGroup) {
        Group group = (Group) getHost().getModel();
        if((group.isXor() || group.isOr()) && (group.isXor() == xorGroup))
            return null;
        return new SetGroupCardinalityCommand(group, xorGroup);
    }

    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        LayoutData layoutData = ((GroupEditPart) getHost()).getLayoutData();
        Group group = (Group) getHost().getModel();
        return new DeleteGroupCommand(group, layoutData);
    }

}
