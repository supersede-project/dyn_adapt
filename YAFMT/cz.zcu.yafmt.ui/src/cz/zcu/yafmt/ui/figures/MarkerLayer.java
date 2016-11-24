package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;


public class MarkerLayer extends Layer {
    
    private int margin;
    
    public MarkerLayer() {
        this(2);
    }
    
    public MarkerLayer(int margin) {
        this.margin = margin;
        setLayoutManager(new XYLayout());
    }
    
    public void refresh() {
        Point location = new Point(margin, margin);
        for(Object child: getChildren()) {
            IFigure figure = (IFigure) child;
            if(!figure.isVisible())
                continue;
            
            Dimension size = figure.getSize();
            setConstraint(figure, new Rectangle(location, size));
            location.x += size.width + margin;
        }
    }

}
