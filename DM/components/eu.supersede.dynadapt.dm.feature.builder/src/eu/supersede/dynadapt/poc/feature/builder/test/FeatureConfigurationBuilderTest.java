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
package eu.supersede.dynadapt.poc.feature.builder.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.poc.feature.builder.FeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.FeatureModelUtility;
import eu.supersede.dynadapt.poc.feature.builder.IFeatureConfigurationBuilder;
import eu.supersede.dynadapt.poc.feature.builder.ModelManager;

public class FeatureConfigurationBuilderTest {
	FeatureModel fm;
	ModelManager mm;
	IFeatureConfigurationBuilder fcb;
	
	@Before
	public void setup(){
		String fmPath = "./features/FeedbackGathering.yafm";
		
		
		fcb = new FeatureConfigurationBuilder();
		mm = new ModelManager();
		fm = mm.loadFM(fmPath);
	}
	
	@Test
	public void buildFeatureConfigurationTest() throws IOException{
		List<String> selectedFeatureIds = 
				Arrays.asList("rating", "selectcategory", "sharewithallhelpdesk", "popup", "android");
		String fcPath = "./features/FeedbackGatheringConf.yafc";
		
		FeatureConfiguration fc = 
				new FeatureConfigurationBuilder().buildFeatureConfiguration(fm, selectedFeatureIds);
		
		mm.saveFC(fc, URI.createFileURI(fcPath));
	}
	
	@Test
	public void getFeatureByIdTest(){
		Feature feature = FeatureModelUtility.getFeatureById(fm, "sharewithallhelpdesk");
		Assert.assertNotNull(feature);
	}
	
	@Test
	public void getFeatureByNameTest(){
		Feature feature = FeatureModelUtility.getFeatureByName(fm, "ShareWithAll");
		Assert.assertNotNull(feature);
	}
	
	@Test
	public void getParentFeatureTest(){
		Feature feature = FeatureModelUtility.getFeatureById(fm, "sharewithallhelpdesk");
		Assert.assertNotNull(feature);
		Feature parentFeature = FeatureModelUtility.getParentFeature(feature);
		Assert.assertNotNull(parentFeature);
	}
}
