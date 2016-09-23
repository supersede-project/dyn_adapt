/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fmtest;

import java.util.Iterator;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelDAO;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelLAO;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fm.IFeatureModelLAO;

public class FeatureModelLAOTest {
	
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";
	
	IFeatureModelLAO fmLAO = null;
	
	
	@Before
	public void setUp() throws Exception{
//		new StandaloneSetup().setPlatformUri("../");
		fmLAO = new FeatureModelLAO(new FeatureModelDAO());
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void testValidFeatureModelSUPERSEDE(){
		FeatureModelSUPERSEDE fm = fmLAO.getFeatureModelSUPERSEDE(featureModelPath);
		
//		System.out.println("Model name: " + fm.getName());
//
//		System.out.println("Model features-------------");
//		Iterator<FeatureSUPERSEDE> itfeatures = fm.getFeatures().iterator();
//		while (itfeatures.hasNext()) {
//			FeatureSUPERSEDE f = itfeatures.next();
//			System.out.println("-------------------------------------------------");
//			System.out.println("Feature name: " + f.getId());
//			System.out.println("Feature attributes: " + f.getAttributes());
//			System.out.println("Feature parent: " + f.getParent());
//			System.out.println("Feature children: " + f.getChildren());
//			System.out.println("Feature siblings: " + f.getSiblings());
//			System.out.println("Feature constraints: " + f.getConstraints());
//		}
//
//		System.out.println("Model constraints-------------");
//		Iterator<Constraint> itconstraints = fm.getConstraints().iterator();
//		while (itconstraints.hasNext()) {
//			System.out.println(itconstraints.next());
//		}
	}
	
}
