package cz.zcu.yafmt.ui.editors.fm;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
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
import cz.zcu.yafmt.ui.actions.SnapToGeometryRetargetAction;
import cz.zcu.yafmt.ui.actions.SnapToGridRetargetAction;
import cz.zcu.yafmt.ui.editors.fm.actions.GenerateIdFromNameAction;
import cz.zcu.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.zcu.yafmt.ui.editors.fm.actions.ApplyLayoutAction;
import cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureOptimalSizeAction;
import cz.zcu.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;

public class FeatureModelEditorActionBarContributor extends ActionBarContributor {

    private RetargetAction applyDefinitionId(RetargetAction action, ActionFactory factory) {
        action.setActionDefinitionId(factory.getCommandId());
        return action;
    }
    
    @Override
    protected void buildActions() {
        addRetargetAction(applyDefinitionId(new UndoRetargetAction(), ActionFactory.UNDO));
        addRetargetAction(applyDefinitionId(new RedoRetargetAction(), ActionFactory.REDO));
        addRetargetAction(applyDefinitionId(new DeleteRetargetAction(), ActionFactory.DELETE));
        addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
        addRetargetAction(new ZoomInRetargetAction());
        addRetargetAction(new ZoomOutRetargetAction());
        addRetargetAction(new SnapToGridRetargetAction());
        addRetargetAction(new SnapToGeometryRetargetAction());
        addRetargetAction(SetFeatureOptimalSizeAction.createRetargetAction());
        addRetargetAction(ApplyLayoutAction.createRetargetAction());
        addRetargetAction(GenerateIdFromNameAction.createRetargetAction());
        addRetargetAction(SetFeatureCardinalityAction.createRetargetAction(false));
        addRetargetAction(SetFeatureCardinalityAction.createRetargetAction(true));
        addRetargetAction(GroupFeaturesAction.createRetargetAction(true));
        addRetargetAction(GroupFeaturesAction.createRetargetAction(false));
        addRetargetAction(UngroupFeaturesAction.createRetargetAction());
        addRetargetAction(ShowFeatureModelVisualizerAction.createRetargetAction());
    }

    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(new EditorZoomComboContributioItem(this));
        toolBarManager.add(getAction(GEFActionConstants.ZOOM_IN));
        toolBarManager.add(getAction(GEFActionConstants.ZOOM_OUT));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
        toolBarManager.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
        toolBarManager.add(getAction(SetFeatureOptimalSizeAction.ID));
        toolBarManager.add(getAction(ApplyLayoutAction.ID));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
        toolBarManager.add(getAction(SetFeatureCardinalityAction.ID_OPTIONAL));
        toolBarManager.add(getAction(SetFeatureCardinalityAction.ID_MANDATORY));
        toolBarManager.add(getAction(GenerateIdFromNameAction.ID));
        toolBarManager.add(getAction(GroupFeaturesAction.ID_XOR));
        toolBarManager.add(getAction(GroupFeaturesAction.ID_OR));
        toolBarManager.add(getAction(UngroupFeaturesAction.ID));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ShowFeatureModelVisualizerAction.ID));
    }

    @Override
    protected void declareGlobalActionKeys() {
    }

}
