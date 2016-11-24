package cz.zcu.yafmt.ui.providers;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;

public class ModelEditorContextMenuProvider extends ContextMenuProvider {

    private ActionRegistry registry;

    public ModelEditorContextMenuProvider(GraphicalEditor editor) {
        super((GraphicalViewer) editor.getAdapter(GraphicalViewer.class));
        this.registry = (ActionRegistry) editor.getAdapter(ActionRegistry.class);
    }

    protected void addActionToMenu(IMenuManager menu, String actionId) {
        IAction action = registry.getAction(actionId);
        if(action.isEnabled())
            menu.add(action);
    }

    protected void addActionToMenu(IMenuManager menu, String groupId, String actionId) {
        IAction action = registry.getAction(actionId);
        if((action != null) && action.isEnabled())
            menu.appendToGroup(groupId, action);
    }

    @Override
    public void buildContextMenu(IMenuManager menu) {
        GEFActionConstants.addStandardActionGroups(menu);
    }

}
