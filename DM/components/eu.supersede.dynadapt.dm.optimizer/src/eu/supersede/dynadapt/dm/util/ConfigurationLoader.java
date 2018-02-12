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
package eu.supersede.dynadapt.dm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.util.FeatureAttributeMetadata.Aggregators;

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
	
	private void loadAttributeMetadata(){
		featureAttributeMetadata = new HashMap<String, FeatureAttributeMetadata>();
		try {
			FileReader fileReader = new FileReader(attributeMetadataPath);
			JSONTokener jsonTokener = new JSONTokener(fileReader);
			JSONObject jsonObject = new JSONObject(jsonTokener);
			
			Map<String, Object> map = jsonObject.toMap();
			for (Entry<String, Object> entry : map.entrySet()){
				String attributeName = entry.getKey();
				// trim away the namespace prefix from the attribute name
				attributeName = attributeName.substring(attributeName.lastIndexOf(".")+1);
				
				Map<Object, Object> valueMap = (Map<Object, Object>)entry.getValue();

				boolean alert = Boolean.parseBoolean(valueMap.get("alert").toString());
				double weight = Double.parseDouble(valueMap.get("weight").toString());
				double minimumValue = parseDouble(valueMap.get("min").toString());
				double maximumValue = parseDouble(valueMap.get("max").toString());
				String strDomain = (String) valueMap.get("domain");
				Class domain;
				if ("int".equalsIgnoreCase(strDomain)){
					domain = Integer.class;
				}else if ("double".equalsIgnoreCase(strDomain)){
					domain = Double.class;
				}else {
					domain = String.class;
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
				attributeMetadata.setAlert(alert);
				
				getFeatureAttributeMetadata().put(attributeName, attributeMetadata);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private double parseDouble (String s) {
		double d = 0d;
		if (s.contains("%")) {
			d = Double.parseDouble(s.trim().replace("%", "")) / 100d;
		}else {
			d = Double.parseDouble(s);
		}
		return d;
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
//				featureAttributes.put(feature, attributes);
			} catch (IOException e) {
				System.err.println("probably the feature: " + feature + " does not have quality attributes associated.");
//				e.printStackTrace();
			}
			featureAttributes.put(feature, attributes);
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
