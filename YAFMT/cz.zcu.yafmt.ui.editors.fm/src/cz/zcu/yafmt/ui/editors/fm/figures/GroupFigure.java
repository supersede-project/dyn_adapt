package cz.zcu.yafmt.ui.editors.fm.figures;

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.figures.ErrorMarker;
import cz.zcu.yafmt.ui.figures.NonInteractiveLabel;
import cz.zcu.yafmt.ui.figures.TooltipFigure;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class GroupFigure extends Shape {

    public static final int SIZE = 45;
    private static final int LABEL_DISTANCE = 50;
    private static final int ERROR_MARKER_DISTANCE = 14;

    private Group group;
    private LayoutData layoutData;
    
    private Label label;
    private TooltipFigure toolTip;
    private ErrorMarker errorMarker;
    
    private double[] connectionAngles;
    private int arcOffset = 0;
    private int arcLength = 0;
    private Rectangle arcBounds = bounds;

    public GroupFigure(Group group, LayoutData layoutData) {
        this.group = group;
        this.layoutData = layoutData;
        initialize();
        refresh();
    }
    
    // ==================================================================
    //  Initialization
    // ==================================================================
    
    private void initialize() {
        setLayoutManager(new XYLayout());
        setForegroundColor(ColorConstants.black);
        setOpaque(true);
        setToolTip(createToolTip());
        createLabel();
        add(createErrorMarker());
    }

    private TooltipFigure createToolTip() {
        toolTip = new TooltipFigure(createDescriptionText());
        return toolTip;
    }
    
    private void createLabel() {
        label = new NonInteractiveLabel();
        label.setForegroundColor(ColorConstants.black);
    }
        
    private IFigure createErrorMarker() {
        errorMarker = new ErrorMarker();
        return errorMarker;
    }
    
    // ==================================================================
    //  Events
    // ==================================================================
    
    @Override
    public void addNotify() {
        // Add label to parent.
        super.addNotify();
        getParent().add(label);
    }

    @Override
    public void removeNotify() {
        // Remove label from parent.
        if(label.getParent() != null)
            label.getParent().remove(label);
        super.removeNotify();
    }
    
    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void refresh() {
        refreshCardinality();
        refreshVisuals();
        toolTip.setText(createDescriptionText());
    }

    private void refreshCardinality() {
        if(group.isOr()) {
            setBackgroundColor(ColorConstants.black);
            label.setText(null);
        }
        else if(group.isXor()) {
            setBackgroundColor(null);
            label.setText(null);
        }
        else {
            setBackgroundColor(null);
            label.setText(FeatureModelUtil.getCardinality(group));
        }
    }
    
    private void refreshVisuals() {
        Rectangle newBounds = layoutData.get(group);
        if(newBounds != null) {
            setBounds(newBounds.getCopy());
            recomputeArcData();
            repositionLabel();
            repositionErrorMarker();
        }
    }
    
    public void setErrors(List<String> messages) {
        errorMarker.setErrors(messages);
    }
    
    private String createDescriptionText() {
        String name = FeatureModelUtil.getTranslatedCardinality(group) + " Group.";
        String description = group.getDescription();
        if((description != null) && !description.isEmpty())
            return name + " " + description;
        else
            return name;
    }
    
    // ==================================================================
    //  Computations
    // ==================================================================
    
    private void recomputeArcData() {
        List<Feature> features = group.getFeatures();
        int size = features.size();

        if(size < 2) {
            arcOffset = 0;
            arcLength = 0;
            arcBounds = bounds;
            return;
        }

        connectionAngles = new double[size + 1];
        connectionAngles[size] = Double.MAX_VALUE;
        Point self = bounds.getCenter(); // Do not get this value from layout data, it could be outdated!

        // Get angle of each group-to-feature connection.
        for(int i = 0; i < size; i++) {
            Rectangle rect = layoutData.get(features.get(i));
            Point target = (rect != null) ? rect.getCenter() : new Point(0, 0);
            connectionAngles[i] = getAngle(self, target);
        }

        // Sort them and and duplicate the first one.
        Arrays.sort(connectionAngles);
        connectionAngles[size] = connectionAngles[0] + 360.0;

        int maxIndex = 0;
        double maxDiff = -1.0;

        // Find region with the biggest angle difference.
        for(int i = 0; i < size; i++) {
            double diff = connectionAngles[i + 1] - connectionAngles[i];
            if(diff > maxDiff) {
                maxDiff = diff;
                maxIndex = i;
            }
        }

        // Arc is made between connections outside the found region.
        arcOffset = (int) connectionAngles[maxIndex + 1];
        arcLength = (int) (360.0 - (connectionAngles[maxIndex + 1] - connectionAngles[maxIndex]) + 1);
        arcBounds = getOptimizedBounds();
    }

    private double getAngle(Point self, Point target) {
        double dx = target.x - self.x;
        double dy = target.y - self.y;

        double result = Math.toDegrees(Math.atan2(-dy, dx));
        return (result < 0.0) ? result + 360.0 : result;
    }

    private Rectangle getOptimizedBounds() {
        // Copied from superclass.
        float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
        int inset1 = (int) Math.floor(lineInset);
        int inset2 = (int) Math.ceil(lineInset);

        Rectangle r = new Rectangle(bounds);
        r.x += inset1;
        r.y += inset1;
        r.width -= inset1 + inset2;
        r.height -= inset1 + inset2;
        return r;
    }

    private void repositionLabel() {
        if(label.getText().isEmpty() || (label.getParent() == null) || (connectionAngles == null))
            return;

        Dimension size = label.getPreferredSize();

        int maxIndex1 = 0;
        int maxIndex2 = 0;
        double maxDiff1 = -1.0;
        double maxDiff2 = -1.0;

        // Find region with the 2nd biggest angle difference.
        for(int i = 0; i < (connectionAngles.length - 1); i++) {
            double diff = connectionAngles[i + 1] - connectionAngles[i];
            if(diff > maxDiff1) {
                maxIndex2 = maxIndex1;
                maxDiff2 = maxDiff1;
                maxIndex1 = i;
                maxDiff1 = diff;
            }
            else if(diff > maxDiff2) {
                maxIndex2 = i;
                maxDiff2 = diff;
            }
        }

        // Place the label inside the found region.
        double theta = Math.toRadians((connectionAngles[maxIndex2 + 1] + connectionAngles[maxIndex2]) / 2);
        int x = (int) (LABEL_DISTANCE * Math.cos(theta)) - size.width / 2;
        int y = -(int) (LABEL_DISTANCE * Math.sin(theta)) - size.width / 2;

        Point position = bounds.getCenter().translate(x, y);
        Rectangle labelBounds = new Rectangle(position, size);
        label.getParent().setConstraint(label, labelBounds); // Label is child of group's parent figure.
    }
    
    private void repositionErrorMarker() {
        double theta = Math.toRadians(arcOffset + arcLength / 2);
        Dimension size = errorMarker.getSize();
        int x = (int) ((SIZE - size.width) / 2 + (ERROR_MARKER_DISTANCE * Math.cos(theta)));
        int y = (int) ((SIZE - size.height) / 2 - (ERROR_MARKER_DISTANCE * Math.sin(theta)));
        setConstraint(errorMarker, new Rectangle(x, y, size.width, size.height));
    }
    
    // ==================================================================
    //  Rendering
    // ==================================================================
    
    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixScaledFigureLocation(graphics);
        super.paint(graphics);
    }
    
    @Override
    protected void fillShape(Graphics graphics) {
        Rectangle fillBounds = arcBounds.getCopy();
        fillBounds.width++;
        fillBounds.height++;
        graphics.fillArc(fillBounds, arcOffset, arcLength);
    }

    @Override
    protected void outlineShape(Graphics graphics) {
        graphics.drawArc(arcBounds, arcOffset, arcLength);
    }

}
