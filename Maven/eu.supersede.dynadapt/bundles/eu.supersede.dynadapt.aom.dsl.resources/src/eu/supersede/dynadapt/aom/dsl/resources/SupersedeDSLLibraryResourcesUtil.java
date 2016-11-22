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

import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import eu.supersede.dynadapt.aom.dsl.resources.constants.Ecore_PrimitiveTypes;
import eu.supersede.dynadapt.aom.dsl.resources.constants.Java_PrimitiveTypes;
import eu.supersede.dynadapt.aom.dsl.resources.constants.UML_PrimitiveTypes;
import eu.supersede.dynadapt.aom.dsl.resources.constants.XML_PrimitiveTypes;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;

/**
 * This utility class creates and adapts resource sets for the use with a 
 * pre-defined set of modeling artifacts:<br/>
 * 
 * @author Martin Fleck, Jesús Gorroñogoitia
 *
 */
public class SupersedeDSLLibraryResourcesUtil {
	/**
	 * Base pathmap to the directory of the SUPERSEDE libraries
	 */
	public static String BASE_PATHMAP = "pathmap://SUPERSEDE_LIBRARIES/";
	
	/**
	 * Creates a new, initialized Supersede DSL resource set without loading any models.
	 * @return new, initialized Supersede DSL resource set
	 */
	public static SupersedeDSLResourceSet createSupersedeDSLResourceSet() {
		return createSupersedeDSLResourceSet(false);
	}
	
	/**
	 * Creates a new, initialized Supersede DSL resource set and loads all known libraries
	 * (UML) if loadKnownResources is set to true.
	 * @param loadKnownResources if true, all known libraries will be pre-loaded
	 * @return new, initialized Supersede DSL resource set
	 */
	public static SupersedeDSLResourceSet createSupersedeDSLResourceSet(boolean loadKnownResources) {
		SupersedeDSLResourceSet set = new SupersedeDSLResourceSet();
		init(set, loadKnownResources);
		return set;
	}
	
	/**
	 * Initializes the given resource set for the use with the known libraries. Specifically,
	 * it prepares the uri map for the use of the pathmaps-uris.
	 * @param resourceSet resource set to be initialized
	 * @return initialized resource set
	 */
	public static SupersedeDSLResourceSet init(SupersedeDSLResourceSet resourceSet) {
		return init(resourceSet, false);
	}
	
	/**
	 * Initializes the given resource set for the use with the known libraries. Specifically,
	 * it prepares the uri map for the use of the pathmaps-uris. All known libraries (UML) will be pre-loaded if loadKnownResources is set to true.
	 * @param resourceSet resource set to be initialized
	 * @param loadKnownResources if true, all known libraries will be pre-loaded
	 * @return initialized resource set
	 */
	public static SupersedeDSLResourceSet init(SupersedeDSLResourceSet resourceSet, boolean loadKnownResources) {
		init(resourceSet.getResourceSet(), loadKnownResources);
		return resourceSet;
	}
	
	/**
	 * Initializes the given resource set for the use with the known libraries. Specifically,
	 * it prepares the uri map for the use of the pathmaps-uris.
	 * @param resourceSet resource set to be initialized
	 * @return initialized resource set
	 */
	public static ResourceSet init(ResourceSet resourceSet) {
		return init(resourceSet, false);
	}
	
	/**
	 * Initializes the given resource set for the use with the known libraries. Specifically,
	 * it prepares the uri map for the use of the pathmaps-uris. All known libraries (UML) will be pre-loaded if loadKnownResources is set to true.
	 * @param resourceSet resource set to be initialized
	 * @param loadKnownResources if true, all known libraries will be pre-loaded
	 * @return initialized resource set
	 */
	public static ResourceSet init(ResourceSet resourceSet, boolean loadKnownResources) {
		if(!Platform.isRunning()) { 
//			Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
//			URI baseURI = getBaseSupersedeResourceURI();
//			mapResourceURIs(uriMap, 
//					BASE_PATHMAP,
//					baseURI.appendSegment("resources")); //$NON-NLS-1$
		}
		
		SupersedeDSLResourceUtil.init(resourceSet);
		ExtendedUMLResourcesUtil.init(resourceSet);
		
		if(loadKnownResources) {
			resourceSet.getResource(Ecore_PrimitiveTypes.PACKAGE_URI, true);
			resourceSet.getResource(Java_PrimitiveTypes.PACKAGE_URI, true);
			resourceSet.getResource(UML_PrimitiveTypes.PACKAGE_URI, true);
			resourceSet.getResource(XML_PrimitiveTypes.PACKAGE_URI, true);
		}
		return resourceSet;
	}
	
	private static URI getBaseSupersedeResourceURI() {
		String catalogueUri = "pathmap://SUPERSEDE_DSL_LIBRARIES/SUPERSEDE.prop"; 
		URI nfpCatalogue = URI.createURI(catalogueUri);
		URL resultURL = SupersedeDSLLibraryResourcesUtil.class.getClassLoader().getResource(
			String.format("resources/%s", nfpCatalogue.lastSegment())); //$NON-NLS-1$

		URI result;

		if (resultURL != null) {
			result = URI.createURI(resultURL.toExternalForm(), true)
				.trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source
			// project folder layout
			resultURL = SupersedeDSLLibraryResourcesUtil.class.getResource("SupersedeDSLLibraryResourcesUtil.class"); //$NON-NLS-1$

			String baseURL = resultURL.toExternalForm();
			baseURL = baseURL.substring(0, baseURL.lastIndexOf("/bin/")); //$NON-NLS-1$
			result = URI.createURI(baseURL, true);
		}

		return result;
	}

	private static void mapResourceURIs(Map<URI, URI> uriMap,
			String uri, URI location) {
		URI prefix = URI.createURI(uri);
		
		// ensure trailing separator (make it a "URI prefix")
		if (!prefix.hasTrailingPathSeparator()) {
			prefix = prefix.appendSegment(""); //$NON-NLS-1$
		}

		// same with the location
		if (!location.hasTrailingPathSeparator()) {
			location = location.appendSegment(""); //$NON-NLS-1$
		}

		uriMap.put(prefix, location);

		// and platform URIs, too
		String folder = location.segment(location.segmentCount() - 2);
		String platformURI = String.format("%s/%s/", //$NON-NLS-1$
			ResourcesPlugin.PLUGIN_ID, folder);
		uriMap.put(URI.createPlatformPluginURI(platformURI, true), location);
		uriMap.put(URI.createPlatformResourceURI(platformURI, true), location);
	}
}
