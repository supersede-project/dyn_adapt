package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.List;
import java.util.Random;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class GenerateFeatureIdFromNameCommand extends RecordingCommand {

    private Feature feature;

    public GenerateFeatureIdFromNameCommand(Feature feature) {
        setLabel("Generate ID from Name");
        this.feature = feature;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        String id = FeatureModelUtil.generateIdFromName(feature.getName());
        FeatureModel featureModel = feature.getFeatureModel();

        if(featureModel != null) {
            List<Feature> features = featureModel.getFeaturesById(id);
            if((features.size() > 1) || ((features.size() == 1) && (features.get(0) != feature)))
                id = id + "_" + (new Random()).nextInt(Short.MAX_VALUE);
        }

        feature.setId(id);
    }

}
