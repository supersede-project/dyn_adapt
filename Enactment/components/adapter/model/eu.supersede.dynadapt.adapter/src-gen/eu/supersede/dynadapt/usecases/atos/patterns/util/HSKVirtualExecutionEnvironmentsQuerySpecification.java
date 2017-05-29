/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironmentsMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironmentsMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.util.VirtualExecutionEnvContainingAComponentQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate HSKVirtualExecutionEnvironmentsMatcher in a type-safe way.
 * 
 * @see HSKVirtualExecutionEnvironmentsMatcher
 * @see HSKVirtualExecutionEnvironmentsMatch
 * 
 */
@SuppressWarnings("all")
public final class HSKVirtualExecutionEnvironmentsQuerySpecification extends BaseGeneratedEMFQuerySpecification<HSKVirtualExecutionEnvironmentsMatcher> {
  private HSKVirtualExecutionEnvironmentsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static HSKVirtualExecutionEnvironmentsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected HSKVirtualExecutionEnvironmentsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return HSKVirtualExecutionEnvironmentsMatcher.on(engine);
  }
  
  @Override
  public HSKVirtualExecutionEnvironmentsMatcher instantiate() throws ViatraQueryException {
    return HSKVirtualExecutionEnvironmentsMatcher.create();
  }
  
  @Override
  public HSKVirtualExecutionEnvironmentsMatch newEmptyMatch() {
    return HSKVirtualExecutionEnvironmentsMatch.newEmptyMatch();
  }
  
  @Override
  public HSKVirtualExecutionEnvironmentsMatch newMatch(final Object... parameters) {
    return HSKVirtualExecutionEnvironmentsMatch.newMatch((org.eclipse.uml2.uml.ExecutionEnvironment) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link HSKVirtualExecutionEnvironmentsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link HSKVirtualExecutionEnvironmentsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static HSKVirtualExecutionEnvironmentsQuerySpecification INSTANCE = new HSKVirtualExecutionEnvironmentsQuerySpecification();
    
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
    private final static HSKVirtualExecutionEnvironmentsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pExecEnv = new PParameter("execEnv", "org.eclipse.uml2.uml.ExecutionEnvironment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pExecEnv);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironments";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("execEnv");
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
      		PVariable var_execEnv = body.getOrCreateVariableByName("execEnv");
      		PVariable var_component = body.getOrCreateVariableByName("component");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		new TypeConstraint(body, new FlatTuple(var_execEnv), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_execEnv, parameter_pExecEnv)
      		));
      		// 	find VirtualExecutionEnvContainingAComponent(execEnv, component)
      		new PositivePatternCall(body, new FlatTuple(var_execEnv, var_component), VirtualExecutionEnvContainingAComponentQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Component.name (component, name)
      		new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_component, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name);
      		// 		check (		name.equalsIgnoreCase("HSK")	)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern HSKVirtualExecutionEnvironments";
      		    }
      		    
      		    @Override
      		    public Iterable<String> getInputParameterNames() {
      		        return Arrays.asList("name");}
      		
      		    @Override
      		    public Object evaluateExpression(IValueProvider provider) throws Exception {
      		        String name = (String) provider.getValue("name");
      		        return evaluateExpression_1_1(name);
      		    }
      		},  null); 
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
  
  private static boolean evaluateExpression_1_1(final String name) {
    boolean _equalsIgnoreCase = name.equalsIgnoreCase("HSK");
    return _equalsIgnoreCase;
  }
}
