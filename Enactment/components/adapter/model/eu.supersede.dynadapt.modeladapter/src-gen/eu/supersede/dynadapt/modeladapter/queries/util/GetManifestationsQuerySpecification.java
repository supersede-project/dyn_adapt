/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.modeladapter.queries.GetManifestationsMatch;
import eu.supersede.dynadapt.modeladapter.queries.GetManifestationsMatcher;
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
 * A pattern-specific query specification that can instantiate GetManifestationsMatcher in a type-safe way.
 * 
 * @see GetManifestationsMatcher
 * @see GetManifestationsMatch
 * 
 */
@SuppressWarnings("all")
public final class GetManifestationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<GetManifestationsMatcher> {
  private GetManifestationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static GetManifestationsQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected GetManifestationsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return GetManifestationsMatcher.on(engine);
  }
  
  @Override
  public GetManifestationsMatcher instantiate() throws ViatraQueryException {
    return GetManifestationsMatcher.create();
  }
  
  @Override
  public GetManifestationsMatch newEmptyMatch() {
    return GetManifestationsMatch.newEmptyMatch();
  }
  
  @Override
  public GetManifestationsMatch newMatch(final Object... parameters) {
    return GetManifestationsMatch.newMatch((org.eclipse.uml2.uml.Manifestation) parameters[0], (org.eclipse.uml2.uml.ExecutionEnvironment) parameters[1], (org.eclipse.uml2.uml.InstanceSpecification) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link GetManifestationsQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link GetManifestationsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static GetManifestationsQuerySpecification INSTANCE = new GetManifestationsQuerySpecification();
    
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
    private final static GetManifestationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pManifestation = new PParameter("manifestation", "org.eclipse.uml2.uml.Manifestation", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pClient = new PParameter("client", "org.eclipse.uml2.uml.ExecutionEnvironment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pSupplier = new PParameter("supplier", "org.eclipse.uml2.uml.InstanceSpecification", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pManifestation, parameter_pClient, parameter_pSupplier);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.modeladapter.queries.getManifestations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("manifestation","client","supplier");
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
              PVariable var_manifestation = body.getOrCreateVariableByName("manifestation");
              PVariable var_client = body.getOrCreateVariableByName("client");
              PVariable var_supplier = body.getOrCreateVariableByName("supplier");
              new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
              new TypeConstraint(body, new FlatTuple(var_client), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ExecutionEnvironment")));
              new TypeConstraint(body, new FlatTuple(var_supplier), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_manifestation, parameter_pManifestation),
                 new ExportedParameter(body, var_client, parameter_pClient),
                 new ExportedParameter(body, var_supplier, parameter_pSupplier)
              ));
              // 	Manifestation.client (manifestation, client)
              new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, new FlatTuple(var_manifestation, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "client")));
              new TypeConstraint(body, new FlatTuple(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement")));
              new Equality(body, var__virtual_0_, var_client);
              // 	Manifestation.supplier (manifestation, supplier)
              new TypeConstraint(body, new FlatTuple(var_manifestation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Manifestation")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, new FlatTuple(var_manifestation, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "supplier")));
              new TypeConstraint(body, new FlatTuple(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement")));
              new Equality(body, var__virtual_1_, var_supplier);
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
