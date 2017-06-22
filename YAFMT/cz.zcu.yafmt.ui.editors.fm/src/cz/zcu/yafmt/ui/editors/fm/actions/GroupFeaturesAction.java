package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class GroupFeaturesAction extends SelectionAction {

    public static final String ID_XOR = "cz.zcu.yafmt.ui.editors.fm.actions.GroupFeaturesAction.XOR";
    public static final String ID_OR = "cz.zcu.yafmt.ui.editors.fm.actions.GroupFeaturesAction.OR";

    public static RetargetAction createRetargetAction(boolean xorGroup) {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null), xorGroup);
    }

    private static IAction initAction(IAction action, boolean xorGroup) {
        if(xorGroup) {
            action.setId(ID_XOR);
            action.setActionDefinitionId(ID_XOR);
            action.setText("Make XOR Group");
            action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("group-xor.png"));
        }
        else {
            action.setId(ID_OR);
            action.setActionDefinitionId(ID_OR);
            action.setText("Make OR Group");
            action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("group-or.png"));
        }

        return action;
    }

    private boolean xorGroup;

    public GroupFeaturesAction(IWorkbenchPart part, boolean xorGroup) {
        super(part);
        this.xorGroup = xorGroup;
        // Do not call this code in init method since it its called in superclass constructor.
        initAction(this, xorGroup);
    }

    private Command getCommand() {
        List<?> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;

        CompoundCommand command = new CompoundCommand();

        // Get command to create new group from selected features.
        EditPart parentEditPart = ((EditPart) objects.get(0)).getParent();
        if(parentEditPart != null) {
            String type = xorGroup ? RequestConstants.REQ_GROUP_FEATURES_XOR : RequestConstants.REQ_GROUP_FEATURES_OR;
            GroupRequest request = new GroupRequest(type);
            request.setEditParts(objects);
            command.add(parentEditPart.getCommand(request));
        }

        // Get commands to change selected group cardinality.
        String type = xorGroup ? RequestConstants.REQ_MAKE_GROUP_XOR : RequestConstants.REQ_MAKE_GROUP_OR;
        Request request = new Request(type);
        for(Object object: objects)
            command.add(((EditPart) object).getCommand(request));

        return command;
    }

    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }

    @Override
    public void run() {
        execute(getCommand());
    }

}
