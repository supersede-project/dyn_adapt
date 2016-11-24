package cz.zcu.yafmt.ui.editors.fm.policies;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.commands.AddAttributeCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.MoveAttributeCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.parts.FeatureEditPart;

public class FeatureLayoutPolicy extends OrderedLayoutEditPolicy {

    @Override
    protected EditPart getInsertionReference(Request request) {
        // Find the edit part after cursor location.
        List<?> editParts = getHost().getChildren();
        EditPart editPartAfter = null;

        Point requestLocation = ((ChangeBoundsRequest) request).getLocation();
        getHostFigure().translateToRelative(requestLocation);
        int requestY = requestLocation.y;
        int prevY = Integer.MAX_VALUE;

        for(Object editPart: editParts) {
            GraphicalEditPart currentEditPart = (GraphicalEditPart) editPart;
            int currentY = currentEditPart.getFigure().getBounds().getCenter().y;
            if((currentY > requestY) && (currentY < prevY)) {
                prevY = currentY;
                editPartAfter = currentEditPart;
            }
        }

        return editPartAfter;
    }

    // Moved attribute within the same feature (change its position).
    @Override
    protected Command createMoveChildCommand(EditPart editPart, EditPart editPartAfter) {
        List<Attribute> attributes = ((Feature) getHost().getModel()).getAttributes();
        Attribute attribute = (Attribute) editPart.getModel();

        int currentIndex = attributes.indexOf(attribute);
        int targetIndex = attributes.size();
        if(editPartAfter != null)
            targetIndex = attributes.indexOf(editPartAfter.getModel());

        // Ignore request if attribute position was not changed.        
        if((currentIndex == targetIndex) || (currentIndex == (targetIndex - 1)))
            return null;
        // Fix position
        if(currentIndex < targetIndex)
            targetIndex--;

        return new MoveAttributeCommand(attribute, targetIndex);
    }

    // Moving attribute from another feature.
    @Override
    protected Command createAddCommand(EditPart editPart, EditPart editPartAfter) {
        Object model = editPart.getModel();
        if(!(model instanceof Attribute))
            return null;

        Attribute attribute = (Attribute) model;
        LayoutData layoutData = ((FeatureEditPart) getHost()).getLayoutData();
        Feature newFeature = (Feature) getHost().getModel();
        IFigure newFeatureFigure = getHostFigure();
        List<Attribute> attributes = newFeature.getAttributes();

        int targetIndex = attributes.size();
        if(editPartAfter != null)
            targetIndex = attributes.indexOf(editPartAfter.getModel());

        Feature oldFeature = attribute.getFeature();
        IFigure oldFeatureFigure = ((GraphicalEditPart) getHost().getRoot().getViewer().getEditPartRegistry().get(oldFeature)).getFigure(); 
        
        CompoundCommand command = new CompoundCommand("Move attribute " + attribute.getName() + " to " + newFeature.getName());
        command.add(new DeleteAttributeCommand(layoutData, oldFeature, oldFeatureFigure, attribute));
        command.add(new AddAttributeCommand(layoutData, newFeature, newFeatureFigure, attribute, targetIndex));
        return command;
    }

    // A new attribute added to the feature.
    @Override
    protected Command getCreateCommand(CreateRequest request) {
        Object object = request.getNewObject();
        if(!(object instanceof Attribute))
            return null;

        Feature feature = (Feature) getHost().getModel();
        IFigure featureFigure = getHostFigure();
        LayoutData layoutData = ((FeatureEditPart) getHost()).getLayoutData();

        return new AddAttributeCommand(layoutData, feature, featureFigure, (Attribute) object);
    }

}
