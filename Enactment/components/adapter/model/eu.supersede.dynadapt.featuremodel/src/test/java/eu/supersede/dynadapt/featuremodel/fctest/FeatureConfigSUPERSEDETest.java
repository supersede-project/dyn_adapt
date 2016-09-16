/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fctest;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureConfigSUPERSEDETest {
	
	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystemConfigDefault.yafc";
	
	IModelManager modelManager = null;
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager ();
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void testValidFeatureConfigSUPERSEDE(){
		FeatureConfigSUPERSEDE fc = new FeatureConfigSUPERSEDE(modelManager.loadFeatureConfiguration(featureConfigPath));

//		System.out.println("Model name: " + fc.getName());
//		
//		System.out.println("Model selections-------------");
//		Iterator<Selection> itselections = fc.getSelections().iterator();
//		while (itselections.hasNext()) {
//			System.out.println(itselections.next().getName());
//		}
	}
	
}
