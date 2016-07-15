package eu.supersede.dynadapt.aom.dsl.util.test;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Test;

import eu.supersede.dynadapt.aom.dsl.resources.SupersedeResources;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class AspectDSLTest {

	@Test
	public void loadAspectModelTest() {
		URI aspectModelURI = URI.createFileURI("models/concurrency.aspect");
		SupersedeDSLResourceSet set = SupersedeResources.createResourceSet();
		Aspect aspectModel = set.loadAspectModel(aspectModelURI);
		Assert.assertNotNull(aspectModel);
		
		String featureName = aspectModel.getFeature().getName();
		String patternName = aspectModel.getPointcuts().get(0).getPattern().getName();
	}

}
