/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/


package eu.supersede.dynadapt.featuremodel.fm;

import org.eclipse.emf.mwe.utils.StandaloneSetup;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureModelDAO implements IFeatureModelDAO {

	public FeatureModelDAO(){
		super();
	}
	
	@Override
	public FeatureModel loadFeatureModel(String featureModelPath) {
		new StandaloneSetup().setPlatformUri("../");
		return (new ModelManager()).loadFeatureModel(featureModelPath);
	}

}
