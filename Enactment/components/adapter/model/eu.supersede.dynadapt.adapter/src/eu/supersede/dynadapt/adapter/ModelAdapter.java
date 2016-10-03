package eu.supersede.dynadapt.adapter;

import java.util.HashMap;
import java.util.List;

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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;

@SuppressWarnings("restriction")
public class ModelAdapter implements IModelAdapter {
	
	private final String INSTANCE = "InstanceSpecificationImpl";
	private final String CLASS = "ClassImpl";

	@Override
	public Model applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		
		String type = jointpointVariantModelElement.getClass().getSimpleName();
		
		if (type.equals(INSTANCE)) {

			InstanceSpecificationImpl instanceBase = (InstanceSpecificationImpl) jointpointBaseModelElement;
			InstanceSpecificationImpl instanceVariant = (InstanceSpecificationImpl) jointpointVariantModelElement;
			for (int i = 0; i < instanceVariant.getSlots().size(); ++i) {
				Slot s = instanceVariant.getSlots().get(i);
				ValueSpecification v = s.getValues().get(0);
				//Creates the new slot referencing new object
				Slot newSlot = instanceBase.createSlot();
				newSlot.setDefiningFeature(s.getDefiningFeature());
				newSlot.createValue(v.getName(), v.getType(), v.eClass());
				newSlot.setOwningInstance(instanceBase);
				InstanceValue baseInst = (InstanceValue) newSlot.getValues().get(0);
				InstanceValue variantInst = (InstanceValue) s.getValues().get(0);
				//Adds the instance to the model in the proper package
				InstanceSpecification newInstance = variantInst.getInstance();
				baseInst.getNearestPackage().getPackagedElements().add(newInstance);
				//Creates the reference between base object and referenced object in base model
				baseInst.setInstance(newInstance);
				//Creates the instance relationship
				for (Relationship a : newInstance.getClassifiers().get(0).getRelationships()) {
					if (a.getRelatedElements().contains(instanceBase.getClassifiers().get(0)) 
							&& a.getRelatedElements().contains(newInstance.getClassifiers().get(0))) {
						InstanceSpecification rel = (InstanceSpecificationImpl) UMLFactory.eINSTANCE.createInstanceSpecification();
						rel.setName("InstanceSpecificationLink_" + instanceBase.getName() + "_to_" + newInstance.getName());
						rel.getClassifiers().add((Classifier) a);
						addReference(rel, instanceBase, a);
						baseInst.getNearestPackage().getPackagedElements().add(rel);
					}
				}
			}
		} else {
			
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
			
			HashMap<String, Slot> destroy = new HashMap<>();
			
			for (int i = 0; i < instanceBase.getSlots().size(); ++i) {
				Slot sb = instanceBase.getSlots().get(i);
				for (int j = 0; j < instanceVariant.getSlots().size(); ++j) {
					Slot sv = instanceVariant.getSlots().get(j);
					InstanceValue baseInst = (InstanceValue) sb.getValues().get(0);
					InstanceValue variantInst = (InstanceValue) sv.getValues().get(0);
					
					if (baseInst.getInstance().getName().equals(variantInst.getInstance().getName())) {
						//Destroy instance and references
						destroy.put(baseInst.getInstance().getName(), sb);
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
			for (Slot s : destroy.values()) s.destroy();
			
		} else if (type.equals(CLASS)){
			
			ClassImpl classBase = (ClassImpl) jointpointBaseModelElement;
			ClassImpl classVariant = (ClassImpl) jointpointVariantModelElement;
			//For each relationship of the class
			for (int i = 0; i < classVariant.getRelationships().size(); ++i) {
				Relationship r1 = classVariant.getRelationships().get(i);
				for (int j = 0; j < classBase.getRelationships().size(); ++j) {
					Relationship r2 = classBase.getRelationships().get(j);
					if (checkSameRelationship(r1,r2)) {
						ClassImpl deleteClass = null;
						if (!r2.getRelatedElements().get(0).equals(classBase)) {
							deleteClass = (ClassImpl) r2.getRelatedElements().get(0);
						} else deleteClass = (ClassImpl) r2.getRelatedElements().get(1);
						r2.destroy();
						deleteClass.destroy();
						break;
					}
				}
				
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
	public Model applyModifyValueComposition(Model inBaseModel, Slot jointpointBaseModelSlot, 
			ValueSpecification newValue) {
		
		StructuralFeature feat = jointpointBaseModelSlot.getDefiningFeature();
		for (Element e : jointpointBaseModelSlot.allOwnedElements()) {
			e.destroy();
		}
		
		if (feat.getType().getName().equals("Integer")) {
			LiteralInteger value =(LiteralInteger) jointpointBaseModelSlot.createValue("", feat.getType(), UMLPackage.eINSTANCE.getLiteralInteger());
			value.setValue(newValue.integerValue());
		} else if (feat.getType().getName().equals("Boolean")) {
			LiteralBoolean value =(LiteralBoolean) jointpointBaseModelSlot.createValue("", feat.getType(), UMLPackage.eINSTANCE.getLiteralBoolean());
			value.setValue(newValue.booleanValue());
		} else if (feat.getType().getName().equals("String")) {
			LiteralString value =(LiteralString) jointpointBaseModelSlot.createValue("", feat.getType(), UMLPackage.eINSTANCE.getLiteralString());
			value.setValue(newValue.stringValue());
		} else if (feat.getType().getName().equals("Real")) {
			LiteralReal value =(LiteralReal) jointpointBaseModelSlot.createValue("", feat.getType(), UMLPackage.eINSTANCE.getLiteralReal());
			value.setValue(newValue.realValue());
		}
		
		return inBaseModel;
	}
	
	/**
	 * Given a pair of instances, retrieves the Relationship ref object of the relationship 
	 * @param e1	parent instance
	 * @param e2	child instance
	 * @return		relationship
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
	 * @param rel
	 * @param instanceBase
	 */
	private void addReference(InstanceSpecification e1, InstanceSpecification e2, Relationship r) {
		//Creates the new slot
		Slot relSlot = e1.createSlot();
		Property p = (Property) r.getOwnedElements().get(0);
		relSlot.setDefiningFeature(p);
		//Adds the reference to the instance value
		InstanceValue v = UMLFactory.eINSTANCE.createInstanceValue();
		v.setInstance(e2);
		InstanceValue value = (InstanceValue) relSlot.createValue("InstanceValue1", v.getType(), v.eClass());
		value.setInstance(e2);
		//relSlot.setDefiningFeature((StructuralFeature) e2.eGet(e2.eClass().getEStructuralFeature("classifier")));
	}
	
	/**
	 * Checks if the object a is an instance specification of the relationship r with parent instance baseInst
	 * @param a
	 * @param r
	 * @param baseInst
	 * @return
	 */
	private boolean isAssociationInstance(EObject a, Relationship r, InstanceSpecification baseInst) {
		if (a.eClass().getName().equalsIgnoreCase("InstanceSpecification")) {
			EObject aa = (EObject) ((EObjectResolvingEList<?>) a.eGet(a.eClass().getEStructuralFeature("classifier"))).get(0);
			if (aa.eGet(aa.eClass().getEStructuralFeature("name")) != null &&
					(aa.eGet(aa.eClass().getEStructuralFeature("name")).
							equals(r.eGet(r.eClass().getEStructuralFeature("name"))))) {
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
			if (!found) return false;
		}
		return true;
	}

}
