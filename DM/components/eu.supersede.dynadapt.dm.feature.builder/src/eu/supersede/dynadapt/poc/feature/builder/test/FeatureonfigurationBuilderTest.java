package eu.supersede.dynadapt.poc.feature.builder.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.FeatureModelUtility;
import eu.supersede.dynadapt.poc.feature.builder.IFeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.ModelManager;

public class FeatureonfigurationBuilderTest {
	FeatureModel fm;
	ModelManager mm;
	IFeatureConfigurationBuilder fcb;
	
	@Before
	public void setup(){
		String fmPath = "./features/FeedbackGathering.yafm";
		
		
		fcb = new FeatureConfigurationBuilder();
		mm = new ModelManager();
		fm = mm.loadFM(fmPath);
	}
	
	@Test
	public void buildFeatureConfigurationTest() throws IOException{
		List<String> selectedFeatureIds = 
				Arrays.asList("rating", "selectcategory", "sharewithallhelpdesk", "popup", "android");
		String fcPath = "./features/FeedbackGatheringConf.yafc";
		
		FeatureConfiguration fc = 
				new FeatureConfigurationBuilder().buildFeatureConfiguration(fm, selectedFeatureIds);
		
		mm.saveFC(fc, URI.createFileURI(fcPath));
	}
	
	@Test
	public void getFeatureByIdTest(){
		Feature feature = FeatureModelUtility.getFeatureById(fm, "sharewithallhelpdesk");
		Assert.assertNotNull(feature);
	}
	
	@Test
	public void getParentFeatureTest(){
		Feature feature = FeatureModelUtility.getFeatureById(fm, "sharewithallhelpdesk");
		Assert.assertNotNull(feature);
		Feature parentFeature = FeatureModelUtility.getParentFeature(feature);
		Assert.assertNotNull(parentFeature);
	}
}
