package eu.supersede.dynadapt.dm.optimizer.gp.mo.fitness;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.FeatureAttributeMetadata;

public class ConstrainedMultiObjectiveFitnessFunctionFGReconfiguration extends AbstractFitnessFunction {

	private static final Logger logger = LoggerFactory.getLogger(ConstrainedMultiObjectiveFitnessFunction.class);

	private double[] currentConfigurationFitness;
	
	private Map<String, FeatureAttributeMetadata> featureAttributeMetadata = configurationLoader.getFeatureAttributeMetadata();
	
	/**
	 * @param currentConfig
	 */
	public ConstrainedMultiObjectiveFitnessFunctionFGReconfiguration(List<String> currentConfig) {
		super(currentConfig);
		
		// calculate the fitness of the current configuration
		currentConfigurationFitness = calculate(currentConfig);
		logger.debug("Fitness of current config: {}", currentConfigurationFitness);
	}

	@Override
	public boolean evaluate(Chromosome chromosome) {
		boolean unique = true;
		// first check if the individual has been evaluated before
		double[] fitness = getCashedFitness(chromosome);
		if (fitness != null){
			chromosome.setObjective(fitness);
			unique = false;
//			logger.debug("Cache size: {} >> Chromsome: {} = {}", fitnessCache.size(), chromosome.getConfiguration().toString(), fitness);
		}else{
			List<String> features = Arrays.asList(chromosome.toString().split(" "));
			
			double[] result = calculate(features);
			
			chromosome.setObjective(Arrays.copyOfRange(result,0,2));
			chromosome.setOverallConstraintViolation(result[2]);
			// save this fitness in cache
			cacheFitness(chromosome);
		}
		return unique;
	}

	@Override
	public boolean isMaximizationFunction() {
		return false;
	}

	@Override
	public boolean isFinished(Chromosome chromosome) {
		boolean finished = true;
		if (isMaximizationFunction()){
			if (chromosome.getOverallConstraintViolation() < currentConfigurationFitness[2]){
				finished = true;
			}else{
				for (int i = 0; i < chromosome.getNumberOfObjectives(); i++){
					if (currentConfigurationFitness[i] > chromosome.getObjective()[i]){
						finished = false;
						break;
					}
				}
			}
		}else{
			if (chromosome.getOverallConstraintViolation() < currentConfigurationFitness[2]){
				finished = true;
			}else{
				for (int i = 0; i < chromosome.getNumberOfObjectives() - 1; i++){
					if (currentConfigurationFitness[i] < chromosome.getObjective()[i]){
						finished = false;
						break;
					}
				}
			}
		}
		return finished;
	}
	
	private double[] calculate (List<String> features){

		List<Properties> attributesOfAllFeatures =  configurationLoader.loadAttributes(features);
		
		// create and initialize
		String costAttribute = "diskC";
		double overallCost = 0d;
		String valueAttribute = "quality";
		double overallValue = 1d;
		
		String alertAttribute = Parameters.ALERT_ATTRIBUTE; // "diskC";
		double overallConstraint = 0d;
		
		for (Properties attributes : attributesOfAllFeatures){
			double cost = Double.parseDouble(attributes.getProperty(costAttribute));
			overallCost += cost;
			
			double value = Double.parseDouble(attributes.getProperty(valueAttribute));
			overallValue *= value;
			
			double alertValue = Double.parseDouble(attributes.getProperty(alertAttribute));
			overallConstraint += alertValue;
			
		}
		
		// overall aggregate sum of all attribute values
		double[] result = new double[Parameters.NUM_OBJECTIVES + Parameters.NUM_CONSTRAINTS];
		result[0] = overallCost;
		result[1] = -1d * overallValue; // convert to minimization //FIXME Only temporary, should be done properly!!!!
		result[2] = overallConstraint;
		
		return result;
	}

}
