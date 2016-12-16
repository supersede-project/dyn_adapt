/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.atos.queries.MaxThreadValuesInCMSConfigurationsMatch;
import eu.supersede.dynadapt.atos.queries.MaxThreadValuesInCMSConfigurationsMatcher;
import eu.supersede.dynadapt.atos.queries.util.CMSConfigurationInstancesQuerySpecification;
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
 * A pattern-specific query specification that can instantiate MaxThreadValuesInCMSConfigurationsMatcher in a type-safe way.
 * 
 * @see MaxThreadValuesInCMSConfigurationsMatcher
 * @see MaxThreadValuesInCMSConfigurationsMatch
 * 
 */
@SuppressWarnings("all")
public final class MaxThreadValuesInCMSConfigurationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<MaxThreadValuesInCMSConfigurationsMatcher> {
  private MaxThreadValuesInCMSConfigurationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MaxThreadValuesInCMSConfigurationsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MaxThreadValuesInCMSConfigurationsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MaxThreadValuesInCMSConfigurationsMatcher.on(engine);
  }
  
  @Override
  public MaxThreadValuesInCMSConfigurationsMatcher instantiate() throws ViatraQueryException {
    return MaxThreadValuesInCMSConfigurationsMatcher.create();
  }
  
  @Override
  public MaxThreadValuesInCMSConfigurationsMatch newEmptyMatch() {
    return MaxThreadValuesInCMSConfigurationsMatch.newEmptyMatch();
  }
  
  @Override
  public MaxThreadValuesInCMSConfigurationsMatch newMatch(final Object... parameters) {
    return MaxThreadValuesInCMSConfigurationsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (java.lang.String) parameters[1], (java.lang.Integer) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MaxThreadValuesInCMSConfigurationsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MaxThreadValuesInCMSConfigurationsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MaxThreadValuesInCMSConfigurationsQuerySpecification INSTANCE = new MaxThreadValuesInCMSConfigurationsQuerySpecification();
    
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
    private final static MaxThreadValuesInCMSConfigurationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pConfiguration = new PParameter("configuration", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pName = new PParameter("name", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pValue = new PParameter("value", "java.lang.Integer", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pConfiguration, parameter_pName, parameter_pValue);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.atos.queries.maxThreadValuesInCMSConfigurations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("configuration","name","value");
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
      		PVariable var_configuration = body.getOrCreateVariableByName("configuration");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		PVariable var_value = body.getOrCreateVariableByName("value");
      		PVariable var_slot = body.getOrCreateVariableByName("slot");
      		PVariable var_feature = body.getOrCreateVariableByName("feature");
      		PVariable var_integer = body.getOrCreateVariableByName("integer");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_configuration, parameter_pConfiguration),
      		   new ExportedParameter(body, var_name, parameter_pName),
      		   new ExportedParameter(body, var_value, parameter_pValue)
      		));
      		// 	find CMSConfigurationInstances(configuration)
      		new PositivePatternCall(body, new FlatTuple(var_configuration), CMSConfigurationInstancesQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	InstanceSpecification.slot (configuration, slot)
      		new TypeConstraint(body, new FlatTuple(var_configuration), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_configuration, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "slot")));
      		new Equality(body, var__virtual_0_, var_slot);
      		// 	Slot.definingFeature (slot, feature)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature")));
      		new Equality(body, var__virtual_1_, var_feature);
      		// 	Property.name (feature, name)
      		new TypeConstraint(body, new FlatTuple(var_feature), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_feature, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_2_, var_name);
      		// 	Slot.value (slot, integer)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "value")));
      		new Equality(body, var__virtual_3_, var_integer);
      		// 	LiteralInteger.value (integer, value)
      		new TypeConstraint(body, new FlatTuple(var_integer), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "LiteralInteger")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_integer, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "LiteralInteger", "value")));
      		new Equality(body, var__virtual_4_, var_value);
      		// 	check (		name.equals("max_threads")	)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern maxThreadValuesInCMSConfigurations";
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
    boolean _equals = name.equals("max_threads");
    return _equals;
  }
}
