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
	
	public List<URI> getMigrationResourceURIs() {
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
