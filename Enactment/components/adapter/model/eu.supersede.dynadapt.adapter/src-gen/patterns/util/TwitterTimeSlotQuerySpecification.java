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
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
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
import patterns.TwitterTimeSlotMatch;
import patterns.TwitterTimeSlotMatcher;

/**
 * A pattern-specific query specification that can instantiate TwitterTimeSlotMatcher in a type-safe way.
 * 
 * @see TwitterTimeSlotMatcher
 * @see TwitterTimeSlotMatch
 * 
 */
@SuppressWarnings("all")
public final class TwitterTimeSlotQuerySpecification extends BaseGeneratedEMFQuerySpecification<TwitterTimeSlotMatcher> {
  private TwitterTimeSlotQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static TwitterTimeSlotQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TwitterTimeSlotMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return TwitterTimeSlotMatcher.on(engine);
  }
  
  @Override
  public TwitterTimeSlotMatcher instantiate() throws ViatraQueryException {
    return TwitterTimeSlotMatcher.create();
  }
  
  @Override
  public TwitterTimeSlotMatch newEmptyMatch() {
    return TwitterTimeSlotMatch.newEmptyMatch();
  }
  
  @Override
  public TwitterTimeSlotMatch newMatch(final Object... parameters) {
    return TwitterTimeSlotMatch.newMatch((org.eclipse.uml2.uml.Slot) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link TwitterTimeSlotQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link TwitterTimeSlotQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static TwitterTimeSlotQuerySpecification INSTANCE = new TwitterTimeSlotQuerySpecification();
    
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
    private final static TwitterTimeSlotQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pSlot = new PParameter("slot", "org.eclipse.uml2.uml.Slot", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pSlot);
    
    @Override
    public String getFullyQualifiedName() {
      return "patterns.twitterTimeSlot";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("slot");
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
      		PVariable var_slot = body.getOrCreateVariableByName("slot");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		PVariable var_instanceName = body.getOrCreateVariableByName("instanceName");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_slot, parameter_pSlot)
      		));
      		// 	Slot.definingFeature.name(slot, name)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_1_, var_name);
      		// 	Slot.owningInstance.classifier.name(slot, instanceName)
      		new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "owningInstance")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_3_, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_4_, var_instanceName);
      		// 	check(name.equals("timeSlot"))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern twitterTimeSlot";
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
      		// 	check(instanceName.equals("SocialNetworks"))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern twitterTimeSlot";
      		    }
      		    
      		    @Override
      		    public Iterable<String> getInputParameterNames() {
      		        return Arrays.asList("instanceName");}
      		
      		    @Override
      		    public Object evaluateExpression(IValueProvider provider) throws Exception {
      		        String instanceName = (String) provider.getValue("instanceName");
      		        return evaluateExpression_1_2(instanceName);
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
    boolean _equals = name.equals("timeSlot");
    return _equals;
  }
  
  private static boolean evaluateExpression_1_2(final String instanceName) {
    boolean _equals = instanceName.equals("SocialNetworks");
    return _equals;
  }
}
