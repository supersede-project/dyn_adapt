package eu.supersede.dynadapt.adapter.system;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;

// TODO Store models locally within Adapter execution. Resolve them
public class ModelRepositoryMapping{
	public static URI getModelURI (SupersedeSystem system, RepositoryMetadata type) throws EnactmentException{
		switch (system) {
		case ATOS:
			return  URI.createURI (atosMapping.get(type.getType()).get(type.getTimestamp()));
		case HEALTH:
			return URI.createURI (healthMapping.get(type.getType()).get(type.getTimestamp()));
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
	private static Map<ResourceType, Map<ResourceTimestamp, String>> healthMapping = new HashMap<>();
	private static Map<ResourceType, Map<ResourceTimestamp, String>> monitoringMapping = new HashMap<>();
	private static Map<ResourceType, Map<ResourceTimestamp, String>> siemensMapping = new HashMap<>();
	
	static{
		//ATOS USE CASE
		Map<ResourceTimestamp, String> atosBaseModel = new HashMap<>();
		Map<ResourceTimestamp, String> atosFeatureConfiguration = new HashMap<>();
		atosBaseModel.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath + 
				"/models/base/atos_base_model.uml");
		atosFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/AtosNormalCMSCapacityConfiguration.yafc");
		atosFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc");
		atosMapping.put(ResourceType.BASE, atosBaseModel);
		atosMapping.put(ResourceType.FEATURE_CONFIGURATION, atosFeatureConfiguration);
		
		//HEALTH USE CASE
		Map<ResourceTimestamp, String> healthBaseModel = new HashMap<>();
		Map<ResourceTimestamp, String> healthFeatureConfiguration = new HashMap<>();
		healthBaseModel.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath + 
				"/models/base/health_watcher.uml");
		healthFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/HealthNotAuthenticatedFeatureConfiguration.yafc");
		healthFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/HealthAuthenticatedFeatureConfiguration.yafc");
		healthMapping.put(ResourceType.BASE, healthBaseModel);
		healthMapping.put(ResourceType.FEATURE_CONFIGURATION, healthFeatureConfiguration);
		
		//MONITORUING USE CASE
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
		
		//SIEMENS USE CASE
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
	
	public static void setModelURI (SupersedeSystem system, RepositoryMetadata type, String relativeModelPath) throws EnactmentException{
		Map<ResourceType, Map<ResourceTimestamp, String>> mapping = null;
		switch (system) {
			case ATOS:
				mapping = atosMapping;
				break;
			case HEALTH:
				mapping = healthMapping;
				break;
			default:
				//FIXME Other systems not supported
				throw new EnactmentException("System not supported " + system.getURI());
		}
		mapping.get(type.getType()).put(type.getTimestamp(), ModelRepositoryResolver.repositoryRelativePath + relativeModelPath);
	}
	
	
}