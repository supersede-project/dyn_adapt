package cz.zcu.yafmt.ui.editors.fc.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationEditorPlugin;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.zcu.yafmt.ui.editors.fc.commands.DeselectFeatureCommand;

public class DeselectFeaturesAction extends FeatureSelectionAction {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fc.actions.DeselectFeaturesAction";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setActionDefinitionId(ID);
        action.setText("Deselect Features");
        action.setImageDescriptor(FeatureConfigurationEditorPlugin.getAccess().getImageDescriptor("deselect.png"));
        return action;
    }

    public DeselectFeaturesAction(GraphicalEditor editor, FeatureConfigurationManager featureConfigManager) {
        super(editor, featureConfigManager);
        initAction(this);

    }

    protected Command getCommand() {
        List<Selection> featuresToSelect = getSelectedFeatures();
        if(featuresToSelect == null)
            return null;
        return new DeselectFeatureCommand(getFeatureConfigManager(), featuresToSelect);
    }

}
