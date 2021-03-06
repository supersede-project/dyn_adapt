/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test.util;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import eu.supersede.dynadapt.model.query.test.ServiceConfigurationsMatch;
import eu.supersede.dynadapt.model.query.test.ServiceConfigurationsMatcher;
import eu.supersede.dynadapt.model.query.test.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
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
 * A pattern-specific query specification that can instantiate ServiceConfigurationsMatcher in a type-safe way.
 * 
 * @see ServiceConfigurationsMatcher
 * @see ServiceConfigurationsMatch
 * 
 */
@SuppressWarnings("all")
public final class ServiceConfigurationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ServiceConfigurationsMatcher> {
  private ServiceConfigurationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ServiceConfigurationsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ServiceConfigurationsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ServiceConfigurationsMatcher.on(engine);
  }
  
  @Override
  public ServiceConfigurationsMatcher instantiate() throws ViatraQueryException {
    return ServiceConfigurationsMatcher.create();
  }
  
  @Override
  public ServiceConfigurationsMatch newEmptyMatch() {
    return ServiceConfigurationsMatch.newEmptyMatch();
  }
  
  @Override
  public ServiceConfigurationsMatch newMatch(final Object... parameters) {
    return ServiceConfigurationsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.InstanceSpecification) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ServiceConfigurationsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ServiceConfigurationsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ServiceConfigurationsQuerySpecification INSTANCE = new ServiceConfigurationsQuerySpecification();
    
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
    private final static ServiceConfigurationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pService = new PParameter("service", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pConfiguration = new PParameter("configuration", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pService, parameter_pConfiguration);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.model.query.test.serviceConfigurations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("service","configuration");
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
      		PVariable var_service = body.getOrCreateVariableByName("service");
      		PVariable var_configuration = body.getOrCreateVariableByName("configuration");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var_slot = body.getOrCreateVariableByName("slot");
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		PVariable var_feature = body.getOrCreateVariableByName("feature");
      		PVariable var_featureName = body.getOrCreateVariableByName("featureName");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_service, parameter_pService),
      		   new ExportedParameter(body, var_configuration, parameter_pConfiguration)
      		));
      		// 	find instanceSpecificationsAsManifestationsOfNodeArtifacts(_, service)
      		new PositivePatternCall(body, new FlatTuple(var___0_, var_service), InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	InstanceSpecification.slot (service, slot)
      		new TypeConstraint(body, new FlatTuple(var_service), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_service, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "slot")));
      		new Equality(body, var__virtual_0_, var_slot);
      		// 	Slot.value (slot, instance)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "value")));
      		new Equality(body, var__virtual_1_, var_instance);
      		// 	Slot.definingFeature (slot, feature)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature")));
      		new Equality(body, var__virtual_2_, var_feature);
      		// 	Property.name (feature, featureName)
      		new TypeConstraint(body, new FlatTuple(var_feature), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_feature, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_3_, var_featureName);
      		// 	InstanceValue.instance (instance, configuration)
      		new TypeConstraint(body, new FlatTuple(var_instance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceValue")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_instance, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceValue", "instance")));
      		new Equality(body, var__virtual_4_, var_configuration);
      		// 	check (		featureName == "conf"	)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern serviceConfigurations";
      		    }
      		    
      		    @Override
      		    public Iterable<String> getInputParameterNames() {
      		        return Arrays.asList("featureName");}
      		
      		    @Override
      		    public Object evaluateExpression(IValueProvider provider) throws Exception {
      		        String featureName = (String) provider.getValue("featureName");
      		        return evaluateExpression_1_1(featureName);
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
  
  private static boolean evaluateExpression_1_1(final String featureName) {
    boolean _equals = Objects.equal(featureName, "conf");
    return _equals;
  }
}
