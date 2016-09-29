/**
 * Generated from platform:/resource/eu.supersede.monitor.reconfiguration.poc.uml.query/src/queries/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.monitor.reconfiguration.queries.util;

import com.google.common.collect.Sets;

import eu.supersede.monitor.reconfiguration.queries.RealizationsMatch;
import eu.supersede.monitor.reconfiguration.queries.RealizationsMatcher;
import eu.supersede.monitor.reconfiguration.queries.util.ClassesQuerySpecification;
import eu.supersede.monitor.reconfiguration.queries.util.InstancesQuerySpecification;

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
 * A pattern-specific query specification that can instantiate RealizationsMatcher in a type-safe way.
 * 
 * @see RealizationsMatcher
 * @see RealizationsMatch
 * 
 */
@SuppressWarnings("all")
public final class RealizationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<RealizationsMatcher> {
  private RealizationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static RealizationsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RealizationsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return RealizationsMatcher.on(engine);
  }
  
  @Override
  public RealizationsMatch newEmptyMatch() {
    return RealizationsMatch.newEmptyMatch();
  }
  
  @Override
  public RealizationsMatch newMatch(final Object... parameters) {
    return RealizationsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link RealizationsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link RealizationsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static RealizationsQuerySpecification INSTANCE = new RealizationsQuerySpecification();
    
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
    private final static RealizationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "queries.realizations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("client","supplier");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("client", "org.eclipse.uml2.uml.InstanceSpecification"),
      			 new PParameter("supplier", "org.eclipse.uml2.uml.Class")
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_client = body.getOrCreateVariableByName("client");
      		PVariable var_supplier = body.getOrCreateVariableByName("supplier");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var_realization = body.getOrCreateVariableByName("realization");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_client, "client"),
      		   new ExportedParameter(body, var_supplier, "supplier")
      		));
      		// 	find classes(supplier, _)
      		new PositivePatternCall(body, new FlatTuple(var_supplier, var___0_), ClassesQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Realization.supplier(realization, supplier)
      		new TypeConstraint(body, new FlatTuple(var_realization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Realization")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_realization, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "supplier")));
      		new Equality(body, var__virtual_0_, var_supplier);
      		// 	find instances(client, _)
      		new PositivePatternCall(body, new FlatTuple(var_client, var___1_), InstancesQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Realization.client(realization, client)
      		new TypeConstraint(body, new FlatTuple(var_realization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Realization")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_realization, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "client")));
      		new Equality(body, var__virtual_1_, var_client);
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
