package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class DeleteFeatureCommand extends RecordingCommand {

    private LayoutData layoutData;
    private Feature feature;
    private Rectangle bounds;

    public DeleteFeatureCommand(Feature feature, LayoutData layoutData) {
        setLabel("Delete Feature " + feature.getName());
        this.layoutData = layoutData;
        this.feature = feature;
        this.bounds = layoutData.get(feature);
    }

    protected void initializeRecording() {
        addRecordedObject(feature.getFeatureModel());
        addRecordedObject(feature);
        addRecordedObjectParent(feature);
    }

    @Override
    protected void performRecording() {
        FeatureModel featureModel = feature.getFeatureModel();
        List<Feature> orphans = featureModel.getOrphans();

        orphans.addAll(feature.getFeatures());
        for(Group group: feature.getGroups())
            orphans.addAll(group.getFeatures());
        feature.getGroups().clear();

        EObject parent = feature.getParent();
        feature.setParent(null);
        FeatureModelUtil.removeUnneededGroup(parent);
    }

    @Override
    public void execute() {
        super.execute();
        layoutData.remove(feature);
    }

    @Override
    public void redo() {
        super.redo();
        layoutData.remove(feature);
    }

    @Override
    public void undo() {
        layoutData.set(feature, bounds);
        super.undo();
    }

}
