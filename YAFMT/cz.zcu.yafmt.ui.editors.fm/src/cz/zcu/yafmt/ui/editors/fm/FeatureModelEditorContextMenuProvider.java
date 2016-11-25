package cz.zcu.yafmt.ui.editors.fm;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import cz.zcu.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.zcu.yafmt.ui.actions.ShowPropertiesAction;
import cz.zcu.yafmt.ui.editors.fm.actions.GenerateIdFromNameAction;
import cz.zcu.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.zcu.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;
import cz.zcu.yafmt.ui.providers.ModelEditorContextMenuProvider;

public class FeatureModelEditorContextMenuProvider extends ModelEditorContextMenuProvider {

    public FeatureModelEditorContextMenuProvider(GraphicalEditor editor) {
        super(editor);
    }

    @Override
    public void buildContextMenu(IMenuManager menu) {
        super.buildContextMenu(menu);

        addActionToMenu(menu, GEFActionConstants.GROUP_VIEW, GEFActionConstants.ZOOM_IN);
        addActionToMenu(menu, GEFActionConstants.GROUP_VIEW, GEFActionConstants.ZOOM_OUT);
        addActionToMenu(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.UNDO.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.REDO.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, ActionFactory.DELETE.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, SetFeatureCardinalityAction.ID_OPTIONAL);
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, SetFeatureCardinalityAction.ID_MANDATORY);
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, GenerateIdFromNameAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, GroupFeaturesAction.ID_XOR);
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, GroupFeaturesAction.ID_OR);
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, UngroupFeaturesAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_REST, ShowPropertiesAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_SAVE, ExportGraphicalEditorAsImageAction.ID);
    }

}
