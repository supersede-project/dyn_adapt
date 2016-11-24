package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class ResizeFeatureCommand extends SetFeatureSizeCommand {

    private Rectangle deltas;

    public ResizeFeatureCommand(LayoutData layoutData, Feature feature, Rectangle deltas) {
        super(layoutData, feature);
        setLabel("Resize Feature");
        this.deltas = deltas; // x, y, w, h attributes difference.
    }
    
    @Override
    protected Rectangle computeFeatureNewBounds() {
        Rectangle bounds = getFeatureOldBounds().getCopy();
        bounds.x += deltas.x;
        bounds.y += deltas.y;
        bounds.width += deltas.width;
        bounds.height += deltas.height;
        return bounds;
    }

}
