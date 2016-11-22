package cz.zcu.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import cz.zcu.yafmt.clang.ConstraintLanguageDescriptor;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.ui.editors.fm.commands.SetConstraintLanguageCommand;

public class SetConstraintLanguageAction extends Action {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fm.actions.SetConstraintLanguageAction";

    private Viewer viewer;
    private CommandStack commandStack;

    public SetConstraintLanguageAction(Viewer viewer, CommandStack commandStack) {
        this.viewer = viewer;
        this.commandStack = commandStack;

        setId(ID);
        setText("Set Language");
        setMenuCreator(new MenuCreator());
    }

    @Override
    public boolean isEnabled() {
        ISelection selection = viewer.getSelection();
        if(!(selection instanceof IStructuredSelection) || selection.isEmpty())
            return false;

        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        for(ConstraintLanguageDescriptor descriptor: registry.getDescriptors()) {
            Command command = getCommand(descriptor.getId());
            if((command != null) && command.canExecute())
                return true;
        }

        return false;
    }

    private Command getCommand(String languageId) {
        CompoundCommand command = new CompoundCommand();
        for(Object object: ((IStructuredSelection) viewer.getSelection()).toArray()) {
            if(object instanceof Constraint) {
                Constraint constraint = (Constraint) object;
                if(!languageId.equals(constraint.getLanguage())) {
                    command.add(new SetConstraintLanguageCommand(constraint, languageId));
                }
            }
        }
        return command;
    }

    private class MenuCreator implements IMenuCreator, SelectionListener {

        private Menu menu;

        @Override
        public Menu getMenu(Menu parent) {
            dispose();

            ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
            menu = new Menu(parent);

            for(ConstraintLanguageDescriptor descriptor: registry.getDescriptors()) {
                Command command = getCommand(descriptor.getId());
                if((command != null) && command.canExecute()) {
                    MenuItem menuItem = new MenuItem(menu, SWT.NONE);
                    menuItem.setText(descriptor.getName());
                    menuItem.setData(command);
                    menuItem.addSelectionListener(this);
                }
            }

            return menu;
        }

        @Override
        public Menu getMenu(Control parent) {
            return null;
        }

        @Override
        public void dispose() {
            if(menu != null) {
                menu.dispose();
                menu = null;
            }
        }

        @Override
        public void widgetSelected(SelectionEvent event) {
            Command command = (Command) ((MenuItem) event.getSource()).getData();
            commandStack.execute(command);
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        }

    }

}
