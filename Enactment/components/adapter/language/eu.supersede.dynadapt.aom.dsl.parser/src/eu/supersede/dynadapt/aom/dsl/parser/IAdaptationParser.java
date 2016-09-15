package eu.supersede.dynadapt.aom.dsl.parser;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public interface IAdaptationParser {
	public Aspect parseAdaptationModel (IFile adaptationModelFile);
	public Aspect parseAdaptationModel (URI fileURI);
	public Model loadUMLResource (URI uri);
	public Profile loadProfileResource (URI uri);
	public PatternModel loadPatternResource (URI uri);
	public FeatureModel loadFeatureResource (URI uri);
}
