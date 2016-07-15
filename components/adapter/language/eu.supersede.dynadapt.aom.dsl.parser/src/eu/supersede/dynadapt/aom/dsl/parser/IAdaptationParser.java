package eu.supersede.dynadapt.aom.dsl.parser;

import org.eclipse.core.resources.IFile;

import eu.supersede.dynadapt.dsl.aspect.Aspect;

public interface IAdaptationParser {
	public Aspect parseAdaptationModel (IFile adaptationModelFile);
}
