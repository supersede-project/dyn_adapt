package eu.supersede.dynadapt.modeladapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.modeladapter.queries.GetManifestationsMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.GetManifestationsQuerySpecification;

public class ComposableExecutionEnvironment extends ComposableImpl implements Composable {
	private final Logger log = LogManager.getLogger(this.getClass());
	
	public ComposableExecutionEnvironment (IModelQuery modelQuery, HashMap<Stereotype, List<Element>> baseJointpoints){
		super (modelQuery, baseJointpoints);
	}

	@Override
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		// Look in Variant model for manifestations whose client is the jointpointVariantModelElement
		// For each found manifestation, 
		// IF manifestation does not exist in base model, create manifestation
		// Take manifestation supplier
		// IF supplier does not exist in base model, create it
		// For created supplier, follow slots to create other instance specifications
		// FIXME: Reuse instance specification creation methods in ComposableInstanceSpecification
		Set<Manifestation> manifestations = getManifestationForExecutionEnvironment ((ExecutionEnvironment)jointpointVariantModelElement);
		for (Manifestation manifestation: manifestations){
			if (!ModelAdapterUtilities.modelContainsElement(manifestation, inBaseModel)){
				log.debug("Adding detected manifestation in variant model, from client: " 
					+ manifestation.getClients().get(0).getQualifiedName()
					+ " to utilized element: " + manifestation.getUtilizedElement().getQualifiedName());
				addManifestationInModel (manifestation, inBaseModel);
			}
		}
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
	
	private void addManifestationInModel(Manifestation manifestation, Model model) {
		// Locate manifestation container. Add it to model if it does not exist
		// Create manifestation
		Package pack  = ModelAdapterUtilities.getPackageInModel (manifestation.getNearestPackage(), model);
		if (pack != null){
			Manifestation newManifestation = 
				ModelAdapterUtilities.createElement (manifestation, pack, baseJointpoints, model);
		}
	}

	
	private Set<Manifestation> getManifestationForExecutionEnvironment(ExecutionEnvironment execEnv) {
		Set<Manifestation> result = new HashSet<>();
		try {
			GetManifestationsMatcher matcher = 
					(GetManifestationsMatcher) modelQuery.queryMatcher(GetManifestationsQuerySpecification.instance());
			Set<Manifestation> manifestationMatches = matcher.getAllValuesOfmanifestation();
			//Filtering out manifestations whose client is not the given execution environment
			for (Manifestation manifestation: manifestationMatches){
				if (manifestationContainsElementAsClient (manifestation, execEnv)){
					result.add(manifestation); 
				}
			}
		} catch (ViatraQueryException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean manifestationContainsElementAsClient(Manifestation manifestation, ExecutionEnvironment execEnv) {
		boolean result = false;
		for (NamedElement client: manifestation.getClients()){
			if (client.getQualifiedName().equals(execEnv.getQualifiedName())){
				result = true;
				break;
			}
		}
		return result;
	}

}
