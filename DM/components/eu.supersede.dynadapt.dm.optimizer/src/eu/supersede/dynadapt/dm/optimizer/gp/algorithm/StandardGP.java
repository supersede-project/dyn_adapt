/*******************************************************************************
 * Copyright (c) 2016 FBK
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Fitsum Kifetew (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.dm.optimizer.gp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.Tenants;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.ChromosomeFactory;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunctionAtos;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunctionFGReconfiguration;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunctionFeedbackReconfiguration;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunctionMonReconfiguration;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.ConstrainedSingleObjectiveFitnessFunctionSiemens;
import eu.supersede.dynadapt.dm.optimizer.gp.fitness.FitnessFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.CrossoverFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.MutationFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.ReplacementFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.SelectionFunction;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.SubtreeCrossover;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.SubtreeMutation;
import eu.supersede.dynadapt.dm.optimizer.gp.operators.TournamentSelection;
import eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.MaxFitnessEvaluationStoppingCondition;
import eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.MaxTimeStoppingCondition;
import eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.dm.util.RandomNumber;

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
		switch(Parameters.APPLICATION){
		case DYNAMIC_ADAPTATION:
			switch(Parameters.TENANT){
			case ATOS:
				fitnessFunction = new ConstrainedSingleObjectiveFitnessFunctionAtos(currentConfiguration);
				break;
			case SIEMENS:
				fitnessFunction = new ConstrainedSingleObjectiveFitnessFunctionSiemens(currentConfiguration);
				break;
		}

			break;
		case FEEDBACK_GATHERING:
			//The same case for the 3 uses cases
			//fitnessFunction = new ConstrainedSingleObjectiveFitnessFunctionFeedbackReconfiguration(currentConfiguration);
			fitnessFunction = new ConstrainedSingleObjectiveFitnessFunctionFGReconfiguration(currentConfiguration);
			break;
		case MONITORING:
			// handles the case of monitor reconfiguration for ATOS
			fitnessFunction = new ConstrainedSingleObjectiveFitnessFunctionMonReconfiguration(currentConfiguration);
			break;
		}
		
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
