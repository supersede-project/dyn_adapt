package eu.supersede.dm.optimizer.gp.chromosome;

import eu.fbk.gbtlib.gp.individual.GPIndividual;

public class Chromosome implements Comparable {
	private GPIndividual configuration;
	private double fitness;
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
		return clone;
	}
	
	@Override
	public int compareTo(Object o) {
		Chromosome other = (Chromosome)o;
		return Double.compare(fitness, other.getFitness());
	}
	
	@Override
	public String toString() {
		if (configuration == null){
			return "";
		}else{
			return configuration.toString();
		}
	}
}
