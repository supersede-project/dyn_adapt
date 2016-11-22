package cz.zcu.yafmt.ui.editors.fc.commands;

import java.util.Arrays;
import java.util.List;

import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationManager;

public class SelectFeatureCommand extends RecordingCommand {

    private FeatureConfigurationManager featureConfigManager;
    private List<Selection> selections;

    public SelectFeatureCommand(FeatureConfigurationManager featureConfigManager, List<Selection> selections) {
        this.featureConfigManager = featureConfigManager;
        this.selections = selections;
        setLabel("Select Features");
    }

    public SelectFeatureCommand(FeatureConfigurationManager featureConfigManager, Selection selection) {
        this(featureConfigManager, Arrays.asList(new Selection[] { selection }));
    }

    @Override
    public boolean canExecute() {
        for(Selection selection: selections) {
            if(featureConfigManager.canSelectFeature(selection))
                return true;
        }
        return false;
    }

    @Override
    protected void initializeRecording() {
        for(Selection selection: selections)
            addRecordedObject(featureConfigManager.getParentSelection(selection));
    }

    @Override
    protected void performRecording() {
        selections = featureConfigManager.selectFeatures(selections);
    }

    @Override
    public void undo() {
        super.undo();
        featureConfigManager.featuresDeselected(selections); // We have to notify FC manager manually.
    }

    @Override
    public void redo() {
        super.redo();
        featureConfigManager.featuresSelected(selections); // We have to notify FC manager manually.
    }

}
