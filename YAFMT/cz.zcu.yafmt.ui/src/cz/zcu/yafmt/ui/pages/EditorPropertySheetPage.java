package cz.zcu.yafmt.ui.pages;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetSorter;

public class EditorPropertySheetPage extends UndoablePropertySheetPage {

    private IPropertySourceProvider provider;

    public EditorPropertySheetPage(GraphicalEditor editor, IPropertySourceProvider provider) {
        super(getCommandStack(editor), getUndoAction(editor), getRedoAction(editor));

        this.provider = provider;
        setSorter(new DisabledSorter());
    }
    
    // ==================================================================
    //  Initialization
    // ==================================================================
    
    @Override
    public void init(IPageSite pageSite) {
        super.init(pageSite);
        // PropertySheet does not send to this page all selection events,
        // so we have to handle it itself.
        pageSite.getPage().addSelectionListener(this);
    }
    
    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        super.dispose();
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        setPropertySourceProvider(provider);
    }
    
    // ==================================================================
    //  Event handling
    // ==================================================================

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        // Ignore invalid selections.
        IWorkbenchPart activePart = getSite().getPage().getActivePart();
        if((part != activePart) || (part instanceof PropertySheet))
            return;
        
        // Selection with multiple values is not displayed.
        // Convert such selection to selection with only one element.
        if((selection instanceof IStructuredSelection) && ((IStructuredSelection) selection).size() > 1)
            selection = new StructuredSelection(((IStructuredSelection) selection).getFirstElement());
        super.selectionChanged(part, selection);
    }
    
    // ==================================================================
    //  Utilities
    // ==================================================================
    
    private static class DisabledSorter extends PropertySheetSorter {

        @Override
        public void sort(IPropertySheetEntry[] entries) {
            // Disable sorting of entries.
        }

    }
    
    // ==================================================================
    //  Editor components queries
    // ==================================================================
    
    private static CommandStack getCommandStack(IAdaptable adaptable) {
        return (CommandStack) adaptable.getAdapter(CommandStack.class);
    }

    private static ActionRegistry getActionRegistry(IAdaptable adaptable) {
        return (ActionRegistry) adaptable.getAdapter(ActionRegistry.class);
    }

    private static IAction getUndoAction(IAdaptable adaptable) {
        return getActionRegistry(adaptable).getAction(ActionFactory.UNDO.getId());
    }

    private static IAction getRedoAction(IAdaptable adaptable) {
        return getActionRegistry(adaptable).getAction(ActionFactory.REDO.getId());
    }
    
}
