package eu.supersede.dynadapt.dm.optimizer.gp.operators;

import eu.fbk.gbtlib.gp.individual.GPIndividual;

public abstract class MutationFunction {
	public abstract void mutate(GPIndividual offspring) throws Exception;
	
}
