/**
 * Generated from platform:/resource/eu.supersede.dynadapt.usecases.atos/src/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.util.ArtifactManifestationsQuerySpecification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher in a type-safe way.
 * 
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch
 * 
 */
@SuppressWarnings("all")
public final class InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification extends BaseGeneratedEMFQuerySpecification<InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher> {
  private InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher.on(engine);
  }
  
  @Override
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher instantiate() throws ViatraQueryException {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher.create();
  }
  
  @Override
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch newEmptyMatch() {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.newEmptyMatch();
  }
  
  @Override
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch newMatch(final Object... parameters) {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.newMatch((org.eclipse.uml2.uml.Artifact) parameters[0], (org.eclipse.uml2.uml.InstanceSpecification) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification INSTANCE = new InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pArtifact = new PParameter("artifact", "org.eclipse.uml2.uml.Artifact", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pInstance = new PParameter("instance", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pArtifact, parameter_pInstance);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.atos.patterns.instanceSpecificationsAsManifestationsOfNodeArtifacts";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("artifact","instance");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, Collections.<String,Object>emptyMap()));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_artifact = body.getOrCreateVariableByName("artifact");
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_artifact, parameter_pArtifact),
      		   new ExportedParameter(body, var_instance, parameter_pInstance)
      		));
      		// 	find artifactManifestations(artifact, instance)
      		new PositivePatternCall(body, new FlatTuple(var_artifact, var_instance), ArtifactManifestationsQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	InstanceSpecification (instance)
      		new TypeConstraint(body, new FlatTuple(var_instance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
