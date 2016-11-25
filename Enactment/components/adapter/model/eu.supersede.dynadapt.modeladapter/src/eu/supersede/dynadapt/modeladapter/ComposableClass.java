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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;

class ComposableClass extends ClassImpl implements Composable{
	
	@Override
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
		ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
		// For each relationship of the class
		for (Relationship r:classVariant.getRelationships()) {
			for (Element e:r.getRelatedElements()) {
				if (!((NamedElement) e).getName().equals(classBase.getName())) {
					classBase.getNearestPackage().getPackagedElements().add((PackageableElement) e);
				}
			}
			classBase.getNearestPackage().getPackagedElements().add((PackageableElement) r.eContainer());
		}
	}
	
	@Override
	public void applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement,
			Model usingVariantModel, Element jointpointVariantModelElement) {
		ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
		ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
		// For each relationship of the class in the variant
		for (Relationship r1:classVariant.getRelationships()) {
			// For each relationship of the class in the base model
			for (Relationship r2:classBase.getRelationships()) {
				// Check which relationships are present in the variant
				if (ModelAdapterUtilities.checkSameRelationship(r1, r2)) {
					// Retrieve the related object
					ClassImpl deleteClass = null;
					if (!r2.getRelatedElements().get(0).equals(classBase)) {
						deleteClass = (ClassImpl) r2.getRelatedElements().get(0);
					} else
						deleteClass = (ClassImpl) r2.getRelatedElements().get(1);
					// Delete it if present in variant
					if (ModelAdapterUtilities.modelContainsElement(deleteClass, usingVariantModel))
						deleteClass.destroy();
					break;
				}
			}
		}
		// Delete all instances of the class in the variant
		List<NamedElement> baseInstances = ModelAdapterUtilities.getInstances(classVariant, inBaseModel);
		for (NamedElement e : baseInstances) {
			if (ModelAdapterUtilities.modelContainsElement(e, usingVariantModel))
				e.destroy();
		}
	}
	
	/**
	 * Checks if the object a is an instance specification of the relationship r
	 * with parent instance baseInst
	 * 
	 * @param a
	 * @param r
	 * @param baseInst
	 * @return
	 */
	private boolean isAssociationInstance(EObject a, Relationship r, InstanceSpecification baseInst) {
		if (a.eClass().getName().equalsIgnoreCase("InstanceSpecification")) {
			EObject aa = (EObject) ((EObjectResolvingEList<?>) a.eGet(a.eClass().getEStructuralFeature("classifier")))
					.get(0);
			if (aa.eGet(aa.eClass().getEStructuralFeature("name")) != null
					&& (aa.eGet(aa.eClass().getEStructuralFeature("name"))
							.equals(r.eGet(r.eClass().getEStructuralFeature("name"))))) {
				InstanceSpecification instance = (InstanceSpecification) a;
				for (Slot s : instance.getSlots()) {
					if (((InstanceValue) s.getValues().get(0)).getInstance().getName().equals(baseInst.getName())) {
						return true;
					}
				}
			}
		}
		return false;
	}


	@Override
	public void applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub
	}
}