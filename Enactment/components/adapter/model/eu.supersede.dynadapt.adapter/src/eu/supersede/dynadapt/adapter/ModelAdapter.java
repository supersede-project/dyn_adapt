package eu.supersede.dynadapt.adapter;

import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.AssociationImpl;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;

@SuppressWarnings("restriction")
public class ModelAdapter implements IModelAdapter {
	
	private final String CLASS = "ClassImpl";
	private final String INSTANCE = "InstanceSpecificationImpl";
	private final String ATTRIBUTE = "SlotImpl";
	
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
				
				Slot newSlot = instanceBase.createSlot();
				newSlot.setDefiningFeature(s.getDefiningFeature());
				newSlot.createValue(v.getName(), v.getType(), v.eClass());
			}
			
		} else {
			//TODO future use cases
		}
		
		return inBaseModel;
		
		/*if (type.equals(CLASS) || type.equals(INSTANCE)) {
			for (Relationship r : jointpointVariantModelElement.getRelationships()) {
				System.out.println("Relationship: " + ((NamedElement) r).getName());
				for (Element e : r.getRelatedElements()) {
					if (!e.equals(jointpointVariantModelElement)) {
						ClassImpl classEnt = (ClassImpl) e;
						System.out.println("Element: " + ((NamedElement) e).getName());
						if (type.equals(CLASS)) {
							Class c = ((Package)inBaseModel.getPackagedElement("Components")).createOwnedClass(
									classEnt.getName(), classEnt.isAbstract());
							for (Property p : classEnt.getAllAttributes()) c.createOwnedAttribute(p.getName(), p.getType());
							//TODO create associations
						} else if (type.equals(INSTANCE)) {
							//TODO create instances
						}
					}
					
				}
			}			
		}
		else if (type.equals(ATTRIBUTE)) {
			String baseType = jointpointBaseModelElement.getClass().getSimpleName();
			Property slot = (Property) jointpointVariantModelElement;
			
			if (baseType.equals(CLASS)) {
				ClassImpl classEnt = (ClassImpl) jointpointBaseModelElement;
				classEnt.createOwnedAttribute(slot.getName(), slot.getType());
				
			} else {
				//TODO study different situations
				throw new Error("Invalid element type");
			}
			
		}
		
		return inBaseModel;*/
		
	}

	@Override
	public Model applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) throws Exception {
		
		List<Element> elements = null;
		String type = jointpointVariantModelElement.getClass().getSimpleName();
		
		if (type.equals(CLASS) || type.equals(INSTANCE)) {
			NamedElement el = (NamedElement) jointpointVariantModelElement;
			String s;
			if (type.equals(CLASS)) s = "Components";
			else s = "Instances";
			elements = inBaseModel.getPackagedElement(s).getOwnedElements();
			Element rm = null;
			//Navigate through all the components
			for (Element e : elements) {
				//If the class name matches then we keep the reference
				if (((NamedElement) e).getQualifiedName().equals(el.getQualifiedName())) {
					rm = e;
				}
			}
			//Delete all references
			for (Relationship r : rm.getRelationships()) {
				AssociationImpl a = (AssociationImpl) r;
				for (Element e : a.getMemberEnds()) {
					e.destroy();
				}
				r.destroy();
			}
			//Delete the element itself
			rm.destroy();
			
		} else if (type.equals(ATTRIBUTE)) {
			
			String baseType = jointpointBaseModelElement.getClass().getSimpleName();
			Property slot = (Property) jointpointVariantModelElement;
			
			if (baseType.equals(CLASS)) {
				ClassImpl classEnt = (ClassImpl) jointpointBaseModelElement;
				classEnt.getOwnedAttribute(slot.getName(), slot.getType()).destroy();;
			} else {
				throw new Error("Invalid element type");
				//TODO study different situations
			}
			
		} else throw new Error("Invalid element type");
		
		return inBaseModel;
		
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
				
		System.out.println(jointpointBaseModelProperty.getApplicableStereotypes());
		
		return inBaseModel;
	}

}
