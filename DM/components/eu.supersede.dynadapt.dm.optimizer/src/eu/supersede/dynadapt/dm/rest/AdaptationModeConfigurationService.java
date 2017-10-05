package eu.supersede.dynadapt.dm.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;
import eu.supersede.dynadapt.dm.optimizer.configuration.AdaptationMode;
import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

@RestController
@RequestMapping(value="/adaptation")
public class AdaptationModeConfigurationService {
	ModuleLoader ml;
	
	public AdaptationModeConfigurationService () throws Exception {
		this.ml = new ModuleLoader();
	}
	
	@RequestMapping(value="/configuration",  method=RequestMethod.GET)
	public AdaptationMode getAdaptationMode () throws Exception {
		return DMOptimizationConfiguration.getAdaptationConfigurationMode();
	}
	
	@RequestMapping(value="/configuration",  method=RequestMethod.PUT)
	public void setAdaptationMode (@RequestBody AdaptationMode mode) throws Exception {
		DMOptimizationConfiguration.setAdaptationConfigurationMode(mode);
	}
}
