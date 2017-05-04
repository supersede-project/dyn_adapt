package eu.supersede.dynadapt.adapter.system;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

// TODO Store models locally within Adapter execution. Resolve them
public class ModelRepositoryMapping{
	public static URI getModelURI (ModelSystem system, RepositoryMetadata type) throws EnactmentException{
		switch (system) {
		case Atos:
			return  URI.createURI (atosMapping.get(type.getType()).get(type.getTimestamp()));
		case Atos_HSK:
			return  URI.createURI (atosHskMapping.get(type.getType()).get(type.getTimestamp()));
		case Health:
			return URI.createURI (healthMapping.get(type.getType()).get(type.getTimestamp()));
		case MonitoringReconfiguration:
			return 	URI.createURI(monitoringMapping.get(type.getType()).get(type.getTimestamp()));
		case Siemens:
			return URI.createURI(siemensMapping.get(type.getType()).get(type.getTimestamp()));
		default:
			//FIXME Other systems not supported
			throw new EnactmentException("System not supported " + system.getId());
		}
	}
	
	private static Map<ResourceType, Map<ResourceTimestamp, String>> atosMapping = new HashMap<>();
	private static Map<ResourceType, Map<ResourceTimestamp, String>> atosHskMapping = new HashMap<>();
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
		
		//ATOS HSK USE CASE
		Map<ResourceTimestamp, String> atosHskBaseModel = new HashMap<>();
		Map<ResourceTimestamp, String> atosHskFeatureConfiguration = new HashMap<>();
		atosHskBaseModel.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath + 
				"/models/base/atos_smart_base_model.uml");
		atosHskFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/SmartPlatformFC_HSK_LowLoad.yafc");
		atosHskFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/SmartPlatformFC_HSK_HighLoad.yafc");
		atosHskMapping.put(ResourceType.BASE, atosHskBaseModel);
		atosHskMapping.put(ResourceType.FEATURE_CONFIGURATION, atosHskFeatureConfiguration);
		
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
				"/models/base/BaseModel-S2.uml");
		siemensFeatureConfiguration.put(ResourceTimestamp.CURRENT, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/FeatureModel-S1c_dm.yafc");
		siemensFeatureConfiguration.put(ResourceTimestamp.NEWEST, ModelRepositoryResolver.repositoryRelativePath +
				"/features/configurations/FeatureModel-S1c_dm_optimized.yafc");
		siemensMapping.put(ResourceType.BASE, siemensBaseModel);
		siemensMapping.put(ResourceType.FEATURE_CONFIGURATION, siemensFeatureConfiguration);
	}
	
	public static void setModelURI (ModelSystem system, RepositoryMetadata type, String relativeModelPath) throws EnactmentException{
		Map<ResourceType, Map<ResourceTimestamp, String>> mapping = null;
		switch (system) {
			case Atos:
				mapping = atosMapping;
				break;
			case Atos_HSK:
				mapping = atosHskMapping;
				break;
			case Health:
				mapping = healthMapping;
				break;
			case MonitoringReconfiguration:
				mapping = monitoringMapping;
				break;
			case Siemens:
				mapping = siemensMapping;
				break;
			default:
				//FIXME Other systems not supported
				throw new EnactmentException("System not supported " + system.getId());
		}
		mapping.get(type.getType()).put(type.getTimestamp(), ModelRepositoryResolver.repositoryRelativePath + relativeModelPath);
	}
	
	
}