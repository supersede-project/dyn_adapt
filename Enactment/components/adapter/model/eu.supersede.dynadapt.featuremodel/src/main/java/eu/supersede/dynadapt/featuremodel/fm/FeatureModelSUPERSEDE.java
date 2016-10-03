/*******************************************************************************
 * Copyright (c) 2016 UPC
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

import java.util.List;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;

public class FeatureModelSUPERSEDE implements IFeatureModelSUPERSEDE {

	private String name;
	private List<FeatureSUPERSEDE> features;
	private List<Constraint> constraints;

	/**
	 * Creates an instance of FeatureModelSUPERSEDE
	 * 
	 * @param name, features, constraints
	 */
	public FeatureModelSUPERSEDE(String name, List<FeatureSUPERSEDE> features, List<Constraint> constraints) {
		super();
		this.name = name;
		this.features = features;
		this.constraints = constraints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FeatureSUPERSEDE> getFeatures() {
		return features;
	}

	public void setFeatures(List<FeatureSUPERSEDE> features) {
		this.features = features;
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
	
	

}
