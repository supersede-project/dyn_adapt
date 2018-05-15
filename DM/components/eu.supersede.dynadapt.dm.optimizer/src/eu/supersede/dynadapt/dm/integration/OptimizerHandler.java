package eu.supersede.dynadapt.dm.integration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.algorithm.SteadyStateGP;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.algorithm.ConstrainedNSGAII;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.rest.FeatureConfiguration;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationUtility;
import eu.supersede.dynadapt.serializer.FMSerializer;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.AttachedValue;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class OptimizerHandler extends AbstractHandler implements DecisionHandler {
	private static final String MODELS_AUTHOR = "dmOptimizer";

	private boolean deterministic = false;
	public OptimizerHandler(ModelSystem system, Alert alert) throws Exception{
		
		super(system, alert, MODELS_AUTHOR); 

		//if tenant is feedback gathering, we read the other conditions
		if(system == ModelSystem.SenerconFG || system == ModelSystem.SiemensFG || system == ModelSystem.AtosFG){
			for(AttachedValue cond: alert.getAttachedValues()){
				switch (cond.getIdData()){
				case "attachment": 
					Parameters.FG_DISKC_ATTACHMENT = Double.parseDouble(cond.getValue());
					break;
				case "screenshot": 
					Parameters.FG_DISKC_SCREENSHOT = Double.parseDouble(cond.getValue());
					break;
				case "audio": 
					Parameters.FG_DISKC_AUDIO = Double.parseDouble(cond.getValue());
					break;
				}
			}
		}else if(system == ModelSystem.AtosMonitoringTimeSlot) {
			String alertAttr = "response_time";
			for(Condition cond: alert.getConditions()){
				if (alertAttr.equalsIgnoreCase(cond.getIdMonitoredData().getNameQualityMonitored())){
//				case "timeSlot":
//					Parameters.ALERT_ATTRIBUTE = "timeSlot";
//					Parameters.CONSTRAINT_THRESHOLD = cond.getValue();
//					break;
//				case "responseTime": 
					// TODO here I'm changing the name of the quality attribute to be compatible with the name in the
					// feature model. May be change the name in the feature model to avoid such hacking?
					cond.getIdMonitoredData().setNameQualityMonitored("responseTime");
					break;
				}
			}
		}else if(system == ModelSystem.AtosMonitoringEnabling) {
			// nothing to do here
		}else if (system == ModelSystem.Siemens_Buildings ||
				system == ModelSystem.Siemens_Types ||
				system == ModelSystem.Siemens_GetMinMaxDates) {
			// TODO nothing to do here, all should be handled later
//			String alertAttr = "response_time";
//			for (Condition cond: alert.getConditions()) {
//				if (alertAttr.equalsIgnoreCase(cond.getIdMonitoredData().getNameQualityMonitored())) {
//					Parameters.ALERT_ATTRIBUTE = alertAttr;
//					Parameters.CONSTRAINT_THRESHOLD = cond.getValue();
//					break;
//				}
//			}
		}
	}
	
	@Override
	public void handle() throws Exception {

		kpiComputer.startComputingKPI();
		
		String fmURI = ""; 
		String fcURI = "";
		
		//Creating temporary folder for serialized models
		Path path = Paths.get(System.getProperty("user.dir"), obtainTemporaryURI(system, deterministic));
		Path temporaryFolder = Files.createTempDirectory(path, "");
		String temp = temporaryFolder.toString();

		FeatureModel fm = null;
		
		// Load currently enacted Feature Configuration
		cz.zcu.yafmt.model.fc.FeatureConfiguration featureConfig ;
		
		//Change this variable if you should call to the model repository
		boolean test = false;
		if (!test){
			featureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);
			log.info("Currently enacted feature configuration " + featureConfig.getName() + " downloaded from repository");

			List<FeatureModel> featuremodels = mr.getFeatureModelsForSystem(system);
			if(featuremodels.size()>0){
				fm = featuremodels.get(0);//the only one?				
			}
			else{
				fmURI = obtainFMURI(alert.getTenant(), deterministic);
				fm = mm.loadFeatureModel(fmURI);
			}
			
			//Copy models in a temporary folder
			saveFM(fm, URI.createFileURI(temp + "/" + fm.getName() + ".yafm"));
			saveFC(featureConfig, URI.createFileURI(temp + "/" + featureConfig.getName() + ".yafc"));
			
			fmURI = temp + "/" + fm.getName() + ".yafm";
			fcURI = temp + "/" + featureConfig.getName() + ".yafc";
		}
		else
		{
			fmURI = obtainFMURI(alert.getTenant(), deterministic);
			fcURI = obtainNameCurrentConfig(alert.getTenant(), deterministic);
			fm = mm.loadFeatureModel(fmURI);
			featureConfig = mm.loadFeatureConfiguration(fcURI);
		}

		String alertAttribute = alert.getConditions().get(0).getIdMonitoredData().getNameQualityMonitored();
		Double alertThresholdValue = alert.getConditions().get(0).getValue();
		
		// Serialize FM and FC
		FMSerializer fms = new FMSerializer();		
		fms.serializeFMToArtifactsInFolder(fmURI, temp);
		fms.serializeFCToArtifactsInFolder(fcURI, fmURI, temp);
		
		String modelURI = temp + "/"  + fm.getName() + ".bnf";
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
		
		//Copy the new configuration in a temporary folder
		saveFC(newFeatureConfig, org.eclipse.emf.common.util.URI.createFileURI(newFeatureConfigPath));
		
		kpiComputer.stopComputingKPI();
		kpiComputer.reportComputedKPI();
		
		//******** Call WP4********
		// Upload the YAMFT Fature Configuration to the ModelRepository 
		String newFeatureConfigId = uploadLatestComputedFC(newFeatureConfig, newFeatureConfigFileName); // Populate metadata, status=Computed
		log.info("New optimal feature configuration " + newFeatureConfigId + " uploaded to repository");			
		
		// Notify Adaptation to the Dashboard 
		List<Selection> changedSelections = FeatureConfigurationUtility.diffFeatureConfigurations(featureConfig, newFeatureConfig);
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
		
	}
	
	private String doOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, Double alertThresholdValue, boolean multiObjective) {
				
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
