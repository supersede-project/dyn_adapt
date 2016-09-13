package eu.supersede.dm.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigurationLoader {
	
	private String configurationPath;
	
	public ConfigurationLoader() {
		configurationPath = "Grammar/monitoring/feedbackreconfig";
		
	}
	
	// Load the quality attributes corresponding to a given feature
	public Properties loadAttributes (String feature){
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(configurationPath + File.separator + feature + ".properties"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public List<Properties> loadAttributes (List<String> configuration){
		List<Properties> properties = new ArrayList<Properties>();
		for (String feature : configuration){
			if (feature != null && !feature.trim().isEmpty())
				properties.add(loadAttributes(feature));
		}
		return properties;
	}
	
	
}
