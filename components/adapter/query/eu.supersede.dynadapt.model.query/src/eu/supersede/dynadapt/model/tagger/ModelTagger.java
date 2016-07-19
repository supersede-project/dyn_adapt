package eu.supersede.dynadapt.model.tagger;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;

public class ModelTagger implements IModelTagger{
	private ModelManager modelManager = null;
	private static final String OUTPUT_FILE_SUFFIX = "_tagged.uml";
	private Profile profile;
	private Package rootPackage;
	
	/**
	 * Creates an instance of ModelTagger that tags model elements with referenced profile stereotypes
	 * @param targetModelPath
	 */
	public ModelTagger (ModelManager modelManager){
		this.modelManager = modelManager;
	}
	
	public void tagModel(NamedElement element, Profile profile, String stereotypeName)
			throws Exception {
		// Get the root package
		rootPackage = element.getNearestPackage();

		// Tag the model
		if (rootPackage.getAppliedProfile(profile.getQualifiedName()) == null) {
			rootPackage.applyProfile(profile);
		}
		Stereotype stereotype = profile.getOwnedStereotype(stereotypeName);
		if (element.getAppliedStereotype(stereotype.getQualifiedName()) == null) {
			element.applyStereotype(stereotype);
			System.out.println ("Tagged element " + element.getQualifiedName() + " with stereotype " + stereotype.getQualifiedName());
		}
	}

	public void tagModel(NamedElement element, String profileURI, String stereotypeName)
			throws Exception {
		profile = modelManager.loadProfile(profileURI);
		tagModel(element, profile, stereotypeName);
	}
	
//	public static void main (String[] args) throws Exception{
//		String modelPath = "../models/atos_base_model.uml";
//		String profilePath = "../models/adm.profile.uml";
//		String patternModelPath = "../models/atos_queries.vql";
//		String patternFQN = "eu.supersede.dynadapt.atos.queries.nodeArtifacts";
//		
//		ModelManager modelManager = new ModelManager (modelPath);
//		
//		IModelQuery modelQuery = new ModelQuery (modelManager);
//		
//		String[] parameters = new String[]{"artifact"};
//		Collection <Map<String, Object>>results = modelQuery.query(patternFQN, patternModelPath, Arrays.asList(parameters));
//		
//		//Selecting first artifact match of nodeArtifacts search
//		NamedElement element = (NamedElement) (results.isEmpty()?null:results.iterator().next().get(parameters[0]));
//		
//		IModelTagger tagger = new ModelTagger(modelManager);
//		tagger.tagModel(element, profilePath, "Joinpoint");
//		
//		modelManager.saveTargetModel(OUTPUT_FILE_SUFFIX);
//	}
}
