package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.Random;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;


public class GenerateAttributeIdFromName extends RecordingCommand {
    
    private Attribute attribute;

    public GenerateAttributeIdFromName(Attribute attribute) {
        setLabel("Generate ID from Name");
        this.attribute = attribute;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        String id = FeatureModelUtil.generateIdFromName(attribute.getName());
        Feature feature = attribute.getFeature();

        if(feature != null) {
            for(Attribute other: feature.getAttributes()) {
                if((other != attribute) && other.getId().equals(id))
                    id = id + "_" + (new Random()).nextInt(Short.MAX_VALUE);
            }
        }

        attribute.setId(id);
    }
}
