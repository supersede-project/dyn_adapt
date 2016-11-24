package cz.zcu.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.LineAttributes;

import cz.zcu.yafmt.ui.figures.TooltipFigure;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class NodeFigure extends Label implements IFigureWithAlpha {

    private LineAttributes borderAttributes = new LineAttributes(1);
    private Color hightlightColor = ColorConstants.white;
    private boolean highlighted = false;
    private int margin = 2;
    private int arcRadius = 10;
    private int alpha = 255;

    public NodeFigure() {
        setFont(DrawUtil.DEFAULT_FONT);
    }
    
    // =====================================================================
    //  Attribute setters
    // =====================================================================
    
    public void setHightlightColor(Color color) {
        if(hightlightColor != color) {
            hightlightColor = color;
            repaint();
        }
    }
    
    public void setHighlighted(boolean highlighted) {
        if(this.highlighted != highlighted) {
            this.highlighted = highlighted;
            repaint();
        }
    }
    
    public void setMargin(int margin) {
        this.margin = margin;
    }
    
    public void setArcRadius(int arcRadius) {
        this.arcRadius = arcRadius;
    }
    
    @Override
    public void setAlpha(int alpha) {
        if(this.alpha != alpha) {
            this.alpha = alpha;
            repaint();
        }
    }
        
    public void setBorderWidth(int borderWidth) {
        borderAttributes.width = borderWidth;
    }
    
    public void setBorderStyle(int style) {
        borderAttributes.style = style;
    }
    
    public void setBorderDash(float[] dash) {
        borderAttributes.dash = dash;
    }

    public void setToolTipText(String text) {
        if((text != null) && !text.isEmpty())
            setToolTip(new TooltipFigure(text));
        else
            setToolTip(null);
    }
    
    @Override
    public void setText(String s) {
        super.setText(s);
        adjustBoundsToFit();
    }
    
    @Override
    public void setFont(Font f) {
        super.setFont(f);
        adjustBoundsToFit();
    }

    // =====================================================================
    //  Attribute getters
    // =====================================================================

    public Color getHightlightColor() {
        return hightlightColor;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public int getMargin() {
        return margin;
    }

    
    public int getArcRadius() {
        return arcRadius;
    }

    @Override
    public Integer getAlpha() {
        return alpha;
    }

    public int getBorderWidth() {
        return (int) borderAttributes.width;
    }

    public int getBorderStyle() {
        return borderAttributes.style;
    }

    public float[] getBorderDash() {
        return borderAttributes.dash;
    }

    // =====================================================================
    //  Size computation
    // =====================================================================
    
    protected void adjustBoundsToFit() {
        if((getText() == null) || (getFont() == null))
            return;

        Dimension minSize = FigureUtilities.getTextExtents(getText(), getFont());
        if(getIcon() != null) {
            org.eclipse.swt.graphics.Rectangle imageRect = getIcon().getBounds();
            int expandHeight = Math.max(imageRect.height - minSize.height, 0);
            minSize.expand(imageRect.width + 4, expandHeight);
        }
        minSize.expand(5 + 2 * margin, 2 + 2 * margin);
        setBounds(new Rectangle(getLocation(), minSize));
    }
    
    // =====================================================================
    //  Drawing
    // =====================================================================

    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);

        Color bgColor1 = highlighted ? hightlightColor : getBackgroundColor();
        Color bgColor2 = DrawUtil.getModifiedColor(bgColor1, highlighted ? 0.2f : -0.2f);

        Rectangle rect = new Rectangle(bounds.x, bounds.y, bounds.width - 1, arcRadius);
        graphics.setBackgroundColor(bgColor1);
        graphics.fillRoundRectangle(rect, arcRadius, arcRadius);

        rect.y += bounds.height - arcRadius - 1;
        graphics.setBackgroundColor(bgColor2);
        graphics.fillRoundRectangle(rect, arcRadius, arcRadius);

        rect.height = bounds.height - arcRadius - 1;
        rect.y = bounds.y + arcRadius / 2;
        graphics.setForegroundColor(bgColor1);
        graphics.fillGradient(rect, true);

        rect.y = bounds.y;
        rect.height = bounds.height - 1;
        graphics.setLineAttributes(borderAttributes);
        graphics.setForegroundColor(getForegroundColor());
        graphics.drawRoundRectangle(rect, arcRadius, arcRadius);

        bgColor2.dispose();

        super.paint(graphics);
    }

}
