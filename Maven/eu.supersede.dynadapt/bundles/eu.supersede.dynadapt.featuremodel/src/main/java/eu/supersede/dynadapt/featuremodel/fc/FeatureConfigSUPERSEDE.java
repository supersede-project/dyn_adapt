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

package eu.supersede.dynadapt.featuremodel.fc;

import java.util.List;

import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;

public class FeatureConfigSUPERSEDE implements IFeatureConfigSUPERSEDE {

	private String name;
	private List<SelectionSUPERSEDE> selections;

	/**
	 * Creates an instance of FeatureConfigSUPERSEDE 
	 * 
	 * @param name, selections
	 */
	public FeatureConfigSUPERSEDE(String name, List<SelectionSUPERSEDE> selections) {
		super();
		this.name = name;
		this.selections = selections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SelectionSUPERSEDE> getSelections() {
		return selections;
	}

	public void setSelections(List<SelectionSUPERSEDE> selections) {
		this.selections = selections;
	}

	
}
