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
package eu.supersede.dynadapt.poc.feature.builder;

import java.util.List;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;

public interface IFeatureConfigurationBuilder {

	/**
	 * Creates a configuration for given feature model, by selecting the features given by Ids
	 * @param fm the feature model for which the  configuration is created
	 * @param selectedFeatureIds the list of feature ids to be selected (e.g. enabled)
	 * @return
	 */
	FeatureConfiguration buildFeatureConfiguration(FeatureModel fm, List<String> selectedFeatureIds);

}