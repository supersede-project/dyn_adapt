package eu.supersede.dynadapt.adapter.system;

import java.net.URI;
import java.net.URISyntaxException;

public enum SupersedeSystem {
	ATOS ("atos"), 
	SIEMENS ("siemens"), 
	SENERCON ("senercon"), 
	MONITORING ("monitoring"), 
	FEEDBACK_GATHERING ("feedback_gathering");
	
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
		case "siemens":
			return SIEMENS;
		case "senercon":
			return SENERCON;
		case "monitoring": 
			return MONITORING;
		case "feedback_gathering":
			return FEEDBACK_GATHERING;
		default:
			return null;
		}
	}
	
	@Override
	public String toString(){
		return getURI().toString();
	}
	
}
