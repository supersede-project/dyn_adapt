package eu.supersede.dynadapt.model.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.viatra.query.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.viatra.query.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.viatra.query.patternlanguage.helper.CorePatternLanguageHelper;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.dynadapt.aom.dsl.resources.ExtendedUMLResourcesUtil;

/**
 * Code taken from Viatra IncQuery API User Documentation:
 * http://wiki.eclipse.org/VIATRA/Query/UserDocumentation/API/Advanced
 * @author Jesús Gorroñogoitia
 * This class queries target model with Viatra IncQuery patterns selected from a given pattern model
 */
public class ModelQuery implements IModelQuery{
	private static ResourceSet resourceSet = new ResourceSetImpl();
	private Resource targetModelResource = null;
	private AdvancedViatraQueryEngine engine = null;
	private boolean patternLanguageInitialize = false;
	
	static {
		// Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml",
		// new XMIResourceFactoryImpl ());
		// UMLResourcesUtils.init (RESOURCE_SET);
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		// Map uriMap = resourceSet.getURIConverter().getURIMap();
		// URI uri =
		// URI.createURI("jar:file:/C:/eclipse/plugins/org.eclipse.uml2.uml.resources_<version>.jar!/");
		// // for example
		// uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
		// uri.appendSegment("libraries").appendSegment(""));
		// uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
		// uri.appendSegment("metamodels").appendSegment(""));
		// uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP),
		// uri.appendSegment("profiles").appendSegment(""));
	}
	
	/**
	 * Creates an instance of ModelQuery that queries on target model referenced by path
	 * @param targetModelPath
	 * @throws ViatraQueryException
	 */
	public ModelQuery (String targetModelPath) throws ViatraQueryException{
		targetModelResource = loadResource(targetModelPath);
		if (targetModelResource == null){
			throw new ViatraQueryException("Target Model initialization", "Target Model " + targetModelPath +" could not be loaded");
		}
		createQueryEngine();
	}
	
	/**
	 * Resets the targetModel by loading a new one referenced by path. 
	 * @param targetModelPath
	 * @throws ViatraQueryException
	 */
	public void resetTargetModelPath (String targetModelPath) throws ViatraQueryException{
		targetModelResource = loadResource(targetModelPath);
		if (targetModelResource == null){
			throw new ViatraQueryException("Target Model initialization", "Target Model " + targetModelPath +" could not be loaded");
		}
		createQueryEngine();
	}


	private void createQueryEngine() throws ViatraQueryException {
		if (engine != null){
			engine.dispose();
		}
		
		EMFScope queryScope = new EMFScope(targetModelResource);
		try {
			// create an *unmanaged* engine to ensure that no one else is
			// going
			// to use our engine
			engine = AdvancedViatraQueryEngine.createUnmanagedEngine(queryScope);

			// Initializing Xtext-based resource parser
			// Do not use if VIATRA Query tooling is loaded!
			if (!patternLanguageInitialize){
				new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
				patternLanguageInitialize = true;
			}
		} catch (ViatraQueryException ex) {
			if (engine != null) {
				engine.dispose();
			}
			throw ex;
		}
	}
	
	public void disposeQueryEngine (){
		// completely dispose of the engine once's it is not needed
		engine.dispose();
		targetModelResource.unload();
	}

	/**
	 * Queries associated target model with a pattern located in a pattern model referenced by path
	 * @param patternFQN the qualified name of the query pattern to search for
	 * @param patternModelPath the full path of the query pattern model
	 * @return a collection of target model matches
	 * @throws ViatraQueryException
	 */
	public Collection<? extends IPatternMatch> query (String patternFQN, String patternModelPath) throws ViatraQueryException{
		//Sequence of queries are possible before disposing the engine and model resource
		Resource patternModel = loadResource(patternModelPath);
		Collection<? extends IPatternMatch> matches = query(patternFQN, patternModel);
		
		return matches;
	}
	
