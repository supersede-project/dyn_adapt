package cz.zcu.yafmt.model.fc.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import cz.zcu.yafmt.model.fc.provider.FeatureConfigurationItemProviderAdapterFactory;
import cz.zcu.yafmt.model.provider.util.ValidatingPropertySource;
import cz.zcu.yafmt.model.validation.fc.FeatureConfigurationValidator;

public class FeatureConfigurationProviderUtil {

    private static final FeatureConfigurationItemProviderAdapterFactory adapterFactory = new FeatureConfigurationItemProviderAdapterFactory();

    private static AdapterFactoryContentProvider getAdapterFactoryContentProvider() {
        return new AdapterFactoryContentProvider(adapterFactory) {
            @Override
            protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
                return new ValidatingPropertySource(object, itemPropertySource, FeatureConfigurationValidator.INSTANCE);
            }
        };
    }
    
    public static IStructuredContentProvider getContentProvider() {
        return getAdapterFactoryContentProvider();
    }
    
    public static IPropertySourceProvider getPropertySourceProvider() {
        return getAdapterFactoryContentProvider();
    }

    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(adapterFactory);
    }

}
