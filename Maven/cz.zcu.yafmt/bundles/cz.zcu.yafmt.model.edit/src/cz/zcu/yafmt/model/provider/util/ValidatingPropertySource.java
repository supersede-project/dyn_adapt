package cz.zcu.yafmt.model.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import cz.zcu.yafmt.model.validation.IStructuralFeatureValidator;

public class ValidatingPropertySource extends UnwrappingPropertySource {

    protected IStructuralFeatureValidator validator;

    public ValidatingPropertySource(Object object, IItemPropertySource itemPropertySource, IStructuralFeatureValidator validator) {
        super(object, itemPropertySource);
        this.validator = validator;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
        return new ValidatingPropertyDescriptor(object, itemPropertyDescriptor, validator);
    }

}
