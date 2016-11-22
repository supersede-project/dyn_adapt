package cz.zcu.yafmt.ui.editors.fc.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.ui.figures.ErrorMarker;
import cz.zcu.yafmt.ui.figures.MarkerLayer;
import cz.zcu.yafmt.ui.figures.RoundedRectangleWithGradient;
import cz.zcu.yafmt.ui.figures.SeparatorFigure;
import cz.zcu.yafmt.ui.figures.TooltipFigure;
import cz.zcu.yafmt.ui.figures.VerticalToolbarFigure;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class SelectionFigure extends RoundedRectangleWithGradient {
    
    private static final int MIN_WIDTH = 90;
    private static final int MIN_HEIGHT = 30;

    private Selection selection;
    
    private Label label;
    private Figure mainLayer;
    private MarkerLayer markerLayer;
    private Figure separatorFigure;
    private Figure attributeValuesContainer;
    private ErrorMarker errorMarker;

    public SelectionFigure(Selection selection) {
        this.selection = selection;
        initialize();
    }
    
    // =================================================================
    //  Initialization
    // =================================================================
    
    private void initialize() {
        setLayoutManager(new StackLayout());
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setSize(-1, -1);
        setHighlighted(false);
        setToolTip(createToolTip());
        add(createMainLayer());
        add(createMarkerLayer());        
    }
    
    private TooltipFigure createToolTip() {
        return new TooltipFigure(createToolTipText());
    }
    
    private String createToolTipText() {
        String description = selection.getDescription();
        if((description != null) && !description.isEmpty())
            return "[" + selection.getId() + "] " + description;
        else
            return "[" + selection.getId() + "]";
    }
    
    // ==================================================================
    //  Initialization (main layer)
    // ==================================================================

    private IFigure createMainLayer() {
        mainLayer = new Figure();
        mainLayer.setLayoutManager(new GridLayout());
        mainLayer.add(createLabel(), new GridData(SWT.CENTER, SWT.CENTER, true, true));
        return mainLayer;
    }
    
    private Label createLabel() {
        label = new Label();
        label.setFont(DrawUtil.BOLD_FONT);
        label.setForegroundColor(ColorConstants.black);
        label.setText(selection.getName());
        return label;
    }
    
    private void initializeAttributesContainer() {
        mainLayer.add(createSeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false), 1);
        mainLayer.add(createAttributeValuesContainer(), new GridData(SWT.CENTER, SWT.CENTER, true, false), 2);
    }
    
    private void destroyAttributeValuesContainer() {
        mainLayer.remove(attributeValuesContainer);
        mainLayer.remove(separatorFigure);
        attributeValuesContainer = null;
        separatorFigure = null;
    }
    
    private Figure createAttributeValuesContainer() {
        attributeValuesContainer = new VerticalToolbarFigure();
        return attributeValuesContainer;
    }
    
    private Figure createSeparatorFigure() {
        separatorFigure = new SeparatorFigure();
        return separatorFigure;
    }
    
    // ==================================================================
    //  Initialization (marker layer)
    // ==================================================================
    
    private IFigure createMarkerLayer() {
        markerLayer = new MarkerLayer();
        markerLayer.add(createErrorMarker());
        return markerLayer;
    }
    
    private IFigure createErrorMarker() {
        errorMarker = new ErrorMarker();
        errorMarker.setLocation(new Point(2, 2));
        return errorMarker;
    }
        
    // =================================================================
    //  Properties
    // =================================================================
        
    public void setHighlighted(boolean highlighted) {
        setLineWidth(highlighted ? 2 : 1);
    }
    
    public void setErrors(List<String> messages) {
        errorMarker.setErrors(messages);
        markerLayer.refresh();
    }
    
    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        return super.getPreferredSize(wHint, hHint).getExpanded(24, 0);
    }
    
    // =================================================================
    //  Drawing
    // =================================================================
        
    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixScaledFigureLocation(graphics);
        label.setForegroundColor(computeForgroundColor());
        super.paint(graphics);
    }

    @Override
    protected void fillShape(Graphics graphics) {
        setTopBackgroundColor(computeTopBackgroundColor());
        super.fillShape(graphics);
    }
        
    @Override
    protected void outlineShape(Graphics graphics) {
        graphics.setForegroundColor(computeForgroundColor());
        if(!selection.isEnabled())
            drawCross(graphics);
        super.outlineShape(graphics);
    }
    
    private void drawCross(Graphics graphics) {
        Rectangle rect = bounds.getCopy().shrink(2, 2);
        graphics.setLineStyle(SWT.LINE_CUSTOM);
        graphics.setLineDash(DrawUtil.getScaledDash(DrawUtil.LINE_DASHED, graphics));
        graphics.drawLine(rect.getTopLeft(), rect.getBottomRight());
        graphics.drawLine(rect.getBottomLeft(), rect.getTopRight());
    }
    
    private Color computeTopBackgroundColor() {
        return selection.isPresent() ? DrawUtil.FEATURE_GRADIENT_COLOR : ColorConstants.white;
    }
    
    private Color computeForgroundColor() {
        return selection.isPresent() ? ColorConstants.black : ColorConstants.lightGray;
    }
    
    // ==================================================================
    //  Events
    // ==================================================================
    
    @Override
    public void add(IFigure figure, Object constraint, int index) {
        if(figure instanceof AttributeValueFigure)
            addAttributeValueFigure(figure, constraint, index);
        else
            super.add(figure, constraint, index);
    }

    @Override
    public void remove(IFigure figure) {
        if(figure instanceof AttributeValueFigure)
            removeAttributeValueFigure(figure);
        else
            super.remove(figure);
    }
    
    private void addAttributeValueFigure(IFigure figure, Object constraint, int index) {
        if(attributeValuesContainer == null)
            initializeAttributesContainer();
        attributeValuesContainer.add(figure, constraint, index);
    }

    private void removeAttributeValueFigure(IFigure figure) {
        attributeValuesContainer.remove(figure);
        if(attributeValuesContainer.getChildren().isEmpty())
            destroyAttributeValuesContainer();
    }

}
