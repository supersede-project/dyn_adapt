package eu.supersede.dynadapt.adapter.service;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AdapterServiceTest {
	AdapterService service;
	
	@Before
	public void setup() throws Exception{
		boolean demo = true;
		service = new AdapterService(demo);
	}
	
	@Test
	public void testAtosHSKUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
//			String featureConfigurationId = "SmartPlatformFC_HSK_SingleVM_HighLoad";
			String featureConfigurationId = null;
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtosHSKDualVMHighLowAdaptation() {
		try {			
			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_a","highloadconfigurationinvm2_a","lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_HighLowLoad";
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore @Test
	public void testBatchAtosHighHSKAdaptation() throws Exception{
		int numberRuns = 2;
		
		String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
//		String featureConfigurationId = "SmartPlatformFC_HSK_SingleVM_HighLoad";
		String featureConfigurationId = null;
		
		for (int i=0; i<numberRuns; i++){
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		}
		
		service.getAdapterKPIComputer().reportComputedKPITimeSeries();
		service.getEnactorKPIComputer().reportComputedKPITimeSeries();
	}
	
	@Ignore @Test
	public void testBatchSiemensAdaptation() throws Exception{
		int numberRuns = 2;
		
		String[] adaptationDecisionActionIds = new String[]{"c4"};
		String featureConfigurationId = "FeatureModel-S1c_dm_optimized";
		
		for (int i=0; i<numberRuns; i++){
			service.enactAdaptationDecisionActions(
					ModelSystem.Siemens.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		}
		
		service.getAdapterKPIComputer().reportComputedKPITimeSeries();
		service.getEnactorKPIComputer().reportComputedKPITimeSeries();
	}
	
	@Ignore @Test
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
