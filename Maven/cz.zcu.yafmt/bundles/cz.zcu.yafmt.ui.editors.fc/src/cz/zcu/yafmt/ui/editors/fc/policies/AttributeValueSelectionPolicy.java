package cz.zcu.yafmt.ui.editors.fc.policies;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import cz.zcu.yafmt.ui.editors.fc.figures.AttributeValueFigure;


public class AttributeValueSelectionPolicy extends SelectionEditPolicy implements EditPolicy {

    @Override
    protected void showSelection() {
        ((AttributeValueFigure) getHostFigure()).setHightlighted(true);
    }
    
    @Override
    protected void hideSelection() {
        ((AttributeValueFigure) getHostFigure()).setHightlighted(false);
    }

}
