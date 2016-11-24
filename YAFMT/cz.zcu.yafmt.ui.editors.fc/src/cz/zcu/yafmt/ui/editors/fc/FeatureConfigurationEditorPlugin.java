package cz.zcu.yafmt.ui.editors.fc;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import cz.zcu.yafmt.ui.UIPluginAccess;

public class FeatureConfigurationEditorPlugin extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "cz.zcu.yafmt.ui.editors.fc"; //$NON-NLS-1$

    private static UIPluginAccess access;

    public static UIPluginAccess getAccess() {
        return access;
    }

    public void start(BundleContext context) throws Exception {
        super.start(context);
        access = new UIPluginAccess(this, PLUGIN_ID);
    }

    public void stop(BundleContext context) throws Exception {
        access = null;
        super.stop(context);
    }

    @Override
    protected void initializeImageRegistry(ImageRegistry registry) {
        access.initializeImageRegistry(registry);
    }
    
}

