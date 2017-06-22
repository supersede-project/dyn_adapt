package cz.zcu.yafmt.ui.editors.fc;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.provider.util.FeatureConfigurationProviderUtil;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.model.validation.fm.FeatureModelValidator;
import cz.zcu.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.zcu.yafmt.ui.actions.ShowFeatureModelVisualizerAction;
import cz.zcu.yafmt.ui.dialogs.ChoicesDialog;
import cz.zcu.yafmt.ui.dialogs.WorkspaceDialog;
import cz.zcu.yafmt.ui.editors.ModelEditor;
import cz.zcu.yafmt.ui.editors.fc.actions.DeselectFeaturesAction;
import cz.zcu.yafmt.ui.editors.fc.actions.SelectFeaturesAction;
import cz.zcu.yafmt.ui.editors.fc.layout.FeatureConfigurationLayoutHelper;
import cz.zcu.yafmt.ui.editors.fc.layout.HorizontalTreeLayout;
import cz.zcu.yafmt.ui.editors.fc.layout.TreeLayout;
import cz.zcu.yafmt.ui.editors.fc.layout.VerticalTreeLayout;
import cz.zcu.yafmt.ui.editors.fc.parts.FeatureConfigurationEditPartFactory;
import cz.zcu.yafmt.ui.operations.ResourceSaveOperation;

public class FeatureConfigurationEditor extends ModelEditor {

    private FeatureConfigurationLayoutHelper layoutHelper = new FeatureConfigurationLayoutHelper();
    private TreeLayout[] EDITOR_LAYOUTS = { new HorizontalTreeLayout(layoutHelper), new VerticalTreeLayout(layoutHelper) };
    private FeatureConfiguration featureConfig;
    private FeatureConfigurationManager featureConfigManager;

