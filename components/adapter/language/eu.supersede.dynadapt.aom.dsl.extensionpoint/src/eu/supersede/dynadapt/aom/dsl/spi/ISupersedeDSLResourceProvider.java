package eu.supersede.dynadapt.aom.dsl.spi;

import java.util.List;

import org.eclipse.emf.common.util.URI;

public interface ISupersedeDSLResourceProvider {
	List<URI> getResourceURIs();
}
