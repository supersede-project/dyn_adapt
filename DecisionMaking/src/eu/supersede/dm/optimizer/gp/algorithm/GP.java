package eu.supersede.dm.optimizer.gp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.optimizer.gp.chromosome.ChromosomeFactory;
import eu.supersede.dm.optimizer.gp.fitness.FitnessFunction;
import eu.supersede.dm.optimizer.gp.fitness.SingleObjectiveFitnessFunction;
import eu.supersede.dm.optimizer.gp.operators.CrossoverFunction;
import eu.supersede.dm.optimizer.gp.operators.MutationFunction;
import eu.supersede.dm.optimizer.gp.operators.SelectionFunction;
import eu.supersede.dm.optimizer.gp.operators.SubtreeCrossover;
import eu.supersede.dm.optimizer.gp.operators.SubtreeMutation;
import eu.supersede.dm.optimizer.gp.operators.TournamentSelection;
import eu.supersede.dm.util.RandomNumber;

public class GP {
	
	private static final Logger logger = LoggerFactory.getLogger(GP.class);
	
	List<Chromosome> population;
	ChromosomeFactory chromosomeFactory;
	FitnessFunction fitnessFunction;
	SelectionFunction selectionFunction;
	CrossoverFunction crossoverFunction;
	MutationFunction mutationFunction;

	private int fitnessEvaluations = 0;

	public GP(String grammarFile, int depth, double probRecursive) {
		chromosomeFactory = new ChromosomeFactory(grammarFile, depth,
				probRecursive);
		fitnessFunction = new SingleObjectiveFitnessFunction();
		selectionFunction = new TournamentSelection();
		crossoverFunction = new SubtreeCrossover();
		mutationFunction = new SubtreeMutation(chromosomeFactory);
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
		return solutions;
	}

	private void initializePopulation() {
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
	
	private void printPopulation(){
		for (Chromosome chromosome : population){
			logger.debug(chromosome.toString());
		}
	}
	
	private void calculateFitnessAndSortPopulation() {
		for (Chromosome chromosome : population) {
			boolean unique = fitnessFunction.evaluate(chromosome);
			if (unique){
				fitnessEvaluations++;
			}
		}
		sortPopulation();
	}

	private void evolve() {
		List<Chromosome> nextGeneration = new ArrayList<Chromosome>();
		nextGeneration.addAll(elitism());
		while (nextGeneration.size() < Parameters.POPULATION_SIZE) {
			Chromosome parent1 = selectionFunction.select(population);
			Chromosome parent2 = selectionFunction.select(population);

			Chromosome offspring1 = parent1.clone();
			Chromosome offspring2 = parent2.clone();

			try {
				// Chrossover
				if (RandomNumber.nextDouble() <= Parameters.CROSSOVER_RATE) {
					crossoverFunction.crossOver(offspring1, offspring2);
				}

				// Mutation
				mutationFunction.mutate(offspring1);
				mutationFunction.mutate(offspring2);
				
				nextGeneration.add(offspring1);
				nextGeneration.add(offspring2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		population = nextGeneration;
	}

	private List<Chromosome> elitism() {

		List<Chromosome> elite = new ArrayList<Chromosome>();

		for (int i = 0; i < Parameters.ELITE; i++) {
			elite.add(population.get(i).clone());
		}
		return elite;
	}

	private boolean isFinished() {
		return (fitnessEvaluations > Parameters.SEARCH_BUDGET);
	}
	
	protected void sortPopulation() {
		if (fitnessFunction.isMaximizationFunction()) {
			Collections.sort(population, Collections.reverseOrder());
		} else {
			Collections.sort(population);
		}
	}
	
	// For testing purposes only!!
	public static void main (String[] args){
		String grammarFile = "Grammar/FeedbackGatheringConfig.bnf";
		int depth = 10;
		double probRecursive = 0.4;
		GP gp = new GP(grammarFile, depth, probRecursive);
		List<Chromosome> solutions = gp.generateSolution();
		Chromosome solution = solutions.get(0);
		System.out.println(solution.getConfiguration().toString());
		System.out.println(solution.getFitness());
	}
}
