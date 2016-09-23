/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fctest;

import java.util.Iterator;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;

public class FeatureConfigLAOTest {

	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystemConfigDefault.yafc";

	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";

	IFeatureConfigLAO fcLAO = null;

	@Before
	public void setUp() throws Exception {
//		new StandaloneSetup().setPlatformUri("../");
		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testValidFeatureConfigSUPERSEDE() {
		FeatureConfigSUPERSEDE fc = fcLAO.getFeatureConfigSUPERSEDE(featureConfigPath, featureModelPath);

//		System.out.println("Model name: " + fc.getName());
//
//		System.out.println("Model selections-------------");
//		Iterator<SelectionSUPERSEDE> itselections = fc.getSelections().iterator();
//		SelectionLAO sLAO = new SelectionLAO();
//		while (itselections.hasNext()) {
//			System.out.println(itselections.next().getClass());
//		}
	}

}
