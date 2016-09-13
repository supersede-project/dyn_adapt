package eu.supersede.dm.optimizer.gp;

public class Parameters {
	
	// feature model parameters
	public static String GRAMMAR_FILE = "Grammar/FeedbackGatheringConfig.bnf";
	public static String FEATURE_ATTRIBUTE_PATH = "input/monitoring/feedbackreconfig";
	
	// Metaheuristic algorithm parameters
	public static int SEARCH_BUDGET = 1000;
	public static Long RANDOM_SEED = null;
	public static int TOURNAMENT_SIZE = 2;
	public static int ELITE = 1;
	public static int POPULATION_SIZE = 100;
	public static double MUTATION_RATE = 0.2;
	public static double CROSSOVER_RATE = 0.8;
	
	public void loadFromFile(String parametersFile){
		
	}
	
	public void saveToFile(){
		
	}
}
