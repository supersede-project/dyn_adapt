package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;

import cz.zcu.yafmt.ui.util.DrawUtil;

public class SeparatorFigure extends Figure {

    public SeparatorFigure() {
        setPreferredSize(1, 1);
        setForegroundColor(ColorConstants.black);
    }

    @Override
    public void paintFigure(Graphics graphics) {
        graphics.setLineWidth(DrawUtil.getScaledLineWidth(1, graphics));
        graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
    }
    
}
