package eu.supersede.dm.optimizer.gp.chromosome;

import java.util.HashMap;
import java.util.Map;

import eu.fbk.gbtlib.gp.individual.GPAnnotatedIndividualFactory;
import eu.fbk.gbtlib.gp.individual.GPIndividual;

public class ChromosomeFactory {
//	private Map<Integer, Chromosome> chromosomeCache = new HashMap<Integer, Chromosome>();
//	private int duplicates = 0;
	private GPAnnotatedIndividualFactory configurationFactory;
	public ChromosomeFactory(String grammarFile, int depth, double probRecursive) {
		String learnedGrammarFile = "";
		boolean applySmoothing = true;
		setConfigurationFactory(new GPAnnotatedIndividualFactory(grammarFile, learnedGrammarFile, probRecursive, depth, applySmoothing));
	}
	
	public Chromosome getChromosome (){
		Chromosome chromosome = new Chromosome();
		
		GPIndividual configuration = getConfigurationFactory().getNewIndividual();
		double fitness = Double.MAX_VALUE;
		
		chromosome.setConfiguration(configuration);
		chromosome.setFitness(fitness);
//		if (chromosomeCache.put(chromosome.getConfiguration().toString().hashCode(), chromosome) != null){
//			duplicates++;
//		}
		return chromosome;
	}

//	public int getNumberOfDuplicates(){
//		return duplicates;
//	}
	
	public GPAnnotatedIndividualFactory getConfigurationFactory() {
		return configurationFactory;
	}

	public void setConfigurationFactory(GPAnnotatedIndividualFactory configurationFactory) {
		this.configurationFactory = configurationFactory;
	}
}
