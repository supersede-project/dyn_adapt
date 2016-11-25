package cz.zcu.yafmt.ui.editors.fm.actions;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPart;

public class SelectAllAction extends org.eclipse.gef.ui.actions.SelectAllAction {

    private IWorkbenchPart part;

    public SelectAllAction(IWorkbenchPart part) {
        super(part);
        this.part = part;
    }

    @Override
    public void run() {
        Control controlWithFocus = Display.getCurrent().getFocusControl();
        if(controlWithFocus instanceof Table) {
            // Constraints editor has focus.
            Table table = ((Table) controlWithFocus);
            table.selectAll();

            // Forward selection to the site selection provider.
            TableItem[] selectedItems = table.getSelection();
            Object[] objects = new Object[selectedItems.length];
            for(int i = 0; i < objects.length; i++)
                objects[i] = selectedItems[i].getData();

            ISelection selection = new StructuredSelection(objects);
            part.getSite().getSelectionProvider().setSelection(selection);
        }
        else {
            // GEF editor has focus.
            super.run();
        }
    }

}
