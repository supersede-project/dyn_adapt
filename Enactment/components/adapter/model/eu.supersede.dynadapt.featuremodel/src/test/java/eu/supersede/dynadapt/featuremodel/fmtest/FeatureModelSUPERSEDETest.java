/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fmtest;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelSUPERSEDE;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureModelSUPERSEDETest {
	
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";
	
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
	public void testValidFeatureModelSUPERSEDE(){
		FeatureModelSUPERSEDE fm = new FeatureModelSUPERSEDE(modelManager.loadFeatureModel(featureModelPath));
		
//		System.out.println("Model name: " + fm.getName());
//
//		System.out.println("Model features-------------");
//		Iterator<Feature> itfeatures = fm.getFeatures().iterator();
//		while (itfeatures.hasNext()) {
//			System.out.println(itfeatures.next().getName());
//		}
//
//		System.out.println("Model constraints-------------");
//		Iterator<Constraint> itconstraints = fm.getConstraints().iterator();
//		while (itconstraints.hasNext()) {
//			System.out.println(itconstraints.next());
//		}
	}
	
}
