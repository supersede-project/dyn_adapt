package eu.supersede.dynadapt.dm.optimizer.gp.chromosome;

import eu.fbk.gbtlib.gp.individual.GPIndividual;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;

public class Chromosome implements Comparable {
	private GPIndividual configuration;
	private double fitness;
	private double overallConstraint;
	private double crowdingDistance;
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
		clone.setOverallConstraint(overallConstraint);
		return clone;
	}
	
	@Override
	public int compareTo(Object o) {
		Chromosome other = (Chromosome)o;
//		return Double.compare(fitness, other.getFitness());
		int compare = Double.compare(overallConstraint, other.getOverallConstraint());
		if (compare == 0){
			compare = Double.compare(fitness, other.getFitness());
		}
		return compare;
	}
	
	@Override
	public String toString() {
		if (configuration == null){
			return "";
		}else{
			return configuration.toString().replaceAll("\\s+", " ");
		}
	}
	public double getCrowdingDistance() {
		return crowdingDistance;
	}
	public void setCrowdingDistance(double crowdingDistance) {
		this.crowdingDistance = crowdingDistance;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}else if (obj instanceof Chromosome){
			Chromosome other = (Chromosome)obj;
			if (other.toString().equalsIgnoreCase(toString())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean violatesConstraint(){
		return (overallConstraint > Parameters.CONSTRAINT_THRESHOLD);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	public double getOverallConstraint() {
		return overallConstraint;
	}
	public void setOverallConstraint(double overallConstraint) {
		this.overallConstraint = overallConstraint;
	}
}
