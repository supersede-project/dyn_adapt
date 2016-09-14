package eu.supersede.dm.optimizer.gp.fitness;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.util.ConfigurationLoader;

public abstract class AbstractFitnessFunction implements FitnessFunction {
	
	protected Map<Integer,Double> fitnessCache = new HashMap<Integer, Double>();
	
	protected ConfigurationLoader configurationLoader = new ConfigurationLoader();
	
	private List<String> currentConfiguration;
	
	/**
	 * 
	 */
	public AbstractFitnessFunction(List<String> currentConfig) {
		currentConfiguration = currentConfig;
	}
	
	/*
	 * Returns the cached fitness value for the individual, else returns NULL
	 */
	protected Double getCashedFitness (Chromosome chromosome){
		Integer hashCode = chromosome.toString().hashCode();
		return fitnessCache.get(hashCode);
	}
	
	protected void cacheFitness (Chromosome chromosome){
		Integer hashCode = chromosome.toString().hashCode();
		fitnessCache.put(hashCode, chromosome.getFitness());
	}

	public List<String> getCurrentConfiguration() {
		return currentConfiguration;
	}

	public void setCurrentConfiguration(List<String> currentConfiguration) {
		this.currentConfiguration = currentConfiguration;
	}
}
