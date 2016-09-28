package eu.supersede.dm.optimizer.gp.fitness;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.util.FeatureAttributeMetadata;
import eu.supersede.dm.util.FeatureAttributeMetadata.Aggregators;

public class SingleObjectiveFitnessFunction extends AbstractFitnessFunction{
	
	private static final Logger logger = LoggerFactory.getLogger(SingleObjectiveFitnessFunction.class);

	private double currentConfigurationFitness;
	
	private Map<String, FeatureAttributeMetadata> featureAttributeMetadata = configurationLoader.getFeatureAttributeMetadata();
	
	/**
	 * @param currentConfig
	 */
	public SingleObjectiveFitnessFunction(List<String> currentConfig) {
		super(currentConfig);
		
		// calculate the fitness of the current configuration
		
		currentConfigurationFitness = calculate(currentConfig);
		logger.debug("Fitness of current config: {}", currentConfigurationFitness);
	}

	
	/*
	 * Return true if the individual is unique (i.e., was not seen so far), otherwise return false (i.e., is a duplicate)
	 * (non-Javadoc)
	 * @see eu.supersede.dm.optimizer.gp.FitnessFunction#evaluate(eu.supersede.dm.optimizer.gp.Chromosome)
	 */
	@Override
	public boolean evaluate(Chromosome chromosome) {
		boolean unique = true;
		// first check if the individual has been evaluated before
		Double fitness = getCashedFitness(chromosome);
		if (fitness != null){
			chromosome.setFitness(fitness);
			unique = false;
//			logger.debug("Cache size: {} >> Chromsome: {} = {}", fitnessCache.size(), chromosome.getConfiguration().toString(), fitness);
		}else{
			List<String> features = Arrays.asList(chromosome.toString().split(" "));
			
			fitness = calculate(features);
			
			chromosome.setFitness(fitness);
			// save this fitness in cache
			cacheFitness(chromosome);
		}
		return unique;
	}

	
	private double calculate (List<String> features){
		
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
		double result = 0;
		for (Double v : aggregatedValues.values()){
			result += v;
		}
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
	 * @see eu.supersede.dm.optimizer.gp.fitness.FitnessFunction#isFinished(eu.supersede.dm.optimizer.gp.chromosome.Chromosome)
	 */
	@Override
	public boolean isFinished(Chromosome chromosome) {
		if (isMaximizationFunction()){
			return (currentConfigurationFitness < chromosome.getFitness());
		} else{
			return (currentConfigurationFitness > chromosome.getFitness());
		}
	}

}
