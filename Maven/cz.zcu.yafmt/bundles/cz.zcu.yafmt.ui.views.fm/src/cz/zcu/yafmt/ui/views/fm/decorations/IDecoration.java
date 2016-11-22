package cz.zcu.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.ui.views.fm.figures.IFigureWithAlpha;

public interface IDecoration extends IFigureWithAlpha {

    boolean isAutoPositioned();

    boolean isOnTop();

    Rectangle computeBounds(Rectangle parentBounds);

}
