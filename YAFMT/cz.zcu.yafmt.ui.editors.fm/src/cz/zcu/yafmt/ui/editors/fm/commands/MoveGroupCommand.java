package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class MoveGroupCommand extends Command {

    private LayoutData layoutData;
    private Group group;
    private Rectangle oldBounds;
    private Rectangle newBounds;

    public MoveGroupCommand(LayoutData layoutData, Group group, Rectangle newBounds) {
        setLabel("Move Group");
        this.layoutData = layoutData;
        this.group = group;
        this.oldBounds = layoutData.get(group);
        this.newBounds = newBounds;
    }

    @Override
    public void execute() {
        computeNewBounds();
        redo();
    }

    @Override
    public void redo() {
        layoutData.set(group, newBounds);
    }

    @Override
    public void undo() {
        layoutData.set(group, oldBounds);
    }

    private void computeNewBounds() {
        Rectangle parentBounds = layoutData.get(group.getParent());
        int cx = newBounds.x + newBounds.width / 2;
        int cy = newBounds.y + newBounds.height / 2;
        newBounds = computeGroupBounds(parentBounds, cx, cy);
    }

    public static Rectangle computeGroupBounds(Rectangle parentBounds, int cx, int cy) {
        if((cx < parentBounds.x) || (cx > parentBounds.right()) || (cy < parentBounds.y) || (cy > parentBounds.bottom())) {
            if(cx < parentBounds.x)
                cx = parentBounds.x;
            else if(cx > parentBounds.right())
                cx = parentBounds.right();
            if(cy < parentBounds.y)
                cy = parentBounds.y;
            else if(cy > parentBounds.bottom())
                cy = parentBounds.bottom();
        }
        else {
            int dxLeft = cx - parentBounds.x;
            int dxRight = parentBounds.right() - cx;
            int dyTop = cy - parentBounds.y;
            int dyBottom = parentBounds.bottom() - cy;

            int dx = Math.min(dxLeft, dxRight);
            int dy = Math.min(dyTop, dyBottom);

            if(dx < dy)
                cx = (dxLeft < dxRight) ? parentBounds.x : parentBounds.right();
            else
                cy = (dyTop < dyBottom) ? parentBounds.y : parentBounds.bottom();
        }

        Rectangle bounds = new Rectangle();
        bounds.x = cx - GroupFigure.SIZE / 2;
        bounds.y = cy - GroupFigure.SIZE / 2;
        bounds.width = GroupFigure.SIZE;
        bounds.height = GroupFigure.SIZE;
        return bounds;
    }

}
