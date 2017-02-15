package eu.supersede.dynadapt.modeladapter;

import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import eu.supersede.dynadapt.model.query.IModelQuery;

public class ComposableImpl {
	protected IModelQuery modelQuery; //FIXME: Remove need of model query. Create one targeting concrete model on demand. @see ModelAdapterUtilities
	protected HashMap<Stereotype, List<Element>> baseJointpoints;
	
	public ComposableImpl (IModelQuery modelQuery, HashMap<Stereotype, List<Element>> baseJointpoints){
		this.modelQuery = modelQuery;
		this.baseJointpoints = baseJointpoints;
	}
}
