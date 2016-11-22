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
/**
 * 
 */
package eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome;

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
			return configuration.toString().replaceAll("\\s+", " ");
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
