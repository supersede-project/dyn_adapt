package cz.zcu.yafmt.ui.views.fm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil.TreeInfo;
import cz.zcu.yafmt.ui.util.DelayedRunner;
import cz.zcu.yafmt.ui.util.SWTUtil;
import cz.zcu.yafmt.ui.views.fm.filters.ConstraintFilter;
import cz.zcu.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.zcu.yafmt.ui.views.fm.filters.GroupFilter;
import cz.zcu.yafmt.ui.views.fm.graph.DecoratableGraphViewer;
import cz.zcu.yafmt.ui.views.fm.graph.LayoutAlgorithmAnimator;
import cz.zcu.yafmt.ui.views.fm.settings.ISettingsListener;
import cz.zcu.yafmt.ui.views.fm.settings.Settings;
import cz.zcu.yafmt.ui.views.fm.util.ConvertingSelectionProvider;
import cz.zcu.yafmt.ui.views.fm.util.SelectionConverter;

public class FeatureModelVisualizer extends ViewPart implements ISelectionListener,
                                                                IPartListener,
                                                                ISettingsListener,
                                                                IContributedContentsView {

    private static final int CONNECTION_LENGHT = 200;
    private static final int MAX_VISIBLE_NODES = 100;

    private IWorkbenchPart sourcePart;
    private FeatureModel featureModel;
    private FeatureConfiguration featureConfig;
    private FeatureModelAdapter featureModelAdapter;
    private ConstraintCache constraintCache;
    
    private Settings settings;
    private TreeInfo treeInfo; // Contains size and height of the current feature model tree.

    private DecoratableGraphViewer viewer;
    private DistanceFilter distanceFilter;
    private GroupFilter groupFilter;
    private ConstraintFilter constraintFilter;
    private ISelection currentSelection; // Viewer may not contain all selected elements, so we have to remember them.
    private DelayedRunner refreshDelayedRunner;
    private DelayedRunner resizeDelayedRunner;

    // ===========================================================================
    //  Initialization
    // ===========================================================================

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        featureModelAdapter = new FeatureModelAdapter();
        constraintCache = new ConstraintCache();
        treeInfo = new TreeInfo();
        currentSelection = StructuredSelection.EMPTY;
        settings = new Settings();
        settings.addSettingsListener(this);
        settings.init(FeatureModelVisualizerPlugin.getAccess().getDialogSettings());
        refreshDelayedRunner = new DelayedRunner();
        resizeDelayedRunner = new DelayedRunner();

        site.getPage().addPartListener(this);
        site.getPage().addSelectionListener(this);
    }

    @Override
    public void dispose() {
        settings.save(FeatureModelVisualizerPlugin.getAccess().getDialogSettings());
        settings.removeSettingsListener(this);
        setSourcePart(null);

        getSite().getPage().removeSelectionListener(this);
        getSite().getPage().removePartListener(this);
        getSite().setSelectionProvider(null);

        super.dispose();
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    // ===========================================================================
    //  Viewer and control creation 
    // ===========================================================================

    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(1, false));
        createGraphViewerControl(parent);
        settings.createControl(parent);

        // Try to load active editor input.
        setSourcePart(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());

        distanceFilter.update(StructuredSelection.EMPTY, featureModel);
        groupFilter.update(StructuredSelection.EMPTY);
        constraintFilter.update(StructuredSelection.EMPTY, featureModel);

        viewer.refresh();
        viewer.applyLayout();

        parent.addControlListener(new ControlAdapter() {
            @Override
            public void controlResized(ControlEvent event) {
                if(!settings.isFixedSize()) {
                    resizeDelayedRunner.run(1000, new Runnable() {
                        @Override
                        public void run() {
                            resizeGraphView();
                            viewer.applyLayout();
                        }
                    });
                }
            }
        });
    }

    private void createGraphViewerControl(Composite parent) {
        distanceFilter = new DistanceFilter(constraintCache, settings.getVisibleDistance());
        groupFilter = new GroupFilter(settings.areGroupsVisible());
        constraintFilter = new ConstraintFilter(constraintCache, settings.areConstraintsVisible());

        // Do not enable hash lookup. It causes invalidation of current selection during graph refresh.
        viewer = new DecoratableGraphViewer(parent, ZestStyles.NONE);
        viewer.setContentProvider(new FeatureModelContentProvider());
        viewer.setLabelProvider(new FeatureModelStyleProvider(viewer, constraintCache));
        viewer.setLayoutAlgorithm(new LayoutAlgorithmAnimator(viewer, settings, new FeatureModelLayoutAlgorithm()));
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        viewer.setNodeStyle(settings.isAnimationEnabled() ? ZestStyles.NONE : ZestStyles.NODES_NO_ANIMATION);
        viewer.setFilters(new ViewerFilter[] { distanceFilter, groupFilter, constraintFilter });
        viewer.setDecorationSelectionProvider(new DecorationSelectionProvider());
        viewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                refreshAll(event.getSelection());
            }
        });

        SWTUtil.enableAntialiasing(viewer.getControl()); // Enable antialiasing on Windows.
        getSite().setSelectionProvider(new ConvertingSelectionProvider(viewer));
    }

    // ===========================================================================
    //  Settings change callbacks
    // ===========================================================================

    @Override
    public void groupsVisibilityChanged(boolean groupsVisible) {
        groupFilter.setEnabled(groupsVisible);
        groupFilter.update(viewer.getSelection());
        viewer.refresh();
        viewer.applyLayout();
    }

    @Override
    public void constraintsVisibilityChanged(boolean constraintsVisible) {
        constraintFilter.setEnabled(constraintsVisible);
        constraintFilter.update(viewer.getSelection(), featureModel);
        viewer.refresh();
        viewer.applyLayout();
    }

    @Override
    public void animationStateChanged(boolean animationEnabled, int animationTime) {
        viewer.setInput(null); // Style can be only changed when input is not set.
        viewer.setNodeStyle(animationEnabled ? ZestStyles.NONE : ZestStyles.NODES_NO_ANIMATION);
        viewer.setInput(featureModel);
    }

    @Override
    public void lockedStateChanged(boolean viewLocked) {
    }

    @Override
    public void visibleDistanceChanged(int visibleDistance, boolean userInput) {
        distanceFilter.setDistance(visibleDistance);
        distanceFilter.update(viewer.getSelection(), featureModel);
        
        if(userInput) {
            viewer.refresh();
            viewer.applyLayout();
        }
    }

    @Override
    public void viewSizeChanged(boolean fixedSize, int sizeMultiplier) {
        resizeGraphView();
        viewer.applyLayout();
    }

    // ===========================================================================
    //  Input handling
    // ===========================================================================

    private void setSourcePart(IWorkbenchPart part) {
        if(part == sourcePart)
            return;

        FeatureModel newFeatureModel = null;
        FeatureConfiguration newFeatureConfig = null;
        
        if(part != null) {
            newFeatureModel = (FeatureModel) part.getAdapter(FeatureModel.class);
            newFeatureConfig = (FeatureConfiguration) part.getAdapter(FeatureConfiguration.class);
            
            if((newFeatureModel == null) && (newFeatureConfig != null))
                newFeatureModel = newFeatureConfig.getFeatureModelCopy();
            if(newFeatureModel == null)
                return;
        }
        
        sourcePart = part;
        setInput(newFeatureModel, newFeatureConfig);
    }

    private void setInput(FeatureModel newFeatureModel, FeatureConfiguration newFeatureConfig) {
        if((newFeatureModel == featureModel) && (newFeatureConfig == featureConfig))
            return;
        
        if(featureModel != null) {
            featureModel.eAdapters().remove(featureModelAdapter);
            constraintCache.dispose();
        }

        featureModel = newFeatureModel;
        featureConfig = newFeatureConfig;
        ((ConvertingSelectionProvider) getSite().getSelectionProvider()).setFeatureConfiguration(featureConfig);
        
        if(!viewer.getControl().isDisposed()) {
            viewer.setInput(featureModel);
            currentSelection = StructuredSelection.EMPTY;
            recomputeTreeInfo();
            resizeGraphView();
        }

        if(featureModel != null) {
            constraintCache.setFeatureModel(newFeatureModel); // Must be called before!
            featureModel.eAdapters().add(featureModelAdapter);
        }
    }
    
    private void recomputeTreeInfo() {
        treeInfo = FeatureModelUtil.analyzeTree(featureModel);
        settings.setInfiniteVisibleDistanceEnabled(treeInfo.size <= MAX_VISIBLE_NODES);
    }

    private void resizeGraphView() {
        if(settings.isFixedSize()) {
            int height = Math.min(treeInfo.height, 1);
            int size = 2 * height * CONNECTION_LENGHT * settings.getSizeMultiplier();
            viewer.getGraphControl().setPreferredSize(size, size);
        }
        else {
            viewer.getGraphControl().setPreferredSize(-1, -1);
        }
    }
    
    private void refreshAll(ISelection selection) {
        distanceFilter.update(selection, featureModel);
        groupFilter.update(selection);
        constraintFilter.update(selection, featureModel);
        ((FeatureModelStyleProvider) viewer.getLabelProvider()).refresh(selection);
        viewer.refresh();
        viewer.applyLayout();
    }

    // ===========================================================================
    //  Event handling
    // ===========================================================================

    @Override
    public IWorkbenchPart getContributingPart() {
        // This make the property sheet view working.
        // PropertySheet takes via this method the workbench part which content should display.
        return sourcePart;
    }

    @Override
    public void selectionChanged(final IWorkbenchPart part, ISelection originalSelection) {
        // Ignore invalid selections.
        IWorkbenchPart activePart = getSite().getPage().getActivePart();
        if((part != activePart) || (part == this) || (part instanceof PropertySheet))
            return;

        final ISelection selection = SelectionConverter.toFeatureModelSelection(originalSelection);
        if(selection == null)
            return;

        refreshDelayedRunner.run(50, new Runnable() {
            @Override
            public void run() {
                if(viewer.getControl().isDisposed())
                    return;
                
                setSourcePart(part);

                if(!currentSelection.equals(selection)) {
                    currentSelection = selection; // Viewer may not contain all selected elements, so we have to remember them.

                    if(!settings.isViewLocked())
                        refreshAll(selection);

                    viewer.setSelection(selection);
                    if(settings.isViewLocked())
                        viewer.moveViewportToSelection(selection); // Do not move viewport when layout animation is in progress!
                }
            }
        });
    }
    
    @Override
    public void partActivated(IWorkbenchPart part) {
        if(part.getAdapter(FeatureModel.class) != null)
            setSourcePart(part);
    }
    
    @Override
    public void partClosed(IWorkbenchPart part) {
        if(part == sourcePart)
            setSourcePart(null);
    }

    @Override
    public void partOpened(IWorkbenchPart part) {
    }

    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
    }

    @Override
    public void partDeactivated(IWorkbenchPart part) {
    }

    // ===========================================================================
    //  Model changes handling
    // ===========================================================================

    class FeatureModelAdapter extends EContentAdapter {
        
        

        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);

            switch(notification.getEventType()) {
                case Notification.ADD:
                case Notification.ADD_MANY:
                case Notification.REMOVE:
                case Notification.REMOVE_MANY:
                case Notification.SET:
                    refreshDelayedRunner.run(500, new Runnable() {
                        @Override
                        public void run() {
                            if(viewer.getControl().isDisposed())
                                return;
                            
                            recomputeTreeInfo();
                            resizeGraphView();
                            constraintFilter.update(currentSelection, featureModel);
                            viewer.refresh();
                            viewer.applyLayout();
                        }
                    });
                    break;
            }
        }

    }

}
