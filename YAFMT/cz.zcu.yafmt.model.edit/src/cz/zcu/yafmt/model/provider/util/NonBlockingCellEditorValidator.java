package cz.zcu.yafmt.model.provider.util;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellEditorValidator;

// Displays validation error message, but allows confirmation of the erroneous value.
public abstract class NonBlockingCellEditorValidator implements ICellEditorListener, ICellEditorValidator {

    protected CellEditor cellEditor;
    private ICellEditorValidator originalValidator;
    private Object currentValue;
    private boolean enabled;
            
    public NonBlockingCellEditorValidator(CellEditor cellEditor) {
        this.cellEditor = cellEditor;
        this.originalValidator = cellEditor.getValidator();
        this.currentValue = cellEditor.getValue();
        this.enabled = true;
        cellEditor.setValidator(this);
    }
    
    @Override
    public void applyEditorValue() {
        // This causes that is possible to confirm erroneous value.
        enabled = false;                       // Disable our validator.
        if((cellEditor.getControl() != null) && !cellEditor.getControl().isDisposed())
            cellEditor.setValue(currentValue); // Refresh validation error message.
    }

    @Override
    public void cancelEditor() {
    }

    @Override
    public void editorValueChanged(boolean oldValidState, boolean newValidState) {
        // Editor can be reused after apply/cancel value call, so we need to refresh it.
        enabled = true;
    }
    
    @Override
    public String isValid(Object value) {
        currentValue = value;                                // Remember current value.
        String defaultError = getDefaultErrorMessage(value); // Use original validator.
        String customError = getErrorMessage(value);         // Use new validator.
        
        // Return custom error when allowed or replace the defaul error message.
        if((customError != null) && (enabled || (defaultError != null)))
            return customError;
        return defaultError;
    }
    
    private String getDefaultErrorMessage(Object value) {
        return (originalValidator != null) ? originalValidator.isValid(value) : null;
    }
    
    protected abstract String getErrorMessage(Object value);
    
}
