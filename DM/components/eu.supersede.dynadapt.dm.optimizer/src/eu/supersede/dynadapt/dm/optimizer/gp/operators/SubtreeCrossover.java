package eu.supersede.dynadapt.dm.optimizer.gp.operators;

import eu.fbk.gbtlib.gp.individual.GPIndividual;
import eu.fbk.gbtlib.gp.operators.AnnotatedSubtreeCrossover;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;

public class SubtreeCrossover extends CrossoverFunction {

	AnnotatedSubtreeCrossover subtreeCrossover = new AnnotatedSubtreeCrossover();
	
	@Override
	public void crossOver(GPIndividual parent1, GPIndividual parent2) throws Exception {
		subtreeCrossover.crossOver(parent1, parent2);

	}

}
