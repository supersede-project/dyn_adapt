package cz.zcu.yafmt.ui.views.fm.util;

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.viewers.IFigureProvider;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

public class LabelProviderAdapter implements IFigureProvider,
                                             ILabelProvider,
                                             IEntityStyleProvider,
                                             IEntityConnectionStyleProvider,
                                             ISelfStyleProvider {

    @Override
    public void dispose() {
    }

    @Override
    public void selfStyleNode(Object element, GraphNode node) {
    }

    @Override
    public void selfStyleConnection(Object element, GraphConnection connection) {
    }

    @Override
    public Image getImage(Object element) {
        return null;
    }

    @Override
    public String getText(Object element) {
        if(element instanceof EntityConnectionData)
            return null;
        // For some strange reason an unique value must be
        // returned, otherwise layout algorithm does not work!
        return "_" + (element.hashCode());
    }

    @Override
    public IFigure getFigure(Object element) {
        return null;
    }

    @Override
    public IFigure getTooltip(Object entity) {
        return null;
    }

    @Override
    public Color getBackgroundColour(Object entity) {
        return null;
    }

    @Override
    public Color getForegroundColour(Object entity) {
        return null;
    }

    @Override
    public Color getNodeHighlightColor(Object entity) {
        return null;
    }

    @Override
    public int getBorderWidth(Object entity) {
        return -1;
    }

    @Override
    public Color getBorderColor(Object entity) {
        return null;
    }

    @Override
    public Color getBorderHighlightColor(Object entity) {
        return null;
    }

    @Override
    public int getConnectionStyle(Object src, Object dest) {
        return ZestStyles.NONE;
    }

    @Override
    public int getLineWidth(Object src, Object dest) {
        return -1;
    }

    @Override
    public Color getColor(Object src, Object dest) {
        return null;
    }

    @Override
    public Color getHighlightColor(Object src, Object dest) {
        return null;
    }

    @Override
    public boolean fisheyeNode(Object entity) {
        return false;
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

}
