package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetAttributeNameCommand extends RecordingCommand {

    private Attribute attribute;
    private String newName;

    public SetAttributeNameCommand(Attribute attribute, String newName) {
        setLabel("Rename Attribute " + attribute.getName() + " to " + newName);
        this.attribute = attribute;
        this.newName = newName;
    }
    
    @Override
    public boolean canExecute() {
        return newName != null; // Can be null when invalid value was entered during direct editing.
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        setLabel("Rename Attribute " + attribute.getName() + " to " + newName);
        attribute.setName(newName);
    }

}
