/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fmtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelDAO;
import eu.supersede.dynadapt.featuremodel.fm.IFeatureModelDAO;

public class FeatureModelDAOTest {
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";
	
	IFeatureModelDAO modelDAO = null;
	
	@Before
	public void setUp() throws Exception{
		modelDAO = new FeatureModelDAO();
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void testValidFeatureModelDAOLoad(){
		FeatureModel fm = modelDAO.loadFeatureModel(featureModelPath); 
	}
}
