package eu.supersede.dynadapt.modeladapter;

import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;

import eu.supersede.dynadapt.model.query.IModelQuery;

public class ComposableExecutionEnvironment extends ComposableImpl implements Composable {
	
	public ComposableExecutionEnvironment (IModelQuery modelQuery, HashMap<Stereotype, List<Element>> baseJointpoints){
		super (modelQuery, baseJointpoints);
	}

	@Override
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Look in Variant model for manifestations whose client is the jointpointVariantModelElement
		// For each found manifestation, 
		// IF manifestation does not exist in base model, create manifestation
		// Take manifestation supplier
		// IF supplier does not exist in base model, create it
		// For created supplier, follow slots to create other instance specifications
		// FIXME: Reuse instance specification creation methods in ComposableInstanceSpecification
		

	}

	@Override
	public void applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// TODO Auto-generated method stub

	}

}
