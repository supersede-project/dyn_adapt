package cz.zcu.yafmt.ui.editors.fc.layout;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;

public abstract class TreeLayout extends AbstractLayout {

    protected static Dimension computeFigurePreferredSize(IFigure figure) {
        Dimension preferredSize = figure.getPreferredSize().getCopy();
        Dimension minimumSize = figure.getMinimumSize();

        if(preferredSize.width < minimumSize.width)
            preferredSize.width = minimumSize.width;
        if(preferredSize.height < minimumSize.height)
            preferredSize.height = minimumSize.height;

        return preferredSize;
    }

    protected Helper helper;

    public TreeLayout(Helper helper) {
        this.helper = helper;
    }

    public abstract String getName();

    protected abstract void doLayout(IFigure treeRootFigure);

    @Override
    public void layout(IFigure container) {
        IFigure treeRootFigure = (IFigure) container.getChildren().get(0);
        if(treeRootFigure == null)
            return;

        IFigure treeParentFigure = helper.getTreeParentFigure(treeRootFigure);
        while(treeParentFigure != null) {
            treeRootFigure = treeParentFigure;
            treeParentFigure = helper.getTreeParentFigure(treeParentFigure);
        }

        doLayout(treeRootFigure);
    }

    @Override
    protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
        return null;
    }

    public static interface Helper {

        IFigure getTreeParentFigure(IFigure figure);

        List<IFigure> getTreeChildrenFigures(IFigure figure);

        List<Connection> getConnectionFigures();

    }

}
