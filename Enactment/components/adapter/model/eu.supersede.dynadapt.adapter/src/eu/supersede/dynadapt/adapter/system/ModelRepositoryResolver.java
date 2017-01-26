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
		case MONITORING:
			return 	URI.createURI(monitoringMapping.get(type.getType()).get(type.getTimestamp()));
		case SIEMENS:
			return URI.createURI(siemensMapping.get(type.getType()).get(type.getTimestamp()));
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
	
	private static Map<ResourceType, Map<ResourceTimestamp, String>> monitoringMapping = new HashMap<>();
	static{
		Map<ResourceTimestamp, String> monitoringBaseModel = new HashMap<>();
		Map<ResourceTimestamp, String> monitoringFeatureConfiguration = new HashMap<>();
		
		monitoringBaseModel.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath + 
				"/models/base/MonitoringSystemBaseModel.uml");
		monitoringFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/MonitoringSystemConfigDefault.yafc");
		monitoringFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/MonitoringSystemConfigHighTimeslot.yafc");
		monitoringMapping.put(ResourceType.BASE, monitoringBaseModel);
		monitoringMapping.put(ResourceType.FEATURE_CONFIGURATION, monitoringFeatureConfiguration);
	}
	
	private static Map<ResourceType, Map<ResourceTimestamp, String>> siemensMapping = new HashMap<>();
	static{
		Map<ResourceTimestamp, String> siemensBaseModel = new HashMap<>();
		Map<ResourceTimestamp, String> siemensFeatureConfiguration = new HashMap<>();
		
		siemensBaseModel.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath + 
				"/models/base/BaseModel-S1.uml");
		siemensFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/FeatureConfiguration-S1.yafc");
		siemensFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/FeatureConfiguration-S1.yafc");
		siemensMapping.put(ResourceType.BASE, siemensBaseModel);
		siemensMapping.put(ResourceType.FEATURE_CONFIGURATION, siemensFeatureConfiguration);
	}
}
