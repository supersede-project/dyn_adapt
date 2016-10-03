package eu.supersede.dm.optimizer.gp.algorithm;

import java.util.List;

import org.junit.Test;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.util.ConfigurationLoader;

public class SteadyStateGPTest {

	@Test
	public void testGenerateSolution() {
		String grammarFile = Parameters.GRAMMAR_FILE;
		int depth = 6;
		double probRecursive = 0.1;
		Parameters.SEARCH_BUDGET = 500;
		Parameters.POPULATION_SIZE = 10;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		SteadyStateGP algorithm = new SteadyStateGP(grammarFile, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = algorithm.generateSolution();
		System.out.printf("Finished after %d generations and %d fitness evaluations.", algorithm.getGenerations(),algorithm.getFitnessEvaluations());
		System.out.println();
		for (Chromosome solution : solutions){
			System.out.println("[" + solution.getFitness() + "] " + solution.toString());
		}
	}

}
