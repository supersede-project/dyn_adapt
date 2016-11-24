package cz.zcu.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.IFigure;

public interface IFigureWithAlpha extends IFigure {

    void setAlpha(int alpha);

    Integer getAlpha(); // Returns object because of Compatibility with Shape class.

}
