package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class AddAttributeCommand extends RecordingCommand {

    private SetFeatureSizeCommand resizeCommand;
    private LayoutData layoutData;
    private Feature feature;
    private IFigure featureFigure;
    private Attribute attribute;
    private int index;

    public AddAttributeCommand(LayoutData layoutData, Feature feature, IFigure featureFigure, Attribute attribute) {
        this(layoutData, feature, featureFigure, attribute, feature.getAttributes().size());
    }

    public AddAttributeCommand(LayoutData layoutData, Feature feature, IFigure featureFigure, Attribute attribute, int index) {
        setLabel("Add Attribute");
        this.layoutData = layoutData;
        this.feature = feature;
        this.featureFigure = featureFigure;
        this.attribute = attribute;
        this.index = index;
    }

    private SetFeatureSizeCommand createResizeCommand() {
        return new SetFeatureOptimalSizeCommand(layoutData, feature, featureFigure) {
            @Override
            protected Dimension computeFeaturePreferredSize() {
                Dimension prefSize = super.computeFeaturePreferredSize();
                Rectangle bounds = getFeatureOldBounds().getCopy();
                if(prefSize.width < bounds.width)
                    prefSize.width = bounds.width;
                if(prefSize.height < bounds.height)
                    prefSize.height = bounds.height;
                return prefSize;
            }
        };
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.getAttributes().add(index, attribute);
    }

    @Override
    public void execute() {
        resizeCommand = createResizeCommand();
        super.execute();
        resizeCommand.execute();
    }

    @Override
    public void redo() {
        super.redo();
        resizeCommand.redo();
    }

    @Override
    public void undo() {
        resizeCommand.undo();
        super.undo();
    }

}
