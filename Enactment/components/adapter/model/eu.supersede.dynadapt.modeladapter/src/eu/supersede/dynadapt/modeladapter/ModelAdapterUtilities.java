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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;
import javax.lang.model.type.PrimitiveType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
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
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;

class ModelAdapterUtilities{
	private final static Logger log = LogManager.getLogger(ModelAdapterUtilities.class);
	
	public static boolean checkSameRelationship(Relationship r1, Relationship r2) {
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
	
	public static boolean modelContainsElement(NamedElement element, Model model) {
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
	
	public static List<NamedElement> getInstances(ClassImpl c, Model model) {
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
	
	public static Package getPackageInModel(Package pack, Model model) {
		// Find in model the corresponding package (same package nested route, excepting for model name)
		String packageQName = pack.getQualifiedName();
		packageQName = packageQName.substring(packageQName.indexOf("::") + 2, packageQName.length());
		List<String> tokens = Arrays.asList(packageQName.split ("\\::")); //Immutable list
		List<String> packages = new ArrayList<>(tokens); //Mutable list
		if (packages.size() == 0){
			return null;
		}
		return getPackageInPackage (packages, model);
	}

	public static Package getPackageInPackage(List<String> packages, Package outerPackage) {
		if (packages.size() == 0){
			return outerPackage;
		}
		String packageName = packages.get(0);
		Package innerPackage = (Package) outerPackage.getPackagedElement(packageName);
		packages.remove(packageName);
		
		return getPackageInPackage (packages, innerPackage);
	}
	
	public static void addElementInPackage(PackageableElement element, Package pack) {
		pack.getPackagedElements().add (element);
	}
	
	public static Element getEquivalentElementInModel(NamedElement element, Model model) {
		//PrimitiveTypes are equivalent among models
		if (element instanceof PrimitiveTypeImpl){
			return element;
		}
		
		PackageableElement equivalentElement = null;
		Package pack = null;
		if (element instanceof Model) //Equivalent element for a model it the model itself
			return model;
		if (element.getNearestPackage() instanceof Model){ //element in root container, that is the model
			pack = model;
		}else{
			getPackageInModel(element.getNearestPackage(), model);
		}
		if (pack!=null){
			equivalentElement = pack.getPackagedElement(((NamedElement)element).getName());
		}
		return equivalentElement;
	}
	
	public static boolean slotsHasSameDefiningFeature(Slot slot1, Slot slot2) {
		return slot1.getDefiningFeature().getName().equals(slot2.getDefiningFeature().getName());
	}

	public static boolean slotsHasSameValue(Slot slot1, Slot slot2) {
		InstanceValue iv1 = (InstanceValue) slot1.getValues().get(0);
		InstanceValue iv2 = (InstanceValue) slot2.getValues().get(0);
		return iv1.getInstance().getName().equals(iv2.getInstance().getName());
	}
	
	public static boolean areSameElements(NamedElement e1, NamedElement e2) {
		boolean result = true;
		result = result && (e1.getClass().getSimpleName().equals(e1.getClass().getSimpleName()));
		result = result && (e1.getName().equals(e2.getName()));
		return result;
	}
	
	public static Element findElementByStereotype(Model model, Stereotype stereotype) {
		EList<Element> list = model.allOwnedElements();
		for (Element e : list) {
			if (e.isStereotypeApplied(stereotype)) {
				return e;
			}
		}
		return null;
	}
	
	public static boolean elementHasRole(Element element, Stereotype stereotype) {
		return element.isStereotypeApplied(stereotype);
	}

	public static boolean elementMatchesInModel(Model model, NamedElement element) {
		return getEquivalentElementInModel (element, model) != null;
	}

	public static Package getPackageInModelMatchingElement(Model model, PackageableElement element) {
		return (Package) getEquivalentElementInModel(element.getNearestPackage(), model);
	}

	public static <T extends Element> T createElement(T element, PackageableElement inContainer, HashMap<Stereotype, List<Element>> baseJointpoints) {
		if (element instanceof Class){
			return (T) createClass ((Class) element, (Package)inContainer, baseJointpoints);
		}else if (element instanceof Association){
			return (T) createAssociation ((Association) element, (Class)inContainer, baseJointpoints);
		}else if (element instanceof Operation){
			return (T) createOperation ((Operation) element, (Class)inContainer, baseJointpoints);
		}else if (element instanceof Property){
			return (T) createProperty ((Property) element, (Class)inContainer, baseJointpoints);
		}else if (element instanceof Package){
			return (T) createPackage ((Package) element, (Model)inContainer, baseJointpoints);
		}else if (element instanceof Slot){
			return (T) createSlot ((Slot) element, (InstanceSpecification)inContainer, baseJointpoints);
		}else if (element instanceof InstanceSpecification){
			return (T) createInstanceSpecification ((InstanceSpecification) element, (Package)inContainer, baseJointpoints);
		}else{
			log.error ("UML Type : " + element.getClass().toString() + " not supported for clonning");
			return null;
		}
	}

	private static InstanceSpecification createInstanceSpecification(InstanceSpecification instance, Package inContainer,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		InstanceSpecification newInstance = UMLFactory.eINSTANCE.createInstanceSpecification();
		newInstance.setName(instance.getName());
		newInstance.setSpecification(instance.getSpecification());
		newInstance.getClassifiers().addAll(instance.getClassifiers());
		ModelAdapterUtilities.addElementInPackage (newInstance, inContainer);
		return newInstance;
	}

	private static Slot createSlot(Slot slot, InstanceSpecification inInstanceSpecification,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		// Creates the new slot referencing new object
		ValueSpecification vs = slot.getValues().get(0);
		Slot newSlot = inInstanceSpecification.createSlot();
		newSlot.setDefiningFeature(slot.getDefiningFeature()); 
		newSlot.createValue(vs.getName(), vs.getType(), vs.eClass());
		newSlot.setOwningInstance(inInstanceSpecification);
		return newSlot;
	}

	private static Package createPackage(Package pack, Model model, HashMap<Stereotype, List<Element>> baseJointpoints) {
		Package newPackage = UMLFactory.eINSTANCE.createPackage();
		newPackage.setName(pack.getName());
		Package nestingPackage =  (Package) getEquivalentElementInModel(pack.getNestingPackage(), model);
		if (nestingPackage != null){
			newPackage.setNestingPackage(nestingPackage);
		}else{
			newPackage.setNestingPackage(createPackage(pack.getNestingPackage(), model, baseJointpoints));
		}
		return newPackage;
	}

	private static Property createProperty(Property property, Class inClass, HashMap<Stereotype, List<Element>> baseJointpoints) {
		//Resolve type if refers to Jointpoint role: from base model JP role element resolves advice type
		//Resolve type pointing to base model.
		//Resolve types pointing to the base model
		//Resolve type in case of advice jointpoint role type
		
		Type type = (Type) resolveElementInModel (property.getType(), inClass.getModel(), baseJointpoints);
		
		//Non-association property
		Association association = property.getAssociation();
		Property newProperty = null;
		if (association==null){
			newProperty = inClass.createOwnedAttribute(property.getName(), type); 
		}else{
			//Manage association properties
			Association newAssociation = createAssociation(association, inClass, baseJointpoints);
			newProperty = inClass.getAttributes().get(inClass.getAttributes().size()-1);
		}
		return newProperty;
	}

	private static Operation createOperation(Operation operation, Class inClass, HashMap<Stereotype, List<Element>> baseJointpoints) {
		//Resolve type (for parameter and return type) if refers to Jointpoint role: from base model JP role element resolves advice type
		//Resolve type (for parameter and return type) pointing to base model.
		EList <String> parameterNames = new BasicEList<>();
		EList<Type> parameterTypes = new BasicEList<>();
		for (Parameter parameter: operation.getOwnedParameters()){
			parameterNames.add (parameter.getName());
			//Resolve types pointing to the base model
			//Resolve type in case of advice jointpoint role type
			parameterTypes.add ((Type) resolveElementInModel(parameter.getType(), inClass.getModel(), baseJointpoints));
		}
		Type returnType = null;
		if (operation.getReturnResult() != null)
			returnType = (Type) resolveElementInModel(operation.getReturnResult().getType(), inClass.getModel(), baseJointpoints);
		return inClass.createOwnedOperation(operation.getName(), parameterNames, parameterTypes, returnType);
	}

	private static Association createAssociation(Association association, Class inClass, HashMap<Stereotype, List<Element>> baseJointpoints) {
		Association newAssociation = inClass.createAssociation(
				association.getMemberEnds().get(0).isNavigable(), 
				association.getMemberEnds().get(0).getAggregation(), 
				association.getMemberEnds().get(0).getName(), 
				association.getMemberEnds().get(0).getLower(), 
				association.getMemberEnds().get(0).getUpper(), 
				(Type)resolveElementInModel(association.getMemberEnds().get(0).getType(), inClass, baseJointpoints),
				association.getMemberEnds().get(1).isNavigable(), 
				association.getMemberEnds().get(1).getAggregation(), 
				association.getMemberEnds().get(1).getName(), 
				association.getMemberEnds().get(1).getLower(), 
				association.getMemberEnds().get(1).getUpper());
		
		return newAssociation;
	}

	private static Class createClass(Class clazz, Package inContainer, HashMap<Stereotype, List<Element>> baseJointpoints) {
		Class newClass = inContainer.createOwnedClass(clazz.getName(), clazz.isAbstract());
	
		//Properties
		for (Property property: clazz.getAttributes()){
			createProperty(property, newClass, baseJointpoints);
		}
		//Operations
		for (Operation operation: clazz.getOperations()){
			createOperation(operation, newClass, baseJointpoints);
		}
		
		return newClass;
	}

	public static Element resolveElementInModel(Element type, PackageableElement inContainer, HashMap<Stereotype, List<Element>> baseJointpoints) {
		// Resolve type in model.
		// If type stereotype with Jointpoint role, resolve it in model by role
		// If type does not exist in model, create type and add it to model
		Element resolvedElement = getEquivalentElementInModel((PackageableElement) type, inContainer.getModel());
		if (resolvedElement == null){
			//Resolve type the Jointpoint role
			//Current resolution is based on stereotyped applications by jointpoint role
			//but in base model jointpoint are determine by patterns, which are passed in baseJointpoints
			for (Stereotype stereotype: baseJointpoints.keySet()){
				if (type.isStereotypeApplied(stereotype)){
					resolvedElement = baseJointpoints.get (stereotype).get(0); //FIXME Investigate possible multiple role assignments
					break;
				}
			}
		}
		if (resolvedElement == null){
			//Get equivalent type container in model. Create it if not available
			Package pack = (Package) resolveElementInModel(type.getNearestPackage(), inContainer, baseJointpoints);
			if (pack == null){
				pack = createElement (type.getNearestPackage(), inContainer, baseJointpoints);
			}
			
			//Create type
			resolvedElement = createElement(type, pack, baseJointpoints);
		}
		
		return resolvedElement;
	}

	/**
	 * returns true if element matches (by name) any of those included in listOfElements
	 * FIXME Improve matching by name to more elaborated matching by type
	 * @param element
	 * @param listOfElements
	 * @return
	 */
	public static <T extends NamedElement> boolean elementMatchesInList(T element, EList<T> listOfElements) {
		boolean match = false;
		for (T e: listOfElements){
			if (e.getName().equals(element.getName())){
				match = true;
				break;
			}
		}
		return match;
	}
	
}
