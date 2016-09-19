/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fctest;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigDAO;

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
		FeatureConfiguration fc = configDAO.loadFeatureConfig(featureConfigPath);
	}

}
