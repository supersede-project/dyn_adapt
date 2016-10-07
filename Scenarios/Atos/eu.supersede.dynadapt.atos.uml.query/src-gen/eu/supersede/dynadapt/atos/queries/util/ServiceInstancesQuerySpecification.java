/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.atos.queries.ServiceInstancesMatch;
import eu.supersede.dynadapt.atos.queries.ServiceInstancesMatcher;
import eu.supersede.dynadapt.atos.queries.util.ArtifactManifestationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ServiceInstancesMatcher in a type-safe way.
 * 
 * @see ServiceInstancesMatcher
 * @see ServiceInstancesMatch
 * 
 */
@SuppressWarnings("all")
public final class ServiceInstancesQuerySpecification extends BaseGeneratedEMFQuerySpecification<ServiceInstancesMatcher> {
  private ServiceInstancesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ServiceInstancesQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ServiceInstancesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ServiceInstancesMatcher.on(engine);
  }
  
  @Override
  public ServiceInstancesMatch newEmptyMatch() {
    return ServiceInstancesMatch.newEmptyMatch();
  }
  
  @Override
  public ServiceInstancesMatch newMatch(final Object... parameters) {
    return ServiceInstancesMatch.newMatch((org.eclipse.uml2.uml.Artifact) parameters[0], (org.eclipse.uml2.uml.NamedElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ServiceInstancesQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ServiceInstancesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ServiceInstancesQuerySpecification INSTANCE = new ServiceInstancesQuerySpecification();
    
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
    private final static ServiceInstancesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.atos.queries.serviceInstances";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("service","instance");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("service", "org.eclipse.uml2.uml.Artifact"),
      			 new PParameter("instance", "org.eclipse.uml2.uml.NamedElement")
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_service = body.getOrCreateVariableByName("service");
      		PVariable var_instance = body.getOrCreateVariableByName("instance");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_service, "service"),
      		   new ExportedParameter(body, var_instance, "instance")
      		));
      		// 	find artifactManifestations(service, instance)
      		new PositivePatternCall(body, new FlatTuple(var_service, var_instance), ArtifactManifestationsQuerySpecification.instance().getInternalQueryRepresentation());
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
