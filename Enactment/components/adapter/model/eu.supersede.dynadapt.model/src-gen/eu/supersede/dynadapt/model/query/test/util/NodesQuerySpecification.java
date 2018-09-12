/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.model.query.test.NodesMatch;
import eu.supersede.dynadapt.model.query.test.NodesMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
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
 * A pattern-specific query specification that can instantiate NodesMatcher in a type-safe way.
 * 
 * @see NodesMatcher
 * @see NodesMatch
 * 
 */
@SuppressWarnings("all")
public final class NodesQuerySpecification extends BaseGeneratedEMFQuerySpecification<NodesMatcher> {
  private NodesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static NodesQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected NodesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NodesMatcher.on(engine);
  }
  
  @Override
  public NodesMatcher instantiate() throws ViatraQueryException {
    return NodesMatcher.create();
  }
  
  @Override
  public NodesMatch newEmptyMatch() {
    return NodesMatch.newEmptyMatch();
  }
  
  @Override
  public NodesMatch newMatch(final Object... parameters) {
    return NodesMatch.newMatch((org.eclipse.uml2.uml.Node) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link NodesQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NodesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static NodesQuerySpecification INSTANCE = new NodesQuerySpecification();
    
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
    private final static NodesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pNode = new PParameter("node", "org.eclipse.uml2.uml.Node", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pName = new PParameter("name", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pNode, parameter_pName);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.model.query.test.nodes";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("node","name");
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
              PVariable var_name = body.getOrCreateVariableByName("name");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_node, parameter_pNode),
                 new ExportedParameter(body, var_name, parameter_pName)
              ));
              // 	Node.name (node, name)
              new TypeConstraint(body, new FlatTuple(var_node), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Node")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, new FlatTuple(var_node, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, new FlatTuple(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_0_, var_name);
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
