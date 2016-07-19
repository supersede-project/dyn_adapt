package eu.supersede.dynadapt.model.query.test;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;


public class ModelQueryTest {
//	String modelPath = "file://home/yosu/Projects/Supersede/workspaces/workspace-adaptation/eu.supersede.dynadapt.model.query/models/atos_base_model.uml";
//	String patternModelPath = "file://home/yosu/Projects/Supersede/workspaces/workspace-adaptation/eu.supersede.dynadapt.model.query/models/atos_queries.vql";
	String modelPath = "./models/atos_base_model.uml";
	String patternModelPath = "./models/atos_queries.vql";
	String patternFQN = "eu.supersede.dynadapt.atos.queries.nodeArtifacts";
	IModelQuery modelQuery = null;
	ModelManager modelManager = null;
	
	@Before
	public void setUp() throws Exception{	
		modelManager = new ModelManager (modelPath);
		modelQuery = new ModelQuery (modelManager);
	}

	@After
	public void cleanUp(){
		if (modelQuery != null)
			((ModelQuery)modelQuery).disposeQueryEngine();
	}
	
	@Test
	public void modelQueryTest() throws ViatraQueryException {
		Assert.assertNotNull(modelManager);
		Assert.assertNotNull(modelQuery);
		
		Collection<? extends IPatternMatch> matches = modelQuery.query(patternFQN, patternModelPath);
		Assert.assertNotNull(matches);
		
		StringBuilder result = new StringBuilder();
		((ModelQuery)modelQuery).prettyPrintMatches(result, matches);
		System.out.println("Search matches for query " + patternFQN + " are: " + result);
		
		String[] parameters = new String[]{"node", "artifact"};
		Collection <Map<String, Object>>results = modelQuery.query(patternFQN, patternModelPath, Arrays.asList(parameters));
		Assert.assertNotNull(results);
		
	}

}
