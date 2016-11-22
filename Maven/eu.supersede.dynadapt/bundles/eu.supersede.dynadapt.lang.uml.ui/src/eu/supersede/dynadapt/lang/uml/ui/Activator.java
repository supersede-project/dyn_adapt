package eu.supersede.dynadapt.lang.uml.ui;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.eclipse.xtext.ui.shared.SharedStateModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

import eu.supersede.dynadapt.lang.uml.UmlRuntimeModule;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	
	private static final Logger logger = Logger.getLogger(Activator.class);

	// The plug-in ID
	public static final String PLUGIN_ID = "eu.supersede.dynadapt.lang.uml.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private Injector injector;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}
	
	public Injector getInjector() {
		return injector;
	}

	private void initializeEcoreInjector() {
		injector = Guice.createInjector(
				Modules.override(Modules.override(new UmlRuntimeModule())
				.with(new UmlUiModule(plugin)))
				.with(new SharedStateModule()));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		try {
			initializeEcoreInjector();
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		injector = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
