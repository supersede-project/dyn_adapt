package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;


public class ApplyHorizontalTreeLayoutCommand extends ApplyLayoutCommand {
    private static final int HORIZONTAL_SPACE = 90;
    private static final int VERTICAL_SPACE = 15;

    public ApplyHorizontalTreeLayoutCommand(FeatureModel featureModel, LayoutData layoutData) {
        super(featureModel, layoutData);
        setLabel("Apply Horizontal Tree Layout");
    }

    @Override
    protected void applyLayout() {
        Map<EObject, Integer> subTreeHeight = new HashMap<EObject, Integer>();
        calculateSubTreeHeight(subTreeHeight);
        calculateLayout(subTreeHeight);
    }

    private int calculateSubTreeHeight(Map<EObject, Integer> subTreeHeight) {
        int height = 0;

        height += calculateSubTreeHeight(subTreeHeight, featureModel.getRoot());
        for(Feature orphan: featureModel.getOrphans())
            height += calculateSubTreeHeight(subTreeHeight, orphan);

        return height;
    }

    private int calculateSubTreeHeight(Map<EObject, Integer> subTreeHeight, Feature feature) {
        int height = 0;

        for(Group group: feature.getGroups()) {
            int groupHeight = 0;
            for(Feature child: group.getFeatures())
                groupHeight += calculateSubTreeHeight(subTreeHeight, child);
            subTreeHeight.put(group, groupHeight);
            height += groupHeight;
        }

        for(Feature child: feature.getFeatures())
            height += calculateSubTreeHeight(subTreeHeight, child);

        if(height == 0)
            height = oldLayout.get(feature).height;
        height += VERTICAL_SPACE;

        subTreeHeight.put(feature, height);
        return height;
    }

    private void calculateLayout(Map<EObject, Integer> subTreeHeight) {
        int x = VERTICAL_SPACE;
        int y = VERTICAL_SPACE;

        calculateLayout(subTreeHeight, featureModel.getRoot(), x, y);
        y += subTreeHeight.get(featureModel.getRoot());

        for(Feature orphan: featureModel.getOrphans()) {
            calculateLayout(subTreeHeight, orphan, x, y);
            y += subTreeHeight.get(orphan);
        }
    }

    private void calculateLayout(Map<EObject, Integer> subTreeHeight, Feature feature, int xBase, int yBase) {
        yBase += VERTICAL_SPACE / 2;
        Rectangle bounds = oldLayout.get(feature).getCopy();
        bounds.x = xBase;
        bounds.y = yBase + (subTreeHeight.get(feature) - bounds.height) / 2;
        newLayout.put(feature, bounds);

        int x = xBase + bounds.width + HORIZONTAL_SPACE;
        int y = yBase;

        for(Group group: feature.getGroups()) {
            double ry = (y - yBase + 0.5 * subTreeHeight.get(group)) / (double) subTreeHeight.get(feature);
            int gx = bounds.right() - GroupFigure.SIZE / 2;
            int gy = (int) (bounds.y + ry * bounds.height - GroupFigure.SIZE / 2);
            newLayout.put(group, new Rectangle(gx, gy, GroupFigure.SIZE, GroupFigure.SIZE));

            for(Feature child: group.getFeatures()) {
                calculateLayout(subTreeHeight, child, x, y);
                y += subTreeHeight.get(child);
            }
        }

        for(Feature child: feature.getFeatures()) {
            calculateLayout(subTreeHeight, child, x, y);
            y += subTreeHeight.get(child);
        }
    }
}
