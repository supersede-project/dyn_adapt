package eu.supersede.dm.optimizer.gp.operators;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;


public abstract class CrossoverFunction {
	public abstract void crossOver(Chromosome parent1, Chromosome parent2) throws Exception;
}
