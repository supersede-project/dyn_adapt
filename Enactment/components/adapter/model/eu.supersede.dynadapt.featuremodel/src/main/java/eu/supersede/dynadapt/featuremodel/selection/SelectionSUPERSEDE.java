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
package eu.supersede.dynadapt.featuremodel.selection;

import java.util.List;

import cz.zcu.yafmt.model.fc.AttributeValue;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;

public class SelectionSUPERSEDE implements ISelectionSUPERSEDE{

	private List<AttributeValue> attValue;
	private FeatureSUPERSEDE feature;

	public SelectionSUPERSEDE(List<AttributeValue> attValue, FeatureSUPERSEDE feature) {
		super();
		this.attValue = attValue;
		this.feature = feature;
	}

	public List<AttributeValue> getAttValue() {
		return attValue;
	}

	public void setAttValue(List<AttributeValue> attValue) {
		this.attValue = attValue;
	}
	
	public FeatureSUPERSEDE getFeature() {
		return feature;
	}

	public void setFeature(FeatureSUPERSEDE feature) {
		this.feature = feature;
	}
	
	
	
}
