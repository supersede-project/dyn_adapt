package cz.zcu.yafmt.ui.editors.fc.parts;

import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.BOOLEAN_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.STRING_VALUE;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.StringValue;
import cz.zcu.yafmt.ui.directediting.ComboDirectEditManager;
import cz.zcu.yafmt.ui.directediting.LabelDirectEditManager;
import cz.zcu.yafmt.ui.editors.fc.figures.AttributeValueFigure;
import cz.zcu.yafmt.ui.editors.fc.policies.AttributeValueDirectEditPolicy;
import cz.zcu.yafmt.ui.editors.fc.policies.AttributeValueSelectionPolicy;
import cz.zcu.yafmt.ui.editors.fc.util.BooleanCellEditor;

public class AttributeValueEditPart extends AbstractGraphicalEditPart {

    private AttributeValue attributeValue;
    private AttributeValueAdapter attributeValueAdapter;

    public AttributeValueEditPart(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
        this.attributeValueAdapter = new AttributeValueAdapter();
        setModel(attributeValue);
    }

    // ===================================================================
    //  Initialization
    // ===================================================================
    
    @Override
    public void activate() {
        super.activate();
        attributeValue.eAdapters().add(attributeValueAdapter);
    }
    
    @Override
    public void deactivate() {
        attributeValue.eAdapters().remove(attributeValueAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================
    
    @Override
    protected IFigure createFigure() {
        return new AttributeValueFigure(attributeValue);
    }
    
    @Override
    public AttributeValueFigure getFigure() {
        return (AttributeValueFigure) super.getFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        getFigure().refresh();
    }

    // ===================================================================
    //  Policies
    // ===================================================================
    
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new AttributeValueSelectionPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new AttributeValueDirectEditPolicy());
    }
    
    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType()))
            performDirectEditing();
    }
    
    private void performDirectEditing() {
        AttributeValueFigure figure = getFigure();
        Rectangle figureBounds = figure.getBounds().getCopy();
        figure.translateToAbsolute(figureBounds);
        
        String attributeName = attributeValue.getName();
        int attributeNameWidth = TextUtilities.INSTANCE.getStringExtents(attributeName + " = ", figure.getFont()).width;
        
        LabelDirectEditManager manager = null;
        
        switch(attributeValue.eClass().getClassifierID()) {
            case BOOLEAN_VALUE:
                manager = new ComboDirectEditManager(this, BooleanCellEditor.class, figure, ((BooleanValue) attributeValue).isValue());
                break;
                
            case INTEGER_VALUE:
                manager = new LabelDirectEditManager(this, figure, Integer.toString(((IntegerValue) attributeValue).getValue()));
                break;
                
            case DOUBLE_VALUE:
                manager = new LabelDirectEditManager(this, figure, Double.toString(((DoubleValue) attributeValue).getValue()));
                break;
                
            case STRING_VALUE: {
                String value = ((StringValue) attributeValue).getValue();
                manager = new LabelDirectEditManager(this, figure, (value != null) ? value : "");
                break;
            }
        }
        
        manager.setAlignment(SWT.LEFT | SWT.CENTER);
        manager.setXOffset(attributeNameWidth);
        manager.show();
    }

    // ===================================================================
    //  Events
    // ===================================================================
        
    private class AttributeValueAdapter extends AdapterImpl {
        
        @Override
        public void notifyChanged(Notification msg) {
            refreshVisuals(); // Only value change notification can occurs.
        }
        
    }
    
}
