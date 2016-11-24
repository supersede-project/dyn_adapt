package cz.zcu.yafmt.ui.tools;

import org.eclipse.gef.tools.CreationTool;


public class CreationToolWithReactivation extends CreationTool {

    protected boolean isReactivationEnabled() {
        return getCurrentInput().isShiftKeyDown();
    }
        
    @Override
    protected void handleFinished() {
        if(isReactivationEnabled())
            reactivate();
        else
            super.handleFinished();
    }
    
}
