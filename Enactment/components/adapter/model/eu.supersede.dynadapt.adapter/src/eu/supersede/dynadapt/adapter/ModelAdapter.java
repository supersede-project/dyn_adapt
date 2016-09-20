package eu.supersede.dynadapt.adapter;

import java.util.List;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ValueSpecification;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) throws Exception {
		
		List<Element> elements = null;
								
		switch (jointpointVariantModelElement.getClass().getSimpleName()) {
			
			case CLASS:
				ClassImpl classEl = (ClassImpl) jointpointVariantModelElement;
				elements = inBaseModel.getPackagedElement("Components").getOwnedElements();
								
				Element rm = null;
				
				for (Element e : elements) {
					if (((ClassImpl) e).getQualifiedName().equals(classEl.getQualifiedName())) {
						rm = e;
					}
					System.out.println(e.getOwnedElements());
				}
				
				
				for (Relationship r : rm.getRelationships()) r.destroy();
				rm.destroy();
				
				break;
			
			case INSTANCE:
				InstanceSpecificationImpl instance = (InstanceSpecificationImpl) jointpointVariantModelElement;
				elements = inBaseModel.getPackagedElement("Instances").getOwnedElements();
				for (Element e : elements) {
					if (((ClassImpl) e).getQualifiedName().equals(instance.getQualifiedName())) {
						deleteAllReferencedElements(e);
					}
				}
				break;
			
			case ATTRIBUTE:
				//TODO delete attribute from class
				break;
			
			default:
				throw new Exception("Invalid element type");
		
		}
						
		for (int i = 0; i < inBaseModel.getPackagedElement("Instances").getOwnedElements().size(); ++i) {
			InstanceSpecificationImpl instance = ((InstanceSpecificationImpl) inBaseModel.getPackagedElement("Instances").getOwnedElements().get(i));
			if (instance.getLabel().equals("CMS Default Configuration Instance"))
				instance.destroy();
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
	public Model applyModifyValueComposition(Model inBaseModel, Property jointpointBaseModelProperty,
			Model usingVariantModel, ValueSpecification newValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void deleteAllReferencedElements(Element e) {
		
		for (Element el : e.getOwnedElements()) el.destroy();
		
		
	}

}
