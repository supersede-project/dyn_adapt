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

import eu.supersede.dm.optimizer.gp.Parameters;

public class ConfigurationLoader {
	
	private String configurationPath;
	
	private Map<String, Properties> featureAttributes;
	
	public ConfigurationLoader() {
		configurationPath = Parameters.FEATURE_ATTRIBUTE_PATH;
		featureAttributes = new HashMap<String, Properties>();
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
}
