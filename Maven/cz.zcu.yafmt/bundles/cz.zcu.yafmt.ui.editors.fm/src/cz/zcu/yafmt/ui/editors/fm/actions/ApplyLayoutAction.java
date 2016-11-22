package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class ApplyLayoutAction extends EditorPartAction {

    public static String ID = "cz.zcu.yafmt.ui.editors.fm.actions.ApplyLayoutAction";

    // We have to keep track of changes of action handler parameters, 
    // because they depend on the last selected layout.
    private static class LayoutRetargetAction extends LabelRetargetAction {
        
        public LayoutRetargetAction() {
            super(ID, null, IAction.AS_DROP_DOWN_MENU);
            setText("Apply Vertical Tree Layout");
            setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("vertical-tree-layout.png"));
        }
        
        protected void propagateChange(PropertyChangeEvent event) {
            super.propagateChange(event);
            
            // Keep track of changes.
            String property = event.getProperty();
            if(property.equals(IAction.TEXT))
                setText(getActionHandler().getText());
            else if(property.equals(IAction.IMAGE))
                setImageDescriptor(getActionHandler().getImageDescriptor());
        }
        
        @Override
        protected void setActionHandler(IAction handler) {
            super.setActionHandler(handler);
            
            // Keep track of changes.
            if(handler != null) {
                setText(handler.getText());
                setImageDescriptor(handler.getImageDescriptor());
            }
        }
        
        @Override
        public IMenuCreator getMenuCreator() {
            // Provider action handler menu creator.
            if(getActionHandler() != null)
                return getActionHandler().getMenuCreator();
            return super.getMenuCreator();
        }
        
    };
    
    public static RetargetAction createRetargetAction() {
        return new LayoutRetargetAction();
    }
    
    private List<IAction> layoutActions;
    private static IAction lastUsedLayoutAction;
    
    public ApplyLayoutAction(GraphicalEditor editor) {
        super(editor, IAction.AS_DROP_DOWN_MENU);
        setId(ID);
        createLayoutActions(editor);
        setLastUsedLayoutAction(layoutActions.get(0));
        setMenuCreator(new MenuCreator());
    }
    
    private void createLayoutActions(IEditorPart editor) {
        layoutActions = new ArrayList<IAction>();
        layoutActions.add(new ApplyVerticalTreeLayoutAction(editor));
        layoutActions.add(new ApplyHorizontalTreeLayoutAction(editor));
    }
    
    public void setLastUsedLayoutAction(IAction layoutAction) {
        setText(layoutAction.getText());
        setImageDescriptor(layoutAction.getImageDescriptor());
        lastUsedLayoutAction = layoutAction;
    }

    @Override
    protected boolean calculateEnabled() {
        return lastUsedLayoutAction.isEnabled();
    }
    
    @Override
    public void run() {
        lastUsedLayoutAction.run();
    }    

    private class MenuCreator implements IMenuCreator {
        
        private Menu menu;

        @Override
        public Menu getMenu(Control parent) {
            dispose();            
            menu = new Menu(parent);
            for(IAction layoutAction: layoutActions)
                addActionToMenu(menu, layoutAction);
            return menu;
        }
        
        private void addActionToMenu(Menu menu, IAction action) {
            ActionContributionItem item = new ActionContributionItem(action);
            item.fill(menu, -1);
        }

        @Override
        public Menu getMenu(Menu parent) {
            return null;
        }
        
        @Override
        public void dispose() {
            if(menu != null) {
                menu.dispose();
                menu = null;
            }
        }
        
    }
    
    private class BaseApplyLayoutAction extends EditorPartAction {

        private String requestId;
        
        public BaseApplyLayoutAction(IEditorPart editor, String name, String imageId, String requestId) {
            super(editor);
            setText(name);
            setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor(imageId));
            this.requestId = requestId;
        }

        @Override
        protected boolean calculateEnabled() {
            Command command = getCommand();
            return (command != null) && command.canExecute();
        }

        private Command getCommand() {
            GraphicalViewer viewer = (GraphicalViewer) getEditorPart().getAdapter(GraphicalViewer.class);
            EditPart editPart = viewer.getRootEditPart().getContents();
            return editPart.getCommand(new Request(requestId));
        }
        
        @Override
        public void run() {
            execute(getCommand());
            setLastUsedLayoutAction(this);
        }
        
    }
        
    private class ApplyVerticalTreeLayoutAction extends BaseApplyLayoutAction {

        public ApplyVerticalTreeLayoutAction(IEditorPart editor) {
            super(editor, "Apply Vertical Tree Layout", "vertical-tree-layout.png", RequestConstants.REQ_APPLY_VER_TREE_LAYOUT);
        }
        
    }
    
    private class ApplyHorizontalTreeLayoutAction extends BaseApplyLayoutAction {

        public ApplyHorizontalTreeLayoutAction(IEditorPart editor) {
            super(editor, "Apply Horizontal Tree Layout", "horizontal-tree-layout.png", RequestConstants.REQ_APPLY_HOR_TREE_LAYOUT);
        }
        
    }

}
