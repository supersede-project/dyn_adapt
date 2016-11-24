package cz.zcu.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.ui.util.DrawUtil;

public class CardinalityDecoration extends Label implements IDecoration {

    private static final int ARC_SIZE = 6;
    private static final Label MANDATORY_TOOL_TIP = new Label("Feature is mandatory.");
    private static final Label MANDATORY_CLONNABLE_TOOL_TIP = new Label("Feature is mandatory and clonnable.");
    private static final Label OPTIONAL_TOOL_TIP = new Label("Feature is optional.");
    private static final Label OPTIONAL_CLONNABLE_TOOL_TIP = new Label("Feature is optional and clonnable.");

    private int alpha = 255;

    public CardinalityDecoration(int lower, int upper) {
        setForegroundColor(ColorConstants.darkGray);
        setFont(DrawUtil.SMALL_FONT);
        setText(lower + ".." + ((upper == -1) ? "*" : upper));
        setSize(FigureUtilities.getStringExtents(getText(), getFont()).expand(4, 4));
        setBorder(new MarginBorder(2));
        setToolTip(getToolTip(lower, upper));
    }
    
    // ===============================================================
    //  Basic properties
    // ===============================================================
    
    private Label getToolTip(int lower, int upper) {
        if((upper > 1) || (upper == -1))
            return (lower == 0) ? OPTIONAL_CLONNABLE_TOOL_TIP : MANDATORY_CLONNABLE_TOOL_TIP;
        else
            return (lower == 0) ? OPTIONAL_TOOL_TIP : MANDATORY_TOOL_TIP;
    }

    @Override
    public void setAlpha(int alpha) {
        if(this.alpha != alpha) {
            this.alpha = alpha;
            repaint();
        }
    }
    
    @Override
    public Integer getAlpha() {
        return alpha;
    }
    
    // ===============================================================
    //  Decoration properties
    // ===============================================================

    @Override
    public boolean isAutoPositioned() {
        return false;
    }

    @Override
    public boolean isOnTop() {
        return true;
    }

    // ===============================================================
    //  Drawing
    // ===============================================================
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x + parentBounds.width - 2;
        int y = parentBounds.y - bounds.height + 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);
        graphics.setForegroundColor(ColorConstants.lightGray);
        graphics.setBackgroundColor(ColorConstants.white);
        graphics.fillRoundRectangle(bounds, ARC_SIZE, ARC_SIZE);
        graphics.drawRoundRectangle(bounds.getCopy().resize(-1, -1), ARC_SIZE, ARC_SIZE);
        super.paint(graphics);
    }

}
