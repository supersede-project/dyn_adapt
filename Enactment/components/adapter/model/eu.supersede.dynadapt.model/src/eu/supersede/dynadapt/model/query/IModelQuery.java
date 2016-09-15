package eu.supersede.dynadapt.model.query;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

public interface IModelQuery {
	public Collection<? extends IPatternMatch> query (String patternFQN, String patternModelPath) throws ViatraQueryException;
	public Collection<? extends IPatternMatch> query (String patternFQN, Resource patternResource) throws ViatraQueryException;
	public Collection<Map<String, Object>> query (String patternFQN, Resource patternResource, List<String> parameters) throws ViatraQueryException;
	public Collection<Map<String, Object>> query (String patternFQN, String patternModelPath, List<String> parameters) throws ViatraQueryException;
	public PatternModel loadPatternModel (URI uri);
}
