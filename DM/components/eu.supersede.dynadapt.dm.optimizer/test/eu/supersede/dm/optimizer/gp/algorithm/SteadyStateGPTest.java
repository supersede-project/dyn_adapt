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
		Parameters.SEARCH_BUDGET = 5;
		Parameters.BUDGET_TYPE = BudgetType.MAX_TIME;
		Parameters.POPULATION_SIZE = 5;
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
