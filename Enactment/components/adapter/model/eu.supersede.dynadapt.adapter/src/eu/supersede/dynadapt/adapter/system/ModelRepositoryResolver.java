package eu.supersede.dynadapt.adapter.system;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.model.ModelManager;

public class ModelRepositoryResolver {
	static String repositoryRelativePath;
	private ModelManager mm = null;
	
	public ModelRepositoryResolver (ModelManager mm, String repositoryRelativePath){
		this.mm = mm;
		ModelRepositoryResolver.repositoryRelativePath = repositoryRelativePath;
	}

	public Model getModelForSystem (SupersedeSystem system, RepositoryMetadata metadata) throws EnactmentException{
		URI uri = ModelRepositoryMapping.getModelURI (system, metadata);
		return mm.loadUMLModel(uri.toString());
	}
	
	public FeatureConfiguration getConfigurationForSystem (SupersedeSystem system, RepositoryMetadata metadata) throws EnactmentException{
		URI uri = ModelRepositoryMapping.getModelURI (system, metadata);
		return mm.loadFeatureConfiguration(uri.toString());
	}
}
