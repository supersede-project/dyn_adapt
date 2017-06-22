package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetAttributeTypeCommand extends RecordingCommand {

    private Attribute attribute;
    private AttributeType type;

    public SetAttributeTypeCommand(Attribute attribute, AttributeType type) {
        setLabel("Set Attribute " + attribute.getName() + " type to " + type.getLiteral());
        this.attribute = attribute;
        this.type = type;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        attribute.setType(type);
    }

}
