package cz.zcu.yafmt.ui.views.fm.decorations;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class NeighborsDecoration extends RoundedRectangle implements IDecoration {

    private static final int BORDER_SCALE = 5;
    private static final int GRADIENT_DETAIL = 5;

    private List<Feature> neighbors;
    private Label toolTip;

    public NeighborsDecoration(List<Feature> neighbors) {
        this.neighbors = neighbors;

        setCornerDimensions(new Dimension(15, 15));
        setForegroundColor(DrawUtil.FEATURE_COLOR);
        setBackgroundColor(DrawUtil.FEATURE_LIGHTER_COLOR);
        setLineStyle(SWT.LINE_CUSTOM);
        setLineDash(DrawUtil.LINE_DOTTED);
    }
    
    // ===============================================================
    //  Basic properties
    // ===============================================================
    
    public List<Feature> getNeighbors() {
        return neighbors;
    }
    
    @Override
    public IFigure getToolTip() {
        if(toolTip == null)
            toolTip = new Label(createToolTipText());
        return toolTip;
    }
    
    private String createToolTipText() {
        StringBuilder builder = new StringBuilder();
        
        if(neighbors.size() == 1) {
            builder.append("Feature has a hidden neighbor (");
            builder.append(neighbors.get(0).getName()).append(").");
        }
        else {
            builder.append("Feature has " + neighbors.size() + " hidden neighbors:");
            for(Feature neighbor: neighbors)
                builder.append("\n    - ").append(neighbor.getName());
        }
                
        return builder.toString();
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
        return false;
    }
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int border = computeBorder();
        return parentBounds.getCopy().expand(border, border);
    }
    
    // ===============================================================
    //  Drawing
    // ===============================================================
    
    @Override
    protected void fillShape(Graphics graphics) {
        graphics.setAlpha(computeAlpha() / (2 * GRADIENT_DETAIL));
        
        int shinkStep = computeBorder() / GRADIENT_DETAIL;
        Rectangle rect = bounds.getCopy();
        Dimension corner = getCornerDimensions();
        
        for(int i = 0; i < GRADIENT_DETAIL; i++) {
            graphics.fillRoundRectangle(rect, corner.width, corner.width);
            rect.shrink(shinkStep, shinkStep);
        }
    }
    
    @Override
    protected void outlineShape(Graphics graphics) {
        graphics.setAlpha(computeAlpha() / 4);
        super.outlineShape(graphics);
    }
    
    private int computeAlpha() {
        Integer alpha = getAlpha();
        return (alpha != null) ? alpha : 255;  
    }
    
    private int computeBorder() {
        return neighbors.size() * BORDER_SCALE;
    }

}
