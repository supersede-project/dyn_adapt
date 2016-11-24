package cz.zcu.yafmt.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import cz.zcu.yafmt.ui.CommonUIPlugin;


public class ShowPropertiesAction extends Action {

    public static final String ID = "cz.zcu.yafmt.ui.actions.ShowPropertiesAction";

    public ShowPropertiesAction() {
        setId(ID);
        setText("Properties");
        setImageDescriptor(CommonUIPlugin.getAccess().getImageDescriptor("properties.png"));
    }
    
    @Override
    public void run() {
        try {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            page.showView("org.eclipse.ui.views.PropertySheet");
        }
        catch(PartInitException ex) {
            CommonUIPlugin.getAccess().logError(ex);
        }
    }
    
}
