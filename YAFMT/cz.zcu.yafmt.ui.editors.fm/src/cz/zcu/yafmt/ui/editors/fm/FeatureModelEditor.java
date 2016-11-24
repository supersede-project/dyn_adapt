package cz.zcu.yafmt.ui.editors.fm;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.provider.util.FeatureModelProviderUtil;
import cz.zcu.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.zcu.yafmt.ui.actions.ShowFeatureModelVisualizerAction;
import cz.zcu.yafmt.ui.actions.ShowPropertiesAction;
import cz.zcu.yafmt.ui.editors.ModelEditor;
import cz.zcu.yafmt.ui.editors.fm.actions.ApplyLayoutAction;
import cz.zcu.yafmt.ui.editors.fm.actions.DeleteAction;
import cz.zcu.yafmt.ui.editors.fm.actions.GenerateIdFromNameAction;
import cz.zcu.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.zcu.yafmt.ui.editors.fm.actions.SelectAllAction;
import cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureOptimalSizeAction;
import cz.zcu.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataFactory;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage;
import cz.zcu.yafmt.ui.editors.fm.parts.FeatureModelEditPartFactory;
import cz.zcu.yafmt.ui.operations.ResourceSaveOperation;
import cz.zcu.yafmt.ui.widgets.Splitter;

public class FeatureModelEditor extends ModelEditor {

    private static final String LAYOUT_DATA_EXTENSION = ".layout";

    private FeatureModel featureModel;
    private LayoutData layoutData;
    private ConstraintsEditor constraintsEditor;
    private ConstraintCache constraintCache;
    private IContentOutlinePage contentOutlinePage;
    
