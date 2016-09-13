package eu.supersede.dm.optimizer.gp.fitness;

import java.util.HashMap;
import java.util.Map;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;

public abstract class AbstractFitnessFunction implements FitnessFunction {
	
	protected Map<Integer,Double> fitnessCache = new HashMap<Integer, Double>();
	
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
}
