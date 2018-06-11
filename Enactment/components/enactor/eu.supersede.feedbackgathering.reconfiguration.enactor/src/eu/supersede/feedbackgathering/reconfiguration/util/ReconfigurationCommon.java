package eu.supersede.feedbackgathering.reconfiguration.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class ReconfigurationCommon {

	public static Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		//Path path = Paths.get(userdir, "model");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	public static Properties loadProperties(ClassLoader obj) throws IOException{
		final Properties properties = new Properties();
		properties.load(obj.getResourceAsStream("feedback.properties"));
		return properties;
	}
	
	public static long getIdApplication(ModelSystem system, String server, Properties feedbackProperties) {
		int idApplication = 0;
		switch(system){
		case Senercon:
		case SenerconFG:
		case SenerconFGcat:
			switch(server){
			case "develop": 
				idApplication = Integer.parseInt(feedbackProperties.getProperty("senercon_application_development")); break;
			case "production":
				idApplication = Integer.parseInt(feedbackProperties.getProperty("senercon_application_production")); break;
			}
			break;
		case Siemens:
		case SiemensFG:
		case SiemensFGcat:
			switch(server){
			case "develop": 
				idApplication = Integer.parseInt(feedbackProperties.getProperty("siemens_application_development")); break;
			case "production":
				idApplication = Integer.parseInt(feedbackProperties.getProperty("siemens_application_production")); break;
			}
			break;		
		case Atos:
		case AtosFG:
		case AtosFGcat:
			switch(server){
			case "develop": 
				idApplication = Integer.parseInt(feedbackProperties.getProperty("atos_application_development")); break;
			case "production":
				idApplication = Integer.parseInt(feedbackProperties.getProperty("atos_application_production")); break;
			}
			break;		
        }
		return idApplication;
	}
	
	public static long getIdConfiguration(ModelSystem system, String server, Properties feedbackProperties) {
		int idConfiguration = 0;
		switch(system){
		case Senercon:
		case SenerconFG:
		case SenerconFGcat:
			switch(server){
			case "develop": 
				idConfiguration = Integer.parseInt(feedbackProperties.getProperty("senercon_configuration_development")); break;
			case "production":
				idConfiguration = Integer.parseInt(feedbackProperties.getProperty("senercon_configuration_production")); break;
			}
			break;
		case Siemens:
		case SiemensFG:
		case SiemensFGcat:
			switch(server){
			case "develop": 
				idConfiguration = Integer.parseInt(feedbackProperties.getProperty("siemens_configuration_development")); break;
			case "production":
				idConfiguration = Integer.parseInt(feedbackProperties.getProperty("siemens_configuration_production")); break;
			}
			break;		
		case Atos:
		case AtosFG:
		case AtosFGcat:
			switch(server){
			case "develop": 
				idConfiguration = Integer.parseInt(feedbackProperties.getProperty("atos_configuration_development")); break;
			case "production":
				idConfiguration = Integer.parseInt(feedbackProperties.getProperty("atos_configuration_production")); break;
			}
			break;		
        }
		return idConfiguration;
	}
	
	public static JSONObject readJsonObject(String absoluteTargetPath, String targetModel) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(absoluteTargetPath + targetModel));
	    StringBuilder sb = new StringBuilder(); 
	    String line;
		try {
		    line = br.readLine();
		    
		    if(line != null){
			    while (line != null) {
			        sb.append(line);
			        line = br.readLine();
			    }
				return new JSONObject(sb.toString());
		    }
		    else{
		    	throw new Exception("Json file is empty!");
		    }
		} finally {
		    br.close();
		}
	}
	
	public static JSONArray readJsonArray(String absoluteTargetPath, String targetModel) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(absoluteTargetPath + targetModel));
	    StringBuilder sb = new StringBuilder(); 
	    String line;
		try {
		    line = br.readLine();
		    
		    if(line != null){
			    while (line != null) {
			        sb.append(line);
			        line = br.readLine();
			    }
				return new JSONArray(sb.toString());
		    }
		    else{
		    	throw new Exception("Json file is empty!");
		    }
		} finally {
		    br.close();
		}
	}
}
