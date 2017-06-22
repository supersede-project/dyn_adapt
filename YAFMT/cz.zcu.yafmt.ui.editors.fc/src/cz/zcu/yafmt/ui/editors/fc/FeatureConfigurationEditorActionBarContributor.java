package cz.zcu.yafmt.ui.editors.fc;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.actions.EditorZoomComboContributioItem;
import cz.zcu.yafmt.ui.actions.ShowFeatureModelVisualizerAction;
import cz.zcu.yafmt.ui.editors.fc.actions.DeselectFeaturesAction;
import cz.zcu.yafmt.ui.editors.fc.actions.SelectFeaturesAction;

public class FeatureConfigurationEditorActionBarContributor extends ActionBarContributor {

    private RetargetAction applyDefinitionId(RetargetAction action, ActionFactory factory) {
        action.setActionDefinitionId(factory.getCommandId());
        return action;
    }
    
    @Override
    protected void buildActions() {
        addRetargetAction(applyDefinitionId(new UndoRetargetAction(), ActionFactory.UNDO));
        addRetargetAction(applyDefinitionId(new RedoRetargetAction(), ActionFactory.REDO));
        addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
        addRetargetAction(new ZoomInRetargetAction());
        addRetargetAction(new ZoomOutRetargetAction());
        addRetargetAction(SelectFeaturesAction.createRetargetAction());
        addRetargetAction(DeselectFeaturesAction.createRetargetAction());
        addRetargetAction(ShowFeatureModelVisualizerAction.createRetargetAction());
    }

    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(new EditorZoomComboContributioItem(this));
        toolBarManager.add(getAction(GEFActionConstants.ZOOM_IN));
        toolBarManager.add(getAction(GEFActionConstants.ZOOM_OUT));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(SelectFeaturesAction.ID));
        toolBarManager.add(getAction(DeselectFeaturesAction.ID));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ShowFeatureModelVisualizerAction.ID));
    }

    @Override
    protected void declareGlobalActionKeys() {
    }

}