	/**
	 * Queries associated target model with a pattern located in a pattern model
	 * @param patternFQN the qualified name of the query pattern to search for
	 * @param patternResource the query pattern model that defines the pattern to apply
	 * @return a collection of target model matches
	 * @throws ViatraQueryException
	 */
	public Collection<? extends IPatternMatch> query (String patternFQN, Resource patternResource) throws ViatraQueryException{
		// instantiate a pattern matcher through the registry, by only
		// knowing its FQN
		// assuming that there is a pattern definition registered
		// matching 'patternFQN'

		Pattern p = null;

		// navigate to the pattern definition that we want
		if (patternResource != null) {
			if (patternResource.getErrors().size() == 0 && patternResource.getContents().size() >= 1) {
				EObject topElement = patternResource.getContents().get(0);
				if (topElement instanceof PatternModel) {
					for (Pattern _p : ((PatternModel) topElement).getPatterns()) {
						if (patternFQN.equals(CorePatternLanguageHelper.getFullyQualifiedName(_p))) {
							p = _p;
							break;
						}
					}
				}
			}
		}
		if (p == null) {
			throw new RuntimeException(String.format("Pattern %s not found", patternFQN));
		}
		// A specification builder is used to translate patterns to
		// query specifications
		SpecificationBuilder builder = new SpecificationBuilder();

		// attempt to retrieve a registered query specification
		ViatraQueryMatcher<? extends IPatternMatch> matcher = engine
				.getMatcher(builder.getOrCreateSpecification(p));

		Collection<? extends IPatternMatch> matches = null;
		if (matcher != null) {
			matches = matcher.getAllMatches();
		}

		// wipe the engine
		engine.wipe();
		// after a wipe, new patterns can be rebuilt with much less
		// overhead than
		// complete traversal (as the base indexes will be kept)

		return matches;
	}	
	
	/**
	 * Queries associated target model with a pattern located in a pattern model and return the matching objects for given parameters defined in the query
	 * @param patternFQN the qualified name of the query pattern to search for
	 * @param patternResource the full path of the query pattern model
	 * @param parameters
	 * @return a collection of target model matches for given query parameters
	 * @throws ViatraQueryException
	 */
	public Collection<Map<String, Object>> query (String patternFQN, Resource patternResource, List<String> parameters) throws ViatraQueryException{
		Collection<Map<String, Object>> result = null;
		Collection<? extends IPatternMatch> matches = query(patternFQN, patternResource);
		if (matches != null){
			result = filterMatches(matches, parameters);
		}
		return result;
	}
	
	/**
	 * Queries associated target model with a pattern located in a pattern model and return the matching objects for given parameters defined in the query
	 * @param pattern FQN the qualified name of the query pattern to search for
	 * @param pattern Full path of the query pattern model
	 * @param parameters
	 * @return a collection of target model matches for given query parameters
	 * @throws ViatraQueryException
	 */
	public Collection<Map<String, Object>> query (String patternFQN, String patternModelPath, List<String> parameters) throws ViatraQueryException{
		Resource patternModel = loadResource(patternModelPath);
		return query(patternFQN, patternModel, parameters);
	}

	/**
	 * Filters matching results, getting those associated to given querying parameters
	 * @param matches Querying matches
	 * @param parameters Querying parameters
	 * @return
	 */
	private Collection<Map<String, Object>> filterMatches(Collection<? extends IPatternMatch> matches, List<String> parameters) {
		Collection<Map<String, Object>> result;
		result = new ArrayList<>();
		for (IPatternMatch match : matches) {
			Map<String, Object> map = new HashMap<>();
			for (String parameter: parameters){
				map.put (parameter, match.get(parameter));
			}
			result.add (map);
		}
		return result;
	}
	
	/**
	 * Load an EMF model results
	 * @param modelPath absolute path to model
	 * @return
	 */
	protected Resource loadResource(String modelPath) {
		return resourceSet.getResource(URI.createURI(modelPath), true);
	}
	
	public void prettyPrintMatches(StringBuilder results, Collection<? extends IPatternMatch> matches) {
		for (IPatternMatch match : matches) {
			results.append(match.prettyPrint() + "; ");
		}
		if (matches.size() == 0) {
			results.append("Empty match set");
		}
		results.append("\n");
	}
	
	/**
	 * Creates a new platform resource {@link URI} based on the given 
	 * uriString by trying to bring the uriString into the necessary
	 * format. Platform resource uris are used to identify a resource
	 * located in the workspace.
	 * 
	 * @param uriString string to be converted into a platform resource uri
	 * @return platform resource uri
	 * 
	 * @see URI#createPlatformResourceURI(String)
	 * @see URI#createPlatformResourceURI(String, boolean)
	 */
	public static URI getPlatformResourceURI(String uriString) {
		URI uri = URI.createURI(uriString);
		if(uriString.startsWith("pathmap://"))
			return uri;
		if(uri.isPlatformResource())
			return uri;
		if(uri.isPlatformPlugin() || uri.isPlatform())
			return URI.createPlatformResourceURI(uri.toPlatformString(true), true);
		String newUriString = uriString;
		if(!uriString.startsWith("/"))
			newUriString = "/" + newUriString;
		return URI.createPlatformResourceURI(newUriString, true);
	}
	
}
