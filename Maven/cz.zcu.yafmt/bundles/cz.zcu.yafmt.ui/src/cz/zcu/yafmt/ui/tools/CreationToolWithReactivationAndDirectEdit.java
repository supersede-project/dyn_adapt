package cz.zcu.yafmt.ui.tools;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.swt.widgets.Display;

public class CreationToolWithReactivationAndDirectEdit extends CreationToolWithReactivation {

    @Override
    protected void performCreation(int button) {
        super.performCreation(button);

        EditPartViewer viewer = getCurrentViewer();
        if(viewer == null)
            return;

        Object object = getCreateRequest().getNewObject();
        final EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(object);
        if(editPart == null)
            return;

        Display.getCurrent().asyncExec(new Runnable() {
            @Override
            public void run() {
                editPart.performRequest(new Request(REQ_OPEN));
            }
        });
    }

}
