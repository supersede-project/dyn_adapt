package eu.supersede.dynadapt.adapter.service;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;

public class AdapterServiceTest {
	AdapterService service;
	
	@Before
	public void setup() throws Exception{
		service = new AdapterService();
	}
	
	@Test
	public void testAtosUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"cms_optimal_configuration", "cms_standard_configuration"};
			String featureConfigurationId = null;
			service.enactAdaptationDecisionActions(
					SupersedeSystem.ATOS.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
			service.enactAdaptationDecisionAction(
					SupersedeSystem.ATOS.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
