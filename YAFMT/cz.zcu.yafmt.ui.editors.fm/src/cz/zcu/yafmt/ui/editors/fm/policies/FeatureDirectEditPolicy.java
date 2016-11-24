package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.editors.fm.commands.SetFeatureNameCommand;
import cz.zcu.yafmt.ui.editors.fm.figures.FeatureFigure;

public class FeatureDirectEditPolicy extends DirectEditPolicy {

    private String getEnteredText(DirectEditRequest request) {
        return (String) request.getCellEditor().getValue();
    }

    @Override
    protected Command getDirectEditCommand(DirectEditRequest request) {
        Feature feature = (Feature) getHost().getModel();
        return new SetFeatureNameCommand(feature, getEnteredText(request));
    }

    @Override
    protected void showCurrentEditValue(DirectEditRequest request) {
        Label label = ((FeatureFigure) getHostFigure()).getLabel();
        label.setText(getEnteredText(request));
    }

}
