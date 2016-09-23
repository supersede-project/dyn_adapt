package cz.zcu.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ui.EditingContext;
import cz.zcu.yafmt.clang.ui.EditingSupportRegistry;
import cz.zcu.yafmt.clang.ui.IEditingSupport;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.provider.util.ValidatingPropertyDescriptor;
import cz.zcu.yafmt.model.validation.IStructuralFeatureValidator;

public class ConstraintValuePropertyDescriptor extends ValidatingPropertyDescriptor {

    public ConstraintValuePropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor, IStructuralFeatureValidator validator) {
        super(object, itemPropertyDescriptor, validator);
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite) {
        Constraint constraint = (Constraint) object;

        // Use custom editor from extension point if possible.
        EditingSupportRegistry registry = ConstraintLanguagePlugin.getDefault().getEditingSupportRegistry();
        IEditingSupport editingSupport = registry.getEditingSupport(constraint.getLanguage());
        if(editingSupport != null) {
            EditingContext context = new EditingContext(constraint.getFeatureModel());
            return attachValidator(editingSupport.createCellEditor(composite, context));
        }

        return super.createPropertyEditor(composite);
    }

}
