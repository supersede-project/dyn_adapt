package cz.zcu.yafmt.clang.ui;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * Main class of a constraint language editing support extension.
 * 
 * @author Jan Pikl
 * 
 */
public interface IEditingSupport {

    /**
     * Creates custom cell editor for editing of a constraint written in the
     * target language. This method could return <code>null</code> in case we do
     * not need cell editor, for example, when we want to use own dialog window
     * for constraint editing.
     * 
     * @param composite
     *            the parent element that will contain the cell editor
     * @param context
     *            context of constraint editing
     * @return created cell editor or <code>null</code>
     */
    CellEditor createCellEditor(Composite composite, EditingContext context);

}
