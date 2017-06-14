/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServicesMatch;
import eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServicesMatcher;
import eu.supersede.dynadapt.usecases.patterns.util.HSKExecutionEnvironmentsQuerySpecification;
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
 * A pattern-specific query specification that can instantiate VMInstancesContainingHSKServicesMatcher in a type-safe way.
 * 
 * @see VMInstancesContainingHSKServicesMatcher
 * @see VMInstancesContainingHSKServicesMatch
 * 
 */
@SuppressWarnings("all")
public final class VMInstancesContainingHSKServicesQuerySpecification extends BaseGeneratedEMFQuerySpecification<VMInstancesContainingHSKServicesMatcher> {
  private VMInstancesContainingHSKServicesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static VMInstancesContainingHSKServicesQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected VMInstancesContainingHSKServicesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return VMInstancesContainingHSKServicesMatcher.on(engine);
  }
  
  @Override
  public VMInstancesContainingHSKServicesMatcher instantiate() throws ViatraQueryException {
    return VMInstancesContainingHSKServicesMatcher.create();
  }
  
  @Override
  public VMInstancesContainingHSKServicesMatch newEmptyMatch() {
    return VMInstancesContainingHSKServicesMatch.newEmptyMatch();
  }
  
  @Override
  public VMInstancesContainingHSKServicesMatch newMatch(final Object... parameters) {
    return VMInstancesContainingHSKServicesMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link VMInstancesContainingHSKServicesQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link VMInstancesContainingHSKServicesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static VMInstancesContainingHSKServicesQuerySpecification INSTANCE = new VMInstancesContainingHSKServicesQuerySpecification();
    
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
    private final static VMInstancesContainingHSKServicesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pInstance = new PParameter("instance", "org.eclipse.uml2.uml.InstanceSpecification", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pInstance);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServices";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("instance");
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
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		PVariable var_execEnv = body.getOrCreateVariableByName("execEnv");
      		PVariable var_manifestation = body.getOrCreateVariableByName("manifestation");
      		new TypeConstraint(body, new FlatTuple(var_instance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_instance, parameter_pInstance)
      		));
      		// 	find HSKExecutionEnvironments(execEnv)
      		new PositivePatternCall(body, new FlatTuple(var_execEnv), HSKExecutionEnvironmentsQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Manifestation.client (manifestation, execEnv)
      		new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_manifestation, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "client")));
      		new Equality(body, var__virtual_0_, var_execEnv);
      		// 	Manifestation.supplier (manifestation, instance)
      		new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_manifestation, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "supplier")));
      		new Equality(body, var__virtual_1_, var_instance);
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
