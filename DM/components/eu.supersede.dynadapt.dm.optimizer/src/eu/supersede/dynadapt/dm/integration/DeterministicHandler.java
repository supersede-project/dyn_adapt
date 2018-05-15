package eu.supersede.dynadapt.dm.integration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fc.StringValue;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationUtility;
import eu.supersede.dynadapt.poc.feature.builder.ModelManager;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class DeterministicHandler extends AbstractHandler implements DecisionHandler {
	private static final String MODELS_AUTHOR = "dmDeterministic";
	
	public DeterministicHandler(ModelSystem system, Alert alert) throws Exception {
		
		super(system, alert, MODELS_AUTHOR);
	}
	
	@Override
	public void handle() throws Exception {
		
		kpiComputer.startComputingKPI();
		
		switch (alert.getTenant()) {
		case SenerconFGcat:
			handleFG();
			break;
		case AtosMonitoring:
			handleMonitoring();
			break;
		default:
			// unhandled case, thorw runtime exception?
			break;
		}
		
				
	}

	/**
	 * 
	 */
	private void handleFG() throws Exception {
		List<ActionOnAttribute> attributes = alert.getActionAttributes();
		
		//Creating temporary folder for serialized models
		Path path = Paths.get(System.getProperty("user.dir"), obtainTemporaryURI(system));
		Path temporaryFolder = Files.createTempDirectory(path, "");
		String temp = temporaryFolder.toString();
		
		FeatureConfiguration newFeatureConfig, featureConfig ;
		//Change this variable if you should call to the model repository
		boolean test = false;
		if (!test){
			// Load currently enacted Feature Configuration
			newFeatureConfig = mr.getLastEnactedFeatureConfigurationForSystem(ModelSystem.SenerconFGcat);
			//Copy model in a temporary folder
			saveFC(newFeatureConfig, URI.createFileURI(temp + "/" + newFeatureConfig.getName() + ".yafc"));
			featureConfig = mm.loadFeatureConfiguration(temp + "/" + newFeatureConfig.getName() + ".yafc");
		}
		else{
			String fcURI = obtainNameCurrentConfig(alert.getTenant());
			newFeatureConfig = mm.loadFeatureConfiguration(fcURI);
			featureConfig = new ModelManager().loadFC(fcURI);
		}
		log.info("Currently enacted feature configuration " + newFeatureConfig.getName() + " downloaded from repository");
		
		
		
		//*****Update feature configuration*****
		for(ActionOnAttribute action : attributes){
	        
			Selection nodeT = newFeatureConfig.getRoot();
			EList<Selection> nodes;
			
			log.info("Action : " + action.getId() );
	    	String[] id = action.getId().split("\\.");
	    	String  idAction = id[id.length-1];

	    	if(id.length > 1){
	        	for(int i=0; i<id.length-1; i++){
	        		nodes = nodeT.getSelections();
	        		for(int j=0; j< nodes.size(); j++){
	        			//Node attribute = ;
	            		if (nodes.get(j).getId().equals(id[i])){
	            			nodeT = nodes.get(j);
	            			break;
	            		}
	        		}
	        	}
	    	}
	    	
	    	EList<AttributeValue> attr = nodeT.getValues();
	    	AttributeValue updateAttribute = null; 
        	for(int j=0; j< attr.size(); j++){
        		if (attr.get(j).getId().equals(idAction)){
        			updateAttribute = attr.get(j);
        			break;
        		}
    		}
        	
        	if (updateAttribute != null){
             	switch(action.getTypeaction()){
	        	case decrease: 
	        	case increase: 
	        	case divide: 
	        	case multiply: 
	        		break;
	        	case update: 
	        		if(updateAttribute instanceof BooleanValue){
	        			((BooleanValue)updateAttribute).setValue(action.getValue()>0);
	        		}
	        		else if(updateAttribute instanceof IntegerValue){
	        				((IntegerValue)updateAttribute).setValue((int)action.getValue());
	        			}
	        			else if(updateAttribute instanceof DoubleValue){
	        					((DoubleValue)updateAttribute).setValue(action.getValue());
	        				}
	        				else if(updateAttribute instanceof StringValue){
	        					((StringValue)updateAttribute).setValue(Double.toString(action.getValue()));
	        				}
	        		break;
         		}        		
        	}
		}

		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();

		// *****Call Adapter****
		String newFeatureConfigFileName = newFeatureConfig.getName() + "_updated.yafc";
		     	
		// Upload the YAMFT Fature Configuration to the ModelRepository 
		String newFeatureConfigId = this.uploadLatestComputedFC(newFeatureConfig, newFeatureConfigFileName); // Populate metadata, status=Computed
		log.info("New optimal feature configuration " + newFeatureConfigId + " uploaded to repository");			
		
		// Load currently enacted Feature Configuration
		//FeatureConfiguration featureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);		
		//log.info("Currently enacted feature configuration " + featureConfig.getName() + " downloaded from repository");
	
		// Notify Adaptation to the Dashboard 
		List<Selection> changedSelections = FeatureConfigurationUtility.diffFeatureConfigurations(featureConfig, newFeatureConfig);
		Adaptation adaptation = DashboardNotificationFactory.createAdaptation(newFeatureConfigId,
				String.format("%s %s", system.toString(), newFeatureConfigId),
				system,
				changedSelections, 
				kpiComputer.getInitialProcessingTime(),
				true);
		adaptation = adaptationDashboardProxy.addAdaptation(adaptation);
		log.info("Adaptation " + newFeatureConfigId + " report sent to dashboard");
		
		// ******Send FC to Adapter******
		boolean processEnactment = Boolean.valueOf(DMOptimizationConfiguration.getProperty("enactment.automatic_processing")); 
		if (processEnactment)
			proxy.enactAdaptationDecisionActionsForFC(system, newFeatureConfigId);
		
		
		//Delete temporary files

		
	}

	/**
	 * 
	 */
	private void handleMonitoring() throws Exception {
		String applicationId = alert.getApplicationId();
		ModelSystem tenant = alert.getTenant();

		double action = 0;
		for(Condition cond: alert.getConditions()){
			if ("startMonitor".equalsIgnoreCase(cond.getIdMonitoredData().getNameQualityMonitored())) {
				action = cond.getValue(); // value of 1d expected here ==> enable monitor
				break;
			}
		}
		
		if (action == 1d) {
		
			// First determine the default configuration depending on the tenant
			String defaultConfig = "";
			switch (tenant) {
			case AtosMonitoring:
				defaultConfig = "low_timeslot";
				break;
			default:
				log.error("unsupported tenant: {}", tenant);
				break;
			}
			
			
			//Creating temporary folder for storing models
			Path path = Paths.get(System.getProperty("user.dir"), obtainTemporaryURI(system));
			Path temporaryFolder = Files.createTempDirectory(path, "");
			String temp = temporaryFolder.toString();
			
			
			List<String> selectedFeatureIds = new ArrayList<String>(Arrays.asList(defaultConfig.split("\\s+")));
			selectedFeatureIds.removeAll(Arrays.asList(null,"")); //Remove empty entries
			
			String fmURI = obtainFMURI(alert.getTenant());
			FeatureModel fm = mm.loadFeatureModel(fmURI);
			FeatureConfigurationBuilder featureConfigurationBuilder = new FeatureConfigurationBuilder();
			FeatureConfiguration newFeatureConfig = featureConfigurationBuilder.buildFeatureConfiguration(fm, selectedFeatureIds);
			
			List<String> currentConfigIds = new ArrayList<String>(); //monitor is disabled 
			FeatureConfiguration currentConfig = featureConfigurationBuilder.buildFeatureConfiguration(fm, currentConfigIds);
			
			String newFeatureConfigFileName = getFileNameOfPath(fmURI).replace (".yafm", "_optimized.yafc");
			String newFeatureConfigPath = Paths.get(temp, newFeatureConfigFileName).toString();
			
			//Copy the new configuration in a temporary folder
			saveFC(newFeatureConfig, org.eclipse.emf.common.util.URI.createFileURI(newFeatureConfigPath));
			
			kpiComputer.stopComputingKPI();
			kpiComputer.reportComputedKPI();
			
			//******** Call WP4********
			// Upload the YAMFT Fature Configuration to the ModelRepository 
			String newFeatureConfigId = uploadLatestComputedFC(newFeatureConfig, newFeatureConfigFileName); // Populate metadata, status=Computed
			log.info("New optimal feature configuration " + newFeatureConfigId + " uploaded to repository");			
			
			// Notify Adaptation to the Dashboard 
			List<Selection> changedSelections = FeatureConfigurationUtility.diffFeatureConfigurations(currentConfig, newFeatureConfig);
			Adaptation adaptation = DashboardNotificationFactory.createAdaptation(newFeatureConfigId,
					String.format("%s %s", system.toString(), newFeatureConfigId),
					system,
					changedSelections, 
					kpiComputer.getInitialProcessingTime(),
					false);
		
			adaptation = adaptationDashboardProxy.addAdaptation(adaptation);
			log.info("Adaptation " + newFeatureConfigId + " report sent to dashboard");
			
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
			
			log.debug("DETERMINISTIC: {} : start monitor with configuration: {}", applicationId, defaultConfig);
				
		
		}else {
			// received disable monitor action? stop monitor?
			log.debug("DETERMINISTIC : {} stop monitor.", applicationId);
		}
		
	}
	
	/*//Old version using xml
	public void processDeterministic(ModelSystem system, String fmURI, String fcURI, 
			List<ActionOnFeature> features, 
			List<ActionOnAttribute> attributes) throws Exception
	{
		kpiComputer.startComputingKPI();
		
		//Read feature configuration file
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse (new File(fcURI));
        
        //XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = null;

        //Update the features

		//Update the attributes
        for(ActionOnAttribute action : attributes){
            Node nodeT = doc.getElementsByTagName("rootSelection").item(0);

        	log.info("Action : " + action.getId() );
        	String[] id = action.getId().split("\\.");
        	String  idAction = id[id.length-1];

        	if(id.length > 1){
            	for(int i=0; i<id.length-1; i++){
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
	        		switch(nodeT.getAttributes().getNamedItem("xsi:type").getNodeValue()){
	        		case "fc:string":
		        		nodeT.getAttributes().getNamedItem("value").setNodeValue(Double.toString(action.getValue()));
		        		break;
	        		case "fc:integer":
	        			nodeT.getAttributes().getNamedItem("value").setNodeValue((Integer.toString((int)action.getValue())));
		        		break;
	        		case "fc:double":
	        			nodeT.getAttributes().getNamedItem("value").setNodeValue(Double.toString(action.getValue()));
	        			break;
	        		}
	        		break;
        	}      	
        }
        
        //Save changes in the temporary folder
     	Path path = Paths.get (System.getProperty("user.dir"), getFolder(fmURI));
		Path temporaryFolder = Files.createTempDirectory(path, "");
		String temp = temporaryFolder.toString();
		
     	Transformer xformer = TransformerFactory.newInstance().newTransformer();
     	String newFeatureConfigFileName = getFileNameOfPath(fcURI).replace (".yafc", "_updated.yafc");
     	Path pathName = Paths.get(temp, newFeatureConfigFileName);
     	xformer.transform(new DOMSource(doc), new StreamResult(new File(pathName.toString())));
		
     	//Save in the model manager
     	//new ModelManager().saveFC(newFeatureConfig, org.eclipse.emf.common.util.URI.createFileURI(pathName.toString()));
     	
		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();
		
		cz.zcu.yafmt.model.fc.FeatureConfiguration newFeatureConfig = FeatureConfigurationFactory.eINSTANCE.createFeatureConfiguration();
		//TODO : charge the feature model updated
		//newFeatureConfig.

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
		//Path fcPath = Paths.get(pathName.toString());
		String featureConfigurationAsString = new String(Files.readAllBytes(pathName));
		
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
		
	}
	
	 * */

	
}
