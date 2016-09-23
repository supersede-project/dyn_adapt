package cz.zcu.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import cz.zcu.yafmt.model.fm.provider.FeatureModelItemProviderAdapterFactory;

public class FeatureModelProviderUtil {

    private static final FeatureModelItemProviderAdapterFactory adapterFactory = new FeatureModelItemProviderAdapterFactory();

    private static AdapterFactoryContentProvider getAdapterFactoryContentProvider() {
        return new AdapterFactoryContentProvider(adapterFactory) {
            @Override
            protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
                return new FeatureModelPropertySource(object, itemPropertySource);
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
