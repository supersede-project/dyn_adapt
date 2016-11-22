package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.draw2d.Animation;
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


public class SetFeatureOptimalSizeAction extends SelectionAction {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureOptimalSizeAction";
    
    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }
    
    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setText("Set Optimal Size");
        action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("set-optimal-size.png"));
        return action;
    }
    
    public SetFeatureOptimalSizeAction(IWorkbenchPart part) {
        super(part);
        initAction(this);
    }

    private Command getCommand() {
        List<?> editParts = getSelectedObjects();
        if(editParts.isEmpty() || !(editParts.get(0) instanceof EditPart))
            return null;
        
        Request request = new Request(RequestConstants.REQ_SET_FEATURE_OPTIMAL_SIZE);
        CompoundCommand command = new CompoundCommand();
        for(Object editPart: editParts)
            command.add(((EditPart) editPart).getCommand(request));
        return command;
    }
    
    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }
    
    @Override
    public void run() {
        Animation.markBegin();
        execute(getCommand());
        Animation.run();
    }

}
