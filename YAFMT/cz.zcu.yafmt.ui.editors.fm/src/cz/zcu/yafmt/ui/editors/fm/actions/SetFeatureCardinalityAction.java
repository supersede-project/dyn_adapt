package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class SetFeatureCardinalityAction extends SelectionAction {

    public static final String ID_MANDATORY = "cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction.Mandatory";
    public static final String ID_OPTIONAL = "cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction.Optional";

    public static RetargetAction createRetargetAction(boolean mandatory) {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null), mandatory);
    }

    private static IAction initAction(IAction action, boolean mandatory) {
        if(mandatory) {
            action.setId(ID_MANDATORY);
            action.setActionDefinitionId(ID_MANDATORY);
            action.setText("Make Feature Mandatory");
            action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("feature-man.png"));
        }
        else {
            action.setId(ID_OPTIONAL);
            action.setActionDefinitionId(ID_OPTIONAL);
            action.setText("Make Feature Optional");
            action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("feature-opt.png"));
        }

        return action;
    }

    private boolean mandatory;

    public SetFeatureCardinalityAction(IWorkbenchPart part, boolean mandatory) {
        super(part);
        this.mandatory = mandatory;
        // Do not call this code in init method since it its called in superclass constructor.
        initAction(this, mandatory);
    }

    private Command getCommand() {
        List<?> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;

        String type = mandatory ? RequestConstants.REQ_MAKE_FEATURE_MAN : RequestConstants.REQ_MAKE_FEATURE_OPT;
        Request request = new Request(type);
        
        CompoundCommand command = new CompoundCommand();
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
