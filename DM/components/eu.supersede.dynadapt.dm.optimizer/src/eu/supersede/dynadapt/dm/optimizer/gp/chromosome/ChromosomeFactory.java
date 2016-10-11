package eu.supersede.dynadapt.dm.optimizer.gp.chromosome;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.fbk.gbtlib.gp.individual.GPAnnotatedIndividualFactory;
import eu.fbk.gbtlib.gp.individual.GPIndividual;

public class ChromosomeFactory {
	private static final Logger logger = LoggerFactory.getLogger(ChromosomeFactory.class);
	
	private Map<Integer, Chromosome> chromosomeCache = new HashMap<Integer, Chromosome>();
	private int duplicates = 0;
	private GPAnnotatedIndividualFactory configurationFactory;
	public ChromosomeFactory(String grammarFile, int depth, double probRecursive) {
		String learnedGrammarFile = "";
		boolean applySmoothing = true;
		setConfigurationFactory(new GPAnnotatedIndividualFactory(grammarFile, learnedGrammarFile, probRecursive, depth, applySmoothing));
	}
	
	public Chromosome getChromosome (){
		Chromosome chromosome = new Chromosome();
		
		GPIndividual configuration = getConfigurationFactory().getNewIndividual();
		while (chromosomeCache.put(configuration.toString().hashCode(), chromosome) != null){
			configuration = getConfigurationFactory().getNewIndividual();
			duplicates++;
		}
//		logger.debug("duplicates: {}", duplicates);
		double fitness = Double.MAX_VALUE;
		double overallConstraint = Double.MAX_VALUE;
		
		chromosome.setConfiguration(configuration);
		chromosome.setFitness(fitness);
		chromosome.setOverallConstraint(overallConstraint);
		return chromosome;
	}

	public int getNumberOfDuplicates(){
		return duplicates;
	}
	
	public GPAnnotatedIndividualFactory getConfigurationFactory() {
		return configurationFactory;
	}

	public void setConfigurationFactory(GPAnnotatedIndividualFactory configurationFactory) {
		this.configurationFactory = configurationFactory;
	}
}
