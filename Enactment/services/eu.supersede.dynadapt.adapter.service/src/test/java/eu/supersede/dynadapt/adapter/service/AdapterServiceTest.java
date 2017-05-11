package eu.supersede.dynadapt.adapter.service;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AdapterServiceTest {
	AdapterService service;
	
	@Before
	public void setup() throws Exception{
		service = new AdapterService();
	}
	
	@Test
	public void testAtosHSKUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationId = "SmartPlatformFC_HSK_HighLoad";
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSiemensUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String featureConfigurationId = "FeatureModel-S1c_dm_optimized";
			service.enactAdaptationDecisionActionsForFC(
					ModelSystem.Siemens.toString(), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
