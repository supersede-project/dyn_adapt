package eu.supersede.dynadapt.lang.yafmt;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class YafmtSupport extends AbstractGenericResourceSupport {

	@Override
	protected Module createGuiceModule() {
		// TODO Auto-generated method stub
		return new YafmtRuntimeModule();
	}

}
