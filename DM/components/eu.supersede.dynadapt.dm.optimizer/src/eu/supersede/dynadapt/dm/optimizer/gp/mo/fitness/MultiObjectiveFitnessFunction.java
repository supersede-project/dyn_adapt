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
package eu.supersede.dynadapt.dm.optimizer.gp.mo.fitness;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.FeatureAttributeMetadata;
import eu.supersede.dynadapt.dm.util.FeatureAttributeMetadata.Aggregators;

/**
 * @author fitsum
 *
 */
public class MultiObjectiveFitnessFunction extends AbstractFitnessFunction {
	private static final Logger logger = LoggerFactory.getLogger(MultiObjectiveFitnessFunction.class);

	private double[] currentConfigurationFitness;
	
	private Map<String, FeatureAttributeMetadata> featureAttributeMetadata = configurationLoader.getFeatureAttributeMetadata();
	
	/**
	 * @param currentConfig
	 */
	public MultiObjectiveFitnessFunction(List<String> currentConfig) {
		super(currentConfig);
		
		// calculate the fitness of the current configuration
		
		currentConfigurationFitness = calculate(currentConfig);
		logger.debug("Fitness of current config: {}", currentConfigurationFitness);
	}

	
	/*
	 * Return true if the individual is unique (i.e., was not seen so far), otherwise return false (i.e., is a duplicate)
	 * (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.FitnessFunction#evaluate(eu.supersede.dynadapt.dm.optimizer.gp.Chromosome)
	 */
	@Override
	public boolean evaluate(Chromosome chromosome) {
		boolean unique = true;
		// first check if the individual has been evaluated before
		double[] fitness = getCashedFitness(chromosome);
		if (fitness != null){
			chromosome.setObjective(fitness);
			unique = false;
//			logger.debug("Cache size: {} >> Chromsome: {} = {}", fitnessCache.size(), chromosome.getConfiguration().toString(), fitness);
		}else{
			List<String> features = Arrays.asList(chromosome.toString().split(" "));
			
			fitness = calculate(features);
			
			chromosome.setObjective(fitness);
			// save this fitness in cache
			cacheFitness(chromosome);
		}
		return unique;
	}

	
	private double[] calculate (List<String> features){
		
		List<Properties> allAttributes =  configurationLoader.loadAttributes(features);
		Map<String, Double> aggregatedValues = new HashMap<String, Double>();
		for (Properties attributes : allAttributes){
			for (Entry<String, FeatureAttributeMetadata> entry : featureAttributeMetadata.entrySet()){
				String attributeName = entry.getKey();
				double attributeValue = Double.parseDouble(attributes.getProperty(attributeName));
				
				FeatureAttributeMetadata attributeMetadata = entry.getValue();
				
				// normalize to a value in [0, 1]
				double minimum = featureAttributeMetadata.get(attributeName).getMinimumValue();
				double maximum = featureAttributeMetadata.get(attributeName).getMaximumValue();
				attributeValue = attributeValue / (maximum - minimum);
				
				// apply weight
				double weight = featureAttributeMetadata.get(attributeName).getWeight();
				attributeValue *= weight;
				
				// is minimize? invert to minimization
				if (!attributeMetadata.isMinimize()){
					attributeValue = 1d - attributeValue;
				}
				
				// aggregate
				Aggregators aggregator = featureAttributeMetadata.get(attributeName).getAggregator();
				if (Aggregators.sum == aggregator){
					if (aggregatedValues.containsKey(attributeName)){
						aggregatedValues.put(attributeName, aggregatedValues.get(attributeName) + attributeValue);
					}else{
						aggregatedValues.put(attributeName, attributeValue);
					}
				} else if (Aggregators.product == aggregator){
					if (aggregatedValues.containsKey(attributeName)){
						aggregatedValues.put(attributeName, aggregatedValues.get(attributeName) * attributeValue);
					}else{
						aggregatedValues.put(attributeName, attributeValue);
					}
				} else {
					throw new RuntimeException("Unsupported aggregator function for attribute values: " + aggregator);
				}
				
			}
		}
		
		// overall aggregate sum of all attribute values
		double[] result = new double[Parameters.NUM_OBJECTIVES];
		result[0] = aggregatedValues.get("memory_consumption");
		result[1] = aggregatedValues.get("availability"); // + aggregatedValues.get("response_time") + aggregatedValues.get("configuration_time");
		return result;
	}
	
//	private double calculateJson (List<String> features){
//		double result;
//		double sum = 0;
//		double product = 1;
//		List<List<FeatureAttribute>> attributesJSON = configurationLoader.loadAttributesJSON(features);
//		for (List<FeatureAttribute> attrs : attributesJSON){
//			for (FeatureAttribute featureAttribute : attrs){
//				// TODO currently, we convert maximization values to minimization values when loading the feature attributes
//				if (Aggregators.sum == featureAttribute.getAggregator()){
//					sum += featureAttribute.getValue();
//				}else if (Aggregators.product == featureAttribute.getAggregator()){
//					product *= featureAttribute.getValue();
//				}
//			}
//		}
//		result = sum + product;
//		return result;
//	}
	
	@Override
	public boolean isMaximizationFunction() {
		return false;
	}


	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.fitness.FitnessFunction#isFinished(eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome)
	 */
	@Override
	public boolean isFinished(Chromosome chromosome) {
		
		
		boolean finished = true;
		if (isMaximizationFunction()){
			for (int i = 0; i < chromosome.getNumberOfObjectives(); i++){
				if (currentConfigurationFitness[i] > chromosome.getObjective()[i]){
					finished = false;
					break;
				}
			}
		}else{
			for (int i = 0; i < chromosome.getNumberOfObjectives(); i++){
				if (currentConfigurationFitness[i] < chromosome.getObjective()[i]){
					finished = false;
					break;
				}
			}
		}
		return finished;
		
	}

}
