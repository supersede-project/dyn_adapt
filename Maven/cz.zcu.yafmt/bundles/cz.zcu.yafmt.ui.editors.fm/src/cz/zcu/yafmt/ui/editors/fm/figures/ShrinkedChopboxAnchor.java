package cz.zcu.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public class ShrinkedChopboxAnchor extends ChopboxAnchor {
    
    private int shrinkSize;
    
    public ShrinkedChopboxAnchor(IFigure owner, int shrinkSize) {
        super(owner);
        this.shrinkSize = shrinkSize;
    }

    @Override
    protected Rectangle getBox() {
        return super.getBox().getCopy().shrink(shrinkSize, shrinkSize);
    }
   
}
