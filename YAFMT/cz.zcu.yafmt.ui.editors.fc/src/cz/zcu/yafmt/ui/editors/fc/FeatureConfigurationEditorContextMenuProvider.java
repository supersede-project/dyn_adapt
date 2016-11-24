package cz.zcu.yafmt.ui.editors.fc;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import cz.zcu.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.zcu.yafmt.ui.editors.fc.actions.DeselectFeaturesAction;
import cz.zcu.yafmt.ui.editors.fc.actions.SelectFeaturesAction;
import cz.zcu.yafmt.ui.providers.ModelEditorContextMenuProvider;

public class FeatureConfigurationEditorContextMenuProvider extends ModelEditorContextMenuProvider {

    public FeatureConfigurationEditorContextMenuProvider(GraphicalEditor editor) {
        super(editor);
    }

    @Override
    public void buildContextMenu(IMenuManager menu) {
        super.buildContextMenu(menu);

        addActionToMenu(menu, GEFActionConstants.GROUP_VIEW, GEFActionConstants.ZOOM_IN);
        addActionToMenu(menu, GEFActionConstants.GROUP_VIEW, GEFActionConstants.ZOOM_OUT);
        addActionToMenu(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.UNDO.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.REDO.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, SelectFeaturesAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, DeselectFeaturesAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_SAVE, ExportGraphicalEditorAsImageAction.ID);
    }

}
