package eu.supersede.feedbackgathering.reconfiguration.test;

import org.junit.Test;

import eu.supersede.dynadapt.model.ModelManager;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeedbackGatheringConfigurationProfile;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeedbackGatheringUpdateAttributes;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class FeedbackGatheringReconfigurationTest {

	//private ModelRepository mr;
	private ModelManager mm;
	
	/*@Test
	public void testConfigure() throws IOException {
		// NOTE: Edit this absolute paths before testing
		String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigV5_optimized.yafc";
		//String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigCategory_reconfig.yafc";
		String absolutetargetFolderPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/json/";
		FeatureConfiguration2Json.configurationProfileFC2JsonInFolder(absoluteModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void testUpdate() throws IOException {
		// NOTE: Edit this absolute paths before testing
		//String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigV5_optimized.yafc";
		String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigCategory_reconfig.yafc";
		String absolutetargetFolderPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/json/";
		FeatureConfiguration2Json.updateFeatureAttributesFC2JsonInFolder(absoluteModelPath, absolutetargetFolderPath);
	}*/
	
	/*@Test
	public void testFGEnactorUpdate() throws Exception {
		
		mm = new ModelManager();
		
		FeedbackGatheringUpdateAttributes FGenactor = new FeedbackGatheringUpdateAttributes(ModelSystem.SenerconFGcat);
		
		String fcURI = "/workspaceSTS/dyn_adapt/Enactment/components/enactor/eu.supersede.feedbackgathering.reconfiguration.enactor/model/FeedbackGatheringConfigCategory.yafc";
		FeatureConfiguration featureConfig = mm.loadFeatureConfiguration(fcURI);

		FGenactor.enactFeatureConfiguration(featureConfig, true);
	}*/
	
	@Test
	public void testFGEnactorProfile() throws Exception {
		mm = new ModelManager();
				
		FeedbackGatheringConfigurationProfile FGenactor = new FeedbackGatheringConfigurationProfile(ModelSystem.SenerconFG);
		
		String fcURI = "/workspaceSTS/dyn_adapt/Enactment/components/enactor/eu.supersede.feedbackgathering.reconfiguration.enactor/model/FeedbackGatheringConfigV6_optimized.yafc";
		FeatureConfiguration featureConfig = mm.loadFeatureConfiguration(fcURI);

		FGenactor.enactFeatureConfiguration(featureConfig, true);
	}
}