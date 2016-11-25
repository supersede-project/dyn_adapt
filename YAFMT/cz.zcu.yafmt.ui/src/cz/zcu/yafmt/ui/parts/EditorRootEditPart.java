package cz.zcu.yafmt.ui.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.tools.MarqueeDragTracker;


public class EditorRootEditPart extends ScalableFreeformRootEditPart {

    @Override
    public DragTracker getDragTracker(Request req) {
        // Change selection behavior of the default drag tracker.
        MarqueeDragTracker dragTracker = new MarqueeDragTracker();
        dragTracker.setMarqueeBehavior(MarqueeDragTracker.BEHAVIOR_NODES_TOUCHED);
        return dragTracker;
    }
    
}
