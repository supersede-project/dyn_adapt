package cz.zcu.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PolylineConnection;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;
import cz.zcu.yafmt.ui.figures.CircleDecoration;

public class ConnectionFigure extends PolylineConnection {

    private Connection connection;
    
    private CircleDecoration circleDecoration = new CircleDecoration();
    private SquareDecoration squareDecoration = new SquareDecoration();
    private Label label;

    public ConnectionFigure(Connection connection) {
        this.connection = connection;
        initialize();
        refresh();
    }
    
    // ==================================================================
    //  Initialization
    // ==================================================================

    private void initialize() {
        add(createLabel(), createLabelLocator());
        setForegroundColor(ColorConstants.black);
    }
    
    private Label createLabel() {
        label = new Label();
        label.setForegroundColor(ColorConstants.black);
        return label;
    }
    
    private Locator createLabelLocator() {
        ConnectionEndpointLocator locator = new ConnectionEndpointLocator(this, false);
        locator.setUDistance(4);
        locator.setVDistance(16);
        return locator;
    }
    
    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setHighlighted(boolean highlighted) {
        setLineWidth(highlighted ? 2 : 1);
    }

    public void refresh() {
        Feature target = connection.getTarget();

        if(target.isCloneable()) {
            setSourceDecoration(null);
            label.setText(FeatureModelUtil.getCardinality(target));
        }
        else {
            if(target.getParentGroup() != null) {
                squareDecoration.setFilled(target.isMandatory());
                setSourceDecoration(squareDecoration);
            }
            else {
                circleDecoration.setFilled(target.isMandatory());
                setSourceDecoration(circleDecoration);
            }
            label.setText(null);
        }
    }

}
