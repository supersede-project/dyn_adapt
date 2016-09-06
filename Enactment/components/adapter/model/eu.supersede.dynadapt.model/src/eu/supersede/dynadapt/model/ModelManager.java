package eu.supersede.dynadapt.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class ModelManager implements IModelManager {
	private static ResourceSet resourceSet = new ResourceSetImpl();
	private Resource targetModelResource = null;
	private URI targetModelURI = null;
	
	/**
	 * Static registration of common EMF metamodels for Ecore, UML2
	 * Registration of UML extension
	 */
	static {
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		UMLResourcesUtil.init(resourceSet);
		Map<URI,URI> uriMap = resourceSet.getURIConverter().getURIMap();
//		final URI uri2 = URI.createURI("jar:file:/home/yosu/Projects/Supersede/Eclipses/eclipse-mars-modeling/plugins/org.eclipse.uml2.uml.resources_5.1.0.v20160201-0816.jar!/");
		final URI uri2 = URI.createURI("jar:file:./lib/org.eclipse.uml2.uml.resources_5.1.0.v20160201-0816.jar!/");
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri2.appendSegment("libraries").appendSegment(""));
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri2.appendSegment("metamodels").appendSegment(""));
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri2.appendSegment("profiles").appendSegment(""));
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#registerPackage(org.eclipse.emf.ecore.EPackage)
	 */
	public void registerPackage (EPackage ePackage){
		resourceSet.getPackageRegistry().put (ePackage.getNsURI(), ePackage);
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#loadResource(java.lang.String)
	 */
	@Override
	public Resource loadResource(String targetModelPath) {
		return resourceSet.getResource(URI.createURI(targetModelPath), true);
	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#loadProfile(java.lang.String)
	 */
	@Override
	public Profile loadProfile(String profilePath) {

		Resource resource = resourceSet.getResource(URI.createURI(profilePath), true);
		return (Profile) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PROFILE);
	}
	
	/**
	 * Creates an instance of ModelManager, associated to a target UML base model defined by its path
	 * @param targetModelPath path of the associated target UML base model
	 * @throws Exception
	 */
	public ModelManager (String targetModelPath) throws Exception{
		this.targetModelURI = URI.createURI(targetModelPath);
		targetModelResource = loadResource(targetModelPath);
		if (targetModelResource == null){
			throw new Exception("Target Model initialization. Target Model " + targetModelPath +" could not be loaded");
		}
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#getTargetModel()
	 */
	@Override
	public Resource getTargetModel (){
		return targetModelResource;
	}
	
	/**
	 * returns the URI locator of associated UML target base model
	 * @return
	 */
	private URI getTargetModelURI(){
		return targetModelURI;
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#saveModel(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.common.util.URI, java.lang.String)
	 */
	@Override
	public URI saveModel (Resource modelResource, URI outputModelURI, String suffixe) throws IOException{
		FileOutputStream foStream = null;
		if (modelResource != null) {
			try {
				File outputFile = createOutputFile(outputModelURI, suffixe);
				foStream = new FileOutputStream(outputFile);
				modelResource.save(foStream, null);
				return URI.createURI(outputFile.getAbsolutePath());
			} catch (IOException e) {
				throw e;
			} finally {
				if (foStream != null) {
					try {
						foStream.flush();
						foStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		throw new NullPointerException("modelResource is null");
	}
	
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#saveTargetModel(java.lang.String)
	 */
	@Override
	public URI saveTargetModel (String suffixe) throws IOException{
		return saveModel(getTargetModel(), getTargetModelURI(), suffixe);
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#saveTargetModel()
	 */
	@Override
	public URI saveTargetModel () throws IOException{
		return saveModel(getTargetModel(), getTargetModelURI(), null);
	}

	/**
	 * This method creates a file in the same folder as the input model file to
	 * store the tagged model. The generated file's name is the same as the
	 * input filename followed by a suffix defined in the static field
	 * {@code OUTPUT_FILE_SUFFIX}
	 * 
	 * @return Returns an instance of {@link File} to be used to save the
	 *         results.
	 * @throws IOException
	 */
	private File createOutputFile(URI outputModelURI, String suffixe) throws IOException {
		String inputFileName = outputModelURI.lastSegment();
		String inputFilePath = outputModelURI.path();
		// Find output directory
		String outputDirectory = inputFilePath.substring(0, (inputFilePath.lastIndexOf('/') + 1));
		// Create the output filename
		String outputFileName = inputFileName;
		if (suffixe != null){
			outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf('.')) + suffixe;
		}
		
		File outputFile = new File(outputDirectory + outputFileName);

		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		return outputFile;
	}
}
