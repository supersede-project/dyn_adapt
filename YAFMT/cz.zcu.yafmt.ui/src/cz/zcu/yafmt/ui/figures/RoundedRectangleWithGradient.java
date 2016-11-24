package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class RoundedRectangleWithGradient extends RoundedRectangle {
    
    private Color topBackgroundColor = ColorConstants.white;
    private Color bottomBackgroundColor = ColorConstants.white;

    public void setTopBackgroundColor(Color topBackgroundColor) {
        if(this.topBackgroundColor != topBackgroundColor) {
            this.topBackgroundColor = topBackgroundColor;
            repaint();
        }
    }
    
    public void setBottomBackgroundColor(Color bottomBackgroundColor) {
        if(this.bottomBackgroundColor != bottomBackgroundColor) {
            this.bottomBackgroundColor = bottomBackgroundColor;
            repaint();
        }
    }
    
    public Color getTopBackgroundColor() {
        return topBackgroundColor;
    }
    
    public Color getBottomBackgroundColor() {
        return bottomBackgroundColor;
    }
        
    @Override
    protected void fillShape(Graphics graphics) {
        Color foregroundColor = getForegroundColor();
        Dimension corner = getCornerDimensions();
        
        Rectangle rect = new Rectangle(bounds.x, bounds.y, bounds.width, corner.height);
        graphics.setBackgroundColor(topBackgroundColor);
        graphics.fillRoundRectangle(rect, corner.width, corner.height);

        rect.y += bounds.height - corner.height;
        graphics.setBackgroundColor(bottomBackgroundColor);
        graphics.fillRoundRectangle(rect, corner.width, corner.height);

        rect.height = bounds.height - corner.height;
        rect.y = bounds.y + corner.height / 2;
        graphics.setForegroundColor(topBackgroundColor);
        graphics.fillGradient(rect, true);
        
        graphics.setForegroundColor(foregroundColor);
    }

}
