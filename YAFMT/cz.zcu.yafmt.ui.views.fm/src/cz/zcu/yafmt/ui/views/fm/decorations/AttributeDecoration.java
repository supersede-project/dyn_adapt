package cz.zcu.yafmt.ui.views.fm.decorations;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class AttributeDecoration extends ImageDecoration {

    private List<Attribute> attributes;
    private Label toolTip;
    
    public AttributeDecoration(List<Attribute> attributes) {
        super(FeatureModelVisualizerPlugin.getAccess().getImage("attribute-decoration.png"));
        this.attributes = attributes;
    }
    
    // ===============================================================
    //  Basic properties
    // ===============================================================
    
    public List<Attribute> getAttributes() {
        return attributes;
    }
    
    @Override
    public IFigure getToolTip() {
        if(toolTip == null)
            toolTip = new Label(createToolTipText());
        return toolTip;
    }
    
    private String createToolTipText() {
        StringBuilder builder = new StringBuilder();
        
        if(attributes.size() == 1) {
            builder.append("Feature has an attribute (");
            appendAttributeText(builder, attributes.get(0)).append(").");
        }
        else {
            builder.append("Feature has " + attributes.size() + " attributes:");
            for(Attribute attribute: attributes)
                appendAttributeText(builder.append("\n    - "), attribute);
        }
        
        return builder.toString();
    }
    
    private StringBuilder appendAttributeText(StringBuilder builder, Attribute attribute) {
        return builder.append(attribute.getName()).append(": ").append(attribute.getType());
    }
    
    // ===============================================================
    //  Decoration properties
    // ===============================================================

    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x + parentBounds.width - 2;
        int y = parentBounds.y + parentBounds.height - 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

}
