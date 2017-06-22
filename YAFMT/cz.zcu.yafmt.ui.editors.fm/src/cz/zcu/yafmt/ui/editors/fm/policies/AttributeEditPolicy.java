package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.GenerateAttributeIdFromName;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.parts.FeatureEditPart;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class AttributeEditPolicy extends ComponentEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_GENERATE_ID_FROM_NAME.equals(type)) {
            Attribute attribute = (Attribute) getHost().getModel();
            return new GenerateAttributeIdFromName(attribute);
        }
        return super.getCommand(request);
    }
    
    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        Feature feature = (Feature) getHost().getParent().getModel();
        IFigure featureFigure = ((GraphicalEditPart) getHost().getParent()).getFigure();
        Attribute attribute = (Attribute) getHost().getModel();
        LayoutData layoutData = ((FeatureEditPart) getHost().getParent()).getLayoutData();

        return new DeleteAttributeCommand(layoutData, feature, featureFigure, attribute);
    }

}
