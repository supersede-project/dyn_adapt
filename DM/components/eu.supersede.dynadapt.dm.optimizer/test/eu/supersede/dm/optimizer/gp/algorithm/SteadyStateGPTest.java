package eu.supersede.dm.optimizer.gp.algorithm;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.algorithm.SteadyStateGP;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;

public class SteadyStateGPTest {

	@Test
	public void testGenerateSolution() {
		String grammarFile = Parameters.GRAMMAR_FILE;
		int depth = 6;
		double probRecursive = 0.1;
		Parameters.SEARCH_BUDGET = 2;
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.POPULATION_SIZE = 10;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		SteadyStateGP algorithm = new SteadyStateGP(grammarFile, depth, probRecursive, currentConfiguration);
		assertFalse(algorithm == null);
		List<Chromosome> solutions = algorithm.generateSolution();
		assertFalse(solutions == null);
		System.out.printf("Finished after %d generations and %d fitness evaluations.", algorithm.getGenerations(),algorithm.getFitnessEvaluations());
		System.out.println();
		for (Chromosome solution : solutions){
			System.out.println("[" + solution.getFitness() + "] " + solution.toString());
		}
	}

}