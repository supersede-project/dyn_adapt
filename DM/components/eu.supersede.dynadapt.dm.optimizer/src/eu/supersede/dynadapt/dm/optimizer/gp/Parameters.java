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
		ATOS, SIEMENS, SENERCON
	}
	
	public enum Applications{
		DYNAMIC_ADAPTATION, MONITORING, FEEDBACK_GATHERING
	}
	
	public static Applications APPLICATION = Applications.DYNAMIC_ADAPTATION;
	public static Tenants TENANT = Tenants.ATOS;
	
	private static String ATOS_INPUT_DIR = "serialization/atos/";
	private static String ATOS_OUTPUT_DIR = "output/atos/";
	private static String SIEMENS_INPUT_DIR = "serialization/siemens/";
	private static String SIEMENS_OUTPUT_DIR = "output/siemens/";
	
	private static String FEEDBACK_INPUT_DIR = "input/refsq17/monitoring/feedbackreconfig/";
	private static String FEEDBACK_OUTPUT_DIR = "output/refsq17/monitoring/feedbackreconfig/";
	
	
	public static String INPUT_DIR = ATOS_INPUT_DIR;
	public static String OUTPUT_DIR = ATOS_OUTPUT_DIR;  
	
	// feature model parameters - these values are for the ATOS HSK scenario (for testing purposes), they need to be changed in case another scenario is being tested
	public static String GRAMMAR_FILE = INPUT_DIR + "SmartPlatformFM.bnf";
	public static String FEATURE_ATTRIBUTE_PATH = INPUT_DIR;
	public static String CURRENT_CONFIGURATION = INPUT_DIR + "SmartPlatformFC_HSK_LowLoad.conf";
	public static String ATTRIBUTE_METADATA = INPUT_DIR + "SmartPlatformFM.json";
	
//	static{
//		switch (APPLICATION){
//		case DYNAMIC_ADAPTATION:
//			switch (TENANT){
//			case ATOS:
//				INPUT_DIR = ATOS_INPUT_DIR;
//				OUTPUT_DIR = ATOS_OUTPUT_DIR;
//				
//				GRAMMAR_FILE = INPUT_DIR + "SmartPlatformFM.bnf";
//				FEATURE_ATTRIBUTE_PATH = INPUT_DIR; // + "attribute_values/";
//				CURRENT_CONFIGURATION = INPUT_DIR + "SmartPlatformFC_HSK_LowLoad.conf";
//				ATTRIBUTE_METADATA = INPUT_DIR + "SmartPlatformFM.json";
//				
//				break;
//			case SIEMENS:
//				INPUT_DIR = SIEMENS_INPUT_DIR;
//				OUTPUT_DIR = SIEMENS_OUTPUT_DIR;
//				
//				GRAMMAR_FILE = INPUT_DIR + "FeatureModel.bnf";
//				FEATURE_ATTRIBUTE_PATH = INPUT_DIR; // + "attribute_values/";
//				CURRENT_CONFIGURATION = INPUT_DIR + "FeatureModel-S1c_dm.conf";
//				ATTRIBUTE_METADATA = INPUT_DIR + "FeatureModel.json";
//				
//				break;
//			}
//			break;
//			
//		case FEEDBACK_GATHERING: //TODO: Create a directory different for tenance 
//			switch (TENANT){
//			case ATOS:
//				INPUT_DIR = FEEDBACK_INPUT_DIR;
//				OUTPUT_DIR = FEEDBACK_OUTPUT_DIR;
//				
//				GRAMMAR_FILE = INPUT_DIR + "/grammar/FeedbackGatheringConfig.bnf";
//				FEATURE_ATTRIBUTE_PATH = INPUT_DIR + "attribute_values/";
//				CURRENT_CONFIGURATION = INPUT_DIR + "current.conf";
//				ATTRIBUTE_METADATA = INPUT_DIR + "attribute.metadata.json";
//				
//				break;
//			case SIEMENS:
//				INPUT_DIR = FEEDBACK_INPUT_DIR;
//				OUTPUT_DIR = FEEDBACK_OUTPUT_DIR;
//				
//				GRAMMAR_FILE = INPUT_DIR + "/grammar/FeedbackGatheringConfig.bnf";
//				FEATURE_ATTRIBUTE_PATH = INPUT_DIR + "attribute_values/";
//				CURRENT_CONFIGURATION = INPUT_DIR + "current.conf";
//				ATTRIBUTE_METADATA = INPUT_DIR + "attribute.metadata.json";
//				
//				break;
//			case SENERCON:
//				INPUT_DIR = FEEDBACK_INPUT_DIR;
//				OUTPUT_DIR = FEEDBACK_OUTPUT_DIR;
//				
//				GRAMMAR_FILE = INPUT_DIR + "/grammar/FeedbackGatheringConfig.bnf";
//				FEATURE_ATTRIBUTE_PATH = INPUT_DIR + "attribute_values/";
//				CURRENT_CONFIGURATION = INPUT_DIR + "current.conf";
//				ATTRIBUTE_METADATA = INPUT_DIR + "attribute.metadata.json";
//				
//				break;
//			}
//			
//			break;
//		case MONITORING: //TODO: Complete for monitoring 
//			break;
//		}
//	}
	
	
	
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

	public static double CONSTRAINT_THRESHOLD = 20; //Average Response Time
//	public static double SOFT_CONSTRAINT_THRESHOLD = 4;
//	public static double CONSTRAINT_VIOLATION_PENALTY = 20; //CONSTRAINT_THRESHOLD;
	
	public static String ALERT_ATTRIBUTE = "response_time";
//	public static double CONSTRAINT_THRESHOLD_SIEMENS = 0.15;
	
//	public static String ALERT_ATTRIBUTE_FEEDBACK = "response_time";
//	public static double CONSTRAINT_THRESHOLD_FEEDBACK = 0.95;
	
	
	// parameters specific to ATOS HSK Scenario
	public static double ATOS_HSK_CONST1 = 10;
	public static double ATOS_HSK_CONST2 = 1.5;
	public static double ATOS_HSK_CONST3 = 0;
	public static double ATOS_HSK_CONST4 = 1.5;
	public static double ATOS_HSK_CONST5 = 1;
	public static double ATOS_HSK_CONST6 = 1000;
	
	public void loadFromFile(String parametersFile){
		
	}
	
	public void saveToFile(){
		
	}
}
