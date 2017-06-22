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

public class ConstrainedSingleObjectiveFitnessFunction extends AbstractFitnessFunction{
	
	private static final Logger logger = LoggerFactory.getLogger(ConstrainedSingleObjectiveFitnessFunction.class);

	/**
	 * @param currentConfig
	 */
	public ConstrainedSingleObjectiveFitnessFunction(List<String> currentConfig) {
		super(currentConfig);		
	}


	@Override
	protected double[] calculate (List<String> features){
		
		List<Properties> attributesOfAllFeatures =  configurationLoader.loadAttributes(features);
		
		// create and initialize
		String costAttribute = "price";
		double overallCost = 0d;
		String valueAttribute = "availability";
		double overallValue = 1d;
		
		String alertAttribute = "response_time";
		double overallConstraint = 0d;
		
		for (Properties attributes : attributesOfAllFeatures){
			if (attributes == null){
				// no quality attributes for some features
				continue;
			}
			double cost = Double.parseDouble(attributes.getProperty(costAttribute));
			FeatureAttributeMetadata costAttributeMetadata = featureAttributeMetadata.get(costAttribute);
			double minimum = costAttributeMetadata.getMinimumValue();
			double maximum = costAttributeMetadata.getMaximumValue();
			double weight = costAttributeMetadata.getWeight();
			// normalize to a value in [0, 1]
			cost = cost / (maximum - minimum);
			overallCost += cost*weight;
			
			double value = Double.parseDouble(attributes.getProperty(valueAttribute)); // already in [0,1]
			value = 1d - value; // convert to minimization
			weight = featureAttributeMetadata.get(valueAttribute).getWeight();
			overallValue *= value * weight;
			
			double alertValue = Double.parseDouble(attributes.getProperty(alertAttribute));
			overallConstraint += alertValue;
		}
		
		// overall aggregate sum of all attribute values
		double[] result = new double[2];
		result[0] = overallCost + overallValue;	// fitness value
		result[1] = overallConstraint; // constraint value
		return result;
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
		if (chromosome.getOverallConstraint() > Parameters.CONSTRAINT_THRESHOLD){
			return true;
		}else{
			return false;
		}
	}
}
