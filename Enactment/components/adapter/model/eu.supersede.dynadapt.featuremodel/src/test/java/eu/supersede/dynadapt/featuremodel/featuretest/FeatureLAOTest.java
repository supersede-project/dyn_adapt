/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.featuretest;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fm.Feature;
import eu.supersede.dynadapt.featuremodel.feature.FeatureLAO;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.feature.IFeatureLAO;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelDAO;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelLAO;

public class FeatureLAOTest {
	
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";
	
	Feature feature = null;
	IFeatureLAO fLAO = null;
	
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		/*Use Root feature as an example feature*/
		feature = ((new FeatureModelLAO(new FeatureModelDAO())).getFeatureModelSUPERSEDE(featureModelPath)).getFeatures().get(0);
		fLAO = new FeatureLAO();
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void testCreateValidFeatureSUPERSEDE(){
		FeatureSUPERSEDE f = fLAO.createFeatureSUPERSEDE(feature);
//		System.out.println("Feature name: " + f.getName());
//		System.out.println("Feature attributes: " + f.getAttributes());
//		System.out.println("Feature parent: " + f.getParent());
//		System.out.println("Feature children: " + f.getChildren());
//		System.out.println("Feature siblings: " + f.getSiblings());
//		System.out.println("Feature constraints: " + f.getConstraints());

	}
	
}
