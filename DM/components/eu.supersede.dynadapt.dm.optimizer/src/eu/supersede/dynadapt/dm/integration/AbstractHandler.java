package eu.supersede.dynadapt.dm.integration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.kpi.OptimizerKPIComputer;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public abstract class AbstractHandler {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected Alert alert;
	protected ModelRepository mr;
	protected ModelManager mm;
	protected Map<String, String> modelsLocation;
	protected AdaptationDashboardProxy<?, ?> adaptationDashboardProxy;
	protected AdapterProxy<?, ?> proxy;
	protected ModelSystem system;
	protected String modelAuthor;
	
	//Configuration
	protected DMOptimizationConfiguration config;	
	//KPI Computer
	protected OptimizerKPIComputer kpiComputer;
	private ResourceSet resourceSet;

	
	protected AbstractHandler(ModelSystem system, Alert alert, String modelAuthor) throws Exception{
		
		this.system = system;
		this.modelAuthor = modelAuthor;
		this.alert = alert; 
		
		resourceSet = new ResourceSetImpl();

		String repositoryPath = Paths.get(System.getProperty("user.dir"), "/repository").toString().concat("/");
		String repository = URI.createFileURI(repositoryPath).toString();
		String repositoryRelativePath = "./repository";		
		mr= new ModelRepository(repository, repositoryRelativePath);
		mm = new ModelManager();
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("configurations", "features/configurations/");
		
		//Registering dashboard proxy to initialize Front-end session Tenant (TODO?)
		this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", getTenant(this.system));
		proxy = new AdapterProxy<Object, Object>();		
		kpiComputer = new OptimizerKPIComputer();
	}
	
	/** 
	 * FIXME Take this method to PopulateRepositoryManager as it is duplicated in Adapter and
	 * Adapter's tests!!!
	 * Load the latest computed FeatureConfiguration for the given system.
	 * @param fc the latest {@link FeatureConfiguration} model
	 * @param fcName the name of the feature configuration file
	 * @param system the system owner of the adated model
	 * @return the id of the uploaded model in the model repository
	 * @throws IOException
	 * @throws Exception
	 */
	protected String uploadLatestComputedFC(cz.zcu.yafmt.model.fc.FeatureConfiguration fc,
			String fcName) throws IOException, Exception {
		PopulateRepositoryManager prm = new PopulateRepositoryManager (mm, mr);
		String modelId = prm.populateModel(fc, fcName, 
				modelAuthor, system, Status.Computed,
				modelsLocation.get("configurations"), 
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class,
				ModelType.FeatureConfiguration, 
				FeatureConfiguration.class);
		return modelId;
	}

	protected String getFolder (String urlString){
		return urlString.substring(0, urlString.lastIndexOf('/'));
	}
	
	protected String getFileNameOfPath(String path) {
		// Return the file name in path
		return path.substring(path.lastIndexOf('/')+1);
	}
	
	
	protected String getTenant(ModelSystem system){
		String tenant = "";
		switch(system){
		case Senercon:
		case SenerconFG:
		case SenerconFGcat:
		case SenerconMonitoring:
			tenant = "senercon"; break;
		case Siemens:
		case SiemensFG:
		case SiemensFGcat:
		case SiemensMonitoring:
			tenant = "siemens"; break;
		case Atos:
		case Atos_HSK:
		case AtosFG:
		case AtosFGcat:
		case AtosMonitoring:
			tenant = "atos"; break;
		}
		return tenant;
	}
	
	protected String obtainTemporaryURI(ModelSystem system){	
		String uri = "";
		switch (system) {
		case Atos:
		case Atos_HSK:
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION;
			Parameters.TENANT= Parameters.Tenants.ATOS; 
			uri = "input/atos_hsk/";
			break;
		case Siemens:
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION;
			Parameters.TENANT= Parameters.Tenants.SIEMENS; 
			uri = "input/siemens/";
			break;
		case Senercon:
		case SenerconFG:
		case SiemensFG:
		case AtosFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			uri = "input/senerconFG/";
			break;
		case SenerconFGcat:
		case SiemensFGcat:
		case AtosFGcat:
			uri = "input/senerconFG/category/";
			break;
		case MonitoringReconfiguration:
			Parameters.APPLICATION = Parameters.Applications.MONITORING;
			Parameters.TENANT = Parameters.Tenants.ATOS;
			uri = "input/httpMR/Scenario1/";
			break;
		}
		
		return uri;
	}
	protected String obtainFMURI(ModelSystem system){	
		String uri = "";
		switch (system) {
		case Atos:
		case Atos_HSK:
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION;
			Parameters.TENANT= Parameters.Tenants.ATOS; 
			uri = "input/atos_hsk/SmartPlatformFM_HSK.yafm";
			break;
		case Siemens:
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION;
			Parameters.TENANT= Parameters.Tenants.SIEMENS; 
			uri = "../../../Scenarios/Siemens/SiemensModels/FeatureModel-S1c_dm.yafm";
			break;
		case Senercon:
		case SenerconFG:
		case SiemensFG:
		case AtosFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			uri = "input/senerconFG/FeedbackGatheringConfigV5.yafm";
			break;
		case SenerconFGcat:
		case SiemensFGcat:
		case AtosFGcat:
			uri = "input/senerconFG/FeedbackGatheringConfigCategory.yafm";
			break;
		case MonitoringReconfiguration:
			Parameters.APPLICATION = Parameters.Applications.MONITORING;
			Parameters.TENANT = Parameters.Tenants.ATOS;
			uri = "input/httpMR/Scenario1/HttpMonitoringSystemTimeslotFeatureModel.yafm";
			break;
		}
		
		return uri;
	} 
	
	protected String obtainNameCurrentConfig(ModelSystem tenant){
		//TODO: Call Model Repository with these two parameters
		String uri = Parameters.INPUT_DIR + "fc/FeedbackGatheringConfigCurrent.yafc";		
		
		switch (tenant) {
		case Atos:
		case Atos_HSK:
			Parameters.TENANT= Parameters.Tenants.ATOS; 
			uri = "input/atos_hsk/SmartPlatformFC_HSK_LowLoad.yafc";
			break;
		case Siemens:
			Parameters.TENANT= Parameters.Tenants.SIEMENS; 
			uri = "../../../Scenarios/Siemens/SiemensModels/FeatureModel-S1c_dm.yafc";
			break;	
		case Senercon:
		case SenerconFG:
		case SiemensFG:
		case AtosFG:
			uri = "input/senerconFG/FeedbackGatheringConfigV5.yafc";
			break;
		case SenerconFGcat:
		case SiemensFGcat:
		case AtosFGcat:
			uri = "input/senerconFG/FeedbackGatheringConfigCategory.yafc";
			break;
		case MonitoringReconfiguration:
			Parameters.APPLICATION = Parameters.Applications.MONITORING;
			Parameters.TENANT = Parameters.Tenants.ATOS;
			uri = "input/httpMR/Scenario1/HttpMonitoringSystemConfigLowTimeslot.yafc";
			break;	
		}
		return uri;
	} 
	
	protected void saveFC(cz.zcu.yafmt.model.fc.FeatureConfiguration fc, URI fcURI) throws IOException{
		Resource resource = resourceSet.createResource(fcURI);
        resource.getContents().add(fc);
        resource.save(null);
	}


	protected void saveFM(cz.zcu.yafmt.model.fm.FeatureModel fm, URI fcURI) throws IOException{
		Resource resource = resourceSet.createResource(fcURI);
        resource.getContents().add(fm);
        resource.save(null);
	}
}
