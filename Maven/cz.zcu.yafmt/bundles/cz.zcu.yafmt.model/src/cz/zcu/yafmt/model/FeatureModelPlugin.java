/**
 */
package cz.zcu.yafmt.model;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

import cz.zcu.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;

/**
 * This is the central singleton for the FeatureModel model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class FeatureModelPlugin extends EMFPlugin {
        
    /**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final FeatureModelPlugin INSTANCE = new FeatureModelPlugin();

    /**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static Implementation plugin;

    /**
	 * Create the instance.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureModelPlugin() {
		super(new ResourceLocator [] {});
	}

    /**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
    @Override
    public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

    /**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
    public static Implementation getPlugin() {
		return plugin;
	}

    /**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static class Implementation extends EclipsePlugin {
        /**
         * Creates an instance.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated NOT
         */
        public Implementation() {
            super();

            // Remember the static instance.
            plugin = this;
            
            // Register packages and custom resource factories.
            FeatureModelUtil.hookResourceFactoryRegistry();
            FeatureModelUtil.hookPackageRegistry();
            FeatureConfigurationUtil.hookResourceFactoryRegistry();
            FeatureConfigurationUtil.hookPackageRegistry();
        }
        
        
    }
    
}
