package eu.supersede.dm.optimizer.gp.operators;

import eu.fbk.gbtlib.gp.operators.AnnotatedSubtreeCrossover;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;

public class SubtreeCrossover extends CrossoverFunction {

	AnnotatedSubtreeCrossover subtreeCrossover = new AnnotatedSubtreeCrossover();
	
	@Override
	public void crossOver(Chromosome parent1, Chromosome parent2) throws Exception {
		subtreeCrossover.crossOver(parent1.getConfiguration(), parent2.getConfiguration());

	}

}
