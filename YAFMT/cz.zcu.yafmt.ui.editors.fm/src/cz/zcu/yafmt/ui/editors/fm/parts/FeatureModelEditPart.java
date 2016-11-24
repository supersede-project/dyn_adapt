package cz.zcu.yafmt.ui.editors.fm.parts;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE_MODEL__NAME;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.validation.fm.FeatureModelValidator;
import cz.zcu.yafmt.ui.editors.fm.commands.ApplyVerticalTreeLayoutCommand;
import cz.zcu.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.zcu.yafmt.ui.editors.fm.figures.FeatureModelFigure;
import cz.zcu.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.policies.FeatureModelEditPolicy;
import cz.zcu.yafmt.ui.editors.fm.policies.FeatureModelLayoutPolicy;
import cz.zcu.yafmt.ui.util.DelayedRunner;
import cz.zcu.yafmt.ui.validation.IProblemManager;

public class FeatureModelEditPart extends AbstractGraphicalEditPart {

    private FeatureModel featureModel;
    private LayoutData layoutData;
    private ConstraintCache constraintCache;
    private IProblemManager problemManager;
    private Adapter featureModelAdapter;
    private Adapter layoutDataAdapter;
    
    public FeatureModelEditPart(FeatureModel featureModel, LayoutData layoutData, ConstraintCache constraintCache, IProblemManager problemManager) {
        this.featureModel = featureModel;
        this.layoutData = layoutData;
        this.constraintCache = constraintCache;
        this.problemManager = problemManager;
        this.featureModelAdapter = new FeatureModelAdapter();
        this.layoutDataAdapter = new LayoutDataAdapter();
        setModel(featureModel);
    }
    
    // ===================================================================
    //  Initialization
    // ===================================================================
    
    @Override
    public void activate() {
        // Check if there is a layout (just for the root feature)
        boolean noLayout = layoutData.get(featureModel.getRoot()) == null;
        
        // Adapters must be registered before children parts activation!
        featureModel.eAdapters().add(featureModelAdapter);
        layoutData.eAdapters().add(layoutDataAdapter);
        super.activate();
        revalidateModel();
        
        // Recover layout if it does not exist.
        if(noLayout) {
            Command autoLayoutCommand = new ApplyVerticalTreeLayoutCommand(featureModel, layoutData);
            autoLayoutCommand.execute();
        }
        
        getFigure().addLayoutListener(LayoutAnimator.getDefault());
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        refreshFeatureFiguresConstraintMarker();
    }

    @Override
    public void deactivate() {
        getFigure().removeLayoutListener(LayoutAnimator.getDefault());
        problemManager.clearProblems(featureModel);
        featureModel.eAdapters().remove(featureModelAdapter);
        layoutData.eAdapters().remove(layoutDataAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    public boolean isSelectable() {
        return false; // Must not be selectable by the marquee selection tool.
    }
    
    @Override
    protected IFigure createFigure() {
        return new FeatureModelFigure();
    }

    @Override
    protected void refreshVisuals() {
        // Enable antialiasing for connection layer.
        // Antialiasing for other layers is enabled in FeatureModelFigure.
        ((ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER)).setAntialias(SWT.ON);
    }
    
    private void refreshFeatureFigureOrphanedState(Feature feature) {
        GraphicalEditPart editPart = getEditPartForObject(feature);
        if(editPart == null)
            return;

        FeatureFigure figure = ((FeatureEditPart) editPart).getFigure(); 
        figure.setOrphaned(feature.isOrphan());
    }

    private void refreshFeatureFiguresConstraintMarker() {
        Collection<Feature> features = constraintCache.getFeaturesAffectedByConstraint();
        Set<Feature> set = (features instanceof Set<?>) ? (Set<Feature>) features : new HashSet<Feature>(features);
        
        for(Object editPart: getChildren()) {
            if(editPart instanceof FeatureEditPart) {
                Feature feature = (Feature) ((FeatureEditPart) editPart).getModel();
                FeatureFigure figure = ((FeatureEditPart) editPart).getFigure(); 
                figure.setConstrained(set.contains(feature));
            }
        }
    }
        
    public void refreshGroupFigure(Group group) {
        GraphicalEditPart editPart = getEditPartForObject(group);
        if(editPart == null)
            return;
        
        GroupFigure figure = ((GroupEditPart) editPart).getFigure();
        figure.refresh();
        figure.repaint();
    }
    
    // ===================================================================
    //  Layout
    // ===================================================================
   
    public LayoutData getLayoutData() {
        return layoutData;
    }
    
    private void layoutDataChanged(Object notifier) {
        if(!(notifier instanceof Map.Entry<?, ?>))
            return;

        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) notifier;
        Object object = entry.getKey();
        Object constraint = entry.getValue();

        GraphicalEditPart editPart = getEditPartForObject(object);
        if(editPart == null)
            return;
            
        setLayoutConstraint(editPart, editPart.getFigure(), constraint);
        
        // Update group figure when the group or one of its children features moved.
        if(object instanceof Group)
            refreshGroupFigure((Group) object);
        else if(object instanceof Feature)
            refreshGroupFigure(((Feature) object).getParentGroup());
    }
    
    // ===================================================================
    //  Model
    // ===================================================================
    
    private void revalidateModel() {
        problemManager.clearProblems(featureModel);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(featureModel, diagnostic))
            problemManager.addProblems(diagnostic);
    }
    
