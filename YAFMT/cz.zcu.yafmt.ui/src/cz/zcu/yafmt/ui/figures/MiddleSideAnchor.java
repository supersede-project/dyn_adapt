package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class MiddleSideAnchor extends AbstractConnectionAnchor {

    private int style;

    public MiddleSideAnchor(IFigure owner) {
        this(owner, SWT.TOP);
    }
    
    public MiddleSideAnchor(IFigure owner, int style) {
        super(owner);
        setStyle(style);
    }

    public void setStyle(int style) {
        if((style != SWT.TOP) && (style != SWT.BOTTOM) && (style != SWT.LEFT) && (style != SWT.RIGHT))
            throw new IllegalArgumentException("Invalid argument, expected SWT.TOP, SWT.BOTTOM, SWT.LEFT or SWT.RIGHT");
        this.style = style;
    }

    @Override
    public Point getLocation(Point reference) {
        IFigure owner = getOwner();
        Rectangle bounds = owner.getBounds();
        Point point = null;

        switch(style) {
            case SWT.TOP:
                point = bounds.getTop();
                break;

            case SWT.BOTTOM:
                point = bounds.getBottom();
                break;

            case SWT.LEFT:
                point = bounds.getLeft();
                break;

            case SWT.RIGHT:
                point = bounds.getRight();
                break;
        }

        owner.translateToAbsolute(point);
        return point;
    }

}
