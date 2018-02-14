package eu.supersede.dynadapt.dm.integration;

import java.util.List;

import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.ActionOnFeature;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public interface DecisionHandler {
	public void handle(
			String fmURI, 
			String fcURI, 
			List<ActionOnFeature> features, 
			List<ActionOnAttribute> attributes,
			String alertAttribute,
			Double valueThreshold) throws Exception;
}
