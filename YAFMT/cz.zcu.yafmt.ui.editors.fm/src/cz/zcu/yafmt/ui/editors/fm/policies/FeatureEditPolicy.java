package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.commands.DeleteFeatureCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.GenerateFeatureIdFromNameCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.SetFeatureCardinalityCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.SetFeatureOptimalSizeCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.parts.FeatureEditPart;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureEditPolicy extends ComponentEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_MAKE_FEATURE_MAN.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createSetFeatureCardinalityCommand(feature, true);
        }
        else if(RequestConstants.REQ_MAKE_FEATURE_OPT.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createSetFeatureCardinalityCommand(feature, false);
        }
        else if(RequestConstants.REQ_GENERATE_ID_FROM_NAME.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return new GenerateFeatureIdFromNameCommand(feature);
        }
        else if(RequestConstants.REQ_SET_FEATURE_OPTIMAL_SIZE.equals(type)) {
            LayoutData layoutData =((FeatureEditPart) getHost()).getLayoutData();
            Feature feature = (Feature) getHost().getModel();
            IFigure figure = ((FeatureEditPart) getHost()).getFigure();
            return new SetFeatureOptimalSizeCommand(layoutData, feature, figure);
        }
        return super.getCommand(request);
    }

    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        Feature feature = (Feature) getHost().getModel();
        if(feature.isRoot())
            return null;

        LayoutData layoutData = ((FeatureEditPart) getHost()).getLayoutData();
        return new DeleteFeatureCommand(feature, layoutData);
    }

    private Command createSetFeatureCardinalityCommand(Feature feature, boolean mandatory) {
        if(feature.isRoot())
            return null;
        if(feature.isMandatory() == mandatory)
            return null;
        return new SetFeatureCardinalityCommand(feature, mandatory);
    }

}
