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
 *  Yosu Gorroñogoitia (Atos) 
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/

package eu.supersede.dynadapt.modeladapter;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.dynadapt.dsl.aspect.ActionOptionType;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.model.query.test.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.model.query.test.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.model.tagger.ModelTagger;

@SuppressWarnings("restriction")
public class ModelAdapter implements IModelAdapter {	
	private final static Logger log = LogManager.getLogger(ModelAdapter.class);
	private final String INSTANCE = "InstanceSpecificationImpl";
	private final String CLASS = "ClassImpl";

	private ModelTagger mt = null;
	private IModelManager mm = null;
	private IModelQuery modelQuery = null;
	
	public ModelAdapter(IModelManager modelManager) throws ViatraQueryException {
		mm = modelManager;
		mt = new ModelTagger(modelManager);
		modelQuery = new ModelQuery (modelManager);
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

	public Model applyCompositionDirective(ActionOptionType actionOptionType, Model inBaseModel,
			HashMap<Stereotype, List<Element>> elements, Stereotype adviceRole, Model usingVariantModel)
			throws Exception {
		
		Element variantElement = findElementByStereotype(usingVariantModel, adviceRole);
		// Notified if variantElement cannot be found in variant model. In this
		// case, adaptation cannot be applied
		if (variantElement == null) {
			System.err.println("Role " + adviceRole.getName() + " could not be found in variant model: "
					+ usingVariantModel.getName());
			return null;
		}

		Model model = null;

		for (Stereotype stereotype : elements.keySet()) {
			for (Element baseElement : elements.get(stereotype)) {
				if (actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("ADD")) != null)
					model = applyAddComposition(inBaseModel, baseElement, usingVariantModel, variantElement);
				else if (actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("DELETE")) != null)
					model = applyDeleteComposition(inBaseModel, baseElement, usingVariantModel, variantElement);
				else if (actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("REPLACE")) != null)
					model = applyReplaceComposition(inBaseModel, baseElement, usingVariantModel, variantElement);
			}
		}

		return model;

	}

	public void stereotypeElement(Element e, Stereotype role) throws Exception {
		mt.tagModel(e, role.getProfile(), role);
		log.debug(e.getAppliedStereotypes());
	}

	@Override
	public Model applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {

		String type = jointpointVariantModelElement.getClass().getSimpleName();

		// TODO Add all instances (from variant model referencing jointpointVariantModelElement) that does not exist in inBaseModel
		if (type.equals(INSTANCE)) {
			InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
			InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;
			//Adding new slots in variant model to insertion point (e.g. Jointpoint) in base model
			for (Slot slot : instanceVariant.getSlots()) {
				log.debug("Adding slot: " + slot.getDefiningFeature().getName() + " in instance " + instanceBase.getName());
				addSlotInInstanceSpecification(slot, instanceBase, inBaseModel);
			}
			//Adding new relationships (as instance specification of instance specification links) 
			// referencing the insertion point
			for (InstanceSpecification linkInstance: getReferencingInstanceSpecificationLinks(instanceVariant)){
				//Add link instance specification
				log.debug("Adding detected link instance specification in variant model: " + linkInstance.getName());
				addInstanceSpecificationInModel (linkInstance, inBaseModel);
			}	
		} else if (type.equals(CLASS)) {
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

		return inBaseModel;
	}

	private void addInstanceSpecificationInModel(InstanceSpecification linkInstance, Model model) {
		//Create InstanceSpecification copy:
		//Create Slots, Add them to the model
		//Add instance to the model
		InstanceSpecification newLinkInstance = UMLFactory.eINSTANCE.createInstanceSpecification();
		newLinkInstance.setName(linkInstance.getName());
		newLinkInstance.setSpecification(linkInstance.getSpecification());
		newLinkInstance.getClassifiers().addAll(linkInstance.getClassifiers());
		model.getPackagedElements().add(newLinkInstance);
		
		for (Slot slot : linkInstance.getSlots()) {
			addSlotInInstanceSpecification(slot, newLinkInstance, model);
		}
	}

	private Set<InstanceSpecification> getReferencingInstanceSpecificationLinks(InstanceSpecificationImpl instanceVariant) {
		Set<InstanceSpecification> instances = null;
	
		try {
			InstanceOfInstanceSpecificationLinkMatcher matcher = 
					(InstanceOfInstanceSpecificationLinkMatcher) modelQuery.queryMatcher(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
			instances = matcher.getAllValuesOflink(instanceVariant);
		} catch (ViatraQueryException e) {
			e.printStackTrace();
		}
		return instances;
	}

	private void addSlotInInstanceSpecification(Slot slot, InstanceSpecification instanceSpecification, Model model) {
		ValueSpecification vs = slot.getValues().get(0);
		// Creates the new slot referencing new object
		Slot newSlot = instanceSpecification.createSlot();
		// FIXME DefiningFeature should be added to base model if it does not exit therein
		newSlot.setDefiningFeature(slot.getDefiningFeature()); 
		newSlot.createValue(vs.getName(), vs.getType(), vs.eClass());
		newSlot.setOwningInstance(instanceSpecification);

		InstanceValue instanceValue = (InstanceValue) newSlot.getValues().get(0);
		InstanceValue newInstanceValue = (InstanceValue) slot.getValues().get(0);
		// Adds the instance to the model in the proper package
		InstanceSpecification newInstance = newInstanceValue.getInstance();
		// FIXME copy variant instance only if it does not exist in base model.
		if (!modelContainsElement (newInstance, model)){
			log.debug("Adding instance: " + newInstance.getName() + " in base model");
			instanceSpecification.getNearestPackage().getPackagedElements().add(newInstance); 
		}
		// Creates the reference between base object and referenced object in
		// base model
		instanceValue.setInstance(newInstance);
	}

	@Deprecated
	public Model applyAddCompositionOld(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {

		String type = jointpointVariantModelElement.getClass().getSimpleName();

		if (type.equals(INSTANCE)) {

			InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
			InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;
			for (int i = 0; i < instanceVariant.getSlots().size(); ++i) {
				Slot s = instanceVariant.getSlots().get(i);
				ValueSpecification v = s.getValues().get(0);
				// Creates the new slot referencing new object
				Slot newSlot = instanceBase.createSlot();
				newSlot.setDefiningFeature(s.getDefiningFeature());
				newSlot.createValue(v.getName(), v.getType(), v.eClass());
				newSlot.setOwningInstance(instanceBase);
				InstanceValue baseInst = (InstanceValue) newSlot.getValues().get(0);
				InstanceValue variantInst = (InstanceValue) s.getValues().get(0);
				// Adds the instance to the model in the proper package
				InstanceSpecification newInstance = variantInst.getInstance();
				baseInst.getNearestPackage().getPackagedElements().add(newInstance);
				// Creates the reference between base object and referenced
				// object in base model
				baseInst.setInstance(newInstance);
				// Creates the instance relationship
				for (Relationship a : newInstance.getClassifiers().get(0).getRelationships()) {
					if (a.getRelatedElements().contains(instanceBase.getClassifiers().get(0))
							&& a.getRelatedElements().contains(newInstance.getClassifiers().get(0))) {
						InstanceSpecification rel = (InstanceSpecificationImpl) UMLFactory.eINSTANCE
								.createInstanceSpecification();
						rel.setName(
								"InstanceSpecificationLink_" + instanceBase.getName() + "_to_" + newInstance.getName());
						rel.getClassifiers().add((Classifier) a);
						addReference(rel, instanceBase, a);
						baseInst.getNearestPackage().getPackagedElements().add(rel);
					}
				}
			}
		} else if (type.equals(CLASS)) {
			ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
			ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
			// For each relationship of the class
			for (int i = 0; i < classVariant.getRelationships().size(); ++i) {
				Relationship r = classVariant.getRelationships().get(i);
				for (int j = 0; j < r.getRelatedElements().size(); ++j) {
					Element e = r.getRelatedElements().get(j);
					if (!((NamedElement) e).getName().equals(classBase.getName())) {
						classBase.getNearestPackage().getPackagedElements().add((PackageableElement) e);
					}
				}
				classBase.getNearestPackage().getPackagedElements().add((PackageableElement) r.eContainer());
			}
		}

		return inBaseModel;

	}

	@Override
	public Model applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) throws Exception {

		String type = jointpointVariantModelElement.getClass().getSimpleName();

		if (type.equals(INSTANCE)) {

			InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
			InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;
			
			//Deleting Slot occurrences in base model, corresponding to variant jointpoint instance
			for (Slot slotInInstanceVariant: instanceVariant.getSlots()){
				deleteSlotInInstanceBase (slotInInstanceVariant, instanceBase);
			}

			//Deleting relationships (as instance specification of instance specification links) 
			// referencing the insertion point
			for (InstanceSpecification linkInstance: getReferencingInstanceSpecificationLinks(instanceVariant)){
				//Add link instance specification
				log.debug("Deleting detected link instance specification in base model: " + linkInstance.getName());
				deleteInstanceSpecificationInModel (linkInstance, jointpointBaseModelElement, inBaseModel);
			}	

		} else if (type.equals(CLASS)) {
			ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
			ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
			// For each relationship of the class in the variant
			for (Relationship r1:classVariant.getRelationships()) {
				// For each relationship of the class in the base model
				for (Relationship r2:classBase.getRelationships()) {
					// Check which relationships are present in the variant
					if (checkSameRelationship(r1, r2)) {
						// Retrieve the related object
						ClassImpl deleteClass = null;
						if (!r2.getRelatedElements().get(0).equals(classBase)) {
							deleteClass = (ClassImpl) r2.getRelatedElements().get(0);
						} else
							deleteClass = (ClassImpl) r2.getRelatedElements().get(1);
						// Delete it if present in variant
						if (modelContainsElement(deleteClass, usingVariantModel))
							deleteClass.destroy();
						break;
					}
				}
			}
			// Delete all instances of the class in the variant
			List<NamedElement> baseInstances = getInstances(classVariant, inBaseModel);
			for (NamedElement e : baseInstances) {
				if (modelContainsElement(e, usingVariantModel))
					e.destroy();
			}
		}

		return inBaseModel;
	}
	
	private void deleteInstanceSpecificationInModel(InstanceSpecification linkInstance, Element jointpointBaseModelElement, Model inBaseModel) {
		// Delete instances referenced by slots of the link
		for (Slot slot : linkInstance.getSlots()) {
			ValueSpecification valueSpecification = slot.getValues().get(0);
			if (valueSpecification != null){
				if (valueSpecification instanceof InstanceValue){
					InstanceSpecification instance = ((InstanceValue)valueSpecification).getInstance();
					if (instance != null && areSameElements (instance, (NamedElement) jointpointBaseModelElement)){
						log.debug("Removing instance: " + instance.getQualifiedName() + 
							" from base model since it is referenced in slot " + slot.getDefiningFeature().getName());
						instance.destroy();
					}
				}
			}
		}
		
		//Delete link
		linkInstance.destroy();
	}

	private boolean areSameElements(NamedElement e1, NamedElement e2) {
		boolean result = true;
		result = result && (e1.getClass().getSimpleName().equals(e1.getClass().getSimpleName()));
		result = result && (e1.getName().equals(e2.getName()));
		return result;
	}

	private void deleteSlotInInstanceBase(Slot slotInInstanceVariant, InstanceSpecificationImpl instanceBase) {
		for (Slot slotInInstanceBase: instanceBase.getSlots()){
			//Slot exists in both instances AND
			//Slot in both instances refers to the same value
			if (slotsHasSameDefiningFeature(slotInInstanceVariant, slotInInstanceBase) && 
				slotsHasSameValue(slotInInstanceVariant, slotInInstanceBase)){
				destroySlotInstance(slotInInstanceBase);
				slotInInstanceBase.destroy();
				
			}	
		}
	}

	private void destroySlotInstance(Slot slot) {
		InstanceValue iv = (InstanceValue)slot.getValues().get(0);
		InstanceSpecification instance = iv.getInstance();
		if (instance!=null) instance.destroy();
	}

	private boolean slotsHasSameValue(Slot slot1, Slot slot2) {
		InstanceValue iv1 = (InstanceValue) slot1.getValues().get(0);
		InstanceValue iv2 = (InstanceValue) slot2.getValues().get(0);
		return iv1.getInstance().getName().equals(iv2.getInstance().getName());
	}

	private boolean slotsHasSameDefiningFeature(Slot slot1, Slot slot2) {
		return slot1.getDefiningFeature().getName().equals(slot2.getDefiningFeature().getName());
	}

	// FIXME: Error when applied to Atos UC (FIXED in new version included in class)
	@Deprecated
	public Model applyDeleteCompositionOld(Model inBaseModel, Element jointpointBaseModelElement,
			Model usingVariantModel, Element jointpointVariantModelElement) throws Exception {

		String type = jointpointVariantModelElement.getClass().getSimpleName();

		if (type.equals(INSTANCE)) {

			InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
			InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;

			HashMap<String, Slot> destroy = new HashMap<>();

			// FIXME: Remove slot in base if slot in variant refers to the same
			// defining feature and their value refers to the same instance
			// value (by name)
			for (int i = 0; i < instanceBase.getSlots().size(); ++i) {
				Slot sb = instanceBase.getSlots().get(i);
				for (int j = 0; j < instanceVariant.getSlots().size(); ++j) {
					Slot sv = instanceVariant.getSlots().get(j);
					InstanceValue baseInst = (InstanceValue) sb.getValues().get(0);
					InstanceValue variantInst = (InstanceValue) sv.getValues().get(0);

					if (baseInst.getInstance().getName().equals(variantInst.getInstance().getName())) {
						// Destroy instance and references
						destroy.put(baseInst.getInstance().getName(), sb);
						// FIXME: Calculate correctly instance specification
						// links pointing to variant jointpoint.
						// Then, delete in base model similar instance
						// specification links relating the same pair of
						// elements of the ISL detected in variant model
						Relationship r = getRelationship(baseInst.getInstance(), variantInst.getInstance());
						TreeIterator<EObject> tree = inBaseModel.eAllContents();
						while (tree.hasNext()) {
							EObject a = tree.next();
							if (isAssociationInstance(a, r, instanceBase)) {
								((InstanceSpecification) a).destroy();
							}
						}
						baseInst.getInstance().destroy();
					}
				}
			}
			for (Slot s : destroy.values())
				s.destroy();

		} else if (type.equals(CLASS)) {
			ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
			ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
			// For each relationship of the class in the variant
			for (int i = 0; i < classVariant.getRelationships().size(); ++i) {
				Relationship r1 = classVariant.getRelationships().get(i);
				// For each relationship of the class in the base model
				for (int j = 0; j < classBase.getRelationships().size(); ++j) {
					Relationship r2 = classBase.getRelationships().get(j);
					// Check which relationships are present in the variant
					if (checkSameRelationship(r1, r2)) {
						// Retrieve the related object
						ClassImpl deleteClass = null;
						if (!r2.getRelatedElements().get(0).equals(classBase)) {
							deleteClass = (ClassImpl) r2.getRelatedElements().get(0);
						} else
							deleteClass = (ClassImpl) r2.getRelatedElements().get(1);
						// Delete it if present in variant
						if (modelContainsElement(deleteClass, usingVariantModel))
							deleteClass.destroy();
						break;
					}
				}
			}
			// Delete all instances of the class in the variant
			List<NamedElement> baseInstances = getInstances(classVariant, inBaseModel);
			for (NamedElement e : baseInstances) {
				if (modelContainsElement(e, usingVariantModel))
					e.destroy();
			}
		}

		return inBaseModel;

	}

	@Override
	public Model applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub
		return null;
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
	public Relationship getRelationship(InstanceSpecification e1, InstanceSpecification e2) {
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

	/**
	 * Adds a slot to e1 with value reference to e2 on relationship r
	 * 
	 * @param rel
	 * @param instanceBase
	 */
	private void addReference(InstanceSpecification e1, InstanceSpecification e2, Relationship r) {
		// Creates the new slot
		Slot relSlot = e1.createSlot();
		Property p = (Property) r.getOwnedElements().get(0);
		relSlot.setDefiningFeature(p);
		// Adds the reference to the instance value
		InstanceValue v = UMLFactory.eINSTANCE.createInstanceValue();
		v.setInstance(e2);
		InstanceValue value = (InstanceValue) relSlot.createValue("InstanceValue1", v.getType(), v.eClass());
		value.setInstance(e2);
		// relSlot.setDefiningFeature((StructuralFeature)
		// e2.eGet(e2.eClass().getEStructuralFeature("classifier")));
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

	/**
	 * Retrieves the list of all the instances of the specified class
	 * 
	 * @param c
	 * @return
	 */
	private List<NamedElement> getInstances(ClassImpl c, Model model) {
		List<NamedElement> instances = new ArrayList<>();
		TreeIterator<EObject> tree = model.eAllContents();
		while (tree.hasNext()) {
			EObject a = tree.next();
			if (a.eClass().getEStructuralFeature("classifier") != null) {
				EObjectResolvingEList eList = (EObjectResolvingEList) a
						.eGet(a.eClass().getEStructuralFeature("classifier"));
				if (eList != null && eList.size() > 0) {
					Classifier classifier = (Classifier) eList.get(0);
					if (classifier.getName().equals(c.getName()))
						instances.add((NamedElement) a);
				}
			}
		}
		return instances;
	}

	private boolean checkSameRelationship(Relationship r1, Relationship r2) {
		for (int i = 0; i < r1.getRelatedElements().size(); ++i) {
			NamedElement e1 = (NamedElement) r1.getRelatedElements().get(i);
			boolean found = false;
			for (int j = 0; j < r2.getRelatedElements().size(); ++j) {
				NamedElement e2 = (NamedElement) r2.getRelatedElements().get(j);
				if (e1.getName().equals(e2.getName())) {
					found = true;
					break;
				}
			}
			if (!found)
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param deleteClass
	 * @param usingVariantModel
	 * @return
	 */
	private boolean modelContainsElement(NamedElement element, Model model) {
		TreeIterator<EObject> tree = model.eAllContents();
		while (tree.hasNext()) {
			EObject a = tree.next();
			if (a.eClass().getEStructuralFeature("name") != null) {
				Object name = a.eGet(a.eClass().getEStructuralFeature("name"));
				if (name != null) {
					if (name.toString().equals(element.getName()))
						return true;
				}
			}
		}
		return false;
	}

	private Element findElementByStereotype(Model model, Stereotype stereotype) {
		EList<Element> list = model.allOwnedElements();
		for (Element e : list) {
			if (e.isStereotypeApplied(stereotype)) {
				return e;
			}
		}
		return null;
	}

}
