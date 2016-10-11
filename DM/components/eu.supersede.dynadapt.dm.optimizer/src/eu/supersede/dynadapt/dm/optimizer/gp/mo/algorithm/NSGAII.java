/**
 * 
 */
package eu.supersede.dynadapt.dm.optimizer.gp.mo.algorithm;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.ChromosomeFactory;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.fitness.FitnessFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.fitness.MultiObjectiveFitnessFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.operators.MultiObjectiveTournamentSelection;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.operators.SelectionFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.CrossoverFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.MutationFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.SubtreeCrossover;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.SubtreeMutation;
import eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.MaxFitnessEvaluationStoppingCondition;
import eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.MaxTimeStoppingCondition;
import eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.dm.util.CrowdingComparator;
import eu.supersede.dynadapt.dm.util.Distance;
import eu.supersede.dynadapt.dm.util.RandomNumber;
import eu.supersede.dynadapt.dm.util.Ranking;

/**
 * @author fitsum
 *
 */
public class NSGAII {

	private static final Logger logger = LoggerFactory.getLogger(NSGAII.class);

	protected List<Chromosome> population;
	protected ChromosomeFactory chromosomeFactory;
	protected FitnessFunction fitnessFunction;
	protected SelectionFunction selectionFunction;
	protected CrossoverFunction crossoverFunction;
	protected MutationFunction mutationFunction;
	// protected ReplacementFunction replacementFunction;
	protected StoppingCondition stoppingCondition;

//	private int fitnessEvaluations = 0;
	private int generation = 0;

	/**
	 * @param grammarFile
	 * @param depth
	 * @param probRecursive
	 * @param currentConfiguration
	 */
	public NSGAII(String grammarFile, int depth, double probRecursive,
			List<String> currentConfiguration) {
		chromosomeFactory = new ChromosomeFactory(grammarFile, depth,
				probRecursive);
		fitnessFunction = new MultiObjectiveFitnessFunction(
				currentConfiguration);
		selectionFunction = new MultiObjectiveTournamentSelection();
		crossoverFunction = new SubtreeCrossover();
		mutationFunction = new SubtreeMutation(
				chromosomeFactory.getConfigurationFactory());
		// replacementFunction = new
		// ReplacementFunction(fitnessFunction.isMaximizationFunction());
		if (Parameters.BUDGET_TYPE == BudgetType.MAX_TIME){
			stoppingCondition = new MaxTimeStoppingCondition();
		}else if (Parameters.BUDGET_TYPE == BudgetType.MAX_FITNESS){
			stoppingCondition = new MaxFitnessEvaluationStoppingCondition();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.algorithm.StandardGP#generateSolution()
	 */
	public List<Chromosome> generateSolution() {
		Distance distance = new Distance();

		initializePopulation();
		calculateFitness(population);
		while (!isFinished()) {
			List<Chromosome> offspringPopulation = evolve();
			calculateFitness(offspringPopulation);

			List<Chromosome> union = new ArrayList<Chromosome>();
			union.addAll(population);
			union.addAll(offspringPopulation);

			Ranking ranking = new Ranking(union);

			int remain = population.size();
			int index = 0;
			List<Chromosome> front = null;
			population.clear();

			// Obtain the next front
			front = ranking.getSubfront(index);

			while ((remain > 0) && (remain >= front.size())) {
				// Assign crowding distance to individuals
				distance.crowdingDistanceAssignment(front,
						Parameters.NUM_OBJECTIVES);
				// Add the individuals of this front
				for (int k = 0; k < front.size(); k++) {
					population.add(front.get(k));
				} // for

				// Decrement remain
				remain = remain - front.size();

				// Obtain the next front
				index++;
				if (remain > 0) {
					front = ranking.getSubfront(index);
				} // if
			}

			// Remain is less than front(index).size, insert only the best one
			if (remain > 0) { // front contains individuals to insert
				distance.crowdingDistanceAssignment(front,
						Parameters.NUM_OBJECTIVES);
				front.sort(new CrowdingComparator());
				for (int k = 0; k < remain; k++) {
					population.add(front.get(k));
				} // for

				remain = 0;
			} // if
		} // while not finished

		Ranking ranking = new Ranking(population);
		List<Chromosome> solutions = ranking.getSubfront(0);
		printObjectivesToFile(solutions, "FUN");
		return solutions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.algorithm.StandardGP#evolve()
	 */
	protected List<Chromosome> evolve() {
		List<Chromosome> nextGeneration = new ArrayList<Chromosome>();
		while (nextGeneration.size() < Parameters.POPULATION_SIZE) {
			Chromosome parent1 = selectionFunction.select(population);
			Chromosome parent2 = selectionFunction.select(population);

			Chromosome offspring1 = parent1.clone();
			Chromosome offspring2 = parent2.clone();

			try {
				// Crossover
				if (RandomNumber.nextDouble() <= Parameters.CROSSOVER_RATE) {
					crossoverFunction.crossOver(offspring1.getConfiguration(),
							offspring2.getConfiguration());
				}

				// Mutation
				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE) {
					mutationFunction.mutate(offspring1.getConfiguration());
				}

				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE) {
					mutationFunction.mutate(offspring2.getConfiguration());
				}

				nextGeneration.add(offspring1);
				nextGeneration.add(offspring2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		generation++;
		return nextGeneration;
	}

	protected void initializePopulation() {
		population = new ArrayList<Chromosome>();
		while (population.size() < Parameters.POPULATION_SIZE) {
			Chromosome chromosome = chromosomeFactory.getChromosome();
			population.add(chromosome);
		}
		// logger.debug("Duplicates: {}",
		// chromosomeFactory.getNumberOfDuplicates());
		// printPopulation();
	}

	protected void calculateFitness(List<Chromosome> pop) {
		for (Chromosome chromosome : pop) {
			boolean unique = fitnessFunction.evaluate(chromosome);
			if (unique) {
//				fitnessEvaluations++;
				stoppingCondition.fitnessEvaluation();
			}
		}
	}

	protected boolean isFinished() {
		boolean finished = fitnessFunction.isFinished(population.get(0))
				|| (stoppingCondition.isFinished());
		return finished;
	}

	public int getFitnessEvaluations() {
		return (int) stoppingCondition.getCurrentValue();
	}

	public int getGeneration() {
		return generation;
	}

	public void printObjectivesToFile(List<Chromosome> solutions, String path) {
		try {
			/* Open the file */
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("cost,value,config\n");
//			bw.newLine();
//			int numberOfObjectives = solutions.get(0).getNumberOfObjectives();
			int sol = 1;
			for (Chromosome solution : solutions) {
//				String msg = "";
//				for (int i = 0; i < numberOfObjectives; i++)
				String msg = solution.getObjective()[0] + "," + (1 - solution.getObjective()[1]) + ",c" + (sol++) + "\n";
				bw.write(msg); //solution.toString());
//				bw.newLine();
			}

			/* Close the file */
			bw.close();
		} catch (IOException e) {
			logger.error("Error acceding to the file");
			e.printStackTrace();
		}
	} // printObjectivesToFile
	
	public static void main(String[] args) {
		int depth = 5;
		double probRecursive = 0.1;
		Parameters.SEARCH_BUDGET = 10; // 10 seconds
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		NSGAII nsgaii = new NSGAII(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = nsgaii.generateSolution();
		Chromosome solution = solutions.get(0);
		System.out.println(solution.getConfiguration().toString());
		System.out.println(solution.getFitness());
	}
}
