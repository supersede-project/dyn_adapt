/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
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
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.dm.optimizer.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DMOptimizationConfiguration {
	private static final Logger log = LoggerFactory.getLogger(DMOptimizationConfiguration.class);
	public static Properties prop = new Properties();
	public static String propFileName = "optimizer.properties";
	static{
		//Read configuration from environment
		if (System.getProperty("supersede.optimizer.properties")!=null){
			propFileName = System.getProperty("supersede.optimizer.properties");
			System.out.println("Setting DM Optimization configuration to: " + propFileName);
		}else{
			System.out.println("Using default DM Optimization configuration: " + propFileName);
		}
		
		InputStream is = DMOptimizationConfiguration.class.getClassLoader().getResourceAsStream(propFileName);
		
		try {
			if (is != null){
				prop.load (is);
			}else{
				throw new RuntimeException("Property file '" + propFileName + "'not found in classpath");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 
	}
	
	public static String getProperty(String key){
		if (prop.containsKey(key)){
			return (String) prop.get (key);
		}else{
			throw new RuntimeException("Property '" + key + "' not found exception");
		}
	}
	
	public static void setProperty (String key, String value) throws URISyntaxException, IOException{
		prop.put(key, value);
		URL url = DMOptimizationConfiguration.class.getClassLoader().getResource(propFileName);
		File fileObject = new File(url.toURI());
		FileOutputStream out = new FileOutputStream(fileObject);
		prop.store(out, null);
	}
	
	public static AdaptationMode getAdaptationConfigurationMode(){
		Boolean automated = Boolean.valueOf(getProperty("enactment.automatic_processing"));
		if (automated) 
			return AdaptationMode.AUTOMATED;
		else 
			return AdaptationMode.SUPERVISED;
	}
	
	public static void setAdaptationConfigurationMode(AdaptationMode mode) throws URISyntaxException, IOException{
		Boolean automated = mode == AdaptationMode.AUTOMATED?true:false;
		setProperty("enactment.automatic_processing", automated.toString());
	}

}
