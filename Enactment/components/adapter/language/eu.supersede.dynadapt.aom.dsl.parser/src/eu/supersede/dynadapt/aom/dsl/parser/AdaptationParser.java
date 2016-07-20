package eu.supersede.dynadapt.aom.dsl.parser;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;

import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLLibraryResourcesUtil;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class AdaptationParser implements IAdaptationParser{
	SupersedeDSLResourceSet resourceSet;
	
	public AdaptationParser(){
		resourceSet = SupersedeDSLLibraryResourcesUtil.createSupersedeDSLResourceSet();
	}
	
	public Aspect parseAdaptationModel (IFile adaptationModelFile){
		URI fileURI = URI.createPlatformResourceURI(adaptationModelFile.getFullPath().toString(), true);
		Aspect adaptation = resourceSet.loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(fileURI.toString()));
		Assert.isNotNull(adaptation, "Adaptation model " + fileURI + " could not be parsed");
		return adaptation;
	}
	
}
