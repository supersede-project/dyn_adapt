package cz.zcu.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class GroupDecoration extends ImageDecoration {

    private Group group;
    private Label toolTip;
    
    public GroupDecoration(Group group) {
        super(FeatureModelVisualizerPlugin.getAccess().getImage("group-decoration.png"));
        this.group = group;
    }
    
    // ===============================================================
    //  Basic properties
    // ===============================================================
    
    public Group getGroup() {
        return group;
    }
    
    @Override
    public IFigure getToolTip() {
        if(toolTip == null)
            toolTip = new Label(createToolTipText());
        return toolTip;
    }
    
    private String createToolTipText() {
        return "Feature is part of a group (with cardinality " + FeatureModelUtil.getCardinality(group) + ").";
    }
    
    // ===============================================================
    //  Decoration properties
    // ===============================================================
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x - bounds.width + 2;
        int y = parentBounds.y + parentBounds.height - 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

}
