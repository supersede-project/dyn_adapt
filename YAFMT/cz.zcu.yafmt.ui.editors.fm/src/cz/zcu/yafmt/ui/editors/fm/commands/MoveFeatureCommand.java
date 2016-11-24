package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class MoveFeatureCommand extends Command {

    private LayoutData layoutData;
    private Feature feature;
    private Rectangle oldBounds;
    private Rectangle newBounds;

    public MoveFeatureCommand(LayoutData layoutData, Feature feature, Rectangle newBounds) {
        setLabel("Move Feature");
        this.layoutData = layoutData;
        this.feature = feature;
        this.oldBounds = layoutData.get(feature);
        this.newBounds = newBounds;
    }

    @Override
    public void execute() {
        redo();
    }

    @Override
    public void redo() {
        layoutData.set(feature, newBounds);
        moveGroups(oldBounds, newBounds);
    }

    @Override
    public void undo() {
        layoutData.set(feature, oldBounds);
        moveGroups(newBounds, oldBounds);
    }

    private void moveGroups(Rectangle from, Rectangle to) {
        int dx = to.x - from.x;
        int dy = to.y - from.y;

        for(Group group: feature.getGroups()) {
            Rectangle bounds = layoutData.get(group).getCopy();
            bounds.x += dx;
            bounds.y += dy;
            layoutData.set(group, bounds);
        }
    }

}
