package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;

import cz.zcu.yafmt.ui.util.DrawUtil;


public class MarkerFigure extends RoundedRectangle {

    private static final Dimension CORNER_DIMENSION = new Dimension(4, 4);
    public static final int SIZE = 12; 
       
    private TooltipFigure toolTip;
    
    public MarkerFigure() {
        setSize(SIZE, SIZE);
        setCornerDimensions(CORNER_DIMENSION);
    }
    
    public void setToolTipText(String text) {
        if((text != null) && !text.isEmpty()) {
            if(toolTip == null)
                toolTip = new TooltipFigure();
            toolTip.setText(text);
            setToolTip(toolTip);
        }
        else {
            setToolTip(null);
        }
    }
    
    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixScaledFigureLocation(graphics);
        super.paint(graphics);
    }
    
    @Override
    public void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        paintContents(graphics);
    }
    
    protected void paintContents(Graphics graphics) {
    }
        
}
