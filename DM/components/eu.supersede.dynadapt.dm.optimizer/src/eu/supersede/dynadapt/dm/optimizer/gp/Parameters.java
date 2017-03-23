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
	// tenant
	public enum Tenants{
		ATOS, SIEMENS, SENERCON, MONITORING, FEEDBACK_GATHERING
	}
	public static Tenants TENANT = Tenants.ATOS; // .FEEDBACK_GATHERING;
	
	private static String ATOS_INPUT_DIR = "/data/workspace_supersede2/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.optimizer/serialization/atos/";
	private static String ATOS_OUTPUT_DIR = "/data/workspace_supersede2/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.optimizer/output/atos/";
	private static String SIEMENS_INPUT_DIR = "/data/workspace_supersede2/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.optimizer/serialization/siemens/";
	private static String SIEMENS_OUTPUT_DIR = "/data/workspace_supersede2/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.optimizer/output/siemens/";
	
	private static String FEEDBACK_INPUT_DIR = "/data/workspace_supersede2/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.optimizer/input/refsq17/monitoring/feedbackreconfig/";
	private static String FEEDBACK_OUTPUT_DIR = "/data/workspace_supersede2/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.optimizer/output/refsq17/monitoring/feedbackreconfig/";
	
	
	public static String INPUT_DIR = SIEMENS_INPUT_DIR;
	public static String OUTPUT_DIR = SIEMENS_OUTPUT_DIR;  
	
	// feature model parameters
	public static String GRAMMAR_FILE = INPUT_DIR + "SmartPlatformFM.bnf";
	public static String FEATURE_ATTRIBUTE_PATH = INPUT_DIR; // + "attribute_values/";
	public static String CURRENT_CONFIGURATION = INPUT_DIR + "SmartPlatformFC_HSK_LowLoad.conf";
	public static String ATTRIBUTE_METADATA = INPUT_DIR + "SmartPlatformFM.json";
	
	static{
		switch (TENANT){
		case ATOS:
			INPUT_DIR = ATOS_INPUT_DIR;
			OUTPUT_DIR = ATOS_OUTPUT_DIR;
			
			GRAMMAR_FILE = INPUT_DIR + "SmartPlatformFM.bnf";
			FEATURE_ATTRIBUTE_PATH = INPUT_DIR; // + "attribute_values/";
			CURRENT_CONFIGURATION = INPUT_DIR + "SmartPlatformFC_HSK_LowLoad.conf";
			ATTRIBUTE_METADATA = INPUT_DIR + "SmartPlatformFM.json";
			
			break;
		case SIEMENS:
			INPUT_DIR = SIEMENS_INPUT_DIR;
			OUTPUT_DIR = SIEMENS_OUTPUT_DIR;
			
			GRAMMAR_FILE = INPUT_DIR + "FeatureModel.bnf";
			FEATURE_ATTRIBUTE_PATH = INPUT_DIR; // + "attribute_values/";
			CURRENT_CONFIGURATION = INPUT_DIR + "FeatureModel-S1c_dm.conf";
			ATTRIBUTE_METADATA = INPUT_DIR + "FeatureModel.json";
			
			break;
		case FEEDBACK_GATHERING:
			INPUT_DIR = FEEDBACK_INPUT_DIR;
			OUTPUT_DIR = FEEDBACK_OUTPUT_DIR;
			
			GRAMMAR_FILE = INPUT_DIR + "/grammar/FeedbackGatheringConfig.bnf";
			FEATURE_ATTRIBUTE_PATH = INPUT_DIR + "attribute_values/";
			CURRENT_CONFIGURATION = INPUT_DIR + "current.conf";
			ATTRIBUTE_METADATA = INPUT_DIR + "attribute.metadata.json";
			break;
		}
	}
	
	
	
	// Metaheuristic algorithm parameters
	public static int SEARCH_BUDGET = 5;
	public static Long RANDOM_SEED = null;
	public static int TOURNAMENT_SIZE = 2;
	public static int ELITE = 1;
	public static int POPULATION_SIZE = 4;
	public static double MUTATION_RATE = 0.2;
	public static double CROSSOVER_RATE = 0.8;
	
	public static int MAX_DUPLICATE_TRIALS = 10;
	
	public enum BudgetType{
		MAX_TIME, MAX_FITNESS
	}
	public static BudgetType BUDGET_TYPE = BudgetType.MAX_TIME;
	
	// Multi-objective optimization parameters
	public static int NUM_OBJECTIVES = 2;
	public static int NUM_CONSTRAINTS = 1;

	public static double CONSTRAINT_THRESHOLD = 20;
//	public static double SOFT_CONSTRAINT_THRESHOLD = 4;
//	public static double CONSTRAINT_VIOLATION_PENALTY = 20; //CONSTRAINT_THRESHOLD;
	
	public static String ALERT_ATTRIBUTE = "response_time";
//	public static double CONSTRAINT_THRESHOLD_SIEMENS = 0.15;
	
//	public static String ALERT_ATTRIBUTE_FEEDBACK = "response_time";
//	public static double CONSTRAINT_THRESHOLD_FEEDBACK = 0.95;
	
	public void loadFromFile(String parametersFile){
		
	}
	
	public void saveToFile(){
		
	}
}
