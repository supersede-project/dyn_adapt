package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class MiddlePointAnchor extends AbstractConnectionAnchor {

    public MiddlePointAnchor(IFigure figure) {
        super(figure);
    }

    @Override
    public Point getLocation(Point reference) {
        IFigure owner = getOwner();
        PrecisionPoint center = new PrecisionPoint(owner.getBounds().getCenter());
        center.translate(0.5, 0.5); // Figure is also moved like this during painting.
        // Important!!!
        // It computes the right position when viewport is scrolling.
        owner.translateToAbsolute(center);
        return center;
    }

}
