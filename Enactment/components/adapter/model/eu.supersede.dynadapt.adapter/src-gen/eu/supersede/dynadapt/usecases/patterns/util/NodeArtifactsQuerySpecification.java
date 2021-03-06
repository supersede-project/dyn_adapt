/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.patterns.NodeArtifactsMatch;
import eu.supersede.dynadapt.usecases.patterns.NodeArtifactsMatcher;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NodeArtifactsMatcher in a type-safe way.
 * 
 * @see NodeArtifactsMatcher
 * @see NodeArtifactsMatch
 * 
 */
@SuppressWarnings("all")
public final class NodeArtifactsQuerySpecification extends BaseGeneratedEMFQuerySpecification<NodeArtifactsMatcher> {
  private NodeArtifactsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static NodeArtifactsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NodeArtifactsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NodeArtifactsMatcher.on(engine);
  }
  
  @Override
  public NodeArtifactsMatcher instantiate() throws ViatraQueryException {
    return NodeArtifactsMatcher.create();
  }
  
  @Override
  public NodeArtifactsMatch newEmptyMatch() {
    return NodeArtifactsMatch.newEmptyMatch();
  }
  
  @Override
  public NodeArtifactsMatch newMatch(final Object... parameters) {
    return NodeArtifactsMatch.newMatch((org.eclipse.uml2.uml.Node) parameters[0], (org.eclipse.uml2.uml.Artifact) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link NodeArtifactsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link NodeArtifactsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static NodeArtifactsQuerySpecification INSTANCE = new NodeArtifactsQuerySpecification();
    
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
    private final static NodeArtifactsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pNode = new PParameter("node", "org.eclipse.uml2.uml.Node", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pArtifact = new PParameter("artifact", "org.eclipse.uml2.uml.Artifact", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pNode, parameter_pArtifact);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.patterns.nodeArtifacts";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("node","artifact");
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
      		PVariable var_node = body.getOrCreateVariableByName("node");
      		PVariable var_artifact = body.getOrCreateVariableByName("artifact");
      		PVariable var__name = body.getOrCreateVariableByName("_name");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_node, parameter_pNode),
      		   new ExportedParameter(body, var_artifact, parameter_pArtifact)
      		));
      		// 	Node.nestedClassifier (node, artifact)
      		new TypeConstraint(body, new FlatTuple(var_node), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Node")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_node, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "nestedClassifier")));
      		new Equality(body, var__virtual_0_, var_artifact);
      		// 	Artifact.name (artifact, _name)
      		new TypeConstraint(body, new FlatTuple(var_artifact), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Artifact")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_artifact, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_1_, var__name);
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
