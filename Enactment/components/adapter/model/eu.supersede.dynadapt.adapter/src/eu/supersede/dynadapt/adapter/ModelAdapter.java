package eu.supersede.dynadapt.adapter;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;

@SuppressWarnings("restriction")
public class ModelAdapter implements IModelAdapter {
	
	private final String INSTANCE = "InstanceSpecificationImpl";
		
	public void stereotypeElement(Element element, Stereotype withRole) {
		
	}
	
	public void applyCompositionDirective(CompositionDirective compositionDirective, Model inBaseModel, Stereotype forRoleStereotype, Model usingVariantModel) {
		
	}

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
						Slot relSlot = rel.createSlot();
						relSlot.setOwningInstance(rel);
						
						//TODO add reference to owner of relationship
						
						baseInst.getNearestPackage().getPackagedElements().add(rel);
						
					}
				}
			}
			
		} else {
			//TODO future use cases
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
			
		} else {
			//TODO future use cases
		}
		
		return inBaseModel;
		
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

	@Override
	public Model applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model applyModifyValueComposition(Model inBaseModel, Property jointpointBaseModelProperty, 
			ValueSpecification newValue) {
				
		
		
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

}
