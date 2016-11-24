package cz.zcu.yafmt.ui.editors.fc.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.ui.editors.fc.commands.SetAttributeValueCommand;
import cz.zcu.yafmt.ui.editors.fc.figures.AttributeValueFigure;

public class AttributeValueDirectEditPolicy extends DirectEditPolicy {

    @Override
    protected Command getDirectEditCommand(DirectEditRequest request) {
        AttributeValue attributeValue = (AttributeValue) getHost().getModel();
        Object value = request.getCellEditor().getValue();
        return new SetAttributeValueCommand(attributeValue, value);
    }

    @Override
    protected void showCurrentEditValue(DirectEditRequest request) {
        // Feedback only for text input.
        Object value = request.getCellEditor().getValue();
        if(value == null)
            value = "";
        if(value instanceof String)
            ((AttributeValueFigure) getHostFigure()).setValue(value);
    }

}
