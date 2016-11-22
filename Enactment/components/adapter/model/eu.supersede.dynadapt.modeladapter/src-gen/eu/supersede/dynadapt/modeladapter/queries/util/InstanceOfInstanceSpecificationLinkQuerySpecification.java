package eu.supersede.dynadapt.modeladapter.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatch;
import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceSpecificationLinkQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate InstanceOfInstanceSpecificationLinkMatcher in a type-safe way.
 * 
 * @see InstanceOfInstanceSpecificationLinkMatcher
 * @see InstanceOfInstanceSpecificationLinkMatch
 * 
 */
@SuppressWarnings("all")
public final class InstanceOfInstanceSpecificationLinkQuerySpecification extends BaseGeneratedEMFQuerySpecification<InstanceOfInstanceSpecificationLinkMatcher> {
  private InstanceOfInstanceSpecificationLinkQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static InstanceOfInstanceSpecificationLinkQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InstanceOfInstanceSpecificationLinkMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceOfInstanceSpecificationLinkMatcher.on(engine);
  }
  
  @Override
  public InstanceOfInstanceSpecificationLinkMatch newEmptyMatch() {
    return InstanceOfInstanceSpecificationLinkMatch.newEmptyMatch();
  }
  
  @Override
  public InstanceOfInstanceSpecificationLinkMatch newMatch(final Object... parameters) {
    return InstanceOfInstanceSpecificationLinkMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.InstanceSpecification) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link InstanceOfInstanceSpecificationLinkQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link InstanceOfInstanceSpecificationLinkQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static InstanceOfInstanceSpecificationLinkQuerySpecification INSTANCE = new InstanceOfInstanceSpecificationLinkQuerySpecification();
    
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
    private final static InstanceOfInstanceSpecificationLinkQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLink";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("link","instance");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("link", "org.eclipse.uml2.uml.InstanceSpecification", null),
      			 new PParameter("instance", "org.eclipse.uml2.uml.InstanceSpecification", null)
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_link = body.getOrCreateVariableByName("link");
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		PVariable var_slot = body.getOrCreateVariableByName("slot");
      		PVariable var_value = body.getOrCreateVariableByName("value");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_link, "link"),
      		   new ExportedParameter(body, var_instance, "instance")
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