package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class UngroupFeaturesAction extends SelectionAction {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fm.actions.UngroupFeaturesAction";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setActionDefinitionId(ID);
        action.setText("Ungroup Features");
        action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("group-del.png"));
        return action;
    }

    public UngroupFeaturesAction(IWorkbenchPart part) {
        super(part);
        initAction(this);
    }

    private Command getCommand() {
        List<?> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;

        EditPart parentEditPart = ((EditPart) objects.get(0)).getParent();
        if(parentEditPart == null)
            return null;

        GroupRequest request = new GroupRequest(RequestConstants.REQ_UNGROUP_FEATURES);
        request.setEditParts(objects);
        return parentEditPart.getCommand(request);
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
