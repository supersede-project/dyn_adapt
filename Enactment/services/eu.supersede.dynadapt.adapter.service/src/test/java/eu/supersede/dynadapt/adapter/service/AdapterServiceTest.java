package eu.supersede.dynadapt.adapter.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

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
			uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc", ModelSystem.Atos_HSK);			
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
			uploadLatestComputedFC("SmartPlatformFC_HSK_DualVM_HighLowLoad.yafc", ModelSystem.Atos_HSK);			
			String featureConfigurationId = null;
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
		uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc", ModelSystem.Atos_HSK);
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
		uploadLatestComputedFC("FeatureModel-S1c_dm_optimized.yafc", ModelSystem.Siemens);
		String featureConfigurationId = null;
		
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
			uploadLatestComputedFC("FeatureModel-S1c_dm_optimized.yafc", ModelSystem.Siemens);
			String featureConfigurationId = null;
			service.enactAdaptationDecisionActionsForFC(
					ModelSystem.Siemens.toString(), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void uploadLatestComputedFC(String fcName, ModelSystem system) throws IOException, Exception {
		//Load model and store it in ModelRepository as the latest ComputedModel for Atos_HSK system
		
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir, service.repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager (service.mm, service.mr);
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", fcName), 
				"Yosu", system, Status.Computed, "features/configurations", 
				FeatureConfiguration.class, ModelType.FeatureConfiguration, 
				eu.supersede.integration.api.adaptation.types.FeatureConfiguration.class);
	}
	
}
