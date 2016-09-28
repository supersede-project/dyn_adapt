package eu.supersede.dm.optimizer.gp.mo.fitness;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.supersede.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dm.util.ConfigurationLoader;

public abstract class AbstractFitnessFunction implements FitnessFunction {
	
	protected Map<Integer,double[]> fitnessCache = new HashMap<Integer, double[]>();
	
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
	protected double[] getCashedFitness (Chromosome chromosome){
		Integer hashCode = chromosome.toString().hashCode();
		return fitnessCache.get(hashCode);
	}
	
	protected void cacheFitness (Chromosome chromosome){
		Integer hashCode = chromosome.toString().hashCode();
		fitnessCache.put(hashCode, chromosome.getObjective());
	}

	public List<String> getCurrentConfiguration() {
		return currentConfiguration;
	}

	public void setCurrentConfiguration(List<String> currentConfiguration) {
		this.currentConfiguration = currentConfiguration;
	}
}
