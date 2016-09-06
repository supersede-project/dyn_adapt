package eu.supersede.dynadapt.model.tagger;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

public interface IModelTagger {
	public void tagModel(NamedElement element, Profile profile, Stereotype stereotype) throws Exception;
	public void tagModel(NamedElement element, Profile profile, String stereotypeName) throws Exception;
	public void tagModel(NamedElement element, String profileURI, String stereotypeName) throws Exception;
}
