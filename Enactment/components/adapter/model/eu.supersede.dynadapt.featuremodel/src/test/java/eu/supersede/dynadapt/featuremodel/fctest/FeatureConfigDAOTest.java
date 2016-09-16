/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fctest;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.Selection;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigSUPERSEDE;

public class FeatureConfigDAOTest {

	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystemConfigDefault.yafc";

	IFeatureConfigDAO configDAO = null;

	@Before
	public void setUp() throws Exception {
		configDAO = new FeatureConfigDAO();
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testValidFeatureModelDAOLoad() {
		IFeatureConfigSUPERSEDE fc = configDAO.loadFeatureConfig(featureConfigPath);

		 System.out.println("Model name: " + ((FeatureConfigSUPERSEDE)fc).getName());
		
		 System.out.println("Model selections-------------");
		 Iterator<Selection> itselections = ((FeatureConfigSUPERSEDE)fc).getSelections().iterator();
		 while (itselections.hasNext()) {
		 System.out.println(itselections.next().getName());
		 }
	}

}
