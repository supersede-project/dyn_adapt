/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns.util;

import com.google.common.collect.Sets;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import patterns.GetMeteorologicalDataServicesMatch;
import patterns.GetMeteorologicalDataServicesMatcher;

/**
 * A pattern-specific query specification that can instantiate GetMeteorologicalDataServicesMatcher in a type-safe way.
 * 
 * @see GetMeteorologicalDataServicesMatcher
 * @see GetMeteorologicalDataServicesMatch
 * 
 */
@SuppressWarnings("all")
public final class GetMeteorologicalDataServicesQuerySpecification extends BaseGeneratedEMFQuerySpecification<GetMeteorologicalDataServicesMatcher> {
  private GetMeteorologicalDataServicesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static GetMeteorologicalDataServicesQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected GetMeteorologicalDataServicesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return GetMeteorologicalDataServicesMatcher.on(engine);
  }
  
  @Override
  public GetMeteorologicalDataServicesMatcher instantiate() throws ViatraQueryException {
    return GetMeteorologicalDataServicesMatcher.create();
  }
  
  @Override
  public GetMeteorologicalDataServicesMatch newEmptyMatch() {
    return GetMeteorologicalDataServicesMatch.newEmptyMatch();
  }
  
  @Override
  public GetMeteorologicalDataServicesMatch newMatch(final Object... parameters) {
    return GetMeteorologicalDataServicesMatch.newMatch((org.eclipse.uml2.uml.CallBehaviorAction) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link GetMeteorologicalDataServicesQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link GetMeteorologicalDataServicesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static GetMeteorologicalDataServicesQuerySpecification INSTANCE = new GetMeteorologicalDataServicesQuerySpecification();
    
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
    private final static GetMeteorologicalDataServicesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pAction = new PParameter("action", "org.eclipse.uml2.uml.CallBehaviorAction", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "CallBehaviorAction")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pAction);
    
    @Override
    public String getFullyQualifiedName() {
      return "patterns.GetMeteorologicalDataServices";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("action");
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
      		PVariable var_action = body.getOrCreateVariableByName("action");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		new TypeConstraint(body, new FlatTuple(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "CallBehaviorAction")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_action, parameter_pAction)
      		));
      		// 	CallBehaviorAction.name(action, name)
      		new TypeConstraint(body, new FlatTuple(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "CallBehaviorAction")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_action, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name);
      		// 	check(name.equals("GetMteorologicalData"))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern GetMeteorologicalDataServices";
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
    boolean _equals = name.equals("GetMteorologicalData");
    return _equals;
  }
}
