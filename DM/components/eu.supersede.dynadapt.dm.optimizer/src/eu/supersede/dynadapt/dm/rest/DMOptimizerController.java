package eu.supersede.dynadapt.dm.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

@RestController
public class DMOptimizerController {
	ModuleLoader ml = new ModuleLoader();
	
	@RequestMapping("/optimize")
	public FeatureConfiguration optimize (
			@RequestParam(value="system", defaultValue="") String system,
			@RequestParam(value="featureModelURI", defaultValue="") String fmURI, 
			@RequestParam(value="featureConfigurationURI", defaultValue="") String fcURI,
			@RequestParam(value="alertAttribute", defaultValue="response_time") String alertAttribute,
			@RequestParam(value="alertThresholdValue", defaultValue="30") String alertThresholdValue,
			@RequestParam(value="multiObjective", defaultValue="false") boolean multiObjective) throws Exception {

		return ml.processOptimization(ModelSystem.valueOf(system), fmURI, fcURI, alertAttribute, Double.valueOf(alertThresholdValue));
	}
}
