package cz.zcu.yafmt.ui.editors.fm.parts;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__ID;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__DESCRIPTION;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__NAME;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__TYPE;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.model.validation.fm.FeatureModelValidator;
import cz.zcu.yafmt.ui.directediting.ComboDirectEditManager;
import cz.zcu.yafmt.ui.directediting.LabelDirectEditManager;
import cz.zcu.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.zcu.yafmt.ui.editors.fm.policies.AttributeDirectEditPolicy;
import cz.zcu.yafmt.ui.editors.fm.policies.AttributeEditPolicy;
import cz.zcu.yafmt.ui.editors.fm.util.AttributeTypeCellEditor;
import cz.zcu.yafmt.ui.validation.IProblemManager;

public class AttributeEditPart extends AbstractGraphicalEditPart {

    private Attribute attribute;
    private Adapter attributeAdapter;
    private IProblemManager problemManager;

    public AttributeEditPart(Attribute attribute, IProblemManager problemManager) {
        this.attribute = attribute;
        this.attributeAdapter = new AttributeAdapter();
        this.problemManager = problemManager;
        setModel(attribute);
    }

    // ===================================================================
    //  Initialization
    // ===================================================================
    
    @Override
    public void activate() {
        super.activate();
        attribute.eAdapters().add(attributeAdapter);
        revalidateModel();
        refreshVisuals();
    }

    @Override
    public void deactivate() {
        problemManager.clearProblems(attribute);
        attribute.eAdapters().remove(attributeAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    protected IFigure createFigure() {
        return new AttributeFigure(attribute);
    }
    
    public AttributeFigure getFigure() {
        return (AttributeFigure) super.getFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        AttributeFigure figure = getFigure();
        figure.setErrors(problemManager.getMessages(attribute));
        figure.refresh();
    }
    
    // ===================================================================
    //  Model
    // ===================================================================
    
    private void revalidateModel() {
        problemManager.clearProblems(attribute);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(attribute, diagnostic))
            problemManager.addProblems(diagnostic);
    }
    
    // ===================================================================
    //  Policies and requests
    // ===================================================================

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new AttributeEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new AttributeDirectEditPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType()))
            performDirectEditing(((SelectionRequest) request).getLocation());
    }

    private void performDirectEditing(Point mouseLocation) {
        double scale = ((ScalableFreeformRootEditPart) getRoot()).getZoomManager().getZoom();
        AttributeFigure figure = getFigure();
        Rectangle figureBounds = figure.getBounds().getCopy();
        figure.translateToAbsolute(figureBounds);
        
        String attributeName = attribute.getName();
        AttributeType attributeType = attribute.getType();
        int attributeNameWidth = TextUtilities.INSTANCE.getStringExtents(attributeName + ": ", figure.getFont()).width;
        int attributeTypeX = figureBounds.x + (int) (scale * attributeNameWidth);
        int mouseX = mouseLocation.x;
        
        LabelDirectEditManager manager = null;
        
        if(mouseX <= attributeTypeX) {
            // Name direct edit
            manager = new LabelDirectEditManager(this, figure, attributeName);
            manager.setErrorMessageProvider(new ICellEditorValidator() {
                @Override
                public String isValid(Object value) {
                    return ((String) value).isEmpty() ? "Attribute name cannot be empty." : null;
                }
            });
        }
        else {
            // Type direct edit.
            manager = new ComboDirectEditManager(this, AttributeTypeCellEditor.class, figure, attributeType);
            manager.setXOffset(attributeNameWidth); // Offset must not be scaled
        }
        
        manager.setAlignment(SWT.LEFT | SWT.CENTER);
        manager.show();
    }
    
    // ===================================================================
    //  Events
    // ===================================================================

    protected class AttributeAdapter extends AdapterImpl {

        @Override
        public void notifyChanged(Notification msg) {
            switch(msg.getFeatureID(Attribute.class)) {
                case ATTRIBUTE__ID:
                case ATTRIBUTE__NAME:
                    revalidateModel();
                    refreshVisuals();
                    break;
                    
                case ATTRIBUTE__TYPE:
                case ATTRIBUTE__DESCRIPTION:
                    refreshVisuals();
                    break;
            }
        }
        
    }

}
