package cz.zcu.yafmt.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.CommonUIPlugin;

public class ShowFeatureModelVisualizerAction extends Action {

    public static final String ID = "cz.zcu.yafmt.ui.actions.ShowFeatureModelVisualizerAction";
    private static final String VIEW_ID = "cz.zcu.yafmt.ui.views.fm.FeatureModelVisualizer";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setText("Show Feature Model Visualizer");
        action.setImageDescriptor(CommonUIPlugin.getAccess().getImageDescriptor("fm-visualizer.png"));
        return action;
    }

    public ShowFeatureModelVisualizerAction() {
        initAction(this);
        setEnabled(true);
    }

    @Override
    public void run() {
        try {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            page.showView(VIEW_ID);
        }
        catch(PartInitException ex) {
            CommonUIPlugin.getAccess().logError(ex);
        }
    }

}
