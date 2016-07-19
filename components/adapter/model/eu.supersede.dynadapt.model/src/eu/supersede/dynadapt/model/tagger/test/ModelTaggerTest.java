package eu.supersede.dynadapt.model.tagger.test;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.model.tagger.IModelTagger;
import eu.supersede.dynadapt.model.tagger.ModelTagger;


public class ModelTaggerTest {
	String modelPath = "../models/atos_base_model.uml";
	String profilePath = "../models/adm.profile.uml";
	String patternModelPath = "../models/atos_queries.vql";
	String patternFQN = "eu.supersede.dynadapt.atos.queries.nodeArtifacts";
	private static final String OUTPUT_FILE_SUFFIX = "_tagged.uml";
	
	IModelQuery modelQuery = null;
	IModelTagger modelTagger = null;
	ModelManager modelManager = null;
	
	@Before
	public void setUp() throws Exception{	
		modelManager = new ModelManager (modelPath);
		modelQuery = new ModelQuery (modelManager);
		modelTagger = new ModelTagger(modelManager);
	}

	@After
	public void cleanUp(){
		if (modelQuery != null)
			((ModelQuery)modelQuery).disposeQueryEngine();
	}
	
	@Test
	public void modelQueryTest() throws Exception {
		Assert.assertNotNull(modelManager);
		Assert.assertNotNull(modelQuery);
		Assert.assertNotNull(modelTagger);
		
		String[] parameters = new String[]{"artifact"};
		Collection <Map<String, Object>>matches = modelQuery.query(patternFQN, patternModelPath, Arrays.asList(parameters));
		Assert.assertNotNull(matches);
		
		//Selecting first artifact match of nodeArtifacts search
		NamedElement element = (NamedElement) (matches.isEmpty()?null:matches.iterator().next().get(parameters[0]));
		Assert.assertNotNull(element);
				
		IModelTagger tagger = new ModelTagger(modelManager);
		tagger.tagModel(element, profilePath, "Joinpoint");
		
		modelManager.saveTargetModel(OUTPUT_FILE_SUFFIX);
	}

}
