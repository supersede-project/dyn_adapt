package cz.zcu.yafmt.model.provider.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

import cz.zcu.yafmt.model.validation.IStructuralFeatureValidator;

public class ValidatingPropertyDescriptor extends PropertyDescriptor {

    private IStructuralFeatureValidator validator;

    public ValidatingPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor, IStructuralFeatureValidator validator) {
        super(object, itemPropertyDescriptor);
        this.validator = validator;
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite) {
        return attachValidator(super.createPropertyEditor(composite));
    }

    public CellEditor attachValidator(CellEditor cellEditor) {
        if(cellEditor != null)
            cellEditor.addListener(new InputValidator(cellEditor));
        return cellEditor;
    }
    
    // ================================================================================
    //  Input validator
    // ================================================================================
    
    private class InputValidator extends NonBlockingCellEditorValidator {

        public InputValidator(CellEditor cellEditor) {
            super(cellEditor);
        }
        
        @Override
        protected String getErrorMessage(Object value) {
            EStructuralFeature structuralFeature = (EStructuralFeature) itemPropertyDescriptor.getFeature(value);
            return validator.getStructuralFeatureError((EObject) object, structuralFeature, value);
        }
        
    }


}
