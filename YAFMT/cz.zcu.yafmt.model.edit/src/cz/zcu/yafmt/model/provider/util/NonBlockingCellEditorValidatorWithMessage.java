package cz.zcu.yafmt.model.provider.util;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.ui.PlatformUI;



public abstract class NonBlockingCellEditorValidatorWithMessage extends NonBlockingCellEditorValidator {

    private IStatusLineManager statusLineManager;
    
    public NonBlockingCellEditorValidatorWithMessage(CellEditor cellEditor) {
        super(cellEditor);
        statusLineManager = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars().getStatusLineManager();
    }
    
    @Override
    public void applyEditorValue() {
        super.applyEditorValue();
        statusLineManager.setErrorMessage(null);
    }
    
    @Override
    public void cancelEditor() {
        super.cancelEditor();
        statusLineManager.setErrorMessage(null);
    }
    
    @Override
    public void editorValueChanged(boolean oldValidState, boolean newValidState) {
        super.editorValueChanged(oldValidState, newValidState);
        statusLineManager.setErrorMessage(cellEditor.getErrorMessage());
    }

}
