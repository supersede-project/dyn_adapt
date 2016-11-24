package cz.zcu.yafmt.ui.editors.fm;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.CONSTRAINT__LANGUAGE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.zcu.yafmt.clang.ConstraintLanguageDescriptor;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelFactory;
import cz.zcu.yafmt.model.validation.fm.FeatureModelValidator;
import cz.zcu.yafmt.ui.actions.DynamicContributionItem;
import cz.zcu.yafmt.ui.editors.fm.actions.SetConstraintLanguageAction;
import cz.zcu.yafmt.ui.editors.fm.commands.AddConstraintCommand;
import cz.zcu.yafmt.ui.util.DelayedRunner;
import cz.zcu.yafmt.ui.validation.IProblemManager;
import cz.zcu.yafmt.ui.widgets.Splitter;
import cz.zcu.yafmt.ui.widgets.SplitterDock;

public class ConstraintsEditor extends SplitterDock implements ISelectionListener {

    private FeatureModel featureModel;
    private FeatureModelAdapter featureModelAdapter = new FeatureModelAdapter();

    private ConstraintCache constraintCache;
    private Set<Constraint> visibleConstraints = new HashSet<Constraint>();
    private IStructuredSelection outerSelection = StructuredSelection.EMPTY;
    private boolean blockSelectionEvents = false;

    private boolean filterEnabled = false;
    private ToolItem filterButton;

    private TableViewer viewer;
    private CommandStack commandStack;
    private ActionRegistry actionRegistry;
    private IContributionItem setLanguageAction;
    private IProblemManager problemManager;

    public ConstraintsEditor(Splitter splitter, GraphicalEditor editor) {
        super(splitter, SWT.NONE);
        commandStack = (CommandStack) editor.getAdapter(CommandStack.class);
        actionRegistry = (ActionRegistry) editor.getAdapter(ActionRegistry.class);
        featureModel = (FeatureModel) editor.getAdapter(FeatureModel.class);
        constraintCache = (ConstraintCache) editor.getAdapter(ConstraintCache.class);
        problemManager = (IProblemManager) editor.getAdapter(IProblemManager.class);
        initialize();
    }
    
    // ====================================================================
    //  Initialization  
    // ====================================================================
    
    private void initialize() {
        // Revalidation happens when adapter is initialized.
        buildControl();
        featureModel.eAdapters().add(featureModelAdapter); // Must be called after initializing viewer.
        
        setName("Constraints");
        setImage(FeatureModelEditorPlugin.getAccess().getImage("constraint.png"));
        setOpenToolTipText("Show Constraints");
        setCollapseToolTipText("Hide Constraints");
    }

    @Override
    public void dispose() {
        featureModel.eAdapters().remove(featureModelAdapter);
        super.dispose();
    }

    // ====================================================================
    //  Control creation
    // ====================================================================
    
    @Override
    protected Control createControl(Composite parent) {
        viewer = new CustomTableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        createViewerColumn();
        createViewerActivationStrategy();
        createViewerActions();
        configureViewer();
        return viewer.getControl();
    }

    private void createViewerColumn() {
        TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
        viewerColumn.setEditingSupport(new ConstraintsEditorEditingSupport(viewer, commandStack));
        viewerColumn.setLabelProvider(new ConstraintsEditorLabelProvider(problemManager));
        ColumnViewerToolTipSupport.enableFor(viewer);

        TableColumnLayout layout = new TableColumnLayout();
        layout.setColumnData(viewerColumn.getColumn(), new ColumnWeightData(1));
        viewer.getTable().getParent().setLayout(layout);
    }

    private void createViewerActivationStrategy() {
        TableViewerEditor.create(viewer, new ConstraintsEditorActivationStrategy(viewer), SWT.NONE);
    }

    private void createViewerActions() {
        setLanguageAction = new DynamicContributionItem(new SetConstraintLanguageAction(viewer, commandStack));
    }