    // ==================================================================================
    //  Basic initialization
    // ==================================================================================
    
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);
        featureConfigManager = new FeatureConfigurationManager(featureConfig, getProblemManager());
    }
        
    // ==================================================================================
    //  Editor initialization
    // ==================================================================================

    @Override
    public void createPartControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());
        createFeatureConfigurationEditor(panel);
        createSettingsPanel(panel);
    }

    private void createFeatureConfigurationEditor(Composite parent) {
        createGraphicalViewer(parent); // Calls configureGraphicalViewer and others bellow.

        GraphicalViewer viewer = getGraphicalViewer();
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        layoutHelper.setGraphicalViewer(viewer);
        setEditorLayout(EDITOR_LAYOUTS[0]);
    }

    private void createSettingsPanel(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(4, false));

        Label layoutLabel = new Label(panel, SWT.NONE);
        layoutLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        layoutLabel.setText("Layout: ");

        Combo layoutCombo = new Combo(panel, SWT.READ_ONLY);
        layoutCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        for(TreeLayout layout: EDITOR_LAYOUTS)
            layoutCombo.add(layout.getName());

        layoutCombo.select(0);
        layoutCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                setEditorLayout(EDITOR_LAYOUTS[index]);
            }
        });
        
        Label visibilityLabel = new Label(panel, SWT.NONE);
        visibilityLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        visibilityLabel.setText("Unselected Features Visibility: ");

        Combo visibilityCombo = new Combo(panel, SWT.READ_ONLY);
        visibilityCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        visibilityCombo.add("Hide All");
        visibilityCombo.add("Show Only Selectable");
        visibilityCombo.add("Show All");
        visibilityCombo.select(1);
        visibilityCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                featureConfigManager.setSelectableFeaturesVisibility(index > 0, index > 1);
            }
        });
    }

    private void setEditorLayout(TreeLayout layout) {
        Object featureConfigEditPart = getGraphicalViewer().getEditPartRegistry().get(featureConfig);
        ((GraphicalEditPart) featureConfigEditPart).getFigure().setLayoutManager(layout);
    }

    // ==================================================================================
    //  Providers
    // ==================================================================================

    @Override
    protected EObject getModel() {
        return featureConfig;
    }

    @Override
    protected EditPartFactory getEditPartFactory() {
        return new FeatureConfigurationEditPartFactory(featureConfigManager);
    }

    @Override
    protected ContextMenuProvider getContextMenuProvider() {
        return new FeatureConfigurationEditorContextMenuProvider(this);
    }

    @Override
    protected ILabelProvider getLabelProvider() {
        return FeatureConfigurationProviderUtil.getLabelProvider();
    }

    @Override
    protected IPropertySourceProvider getPropertySourceProvider() {
        return FeatureConfigurationProviderUtil.getPropertySourceProvider();
    }

    @Override
    protected IContentProvider getContentProvider() {
        return FeatureConfigurationProviderUtil.getContentProvider();
    }

    // ==================================================================================
    //  Actions
    // ==================================================================================

    @Override
    protected void createActions() {
        super.createActions();
        
        createAction(new ShowFeatureModelVisualizerAction());
        createAction(new ExportGraphicalEditorAsImageAction(this) {
            @Override
            protected String getDefaultName() {
                return featureConfig.getName();
            }
        });
    }

    @Override
    protected void createActionsLate() {
        super.createActionsLate();
        
        createAction(new SelectFeaturesAction(this, featureConfigManager));
        createAction(new DeselectFeaturesAction(this, featureConfigManager));
    }

    // ==================================================================================
    //  Save and Load operations
    // ==================================================================================

    @Override
    protected void doLoad(IFileEditorInput input) throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        loadFeatureConfiguration(resourceSet, input.getFile().getFullPath().toString());
        checkFeatureModelExistence(resourceSet);
        checkFeatureModelChanges();
        checkFeatureModelValidity();
    }
    
    private void loadFeatureConfiguration(ResourceSet resourceSet, String path) throws Exception {
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        resource.load(null);
        
        EObject content = resource.getContents().get(0);
        if(!(content instanceof FeatureConfiguration))
            throw new Exception(path + " does not contain valid feature configuration.");
        featureConfig = (FeatureConfiguration) content;
    }
    
    private FeatureModel loadFeatureModel(ResourceSet resourceSet, String path) throws Exception {
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        resource.load(null);
        
        EObject content = resource.getContents().get(0);
        if(!(content instanceof FeatureModel))
            throw new Exception(path + " does not contain valid feature model.");
        return (FeatureModel) content;
    }

    @Override
    protected void doSave() throws Exception {
        executeWorkspaceOperation(new ResourceSaveOperation(featureConfig.eResource()));
    }
        
    // ==================================================================================
    //  Feature Model changes detection and resolution
    // ==================================================================================
    
    private void checkFeatureModelExistence(ResourceSet resourceSet) {
        // Root is null when original feature model was not loaded properly. 
        if(featureConfig.getFeatureModel().getRoot() != null)
            return;
        
        // Ask user for a file.
        Shell shell = getSite().getShell();
        String inputName = getEditorInput().getName();
        if(!MessageDialog.openQuestion(shell, inputName, "The original feature model was not found!\nWould you like to change its location?"))
            return;
        
        // Let user to choose a file.
        String path = WorkspaceDialog.openFile(shell, "Feature Model Selection", "Select feature model new localtion.");
        if(path == null)
            return;
        
        try {
            featureConfig.setFeatureModel(loadFeatureModel(resourceSet, path));
            doSave(null);
        }
        catch(Exception ex) {
            MessageDialog.openError(shell, "Unable to load " + path, ex.getMessage());
        }
    }

    private void checkFeatureModelChanges() {
        // Root is null when the original feature model was not loaded properly.
        if(featureConfig.getFeatureModel().getRoot() == null)
            return;
        
        // Look for changes in the original feature model.
        if(FeatureModelUtil.compareFeatureModels(featureConfig.getFeatureModel(), featureConfig.getFeatureModelCopy(), false))
            return;
        
        // The original feature model was changed. Check if the new version is valid. 
        boolean isValid = FeatureModelValidator.INSTANCE.validateRecursive(featureConfig.getFeatureModel(), new BasicDiagnostic());
        
        // Ask user for what to do.
        Shell shell = getSite().getShell();
        String inputName = getEditorInput().getName();
        String question = "The original feature model was changed.";
        if(!isValid)
            question += "\nThe new version contains validation errors!";
        String[] choices = { "Ignore changes.", "Merge changes automatically." };
        int answer = ChoicesDialog.openChoices(shell, inputName, question, choices, !isValid);
        if(answer == 1) {
            // Just copy the new version of feature model.
            // Changes are merged in the FeatureConfigurationManager (see FeatureConfigurationUtil.repair*() methods).
            featureConfig.setFeatureModelCopy(EcoreUtil.copy(featureConfig.getFeatureModel()));
            doSave(null);
        }
    }
        
    private void checkFeatureModelValidity() {
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validateRecursive(featureConfig.getFeatureModelCopy(), diagnostic)) {
            MultiStatus status = new MultiStatus(FeatureConfigurationEditorPlugin.PLUGIN_ID, IStatus.WARNING, "The feature model contains validation errors!", null);
            for(Diagnostic child: diagnostic.getChildren())
                status.add(new Status(IStatus.ERROR, FeatureConfigurationEditorPlugin.PLUGIN_ID, child.getMessage()));
            ErrorDialog.openError(getSite().getShell(), "Warning", null, status);
        }
    }

    // ==================================================================================
    //  Adapters
    // ==================================================================================

    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == FeatureConfiguration.class)
            return featureConfig;
        if(type == FeatureModel.class)
            return featureConfig.getFeatureModelCopy();
        return super.getAdapter(type);
    }

}
