package cz.zcu.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RoundedRectangleAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.util.DrawUtil;
import cz.zcu.yafmt.ui.views.fm.decorations.AttributeDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.CardinalityDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.ConstraintDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.GroupDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.NeighborsDecoration;
import cz.zcu.yafmt.ui.views.fm.figures.ConstraintFigure;
import cz.zcu.yafmt.ui.views.fm.figures.FeatureFigure;
import cz.zcu.yafmt.ui.views.fm.figures.GroupFigure;
import cz.zcu.yafmt.ui.views.fm.figures.NodeFigure;
import cz.zcu.yafmt.ui.views.fm.util.LabelProviderAdapter;

public class FeatureModelStyleProvider extends LabelProviderAdapter {

    private GraphViewer viewer;
    private ViewerFilter[] filters;
    private ConstraintCache constraintCache;
    private Set<Object> selectedElements = new HashSet<Object>();

    public FeatureModelStyleProvider(GraphViewer viewer, ConstraintCache constraintCache) {
        this.viewer = viewer;
        this.constraintCache = constraintCache;
    }

    @SuppressWarnings("unchecked")
    public void refresh(ISelection selection) {
        selectedElements = new HashSet<Object>(((IStructuredSelection) selection).toList());
    }

    // =============================================================
    // Nodes
    // =============================================================

    @Override
    public IFigure getFigure(Object element) {
        NodeFigure figure = createFigure(element);
        // Immediately highlight selected figure.
        if(selectedElements.contains(element))
            figure.setHighlighted(true);
        return figure;
    }

    private NodeFigure createFigure(Object element) {
        if(element instanceof Feature)
            return createFeatureFigure((Feature) element);
        if(element instanceof Group)
            return new GroupFigure((Group) element);
        if(element instanceof Constraint)
            return new ConstraintFigure((Constraint) element);
        return null;
    }

    private NodeFigure createFeatureFigure(Feature feature) {
        FeatureFigure figure = new FeatureFigure(feature);
        figure.addDecoration(new CardinalityDecoration(feature.getLower(), feature.getUpper()));

        List<Feature> neighbors = getHiddenNeighbors(feature);
        if((neighbors != null) && !neighbors.isEmpty())
            figure.addDecoration(new NeighborsDecoration(neighbors));

        Group group = getHiddenGroup(feature);
        if(group != null)
            figure.addDecoration(new GroupDecoration(group));

        List<Constraint> constraints = getHiddenConstraints(feature);
        if((constraints != null) && !constraints.isEmpty())
            figure.addDecoration(new ConstraintDecoration(constraints));

        if(!feature.getAttributes().isEmpty())
            figure.addDecoration(new AttributeDecoration(feature.getAttributes()));

        return figure;
    }

    // =============================================================
    // Connections
    // =============================================================

    @Override
    public void selfStyleConnection(Object element, GraphConnection connection) {
        Connection figure = connection.getConnectionFigure();

        // Set better line style
        if(connection.getLineStyle() == SWT.LINE_DOT) {
            connection.setLineStyle(SWT.LINE_CUSTOM);
            ((PolylineConnection) figure).setLineDash(DrawUtil.LINE_DASHED);
        }

        // Replace connection anchors.
        NodeFigure source = (NodeFigure) figure.getSourceAnchor().getOwner();
        NodeFigure target = (NodeFigure) figure.getTargetAnchor().getOwner();
        Dimension sourceCorners = new Dimension(source.getArcRadius(), source.getArcRadius());
        Dimension targetCorners = new Dimension(target.getArcRadius(), target.getArcRadius());
        figure.setSourceAnchor(new RoundedRectangleAnchor(source, sourceCorners));
        figure.setTargetAnchor(new RoundedRectangleAnchor(target, targetCorners));
    }

    @Override
    public int getConnectionStyle(Object src, Object dst) {
        if((src instanceof Feature) && (dst instanceof Feature)) {
            EObject dstParent = ((Feature) dst).getParent();
            if(dstParent instanceof Group)
                dstParent = ((Group) dstParent).getParent();
            return (src == dstParent) ? ZestStyles.CONNECTIONS_DIRECTED : ZestStyles.NONE;
        }
        return ZestStyles.CONNECTIONS_DOT; // This style is detected and changed in selfStyleConnection().
    }

    @Override
    public int getLineWidth(Object src, Object dest) {
        return 1;
    }

    @Override
    public Color getColor(Object src, Object dst) {
        if((src instanceof Feature) && (dst instanceof Feature))
            return DrawUtil.FEATURE_COLOR;
        if((src instanceof Group) || (dst instanceof Group))
            return DrawUtil.GROUP_COLOR;
        return DrawUtil.CONSTRAINT_COLOR;
    }

    @Override
    public Color getHighlightColor(Object src, Object dst) {
        return getColor(src, dst);
    }

    // =============================================================
    // Helpers
    // =============================================================

    private List<Feature> getHiddenNeighbors(Feature feature) {
        List<Feature> neighbors = new ArrayList<Feature>();

        Object parent = feature.getParent();
        if(parent instanceof Group)
            parent = ((Group) parent).getParent();
        if(isFiltered(parent))
            neighbors.add((Feature) parent);

        for(Feature child: feature.getFeatures()) {
            if(isFiltered(child))
                neighbors.add(child);
        }

        for(Group group: feature.getGroups()) {
            for(Feature child: group.getFeatures()) {
                if(isFiltered(child))
                    neighbors.add(child);
            }
        }

        return neighbors;
    }

    private Group getHiddenGroup(Feature feature) {
        Group group = feature.getParentGroup();
        return ((group != null) && isFiltered(group)) ? group : null;
    }

    private List<Constraint> getHiddenConstraints(Feature feature) {
        Collection<Constraint> constraints = constraintCache.getConstraintsAffectingFeature(feature);
        if(constraints.isEmpty())
            return null;

        List<Constraint> hiddenConstraints = new ArrayList<Constraint>(constraints.size()); 
        for(Constraint constraint: constraints) {
            if(isFiltered(constraint))
                hiddenConstraints.add(constraint);
        }
        return hiddenConstraints;
    }

    private boolean isFiltered(Object element) {
        if(filters == null)
            filters = viewer.getFilters();

        for(ViewerFilter filter: filters) {
            if(!filter.select(viewer, viewer.getInput(), element))
                return true;
        }

        return false;
    }

}
