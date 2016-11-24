package cz.zcu.yafmt.ui.editors.fm.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.ui.figures.ErrorMarker;
import cz.zcu.yafmt.ui.figures.TooltipFigure;

public class AttributeFigure extends Label {

    public static int WIDTH = 150;
    public static int HEIGHT = 18;
    public static int EXTENDED_HEIGHT = 28;

    private Attribute attribute;
    private TooltipFigure toolTip;
    private ErrorMarker errorMarker;
    
    public AttributeFigure(Attribute attribute) {
        this.attribute = attribute;
        initialize();
        refresh();
    }

    // ==================================================================
    //  Initialization
    // ==================================================================
    
    private void initialize() {
        setForegroundColor(ColorConstants.black);
        setToolTip(createTooltip());
        add(createErrorMarker());
    }
    
    private IFigure createTooltip() {
        toolTip = new TooltipFigure();
        return toolTip;
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
        
    public void refresh() {
        setNameAndType(attribute.getName(), attribute.getType());
        toolTip.setText(createDescriptionText());
    }
    
    public void setName(String name) {
        setNameAndType(name, attribute.getType());
    }

    private void setNameAndType(String name, AttributeType type) {
        setText(name + ": " + getTypeName(type));
    }

    private static String getTypeName(AttributeType type) {
        switch(type) {
            case BOOLEAN:
                return "Boolean";
            case INTEGER:
                return "Integer";
            case DOUBLE:
                return "Double";
            case STRING:
                return "String";
            default:
                return "Unknown";
        }
    }
    
    private String createDescriptionText() {
        String description = attribute.getDescription() ;
        if((description != null) && !description.isEmpty())
            return "[" + attribute.getId() + "] " + description;
        else
            return "[" + attribute.getId() + "] ";
    }
    
}
