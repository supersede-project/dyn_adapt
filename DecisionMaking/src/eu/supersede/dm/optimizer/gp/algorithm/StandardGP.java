package eu.supersede.dm.optimizer.gp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.optimizer.gp.chromosome.ChromosomeFactory;
import eu.supersede.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunction;
import eu.supersede.dm.optimizer.gp.fitness.FitnessFunction;
import eu.supersede.dm.optimizer.gp.fitness.SingleObjectiveFitnessFunction;
import eu.supersede.dm.optimizer.gp.operators.CrossoverFunction;
import eu.supersede.dm.optimizer.gp.operators.MutationFunction;
import eu.supersede.dm.optimizer.gp.operators.ReplacementFunction;
import eu.supersede.dm.optimizer.gp.operators.SelectionFunction;
import eu.supersede.dm.optimizer.gp.operators.SubtreeCrossover;
import eu.supersede.dm.optimizer.gp.operators.SubtreeMutation;
import eu.supersede.dm.optimizer.gp.operators.TournamentSelection;
import eu.supersede.dm.optimizer.gp.stoppingconditions.MaxFitnessEvaluationStoppingCondition;
import eu.supersede.dm.optimizer.gp.stoppingconditions.MaxTimeStoppingCondition;
import eu.supersede.dm.optimizer.gp.stoppingconditions.StoppingCondition;
import eu.supersede.dm.util.ConfigurationLoader;
import eu.supersede.dm.util.RandomNumber;

public class StandardGP {
	
	private static final Logger logger = LoggerFactory.getLogger(StandardGP.class);
	
	protected List<Chromosome> population;
	protected ChromosomeFactory chromosomeFactory;
	protected FitnessFunction fitnessFunction;
	protected SelectionFunction selectionFunction;
	protected CrossoverFunction crossoverFunction;
	protected MutationFunction mutationFunction;
	protected ReplacementFunction replacementFunction;
	protected StoppingCondition stoppingCondition;
	
//	protected int fitnessEvaluations = 0;
	protected int generation = 0;

	public StandardGP(String grammarFile, int depth, double probRecursive, List<String> currentConfiguration) {
		chromosomeFactory = new ChromosomeFactory(grammarFile, depth,
				probRecursive);
		fitnessFunction = new ConstrainedSingleObjectiveFitnessFunction(currentConfiguration);
		selectionFunction = new TournamentSelection();
		crossoverFunction = new SubtreeCrossover();
		mutationFunction = new SubtreeMutation(chromosomeFactory.getConfigurationFactory());
		replacementFunction = new ReplacementFunction(fitnessFunction.isMaximizationFunction());
		if (Parameters.BUDGET_TYPE == BudgetType.MAX_TIME){
			stoppingCondition = new MaxTimeStoppingCondition();
		}else if (Parameters.BUDGET_TYPE == BudgetType.MAX_FITNESS){
			stoppingCondition = new MaxFitnessEvaluationStoppingCondition();
		}
	}

	public List<Chromosome> generateSolution() {
		List<Chromosome> solutions = new ArrayList<Chromosome>();
		initializePopulation();
		calculateFitnessAndSortPopulation();
		while (!isFinished()) {
			evolve();
			calculateFitnessAndSortPopulation();
		}
		solutions.add(population.get(0));
		logger.debug("Done after: {} generations.", generation);
		return solutions;
	}

	protected void initializePopulation() {
		population = new ArrayList<Chromosome>();
		while (population.size() < Parameters.POPULATION_SIZE) {
			Chromosome chromosome = chromosomeFactory.getChromosome();
			population.add(chromosome);
		}
//		logger.debug("Duplicates: {}", chromosomeFactory.getNumberOfDuplicates());
//		printPopulation();
	}

	/*
	 * temporary debug function
	 */
	
	protected void printPopulation(){
		for (Chromosome chromosome : population){
			logger.debug(chromosome.toString());
		}
	}
	
	protected void calculateFitnessAndSortPopulation() {
		for (Chromosome chromosome : population) {
			boolean unique = fitnessFunction.evaluate(chromosome);
			if (unique){
				stoppingCondition.fitnessEvaluation();
			}
		}
		sortPopulation();
	}

	protected void calculateFitness() {
		for (Chromosome chromosome : population) {
			boolean unique = fitnessFunction.evaluate(chromosome);
			if (unique){
				stoppingCondition.fitnessEvaluation();
			}
		}
	}
	
	protected void evolve() {
		List<Chromosome> nextGeneration = new ArrayList<Chromosome>();
		nextGeneration.addAll(elitism());
		while (nextGeneration.size() < Parameters.POPULATION_SIZE) {
			Chromosome parent1 = selectionFunction.select(population);
			Chromosome parent2 = selectionFunction.select(population);

			Chromosome offspring1 = parent1.clone();
			Chromosome offspring2 = parent2.clone();

			try {
				// Crossover
				if (RandomNumber.nextDouble() <= Parameters.CROSSOVER_RATE) {
					crossoverFunction.crossOver(offspring1.getConfiguration(), offspring2.getConfiguration());
				}

				// Mutation
				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE){
					mutationFunction.mutate(offspring1.getConfiguration());
				}
				
				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE){
					mutationFunction.mutate(offspring2.getConfiguration());
				}
				
				nextGeneration.add(offspring1);
				nextGeneration.add(offspring2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		population = nextGeneration;
		generation++;
	}

	protected List<Chromosome> elitism() {

		List<Chromosome> elite = new ArrayList<Chromosome>();

		for (int i = 0; i < Parameters.ELITE; i++) {
			elite.add(population.get(i).clone());
		}
		return elite;
	}

	protected boolean isFinished() {
		boolean finished =  fitnessFunction.isFinished(population.get(0))
				|| (stoppingCondition.isFinished());
		return finished;
	}
	
	protected void sortPopulation() {
		if (fitnessFunction.isMaximizationFunction()) {
			Collections.sort(population, Collections.reverseOrder());
		} else {
			Collections.sort(population);
		}
	}
	
	public int getGenerations(){
		return generation;
	}
	
	public int getFitnessEvaluations(){
		return (int)stoppingCondition.getCurrentValue();
	}
	
	// For testing purposes only!!
	public static void main (String[] args){
		int depth = 10;
		double probRecursive = 0.005;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		StandardGP gp = new StandardGP(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = gp.generateSolution();
		Chromosome solution = solutions.get(0);
		System.out.println(solution.getConfiguration().toString());
		System.out.println(solution.getFitness());
	}
}
