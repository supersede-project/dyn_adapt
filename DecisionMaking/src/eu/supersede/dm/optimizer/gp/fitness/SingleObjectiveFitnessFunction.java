package eu.supersede.dm.optimizer.gp.fitness;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;

public class SingleObjectiveFitnessFunction extends AbstractFitnessFunction{
	
	private static final Logger logger = LoggerFactory.getLogger(SingleObjectiveFitnessFunction.class);

	private double currentConfigurationFitness;
	
	/**
	 * @param currentConfig
	 */
	public SingleObjectiveFitnessFunction(List<String> currentConfig) {
		super(currentConfig);
		
		// calculate the fitness of the current configuration
		
		currentConfigurationFitness = calculate(currentConfig);
		logger.debug("Fitness of current config: {}", currentConfigurationFitness);
	}

	
	/*
	 * Return true if the individual is unique (i.e., was not seen so far), otherwise return false (i.e., is a duplicate)
	 * (non-Javadoc)
	 * @see eu.supersede.dm.optimizer.gp.FitnessFunction#evaluate(eu.supersede.dm.optimizer.gp.Chromosome)
	 */
	@Override
	public boolean evaluate(Chromosome chromosome) {
		boolean unique = true;
		// first check if the individual has been evaluated before
		Double fitness = getCashedFitness(chromosome);
		if (fitness != null){
			chromosome.setFitness(fitness);
			unique = false;
//			logger.debug("Cache size: {} >> Chromsome: {} = {}", fitnessCache.size(), chromosome.getConfiguration().toString(), fitness);
		}else{
			List<String> features = Arrays.asList(chromosome.toString().split(" "));
			
			fitness = calculate(features);
			
			chromosome.setFitness(fitness);
			// save this fitness in cache
			cacheFitness(chromosome);
		}
		return unique;
	}

	
	private double calculate (List<String> features){
		double result;
		List<Properties> allAttributes =  configurationLoader.loadAttributes(features);
		double totalAvailability = 1;
		for (Properties attributes : allAttributes){
			double availability = Double.parseDouble(attributes.getProperty("availability"));
			totalAvailability += availability;
		}
		result = totalAvailability;  //1d - totalAvailability;
		return result;
	}
	
	@Override
	public boolean isMaximizationFunction() {
		return true;
	}


	/* (non-Javadoc)
	 * @see eu.supersede.dm.optimizer.gp.fitness.FitnessFunction#isFinished(eu.supersede.dm.optimizer.gp.chromosome.Chromosome)
	 */
	@Override
	public boolean isFinished(Chromosome chromosome) {
		if (isMaximizationFunction()){
			return (currentConfigurationFitness < chromosome.getFitness());
		} else{
			return (currentConfigurationFitness > chromosome.getFitness());
		}
	}

}
