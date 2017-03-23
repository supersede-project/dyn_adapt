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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.FeatureAttributeMetadata;

public class ConstrainedSingleObjectiveFitnessFunctionSiemens extends AbstractFitnessFunction{
	
	private static final Logger logger = LoggerFactory.getLogger(ConstrainedSingleObjectiveFitnessFunctionSiemens.class);

	/**
	 * @param currentConfig
	 */
	public ConstrainedSingleObjectiveFitnessFunctionSiemens(List<String> currentConfig) {
		super(currentConfig);		
	}


	@Override
	protected double[] calculate (List<String> features){
		
		List<Properties> attributesOfAllFeatures =  configurationLoader.loadAttributes(features);
		
		Map<String, Double> aggregateValues = new HashMap<String, Double>();
		
		// create and initialize
		String priceAttribute = "price";
		aggregateValues.put(priceAttribute, 0d);
		
		String availabilityAttribute = "availability";
		aggregateValues.put(availabilityAttribute, 1d);
		
		String responseTimeAttribute = "response_time";
		aggregateValues.put(responseTimeAttribute, 0d);
		
		for (Properties attributes : attributesOfAllFeatures){
			if (attributes == null || attributes.isEmpty()){
				// no quality attributes for some features
				continue;
			}
			double price = Double.parseDouble(attributes.getProperty(priceAttribute));
			FeatureAttributeMetadata costAttributeMetadata = featureAttributeMetadata.get(priceAttribute);
			double minimum = costAttributeMetadata.getMinimumValue();
			double maximum = costAttributeMetadata.getMaximumValue();
			double weight = costAttributeMetadata.getWeight();
			// normalize to a value in [0, 1]
//			price = price / (maximum - minimum);
			aggregateValues.put(priceAttribute, aggregateValues.get(priceAttribute) + price * weight);
			
			double availability = Double.parseDouble(attributes.getProperty(availabilityAttribute)); // already in [0,1]
			availability = 1d - availability; // convert to minimization
			weight = featureAttributeMetadata.get(availabilityAttribute).getWeight();
			aggregateValues.put(availabilityAttribute, aggregateValues.get(availabilityAttribute) * availability * weight);
			
			double responseTime = Double.parseDouble(attributes.getProperty(responseTimeAttribute));
			weight = featureAttributeMetadata.get(responseTimeAttribute).getWeight();
			aggregateValues.put(responseTimeAttribute, aggregateValues.get(responseTimeAttribute) + responseTime * weight);
		}
		
		
		// overall aggregate sum of all attribute values
		double[] result = new double[2];
		result[0] = aggregateValues.get(Parameters.ALERT_ATTRIBUTE_SIEMENS);
		result[1] = sumAll (aggregateValues.values());
		logger.debug("{} Fitness: {}, Constraint: {}", features.toString(), result[0], result[1]);
		return result;
	}
	
	
	
	private double sumAll(Collection<Double> values) {
		double total = 0;
		for (Double d : values){
			total += d;
		}
		return total;
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
	public boolean violatesConstraint (Chromosome chromosome){
//		if (chromosome.getOverallConstraint() > Parameters.SOFT_CONSTRAINT_THRESHOLD){
//			return true;
//		}else{
			return false;
//		}
	}
}
