package cz.zcu.yafmt.model.validation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

public final class FeatureModelValidationPlugin extends EMFPlugin {
    
    public static final FeatureModelValidationPlugin INSTANCE = new FeatureModelValidationPlugin();

    private static Implementation plugin;

    public FeatureModelValidationPlugin() {
        super(new ResourceLocator [] {});
    }

    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    public static Implementation getPlugin() {
        return plugin;
    }

    public static class Implementation extends EclipsePlugin {

        public Implementation() {
            plugin = this;
        }
    }

}

