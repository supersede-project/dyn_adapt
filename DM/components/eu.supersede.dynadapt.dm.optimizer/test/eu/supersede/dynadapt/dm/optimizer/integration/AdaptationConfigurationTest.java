package eu.supersede.dynadapt.dm.optimizer.integration;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import eu.supersede.dynadapt.dm.optimizer.configuration.AdaptationMode;
import eu.supersede.dynadapt.dm.optimizer.configuration.DMOptimizationConfiguration;

public class AdaptationConfigurationTest {
	@Test
	public void testReadAdaptationConfigurationMode(){
		AdaptationMode mode = DMOptimizationConfiguration.getAdaptationConfigurationMode();
		Assert.assertNotNull (mode);
	}
	
	@Test
	public void testSetAdaptationConfigurationMode() throws URISyntaxException, IOException{
		DMOptimizationConfiguration.setAdaptationConfigurationMode(AdaptationMode.AUTOMATED);
		AdaptationMode mode = DMOptimizationConfiguration.getAdaptationConfigurationMode();
		Assert.assertEquals(mode, AdaptationMode.AUTOMATED);
	}
}
