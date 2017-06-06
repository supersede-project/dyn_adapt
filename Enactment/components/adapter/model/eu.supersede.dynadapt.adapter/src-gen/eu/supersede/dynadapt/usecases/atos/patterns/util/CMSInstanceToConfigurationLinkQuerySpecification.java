/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.atos.patterns.CMSInstanceToConfigurationLinkMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.CMSInstanceToConfigurationLinkMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.util.InstanceSpecificationLinkQuerySpecification;
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
 * A pattern-specific query specification that can instantiate CMSInstanceToConfigurationLinkMatcher in a type-safe way.
 * 
 * @see CMSInstanceToConfigurationLinkMatcher
 * @see CMSInstanceToConfigurationLinkMatch
 * 
 */
@SuppressWarnings("all")
public final class CMSInstanceToConfigurationLinkQuerySpecification extends BaseGeneratedEMFQuerySpecification<CMSInstanceToConfigurationLinkMatcher> {
  private CMSInstanceToConfigurationLinkQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static CMSInstanceToConfigurationLinkQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected CMSInstanceToConfigurationLinkMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CMSInstanceToConfigurationLinkMatcher.on(engine);
  }
  
  @Override
  public CMSInstanceToConfigurationLinkMatcher instantiate() throws ViatraQueryException {
    return CMSInstanceToConfigurationLinkMatcher.create();
  }
  
  @Override
  public CMSInstanceToConfigurationLinkMatch newEmptyMatch() {
    return CMSInstanceToConfigurationLinkMatch.newEmptyMatch();
  }
  
  @Override
  public CMSInstanceToConfigurationLinkMatch newMatch(final Object... parameters) {
    return CMSInstanceToConfigurationLinkMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.InstanceSpecification) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link CMSInstanceToConfigurationLinkQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link CMSInstanceToConfigurationLinkQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static CMSInstanceToConfigurationLinkQuerySpecification INSTANCE = new CMSInstanceToConfigurationLinkQuerySpecification();
    
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
    private final static CMSInstanceToConfigurationLinkQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pLink = new PParameter("link", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pInstance = new PParameter("instance", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pLink, parameter_pInstance);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.atos.patterns.CMSInstanceToConfigurationLink";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("link","instance");
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
      		PVariable var_link = body.getOrCreateVariableByName("link");
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		PVariable var_slot = body.getOrCreateVariableByName("slot");
      		PVariable var_value = body.getOrCreateVariableByName("value");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_link, parameter_pLink),
      		   new ExportedParameter(body, var_instance, parameter_pInstance)
      		));
      		// 	find InstanceSpecificationLink(link)
      		new PositivePatternCall(body, new FlatTuple(var_link), InstanceSpecificationLinkQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	InstanceSpecification.slot (link, slot)
      		new TypeConstraint(body, new FlatTuple(var_link), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_link, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "slot")));
      		new Equality(body, var__virtual_0_, var_slot);
      		// 	Slot.value (slot,value)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "value")));
      		new Equality(body, var__virtual_1_, var_value);
      		// 	InstanceValue.instance (value, instance)
      		new TypeConstraint(body, new FlatTuple(var_value), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceValue")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_value, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceValue", "instance")));
      		new Equality(body, var__virtual_2_, var_instance);
      		// 	InstanceSpecification.name (instance, name)
      		new TypeConstraint(body, new FlatTuple(var_instance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_instance, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_3_, var_name);
      		// 	check (		name.equals("CMS Instance")	)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern CMSInstanceToConfigurationLink";
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
    boolean _equals = name.equals("CMS Instance");
    return _equals;
  }
}
