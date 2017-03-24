package eu.supersede.dynadapt.adapter.service;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AdapterServiceTest {
	AdapterService service;
	
	@Before
	public void setup() throws Exception{
		service = new AdapterService();
	}
	
	@Test
	public void testAtosCMSUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"cms_optimal_configuration", "cms_standard_configuration"};
			String featureConfigurationId = null;
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
//			service.enactAdaptationDecisionAction(
//					ModelSystem.Atos.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtosHSKUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationId = null;
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
//			service.enactAdaptationDecisionAction(
//					ModelSystem.Atos.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
