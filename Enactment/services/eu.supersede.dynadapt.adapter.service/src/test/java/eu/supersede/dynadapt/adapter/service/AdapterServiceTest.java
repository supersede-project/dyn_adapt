package eu.supersede.dynadapt.adapter.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public class AdapterServiceTest {
	private static AdapterService service;
	private static AdaptationDashboardProxy <Object, Object> adaptationProxy;
	private static ModelRepositoryProxy<?, ?> modelRepositoryProxy;
	
	@BeforeClass
	public static void setup() throws Exception{
		boolean demo = true;
		service = new AdapterService(demo);
		adaptationProxy = new AdaptationDashboardProxy<Object, Object>("adaptation", "adaptation", "atos");
		modelRepositoryProxy = new ModelRepositoryProxy<Object, Object>();
	}
	
	@Test
	public void testEnactAdaptationDecisionActions() throws Exception {
		ModelSystem system = ModelSystem.Atos_HSK;
		
		//Upload new enacted FC
		String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		
//		//Create adaptation in dashboard
		Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
		adaptation = adaptationProxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		List<String> adaptationDecisionActionIds = new ArrayList<>();
		adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
		adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
		service.enactAdaptationDecisionActions(system.toString(), adaptationDecisionActionIds, featureConfigurationId);
	}
	
	@Ignore @Test
	public void testAtosHSKUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationId = "661";
			service.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore @Test
	public void testAtosHSKDualVMAdaptation() {
		try {			
			//High-Low
			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_a","highloadconfigurationinvm2_a","lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_HighLowLoad";
			
			//Medium-Low
//			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_a","mediumloadconfigurationinvm2_a","lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
//			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_MediumLowLoad";
			
			//Low-Low
//			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
//			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_LowLowLoad";
			
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
		String featureConfigurationId = "SmartPlatformFC_HSK_SingleVM_HighLoad";
		
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
	
	private String uploadLatestComputedFC(String fcName) throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		
		ModelMetadata metadata = createFeatureConfigurationModelMetadata(fcName);
		IModel[] result = modelRepositoryProxy.createModelInstances(ModelType.FeatureConfiguration, metadata);
		Assert.notNull(result);
		Assert.notEmpty(result);
		FeatureConfiguration am = (FeatureConfiguration) result[0];
		
		return am.getId();
	}
	
	private ModelMetadata createFeatureConfigurationModelMetadata(String fcName) throws IOException {
		ModelMetadata metadata = new ModelMetadata();
		
		metadata.setSender("DM Optimizer");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = createFeatureConfigurationMetadataInstances(fcName);
		metadata.setModelInstances(modelInstances);
		
		return metadata;
	}

	private List<IModel> createFeatureConfigurationMetadataInstances(String fcName) throws IOException {
		List<IModel> modelInstances = new ArrayList<>();
		FeatureConfiguration am = new FeatureConfiguration();
		modelInstances.add(am);
		
		am.setName(fcName);
		am.setAuthorId("DM Optimizer");
		am.setCreationDate(Calendar.getInstance().getTime());
		am.setLastModificationDate(Calendar.getInstance().getTime());
		am.setFileExtension(ModelType.FeatureConfiguration.getExtension());
		am.setSystemId(ModelSystem.Atos_HSK);
		am.setStatus(Status.Computed.toString());
		am.setRelativePath("features/configurations");
		am.setDependencies(new ArrayList<TypedModelId>());
		am.setModelContent(getFeatureConfigurationContent(fcName));
		
		return modelInstances;
	}

	private String getFeatureConfigurationContent(String fcName) throws IOException {
		File f = new File("");
		List<String> lines = Files.readAllLines(
			Paths.get(f.getAbsolutePath() + 
				"/repository/features/configurations/" + fcName), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		return content;
	}
	
	private Adaptation createAdaptation(String fc_id, String name) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
		adaptation.setModel_system(ModelSystem.Atos);
		adaptation.setName(name);
		adaptation.setRank(1.0);
		adaptation.getActions().add(createActionA());
		adaptation.getActions().add(createActionB());
		return adaptation;
	}
	
	private Action createActionA() {
		Action action = new Action ();
		action.setAction_id("highloadconfigurationinvm2_a");
		action.setDescription("High load configuration for HSK service");
		action.setName("VM2_A_HighConfiguration");
		action.setEnabled(true);
		
		return action;
	}
	
	private Action createActionB() {
		Action action = new Action ();
		action.setAction_id("lowloadconfigurationinvm2_a");
		action.setDescription("Low load configuration for HSK service");
		action.setName("VM2_A_LowConfiguration");
		action.setEnabled(true);
		
		return action;
	}
	
}
