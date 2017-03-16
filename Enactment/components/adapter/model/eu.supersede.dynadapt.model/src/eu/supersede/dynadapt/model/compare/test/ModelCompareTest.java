package eu.supersede.dynadapt.model.compare.test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Test;

import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.compare.DiffType;
import eu.supersede.dynadapt.model.compare.ModelCompare;
import eu.supersede.dynadapt.model.compare.ModelCompareImpl;

public class ModelCompareTest {
	@Test
	public void ModelComparisonTest () throws IOException{		
		// NOTE: Edit this absolute paths before testing	
		String originalModelPath = 
				"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/base/atos_smart_base_model.uml";
		String adaptedModelPath = 
			"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/adapted/atos_smart_adapted_model.uml";
		
		ModelManager mm = new ModelManager(true);
		Model adaptedModel = mm.loadUMLModel(adaptedModelPath);
		Model originalModel = mm.loadUMLModel(originalModelPath);
		ModelCompare mc = new ModelCompareImpl();
		Map<DiffType,Set<Element>> diffElements = mc.computeDifferencesBetweenModels(adaptedModel, originalModel);
		Assert.assertNotNull(diffElements);
		Assert.assertTrue(!diffElements.isEmpty());
	}
}
