/*******************************************************************************
 * Copyright (c) 2014-2016 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 * Jesús Gorroñogoitia (Atos Spain S.A.) - Adapted to Supersede project
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 * Adapted in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.aom.dsl.resources;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

public class ResourcesPlugin extends EMFPlugin {

	public static final String PLUGIN_ID = "eu.supersede.dynadapt.aom.dsl.resources";
	
	/**
	 * The singleton instance of the plugin.
	 */
	public static final ResourcesPlugin INSTANCE = new ResourcesPlugin();
	
	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	/**
	 * Creates the singleton instance.
	 */
	private ResourcesPlugin() {
		super(new ResourceLocator[]{});
	}

	/**
	 * Returns the singleton instance of the plugin.
	 * 
	 * @return the singleton instance.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * The actual implementation of the <b>Plugin</b>.
	 */
	public static class Implementation
			extends EclipsePlugin {

		public Implementation() {
			super();

			plugin = this;
		}
	}

}
