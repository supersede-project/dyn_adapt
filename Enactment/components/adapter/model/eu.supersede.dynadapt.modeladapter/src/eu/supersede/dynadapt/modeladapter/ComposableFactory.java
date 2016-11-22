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
 * 	Quim Motger (UPC) - main development
 *  Yosu Gorroñogoitia (Atos) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/

package eu.supersede.dynadapt.modeladapter;

import org.eclipse.uml2.uml.Element;

import eu.supersede.dynadapt.model.query.IModelQuery;

class ComposableFactory {
	private final static String INSTANCE = "InstanceSpecificationImpl";
	private final static String CLASS = "ClassImpl";
	
	public static Composable create(Element element, IModelQuery modelQuery) {
		Composable composable = null;
		String type = element.getClass().getSimpleName();
		switch (type){
		case INSTANCE:
			composable = new ComposableInstanceSpecification(modelQuery);
			break;
		case CLASS:
			composable = new ComposableClass();
			break;
		}
		return composable;
	}
	
}