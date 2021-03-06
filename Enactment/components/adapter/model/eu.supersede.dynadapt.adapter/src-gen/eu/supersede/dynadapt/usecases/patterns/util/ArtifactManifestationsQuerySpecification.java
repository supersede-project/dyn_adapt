/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.patterns.ArtifactManifestationsMatch;
import eu.supersede.dynadapt.usecases.patterns.ArtifactManifestationsMatcher;
import eu.supersede.dynadapt.usecases.patterns.util.NodeArtifactsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ArtifactManifestationsMatcher in a type-safe way.
 * 
 * @see ArtifactManifestationsMatcher
 * @see ArtifactManifestationsMatch
 * 
 */
@SuppressWarnings("all")
public final class ArtifactManifestationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ArtifactManifestationsMatcher> {
  private ArtifactManifestationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ArtifactManifestationsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ArtifactManifestationsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ArtifactManifestationsMatcher.on(engine);
  }
  
  @Override
  public ArtifactManifestationsMatcher instantiate() throws ViatraQueryException {
    return ArtifactManifestationsMatcher.create();
  }
  
  @Override
  public ArtifactManifestationsMatch newEmptyMatch() {
    return ArtifactManifestationsMatch.newEmptyMatch();
  }
  
  @Override
  public ArtifactManifestationsMatch newMatch(final Object... parameters) {
    return ArtifactManifestationsMatch.newMatch((org.eclipse.uml2.uml.Artifact) parameters[0], (org.eclipse.uml2.uml.NamedElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ArtifactManifestationsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ArtifactManifestationsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ArtifactManifestationsQuerySpecification INSTANCE = new ArtifactManifestationsQuerySpecification();
    
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
    private final static ArtifactManifestationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pArtifact = new PParameter("artifact", "org.eclipse.uml2.uml.Artifact", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pManifestationTarget = new PParameter("manifestationTarget", "org.eclipse.uml2.uml.NamedElement", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pArtifact, parameter_pManifestationTarget);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.patterns.artifactManifestations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("artifact","manifestationTarget");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, (IQueryBackendFactory)null));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_artifact = body.getOrCreateVariableByName("artifact");
      		PVariable var_manifestationTarget = body.getOrCreateVariableByName("manifestationTarget");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var_manifestation = body.getOrCreateVariableByName("manifestation");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_artifact, parameter_pArtifact),
      		   new ExportedParameter(body, var_manifestationTarget, parameter_pManifestationTarget)
      		));
      		// 	find nodeArtifacts(_, artifact)
      		new PositivePatternCall(body, new FlatTuple(var___0_, var_artifact), NodeArtifactsQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Artifact.manifestation (artifact, manifestation)
      		new TypeConstraint(body, new FlatTuple(var_artifact), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Artifact")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_artifact, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Artifact", "manifestation")));
      		new Equality(body, var__virtual_0_, var_manifestation);
      		// 	Manifestation.supplier (manifestation, manifestationTarget)
      		new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_manifestation, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "supplier")));
      		new Equality(body, var__virtual_1_, var_manifestationTarget);
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
