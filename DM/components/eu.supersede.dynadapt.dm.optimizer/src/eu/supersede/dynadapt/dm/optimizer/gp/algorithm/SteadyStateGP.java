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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters.BudgetType;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;
import eu.supersede.dynadapt.dm.util.FileUtils;
import eu.supersede.dynadapt.dm.util.RandomNumber;

public class SteadyStateGP extends StandardGP {
	
	private static final Logger logger = LoggerFactory.getLogger(SteadyStateGP.class);
	

	public SteadyStateGP(String grammarFile, int depth, double probRecursive, List<String> currentConfiguration) {
		super(grammarFile, depth, probRecursive, currentConfiguration);
	}

//	@Override
//	protected boolean isFinished() {
//		return stoppingCondition.isFinished();
//	}
	
	@Override
	public List<Chromosome> generateSolution() {
		initializePopulation();
		calculateFitnessAndSortPopulation();
		while (!isFinished()) {
			evolve();
			sortPopulation();
		}
		logger.debug("Done after: {} generations.", generation);
		return population.subList(0, 1); //return the top of the (sorted) list
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
					stoppingCondition.fitnessEvaluation();
				}
				
				if (RandomNumber.nextDouble() <= Parameters.MUTATION_RATE){
					mutationFunction.mutate(offspring2.getConfiguration());
				}
				
				// compute fitness of offspring
				if (fitnessFunction.evaluate(offspring2)){
					stoppingCondition.fitnessEvaluation();
				}
				
				
				// add offsprings if they are not worse than their parents
				if ((!fitnessFunction.violatesConstraint(offspring1) && !fitnessFunction.violatesConstraint(offspring2))
						&& replacementFunction.keepOffspring(parent1, parent2, offspring1, offspring2)){
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
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.SEARCH_BUDGET = 10;
		Parameters.POPULATION_SIZE = 15;
		
		switch (Parameters.TENANT){
		case SIEMENS:
			Parameters.ALERT_ATTRIBUTE = "availability";
			Parameters.CONSTRAINT_THRESHOLD = 1;
			break;
		case ATOS:
			Parameters.CONSTRAINT_THRESHOLD = 4; // ART in seconds
//			Parameters.CONSTRAINT_VIOLATION_PENALTY = 100;
			break;
		case FEEDBACK_GATHERING:
			break;
		}
		
		int depth = 5;
		double probRecursive = 0.005;
		List<String> currentConfiguration = ConfigurationLoader.loadCurrentConfiguration();
		SteadyStateGP gp = new SteadyStateGP(Parameters.GRAMMAR_FILE, depth, probRecursive, currentConfiguration);
		List<Chromosome> solutions = gp.generateSolution();
		Chromosome solution = solutions.get(0);
		System.out.println(solution.getConfiguration().toString());
		System.out.println("fitness:" + solution.getFitness() + ", constraint: " + solution.getOverallConstraint());
		// save solution to file
		FileUtils.writeToFile(solution.toString(), Parameters.OUTPUT_DIR + "so/optimal.config");
	}
}
