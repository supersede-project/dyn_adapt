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
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.uml2.uml.Package;

import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
//import eu.supersede.dynadapt.model.query.test.InstanceOfInstanceSpecificationLinkMatcher;
//import eu.supersede.dynadapt.model.query.test.util.InstanceOfInstanceSpecificationLinkQuerySpecification;

class ComposableInstanceSpecification extends ComposableImpl implements Composable{
	private final static Logger log = LogManager.getLogger(ComposableInstanceSpecification.class);
	
	public ComposableInstanceSpecification (IModelQuery modelQuery, HashMap<Stereotype, List<Element>> baseJointpoints){
		super (modelQuery, baseJointpoints);
	}
	
	@Override
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement,
			Model usingVariantModel, Element jointpointVariantModelElement) {
		InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
		InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;
		//Adding new slots in variant model to insertion point (e.g. Jointpoint) in base model
		for (Slot slot : instanceVariant.getSlots()) {
			log.debug("Adding slot: " + slot.getDefiningFeature().getName() + " in instance " + instanceBase.getQualifiedName());
			addSlotInInstanceSpecification(slot, instanceBase, inBaseModel);
		}
		//Adding new relationships (as instance specification of instance specification links) 
		// referencing the insertion point
		for (InstanceSpecification linkInstance: getReferencingInstanceSpecificationLinks(instanceVariant, usingVariantModel)){
			//Add link instance specification
			//FIXME avoid adding duplicated instances
			if (!ModelAdapterUtilities.modelContainsElement(linkInstance, inBaseModel)){
				log.debug("Adding detected link instance specification in variant model: " + linkInstance.getQualifiedName());
				addInstanceSpecificationInModel (linkInstance, inBaseModel);
			}
		}
	}
	
	@Override
	public void applyDeleteComposition(Model inBaseModel,
			Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) {
		InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
		InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;
		
		//Deleting Slot occurrences in base model, corresponding to variant jointpoint instance
		for (Slot slotInInstanceVariant: instanceVariant.getSlots()){
			deleteSlotInInstanceBase (slotInInstanceVariant, instanceBase);
		}

		//Deleting relationships (as instance specification of instance specification links) 
		// referencing the insertion point
		for (InstanceSpecification linkInstance: getReferencingInstanceSpecificationLinks(instanceVariant, usingVariantModel)){
			//Add link instance specification
			log.debug("Deleting detected link instance specification in base model: " + linkInstance.getQualifiedName());
			deleteInstanceSpecificationInModel (linkInstance, jointpointBaseModelElement, inBaseModel);
		}
	}
	
	private void addSlotInInstanceSpecification(Slot slot, InstanceSpecification instanceSpecification, Model model) {
		// Creates the new slot referencing new object		
		Slot newSlot = ModelAdapterUtilities.createElement (slot, instanceSpecification, baseJointpoints);
		
		// DefiningFeature should be added to base model if it does not exit therein
		StructuralFeature sf = slot.getDefiningFeature();
		if (!ModelAdapterUtilities.modelContainsElement(sf, model)){
			Package pack  = ModelAdapterUtilities.getPackageInModel (sf.getNearestPackage(), model);
			if (pack != null){
				log.debug("Adding instance: " + sf.getName() + " in base model in package " + pack.getQualifiedName());
				ModelAdapterUtilities.addElementInPackage ((PackageableElement) sf, pack);
			}
		}

		InstanceValue instanceValue = (InstanceValue) newSlot.getValues().get(0);
		InstanceValue newInstanceValue = (InstanceValue) slot.getValues().get(0);
		// Adds the instance to the model in the proper package
		InstanceSpecification newInstance = newInstanceValue.getInstance();
		// Copy variant instance only if it does not exist in base model.
		// If it does not exist it should placed in the package defined in variant model
		Package pack  = ModelAdapterUtilities.getPackageInModel (newInstance.getNearestPackage(), model);
		if (!ModelAdapterUtilities.modelContainsElement (newInstance, model) && pack != null){
			log.debug("Adding instance: " + newInstance.getName() + " in base model in package " + pack.getQualifiedName());
			ModelAdapterUtilities.addElementInPackage (newInstance, pack);
		}
		// Creates the reference between base object and referenced object in
		// base model
		instanceValue.setInstance(newInstance);
	}

	private void addInstanceSpecificationInModel(InstanceSpecification linkInstance, Model model) {
		//Get the package in base model where linkInstance should be placed
		Package pack  = ModelAdapterUtilities.getPackageInModel (linkInstance.getNearestPackage(), model);
		if (pack != null){
			//Create InstanceSpecification copy:
			//Create Slots, Add them to the model
			//Add instance to the model
			InstanceSpecification newLinkInstance = ModelAdapterUtilities.createElement (linkInstance, pack, baseJointpoints);
			for (Slot slot : linkInstance.getSlots()) {
				addSlotInInstanceSpecification(slot, newLinkInstance, model);
			}
		}
	}
	
	private Set<InstanceSpecification> getReferencingInstanceSpecificationLinks(InstanceSpecificationImpl instanceVariant, Model model) {
		Set<InstanceSpecification> instances = null;
	
		try {
			InstanceOfInstanceSpecificationLinkMatcher matcher = 
					(InstanceOfInstanceSpecificationLinkMatcher) modelQuery.queryMatcher(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
			instances = matcher.getAllValuesOflink(instanceVariant);
			//Filtering out instances that do not belong to target model
			for (InstanceSpecification instance: instances){
				if (!ModelAdapterUtilities.modelContainsElement(instance, model)){
					instances.remove(instance);
				}
			}
		} catch (ViatraQueryException e) {
			e.printStackTrace();
		}
		return instances;
	}
	
	private void deleteInstanceSpecificationInModel(InstanceSpecification linkInstance, Element jointpointBaseModelElement, Model inBaseModel) {
		//Get linkInstance equivalent in base model
		InstanceSpecification linkInstanceInBaseModel = (InstanceSpecification) ModelAdapterUtilities.getEquivalentElementInModel (linkInstance, inBaseModel);
		if(linkInstanceInBaseModel == null) return;
		
		// Delete instances referenced by slots of the link
		for (Slot slot : linkInstanceInBaseModel.getSlots()) {
			ValueSpecification valueSpecification = slot.getValues().get(0);
			if (valueSpecification != null){
				if (valueSpecification instanceof InstanceValue){
					InstanceSpecification instance = ((InstanceValue)valueSpecification).getInstance();
					//Do not remove the jointpoint basemodel element
//					if (instance != null && areSameElements (instance, (NamedElement) jointpointBaseModelElement)){
					//FIXME Since base model is cloned, and not stored in ResourceSet, object found in RS is not identical object to the one found
					//in cloned based model, but both has same qualified name
					if (instance != null && !(instance.getQualifiedName().equals(((InstanceSpecification)jointpointBaseModelElement).getQualifiedName()))){
						log.debug("Removing instance: " + instance.getQualifiedName() + 
							" from base model since it is referenced in slot " + slot.getDefiningFeature().getQualifiedName());
						instance.destroy();
					}
				}
			}
		}
		
		//Delete link
		linkInstanceInBaseModel.destroy();
	}
	
	private void deleteSlotInInstanceBase(Slot slotInInstanceVariant, InstanceSpecificationImpl instanceBase) {
		for (Slot slotInInstanceBase: instanceBase.getSlots()){
			if (slotInInstanceBase.getDefiningFeature() == null){ //FIXME Investigate when this happens
				continue;
			}
			//Slot exists in both instances AND
			//Slot in both instances refers to the same value
			if (ModelAdapterUtilities.slotsHasSameDefiningFeature(slotInInstanceVariant, slotInInstanceBase) && 
				ModelAdapterUtilities.slotsHasSameValue(slotInInstanceVariant, slotInInstanceBase)){
				log.debug("Deleting slot : " + slotInInstanceBase.getDefiningFeature().getQualifiedName() + " in instance " + instanceBase.getQualifiedName());
				destroySlotInstance(slotInInstanceBase);
				slotInInstanceBase.destroy();
			}	
		}
	}
	
	private void destroySlotInstance(Slot slot) {
		InstanceValue iv = (InstanceValue)slot.getValues().get(0);
		InstanceSpecification instance = iv.getInstance();
		if (instance!=null) {
			log.debug("Deleting instance value : " + instance.getQualifiedName() + " referenced by slot " + slot.getDefiningFeature().getQualifiedName());
			instance.destroy();
		}
	}

	@Override
	public void applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Given a pair of instances, retrieves the Relationship ref object of the
	 * relationship
	 * 
	 * @param e1
	 *            parent instance
	 * @param e2
	 *            child instance
	 * @return relationship
	 */
	private Relationship getRelationship(InstanceSpecification e1, InstanceSpecification e2) {
		List<Relationship> rs = ((ClassImpl) e1.getClassifiers().get(0)).getRelationships();
		Relationship rel = null;
		for (Relationship r : rs) {
			if (r.getRelatedElements().contains(e2.getClassifiers().get(0))) {
				rel = r;
				break;
			}
		}
		return rel;
	}
}