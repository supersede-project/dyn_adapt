package eu.supersede.dm.optimizer.gp.algorithm;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.util.ConfigurationLoader;

public class StandardGPTest {

	@Test
	public void testGenerateSolution() {
		String grammarFile = Parameters.GRAMMAR_FILE;
		int depth = 6;
		double probRecursive = 0.1;
		Parameters.SEARCH_BUDGET = 5000;
		Parameters.POPULATION_SIZE = 50;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		StandardGP algorithm = new StandardGP(grammarFile, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = algorithm.generateSolution();
		System.out.printf("Finished after %d generations and %d fitness evaluations.", algorithm.getGenerations(),algorithm.getFitnessEvaluations());
		System.out.println();
		for (Chromosome solution : solutions){
			System.out.println("[" + solution.getFitness() + "] " + solution.toString());
		}
	}

}
