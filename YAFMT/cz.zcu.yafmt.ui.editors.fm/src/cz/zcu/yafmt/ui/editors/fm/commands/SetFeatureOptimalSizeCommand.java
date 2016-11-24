package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class SetFeatureOptimalSizeCommand extends SetFeatureSizeCommand {

    private IFigure figure;
        
    public SetFeatureOptimalSizeCommand(LayoutData layoutData, Feature feature, IFigure figure) {
        super(layoutData, feature);
        setLabel("Set Feature Optimal Size");
        this.figure = figure;
    }

    @Override
    protected Rectangle computeFeatureNewBounds() {
        Rectangle bounds = new Rectangle(figure.getBounds().getLocation(), computeFeaturePreferredSize());
        Dimension minSize = figure.getMinimumSize();
        
        if(bounds.width < minSize.width)
            bounds.width = minSize.width;
        if(bounds.height < minSize.height)
            bounds.height = minSize.height;
        
        return bounds;
    }
    
    protected Dimension computeFeaturePreferredSize() {
        return figure.getPreferredSize();
    }
        
}
