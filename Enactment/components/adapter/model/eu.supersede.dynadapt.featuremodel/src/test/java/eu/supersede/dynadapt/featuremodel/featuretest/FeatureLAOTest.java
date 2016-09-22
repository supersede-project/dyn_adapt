/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.featuretest;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import eu.supersede.dynadapt.featuremodel.feature.FeatureLAO;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.feature.IFeatureLAO;

public class FeatureLAOTest {

	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";

	IFeatureLAO fLAO = null;

	@Mock
	FeatureSUPERSEDE parent;
	FeatureSUPERSEDE child;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		fLAO = new FeatureLAO();
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testCreateValidFeatureSUPERSEDE() {
		fLAO.addChild(parent, child);
		fLAO.setFeatureSiblings(parent);
	}

}
