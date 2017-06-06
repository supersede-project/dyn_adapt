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
package eu.supersede.dynadapt.dm.optimizer.gp.fitness;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.FeatureAttributeMetadata;

public class ConstrainedSingleObjectiveFitnessFunctionAtos extends AbstractFitnessFunction{
	
	private static final Logger logger = LoggerFactory.getLogger(ConstrainedSingleObjectiveFitnessFunctionAtos.class);

	/**
	 * @param currentConfig
	 */
	public ConstrainedSingleObjectiveFitnessFunctionAtos(List<String> currentConfig) {
		super(currentConfig);		
	}


	@Override
	protected double[] calculate (List<String> features){
		
		List<Properties> attributesOfAllFeatures =  configurationLoader.loadAttributes(features);
		
		double minimumCores = computeMinimumCores();
		double minimumMemory = computeMinimumMemory();
		
		
		// create and initialize
		String coresAttribute = "cores";
		String memoryAttribute = "memory";
		double totalCores = 0d;
		double totalMemory = 0d;
//		double overallValue = 1d;
		
//		String alertAttribute = "art";
//		double overallConstraint = 0d;
		
		double physicalCores = configurationLoader.getFeatureAttributeMetadata().get(coresAttribute).getMaximumValue();
		double physicalMemory = configurationLoader.getFeatureAttributeMetadata().get(memoryAttribute).getMaximumValue();
		
		for (Properties attributes : attributesOfAllFeatures){
			if (attributes == null || attributes.isEmpty()){
				// no quality attributes for some features
				continue;
			}
			double cores = Double.parseDouble(attributes.getProperty(coresAttribute));
//			FeatureAttributeMetadata costAttributeMetadata1 = featureAttributeMetadata.get(costAttribute1);
//			double minimum = costAttributeMetadata1.getMinimumValue();
//			double maximum = costAttributeMetadata1.getMaximumValue();
//			double weight = costAttributeMetadata1.getWeight();
//			// normalize to a value in [0, 1]
//			cost1 = cost1 / (maximum - minimum);
//			overallCost += cost1*weight;
			
			totalCores += cores;
			
			double memory = Double.parseDouble(attributes.getProperty(memoryAttribute));
//			FeatureAttributeMetadata costAttributeMetadata2 = featureAttributeMetadata.get(costAttribute2);
//			minimum = costAttributeMetadata2.getMinimumValue();
//			maximum = costAttributeMetadata2.getMaximumValue();
//			weight = costAttributeMetadata2.getWeight();
//			// normalize to a value in [0, 1]
//			cost2 = cost2 / (maximum - minimum);
//			overallCost += cost2*weight;

			totalMemory += memory;
			
//			double alertValue = Double.parseDouble(attributes.getProperty(alertAttribute));
//			overallConstraint += cores;
//			overallConstraint += memory;
		}
		
		logger.debug(features.toString() + totalCores);

		double[] result = new double[2];
		
		// are physical (hard) constraints respected by this solution?
		if (totalCores <= 0 || totalMemory <= 0 || totalCores > physicalCores || totalMemory > physicalMemory){
			// invalid individual
//			overallCost1 = Double.MAX_VALUE;
			result[0] = Double.MAX_VALUE;
			result[1] = Double.MAX_VALUE;
		} else{
			// compute average response time (art)
			double art = computeFitness (totalCores, totalMemory);
			result[0] = art;
			result[1] = totalCores + totalMemory;
		}
		
		
		
//		// penalize individuals that violate the soft constraints
//		if (overallCost1 < Parameters.SOFT_CONSTRAINT_THRESHOLD){
//			overallCost1 += Parameters.CONSTRAINT_VIOLATION_PENALTY;
//			overallConstraint = overallCost1;
//		}
//		
//		
//		result[0] = overallCost1; // + overallValue;	// fitness value
//		result[1] = overallConstraint; // constraint value
		return result;
	}
	
	private double computeMinimumMemory() {
		// TODO Auto-generated method stub
		return 0;
	}


	private double computeMinimumCores() {
		// TODO Auto-generated method stub
		return 0;
	}


	/*
	 * compute the estimated average response time given #cores and memory
	 */
	private double computeART (double totalCores, double totalMemory){
		double a = 1;
		double b = 1;
//		double threads = (totalCores - b) / a;
		double threads = Parameters.ATOS_HSK_CONST6 * totalCores;
		double art = a / threads;
		return art;
	}
	
	private double computeFitness (double totalCores, double totalMemory){
		final double ART = Parameters.CONSTRAINT_THRESHOLD; // = 5 seconds
//		final double C1 = 10, C2 = 1, C3 = 0, C4 = 1, C5 = 1;
		double threads = Parameters.ATOS_HSK_CONST1 / ART; //40 ms (normal), 1 sec (anormal)
		//Normal ART (40ms, 100ms) up to 500 thread - 1 core, 1GB RAM
		//Abnormal ART (~1000 ms) - 1000 thread - 2 cores, 2GB RAM
		
		double minimumCores = Parameters.ATOS_HSK_CONST2 * threads + Parameters.ATOS_HSK_CONST3; //C3=0, C2, 1 core = 500 threads, 2 cores = 1000 threads
		double minimumMemory = Parameters.ATOS_HSK_CONST4 * threads + Parameters.ATOS_HSK_CONST5; //C5=0, C4, 1GB = 500 threads, 2 Gb = 1000 threads
		if (totalCores < minimumCores || totalMemory < minimumMemory){
			// invalid individual
			return Double.MAX_VALUE;
		}else{
			return totalMemory - minimumMemory + totalCores - minimumCores;
		}
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.fitness.SingleObjectiveFitnessFunction#isFinished(eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome)
	 */
	@Override
	public boolean isFinished(Chromosome chromosome) {
		if (violatesConstraint(chromosome)){
			return false;
		}else{
			if (isMaximizationFunction()){
				return (currentConfigurationFitness < chromosome.getFitness());
			} else{
				return (currentConfigurationFitness > chromosome.getFitness());
			}
		}
	}
	
	@Override
	public boolean isMaximizationFunction() {
		return false;
	}
	
	@Override
	public boolean violatesConstraint (Chromosome chromosome){
		if (chromosome.getOverallConstraint() <= 0 ){ //Parameters.SOFT_CONSTRAINT_THRESHOLD){
			return true;
		}else{
			return false;
		}
	}
}
