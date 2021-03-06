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

public class ConstrainedSingleObjectiveFitnessFunctionFGReconfiguration  extends AbstractFitnessFunction {

	private static final Logger logger = LoggerFactory.getLogger(ConstrainedSingleObjectiveFitnessFunctionFeedbackReconfiguration.class);

	
	public ConstrainedSingleObjectiveFitnessFunctionFGReconfiguration(List<String> currentConfig) {
		super(currentConfig);
	}

	@Override
	public boolean violatesConstraint(Chromosome chromosome) {
		if (chromosome.getOverallConstraint() > Parameters.CONSTRAINT_THRESHOLD){
			return true;
		}else{
			return false;
		}
	}

	@Override
	protected double[] calculate(List<String> features) {
		List<Properties> attributesOfAllFeatures =  configurationLoader.loadAttributes(features);
		
		Map<String, Double> aggregateValues = new HashMap<String, Double>();
		
		// create and initialize
		String costAttribute = "diskC";
		double costMinMax[] = new double[2];
		aggregateValues.put(costAttribute, 0d);
		
		String valueAttribute = "quality";
		aggregateValues.put(valueAttribute, 0d);
						
		for (Properties attributes : attributesOfAllFeatures){
			double cost, value, weight = 1.0;
			
			cost = Double.parseDouble(attributes.getProperty(costAttribute));
			FeatureAttributeMetadata costAttributeMetadata = featureAttributeMetadata.get(costAttribute);
			costMinMax[0] = 0;//costAttributeMetadata.getMinimumValue();
			costMinMax[1] = costAttributeMetadata.getMaximumValue();
			
			// calculate the weight (importance) of the feature for the new configuration
			switch(attributes.getProperty("mechanism")){
			case "attachment": 
				//weight = (Parameters.FG_DISKC_ATTACHMENT - costMinMax[0]) / (costMinMax[1] - costMinMax[0]) ;
				if(cost < Parameters.FG_DISKC_ATTACHMENT)
					weight = (Parameters.FG_DISKC_ATTACHMENT-cost)/costMinMax[1];//Math.abs(Parameters.FG_DISKC_ATTACHMENT-cost) / (costMinMax[1] - cost) ;
				else 
					weight = 1;//1 - weight;
				break;
			case "screenshot": 
				//weight = (Parameters.FG_DISKC_SCREENSHOT - costMinMax[0]) / (costMinMax[1] - costMinMax[0]) ;
				weight = Parameters.FG_DISKC_SCREENSHOT / costMinMax[1] ;
				weight = 1 - weight;
				break;
			case "audio": 
				//weight = (Parameters.FG_DISKC_AUDIO - costMinMax[0]) / (costMinMax[1] - costMinMax[0]) ;
				if(cost < Parameters.FG_DISKC_AUDIO)
					weight = (Parameters.FG_DISKC_AUDIO - cost) / costMinMax[1] ;
				else 
					weight = 1; //1-weight;
				break;
			}

			//weight = costAttributeMetadata.getWeight();
			
			// normalize to a value in [0, 1]
			cost = (cost - costMinMax[0]) / (costMinMax[1] - costMinMax[0]);
			aggregateValues.put(costAttribute, aggregateValues.get(costAttribute) + cost * weight);
			
			
			value = Double.parseDouble(attributes.getProperty(valueAttribute)); // already in [0,1]
			value = 1d - value; // convert to minimization
			
			aggregateValues.put(valueAttribute, aggregateValues.get(valueAttribute) + value * weight);
			
			//logger.info("\n Weight " + costAttribute + ":" + weight + "Value:" + value);
		}
		
		// overall aggregate sum of all attribute values
		double[] result = new double[2];
		result[0] = sumAll(aggregateValues.values()); // fitness value
		result[1] = aggregateValues.get(Parameters.ALERT_ATTRIBUTE); // constraint value that comes from the alert

		logger.info("\n Features:" + features + "fitnes value: " + result[0] + " constraint value " + result[1] + " ");

		return result;		
	}
	
	private double sumAll(Collection<Double> values) {
		double total = 0;
		for (Double d : values){
			total += d;
		}
		return total;
	}

	
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
}