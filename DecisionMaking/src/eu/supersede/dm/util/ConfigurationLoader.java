package eu.supersede.dm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.fitness.SingleObjectiveFitnessFunction;
import eu.supersede.dm.util.FeatureAttributeMetadata.Aggregators;

public class ConfigurationLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationLoader.class);
	
	private String configurationPath;
	private String attributeMetadataPath;
	private Map<String, Properties> featureAttributes;
	
	private Map<String, List<FeatureAttribute>> jsonAttributes;
	
	private Map<String, FeatureAttributeMetadata> featureAttributeMetadata;
	
	private static ConfigurationLoader instance;
	
//	private static String[] ATTRIBUTE_NAMES = {"memory_consumption", "availability", "response_time", "configuration_time"};
	
	public static ConfigurationLoader getInstance(){
		if (instance == null){
			instance = new ConfigurationLoader();
		}
		return instance;
	}
	
	private ConfigurationLoader() {
		configurationPath = Parameters.FEATURE_ATTRIBUTE_PATH;
		attributeMetadataPath = Parameters.ATTRIBUTE_METADATA;
		featureAttributes = new HashMap<String, Properties>();
		jsonAttributes = new HashMap<String, List<FeatureAttribute>>();
		loadAttributeMetadata();
	}
	
//	public List<List<FeatureAttribute>> loadAttributesJSON(List<String> configuration){
//		List<List<FeatureAttribute>> attrs = new ArrayList<List<FeatureAttribute>> ();
//		for (String feature : configuration){
//			if (feature.isEmpty()){
//				continue;
//			}
//			
//			List<FeatureAttribute> attributes = loadAttributesJSON(feature, true);
//			attrs.add(attributes);
//		}
//		return attrs;
//	}
	
