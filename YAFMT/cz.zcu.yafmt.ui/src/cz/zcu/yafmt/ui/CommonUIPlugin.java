package cz.zcu.yafmt.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class CommonUIPlugin extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "cz.zcu.yafmt.ui"; //$NON-NLS-1$

    private static UIPluginAccess access;
    
    public static UIPluginAccess getAccess() {
        return access;
    }
    
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        access = new UIPluginAccess(this, PLUGIN_ID);
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        access = null;
        super.stop(context);
    }
    
    @Override
    protected void initializeImageRegistry(ImageRegistry registry) {
        access.initializeImageRegistry(registry);
    }

}
