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
package eu.supersede.dynadapt.dm.optimizer.gp.mo.fitness;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.ConfigurationLoader;

public abstract class AbstractFitnessFunction implements FitnessFunction {
	
	protected Map<Integer,double[]> fitnessCache = new HashMap<Integer, double[]>();
	
	protected ConfigurationLoader configurationLoader = ConfigurationLoader.getInstance();
	
	private List<String> currentConfiguration;
	
	/**
	 * 
	 */
	public AbstractFitnessFunction(List<String> currentConfig) {
		currentConfiguration = currentConfig;
	}
	
	/*
	 * Returns the cached fitness value for the individual, else returns NULL
	 */
	protected double[] getCashedFitness (Chromosome chromosome){
		Integer hashCode = chromosome.hashCode();
		return fitnessCache.get(hashCode);
	}
	
	protected void cacheFitness (Chromosome chromosome){
		Integer hashCode = chromosome.hashCode();
		fitnessCache.put(hashCode, chromosome.getObjective());
	}

	public List<String> getCurrentConfiguration() {
		return currentConfiguration;
	}

	public void setCurrentConfiguration(List<String> currentConfiguration) {
		this.currentConfiguration = currentConfiguration;
	}
}
