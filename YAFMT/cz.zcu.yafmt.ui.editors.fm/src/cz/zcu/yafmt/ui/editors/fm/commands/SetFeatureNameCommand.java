package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetFeatureNameCommand extends RecordingCommand {

    private Feature feature;
    private String newName;

    public SetFeatureNameCommand(Feature feature, String newName) {
        setLabel("Rename Feature " + feature.getName() + " to " + newName);
        this.feature = feature;
        this.newName = newName;
    }
    
    @Override
    public boolean canExecute() {
        return newName != null; // Can be null when invalid value was entered during direct editing.
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.setName(newName);
    }

}
