package cz.zcu.yafmt.ui.editors.fc.util;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;


public class BooleanCellEditor extends ComboBoxCellEditor {

    private static final String[] VALUES = { "false", "true" };
    
    public BooleanCellEditor(Composite parent) {
        super(parent, VALUES);
    }
        
    @Override
    protected void doSetValue(Object value) {
        super.doSetValue(Boolean.TRUE.equals(value) ? 1 : 0);
    }
    
    @Override
    protected Object doGetValue() {
        int index = (Integer) super.doGetValue();
        return (index == 1) ? Boolean.TRUE : Boolean.FALSE;
    }

}
