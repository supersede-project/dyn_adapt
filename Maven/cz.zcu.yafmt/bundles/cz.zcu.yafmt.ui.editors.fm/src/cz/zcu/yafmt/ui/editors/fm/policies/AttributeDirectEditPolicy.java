package cz.zcu.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.ui.editors.fm.commands.SetAttributeNameCommand;
import cz.zcu.yafmt.ui.editors.fm.commands.SetAttributeTypeCommand;
import cz.zcu.yafmt.ui.editors.fm.figures.AttributeFigure;

public class AttributeDirectEditPolicy extends DirectEditPolicy {

    @Override
    protected Command getDirectEditCommand(DirectEditRequest request) {
        Attribute attribute = (Attribute) getHost().getModel();
        Object value = request.getCellEditor().getValue();

        if(value instanceof String)
            return new SetAttributeNameCommand(attribute, (String) value);
        if(value instanceof AttributeType)
            return new SetAttributeTypeCommand(attribute, (AttributeType) value);
        return null;
    }

    @Override
    protected void showCurrentEditValue(DirectEditRequest request) {
        // Feedback only for text input.
        Object value = request.getCellEditor().getValue();
        if(value == null)
            value = "";
        if(value instanceof String)
            ((AttributeFigure) getHostFigure()).setName((String) value);
    }

}
