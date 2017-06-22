package cz.zcu.yafmt.ui.editors.fm.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.commands.GroupFeaturesCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.UngroupFeaturesCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.parts.FeatureModelEditPart;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureModelEditPolicy extends ComponentEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_GROUP_FEATURES_XOR.equals(type)) {
            List<?> selection = ((GroupRequest) request).getEditParts();
            return createGroupFeaturesCommand(selection, true);
        }
        else if(RequestConstants.REQ_GROUP_FEATURES_OR.equals(type)) {
            List<?> selection = ((GroupRequest) request).getEditParts();
            return createGroupFeaturesCommand(selection, false);
        }
        else if(RequestConstants.REQ_UNGROUP_FEATURES.equals(type)) {
            List<?> selection = ((GroupRequest) request).getEditParts();
            return createUngroupFeaturesCommand(selection);
        }
        return super.getCommand(request);
    }

    private Command createGroupFeaturesCommand(List<?> selectedEditParts, boolean xorGroup) {
        List<Feature> features = getFeatureSelection(selectedEditParts);
        if((features == null) || (features.size() < 2))
            return null;

        // Check if all features are sub-features of the same feature.
        EObject commonParent = null;
        for(Feature feature: features) {
            EObject parent = feature.getParent();
            if(parent instanceof Group)
                parent = ((Group) parent).getParent();
            if(!(parent instanceof Feature))
                return null;
            if(commonParent == null)
                commonParent = parent;
            else if(parent != commonParent)
                return null;
        }

        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        return new GroupFeaturesCommand(layoutData, features, xorGroup);
    }

    private Command createUngroupFeaturesCommand(List<?> selectedEditParts) {
        List<Feature> features = getFeatureSelection(selectedEditParts);
        if((features == null) || features.isEmpty())
            return null;

        // Check if there is a parent group.
        boolean canExecute = false;
        for(Feature feature: features) {
            if(feature.getParentGroup() != null) {
                canExecute = true;
                break;
            }
        }
        if(!canExecute)
            return null;

        return new UngroupFeaturesCommand(features);
    }

    List<Feature> getFeatureSelection(List<?> selectedEditParts) {
        List<Feature> features = new ArrayList<Feature>();

        for(Object selectedObject: selectedEditParts) {
            Object model = ((EditPart) selectedObject).getModel();
            if(model instanceof Feature)
                features.add((Feature) model);
        }

        return features;
    }

}
