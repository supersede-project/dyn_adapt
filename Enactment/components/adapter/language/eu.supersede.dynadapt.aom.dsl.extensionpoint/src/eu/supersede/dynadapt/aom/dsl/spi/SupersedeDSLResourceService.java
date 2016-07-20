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
package eu.supersede.dynadapt.aom.dsl.spi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import org.eclipse.emf.common.util.URI;

public class SupersedeDSLResourceService {
	private static SupersedeDSLResourceService service;
	private ServiceLoader<ISupersedeDSLResourceProvider> loader;
	
	private SupersedeDSLResourceService() {
		loader = ServiceLoader.load(ISupersedeDSLResourceProvider.class);
	}
	
	public static synchronized SupersedeDSLResourceService getInstance() {
		if(service == null)
			service = new SupersedeDSLResourceService();
		return service;
	}
	
	public List<URI> getSupersedeDSLResourceURIs() {
		List<URI> uris = new ArrayList<>();
		try {
			Iterator<ISupersedeDSLResourceProvider> providers = loader.iterator();
			while(providers.hasNext()) 
				uris.addAll(providers.next().getResourceURIs());
		} catch(ServiceConfigurationError serviceError) {
			;
		}
		return uris;
	}
}
