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

public class VerticalTreeLayout extends TreeLayout {

    private static final int HORIZONTAL_SPACE = 10;
    private static final int VERTICAL_SPACE = 60;

    public VerticalTreeLayout(Helper helper) {
        super(helper);
    }

    @Override
    public String getName() {
        return "Vertical Tree";
    }

    @Override
    protected void doLayout(IFigure root) {
        Map<IFigure, Integer> subTreeWidth = new HashMap<IFigure, Integer>();
        calculateSubTreeWidth(subTreeWidth, root);
        layoutTree(subTreeWidth, root, HORIZONTAL_SPACE, HORIZONTAL_SPACE);
        setupConnectionAnchors();
    }

    private int calculateSubTreeWidth(Map<IFigure, Integer> subTreeWidth, IFigure figure) {
        List<IFigure> children = helper.getTreeChildrenFigures(figure);
        
        int treeWidth = 0;
        if(!children.isEmpty()) {
            for(IFigure child: children)
                treeWidth += calculateSubTreeWidth(subTreeWidth, child);
            treeWidth += HORIZONTAL_SPACE * (children.size() - 1);
        }
        subTreeWidth.put(figure, treeWidth);
        
        int nodeWidth = computeFigurePreferredSize(figure).width;
        return Math.max(treeWidth, nodeWidth);
    }

    private void layoutTree(Map<IFigure, Integer> subTreeWidth, IFigure figure, int xOffset, int yOffset) {
        Point nodePosition = new Point(xOffset, yOffset);
        Dimension nodeSize = computeFigurePreferredSize(figure);
        
        int treeWidth = subTreeWidth.get(figure);
        if(treeWidth > nodeSize.width)
            nodePosition.x += (treeWidth - nodeSize.width) / 2;
        else
            xOffset += (nodeSize.width - treeWidth) / 2;
        figure.setBounds(new Rectangle(nodePosition, nodeSize));

        yOffset += nodeSize.height + VERTICAL_SPACE;
        for(IFigure child: helper.getTreeChildrenFigures(figure)) {
            layoutTree(subTreeWidth, child, xOffset, yOffset);
            int childWidth = computeFigurePreferredSize(child).width;
            xOffset += Math.max(subTreeWidth.get(child), childWidth) + HORIZONTAL_SPACE;
        }
    }

    private void setupConnectionAnchors() {
        for(Connection connection: helper.getConnectionFigures()) {
            ((MiddleSideAnchor) connection.getSourceAnchor()).setStyle(SWT.TOP);
            ((MiddleSideAnchor) connection.getTargetAnchor()).setStyle(SWT.BOTTOM);
        }
    }

}
