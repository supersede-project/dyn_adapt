package eu.supersede.dynadapt.adapter.system;

import java.net.URI;
import java.net.URISyntaxException;

public enum SupersedeSystem {
	ATOS ("http://www.supersede.eu/atos"), 
	SIEMENS ("http://www.supersede.eu/siemens"), 
	SENERCON ("http://www.supersede.eu/senercon"), 
	MONITORING ("http://www.supersede.eu/monitoring"), 
	FEEDBACK_GATHERING ("http://www.supersede.eu/feedback_gathering");
	
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
		case "http://www.supersede.eu/atos":
			return ATOS;
		case "http://www.supersede.eu/siemens":
			return SIEMENS;
		case "http://www.supersede.eu/senercon":
			return SENERCON;
		case "http://www.supersede.eu/monitoring": 
			return MONITORING;
		case "http://www.supersede.eu/feedback_gathering":
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
