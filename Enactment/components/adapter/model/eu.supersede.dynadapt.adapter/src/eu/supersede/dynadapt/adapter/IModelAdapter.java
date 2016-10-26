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
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.adapter;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

public interface IModelAdapter {
	
	public Model applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) throws Exception;
	
	public Model applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) throws Exception;
	
	public Model applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) throws Exception;
	
	public Model applyModifyValueComposition(Model inBaseModel, Slot jointpointBaseModelSlot, ValueSpecification newValue) throws Exception;

}