    // ==================================================================================
    //  Basic initialization
    // ==================================================================================
    
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);
        getProblemManager().clearProblems(); // Revalidation occurs when edit parts are created.
    }
    
    public void dispose() {
        if(constraintsEditor != null) // When input cannot be loaded.
            getSite().getPage().removeSelectionListener(constraintsEditor);
        super.dispose();
    }
    
    // ==================================================================================
    //  Editor initialization
    // ==================================================================================

    @Override
    public void createPartControl(Composite parent) {
        Splitter splitter = new Splitter(parent);
        createFeatureTreeEditor(splitter);
        createConstraintsEditor(splitter);
    }
    
    private void createFeatureTreeEditor(Composite parent) {
        super.createPartControl(parent); // Calls configureGraphicalViewer and others bellow.
        
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
        viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
    }

    private void createConstraintsEditor(Splitter splitter) {
        constraintsEditor = new ConstraintsEditor(splitter, this);
        constraintsEditor.getViewer().addSelectionChangedListener(getSelectionProvider());
        getSite().getPage().addSelectionListener(constraintsEditor);
    }

    // ==================================================================================
    //  Providers
    // ==================================================================================

    @Override
    protected EObject getModel() {
        return featureModel;
    }

    @Override
    protected EditPartFactory getEditPartFactory() {
        return new FeatureModelEditPartFactory(this);
    }

    @Override
    protected ContextMenuProvider getContextMenuProvider() {
        return new FeatureModelEditorContextMenuProvider(this);
    }

    @Override
    protected ILabelProvider getLabelProvider() {
        return FeatureModelProviderUtil.getLabelProvider();
    }

    @Override
    protected IPropertySourceProvider getPropertySourceProvider() {
        return FeatureModelProviderUtil.getPropertySourceProvider();
    }

    @Override
    protected IContentProvider getContentProvider() {
        return FeatureModelProviderUtil.getContentProvider();
    }

    // ==================================================================================
    //  Palette initialization
    // ==================================================================================

    @Override
    protected PaletteRoot getPaletteRoot() {
        return new FeatureModelEditorPaletteRoot();
    }

    @Override
    protected PaletteViewerProvider createPaletteViewerProvider() {
        return new PaletteViewerProvider(getEditDomain()) {
            @Override
            protected void configurePaletteViewer(PaletteViewer viewer) {
                super.configurePaletteViewer(viewer);
                // Add drag and drop support for palette.
                viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
            }
        };
    }

    @Override
    protected FlyoutPreferences getPalettePreferences() {
        FlyoutPreferences preferences = super.getPalettePreferences();
        preferences.setDockLocation(PositionConstants.WEST);
        preferences.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
        preferences.setPaletteWidth(150);
        return preferences;
    }

    // ==================================================================================
    //  Actions
    // ==================================================================================

    @Override
    protected void createActions() {
        super.createActions();
        createAction(new DeleteAction(this));    // Custom delete action.
        createAction(new SelectAllAction(this)); // Custom select all action.
        createAction(new SetFeatureCardinalityAction(this, false));
        createAction(new SetFeatureCardinalityAction(this, true));
        createAction(new GenerateIdFromNameAction(this));
        createAction(new GroupFeaturesAction(this, true));
        createAction(new GroupFeaturesAction(this, false));
        createAction(new UngroupFeaturesAction(this));
        createAction(new ApplyLayoutAction(this));
        createAction(new SetFeatureOptimalSizeAction(this));
        createAction(new ShowFeatureModelVisualizerAction());
        createAction(new ShowPropertiesAction());
        createAction(new ExportGraphicalEditorAsImageAction(this) {
            @Override
            protected String getDefaultName() {
                return featureModel.getName();
            }
        });
    }
    
    @Override
    protected void createActionsLate() {
        super.createActionsLate();
        createAction(new ToggleGridAction(getGraphicalViewer()));
        createAction(new ToggleSnapToGeometryAction(getGraphicalViewer()));
    }
    
    // ==================================================================================
    //  Markers
    // ==================================================================================
    
    @Override
    protected void gotoMarker(List<Object> markerObjects) {
        super.gotoMarker(markerObjects);
        constraintsEditor.selectionChanged(this, new StructuredSelection(markerObjects));
    }
    
    // ==================================================================================
    //  Save and Load operations
    // ==================================================================================

    @Override
    protected void doLoad(IFileEditorInput input) throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        String path = input.getFile().getFullPath().toString();
        loadFeatureModel(resourceSet, path);
        loadLayoutData(resourceSet, path);
    }

    private void loadFeatureModel(ResourceSet resourceSet, String path) throws Exception {
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        resource.load(null);
        
        EObject content = resource.getContents().get(0);
        if(!(content instanceof FeatureModel))
            throw new Exception(path + " does not contain valid feature model.");
        
        featureModel = (FeatureModel) resource.getContents().get(0);
        constraintCache = new ConstraintCache(featureModel);
    }

    private void loadLayoutData(ResourceSet resourceSet, String featureModelPath) {
        LayoutDataPackage.eINSTANCE.eClass(); // For package registration.
        String path = featureModelPath + LAYOUT_DATA_EXTENSION;
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));

        try {
            resource.load(createModelLayoytLoadSaveOptions());
            layoutData = (LayoutData) resource.getContents().get(0);
        }
        catch(IOException ex) {
            layoutData = LayoutDataFactory.eINSTANCE.createLayoutData();
            resource.getContents().add(layoutData);
        }
    }

    @Override
    protected void doSave() throws Exception {
        executeWorkspaceOperation(new ResourceSaveOperation(featureModel.eResource()));
        executeWorkspaceOperation(new ResourceSaveOperation(layoutData.eResource(), createModelLayoytLoadSaveOptions()));
    }

    @Override
    protected void setInputWithNotify(IEditorInput input) {
        super.setInputWithNotify(input);

        // Called during save as operation.
        String path = ((IFileEditorInput) input).getFile().getFullPath().toString();
        featureModel.eResource().setURI(URI.createPlatformResourceURI(path, true));
        layoutData.eResource().setURI(URI.createPlatformResourceURI(path + LAYOUT_DATA_EXTENSION, true));
    }

    private Map<Object, Object> createModelLayoytLoadSaveOptions() {
        Map<Object, Object> options = new HashMap<Object, Object>();
        // Ignore and discard all dangling references.
        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
        return options;
    }
    
    // ==================================================================================
    //  Adapters
    // ==================================================================================

    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == IContentOutlinePage.class) {
            if(contentOutlinePage == null)
                contentOutlinePage = new FeatureModelEditorContentOutlinePage(this);
            return contentOutlinePage;
        }
        
        if(type == FeatureModel.class)
            return featureModel;
        if(type == LayoutData.class)
            return layoutData;
        if(type == ConstraintCache.class)
            return constraintCache;
        
        return super.getAdapter(type);
    }

}
