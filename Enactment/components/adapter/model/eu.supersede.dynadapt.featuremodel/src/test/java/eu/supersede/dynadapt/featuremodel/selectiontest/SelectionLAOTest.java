/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.selectiontest;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import cz.zcu.yafmt.model.fc.Selection;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.selection.ISelectionLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;

public class SelectionLAOTest {
	
	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystemConfigDefault.yafc";
	
	ISelectionLAO sLAO = null;
	
	@Mock
	SelectionSUPERSEDE sSUPERSEDE;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		sLAO = new SelectionLAO();
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void testCreateValidFeatureSUPERSEDE(){
		sLAO.getAttrValueMap(sSUPERSEDE);
	}
	
}
