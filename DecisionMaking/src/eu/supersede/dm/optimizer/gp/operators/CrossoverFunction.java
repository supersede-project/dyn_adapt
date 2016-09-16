package eu.supersede.dm.optimizer.gp.operators;

import eu.fbk.gbtlib.gp.individual.GPIndividual;


public abstract class CrossoverFunction {
	public abstract void crossOver(GPIndividual parent1, GPIndividual parent2) throws Exception;
}
