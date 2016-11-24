package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetConstraintLanguageCommand extends RecordingCommand {

    private Constraint constraint;
    private String language;

    public SetConstraintLanguageCommand(Constraint constraint, String language) {
        setLabel("Change constraint language");
        this.constraint = constraint;
        this.language = language;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(constraint);
    }

    @Override
    protected void performRecording() {
        constraint.setLanguage(language);
    }

}
