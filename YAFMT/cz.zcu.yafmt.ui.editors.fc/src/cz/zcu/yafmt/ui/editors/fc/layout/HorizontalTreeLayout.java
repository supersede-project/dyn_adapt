package cz.zcu.yafmt.ui.editors.fc.layout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.ui.figures.MiddleSideAnchor;

public class HorizontalTreeLayout extends TreeLayout {

    private static final int HORIZONTAL_SPACE = 60;
    private static final int VERTICAL_SPACE = 10;

    public HorizontalTreeLayout(Helper helper) {
        super(helper);
    }

    @Override
    public String getName() {
        return "Horizontal Tree";
    }

    @Override
    protected void doLayout(IFigure root) {
        Map<IFigure, Integer> subTreeHeight = new HashMap<IFigure, Integer>();
        calculateSubTreeHeight(subTreeHeight, root);
        layoutTree(subTreeHeight, root, VERTICAL_SPACE, VERTICAL_SPACE);
        setupConnectionAnchors();
    }

    private int calculateSubTreeHeight(Map<IFigure, Integer> subTreeHeight, IFigure figure) {
        List<IFigure> children = helper.getTreeChildrenFigures(figure);
        
        int treeHeight = 0;
        if(!children.isEmpty()) {
            for(IFigure child: children)
                treeHeight += calculateSubTreeHeight(subTreeHeight, child);
            treeHeight += VERTICAL_SPACE * (children.size() - 1);
        }
        subTreeHeight.put(figure, treeHeight);
        
        int nodeHeight = computeFigurePreferredSize(figure).height;
        return Math.max(treeHeight, nodeHeight);
    }

    private void layoutTree(Map<IFigure, Integer> subTreeHeight, IFigure figure, int xOffset, int yOffset) {
        Point nodePosition = new Point(xOffset, yOffset);
        Dimension nodeSize = computeFigurePreferredSize(figure);
        
        int treeHeight = subTreeHeight.get(figure);
        if(treeHeight > nodeSize.height)
            nodePosition.y += (treeHeight - nodeSize.height) / 2;
        else
            yOffset += (nodeSize.height - treeHeight) / 2;
        figure.setBounds(new Rectangle(nodePosition, nodeSize));
        
        xOffset += nodeSize.width + HORIZONTAL_SPACE;
        for(IFigure child: helper.getTreeChildrenFigures(figure)) {
            layoutTree(subTreeHeight, child, xOffset, yOffset);
            int childHeight = computeFigurePreferredSize(child).height;
            yOffset += Math.max(subTreeHeight.get(child), childHeight) + VERTICAL_SPACE;
        }
    }

    private void setupConnectionAnchors() {
        for(Connection connection: helper.getConnectionFigures()) {
            ((MiddleSideAnchor) connection.getSourceAnchor()).setStyle(SWT.LEFT);
            ((MiddleSideAnchor) connection.getTargetAnchor()).setStyle(SWT.RIGHT);
        }
    }

}
