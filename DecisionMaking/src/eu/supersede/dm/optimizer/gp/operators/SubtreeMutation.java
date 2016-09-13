package eu.supersede.dm.optimizer.gp.operators;

import eu.fbk.gbtlib.gp.operators.AnnotatedSubtreeMutation;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.optimizer.gp.chromosome.ChromosomeFactory;

public class SubtreeMutation extends MutationFunction {

	AnnotatedSubtreeMutation subtreeMutation;
	
	public SubtreeMutation(ChromosomeFactory chromosomeFactory) {
		subtreeMutation = new AnnotatedSubtreeMutation(chromosomeFactory.getConfigurationFactory());
	}
	
	@Override
	public void mutate(Chromosome offspring) throws Exception {
		subtreeMutation.mutate(offspring.getConfiguration());

	}

}
