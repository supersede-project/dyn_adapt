package eu.supersede.dm.optimizer.gp.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.util.ConfigurationLoader;
import eu.supersede.dm.util.RandomNumber;

public class SteadyStateGP extends StandardGP {
	
	private static final Logger logger = LoggerFactory.getLogger(SteadyStateGP.class);
	

	public SteadyStateGP(String grammarFile, int depth, double probRecursive, List<String> currentConfiguration) {
		super(grammarFile, depth, probRecursive, currentConfiguration);
	}

	@Override
	public List<Chromosome> generateSolution() {
		List<Chromosome> solutions = new ArrayList<Chromosome>();
		initializePopulation();
		calculateFitnessAndSortPopulation();
		while (!isFinished()) {
			evolve();
			sortPopulation();
		}
		solutions.add(population.get(0));
		logger.debug("Done after: {} generations.", generation);
		return solutions;
	}

	
	@Override
	protected void evolve() {
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
					crossoverFunction.crossOver(offspring1.getConfiguration(), offspring2.getConfiguration());
				}

				// Mutation
				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE){
					mutationFunction.mutate(offspring1.getConfiguration());
				}
				
				// compute fitness of offspring
				if (fitnessFunction.evaluate(offspring1)){
					fitnessEvaluations++;
				}
				
				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE){
					mutationFunction.mutate(offspring2.getConfiguration());
				}
				
				// compute fitness of offspring
				if (fitnessFunction.evaluate(offspring2)){
					fitnessEvaluations++;
				}
				
				// add offsprings if they are not worse than their parents
				if (replacementFunction.keepOffspring(parent1, parent2, offspring1, offspring2)){
					nextGeneration.add(offspring1);
					nextGeneration.add(offspring2);
//					logger.debug("Keeping offspring");
				}else{
					nextGeneration.add(parent1);
					nextGeneration.add(parent2);
//					logger.debug("Keeping parents");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		population = nextGeneration;
		generation++;
	}

	// For testing purposes only!!
	public static void main (String[] args){
		int depth = 10;
		double probRecursive = 0.4;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		SteadyStateGP gp = new SteadyStateGP(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = gp.generateSolution();
		Chromosome solution = solutions.get(0);
		System.out.println(solution.getConfiguration().toString());
		System.out.println(solution.getFitness());
	}
}