    private void configureViewer() {
        viewer.setContentProvider(new ConstraintsEditorContentProvider());
        viewer.addFilter(new ConstraintsFilter());
        viewer.setInput(featureModel);

        viewer.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent event) {
                Object selection = ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                if(selection == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
                    addNewConstraint();
            }
        });

        viewer.getTable().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.keyCode == SWT.DEL) {
                    actionRegistry.getAction(ActionFactory.DELETE.getId()).run();
                }
            }
        });
    }

    @Override
    protected void contributeToContextMenu(IMenuManager manager) {
        IAction deleteAction = actionRegistry.getAction(ActionFactory.DELETE.getId());
        if(deleteAction.isEnabled())
            manager.add(deleteAction);
        if(setLanguageAction.isEnabled())
            manager.add(setLanguageAction);
    }

    @Override
    protected void contributeToToolbar(ToolBar toolBar) {
        filterButton = new ToolItem(toolBar, SWT.CHECK);
        filterButton.setSelection(filterEnabled);
        filterButton.setToolTipText("Filter by Feature Selection");
        filterButton.setImage(FeatureModelEditorPlugin.getAccess().getImage("filter.png"));
        filterButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                filterEnabled = filterButton.getSelection();
                refresh();
            }
        });
    }
    
    // ====================================================================
    //  Properties
    // ====================================================================
    
    @Override
    public boolean setFocus() {
        return viewer.getControl().setFocus();
    }

    @Override
    public boolean isFocusControl() {
        return viewer.getControl().isFocusControl();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        refresh();
    }

    public TableViewer getViewer() {
        return viewer;
    }
    
    public void refresh() {
        if(!isVisible())
            return;

        if(filterEnabled)
            refreshFilter();
        viewer.refresh();
    }

    private void refreshFilter() {
        visibleConstraints.clear();

        for(Object object: outerSelection.toArray()) {
            if(object instanceof Constraint) {
                Constraint constraint = (Constraint) object;
                visibleConstraints.add(constraint);
            }
            else if(object instanceof Feature) {
                Feature feature = (Feature) object;
                visibleConstraints.addAll(constraintCache.getConstraintsAffectingFeature(feature));
            }
        }
    }
    
    // ====================================================================
    //  Commands
    // ====================================================================
    
    private void addNewConstraint() {
        Constraint constraint = FeatureModelFactory.eINSTANCE.createConstraint();
        constraint.setLanguage(getDefaultConstraintLanguage());
        constraint.setValue("");
        visibleConstraints.add(constraint); // Make the new constraint visible.

        // Execute command to add new constraint.
        Command command = new AddConstraintCommand(featureModel, constraint);
        commandStack.execute(command);

        // Start constraint editing.
        viewer.editElement(constraint, 0);
    }

    private String getDefaultConstraintLanguage() {
        // Get last used language for constraint if possible.
        String languageId = null;
        List<Constraint> constraints = featureModel.getConstraints();
        if(!constraints.isEmpty())
            languageId = constraints.get(constraints.size() - 1).getLanguage();

        // Check if that language really exists.
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        if(registry.getDescriptor(languageId) != null)
            return languageId;
        
        // Return the first language in registry.
        ConstraintLanguageDescriptor descriptor = registry.getDescriptors().iterator().next();
        return (descriptor != null) ? descriptor.getId() : null;
    }
    
    // ====================================================================
    //  Validation
    // ====================================================================
        
    private void revalidateConstraint(Constraint constraint) {
        problemManager.clearProblems(constraint);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(constraint, diagnostic))
            problemManager.addProblems(diagnostic);
    }
    
    private void revalidateAllConstraints() {
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        boolean success = true;
        for(Constraint constraint: featureModel.getConstraints()) {
            problemManager.clearProblems(constraint);
            success &= FeatureModelValidator.INSTANCE.validate(constraint, diagnostic);
        }
        if(!success)
            problemManager.addProblems(diagnostic);
    }
    
    // ====================================================================
    //  Events
    // ====================================================================
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        // Ignore invalid selections.
        IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
        if((part != activePart) || (part instanceof PropertySheet) || viewer.getSelection().equals(selection))
            return;

        outerSelection = (selection instanceof IStructuredSelection) ? (IStructuredSelection) selection : StructuredSelection.EMPTY;
        if(filterEnabled)
            refresh();
        
        // Do not generate another selection event.
        blockSelectionEvents = true;
        viewer.setSelection(selection);
        blockSelectionEvents = false;
    }   

    private class FeatureModelAdapter extends EContentAdapter {

        private DelayedRunner delayedRunner = new DelayedRunner();
        
        @Override
        protected void addAdapter(Notifier notifier) {
            super.addAdapter(notifier);

            if(notifier instanceof Constraint) {
                revalidateConstraint((Constraint) notifier);
                // Because the 'add button', we have to refresh it all.
                // We cannot use viewer.insert(), since there is a filter set.
                viewer.refresh(); 
            }
            else if((notifier instanceof Feature) || (notifier instanceof Attribute)) {
                scheduleRevalidaiondOfAllConstraints();
            }
        }
        
        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
            if(notifier instanceof Constraint) {
                problemManager.clearProblems(notifier);
                viewer.remove(notifier);
            }
            else if((notifier instanceof Feature) || (notifier instanceof Attribute)) {
                scheduleRevalidaiondOfAllConstraints();
            }
        }
        
        @Override
        public void notifyChanged(Notification msg) {
            super.notifyChanged(msg);

            Object notifier = msg.getNotifier();
            if(notifier instanceof Constraint)
                notifyChangedFromConstraint(msg);
            if(notifier instanceof Feature)
                notifyChangedFromFeature(msg);
            if(notifier instanceof Attribute)
                notifyChangedFromAttribute(msg);
        }
        
        private void notifyChangedFromConstraint(Notification msg) {
            switch(msg.getFeatureID(Constraint.class)) {
                case CONSTRAINT__LANGUAGE:
                case CONSTRAINT__VALUE:
                    revalidateConstraint((Constraint) msg.getNotifier());
                    viewer.refresh(msg.getNotifier());
                    break;
            }
        }

        private void notifyChangedFromFeature(Notification msg) {
            switch(msg.getFeatureID(Feature.class)) {
                case FEATURE__ID:
                    scheduleRevalidaiondOfAllConstraints();
                    break;
            }
        }
        
        private void notifyChangedFromAttribute(Notification msg) {
            switch(msg.getFeatureID(Attribute.class)) {
                case ATTRIBUTE__ID:
                    scheduleRevalidaiondOfAllConstraints();
                    break;
            }
        }

        private void scheduleRevalidaiondOfAllConstraints() {
            delayedRunner.run(500, new Runnable() {
                @Override
                public void run() {
                    revalidateAllConstraints();
                    viewer.refresh();
                }
            });
        }
        
        
        
    }
    
    // ====================================================================
    //  Helpers
    // ====================================================================

    private class ConstraintsFilter extends ViewerFilter {

        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if(!filterEnabled || (element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT))
                return true;
            return visibleConstraints.contains(element);
        }

    }
    
    private class CustomTableViewer extends TableViewer {

        public CustomTableViewer(Composite parent, int style) {
            super(parent, style);
        }

        @Override
        protected void fireSelectionChanged(SelectionChangedEvent event) {
            if(!blockSelectionEvents)
                super.fireSelectionChanged(event);
        }

        @Override
        protected void firePostSelectionChanged(SelectionChangedEvent event) {
            if(!blockSelectionEvents)
                super.firePostSelectionChanged(event);
        }

    }

}
