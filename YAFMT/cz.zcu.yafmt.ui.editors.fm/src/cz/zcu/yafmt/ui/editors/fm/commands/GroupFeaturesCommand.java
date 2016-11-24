package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModelFactory;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class GroupFeaturesCommand extends RecordingCommand {

    private LayoutData layoutData;
    private List<Feature> features;
    private Group group;
    private Rectangle bounds;
    private boolean xorGroup;

    public GroupFeaturesCommand(LayoutData layoutData, List<Feature> features, boolean xorGroup) {
        setLabel("Make " + (xorGroup ? "XOR" : "OR") + " Group");
        this.layoutData = layoutData;
        this.features = features;
        this.xorGroup = xorGroup;
    }

    @Override
    protected void initializeRecording() {
        for(Feature feature: features)
            addRecordedObjectParent(feature);
    }

    @Override
    protected void performRecording() {
        EObject parent = features.get(0).getParent();
        if(parent instanceof Group)
            parent = ((Group) parent).getParent();

        group = FeatureModelFactory.eINSTANCE.createGroup();
        group.setParent((Feature) parent);
        group.getFeatures().addAll(features);
        group.setXor(xorGroup); // Must be called after adding features.

        // Do not iterate on the original group list (ConcurrentModificationException).
        List<Group> groups = new ArrayList<Group>(((Feature) parent).getGroups());
        for(Group group: groups)
            FeatureModelUtil.removeUnneededGroup(group);

        computeGroupBounds();
    }

    private void computeGroupBounds() {
        Rectangle parentBounds = layoutData.get(group.getParent());

        int cx = 0;
        int cy = 0;
        for(Feature feature: features) {
            Point center = layoutData.get(feature).getCenter();
            cx += center.x;
            cy += center.y;
        }
        cx /= features.size();
        cy /= features.size();

        bounds = MoveGroupCommand.computeGroupBounds(parentBounds, cx, cy);
    }

    @Override
    public void execute() {
        layoutData.set(group, bounds);
        super.execute();

    }

    @Override
    public void redo() {
        layoutData.set(group, bounds);
        super.redo();
    }

    @Override
    public void undo() {
        super.undo();
        layoutData.remove(group);
    }

}
