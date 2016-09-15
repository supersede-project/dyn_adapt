package eu.supersede.dynadapt.model;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Profile;

public interface IModelManager {

	/**
	 * Loads the UML base model resource from the passed file and returns this Resource object.
	 * 
	 * @param file
	 *            IFile object to be loaded as the resource
	 * @return Resource object loaded from the passed file
	 */
	Resource loadResource(String targetModelPath);

	/**
	 * Loads the profile of the given name and returns this Profile object.
	 * 
	 * @param profileFileName
	 *            Name of the file to be loaded as a profile
	 * @return Profie loaded from the file
	 */
	Profile loadProfile(String profilePath);

	/**
	 * Returns the associated UML base target model
	 * @return the associated UML base target model
	 */
	Resource getTargetModel();

	/**
	 * @throws IOException 
	 * Save a model resource included in current resource set, into the outputModelURI recipient, adding suffixe to that URI
	 * @param modelResource
	 * @param outputModelURI
	 * @param suffixe
	 * @throws  
	 */
	URI saveModel(Resource modelResource, URI outputModelURI, String suffixe) throws IOException;

	/**
	 * Saves a copy of associated target model adding given suffixe to the original target model name
	 * @param suffixe suffixe added to the original target model name 
	 * @return locator for saved model
	 * @throws IOException
	 */
	URI saveTargetModel(String suffixe) throws IOException;
	
	/**
	 * Saves a associated target model replacing original file
	 * @return locator for saved model
	 * @throws IOException
	 */
	URI saveTargetModel() throws IOException;
	
//	/**
//	 * Regiser given model into the ModelManager resource set
//	 * @param ePackage model to register
//	 * @see org.eclipse.uml2.uml.resource.UMLResource
//	 */
//	void registerPackage (EPackage ePackage);
	
	/**
	 * Loads the model resource with the given uri into this resource set. If
	 * no such resource is found or the root object is not an instance of the
	 * given class, null is returned.
	 * 
	 * @param uri uri of the model to be loaded
	 * @param clazz class the model resource should have
	 * @return model resource with the given uri or null.
	 */

	<T extends EObject> T loadModel(URI uri, Class<T> clazz);

}