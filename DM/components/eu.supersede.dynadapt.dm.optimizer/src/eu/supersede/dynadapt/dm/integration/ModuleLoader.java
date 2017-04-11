package eu.supersede.dynadapt.dm.integration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.algorithm.SteadyStateGP;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.algorithm.ConstrainedNSGAII;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.rest.FeatureConfiguration;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.ModelManager;
import eu.supersede.dynadapt.serializer.FMSerializer;
import eu.supersede.integration.api.adaptation.types.Alert;

import eu.supersede.integration.api.pubsub.adaptation.AdaptationAlertMessageListener;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationSubscriber;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationSubscriber;

@Component
public class ModuleLoader {

	//@Autowired
	//private RequirementsJpa requirementsTable;

	public ModuleLoader() {

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
					} catch( InterruptedException e ) {
						e.printStackTrace();
					}
					subscriber.closeSubscription();
					subscriber.closeTopicConnection();
					
				}catch (URISyntaxException u){
					u.printStackTrace();
				}catch(IOException i){
					i.printStackTrace();
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

	public void handleAlert(Alert alert) throws IOException, URISyntaxException
    {		
		System.out.println("Handling alert: " + alert.getId() + ", " + alert.getApplicationId() + ", "
                + alert.getTenant() + ", " + alert.getTimestamp());
		
		// collect the parameters for the optimizer		
		//Generate grammar and attribute_metadata.json from fmURI
		//Inject  attribute_metadata.json in Parameters.ATTRIBUTE_Metadata
		//Generate feature.properties file for each FM quality attributes. Attribute values are taken from:
		// input FC->selection (feature)->attributeValue->value, if feature is selected in FC, otherwise
		// from FM->feature->attribute->defaultValue
		// Generate current configuration from input FC
		//String fmFolder = getFolder (fmURI);
		//Map qualityAttributePath to temporary folder where serialized files are placed.
		
		//Creating temporary folder for serialized models		
		String fmURI = obtainFMURI(alert.getApplicationId(), alert.getTenant());
		String fcURI = obtainNameCurrentConfig(alert.getApplicationId(), alert.getTenant());
		
		Path path = Paths.get (new URI("file://" + getFolder(fmURI)));
		Path temporaryFolder = Files.createTempDirectory(path, "");
		String temp = temporaryFolder.toString();
		
		FMSerializer.serializeFMToArtifactsInFolder(fmURI, temp);
		FMSerializer.serializeFCToArtifactsInFolder(fcURI, fmURI, temp);
		
		String modelURI = temp + getFileNameOfPath(fmURI).replace("yafm", "bnf");
		Parameters.ATTRIBUTE_METADATA = temp + getFileNameOfPath(fmURI).replace("yafm", "json");
		String qualityAttributePath = temp;
		String currentConfig = temp + getFileNameOfPath(fcURI).replace ("yafc", "conf");
		
		Boolean multiObjective = false; //TODO: how to determine this parameter??
		
		String optimalConfig = doOptimization(modelURI, currentConfig, qualityAttributePath, 
				alert.getConditions().get(0).getIdMonitoredData().getNameQualityMonitored() /*alertAttribute*/, 
				alert.getConditions().get(0).getValue() /*alertThresholdValue*/, 
				multiObjective, alert);
//		if (!multiObjective){
//			optimalConfig = doSOOptimization (modelURI, currentConfig, qualityAttributePath, 
//					alert.getConditions().get(0).getIdMonitoredData().getNameQualityMonitored() /*alertAttribute*/, 
//					alert.getConditions().get(0).getValue() /*alertThresholdValue*/);
//		}else{
//			optimalConfig = doMOOptimization (modelURI, currentConfig, qualityAttributePath, 
//					alert.getConditions().get(0).getIdMonitoredData().getNameQualityMonitored() /*alertAttribute*/, 
//					alert.getConditions().get(0).getValue() /*alertThresholdValue*/);
//		}
		System.out.println(optimalConfig);
		FeatureConfiguration fc = new FeatureConfiguration(optimalConfig);
		
		//Generate a YAMFT FeatureConfiguration from optimalConfig. Return this FC
		ModelManager mm = new ModelManager();		
		FeatureModel fm = mm.loadFM(fmURI);
		List<String> selectedFeatureIds = new ArrayList<String>(Arrays.asList(fc.getOptimalConfig().split("\\s+")));
		
		//Remove empty entries
		selectedFeatureIds.removeAll(Arrays.asList(null,""));
		//FIXME selected feature ids should be feature ids and no names. Current workaround is get the feature corresponding to the name, and get the id
		// assuming FM does no contains features with duplicated names: TODO Discuss fix with Fitsum
		//selectedFeatureIds = selectedFeatureIds.stream().map(name->FeatureModelUtility.getFeatureByName(fm, name).getId()).collect(Collectors.toList());
		cz.zcu.yafmt.model.fc.FeatureConfiguration featureConf = 
				new FeatureConfigurationBuilder().buildFeatureConfiguration(fm, selectedFeatureIds);
		String newConfig = temp + getFileNameOfPath(fcURI).replace (".yafc", "_optimized.yafc");
		new ModelManager().saveFC(featureConf, org.eclipse.emf.common.util.URI.createFileURI(newConfig));
		
		//TODO Delete a temporary folder during Optimizer shutdown
		//TODO send fc to Adapter;
    }
	
	private String obtainFMURI(String appID, String tenant){
		//TODO: Call Model Repository with these two parameters
		switch (appID) {
		case "dynamic":
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION; break;
		case "feedback":
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING; break;	
		case "monitoring":
			Parameters.APPLICATION = Parameters.Applications.MONITORING; break;
		}
		
		switch (tenant) {
		case "atos":
			Parameters.TENANT= Parameters.Tenants.ATOS; break;
		case "siemens":
			Parameters.TENANT= Parameters.Tenants.SIEMENS; break;	
		case "senercon":
			Parameters.TENANT= Parameters.Tenants.SENERCON; break;
		}
		
		return Parameters.INPUT_DIR + "fm/FeedbackGatheringConfig.yafm";
	} 
	
	private String obtainNameCurrentConfig(String appID, String tenant){
		//TODO: Call Model Repository with these two parameters
		switch (appID) {
		case "dynamic":
			Parameters.APPLICATION = Parameters.Applications.DYNAMIC_ADAPTATION; break;
		case "feedback":
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING; break;	
		case "monitoring":
			Parameters.APPLICATION = Parameters.Applications.MONITORING; break;
		}
		
		switch (tenant) {
		case "atos":
			Parameters.TENANT= Parameters.Tenants.ATOS; break;
		case "siemens":
			Parameters.TENANT= Parameters.Tenants.SIEMENS; break;	
		case "senercon":
			Parameters.TENANT= Parameters.Tenants.SENERCON; break;
		}
		return Parameters.INPUT_DIR + "fc/FeedbackGatheringConfigCurrent.yafc";
	} 
	
	private String getFolder (String urlString){
		return urlString.substring(0, urlString.lastIndexOf('/'));
	}
	
	private String getFileNameOfPath(String path) {
		// Return the file name in path
		return path.substring(path.lastIndexOf('/'));
	}
	
	private String doOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, Double alertThresholdValue, boolean multiObjective, Alert alert) {
		
		// get the tenant
		//Parameters.TENANT = Tenants.valueOf(alert.getTenant());
		
		if (!modelURI.isEmpty())
			Parameters.GRAMMAR_FILE = modelURI;
		
		if (!currentConfig.isEmpty())
			Parameters.CURRENT_CONFIGURATION = currentConfig;
		
		if (!qualityAttributePath.isEmpty())
			Parameters.FEATURE_ATTRIBUTE_PATH = qualityAttributePath;
		
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.SEARCH_BUDGET = 5;
		Parameters.POPULATION_SIZE = 150;
		
		Parameters.CONSTRAINT_THRESHOLD = alertThresholdValue;
		Parameters.ALERT_ATTRIBUTE = alertAttribute;
		int depth = 15;
		double probRecursive = 0.005;
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
			System.out.println(solution.getConfiguration().toString());
			optimalConfiguration = solution.getConfiguration().toString();
		}
		return optimalConfiguration;
	}
