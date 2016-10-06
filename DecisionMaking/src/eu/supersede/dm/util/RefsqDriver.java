/**
 * 
 */
package eu.supersede.dm.util;

import java.util.ArrayList;
import java.util.List;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dm.optimizer.gp.mo.algorithm.NSGAII;
import eu.supersede.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 *
 */
public class RefsqDriver {
	/**
	 * 
	 */
	public RefsqDriver() {
		// TODO Auto-generated constructor stub
	}
	
	private static boolean raiseAlert(int threshold, int min, int max){
		if (RandomNumber.nextInt(min, max) > threshold){
			return true;
		}else{
			return false;
		}
	}
	
	private static List<String> stringToList (String config){
		List<String> list = new ArrayList<String>();
		for (String s : config.split("\\s+")){
			if (!s.trim().isEmpty()){
				list.add(s);
			}
		}
		return list;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int depth = 25;
		double probRecursive = 0.0002;
		Parameters.SEARCH_BUDGET = 3; // seconds
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.CONSTRAINT_THRESHOLD = 30;
		Parameters.POPULATION_SIZE = 150;
		Parameters.CROSSOVER_RATE = 0.6;
		Parameters.MUTATION_RATE = 0.2;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		
		int threshold = (int) Parameters.CONSTRAINT_THRESHOLD;
		int min = 0;
		int max = 100;
		while (true){
			
			if (raiseAlert(threshold, min, max)){
				System.err.println("Alert raised! Optimze ...");
				
				
				NSGAII nsgaii = new NSGAII(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
				List<Chromosome> solutions = nsgaii.generateSolution();
				
				// present solutions (pareto-front) to the user
				
				// user chooses one
				Chromosome solution = RandomNumber.choice(solutions);
				
				// save chosen config as current configuration
				String config = solution.toString();
				currentConfiguration = stringToList(config);
				
				System.out.println(currentConfiguration);
				System.out.println(solution.getObjective());
				
				System.err.println("sleeping ...");
				Thread.sleep(5000);
				System.err.println("woke up. resuming ...");
			}
		}
		
	}
}
