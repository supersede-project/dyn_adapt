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
package eu.supersede.dynadapt.model.test;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;


public class ModelManagerTest {
	
//	String modelPath = "./models/atos_base_model.uml";
//	String patternModelPath = "./models/atos_queries.vql";
	
//	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.model/models/atos_base_model.uml";
	String umlModelPath = "./models/atos_base_model.uml";
	String profilePath = "platform:/resource/eu.supersede.dynadapt.model/models/adm.profile.uml";
	String patternModelPath = "platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql";
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.model/models/AtosUCFeatureModel.yafm";
	String featureConfigurationPath = "platform:/resource/eu.supersede.dynadapt.model/models/AtosDefaultFeatureConfiguration.yafc";
	
	IModelManager modelManager = null;
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager (umlModelPath);
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void modelLoadTest() throws ViatraQueryException {
		Assert.assertNotNull(modelManager);
		
		Model umlModel = modelManager.loadUMLModel(umlModelPath);
		Profile profile = modelManager.loadProfile(profilePath);
		PatternModel patternModel = modelManager.loadPatternModel(patternModelPath);
		FeatureModel featureModel = modelManager.loadFeatureModel(featureModelPath);
		FeatureConfiguration featureConfiguration = modelManager.loadFeatureConfiguration(featureConfigurationPath);
		
		Assert.assertNotNull(umlModel);
		Assert.assertNotNull(profile);
		Assert.assertNotNull(patternModel);
		Assert.assertNotNull(featureModel);
		Assert.assertNotNull(featureConfiguration);
	}
	
	@Test
	public void loadModelFromURLTest () throws IOException {
		//Load and download model from url
		String surl = "https://raw.githubusercontent.com/supersede-project/dyn_adapt/master/Scenarios/Atos/eu.supersede.dynadapt.usecases.atos/models/base/atos_base_model.uml";
		URL url = new URL (surl);
		InputStream in = url.openStream();
		Assert.assertNotNull(in);
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Path file = Paths.get(temp.toString(), "model.uml");
		Files.copy(in, file, StandardCopyOption.REPLACE_EXISTING);
		in.close();
		
		//Reading resource form model
		URI uri = URI.createFileURI(file.toString());
		Model model = modelManager.loadUMLModel(uri.toFileString());
		Assert.assertNotNull(model);
	}
	
	@Test
	public void loadModelFromURL2Test () throws IOException {
		//Load and download model from url
		String surl = "https://raw.githubusercontent.com/supersede-project/dyn_adapt/master/Scenarios/Atos/eu.supersede.dynadapt.usecases.atos/models/base/atos_base_model.uml";
		Model model = modelManager.loadUMLModel(surl);
		Assert.assertNotNull(model);
	}
}
