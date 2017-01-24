package eu.supersede.dynadapt.dm.rest;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.algorithm.SteadyStateGP;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.algorithm.ConstrainedNSGAII;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.serializer.FMSerializer;

@RestController
public class DMOptimizerController {
	
//	@RequestMapping("/optimize")
//	public FeatureConfiguration optimize (@RequestParam(value="modelURI", defaultValue="") String modelURI, 
//			@RequestParam(value="currentConfig", defaultValue="") String currentConfig, 
//			@RequestParam(value="qualityAttributePath", defaultValue="") String qualityAttributePath,
//			@RequestParam(value="alertAttribute", defaultValue="response_time") String alertAttribute,
//			@RequestParam(value="alertThresholdValue", defaultValue="30") String alertThresholdValue,
//			@RequestParam(value="multiObjective", defaultValue="true") boolean multiObjective) {
////		optimize (URI modelURI, URI currentConfigurationId, String alertAttribute, String alertThresholdValue
//		System.out.println(modelURI);
//		String optimalConfig = null;
//		if (!multiObjective){
//			optimalConfig = doSOOptimization (modelURI, currentConfig, qualityAttributePath, alertAttribute, alertThresholdValue);
//		}else{
//			optimalConfig = doMOOptimization (modelURI, currentConfig, qualityAttributePath, alertAttribute, alertThresholdValue);
//		}
//		System.out.println(optimalConfig);
//		FeatureConfiguration fc = new FeatureConfiguration(optimalConfig);
//		return fc;
//	}
	
	@RequestMapping("/optimize")
	public FeatureConfiguration optimize (
			@RequestParam(value="featureModelURI", defaultValue="") String fmURI, 
			@RequestParam(value="featureConfigurationURI", defaultValue="") String fcURI,
			@RequestParam(value="alertAttribute", defaultValue="response_time") String alertAttribute,
			@RequestParam(value="alertThresholdValue", defaultValue="30") String alertThresholdValue,
			@RequestParam(value="multiObjective", defaultValue="true") boolean multiObjective) throws Exception {
//		optimize (URI modelURI, URI currentConfigurationId, String alertAttribute, String alertThresholdValue
		//Serialize input FC to grammar and QualityAttribute JSON. Pass grammar and quality attributes URIs
		//modelURI points at generated grammar from Input FM
		//currentConfig is a column (newline separated list of) enabled features in current configuration
		//qualityAttributePath is 
		System.out.println(fmURI);
		
		//Generate grammar and attribute_metadata.json from fmURI
		//Inject  attribute_metadata.json in Parameters.ATTRIBUTE_Metadata
		//Generate feature.properties file for each FM quality attributes. Attribute values are taken from:
		// input FC->selection (feature)->attributeValue->value, if feature is selected in FC, otherwise
		// from FM->feature->attribute->defaultValue
		// Generate current configuration from input FC
		//String fmFolder = getFolder (fmURI);
		//Map qualityAttributePath to temporary folder where serialized files are placed.
		
		//Creating temporary folder for serialized models
		Path path = Paths.get (new URI("file://" + getFolder(fmURI)));
		Path temporaryFolder = Files.createTempDirectory(path, "");
		String temp = temporaryFolder.toString();
		
		FMSerializer.serializeFMToArtifactsInFolder(fmURI, temp);
		FMSerializer.serializeFCToArtifactsInFolder(fcURI, fmURI, temp);
		
		String modelURI = fmURI.replace("yafm", "bnf");
		Parameters.ATTRIBUTE_METADATA = fmURI.replace("yafm", "json");
		String qualityAttributePath = temp;
		String currentConfig = temp + getFileNameOfPath(fcURI).replace ("yafc", "conf");
		
		String optimalConfig = null;
		if (!multiObjective){
			optimalConfig = doSOOptimization (modelURI, currentConfig, qualityAttributePath, alertAttribute, alertThresholdValue);
		}else{
			optimalConfig = doMOOptimization (modelURI, currentConfig, qualityAttributePath, alertAttribute, alertThresholdValue);
		}
		System.out.println(optimalConfig);
		FeatureConfiguration fc = new FeatureConfiguration(optimalConfig);
		//TODO Generate a YAMFT FeatureConfiguration from optimalConfig. Return this FC
		return fc;
	}
	
	private String getFileNameOfPath(String path) {
		// Return the file name in path
		return path.substring(path.lastIndexOf('/'));
	}

	String getFolder (String urlString){
		return urlString.substring(0, urlString.lastIndexOf('/'));
	}

	private String doMOOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, String alertThresholdValue) {
		if (!modelURI.isEmpty())
			Parameters.GRAMMAR_FILE = modelURI;
		
		if (!currentConfig.isEmpty())
			Parameters.CURRENT_CONFIGURATION = currentConfig;
		
		if (!qualityAttributePath.isEmpty())
			Parameters.FEATURE_ATTRIBUTE_PATH = qualityAttributePath;
		
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.SEARCH_BUDGET = 5;
		Parameters.CONSTRAINT_THRESHOLD = Double.parseDouble(alertThresholdValue); // 30;
		Parameters.ALERT_ATTRIBUTE = alertAttribute;
		Parameters.POPULATION_SIZE = 150;
		int depth = 15;
		double probRecursive = 0.05;
		Parameters.CROSSOVER_RATE = 0.6;
		Parameters.MUTATION_RATE = 0.2;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		ConstrainedNSGAII nsgaii = new ConstrainedNSGAII(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = nsgaii.generateSolution();
		StringBuffer sols = new StringBuffer();
		for (Chromosome c : solutions){
			sols.append("[" + c.getConfiguration().toString() + "],");
		}
		return sols.toString();
	}
	
	private String doSOOptimization(String modelURI, String currentConfig, String qualityAttributePath, String alertAttribute, String alertThresholdValue) {
		if (!modelURI.isEmpty())
			Parameters.GRAMMAR_FILE = modelURI;
		
		if (!currentConfig.isEmpty())
			Parameters.CURRENT_CONFIGURATION = currentConfig;
		
		if (!qualityAttributePath.isEmpty())
			Parameters.FEATURE_ATTRIBUTE_PATH = qualityAttributePath;
		
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.SEARCH_BUDGET = 5;
		Parameters.CONSTRAINT_THRESHOLD = Double.parseDouble(alertThresholdValue);
		Parameters.ALERT_ATTRIBUTE = alertAttribute;
		Parameters.POPULATION_SIZE = 150;
		int depth = 15;
		double probRecursive = 0.005;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		SteadyStateGP gp = new SteadyStateGP(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
		List<eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome> solutions = gp.generateSolution();
		eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome solution = solutions.get(0);
		System.out.println(solution.getConfiguration().toString());
		return solution.getConfiguration().toString();
	}
	

}
