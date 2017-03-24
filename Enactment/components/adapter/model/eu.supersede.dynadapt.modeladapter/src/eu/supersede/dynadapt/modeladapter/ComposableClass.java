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

import java.util.ArrayList;
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
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.internal.impl.AssociationImpl;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.ElementImpl;
import org.eclipse.uml2.uml.internal.impl.GeneralizationImpl;
import org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl;

import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;

import org.eclipse.uml2.uml.Package;

class ComposableClass extends ComposableImpl implements Composable {

	public ComposableClass(IModelQuery modelQuery, HashMap<Stereotype, List<Element>> baseJointpoints) {
		super(modelQuery, baseJointpoints);
	}

	@Override
	/**
	 * Add to classBase all properties in classVariant (but not already existing
	 * in classVariant) Add to classBase all operations in classVariant (but not
	 * already existing in classVariant) In variant model (recursively): Gel all
	 * elements connected to classVariant through associations|generalizations
	 * -> [link, linkedElements] For each linkedElement If linkedElement is a
	 * jointpoint element, continue If linkedElement does not exist in base
	 * model Add linkedElement to base model If link does not exist in base
	 * model Add link to base model Recursively go through linkedElement
	 */
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
		ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;

		// Add to classBase all properties in classVariant (but not already
		// existing in classVariant)
		addProperties(classVariant, classBase, inBaseModel);

		// Add to classBase all operations in classVariant (but not already
		// existing in classVariant)
		addOperations(classVariant, classBase, inBaseModel);

