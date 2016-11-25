package cz.zcu.yafmt.ui.actions;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.LabelRetargetAction;

import cz.zcu.yafmt.ui.CommonUIPlugin;


public class SnapToGeometryRetargetAction extends LabelRetargetAction {
    
    public SnapToGeometryRetargetAction() {
        super(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, null, IAction.AS_CHECK_BOX);
        setImageDescriptor(CommonUIPlugin.getAccess().getImageDescriptor("snap-to-geometry.png"));
        setToolTipText("Snap to Geometry");
    }
    
}