//	private List<FeatureAttribute> loadAttributesJSON (String feature, boolean useCache){
//		List<FeatureAttribute> attributes = null;
//		
//		if (useCache){
//			attributes = jsonAttributes.get(feature);
//		}
//		
//		// if not in cache, load it from the json file on disk
//		if (attributes == null){
//			attributes = new ArrayList<FeatureAttribute>();
//			String jsonFile = configurationPath + File.separator + feature + ".json";
//			FileReader fileReader;
//			try {
//				fileReader = new FileReader(jsonFile);
//				JSONTokener jsonTokener = new JSONTokener(fileReader);
//				JSONObject jsonObject = new JSONObject(jsonTokener);
//				
//				Map<String, Object> map = jsonObject.toMap();
//				for (Entry<String, Object> entry : map.entrySet()){
//					String attributeName = entry.getKey();
//					
//					Map<Object, Object> valueMap = (Map<Object, Object>)entry.getValue();
//	
//					FeatureAttribute featureAttribute = new FeatureAttribute();
//					
//					featureAttribute.setName(attributeName);
//					
//					/*
//					 * IMPORTANT!! If maximization, convert to minimization, hence we always do minimization
//					 */
//	//				String opt = jsonObject.query("/" + attributeName + "/opt").toString();
//					String opt = (String) valueMap.get("opt");
//					featureAttribute.setMinimize(true);
//	//				double value = Double.parseDouble(jsonObject.query("/" + attributeName + "/value").toString());
//					double value = Double.parseDouble(valueMap.get("value").toString()); 
//					if ("max".equalsIgnoreCase(opt)){
//						value = 1d / (1d + value); // convert to minimization
//					}
//					featureAttribute.setValue(value);
//					
//					
//	//				String domain = jsonObject.query("/" + attributeName + "/domain").toString();
//					String domain = (String) valueMap.get("domain");
//					if ("int".equalsIgnoreCase(domain)){
//						featureAttribute.setDomain(Integer.class);
//					}else{
//						featureAttribute.setDomain(Double.class);
//					}
//					
//	//				Aggregators aggregator = Aggregators.valueOf(jsonObject.query("/" + attributeName + "/aggregator").toString());
//					Aggregators aggregator = Aggregators.valueOf((String) valueMap.get("aggregator"));
//					featureAttribute.setAggregator(aggregator);
//					
//					attributes.add(featureAttribute);
//				}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			// save it in cache
//			jsonAttributes.put(feature, attributes);
//		}
//		return attributes;
//	}
	
	private void loadAttributeMetadata(){
		featureAttributeMetadata = new HashMap<String, FeatureAttributeMetadata>();
		try {
			FileReader fileReader = new FileReader(attributeMetadataPath);
			JSONTokener jsonTokener = new JSONTokener(fileReader);
			JSONObject jsonObject = new JSONObject(jsonTokener);
			
			Map<String, Object> map = jsonObject.toMap();
			for (Entry<String, Object> entry : map.entrySet()){
				String attributeName = entry.getKey();
				
				Map<Object, Object> valueMap = (Map<Object, Object>)entry.getValue();


				double weight = Double.parseDouble(valueMap.get("weight").toString());
				double minimumValue = Double.parseDouble(valueMap.get("min").toString());
				double maximumValue = Double.parseDouble(valueMap.get("max").toString());
				String strDomain = (String) valueMap.get("domain");
				Class domain;
				if ("int".equalsIgnoreCase(strDomain)){
					domain = Integer.class;
				}else{
					domain = Double.class;
				}
				Aggregators aggregator = Aggregators.valueOf((String) valueMap.get("aggregator"));
				boolean minimize = Boolean.parseBoolean(valueMap.get("minimize").toString());

				
				FeatureAttributeMetadata attributeMetadata = new FeatureAttributeMetadata();
				attributeMetadata.setName(attributeName);
				attributeMetadata.setDomain(domain);
				attributeMetadata.setMaximumValue(maximumValue);
				attributeMetadata.setMinimumValue(minimumValue);
				attributeMetadata.setWeight(weight);
				attributeMetadata.setAggregator(aggregator);
				attributeMetadata.setMinimize(minimize);
				
				getFeatureAttributeMetadata().put(attributeName, attributeMetadata);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Load the quality attributes corresponding to a given feature
	private Properties loadAttributes (String feature, boolean useCache){
		// check if it has been loaded before
		Properties attributes = null;
		if (useCache){
			attributes = featureAttributes.get(feature);
		}
		
		// if not in cache, or using cache is disabled, then load it from disk
		if (attributes == null){
			attributes = new Properties();
			try {
				attributes.load(new FileReader(configurationPath + File.separator + feature + ".properties"));
				// save in cache
				featureAttributes.put(feature, attributes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return attributes;
	}
	
	public List<Properties> loadAttributes (List<String> configuration){
		List<Properties> allAttributes = new ArrayList<Properties>();
		for (String feature : configuration){
			if (feature != null && !feature.trim().isEmpty()) {
				Properties attributes = loadAttributes(feature, true);
				allAttributes.add(attributes);
			}
		}
		return allAttributes;
	}
	
	public void resetCache (){
		featureAttributes.clear();
		jsonAttributes.clear();
	}
	
	public void refreshCache (){
		// re-read from file the values of attributes in the cache
		for (String feature : featureAttributes.keySet()){
			featureAttributes.put(feature, loadAttributes(feature, false));
		}
	}
	
	/*
	 * assume that the current configuration is stored in a file (each separated by comma or other character)
	 */
	public static List<String> loadCurrentConfiguration (){
		List<String> currentConfiguration = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Parameters.CURRENT_CONFIGURATION));
			while (bufferedReader.ready()){
				String line = bufferedReader.readLine();
				if (line != null && !line.trim().isEmpty()){
					currentConfiguration.add(line.trim());
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentConfiguration;
	}

	public Map<String, FeatureAttributeMetadata> getFeatureAttributeMetadata() {
		return featureAttributeMetadata;
	}

}
