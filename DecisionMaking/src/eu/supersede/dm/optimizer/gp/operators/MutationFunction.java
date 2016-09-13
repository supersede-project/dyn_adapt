package eu.supersede.dm.optimizer.gp.operators;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;

public abstract class MutationFunction {
	public abstract void mutate(Chromosome offspring) throws Exception;
	
}
