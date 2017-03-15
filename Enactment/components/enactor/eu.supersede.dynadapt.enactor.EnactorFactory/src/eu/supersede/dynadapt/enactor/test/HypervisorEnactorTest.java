/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
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
package eu.supersede.dynadapt.enactor.test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.dynadapt.enactor.factory.EnactorFactory;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.integration.api.adaptation.types.ModelSystem;


public class HypervisorEnactorTest {	
	@Before
	public void doSetup() throws IOException{
	}
	
	
	@Test
	public void AtosEnactorInAtosHSKTest () throws Exception{		
		// NOTE: Edit this absolute paths before testing		
		String originalModelPath = 
				"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/base/atos_smart_base_model.uml";
		String adaptedModelPath = 
			"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/adapted/atos_smart_adapted_model.uml";
		
		ModelManager mm = new ModelManager(true);
		Model originalModel = mm.loadUMLModel(originalModelPath);
		Model adaptedModel = mm.loadUMLModel(adaptedModelPath);
		IEnactor enactor = EnactorFactory.getEnactorForSystem(ModelSystem.Atos);
		enactor.enactAdaptedModel(adaptedModel, originalModel);
	}
	

}
