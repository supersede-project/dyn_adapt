package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetFeatureCardinalityCommand extends RecordingCommand {

    private Feature feature;
    private boolean mandatory;

    public SetFeatureCardinalityCommand(Feature feature, boolean mandatory) {
        setLabel("Make Feature " + (mandatory ? "Mandatory" : "Optional"));
        this.feature = feature;
        this.mandatory = mandatory;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.setMandatory(mandatory);
    }

}
