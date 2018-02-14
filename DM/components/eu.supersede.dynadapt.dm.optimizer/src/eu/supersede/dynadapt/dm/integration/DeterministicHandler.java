package eu.supersede.dynadapt.dm.integration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;
import eu.supersede.dynadapt.dm.optimizer.kpi.OptimizerKPIComputer;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationUtility;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.ActionOnFeature;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fc.StringValue;

public class DeterministicHandler implements DecisionHandler {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ModelRepository mr;
	private ModelManager mm;
	private Map<String, String> modelsLocation;
	private AdaptationDashboardProxy<?, ?> adaptationDashboardProxy;
	private AdapterProxy<?, ?> proxy;
	private ModelSystem system;
	
	//Configuration
	private DMOptimizationConfiguration config;	
	//KPI Computer
	private OptimizerKPIComputer kpiComputer;
	private static final String MODELS_AUTHOR = "dmDeterministic";
	
	public DeterministicHandler(ModelSystem system) throws Exception {
		this.system = system;

		String repositoryPath = Paths.get(System.getProperty("user.dir"), "/repository").toString().concat("/");
		String repository = URI.createFileURI(repositoryPath).toString();
		String repositoryRelativePath = "./repository";		
		mr= new ModelRepository(repository, repositoryRelativePath);
		mm = new ModelManager();
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("configurations", "features/configurations/");
		
		//Registering dashboard proxy to initialize Front-end session Tenant (TODO?)
		//this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", system.name());
		proxy = new AdapterProxy<Object, Object>();		
		kpiComputer = new OptimizerKPIComputer();
	}
	
	@Override
	public void handle(String fmURI, String fcURI, List<ActionOnFeature> features,
			List<ActionOnAttribute> attributes, String alertAttribute, Double valueThreshold) throws Exception {
		
		kpiComputer.startComputingKPI();
		
		// Load currently enacted Feature Configuration
		FeatureConfiguration newFeatureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);		
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
	            		if (nodes.get(j).equals(id[i])){
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
	        		if(updateAttribute.eClass().equals(BooleanValue.class)){
	        			((BooleanValue)updateAttribute).setValue(action.getValue()>0);
	        		}
	        		else{
	        			if(updateAttribute.eClass().equals(IntegerValue.class)){
	        				((IntegerValue)updateAttribute).setValue((int)action.getValue());
	        			}
	        			else{
	        				if(updateAttribute.eClass().equals(DoubleValue.class)){
	        					((DoubleValue)updateAttribute).setValue(action.getValue());
	        				}
	        				else{//String
	        					((StringValue)updateAttribute).setValue(Double.toString(action.getValue()));
	        				}
	        			}
	        		}
	        		break;
         		}        		
        	}
		}
				
		//*****Save updated feature configuration*****
		String newFeatureConfigFileName = newFeatureConfig.getName().replace (".yafc", "_updated.yafc");
     	
		// Upload the YAMFT Fature Configuration to the ModelRepository 
		String newFeatureConfigId = new FeatureUtils(mr,mm).uploadLatestComputedFC(newFeatureConfig, newFeatureConfigFileName, system,
				MODELS_AUTHOR, modelsLocation.get("configurations")); // Populate metadata, status=Computed
		log.info("New optimal feature configuration " + newFeatureConfigId + " uploaded to repository");			
		

		// *****Call Adapter****
		// Load currently enacted Feature Configuration
		FeatureConfiguration featureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);		
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
		boolean processEnactment = Boolean.valueOf(DMOptimizationConfiguration.getProperty("enactment.automatic_processing")); 
		if (processEnactment)
			proxy.enactAdaptationDecisionActionsForFC(system, newFeatureConfigId);
		
		
		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();
		
		
	}

	
}