		// Add elements connected to classVariant through relationships:
		// associations|generalizations (include relationships themselves)
		addGeneralizations(classVariant, classBase);
	}

	private void addGeneralizations(Element fromElement, Element toElement) {
		// Gel all elements connected to classVariant through generalizations ->
		// [relationship (r), elements(e)]
		Model model = toElement.getModel();

		for (Relationship r : fromElement.getRelationships()) {
			// Filter out associations management here. They will managed as
			// properties for corresponding type
			if (!(r instanceof GeneralizationImpl)) {
				continue;
			}
			for (Element e : r.getRelatedElements()) {
				// Ignore fromClass
				if (e == fromElement) {
					continue;
				}
				// * If linkedElement does not exist in base model
				// * Add linkedElement to base model
				if (!ModelAdapterUtilities.elementMatchesInModel(model, (PackageableElement) e)) {
					Element createdElement = addElementToModel(model, (PackageableElement) e);

					// * If link does not exist in base model
					// * Add link to base model
					// Add Generalization to toElement.
					createGeneralizationInClass((Generalization) r, createdElement);
				}
			}
		}
	}

	private Element addElementToModel(Model model, PackageableElement elementToAdd) {
		// Locate container in model corresponding to element to copy
		Package pack = ModelAdapterUtilities.getPackageInModelMatchingElement(model, elementToAdd);
		// Add elementToAdd in container
		PackageableElement addedElement = ModelAdapterUtilities.createElement(elementToAdd, pack, baseJointpoints, model);

		// Add elements connected to classVariant through relationships:
		// generalizations (include relationships themselves)
		addGeneralizations(addedElement, elementToAdd);

		return addedElement;
	}

	private void createGeneralizationInClass(Generalization generalizationToAdd, Element inClass) {
		if (inClass instanceof ClassImpl) { // FIXME Generalized to Classes and
											// Interfaces
			((Class) inClass).createGeneralization((Classifier) ModelAdapterUtilities.resolveElementInModel(
					generalizationToAdd.getGeneral(), inClass.getNearestPackage(), baseJointpoints));
		}
	}

	// Add to classBase all operations in classVariant (but not already existing
	// in classVariant)
	private void addOperations(ClassImpl fromClass, ClassImpl toClass, Model model) {
		for (Operation operation : fromClass.getOperations()) {
			if (ModelAdapterUtilities.elementMatchesInList(operation, toClass.getOperations()))
				continue;
			Operation clonedOperation = ModelAdapterUtilities.createElement(operation, toClass, baseJointpoints, model);
		}
	}

	// Add to classBase all properties in classVariant (but not already existing
	// in classVariant)
	private void addProperties(ClassImpl fromClass, ClassImpl toClass, Model model) {
		for (Property property : fromClass.getAttributes()) {
			if (ModelAdapterUtilities.elementMatchesInList(property, toClass.getAttributes()))
				continue;
			Property clonedProperty = ModelAdapterUtilities.createElement(property, toClass, baseJointpoints, model);
		}
	}

	/**
	 * Find base model elements tagged with role -> [elements|basemodel|role] =
	 * [joinpoint|basemodel] Find advice model elements tagged with same role ->
	 * [elements|advicemodel|role] = [jointpoint|advice] For each classBase in
	 * [jointpoint|basemodel] Get corresponding classVariant = element in
	 * [jointpoint|advice] For all properties Pi in classVariant: Remove
	 * property (Pi) from classBase If (property Pi is an association) Type T =
	 * association.type If type T exists in variantmodel For all elements in
	 * basemodel, if type T is not referenced by any of them (as generalization
	 * general, property type or operation parameter type) Remove type (see
	 * REMOVE TYPE) For all operations Oi in classVariant: Remove operation (Oi)
	 * from classBase For all parameters Pi in Oi, including return object Type
	 * T = pi.type If type T exists in advicemodel For all elements in
	 * basemodel, if type T is not referenced by any of them (as generalization
	 * general, property type or operation parameter type) Remove type (see
	 * REMOVE TYPE) For all generalizations Gi defined in classVariant If type =
	 * Gi.general exists in advicemodel Remove type (see REMOVE TYPE) For any
	 * type in advicemodel, such as type.generalization.general = classVariant
	 * If type exists in advicemodel Remove type (see REMOVE TYPE)
	 * 
	 * REMOVE_TYPE subrutine:
	 * 
	 * Remove TYPE from basemodel For all properties Pi in TYPE: If (property Pi
	 * is an association) Type T = association.type If type T exists in
	 * advicemodel For all elements in basemodel, if type T is not referenced by
	 * any of them (as generalization general, property type or operation
	 * parameter type) Remove type (see REMOVE TYPE) For all operations Oi in
	 * TYPE: For all parameters Pi in Oi, including return object Type T =
	 * pi.type If type T exists in advicemodel For all elements in basemodel, if
	 * type T is not referenced by any of them (as generalization general,
	 * property type or operation parameter type) Remove type (see REMOVE TYPE)
	 * For all generalizations Gi defined in TYPE If type = Gi.general exists in
	 * advicemodel Remove type (see REMOVE TYPE) For any type in advicemodel,
	 * such as type.generalization.general = TYPE If type exists in advicemodel
	 * Remove type (see REMOVE TYPE)
	 **/

	@Override
	public void applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
		ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;

		// * For all properties Pi in classVariant:
		// * Remove property (Pi) from classBase
		// * If (property Pi is an association)
		// * Type T = association.type
		// * If type T exists in variantmodel and it is not a base jointpoint
		// * For all elements in basemodel, if type T is not referenced by any
		// of them (as generalization general, property type or operation
		// parameter type)
		// * Remove type (see REMOVE TYPE)

		for (Property property : classVariant.getAttributes()) {
			Property baseProperty = (Property) ModelAdapterUtilities.resolvePropertyInClass(property, classBase, baseJointpoints);
			Type associationType = null;
			Association association = baseProperty.getAssociation();
			if (association != null) {
				if (baseProperty.getAssociation().getMemberEnds()!=null && 
					baseProperty.getAssociation().getMemberEnds().get(0)!=null){
					associationType = baseProperty.getAssociation().getMemberEnds().get(0).getType();
					
				}
			}
			//Destroy property
			baseProperty.destroy();
			if (associationType!=null){
				removeType(associationType, classBase.getModel(), usingVariantModel);
			}
			if (association!=null){
				//Destroy property association (they are not removed when the class is destroyed)
				association.destroy();
			}
		}

		// * For all operations Oi in classVariant:
		// * Remove operation (Oi) from classBase
		// * For all parameters Pi in Oi, including return object
		// * Type T = pi.type
		// * If type T exists in advicemodel and it is not a base jointpoint
		// * For all elements in basemodel, if type T is not referenced by any
		//   of them (as generalization general, property type or operation
		//   parameter type)
		//   * Remove type (see REMOVE TYPE)
		for (Operation operation : classVariant.getOperations()) {
			Operation baseOperation = (Operation) ModelAdapterUtilities.resolveOperationInClass(operation, classBase, baseJointpoints);
			
			List<Type> typesToRemove = new ArrayList<>();
			
			for (Parameter parameter : baseOperation.getOwnedParameters()) {
				Type type = parameter.getType();
				typesToRemove.add(type);
			}
			if (operation.getReturnResult() != null) {
				Type type = baseOperation.getReturnResult().getType();
				typesToRemove.add(type);
			}
			
			baseOperation.destroy();
			for (Type typeToRemove: typesToRemove){
				removeType(typeToRemove, classBase.getModel(), usingVariantModel);
			}
		}

		// * For all generalizations Gi defined in classVariant (superclasses of
		// classVariant)
		// * If type = Gi.general exists in advicemodel and it is not a base
		// jointpoint
		// * Remove type (see REMOVE TYPE)

		for (Generalization generalization : classVariant.getGeneralizations()) {
			Type type = generalization.getGeneral();
			resolvedAndRemoveType(type, classBase.getModel(), classVariant.getModel());
		}

		// * For any type in advicemodel, such as type.generalization.general =
		// classVariant (subclasses of classVariant)
		// * If type exists in advicemodel and it is not a base jointpoint
		// *Remove type (see REMOVE TYPE)
		for (Type type : ModelAdapterUtilities.findSubclassesOfType((Class)classVariant, classVariant.getModel())) {
			resolvedAndRemoveType(type, classBase.getModel(), classVariant.getModel());
		}

	}

	private void resolvedAndRemoveType(Type type, Model model, Model variantModel) {
		if (ModelAdapterUtilities.modelContainsElement(type, variantModel)) {
			Type baseType = (Type) ModelAdapterUtilities.resolveElementInModel(type, model, baseJointpoints); 
			removeType(baseType, model, variantModel);
		}
	}

	// Destroy method remove all cross-references to the type,
	// but not the referencing types, so it founds references to type that appears in the variant model and removes them
	private void removeType(Type type, Model inModel, Model variantModel) {
		// * Remove TYPE from basemodel
		List<Association> associationsToRemove = ModelAdapterUtilities.getAssociationsOfClass((Class)type);
		if (type != null && !baseJointpoints.containsValue(type)) {
			if (!ModelAdapterUtilities.elementIsReferencedInModel((Class)type, inModel)) {
				//Traverse through properties, operations and generalizations before removing the type.
				List<Type> references = findReferencesOfType((Class)type, inModel, variantModel);
				
				//Destroy type
				type.destroy(); 
				
				//Destroy associations of type
				for (Association assoc: associationsToRemove){
					assoc.destroy();
				}
				
				//Remove references of type
				for (Type typeToRemove: references){
					if (!(typeToRemove instanceof PrimitiveTypeImpl)){ //FIXME Consider only Classifiers (Class) for removal
						removeType(typeToRemove, inModel, variantModel);
					}
				}
			}
		}
	}
	
	private List<Type> findReferencesOfType(Class type, Model baseModel, Model variantModel) {
		
		List<Type> references = new ArrayList<>();
		// * For all properties Pi in TYPE:
		// * If (property Pi is an association)
		// * Type T = association.type
		// * If type T exists in advicemodel
		
		for (Property property : type.getAttributes()) {
//			Property baseProperty = (Property) ModelAdapterUtilities.resolvePropertyInClass(property, classBase, baseJointpoints);
			Type associationType = null;
			if (property.getAssociation() != null) {
				if (property.getAssociation().getMemberEnds()!=null && 
					property.getAssociation().getMemberEnds().get(0)!=null){
					associationType = property.getAssociation().getMemberEnds().get(0).getType();
				}
			}
			
			if (associationType!= null && 
				ModelAdapterUtilities.getEquivalentElementInModel(associationType, variantModel) != null){
				references.add(associationType);
			}
		}
		
		// * For all operations Oi in TYPE:
		// * For all parameters Pi in Oi, including return object
		// * Type T = pi.type
		// * If type T exists in advicemodel
		
		for (Operation operation : type.getOperations()) {
			for (Parameter parameter : operation.getOwnedParameters()) {
				Type parameterType = parameter.getType();
				if (parameterType!= null && 
					ModelAdapterUtilities.getEquivalentElementInModel(parameterType, variantModel) != null){
					references.add(parameterType);
				}
			}
			
			if (operation.getReturnResult() != null) {
				Type parameterType = operation.getReturnResult().getType();
				if (parameterType!= null && 
					ModelAdapterUtilities.getEquivalentElementInModel(parameterType, variantModel) != null){
					references.add(parameterType);
				}
			}
		}
		
		// * For all generalizations Gi defined in TYPE
		// * If type = Gi.general exists in advicemodel
		// * Remove type (see REMOVE TYPE)
		// * For any type in advicemodel, such as type.generalization.general =
		// TYPE
		// * If type exists in advicemodel
		for (Generalization generalization : type.getGeneralizations()) {
			Type superClass = generalization.getGeneral();
			if (superClass!= null && 
				ModelAdapterUtilities.getEquivalentElementInModel(superClass, variantModel) != null){
				references.add(superClass);
			}
		}
		
		return references;
		
	}

	@Override
	public void applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub
	}
}