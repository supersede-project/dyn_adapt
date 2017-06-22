/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.patterns.VirtualExecutionEnvContainingAComponentMatch;
import eu.supersede.dynadapt.usecases.patterns.VirtualExecutionEnvContainingAComponentMatcher;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate VirtualExecutionEnvContainingAComponentMatcher in a type-safe way.
 * 
 * @see VirtualExecutionEnvContainingAComponentMatcher
 * @see VirtualExecutionEnvContainingAComponentMatch
 * 
 */
@SuppressWarnings("all")
public final class VirtualExecutionEnvContainingAComponentQuerySpecification extends BaseGeneratedEMFQuerySpecification<VirtualExecutionEnvContainingAComponentMatcher> {
  private VirtualExecutionEnvContainingAComponentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static VirtualExecutionEnvContainingAComponentQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected VirtualExecutionEnvContainingAComponentMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return VirtualExecutionEnvContainingAComponentMatcher.on(engine);
  }
  
  @Override
  public VirtualExecutionEnvContainingAComponentMatcher instantiate() throws ViatraQueryException {
    return VirtualExecutionEnvContainingAComponentMatcher.create();
  }
  
  @Override
  public VirtualExecutionEnvContainingAComponentMatch newEmptyMatch() {
    return VirtualExecutionEnvContainingAComponentMatch.newEmptyMatch();
  }
  
  @Override
  public VirtualExecutionEnvContainingAComponentMatch newMatch(final Object... parameters) {
    return VirtualExecutionEnvContainingAComponentMatch.newMatch((org.eclipse.uml2.uml.ExecutionEnvironment) parameters[0], (org.eclipse.uml2.uml.Component) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link VirtualExecutionEnvContainingAComponentQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link VirtualExecutionEnvContainingAComponentQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static VirtualExecutionEnvContainingAComponentQuerySpecification INSTANCE = new VirtualExecutionEnvContainingAComponentQuerySpecification();
    
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
    private final static VirtualExecutionEnvContainingAComponentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pExecEnv = new PParameter("execEnv", "org.eclipse.uml2.uml.ExecutionEnvironment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pInstanceClassifier = new PParameter("instanceClassifier", "org.eclipse.uml2.uml.Component", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Component")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pExecEnv, parameter_pInstanceClassifier);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.patterns.VirtualExecutionEnvContainingAComponent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("execEnv","instanceClassifier");
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
      		PVariable var_instanceClassifier = body.getOrCreateVariableByName("instanceClassifier");
      		PVariable var_classifier = body.getOrCreateVariableByName("classifier");
      		PVariable var_manifestation = body.getOrCreateVariableByName("manifestation");
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		new TypeConstraint(body, new FlatTuple(var_execEnv), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")));
      		new TypeConstraint(body, new FlatTuple(var_instanceClassifier), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_execEnv, parameter_pExecEnv),
      		   new ExportedParameter(body, var_instanceClassifier, parameter_pInstanceClassifier)
      		));
      		// 	ExecutionEnvironment.nestedClassifier (execEnv, classifier)
      		new TypeConstraint(body, new FlatTuple(var_execEnv), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_execEnv, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "nestedClassifier")));
      		new Equality(body, var__virtual_0_, var_classifier);
      		// 	Artifact.manifestation (classifier, manifestation)
      		new TypeConstraint(body, new FlatTuple(var_classifier), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Artifact")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_classifier, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Artifact", "manifestation")));
      		new Equality(body, var__virtual_1_, var_manifestation);
      		// 	Manifestation.supplier (manifestation, instance)
      		new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_manifestation, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "supplier")));
      		new Equality(body, var__virtual_2_, var_instance);
      		// 	InstanceSpecification.classifier (instance, instanceClassifier)
      		new TypeConstraint(body, new FlatTuple(var_instance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_instance, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier")));
      		new Equality(body, var__virtual_3_, var_instanceClassifier);
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
