package eu.supersede.dynadapt.adapter;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

public interface IModelAdapter {
	
	public Model applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) throws Exception;
	
	public Model applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) throws Exception;
	
	public Model applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel, Element jointpointVariantModelElement) throws Exception;
	
	public Model applyModifyValueComposition(Model inBaseModel, Property jointpointBaseModelProperty, Model usingVariantModel, ValueSpecification newValue) throws Exception;

}
