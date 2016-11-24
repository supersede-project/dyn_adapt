package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class UngroupFeaturesCommand extends RecordingCommand {

    private List<Feature> features;

    public UngroupFeaturesCommand(List<Feature> features) {
        setLabel("Ungroup Features");
        this.features = features;
    }

    @Override
    protected void initializeRecording() {
        for(Feature feature: features)
            addRecordedObjectParent(feature);
    }

    @Override
    protected void performRecording() {
        Set<Group> previousParents = new HashSet<Group>();

        for(Feature feature: features) {
            Group group = feature.getParentGroup();
            if(group != null) {
                feature.setParent(group.getParent());
                previousParents.add(group);
            }
        }

        // Do not iterate on the original group list (ConcurrentModificationException).
        for(Group group: previousParents)
            FeatureModelUtil.removeUnneededGroup(group);
    }

}
