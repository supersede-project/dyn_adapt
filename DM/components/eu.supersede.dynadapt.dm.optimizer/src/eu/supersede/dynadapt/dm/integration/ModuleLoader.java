package eu.supersede.dynadapt.dm.integration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cz.zcu.yafmt.model.fc.Selection;
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
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationUtility;
import eu.supersede.dynadapt.poc.feature.builder.ModelManager;
import eu.supersede.dynadapt.serializer.FMSerializer;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.ActionOnFeature;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationAlertMessageListener;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationSubscriber;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationSubscriber;

@Component
public class ModuleLoader {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private AdapterProxy<?, ?> proxy;
	public AdaptationDashboardProxy<?, ?> adaptationDashboardProxy;
	
	private ModelRepository mr;
	private eu.supersede.dynadapt.model.ModelManager mm;
	private static final String MODELS_AUTHOR = "Optimizer";
	private String repository;
	private String repositoryRelativePath;
	private Map<String, String> modelsLocation;
	
	//Configuration
	DMOptimizationConfiguration config;
	//KPI Computer
	private OptimizerKPIComputer kpiComputer = new OptimizerKPIComputer();

	//@Autowired
	//private RequirementsJpa requirementsTable;

	public ModuleLoader() throws Exception {
		proxy = new AdapterProxy<Object, Object>();
		
		//FIXME Take credentials to a properties file
		//FIXME To avoid FE session expires, create the proxy upon the reception of the alarm
		//this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		this.mm = new eu.supersede.dynadapt.model.ModelManager();
		
		String repositoryPath = Paths.get(System.getProperty("user.dir"), "/repository").toString().concat("/");
		this.repository = org.eclipse.emf.common.util.URI.createFileURI(repositoryPath).toString();
		this.repositoryRelativePath = "./repository";		
		//FIXME We shoul use platform URI instead, but dependencies to import StandaloneSetup cannot be resolved
		//String platformRelativePath = "../";
		//new StandaloneSetup().setPlatformUri(platformRelativePath);
		
		this.mr = new ModelRepository(repository, repositoryRelativePath, mm);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("configurations", "features/configurations/");
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

	public void handleAlert(Alert alert) throws Exception
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
		
		// According to the type of alert (if alert contains actions, it is deterministic): 
		boolean deterministicAlert = (alert.getActionAttributes()!=null) || (alert.getActionFeatures()!=null);
		
		//Registering dashboard proxy to initialize Front-end session
		this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		
		if(!deterministicAlert){
			//if tenant is feedback gathering, we read the other conditions
			if(system == ModelSystem.SenerconFG || system == ModelSystem.SiemensFG || system == ModelSystem.AtosFG){
				for(Condition cond: alert.getConditions()){
					switch (cond.getIdMonitoredData().getNameQualityMonitored()){
					case "attachment": 
						Parameters.FG_DISKC_ATTACHMENT = cond.getValue();
						break;
					case "screenshot": 
						Parameters.FG_DISKC_SCREENSHOT = cond.getValue();
						break;
					case "audio": 
						Parameters.FG_DISKC_AUDIO = cond.getValue();
						break;
					}
				}
			}
			// non-deterministic alert: optimizer
			processOptimization(system, fmURI, fcURI, alertAttribute, alertThresholdValue);
		}
		else {
			// deterministic alert: dispatcher
			processDeterministic(system, fmURI, fcURI, alert.getActionFeatures(), alert.getActionAttributes());
		}
		
    }
	
