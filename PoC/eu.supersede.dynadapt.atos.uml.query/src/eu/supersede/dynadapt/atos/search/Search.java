package eu.supersede.dynadapt.atos.search;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.dynadapt.atos.queries.ArtifactManifestationsMatch;
import eu.supersede.dynadapt.atos.queries.ArtifactManifestationsMatcher;
import eu.supersede.dynadapt.atos.queries.Atos_queries;
import eu.supersede.dynadapt.atos.queries.ServicesMatch;
import eu.supersede.dynadapt.atos.queries.ServicesMatcher;

public class Search {
	private static ResourceSet resourceSet = new ResourceSetImpl();
	private ViatraQueryEngine engine;
	static {
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl ());
//		UMLResourcesUtils.init (RESOURCE_SET);
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//		Map uriMap = resourceSet.getURIConverter().getURIMap();
//		URI uri = URI.createURI("jar:file:/C:/eclipse/plugins/org.eclipse.uml2.uml.resources_<version>.jar!/"); // for example
//		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
//		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
//		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));
	}
	Atos_queries queries = null;
	
	public Search(String modelPath) throws ViatraQueryException{
		queries = Atos_queries.instance();
		Resource modelResource = loadResource(modelPath);
		EMFScope scope = new EMFScope (modelResource);
		engine = AdvancedViatraQueryEngine.createUnmanagedEngine(scope);
	}
	
	public static void main (String[] args) throws ViatraQueryException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		String modelPath = "platform:/resource/eu.supersede.dynadapt.atos.uml/atos_base_model.uml";
		String modelPath = "file://home/yosu/Projects/Supersede/Git/dyn_adapt/PoC/eu.supersede.dynadapt.atos.uml/atos_base_model.uml";
		
		
		Search search = new Search(modelPath);
		search.searchExample();
		
		Collection<ServicesMatch> services = search.searchServices();
		System.out.println("Services: " + search.prettyPrintMatches (services));
		
		System.out.println("Services: " + search.prettyPrintMatches (search.search ("services")));
		System.out.println("Service Configurations: " + search.prettyPrintMatches (search.search ("serviceConfigurations")));
		
	}
	
	protected Resource loadResource(String modelPath) {
		return resourceSet.getResource(URI.createURI(modelPath), true);
	}
	
	public void searchExample () throws ViatraQueryException{
		//Searching artifact manifestations
		ArtifactManifestationsMatcher matcher = queries.getArtifactManifestations(engine);
		Collection <ArtifactManifestationsMatch> matches = matcher.getAllMatches();
		System.out.println("Artifact Manifestations: " + prettyPrintMatches(matches));
	}
	
	public Collection<ServicesMatch> searchServices () throws ViatraQueryException{
		ServicesMatcher matcher = queries.getServices(engine);
		return matcher.getAllMatches();
	}
	
	public Collection<? extends IPatternMatch> search (String pattern) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method patternMethod = 
				queries.getClass().getMethod(
						"get" + capitalizeFirstLetter(pattern), ViatraQueryEngine.class);
		BaseMatcher matcher = (BaseMatcher) patternMethod.invoke(queries, engine);
		return matcher.getAllMatches();
	}
	
	private  String capitalizeFirstLetter(String original) {
	    if (original == null || original.length() == 0) {
	        return original;
	    }
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
	protected StringBuilder prettyPrintMatches(Collection<? extends IPatternMatch> matches) {
		StringBuilder results = new StringBuilder();
		for (IPatternMatch match : matches) {
			results.append(match.prettyPrint()+"; ");
		}
		if(matches.size() == 0) {
			results.append("Empty match set");
		}
		results.append("\n");
		return results;
	}
}
