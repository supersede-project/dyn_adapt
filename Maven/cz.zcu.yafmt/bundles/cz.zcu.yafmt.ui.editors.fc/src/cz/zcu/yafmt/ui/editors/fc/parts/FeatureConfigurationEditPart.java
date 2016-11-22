package cz.zcu.yafmt.ui.editors.fc.parts;

import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.validation.fc.FeatureConfigurationValidator;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.zcu.yafmt.ui.editors.fc.IFeatureConfigurationListener;
import cz.zcu.yafmt.ui.editors.fc.figures.FeatureConfigurationFigure;
import cz.zcu.yafmt.ui.validation.IProblemManager;

public class FeatureConfigurationEditPart extends AbstractGraphicalEditPart {

    private FeatureConfigurationManager featureConfigManager;
    private FeatureConfigurationAdapter featureConfigAdapter;
    private FeatureConfiguration featureConfig;

    public FeatureConfigurationEditPart(FeatureConfigurationManager featureConfigManager, FeatureConfiguration featureConfig) {
        this.featureConfigManager = featureConfigManager;
        this.featureConfig = featureConfig;
        this.featureConfigAdapter = new FeatureConfigurationAdapter();
        setModel(featureConfig);
    }
    
    // ===================================================================
    //  Initialization
    // ===================================================================

    @Override
    public void activate() {
        super.activate();
        featureConfig.eAdapters().add(featureConfigAdapter);
        featureConfigManager.addFeatureConfigurationListener(featureConfigAdapter);
    }

    @Override
    public void deactivate() {
        featureConfigManager.removeFeatureConfigurationListener(featureConfigAdapter);
        featureConfig.eAdapters().add(featureConfigAdapter);
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
        return new FeatureConfigurationFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        // Enable antialiasing for connection layer.
        // Antialiasing for other layers is enabled in FeatureModelFigure.
        ((ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER)).setAntialias(SWT.ON);
    }
    
    // ===================================================================
    //  Model
    // ===================================================================
    
    private void revalidateModel() {
        IProblemManager problemManager = featureConfigManager.getProblemStore();
        problemManager.clearProblems(featureConfig);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureConfigurationValidator.INSTANCE.validate(featureConfig, diagnostic))
            problemManager.addProblems(diagnostic);        
    }
    
    private void refreshModel() {
        refresh();
        for(Object child: getChildren())
            ((EditPart) child).refresh();
        getFigure().getLayoutManager().layout(getFigure()); // We need to refresh connection anchors.
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelChildren() {
        List<Selection> modelChildren = new ArrayList<Selection>();
        modelChildren.add(featureConfig.getRoot());
        contributeModelChildren(modelChildren, featureConfig.getRoot());
        return modelChildren;
    }

    private void contributeModelChildren(List<Selection> modelChildren, Selection selection) {
        featureConfigManager.contributeChildrenSelections(selection, modelChildren, false);
        for(Selection childSelection: selection.getSelections())
            contributeModelChildren(modelChildren, childSelection);
    }
    
    // ===================================================================
    //  Policies
    // ===================================================================

    @Override
    protected void createEditPolicies() {
    }
    
    // ===================================================================
    //  Events
    // ===================================================================
    
    private class FeatureConfigurationAdapter extends AdapterImpl implements IFeatureConfigurationListener {
        
        @Override
        public void notifyChanged(Notification msg) {
            switch(msg.getFeatureID(FeatureConfiguration.class)) {
                case FEATURE_CONFIGURATION__NAME:
                    revalidateModel();
                    break;
            }
        }
        
        @Override
        public void featuresSelected(List<Selection> selections) {
            refreshModel();
        }

        @Override
        public void featuresDeselected(List<Selection> selections) {
            refreshModel();
        }
        
    }

}
