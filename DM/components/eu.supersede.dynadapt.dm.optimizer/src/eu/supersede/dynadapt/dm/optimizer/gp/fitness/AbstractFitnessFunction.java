package eu.supersede.dynadapt.dm.optimizer.gp.fitness;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;

public abstract class AbstractFitnessFunction implements FitnessFunction {
	
	protected Map<Integer,Double[]> fitnessCache = new HashMap<Integer, Double[]>();
	
	protected ConfigurationLoader configurationLoader = ConfigurationLoader.getInstance();
	
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
	protected Double[] getCashedFitness (Chromosome chromosome){
		Integer hashCode = chromosome.hashCode();
		return fitnessCache.get(hashCode);
	}
	
	protected void cacheFitness (Chromosome chromosome){
		Integer hashCode = chromosome.hashCode();
		Double[] fitness = new Double[2];
		fitness[0] = chromosome.getFitness();
		fitness[1] = chromosome.getOverallConstraint();
		fitnessCache.put(hashCode, fitness);
	}

	public List<String> getCurrentConfiguration() {
		return currentConfiguration;
	}

	public void setCurrentConfiguration(List<String> currentConfiguration) {
		this.currentConfiguration = currentConfiguration;
	}
}
