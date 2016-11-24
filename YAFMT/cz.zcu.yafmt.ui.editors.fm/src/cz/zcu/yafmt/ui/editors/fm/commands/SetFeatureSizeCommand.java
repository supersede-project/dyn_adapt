package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;


public abstract class SetFeatureSizeCommand extends Command {

    private LayoutData layoutData;
    private Feature feature;
    private Rectangle featureOldBounds;
    private Rectangle featureNewBounds;
    private Map<Group, Rectangle> groupOldBounds;
    private Map<Group, Rectangle> groupNewBounds;

    public SetFeatureSizeCommand(LayoutData layoutData, Feature feature) {
        this.layoutData = layoutData;
        this.feature = feature;
    }

    @Override
    public void execute() {
        // Must be computed here. Necessary when more resize commands are executed together.
        computeFeatureBounds();
        computeGroupBounds();
        redo();
    }

    @Override
    public void redo() {
        layoutData.set(feature, featureNewBounds);
        applyGroupBounds(groupNewBounds);
    }

    @Override
    public void undo() {
        layoutData.set(feature, featureOldBounds);
        applyGroupBounds(groupOldBounds);
    }

    private void computeFeatureBounds() {
        featureOldBounds = layoutData.get(feature);
        featureNewBounds = computeFeatureNewBounds();
    }
    
    protected Rectangle getFeatureOldBounds() {
        return featureOldBounds;
    }
    
    protected abstract Rectangle computeFeatureNewBounds();

    private void applyGroupBounds(Map<Group, Rectangle> groupBounds) {
        if(groupBounds == null)
            return;
        for(Map.Entry<Group, Rectangle> entry: groupBounds.entrySet())
            layoutData.set(entry.getKey(), entry.getValue());
    }

    private void computeGroupBounds() {
        if(feature.getGroups().isEmpty())
            return;

        groupOldBounds = new HashMap<Group, Rectangle>(feature.getGroups().size());
        groupNewBounds = new HashMap<Group, Rectangle>(feature.getGroups().size());

        for(Group group: feature.getGroups())
            groupOldBounds.put(group, layoutData.get(group));

        double dwRatio = featureNewBounds.width / ((double) featureOldBounds.width);
        double dhRatio = featureNewBounds.height / ((double) featureOldBounds.height);

        for(Group group: feature.getGroups()) {
            Rectangle groupBounds = layoutData.get(group).getCopy();

            // Change coordinates according to the ratio. 
            Point groupCenter = groupBounds.getCenter();
            groupCenter.x = featureNewBounds.x + (int) ((groupCenter.x - featureOldBounds.x) * dwRatio);
            groupCenter.y = featureNewBounds.y + (int) ((groupCenter.y - featureOldBounds.y) * dhRatio);

            // Fix rounding error.
            if(Math.abs(groupCenter.x - featureNewBounds.x) <= 1)
                groupCenter.x = featureNewBounds.x;
            else if(Math.abs(groupCenter.x - featureNewBounds.right()) <= 1)
                groupCenter.x = featureNewBounds.right();
            if(Math.abs(groupCenter.y - featureNewBounds.y) <= 1)
                groupCenter.y = featureNewBounds.y;
            else if(Math.abs(groupCenter.y - featureNewBounds.bottom()) <= 1)
                groupCenter.y = featureNewBounds.bottom();

            groupBounds.x = groupCenter.x - groupBounds.width / 2;
            groupBounds.y = groupCenter.y - groupBounds.height / 2;

            groupNewBounds.put(group, groupBounds);
        }
    }
    
}
