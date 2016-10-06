package cz.zcu.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.provider.util.ValidatingPropertySource;
import cz.zcu.yafmt.model.validation.fm.FeatureModelValidator;

public class FeatureModelPropertySource extends ValidatingPropertySource {

    public FeatureModelPropertySource(Object object, IItemPropertySource itemPropertySource) {
        super(object, itemPropertySource, FeatureModelValidator.INSTANCE);
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
        // Use custom property descriptor for constraint value.
        // It can use language custom editor from extension point. 
        if(itemPropertyDescriptor.getFeature(null) == FeatureModelPackage.Literals.CONSTRAINT__VALUE)
            return new ConstraintValuePropertyDescriptor(object, itemPropertyDescriptor, FeatureModelValidator.INSTANCE);
        // Default descriptor for others.
        return super.createPropertyDescriptor(itemPropertyDescriptor);
    }

}
