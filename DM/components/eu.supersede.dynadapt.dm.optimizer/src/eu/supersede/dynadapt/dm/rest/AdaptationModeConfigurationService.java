package eu.supersede.dynadapt.dm.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;
import eu.supersede.dynadapt.dm.optimizer.configuration.AdaptationMode;
import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;

@RestController
@RequestMapping(value="/adaptation")
public class AdaptationModeConfigurationService {
	ModuleLoader ml;
	private static final Logger log = LoggerFactory.getLogger(AdaptationModeConfigurationService.class);
	
	public AdaptationModeConfigurationService () throws Exception {
		this.ml = new ModuleLoader();
	}
	
	@RequestMapping(value="/configuration",  method=RequestMethod.GET)
	public AdaptationMode getAdaptationMode () throws Exception {
		log.debug("getAdaptationMode requested");
		return DMOptimizationConfiguration.getAdaptationConfigurationMode();
	}
	
	@RequestMapping(value="/configuration",  method=RequestMethod.PUT)
	public void setAdaptationMode (@RequestBody AdaptationMode mode) throws Exception {
		log.debug("setAdaptationMode with mode " + mode + " requested");
		DMOptimizationConfiguration.setAdaptationConfigurationMode(mode);
	}
}
