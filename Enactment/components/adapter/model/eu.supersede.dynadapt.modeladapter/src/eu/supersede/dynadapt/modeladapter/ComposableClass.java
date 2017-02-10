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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.internal.impl.AssociationImpl;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.ElementImpl;
import org.eclipse.uml2.uml.internal.impl.GeneralizationImpl;

import eu.supersede.dynadapt.model.query.IModelQuery;

import org.eclipse.uml2.uml.Package;

class ComposableClass  extends ComposableImpl implements Composable{
	
	public ComposableClass(IModelQuery modelQuery, HashMap<Stereotype, List<Element>> baseJointpoints) {
		super(modelQuery, baseJointpoints);
	}

	@Override
	/**
	* Add to classBase all properties in classVariant (but not already existing in classVariant)
	* Add to classBase all operations in classVariant (but not already existing in classVariant)
	* In variant model (recursively):
		* Gel all elements connected to classVariant through associations|generalizations -> [link, linkedElements]
		* For each linkedElement
			* If linkedElement is a jointpoint element, continue
			* If linkedElement does not exist in base model 
				* Add linkedElement to base model
			* If link does not exist in base model
				* Add link to base model
			* Recursively go through linkedElement
	 */
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
		ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
		
		// Add to classBase all properties in classVariant (but not already existing in classVariant)
		addProperties (classVariant, classBase);
		
		// Add to classBase all operations in classVariant (but not already existing in classVariant)
		addOperations (classVariant, classBase);
		
		// Add elements connected to classVariant through relationships: associations|generalizations (include relationships themselves)
		addGeneralizations (classVariant, classBase);
	}
	
	private void addGeneralizations(Element fromElement, Element toElement) {
		// Gel all elements connected to classVariant through generalizations -> [relationship (r), elements(e)]
		Model model = toElement.getModel();
		
		for (Relationship r:fromElement.getRelationships()) {
			//Filter out associations management here. They will managed as properties for corresponding type
			if (!(r instanceof GeneralizationImpl)){
				continue;
			}
			for (Element e:r.getRelatedElements()) {
				//	Ignore fromClass
				if (e == fromElement){
					continue;
				}
				//	* If linkedElement does not exist in base model 
				//		* Add linkedElement to base model
				if (!ModelAdapterUtilities.elementMatchesInModel(model, (PackageableElement)e)){
					Element createdElement = addElementToModel(model, (PackageableElement)e);
				
					//	* If link does not exist in base model
					//		* Add link to base model
					// Add Generalization to toElement.
					createGeneralizationInClass((Generalization) r, createdElement);
				}
			}
		}	
	}

	private Element addElementToModel(Model model, PackageableElement elementToAdd) {
		//Locate container in model corresponding to element to copy
		Package pack = ModelAdapterUtilities.getPackageInModelMatchingElement (model, elementToAdd);
		//Add elementToAdd in container
		PackageableElement addedElement = ModelAdapterUtilities.createElement (elementToAdd, pack, baseJointpoints);
//		if (addedElement != null)
//			ModelAdapterUtilities.addElementInPackage(addedElement, pack);
		
		// Add elements connected to classVariant through relationships: generalizations (include relationships themselves)
		addGeneralizations (addedElement, elementToAdd);
		
		return addedElement;
	}
	

	private void createGeneralizationInClass(Generalization generalizationToAdd, Element inClass) {
		if (inClass instanceof ClassImpl){ //FIXME Generalized to Classes and Interfaces
			((Class)inClass).createGeneralization(
					(Classifier)ModelAdapterUtilities.resolveElementInModel(
							generalizationToAdd.getGeneral(), inClass.getNearestPackage(), baseJointpoints));
		}
	}

	// Add to classBase all operations in classVariant (but not already existing in classVariant)
	private void addOperations(ClassImpl fromClass, ClassImpl toClass) {
		for (Operation operation: fromClass.getOperations()){
			if (ModelAdapterUtilities.elementMatchesInList (operation, toClass.getOperations()))
				continue;
			Operation clonedOperation = ModelAdapterUtilities.createElement (operation, toClass, baseJointpoints);
//			if (clonedOperation != null)
//				toClass.getOperations().add(clonedOperation);
		}
	}

	// Add to classBase all properties in classVariant (but not already existing in classVariant)
	private void addProperties(ClassImpl fromClass, ClassImpl toClass) {
		for (Property property: fromClass.getAttributes()){
			if (ModelAdapterUtilities.elementMatchesInList (property, toClass.getAttributes()))
				continue;
			Property clonedProperty = ModelAdapterUtilities.createElement (property, toClass, baseJointpoints);
//			if (clonedProperty != null)
//				toClass.getAttributes().add(clonedProperty);
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