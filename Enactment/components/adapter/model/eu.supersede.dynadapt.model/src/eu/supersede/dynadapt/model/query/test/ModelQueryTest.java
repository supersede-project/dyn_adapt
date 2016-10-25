/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.model.query.test;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.model.IModelManager;
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
	IModelManager modelManager = null;
	
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
	
	@Test
	public void loadPatternModelTest() throws ViatraQueryException {
		Assert.assertNotNull(modelManager);
		Assert.assertNotNull(modelQuery);
		
		PatternModel patternModel = modelQuery.loadPatternModel(URI.createURI(patternModelPath));
		
		Assert.assertNotNull(patternModel);
		Assert.assertTrue(patternModel.getPackageName().equals("eu.supersede.dynadapt.atos.queries"));
	}

}