    @Override
    protected List<Object> getModelChildren() {
        List<Object> modelChildren = new ArrayList<Object>();

        // Groups go before features. This order is used for rendering objects.
        TreeIterator<EObject> it = featureModel.eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Group)
                modelChildren.add(object);
        }

        // Features go after groups.
        it = featureModel.eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Feature)
                modelChildren.add(object);
        }

        return modelChildren;
    }
    
    // ===================================================================
    //  Children edit parts
    // ===================================================================
    
    private GraphicalEditPart getEditPartForObject(Object object) {
        return (GraphicalEditPart) getViewer().getEditPartRegistry().get(object);
    }

    private void addEditPartForObject(Object object) {
        // Create edit part only of it does not exist yet.
        if(getEditPartForObject(object) == null) {
            // Groups go before features. This order is used for rendering objects.
            if(object instanceof Group)
                addChild(createChild(object), 0);
            else if(object instanceof Feature)
                addChild(createChild(object), getChildren().size());
        }
        
        // Must be called even in case edit part already exists.
        if(object instanceof Feature)
            refreshFeatureFigureOrphanedState((Feature) object);
    }

    private void removeEditPartForObject(Object object) {
        // Ignore non-existing edit parts.
        // Do not remove edit parts when they are still present in model.
        // This situation usually happens when feature parent was changed,
        // but the feature is still present in model.
        EditPart editPart = getEditPartForObject(object);
        if((editPart != null) && (((EObject) object).eContainer() == null))
            removeChild(editPart);
    }
    
    // ===================================================================
    //  Policies
    // ===================================================================
    
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureModelLayoutPolicy());
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureModelEditPolicy());
        installEditPolicy("Snap Feedback", new SnapFeedbackPolicy()); // Policy for 'snap to grid' and 'snap to geometry' functions.
    }
        
    // ===================================================================
    //  Events
    // ===================================================================
    
    class FeatureModelAdapter extends EContentAdapter {
        
        private DelayedRunner delayedRunner = new DelayedRunner();

        @Override
        protected void addAdapter(Notifier notifier) {
            if(notifier instanceof Attribute)
                return;
            
            super.addAdapter(notifier);
            if((notifier instanceof Feature) || (notifier instanceof Group))
                addEditPartForObject(notifier);
        }
        
        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
            if((notifier instanceof Feature) || (notifier instanceof Group))
                removeEditPartForObject(notifier);
        }
        
        @Override
        public void notifyChanged(Notification msg) {
            super.notifyChanged(msg);
            
            Object notifier = msg.getNotifier();
            if((notifier instanceof FeatureModel) && (msg.getFeatureID(FeatureModel.class) == FEATURE_MODEL__NAME))
                revalidateModel();

            delayedRunner.run(500, new Runnable() {
                @Override
                public void run() {
                    refreshFeatureFiguresConstraintMarker();
                }
            });
        }
        
    }

    class LayoutDataAdapter extends EContentAdapter {

        @Override
        public void notifyChanged(Notification msg) {
            super.notifyChanged(msg);

            switch(msg.getEventType()) {
                case Notification.ADD:
                    layoutDataChanged(msg.getNewValue());
                    break;

                case Notification.SET:
                    layoutDataChanged(msg.getNotifier());
                    break;
            }
        }

    }
    
    // ===================================================================
    //  Adapters
    // =================================================================== 
    
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        // Helper for 'snap to grid' and 'snap to geometry' functions. 
        if(type == SnapToHelper.class) {
            List<SnapToHelper> helpers = new ArrayList<SnapToHelper>(2);
            if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED)))
                helpers.add(new SnapToGeometry(this));
            if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED)))
                helpers.add(new SnapToGrid(this));
            if(helpers.size() == 0)
                return null;
            else
                return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[helpers.size()]));
        }
        return super.getAdapter(type);
    }

}
