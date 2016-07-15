/*******************************************************************************
 * Copyright (c) 2014-2016 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 * Jesús Gorroñogoitia (Atos Spain S.A.) - Adapted to Supesede project
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 * Adapted in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.aom.dsl.resources;

import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLStandaloneSetup;

/**
 * A convenience class for the examples. It provides the necessary resource
 * URIs as well as a method to create a {@link SupersedeDSLResourceSet} already
 * loaded with all the resources.
 * 
 * @author Martin Fleck, Jesús Gorroñogoitia
 *
 */
public class SupersedeResources {
	
	/**
	 * Creates a {@link SupersedeDSLResourceSet} with all the basic resources for
	 * our examples
	 * 
	 * @return migration resource set with loaded resources
	 */
	public static SupersedeDSLResourceSet createResourceSet() {
		SupersedeDSLStandaloneSetup.doSetup();
		SupersedeDSLResourceSet set = new SupersedeDSLResourceSet();
		return set;
	}
}
