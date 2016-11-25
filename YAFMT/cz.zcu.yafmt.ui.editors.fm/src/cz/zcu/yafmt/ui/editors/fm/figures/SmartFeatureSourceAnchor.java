package cz.zcu.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

// Experimental stuff.
// Computes anchor position based on position of other sibling features.
public class SmartFeatureSourceAnchor extends ShrinkedChopboxAnchor {

    private Feature feature;
    private LayoutData layoutData;
    
    public SmartFeatureSourceAnchor(IFigure owner, Feature feature, LayoutData layoutData) {
        super(owner, 1);
        this.feature = feature;
        this.layoutData = layoutData;
    }

    @Override
    public Point getLocation(Point reference) {
        EObject parent = feature.getParent();
        Rectangle parentBounds = layoutData.get(parent);
        if(parentBounds == null)
            return super.getLocation(reference);
                
        Rectangle childrenArea = getOwner().getBounds().getCopy();
        for(EObject child: parent.eContents()) {
            Rectangle childBounds = layoutData.get(child);
            if(childBounds != null)
                childrenArea = childrenArea.union(childBounds);
        }
        
        Rectangle bounds = getOwner().getBounds();
        Point parentCenter = parentBounds.getCenter();
        Point childrenAreaCenter = childrenArea.getCenter();
        int dx = childrenAreaCenter.x - parentCenter.x;
        int dy = childrenAreaCenter.y - parentCenter.y;
        
        if(Math.abs(dx) > Math.abs(dy))
            return translateToAbsolute((dx > 0) ? bounds.getLeft() : bounds.getRight());
        else
            return translateToAbsolute((dy > 0) ? bounds.getTop() : bounds.getBottom());
    }
    
    private Point translateToAbsolute(Point point) {
        getOwner().translateToAbsolute(point);
        return point;
    }

}
