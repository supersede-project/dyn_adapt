package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetConstraintValueCommand extends RecordingCommand {

    private Constraint constraint;
    private String newValue;

    public SetConstraintValueCommand(Constraint constraint, String newValue) {
        setLabel("Change constraint value");
        this.constraint = constraint;
        this.newValue = newValue;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(constraint);
    }

    @Override
    protected void performRecording() {
        constraint.setValue(newValue);
    }

}
