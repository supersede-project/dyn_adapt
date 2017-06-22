package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;

import cz.zcu.yafmt.ui.util.DrawUtil;


public class ConstraintMarker extends MarkerFigure {
    
    private static final String LABEL = "{ }";
    
    public ConstraintMarker() {
        setBackgroundColor(DrawUtil.CONSTRAINT_COLOR);
        setForegroundColor(DrawUtil.CONSTRAINT_DARKER_COLOR);
        setToolTipText("This feature is affected by a constraint.");
        setVisible(false);
    }
    
    @Override
    protected void paintContents(Graphics graphics) {
        Dimension size = TextUtilities.INSTANCE.getStringExtents(LABEL, DrawUtil.TINY_FONT);
        
        double x = bounds.x + 0.5 * (bounds.width - size.width) - 0.5;
        double y = bounds.y + 0.5 * (bounds.height - size.height) - 0.25;
        
        graphics.setForegroundColor(ColorConstants.white);
        graphics.setFont(DrawUtil.TINY_FONT);
        graphics.drawText(LABEL, new PrecisionPoint(x, y));
    }
    
}
