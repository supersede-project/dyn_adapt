package eu.supersede.dm.optimizer.gp;

public class Parameters {
	
	// feature model parameters
	public static String GRAMMAR_FILE = "Grammar/FeedbackGatheringConfig.bnf";
	public static String FEATURE_ATTRIBUTE_PATH = "input/refsq17/monitoring/feedbackreconfig/";
	public static String CURRENT_CONFIGURATION = "input/refsq17/monitoring/feedbackreconfig/current3.conf";
	public static String ATTRIBUTE_METADATA = "input/refsq17/monitoring/feedbackreconfig/attribute.metadata.json";
	
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
	
	public void loadFromFile(String parametersFile){
		
	}
	
	public void saveToFile(){
		
	}
}