	public void processDeterministic(ModelSystem system, String fmURI, String fcURI, 
			List<ActionOnFeature> features, 
			List<ActionOnAttribute> attributes) throws Exception
	{
		kpiComputer.startComputingKPI();
		
		//Read feature configuration file
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse (new File(fcURI));

        //doc.getDocumentElement().normalize();
        //System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());

        Node nodeT = doc.getElementsByTagName("rootSelection").item(0);
        
        //XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = null;
        
		//Update the attributes
        for(ActionOnAttribute action : attributes){
        	String id[] = action.getId().split(".");
        	String  idAction = id[id.length-1];

        	if(id.length > 1){
            	for(int i=0; i<id.length-2; i++){
            		Element e = (Element) nodeT;
            		nodes = e.getElementsByTagName("selection");
            		for(int j=0; j< nodes.getLength(); j++){
            			Node attribute = nodes.item(j).getAttributes().getNamedItem("id");
                		if (attribute.getNodeValue().equals(id[i])){
                			nodeT = nodes.item(j);
                			break;
                		}
            		}
            	}
        	}
        	
        	Element e = (Element) nodeT;
        	nodes = e.getElementsByTagName("attributeValue");
        	for(int j=0; j< nodes.getLength(); j++){
    			Node attribute = nodes.item(j).getAttributes().getNamedItem("id");
        		if (attribute.getNodeValue().equals(idAction)){
        			nodeT = nodes.item(j);
        			break;
        		}
    		}
        	
         	switch(action.getTypeaction()){
	        	case decrease: 
	        		break;
	        	case increase: 
	        		break;
	        	case divide: 
	        		break;
	        	case multiply: 
	        		break;
	        	case update: 
	        		nodeT.getAttributes().getNamedItem("value").setNodeValue(Double.toString(action.getValue()));
	        		break;
        	}
         	
         	Path path = Paths.get (System.getProperty("user.dir"), getFolder(fmURI));
    		Path temporaryFolder = Files.createTempDirectory(path, "");
    		String temp = temporaryFolder.toString();
    		
         	Transformer xformer = TransformerFactory.newInstance().newTransformer();
         	xformer.transform(new DOMSource(doc), new StreamResult(new File(Paths.get(temp, getFileNameOfPath(fcURI).replace ("yafc", "conf")).toString())));
        	
        }
		//Update the features
		
		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();
		
		// Call the WP4
		
	}
	

	public FeatureConfiguration processOptimization(ModelSystem system, String fmURI, String fcURI, String alertAttribute, Double alertThresholdValue) throws Exception {
		kpiComputer.startComputingKPI();
		
		//Registering dashboard proxy to initialize Front-end session
		this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");

		
		//Resolving relative URIs to execution directory
//		fmURI = System.getProperty("user.dir") + "/" + fmURI;
		fcURI = System.getProperty("user.dir") + "/" + fcURI;
		
		//Creating temporary folder for serialized models
//		Path path = Paths.get (new URI("file://" + getFolder(fmURI)));
		Path path = Paths.get (System.getProperty("user.dir"), getFolder(fmURI));
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
		String currentConfig = Paths.get(temp, getFileNameOfPath(fcURI).replace ("yafc", "conf")).toString();
		
		Boolean multiObjective = Boolean.valueOf(
				DMOptimizationConfiguration.getProperty("multiobjective"));
		
		String optimalConfig = doOptimization(modelURI, currentConfig, qualityAttributePath, 
				alertAttribute, 
				alertThresholdValue, 
				multiObjective);

		log.debug("Computed optimal configuration: " + optimalConfig);
				
		//Generate a YAMFT Feature Configuration from optimalConfig. Return this FC
		FeatureConfiguration fc = new FeatureConfiguration(optimalConfig);
		List<String> selectedFeatureIds = new ArrayList<String>(Arrays.asList(fc.getOptimalConfig().split("\\s+")));
		selectedFeatureIds.removeAll(Arrays.asList(null,"")); //Remove empty entries
		cz.zcu.yafmt.model.fc.FeatureConfiguration newFeatureConfig = 
				new FeatureConfigurationBuilder().buildFeatureConfiguration(fm, selectedFeatureIds);
		String newFeatureConfigFileName = getFileNameOfPath(fcURI).replace (".yafc", "_optimized.yafc");
		String newFeatureConfigPath = Paths.get(temp, newFeatureConfigFileName).toString();
		//FIXME Shouldn't we use the model manager object created above?
		new ModelManager().saveFC(newFeatureConfig, org.eclipse.emf.common.util.URI.createFileURI(newFeatureConfigPath));
		
		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();
		
		// Upload the YAMFT Fature Configuration to the ModelRepository 
		String newFeatureConfigId = uploadLatestComputedFC(newFeatureConfig, newFeatureConfigFileName, system); // Populate metadata, status=Computed
		log.info("New optimal feature configuration " + newFeatureConfigId + " uploaded to repository");			
		
		// Load currently enacted Feature Configuration
		cz.zcu.yafmt.model.fc.FeatureConfiguration featureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);		
		log.info("Currently enacted feature configuration " + featureConfig.getName() + " downloaded from repository");
	
