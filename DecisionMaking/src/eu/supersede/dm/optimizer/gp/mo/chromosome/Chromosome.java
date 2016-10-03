/**
 * 
 */
package eu.supersede.dm.optimizer.gp.mo.chromosome;

import eu.fbk.gbtlib.gp.individual.GPIndividual;

/**
 * @author fitsum
 *
 */
public class Chromosome {
	private GPIndividual configuration;
	private double fitness;
	private double crowdingDistance;
	private double [] objective;

	private int numberOfObjectives;

	private int rank;

	private double  overallConstraintViolation;

	private int  numberOfViolatedConstraints;
	
	/**
	 * 
	 */
	public Chromosome() {
		fitness = Double.MAX_VALUE;
		crowdingDistance = 0;
		objective = null;
		numberOfObjectives = 0;
		rank = Integer.MAX_VALUE;
		overallConstraintViolation = 0;
		numberOfViolatedConstraints = 0;
	}

	
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public GPIndividual getConfiguration() {
		return configuration;
	}
	public void setConfiguration(GPIndividual config) {
		this.configuration = config;
	}
	
	
	public Chromosome clone (){
		Chromosome clone = new Chromosome ();
		GPIndividual cloneConfig = (GPIndividual) configuration.clone();
		clone.setConfiguration(cloneConfig);
		clone.setFitness(fitness);
		clone.setNumberOfObjectives(numberOfObjectives);
		clone.setCrowdingDistance(crowdingDistance);
		clone.setNumberOfViolatedConstraints(numberOfViolatedConstraints);
		clone.setObjective(objective);
		clone.setOverallConstraintViolation(overallConstraintViolation);
		clone.setRank(rank);
		return clone;
	}
	
	@Override
	public String toString() {
		if (configuration == null){
			return "";
		}else{
			return configuration.toString();
		}
	}
	public double getCrowdingDistance() {
		return crowdingDistance;
	}
	public void setCrowdingDistance(double crowdingDistance) {
		this.crowdingDistance = crowdingDistance;
	}
	public double [] getObjective() {
		return objective;
	}
	public void setObjective(double [] objective) {
		this.objective = objective;
	}
	public int getNumberOfObjectives() {
		return numberOfObjectives;
	}
	public void setNumberOfObjectives(int numberOfObjectives) {
		this.numberOfObjectives = numberOfObjectives;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public double getOverallConstraintViolation() {
		return overallConstraintViolation;
	}
	public void setOverallConstraintViolation(double overallConstraintViolation) {
		this.overallConstraintViolation = overallConstraintViolation;
	}
	public int getNumberOfViolatedConstraints() {
		return numberOfViolatedConstraints;
	}
	public void setNumberOfViolatedConstraints(int numberOfViolatedConstraints) {
		this.numberOfViolatedConstraints = numberOfViolatedConstraints;
	}
}
