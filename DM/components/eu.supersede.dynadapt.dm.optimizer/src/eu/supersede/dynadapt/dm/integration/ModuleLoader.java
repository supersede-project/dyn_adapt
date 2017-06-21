package eu.supersede.dynadapt.dm.integration;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.algorithm.SteadyStateGP;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.algorithm.ConstrainedNSGAII;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.optimizer.kpi.OptimizerKPIComputer;
import eu.supersede.dynadapt.dm.rest.FeatureConfiguration;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.ModelManager;
import eu.supersede.dynadapt.serializer.FMSerializer;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationAlertMessageListener;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationSubscriber;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationSubscriber;

@Component
public class ModuleLoader {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private AdapterProxy<?, ?> proxy;
	//Configuration
	DMOptimizationConfiguration config;
	//KPI Computer
	private OptimizerKPIComputer kpiComputer = new OptimizerKPIComputer();

	//@Autowired
	//private RequirementsJpa requirementsTable;

	public ModuleLoader() {
		proxy = new AdapterProxy<Object, Object>();
	}

	@PostConstruct
	public void init() {
		new Thread( new Runnable() {
			@Override
			public void run() {
				iAdaptationSubscriber subscriber = null;
				
				try {
					subscriber = new AdaptationSubscriber();
					subscriber.openTopicConnection();
					AdaptationAlertMessageListener messageListener = subscriber.createAdaptationAlertSubscriptionAndKeepListening();

					try {
						while( true ) {

							if (messageListener.areMessageReceived())
                            {
                                handleAlert(messageListener.getNextAlert());
                            }
                            else
                            {
                                Thread.sleep(1000); // FIXME Configure sleeping time
                            }
						}
					} catch( Exception e ) {
						e.printStackTrace();
					}
					subscriber.closeSubscription();
					subscriber.closeTopicConnection();
					
				}catch (JMSException e) {
					e.printStackTrace();
				}catch (NamingException e1)
                {
                    e1.printStackTrace();
                }finally
                {
                    if (subscriber != null)
                    {
                        try
                        {
                            subscriber.closeTopicConnection();
                        }
                        catch (JMSException e)
                        {
                            throw new RuntimeException("Error in closing topic connection", e);
                        }
                    }
                }
			}} ).start();
	}