		// Notify Adaptation to the Dashboard 
		List<Selection> changedSelections = FeatureConfigurationUtility.diffFeatureConfigurations(featureConfig, newFeatureConfig);
		Adaptation adaptation = DashboardNotificationFactory.createAdaptation(newFeatureConfigId,
				String.format("%s %s", system.toString(), newFeatureConfigId),
				system,
				changedSelections, 
				kpiComputer.getInitialProcessingTime());
		adaptation = adaptationDashboardProxy.addAdaptation(adaptation);
		log.info("Adaptation " + newFeatureConfigId + " report sent to dashboard");
		
		// Send FC to Adapter;
		// FIXME This should not be neccessary in the last version
		Path fcPath = Paths.get(newFeatureConfigPath);
		String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
		
		boolean processEnactment = Boolean.valueOf(
				DMOptimizationConfiguration.getProperty("enactment.automatic_processing")); 
		if (processEnactment)
			proxy.enactAdaptationDecisionActionsForFC(system, newFeatureConfigId);
		
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
			String fcName, ModelSystem system) throws IOException, Exception {
//		String userdir = System.getProperty("user.dir");
//		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager (mm, mr);
		String modelId = prm.populateModel(
//				Paths.get(repositoryPath.toString(), "features/configurations", fcName), 
				fc,
				fcName,
				MODELS_AUTHOR,
				system, Status.Computed,
				modelsLocation.get("configurations"), 
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class,
				ModelType.FeatureConfiguration, 
				eu.supersede.integration.api.adaptation.types.FeatureConfiguration.class);
		return modelId;
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
		case SenerconFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.SENERCON;
			break;
		case SiemensFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.SIEMENS;
			break;
		case AtosFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.ATOS;
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
			Parameters.TENANT= Parameters.Tenants.SENERCON;break;
		case SenerconFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.SENERCON;
			uri = "input/senerconFG/FeedbackGatheringConfigV5.yafm";
			break;
		case SiemensFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.SIEMENS;
			uri = "input/siemensFG/FeedbackGatheringConfigCategory.yafm";
			break;
		case AtosFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.ATOS;
			uri = "input/atosFG/FeedbackGatheringConfigV5.yafm";
			break;
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
		case SenerconFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.SENERCON;
			uri = "input/senerconFG/FeedbackGatheringConfigV5.yafc";
			break;
		case SiemensFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.SIEMENS;
			uri = "input/siemensFG/FeedbackGatheringConfigCategory.yafc";
			break;
		case AtosFG:
			Parameters.APPLICATION = Parameters.Applications.FEEDBACK_GATHERING;
			Parameters.TENANT = Parameters.Tenants.ATOS;
			uri = "input/atosFG/FeedbackGatheringConfigV5.yafc";
			break;
		}
		return uri;
	} 
	
	private String getFolder (String urlString){
		return urlString.substring(0, urlString.lastIndexOf('/'));
	}
	
	private String getFileNameOfPath(String path) {
		// Return the file name in path
		return path.substring(path.lastIndexOf('/')+1);
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
		
		Parameters.CONSTRAINT_THRESHOLD = alertThresholdValue;// This value is not normalized 
		Parameters.ALERT_ATTRIBUTE = alertAttribute;
		int depth = 15;
		double probRecursive = 0.05;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		String optimalConfiguration = "";
		//multiObjective = true;
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
