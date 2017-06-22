package cz.zcu.yafmt.ui.actions;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.LabelRetargetAction;

import cz.zcu.yafmt.ui.CommonUIPlugin;


public class SnapToGridRetargetAction extends LabelRetargetAction {
    
    public SnapToGridRetargetAction() {
        super(GEFActionConstants.TOGGLE_GRID_VISIBILITY, null, IAction.AS_CHECK_BOX);
        setImageDescriptor(CommonUIPlugin.getAccess().getImageDescriptor("snap-to-grid.png"));
        setToolTipText("Snap to Grid");
    }
    
}
