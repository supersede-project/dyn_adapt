package cz.zcu.yafmt.ui.editors.fc.figures;

import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.BOOLEAN_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.STRING_VALUE;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.StringValue;
import cz.zcu.yafmt.ui.figures.ErrorMarker;
import cz.zcu.yafmt.ui.figures.TooltipFigure;
import cz.zcu.yafmt.ui.util.DrawUtil;


public class AttributeValueFigure extends Label {

    private AttributeValue attributeValue;
    private ErrorMarker errorMarker;
    private boolean highlighted;

    public AttributeValueFigure(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
        this.highlighted = false;
        initialize();
        refresh();
    }

    // ==================================================================
    //  Initialization
    // ==================================================================
    
    private void initialize() {
        setForegroundColor(ColorConstants.black);
        setToolTip(createToolTip());
        add(createErrorMarker());
    }
    
    private TooltipFigure createToolTip() {
        return new TooltipFigure(createToolTipText());
    }
    
    private String createToolTipText() {
        String description = attributeValue.getDescription();
        if((description != null) && !description.isEmpty())
            return "[" + attributeValue.getId() + "] " + description;
        else
            return "[" + attributeValue.getId() + "]";
    }
    
    private IFigure createErrorMarker() {
        errorMarker = new ErrorMarker();
        return errorMarker;
    }

    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setErrors(List<String> messages) {
        errorMarker.setErrors(messages);
    }
    
    public void setHightlighted(boolean value) {
        if(highlighted != value) {
            highlighted = value;
            repaint();
        }
    }
    
    public void refresh() {
        setNameAndValue(attributeValue.getName(), getValue(attributeValue));
    }

    public void setValue(Object value) {
        setNameAndValue(attributeValue.getName(), value);
    }

    private void setNameAndValue(String name, Object value) {
        // Spaces on sides are reserved to display highlight border properly.
        setText(" " + name + " = " + valueToString(value) + " ");
    }
    
    private Object getValue(AttributeValue attributeValue) {
        switch(attributeValue.eClass().getClassifierID()) {
            case BOOLEAN_VALUE:
                return ((BooleanValue) attributeValue).isValue();
                
            case INTEGER_VALUE:
                return ((IntegerValue) attributeValue).getValue();
                
            case DOUBLE_VALUE:
                return ((DoubleValue) attributeValue).getValue();
                
            case STRING_VALUE:
                return ((StringValue) attributeValue).getValue();
                
            default:
                return null;
        }
    }
    
    private String valueToString(Object value) {
        return (value != null) ? value.toString() : "";
    }
    
    // ==================================================================
    //  Drawing
    // ==================================================================
    
    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        
        if(highlighted) {
            graphics.setLineStyle(SWT.LINE_CUSTOM);
            graphics.setLineDash(DrawUtil.LINE_DASHED);
            graphics.drawRectangle(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
        }
    }
    
}
