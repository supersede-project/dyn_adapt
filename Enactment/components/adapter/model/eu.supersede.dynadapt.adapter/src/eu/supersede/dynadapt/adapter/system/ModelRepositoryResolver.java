package eu.supersede.dynadapt.adapter.system;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;
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

// TODO Store models locally within Adapter execution. Resolve them
class ModelRepositoryMapping{
	public static URI getModelURI (SupersedeSystem system, RepositoryMetadata type) throws EnactmentException{
		switch (system) {
		case ATOS:
			return  URI.createURI (atosMapping.get(type.getType()).get(type.getTimestamp()));
		default:
			//FIXME Other systems not supported
			throw new EnactmentException("System not supported " + system.getURI());
		}
	}
	
	private static Map<ResourceType, Map<ResourceTimestamp, String>> atosMapping = new HashMap<>();
	static{
		Map<ResourceTimestamp, String> atosBaseModel = new HashMap<>();
		Map<ResourceTimestamp, String> atosFeatureConfiguration = new HashMap<>();
		
//		atosBaseModel.put(ResourceTimestamp.CURRENT, 
//				"platform:/resource/eu.supersede.dynadapt.usecases.atos/models/base/atos_base_model.uml");
//		atosFeatureConfiguration.put(ResourceTimestamp.CURRENT, 
//				"platform:/resource/eu.supersede.dynadapt.usecases.atos/features/configurations/AtosNormalCMSCapacityConfiguration.yafc");
//		atosFeatureConfiguration.put(ResourceTimestamp.NEWEST,
//				"platform:/resource/eu.supersede.dynadapt.usecases.atos/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc");

		
		atosBaseModel.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath + 
				"/models/base/atos_base_model.uml");
		atosFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/AtosNormalCMSCapacityConfiguration.yafc");
		atosFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc");
		atosMapping.put(ResourceType.BASE, atosBaseModel);
		atosMapping.put(ResourceType.FEATURE_CONFIGURATION, atosFeatureConfiguration);
	}
}
