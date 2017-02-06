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
package eu.supersede.dynadapt.dm.optimizer.gp;

public class Parameters {
	
	public static String INPUT_DIR = "input/refsq17/monitoring/feedbackreconfig/";
	public static String OUTPUT_DIR = "output/refsq17/monitoring/feedbackreconfig/";
	
	// feature model parameters
	public static String GRAMMAR_FILE = INPUT_DIR + "grammar/FeedbackGatheringConfig.bnf";
	public static String FEATURE_ATTRIBUTE_PATH = INPUT_DIR + "attribute_values/";
	public static String CURRENT_CONFIGURATION = INPUT_DIR + "current.conf";
	public static String ATTRIBUTE_METADATA = INPUT_DIR + "attribute.metadata.json";
	
	
	// Metaheuristic algorithm parameters
	public static int SEARCH_BUDGET = 5;
	public static Long RANDOM_SEED = null;
	public static int TOURNAMENT_SIZE = 2;
	public static int ELITE = 1;
	public static int POPULATION_SIZE = 10;
	public static double MUTATION_RATE = 0.2;
	public static double CROSSOVER_RATE = 0.8;
	
	public enum BudgetType{
		MAX_TIME, MAX_FITNESS
	}
	public static BudgetType BUDGET_TYPE = BudgetType.MAX_TIME;
	
	// Multi-objective optimization parameters
	public static int NUM_OBJECTIVES = 2;
	public static int NUM_CONSTRAINTS = 1;

	public static double CONSTRAINT_THRESHOLD = 10;
	public static String ALERT_ATTRIBUTE = "memory_consumption";
	
	public void loadFromFile(String parametersFile){
		
	}
	
	public void saveToFile(){
		
	}
}
