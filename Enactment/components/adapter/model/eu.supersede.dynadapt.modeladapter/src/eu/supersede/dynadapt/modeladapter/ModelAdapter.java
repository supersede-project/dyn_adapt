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

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.dynadapt.dsl.aspect.ActionOptionType;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.model.tagger.ModelTagger;

public class ModelAdapter implements IModelAdapter {	
	private final static Logger log = LogManager.getLogger(ModelAdapter.class);

	private ModelTagger mt = null;
	private IModelQuery modelQuery = null;
	
	public ModelAdapter(IModelManager modelManager) throws ViatraQueryException {
		mt = new ModelTagger(modelManager);
		modelQuery = new ModelQuery (modelManager);
	}

	@Override
	public Model applyCompositionDirective(ActionOptionType actionOptionType, Model inBaseModel,
			HashMap<Stereotype, List<Element>> elements, Stereotype adviceRole, Model usingVariantModel)
			throws Exception {
		
		Element variantElement = ModelAdapterUtilities.findElementByStereotype(usingVariantModel, adviceRole);
		// Notified if variantElement cannot be found in variant model. In this
		// case, adaptation cannot be applied
		if (variantElement == null) {
			System.err.println("Role " + adviceRole.getName() + " could not be found in variant model: "
					+ usingVariantModel.getName());
			return null;
		}
		
		Composable composable = ComposableFactory.create (variantElement, modelQuery, elements);

		for (Stereotype stereotype : elements.keySet()) {
			for (Element baseElement : elements.get(stereotype)) {
				//Apply composition only if baseElement and variantElement share the same jointpoint role
				if (ModelAdapterUtilities.elementHasRole (variantElement, stereotype)){
					if (actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("ADD")) != null)
						composable.applyAddComposition(inBaseModel, baseElement, usingVariantModel, variantElement);
					else if (actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("DELETE")) != null)
						composable.applyDeleteComposition(inBaseModel, baseElement, usingVariantModel, variantElement);
					else if (actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("REPLACE")) != null)
						composable.applyReplaceComposition(inBaseModel, baseElement, usingVariantModel, variantElement);
				}
			}
		}

		return inBaseModel;
	}

	@Override
	public Model applyModifyValueComposition(Model inBaseModel, Slot jointpointBaseModelSlot, String newValue) {

		StructuralFeature feat = jointpointBaseModelSlot.getDefiningFeature();
		for (Element e : jointpointBaseModelSlot.allOwnedElements()) {
			e.destroy();
		}

		if (feat.getType().getName().equals("Integer")) {
			LiteralInteger value = (LiteralInteger) jointpointBaseModelSlot.createValue("", feat.getType(),
					UMLPackage.eINSTANCE.getLiteralInteger());
			value.setValue(Integer.valueOf(newValue));
		} else if (feat.getType().getName().equals("Boolean")) {
			LiteralBoolean value = (LiteralBoolean) jointpointBaseModelSlot.createValue("", feat.getType(),
					UMLPackage.eINSTANCE.getLiteralBoolean());
			value.setValue(Boolean.valueOf(newValue));
		} else if (feat.getType().getName().equals("String")) {
			LiteralString value = (LiteralString) jointpointBaseModelSlot.createValue("", feat.getType(),
					UMLPackage.eINSTANCE.getLiteralString());
			value.setValue(newValue);
		} else if (feat.getType().getName().equals("Real")) {
			LiteralReal value = (LiteralReal) jointpointBaseModelSlot.createValue("", feat.getType(),
					UMLPackage.eINSTANCE.getLiteralReal());
			value.setValue(Double.valueOf(newValue));
		}

		return inBaseModel;
	}

	public Model applyUpdateCompositionDirective(Model inBaseModel, HashMap<Stereotype, List<Element>> elements,
			String newValue) {
		Model model = null;
		for (Stereotype stereotype : elements.keySet()) {
			for (Element element : elements.get(stereotype)) {
				Slot s = (Slot) element;
				model = applyModifyValueComposition(inBaseModel, s, newValue);
			}
		}
		return model;
	}

	private void stereotypeElement(Element e, Stereotype role) throws Exception {
		mt.tagModel(e, role.getProfile(), role);
		log.debug(e.getAppliedStereotypes());
	}
}

