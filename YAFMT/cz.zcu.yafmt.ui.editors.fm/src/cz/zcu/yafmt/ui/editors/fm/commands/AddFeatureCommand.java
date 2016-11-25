package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class AddFeatureCommand extends RecordingCommand {

    private LayoutData layoutData;
    private FeatureModel featureModel;
    private Feature feature;
    private Rectangle bounds;

    public AddFeatureCommand(LayoutData layoutData, FeatureModel featureModel, Feature feature, Point location) {
        setLabel("Add New Feature");
        this.layoutData = layoutData;
        this.featureModel = featureModel;
        this.feature = feature;

        bounds = new Rectangle();
        bounds.x = location.x - FeatureFigure.INITIAL_WIDTH / 2;
        bounds.y = location.y - FeatureFigure.INITIAL_HEGHT / 2;
        bounds.width = FeatureFigure.INITIAL_WIDTH;
        bounds.height = FeatureFigure.INITIAL_HEGHT;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(featureModel);
    }

    @Override
    protected void performRecording() {
        featureModel.getOrphans().add(feature);
    }

    @Override
    public void execute() {
        layoutData.set(feature, bounds);
        super.execute();

    }

    @Override
    public void redo() {
        layoutData.set(feature, bounds);
        super.redo();
    }

    @Override
    public void undo() {
        super.undo();
        layoutData.remove(feature);
    }

}