	private void handleAlert(Alert alert) throws Exception
    {		
		log.debug("Handling alert: " + alert.getId() + ", " + alert.getApplicationId() + ", "
                + alert.getTenant() + ", " + alert.getTimestamp());
		
		//Check Alert for Atos HSK. Inject RT is case it is missing.
		if (alert.getTenant()==ModelSystem.Atos_HSK && !alert.getConditions().stream().anyMatch(
				c->c.getIdMonitoredData().getNameQualityMonitored().equals("response_time")))
			alert.getConditions().add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 1.0));
		
		//Check Alert for Siemens. Inject RT is case it is missing.
		if (alert.getTenant()==ModelSystem.Siemens && !alert.getConditions().stream().anyMatch(
				c->c.getIdMonitoredData().getNameQualityMonitored().equals("response_time"))){
			alert.getConditions().clear();
			alert.getConditions().add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 10.0));
		}
		
		// collect the parameters for the optimizer		
		//Generate grammar and attribute_metadata.json from fmURI
		//Inject  attribute_metadata.json in Parameters.ATTRIBUTE_Metadata
		//Generate feature.properties file for each FM quality attributes. Attribute values are taken from:
		// input FC->selection (feature)->attributeValue->value, if feature is selected in FC, otherwise
		// from FM->feature->attribute->defaultValue
		// Generate current configuration from input FC
		//String fmFolder = getFolder (fmURI);
		//Map qualityAttributePath to temporary folder where serialized files are placed.
		
		// Process Alert data	
		String fmURI = obtainFMURI(alert.getApplicationId(), alert.getTenant());
		String fcURI = obtainNameCurrentConfig(alert.getApplicationId(), alert.getTenant());
		String alertAttribute = alert.getConditions().get(0).getIdMonitoredData().getNameQualityMonitored();
		Double alertThresholdValue = alert.getConditions().get(0).getValue();
		ModelSystem system = alert.getTenant();
		
		processOptimization(system, fmURI, fcURI, alertAttribute, alertThresholdValue);
		
    }

	public FeatureConfiguration processOptimization(ModelSystem system, String fmURI, String fcURI, String alertAttribute, Double alertThresholdValue) throws Exception {
		kpiComputer.startComputingKPI();
		
		//Resolving relative URIs to execution directory
		fmURI = System.getProperty("user.dir") + "/" + fmURI;
		fcURI = System.getProperty("user.dir") + "/" + fcURI;
		
		//Creating temporary folder for serialized models
		Path path = Paths.get (new URI("file://" + getFolder(fmURI)));
		Path temporaryFolder = Files.createTempDirectory(path, "");
		String temp = temporaryFolder.toString();
		
		FMSerializer fms = new FMSerializer();
		
		fms.serializeFMToArtifactsInFolder(fmURI, temp);
		fms.serializeFCToArtifactsInFolder(fcURI, fmURI, temp);
		
		//Serializer saves model in a file with name <FM_name>.bnf, not in a file with name <FM_File_name.bnf>
		//so name needs to be retrieved from FM.getModelName
		ModelManager mm = new ModelManager();
		FeatureModel fm = mm.loadFM(fmURI);
		String modelURI = temp + "/"  + fm.getName() + ".bnf";
		
		setTenant(system);
		Parameters.ATTRIBUTE_METADATA = temp + "/"  + fm.getName() + ".json";
		String qualityAttributePath = temp;
		String currentConfig = temp + getFileNameOfPath(fcURI).replace ("yafc", "conf");
		
		Boolean multiObjective = Boolean.valueOf(
				DMOptimizationConfiguration.getProperty("multiobjective"));
		
		String optimalConfig = doOptimization(modelURI, currentConfig, qualityAttributePath, 
				alertAttribute, 
				alertThresholdValue, 
				multiObjective);

		log.debug("Computed optimal configuration: " + optimalConfig);
		FeatureConfiguration fc = new FeatureConfiguration(optimalConfig);
		
		//Generate a YAMFT FeatureConfiguration from optimalConfig. Return this FC
		List<String> selectedFeatureIds = new ArrayList<String>(Arrays.asList(fc.getOptimalConfig().split("\\s+")));
		
		//Remove empty entries
		selectedFeatureIds.removeAll(Arrays.asList(null,""));
		
		//Generate FC
		cz.zcu.yafmt.model.fc.FeatureConfiguration featureConf = 
				new FeatureConfigurationBuilder().buildFeatureConfiguration(fm, selectedFeatureIds);
		String newConfig = temp + getFileNameOfPath(fcURI).replace (".yafc", "_optimized.yafc");
		new ModelManager().saveFC(featureConf, org.eclipse.emf.common.util.URI.createFileURI(newConfig));
		
		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();
		
		//TODO Store optimal computed FCs onto the ModelRepository
		
		//Send FC to Adapter;
		Path fcPath = Paths.get(newConfig);
		String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
		
		boolean processEnactment = Boolean.valueOf(
				DMOptimizationConfiguration.getProperty("enactment.automatic_processing")); 
		if (processEnactment)
			proxy.enactAdaptationFCasString(system, featureConfigurationAsString);
		
		//Remove temporary file
		boolean removeTemp = Boolean.valueOf(
				DMOptimizationConfiguration.getProperty("temp_file.remove_after_computing"));
		if (removeTemp){
			//Remove all files within the temporary folder
			Files.walk(temporaryFolder).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
			Files.deleteIfExists(temporaryFolder);
		}
		
		return fc;
	}
	
	private void setTenant(ModelSystem tenant){
		switch (tenant) {
		case Atos:
		case Atos_HSK:
			Parameters.TENANT= Parameters.Tenants.ATOS;
			break;
		case Siemens:
			Parameters.TENANT= Parameters.Tenants.SIEMENS; 
			break;	
		case Senercon:
			Parameters.TENANT= Parameters.Tenants.SENERCON; 
			break;
		}
	}
	
	private String obtainFMURI(String appID, ModelSystem tenant){
		//TODO: Call Model Repository with these two parameters
		String uri = Parameters.INPUT_DIR + "fm/FeedbackGatheringConfig.yafm";
		switch (appID) {
		case "dynamic":
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION; break;
		case "feedback":
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING; break;	
		case "monitoring":
			Parameters.APPLICATION = Parameters.Applications.MONITORING; break;
		}
		
		switch (tenant) {
		case Atos:
		case Atos_HSK:
			Parameters.TENANT= Parameters.Tenants.ATOS; 
			uri = "input/atos_hsk/SmartPlatformFM_HSK.yafm";
			break;
		case Siemens:
			Parameters.TENANT= Parameters.Tenants.SIEMENS; 
			uri = "../../../Scenarios/Siemens/SiemensModels/FeatureModel-S1c_dm.yafm";
			break;
		case Senercon:
			Parameters.TENANT= Parameters.Tenants.SENERCON; break;
		}
		
		return uri;
	} 
	
	private String obtainNameCurrentConfig(String appID, ModelSystem tenant){
		//TODO: Call Model Repository with these two parameters
		String uri = Parameters.INPUT_DIR + "fc/FeedbackGatheringConfigCurrent.yafc";
		switch (appID) {
		case "dynamic":
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION; break;
		case "feedback":
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING; break;	
		case "monitoring":
			Parameters.APPLICATION = Parameters.Applications.MONITORING; break;
		}
		
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
			Parameters.TENANT= Parameters.Tenants.SENERCON; break;
		}
		return uri;
	} 
	
	private String getFolder (String urlString){
		return urlString.substring(0, urlString.lastIndexOf('/'));
	}
	
	private String getFileNameOfPath(String path) {
		// Return the file name in path
		return path.substring(path.lastIndexOf('/'));
	}
	
	private String doOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, Double alertThresholdValue, boolean multiObjective) {
		
		// get the tenant
		//Parameters.TENANT = Tenants.valueOf(alert.getTenant());
		
		if (!modelURI.isEmpty())
			Parameters.GRAMMAR_FILE = modelURI;
		
		if (!currentConfig.isEmpty())
			Parameters.CURRENT_CONFIGURATION = currentConfig;
		
		if (!qualityAttributePath.isEmpty())
			Parameters.FEATURE_ATTRIBUTE_PATH = qualityAttributePath;
		
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.SEARCH_BUDGET = 5; //00000;
		Parameters.POPULATION_SIZE = 50;
		
		Parameters.CONSTRAINT_THRESHOLD = alertThresholdValue;
		Parameters.ALERT_ATTRIBUTE = alertAttribute;
		int depth = 15;
		double probRecursive = 0.05;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		String optimalConfiguration = "";
		if (multiObjective){
			ConstrainedNSGAII nsgaii = new ConstrainedNSGAII(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
			List<Chromosome> solutions = nsgaii.generateSolution();
			StringBuffer sols = new StringBuffer();
			for (Chromosome c : solutions){
				sols.append("[" + c.getConfiguration().toString() + "],");
			}
			optimalConfiguration = sols.toString();
		}else{
			SteadyStateGP gp = new SteadyStateGP(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
			List<eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome> solutions = gp.generateSolution();
			eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome solution = solutions.get(0);
			log.debug(solution.getConfiguration().toString());
			optimalConfiguration = solution.getConfiguration().toString();
		}
		return optimalConfiguration;
	}
}
