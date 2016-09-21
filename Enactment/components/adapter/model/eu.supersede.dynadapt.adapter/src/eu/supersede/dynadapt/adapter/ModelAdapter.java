package eu.supersede.dynadapt.adapter;

import java.util.List;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
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
		// TODO Auto-generated method stub
		return null;
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
				for (Element e : a.getMemberEnds()) e.destroy();
				r.destroy();
			}
			//Delete the element itself
			rm.destroy();
			
		} else if (type.equals(INSTANCE)) {
			
		} else if (type.equals(ATTRIBUTE)) {
			
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

}
