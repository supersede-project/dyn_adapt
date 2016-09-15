package eu.supersede.dynadapt.aom.dsl.parser;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.internal.impl.ProfileImpl;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.impl.PatternImpl;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLLibraryResourcesUtil;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class AdaptationParser implements IAdaptationParser{
	SupersedeDSLResourceSet resourceSet;
	
	public AdaptationParser(){
		resourceSet = SupersedeDSLLibraryResourcesUtil.createSupersedeDSLResourceSet();
	}
	
	public Model loadUMLResource (URI uri){
		Model resource = resourceSet.loadUMLModel(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public Profile loadProfileResource (URI uri){
		Profile resource = resourceSet.loadUMLProfile(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public PatternModel loadPatternResource (URI uri){
		PatternModel resource = resourceSet.loadPatternModel(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public FeatureModel loadFeatureResource (URI uri){
		FeatureModel resource = resourceSet.loadFeatureModel(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public Aspect parseAdaptationModel (IFile adaptationModelFile){
		URI fileURI = URI.createPlatformResourceURI(adaptationModelFile.getFullPath().toString(), true);
		Aspect adaptation = resourceSet.loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(fileURI.toString()));
		Assert.isNotNull(adaptation, "Adaptation model " + fileURI + " could not be parsed");
		return adaptation;
	}
	
	public Aspect parseAdaptationModel (URI fileURI){
		Aspect adaptation = resourceSet.loadAspectModel(fileURI);
		Assert.isNotNull(adaptation, "Adaptation model " + fileURI + " could not be parsed");
		return adaptation;
	}
	
}
