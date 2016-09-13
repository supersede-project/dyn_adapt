package eu.supersede.dm.optimizer.gp.algorithm;

import java.util.List;

import org.junit.Test;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;

public class SteadyStateGPTest {

	@Test
	public void testGenerateSolution() {
		String grammarFile = Parameters.GRAMMAR_FILE;
		int depth = 6;
		double probRecursive = 0.1;
		Parameters.SEARCH_BUDGET = 100;
		Parameters.POPULATION_SIZE = 10;
		SteadyStateGP algorithm = new SteadyStateGP(grammarFile, depth, probRecursive);
		List<Chromosome> solutions = algorithm.generateSolution();
		System.out.printf("Finished after %d generations and %d fitness evaluations.", algorithm.getGenerations(),algorithm.getFitnessEvaluations());
		System.out.println();
		for (Chromosome solution : solutions){
			System.out.println("[" + solution.getFitness() + "] " + solution.toString());
		}
	}

}
