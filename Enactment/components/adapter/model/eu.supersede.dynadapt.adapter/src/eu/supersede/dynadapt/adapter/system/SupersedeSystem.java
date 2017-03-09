package eu.supersede.dynadapt.adapter.system;

import java.net.URI;
import java.net.URISyntaxException;

public enum SupersedeSystem {
	ATOS ("atos"), 
	ATOS_HSK ("atos_hsk"), 
	SIEMENS ("siemens"), 
	SENERCON ("senercon"), 
	MONITORING ("monitoring"), 
	FEEDBACK_GATHERING ("feedback_gathering"),
	HEALTH ("health");
	
	private URI uri;
	
	SupersedeSystem(String suri){
		try {
			uri = new URI (suri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public URI getURI (){
		return uri;
	}
	
	public static SupersedeSystem getByURI (String suri){
		switch (suri){
		case "atos":
			return ATOS;
		case "atos_hsk":
			return ATOS_HSK;
		case "siemens":
			return SIEMENS;
		case "senercon":
			return SENERCON;
		case "monitoring": 
			return MONITORING;
		case "feedback_gathering":
			return FEEDBACK_GATHERING;
		case "health":
			return HEALTH;
		default:
			return null;
		}
	}
	
	@Override
	public String toString(){
		return getURI().toString();
	}
	
}