//	private String doMOOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, Double alertThresholdValue) {
//		if (!modelURI.isEmpty())
//			Parameters.GRAMMAR_FILE = modelURI;
//		
//		if (!currentConfig.isEmpty())
//			Parameters.CURRENT_CONFIGURATION = currentConfig;
//		
//		if (!qualityAttributePath.isEmpty())
//			Parameters.FEATURE_ATTRIBUTE_PATH = qualityAttributePath;
//		
//		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
//		Parameters.SEARCH_BUDGET = 5;
//		Parameters.CONSTRAINT_THRESHOLD = alertThresholdValue; // 30;
//		Parameters.ALERT_ATTRIBUTE = alertAttribute;
//		Parameters.POPULATION_SIZE = 150;
//		int depth = 15;
//		double probRecursive = 0.05;
//		Parameters.CROSSOVER_RATE = 0.6;
//		Parameters.MUTATION_RATE = 0.2;
//		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
//		ConstrainedNSGAII nsgaii = new ConstrainedNSGAII(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
//		List<Chromosome> solutions = nsgaii.generateSolution();
//		StringBuffer sols = new StringBuffer();
//		for (Chromosome c : solutions){
//			sols.append("[" + c.getConfiguration().toString() + "],");
//		}
//		return sols.toString();
//	}
//	
//	private String doSOOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, Double alertThresholdValue) {
//		if (!modelURI.isEmpty())
//			Parameters.GRAMMAR_FILE = modelURI;
//		
//		if (!currentConfig.isEmpty())
//			Parameters.CURRENT_CONFIGURATION = currentConfig;
//		
//		if (!qualityAttributePath.isEmpty())
//			Parameters.FEATURE_ATTRIBUTE_PATH = qualityAttributePath;
//		
//		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
//		Parameters.SEARCH_BUDGET = 5;
//		Parameters.CONSTRAINT_THRESHOLD = alertThresholdValue;
//		Parameters.ALERT_ATTRIBUTE = alertAttribute;
//		Parameters.POPULATION_SIZE = 150;
//		int depth = 15;
//		double probRecursive = 0.005;
//		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
//		SteadyStateGP gp = new SteadyStateGP(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
//		List<eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome> solutions = gp.generateSolution();
//		eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome solution = solutions.get(0);
//		System.out.println(solution.getConfiguration().toString());
//		return solution.getConfiguration().toString();
//	}
	
}
