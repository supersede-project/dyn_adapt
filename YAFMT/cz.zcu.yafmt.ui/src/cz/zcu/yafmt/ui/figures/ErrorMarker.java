package cz.zcu.yafmt.ui.figures;

import java.util.Collection;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.ui.util.DrawUtil;

public class ErrorMarker extends MarkerFigure {

    public ErrorMarker() {
        this(null);
    }
    
    public ErrorMarker(Collection<String> messages) {
        setForegroundColor(DrawUtil.DARK_RED_COLOR);
        setBackgroundColor(ColorConstants.red);
        setErrors(messages);
    }

    public void setErrors(Collection<String> messages) {
        if((messages == null) || messages.isEmpty()) {
            setToolTipText(null);
            setVisible(false);
            return;
        }

        StringBuilder builder = null;
        for(String message: messages) {
            if(builder == null)
                builder = new StringBuilder(message);
            else
                builder.append("\n").append(message);
        }

        setToolTipText(builder.toString());
        setVisible(true);
    }
                
    @Override
    protected void paintContents(Graphics graphics) {
        graphics.setForegroundColor(ColorConstants.white);
        graphics.setLineWidth(1);
        Rectangle rect = createCrossBounds();
        graphics.drawLine(rect.getTopLeft(), rect.getBottomRight());
        graphics.drawLine(rect.getBottomLeft(), rect.getTopRight());
        graphics.setForegroundColor(getForegroundColor());
    }

    private Rectangle createCrossBounds() {
        Rectangle rect = new PrecisionRectangle(bounds);
        rect.x += 3.0;
        rect.y += 3.0;
        rect.width -= 7.0;
        rect.height -= 7.0;
        return rect;
    }

}
