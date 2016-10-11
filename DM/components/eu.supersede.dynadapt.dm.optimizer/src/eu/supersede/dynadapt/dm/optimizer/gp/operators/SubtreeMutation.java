package eu.supersede.dynadapt.dm.optimizer.gp.operators;

import eu.fbk.gbtlib.gp.individual.GPAnnotatedIndividualFactory;
import eu.fbk.gbtlib.gp.individual.GPIndividual;
import eu.fbk.gbtlib.gp.operators.AnnotatedSubtreeMutation;

public class SubtreeMutation extends MutationFunction {

	AnnotatedSubtreeMutation subtreeMutation;
	
	public SubtreeMutation(GPAnnotatedIndividualFactory chromosomeFactory) {
		subtreeMutation = new AnnotatedSubtreeMutation(chromosomeFactory);
	}
	
	@Override
	public void mutate(GPIndividual offspring) throws Exception {
		subtreeMutation.mutate(offspring);

	}

}
