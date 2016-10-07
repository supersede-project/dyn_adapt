/**
 * 
 */
package eu.supersede.dm.optimizer.gp.mo.algorithm;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dm.util.ConfigurationLoader;

/**
 * @author fitsum
 *
 */
public class NSGAIITest {

	@Test
	public void testGenerateSolution() {
		String grammarFile = Parameters.GRAMMAR_FILE;
		int depth = 6;
		double probRecursive = 0.1;
		Parameters.SEARCH_BUDGET = 2;
		Parameters.POPULATION_SIZE = 50;
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		NSGAII nsga2 = new NSGAII(grammarFile, depth, probRecursive, currentConfiguration);
		assertFalse(nsga2 == null);
		List<Chromosome> solutions = nsga2.generateSolution();
		System.out.printf("Finished after %d generations and %d fitness evaluations.", nsga2.getGeneration(),nsga2.getFitnessEvaluations());
		System.out.println();
		for (Chromosome solution : solutions){
			System.out.println("[" + solution.getObjective()[0] + ", " + solution.getObjective()[1] + "] " + solution.toString());
		}
	}

}
