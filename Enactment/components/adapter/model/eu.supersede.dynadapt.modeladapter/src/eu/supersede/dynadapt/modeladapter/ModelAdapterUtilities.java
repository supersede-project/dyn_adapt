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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;
import org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl;
import org.eclipse.uml2.uml.internal.impl.StructuralFeatureImpl;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.modeladapter.queries.GetReferenceToTypeMatcher;
import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.SubClassOfMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.GetReferenceToTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.SubClassOfQuerySpecification;

import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Class;

public class ModelAdapterUtilities {
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
		// Find in model the corresponding package (same package nested route,
		// excepting for model name)
		String packageQName = pack.getQualifiedName();
		packageQName = packageQName.substring(packageQName.indexOf("::") + 2, packageQName.length());
		List<String> tokens = Arrays.asList(packageQName.split("\\::")); // Immutable
																			// list
		List<String> packages = new ArrayList<>(tokens); // Mutable list
		if (packages.size() == 0) {
			return null;
		}
		return getPackageInPackage(packages, model);
	}

	public static Package getPackageInPackage(List<String> packages, Package outerPackage) {
		if (packages.size() == 0) {
			return outerPackage;
		}
		String packageName = packages.get(0);
		Package innerPackage = (Package) outerPackage.getPackagedElement(packageName);
		packages.remove(packageName);

		return getPackageInPackage(packages, innerPackage);
	}

	public static void addElementInPackage(PackageableElement element, Package pack) {
		pack.getPackagedElements().add(element);
	}

	public static Element getEquivalentElementInModel(NamedElement element, Model model) {
		// PrimitiveTypes are equivalent among models
		// FIXME Get primitive Equivalent in model
		if (element instanceof PrimitiveType) {
			return element;
//			return getPrimitiveTypeInModel ((PrimitiveType) element, model);
		}
		
		//Properties
		if (element instanceof Property && ((Property)element).getAssociation()==null){
			return getPropertyInModel ((Property)element, model);
		}
		
		//ExecutionEnvironment
		//FIXME Generalize resolution of different elements
		if (element instanceof ExecutionEnvironment){
			return getExecutionEnvironmentInModel ((ExecutionEnvironment)element, model);
		}

		PackageableElement equivalentElement = null;
		Package pack = null;
		// Equivalent element for a model it the model itself
		if (element instanceof Model){ 
			return model;
		}
		// element in root container, that is the model
		if (element.getNearestPackage() instanceof Model) { 
			pack = model;
		} else {
			pack = getPackageInModel(element.getNearestPackage(), model);
		}
		if (pack != null) {
			equivalentElement = pack.getPackagedElement(((NamedElement) element).getName());
		}
		return equivalentElement;
	}

	private static Property getPropertyInModel(Property property, Model model) {
		Property result = null;
		org.eclipse.uml2.uml.Class classInModel = (org.eclipse.uml2.uml.Class)getEquivalentElementInModel((NamedElement)property.eContainer(), model);
		
		if (classInModel != null){
			//As given property is defined in another model than where class is defined, matches must be found by matching name and type
//			result = classInModel.getAttribute(property.getName(), property.getType());
			for (Property p: classInModel.getAllAttributes()){
				if (p.getName().equals(property.getName()) && 
					p.getType().getQualifiedName().equals(property.getType().getQualifiedName())){
					result = p;
					break;
				}
			}
		}
	
		return result;
	}
	
	private static ExecutionEnvironment getExecutionEnvironmentInModel(ExecutionEnvironment execEnv, Model model) {
		ExecutionEnvironment result = null;
		Node nodeInModel = (Node)getEquivalentElementInModel((NamedElement)execEnv.eContainer(), model);
		
		if (nodeInModel != null){
			for (Node node: nodeInModel.getNestedNodes()){
				if (node instanceof ExecutionEnvironment && node.getName().equals(execEnv.getName())){
					result = (ExecutionEnvironment)node;
					break;
				}
			}
		}
	
		return result;
	}

	private static Element getPrimitiveTypeInModel(PrimitiveType element, Model model) {
		if (element.eContainer() instanceof Model){
			if(((Model)element.eContainer()).getName().equals("EcorePrimitiveTypes")){
				return element;
			}
		}
		Element type = null;
		for (PackageImport pi:model.getPackageImports()){
			if (pi.getImportedPackage().getName().equals("PrimitiveTypes")){
				type = pi.getImportedPackage().getPackagedElement(element.getName());
				break;
			}
		}
		return null;
	}

	public static boolean slotsHasSameDefiningFeature(Slot slot1, Slot slot2) {
		return slot1.getDefiningFeature().getName().equals(slot2.getDefiningFeature().getName());
	}

	public static boolean slotsHasSameValue(Slot slot1, Slot slot2) {
		ValueSpecification iv1 = (ValueSpecification) slot1.getValues().get(0);
		ValueSpecification iv2 = (ValueSpecification) slot2.getValues().get(0);
		if (iv1 instanceof InstanceValue && iv2 instanceof InstanceValue){
			return ((InstanceValue)iv1).getInstance().getName().equals(((InstanceValue)iv2).getInstance().getName());
		}else if (iv1 instanceof LiteralString && iv2 instanceof LiteralString){
			return ((LiteralString)iv1).getValue().equals(((LiteralString)iv2).getValue());
		}else if (iv1 instanceof LiteralReal && iv2 instanceof LiteralReal){
			return ((LiteralReal)iv1).getValue() == (((LiteralReal)iv2).getValue());
		}else if (iv1 instanceof LiteralInteger && iv2 instanceof LiteralInteger){
			return ((LiteralInteger)iv1).getValue() == (((LiteralInteger)iv2).getValue());
		}else{
			return false;
		}
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
	
	public static List<ActivityEdge> setOutgoingEdges(ActivityImpl activity, List<ActivityEdge> outgoingEdges, ActivityNode originAction) {
		List<ActivityEdge> edges = new ArrayList<>();
		for (int i = 0; i < outgoingEdges.size(); ++i) {
			ActivityEdge edge = (ActivityEdge) activity.createEdge(outgoingEdges.get(i).getName(), outgoingEdges.get(i).eClass());
			log.debug("\tNew edge from " + originAction.getName());
			edges.add(edge);
			edge.setSource(originAction);
			originAction.getOutgoings().add(edge);
		}
		return edges;
	}

	public static void setIncomingEdges(List<ActivityEdge> incomingEdges, ActivityNode originAction) {
		for (int i = 0; i < incomingEdges.size(); ++i) {
			//log.debug("\tNew edge to " + originAction.getName());
			log.debug("\tSet edge target to " + originAction.getName() );
			ActivityEdge edge = incomingEdges.get(i);
			edge.setTarget(originAction);
			originAction.getIncomings().add(edge);
		}
	}
		
	public static boolean elementHasRole(Element element, Stereotype stereotype) {
		return element.isStereotypeApplied(stereotype);
	}

	public static boolean elementMatchesInModel(Model model, NamedElement element) {
		return getEquivalentElementInModel(element, model) != null;
	}

	public static Package getPackageInModelMatchingElement(Model model, PackageableElement element) {
		return (Package) getEquivalentElementInModel(element.getNearestPackage(), model);
	}

	public static <T extends Element> T createElement(T element, PackageableElement inContainer,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		
		if (element instanceof Class) {
			Class clazz = (Class)element;
			log.debug("Creating class: " + clazz.getName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createClass(clazz, (Package) inContainer, baseJointpoints, model);
		} else if (element instanceof Association) {
			Association association = (Association)element;
			log.debug("Creating association: " + association.getName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createAssociation(association, (Class) inContainer, baseJointpoints, model);
		} else if (element instanceof Operation) {
			Operation operation = (Operation)element;
			log.debug("Creating operation: " + operation.getName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createOperation(operation, (Class) inContainer, baseJointpoints, model);
		} else if (element instanceof Property) {
			Property property = (Property)element;
			log.debug("Creating property: " + property.getName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createProperty((Property) element, (Class) inContainer, baseJointpoints, model);
		} else if (element instanceof Package) {
			Package pack = (Package)element;
			log.debug("Creating package: " + pack.getName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createPackage((Package) element, (Model) inContainer, baseJointpoints, model);
		} else if (element instanceof Slot) {
			Slot slot = (Slot)element;
			log.debug("Creating slot for defining feature: " + slot.getDefiningFeature().getQualifiedName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createSlot((Slot) element, (InstanceSpecification) inContainer, baseJointpoints, model);
		} else if (element instanceof InstanceSpecification) {
			InstanceSpecification instanceSpecification = (InstanceSpecification)element;
			log.debug("Creating instanceSpecification: " + instanceSpecification.getName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createInstanceSpecification((InstanceSpecification) element, (Package) inContainer,
					baseJointpoints, model);
		}else if (element instanceof Manifestation) {
			Manifestation manifestation = (Manifestation)element;
			log.debug("Creating manifestation for utilized element: " + manifestation.getUtilizedElement().getQualifiedName() + " in container:" + inContainer.getQualifiedName() + " in model: " + model.getName());
			return (T) createManifestation((Manifestation) element, (Package) inContainer,
					baseJointpoints, model);
		} else {
			log.error("UML Type : " + element.getClass().toString() + " not supported for clonning");
			return null;
		}
	}

	private static Manifestation createManifestation(Manifestation manifestation, Package inContainer,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		Manifestation newManifestation = UMLFactory.eINSTANCE.createManifestation();
		newManifestation.setName(manifestation.getName());
		
		//Resolve clients in base model
		for (NamedElement client: manifestation.getClients()){
			NamedElement equivalentClient = (NamedElement)getEquivalentElementInModel(client, model);
			if (equivalentClient==null){
				Package pack  = getPackageInModel (client.getNearestPackage(), model);
				if (pack != null){
					equivalentClient = createElement(client, pack, baseJointpoints, model);
				}
			}
			newManifestation.getClients().add(equivalentClient);
		}
		
		//Resolve suppliers in base model
		for (NamedElement supplier: manifestation.getSuppliers()){
			NamedElement equivalentSupplier = (NamedElement)getEquivalentElementInModel(supplier, model);
			if (equivalentSupplier==null){
				Package pack  = getPackageInModel (supplier.getNearestPackage(), model);
				if (pack != null){
					equivalentSupplier = createElement(supplier, pack, baseJointpoints, model);
				}
			}
			newManifestation.getSuppliers().add(equivalentSupplier);
			newManifestation.setUtilizedElement((PackageableElement)equivalentSupplier);
		}
		
		inContainer.getPackagedElements().add(newManifestation);		
		
		return newManifestation;
	}

	private static InstanceSpecification createInstanceSpecification(InstanceSpecification instance,
			Package inContainer, HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		InstanceSpecification newInstance = UMLFactory.eINSTANCE.createInstanceSpecification();
		newInstance.setName(instance.getName());
		newInstance.setSpecification(instance.getSpecification());
		
		//Resolve classifiers in base model
		for (Classifier classifier: instance.getClassifiers()){
			Classifier equivalentClassifier = (Classifier)getEquivalentElementInModel(classifier, model);
			newInstance.getClassifiers().add(equivalentClassifier);
		}
		
		//Create slots
		for (Slot slot: instance.getSlots()){
			createSlot (slot, newInstance, baseJointpoints, model);
		}
		 
		ModelAdapterUtilities.addElementInPackage(newInstance, inContainer);
		return newInstance;
	}

	private static Slot createSlot(Slot slot, InstanceSpecification inInstanceSpecification,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		// Creates the new slot referencing new object
		ValueSpecification vs = slot.getValues().get(0);
		Slot newSlot = inInstanceSpecification.createSlot();
		//Resolve defining feature in base model
		StructuralFeature equivalentDefiningFeature = (StructuralFeature)getEquivalentElementInModel(slot.getDefiningFeature(), model);
		//FIXME Check that in ComposableInstanceSpecification missing defining features are not checked nor created if missed
		if (equivalentDefiningFeature == null){
			Package pack  = getPackageInModel (slot.getDefiningFeature().getNearestPackage(), model);
			if (pack != null){
				equivalentDefiningFeature = createElement(slot.getDefiningFeature(), slot.getDefiningFeature().getNearestPackage(), baseJointpoints, model);
		
			}
		}
		newSlot.setDefiningFeature(equivalentDefiningFeature);
		createValue(newSlot, vs, baseJointpoints, model);

		newSlot.setOwningInstance(inInstanceSpecification);
		return newSlot;
	}
	
	private static void createValue (Slot slot, ValueSpecification vs, HashMap<Stereotype, List<Element>> baseJointpoints, Model model){
		ValueSpecification newVs = slot.createValue(vs.getName(), vs.getType(), vs.eClass());
		if (vs instanceof InstanceValue){
			InstanceSpecification equivalentInstance = (InstanceSpecification)getEquivalentElementInModel(((InstanceValue) vs).getInstance(), model);
			//FIXME Check that in ComposableInstanceSpecification missing defining features are not checked nor created if missed
			if (equivalentInstance == null){
				Package pack  = getPackageInModel (((InstanceValue) vs).getInstance().getNearestPackage(), model);
				if (pack != null){
					equivalentInstance = createElement(((InstanceValue) vs).getInstance(), pack, baseJointpoints, model);
				}
			}
			((InstanceValue)newVs).setInstance(equivalentInstance);
		}else if (vs instanceof LiteralString){
			((LiteralString)newVs).setValue(((LiteralString)vs).getValue());
		}else if (vs instanceof LiteralReal){
			((LiteralReal)newVs).setValue(((LiteralReal)vs).getValue());
		}else if (vs instanceof LiteralInteger){
			((LiteralInteger)newVs).setValue(((LiteralInteger)vs).getValue());
		}else{
			//Ignored
		}
	}

	private static Package createPackage(Package pack, Model container,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		Package newPackage = UMLFactory.eINSTANCE.createPackage();
		newPackage.setName(pack.getName());
		Package nestingPackage = (Package) getEquivalentElementInModel(pack.getNestingPackage(), container);
		if (nestingPackage != null) {
			newPackage.setNestingPackage(nestingPackage);
		} else {
			newPackage.setNestingPackage(createPackage(pack.getNestingPackage(), container, baseJointpoints, model));
		}
		return newPackage;
	}

	private static Property createProperty(Property property, Class inClass,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		// Resolve type if refers to Jointpoint role: from base model JP role
		// element resolves advice type
		// Resolve type pointing to base model.
		// Resolve types pointing to the base model
		// Resolve type in case of advice jointpoint role type

		Type type = (Type) resolveElementInModel(property.getType(), inClass.getModel(), baseJointpoints);

		// Non-association property
		Association association = property.getAssociation();
		Property newProperty = null;
		if (association == null) {
			newProperty = inClass.createOwnedAttribute(property.getName(), type);
		} else {
			// Manage association properties
			Association newAssociation = createAssociation(association, inClass, baseJointpoints, model);
			newProperty = inClass.getAttributes().get(inClass.getAttributes().size() - 1);
		}
		return newProperty;
	}

	private static Operation createOperation(Operation operation, Class inClass,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		// Resolve type (for parameter and return type) if refers to Jointpoint
		// role: from base model JP role element resolves advice type
		// Resolve type (for parameter and return type) pointing to base model.
		EList<String> parameterNames = new BasicEList<>();
		EList<Type> parameterTypes = new BasicEList<>();
		for (Parameter parameter : operation.getOwnedParameters()) {
			parameterNames.add(parameter.getName());
			// Resolve types pointing to the base model
			// Resolve type in case of advice jointpoint role type
			parameterTypes.add((Type) resolveElementInModel(parameter.getType(), inClass.getModel(), baseJointpoints));
		}
		Type returnType = null;
		if (operation.getReturnResult() != null)
			returnType = (Type) resolveElementInModel(operation.getReturnResult().getType(), inClass.getModel(),
					baseJointpoints);
		return inClass.createOwnedOperation(operation.getName(), parameterNames, parameterTypes, returnType);
	}

	private static Association createAssociation(Association association, Class inClass,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		Association newAssociation = inClass.createAssociation(association.getMemberEnds().get(0).isNavigable(),
				association.getMemberEnds().get(0).getAggregation(), association.getMemberEnds().get(0).getName(),
				association.getMemberEnds().get(0).getLower(), association.getMemberEnds().get(0).getUpper(),
				(Type) resolveElementInModel(association.getMemberEnds().get(0).getType(), inClass, baseJointpoints),
				association.getMemberEnds().get(1).isNavigable(), association.getMemberEnds().get(1).getAggregation(),
				association.getMemberEnds().get(1).getName(), association.getMemberEnds().get(1).getLower(),
				association.getMemberEnds().get(1).getUpper());

		return newAssociation;
	}

	private static Class createClass(Class clazz, Package inContainer,
			HashMap<Stereotype, List<Element>> baseJointpoints, Model model) {
		Class newClass = inContainer.createOwnedClass(clazz.getName(), clazz.isAbstract());

		// Properties
		for (Property property : clazz.getAttributes()) {
			createProperty(property, newClass, baseJointpoints, model);
		}
		// Operations
		for (Operation operation : clazz.getOperations()) {
			createOperation(operation, newClass, baseJointpoints, model);
		}

		return newClass;
	}

	public static Element resolveElementInModel(Element type, PackageableElement inContainer,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		// Resolve type in model.
		// If type stereotype with Jointpoint role, resolve it in model by role
		// If type does not exist in model, create type and add it to model
		Element resolvedElement = getEquivalentElementInModel((PackageableElement) type, inContainer.getModel());
		if (resolvedElement == null) {
			// Resolve type the Jointpoint role
			// Current resolution is based on stereotyped applications by
			// jointpoint role
			// but in base model jointpoint are determine by patterns, which are
			// passed in baseJointpoints
			for (Stereotype stereotype : baseJointpoints.keySet()) {
				if (type.isStereotypeApplied(stereotype)) {
					// FIXME Investigate possible multiple role assignments
					resolvedElement = baseJointpoints.get(stereotype).get(0); 
					break;
				}
			}
		}
		if (resolvedElement == null) {
			// Get equivalent type container in model. Create it if not
			// available
			Package pack = (Package) resolveElementInModel(type.getNearestPackage(), inContainer, baseJointpoints);
			if (pack == null) {
				pack = createElement(type.getNearestPackage(), inContainer, baseJointpoints, inContainer.getModel());
			}

			// Create type
			resolvedElement = createElement(type, pack, baseJointpoints, inContainer.getModel());
		}

		return resolvedElement;
	}

	public static Property resolvePropertyInClass(Property property, Class inClass,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		Property found = null;
		for (Property p : inClass.getAttributes()) {
			if (propertyMatchAnotherInModel(p, property, inClass.getModel(), baseJointpoints)) {
				found = p;
				break;
			}
		}
		return found;
	}

	private static boolean propertyMatchAnotherInModel(Property p1, Property p2, Model model,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		boolean match = false;
		if (p1.getName().equals(p2.getName())
				&& p1.getType() == ModelAdapterUtilities.resolveElementInModel(p2.getType(), model, baseJointpoints)) {
			match = true;
		}
		return match;
	}

	public static Operation resolveOperationInClass(Operation operation, Class inClass,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		Operation found = null;
		for (Operation oper : inClass.getOperations()) {
			if (operationMatchAnotherInModel(oper, operation, inClass.getModel(), baseJointpoints)) {
				found = oper;
				break;
			}
		}
		return found;
	}

	private static boolean operationMatchAnotherInModel(Operation oper, Operation operation, Model model,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		boolean match = false;
		// Comparing operation names
		if (oper.getName().equals(operation.getName())) {
			// Comparing return types
			if (operationReturnTypeMatchAnotherInModel(oper.getReturnResult(), operation.getReturnResult(), model,
					baseJointpoints)) {
				match = true;
				// Comparing parameters
				for (Parameter param : oper.getOwnedParameters()) {
					if (!parameterMatchAnotherInOperationInModel(param, operation, model, baseJointpoints)) {
						match = false;
						break;
					}
				}
			}
		}
		return match;
	}

	private static boolean parameterMatchAnotherInOperationInModel(Parameter param, Operation operation, Model model,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		boolean match = true;
		for (Parameter p : operation.getOwnedParameters()) {
			if (!p.getName().equals(param.getName()) || !(p.getType() == ModelAdapterUtilities
					.resolveElementInModel(param.getType(), model, baseJointpoints))) {
				match = false;
				break;
			}
		}
		return match;
	}

	private static boolean operationReturnTypeMatchAnotherInModel(Parameter param1, Parameter param2, Model model,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		if (param1 == null && param2 == null) {
			return true;
		} else {
			return parameterTypeMatchAnotherInModel(param1, param2, model, baseJointpoints);
		}
	}

	private static boolean parameterTypeMatchAnotherInModel(Parameter param1, Parameter param2, Model model,
			HashMap<Stereotype, List<Element>> baseJointpoints) {
		boolean match = true;

		// Both Param1 and param 2 must exist
		if (param1 != null && param2 != null) {
			match = param1.getType() == ModelAdapterUtilities.resolveElementInModel(param2.getType(), model,
					baseJointpoints);
		}

		return match;
	}

	/**
	 * returns true if element matches (by name) any of those included in
	 * listOfElements FIXME Improve matching by name to more elaborated matching
	 * by type
	 * 
	 * @param element
	 * @param listOfElements
	 * @return
	 */
	public static <T extends NamedElement> boolean elementMatchesInList(T element, EList<T> listOfElements) {
		boolean match = false;
		for (T e : listOfElements) {
			if (e.getName().equals(element.getName())) {
				match = true;
				break;
			}
		}
		return match;
	}

	public static Set<Classifier> findSubclassesOfType(Class classVariant, Model model) {
		// Use Model Query to find subclasses
		Set<Classifier> result = new HashSet<>();
		try {
			IModelManager modelManager = new ModelManager(false);
			modelManager.getResourceSet().getResources().add(model.eResource());
			ModelQuery modelQuery = new ModelQuery(modelManager, model.eResource());
			SubClassOfMatcher matcher = (SubClassOfMatcher) modelQuery
					.queryMatcher(SubClassOfQuerySpecification.instance());
			Set<Classifier> subClasses = matcher.getAllValuesOfsubclass(classVariant);
			// Filtering out instances that do not belong to target model
			for (Classifier subClass : subClasses) {
				if (ModelAdapterUtilities.modelContainsElement(subClass, model)) {
					result.add(subClass);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean elementIsReferencedInModel(Class type, Model model) {
		// Use Model Query to find subclasses
		Set<Element> result = new HashSet<>();
		try {
			IModelManager modelManager = new ModelManager(false);
			modelManager.getResourceSet().getResources().add(model.eResource());
			ModelQuery modelQuery = new ModelQuery(modelManager, model.eResource());
			GetReferenceToTypeMatcher matcher = (GetReferenceToTypeMatcher) modelQuery
					.queryMatcher(GetReferenceToTypeQuerySpecification.instance());
			Set<Element> references = matcher.getAllValuesOfelement(type);
			// Filtering out instances that do not belong to target model
			for (Element reference : references) {
				if (ModelAdapterUtilities.modelContainsElement((NamedElement) reference, model)) {
					result.add(reference);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !result.isEmpty();
	}
	
//	public static Set<InstanceSpecification> getReferencingInstanceSpecificationLinks(InstanceSpecification instance, Model model) {
//		Set<InstanceSpecification> instances = null;
//	
//		try {
//			IModelManager modelManager = new ModelManager(false);
//			modelManager.getResourceSet().getResources().add(model.eResource());
//			ModelQuery modelQuery = new ModelQuery(modelManager, model.eResource());
//			InstanceOfInstanceSpecificationLinkMatcher matcher = 
//					(InstanceOfInstanceSpecificationLinkMatcher) modelQuery.queryMatcher(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
//			instances = matcher.getAllValuesOfinstance(instance);
//			//Filtering out instances that do not belong to target model
//			for (InstanceSpecification instanceSpecification: instances){
//				if (!ModelAdapterUtilities.modelContainsElement(instanceSpecification, model)){
//					instances.remove(instanceSpecification); //FIXME instances are unmutable so this won't work
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return instances;
//	}

	public static List<Association> getAssociationsOfClass(Class clazz) {
		List<Association> associations = new ArrayList<>();
		for (Property property : clazz.getAttributes()) {
			if (property.getAssociation() != null) {
				associations.add (property.getAssociation());
			}
		}
		return associations;
	}
}
