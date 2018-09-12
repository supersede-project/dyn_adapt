/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.modeladapter.queries.PropertiesWithTypeMatch;
import eu.supersede.dynadapt.modeladapter.queries.PropertiesWithTypeMatcher;
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
 * A pattern-specific query specification that can instantiate PropertiesWithTypeMatcher in a type-safe way.
 * 
 * @see PropertiesWithTypeMatcher
 * @see PropertiesWithTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class PropertiesWithTypeQuerySpecification extends BaseGeneratedEMFQuerySpecification<PropertiesWithTypeMatcher> {
  private PropertiesWithTypeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static PropertiesWithTypeQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PropertiesWithTypeMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return PropertiesWithTypeMatcher.on(engine);
  }
  
  @Override
  public PropertiesWithTypeMatcher instantiate() throws ViatraQueryException {
    return PropertiesWithTypeMatcher.create();
  }
  
  @Override
  public PropertiesWithTypeMatch newEmptyMatch() {
    return PropertiesWithTypeMatch.newEmptyMatch();
  }
  
  @Override
  public PropertiesWithTypeMatch newMatch(final Object... parameters) {
    return PropertiesWithTypeMatch.newMatch((org.eclipse.uml2.uml.Property) parameters[0], (org.eclipse.uml2.uml.Type) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link PropertiesWithTypeQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link PropertiesWithTypeQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static PropertiesWithTypeQuerySpecification INSTANCE = new PropertiesWithTypeQuerySpecification();
    
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
    private final static PropertiesWithTypeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pProperty = new PParameter("property", "org.eclipse.uml2.uml.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pType = new PParameter("type", "org.eclipse.uml2.uml.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pProperty, parameter_pType);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.modeladapter.queries.propertiesWithType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("property","type");
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
              PVariable var_property = body.getOrCreateVariableByName("property");
              PVariable var_type = body.getOrCreateVariableByName("type");
              new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
              new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_property, parameter_pProperty),
                 new ExportedParameter(body, var_type, parameter_pType)
              ));
              // 	Property.type (property, type)
              new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, new FlatTuple(var_property, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
              new TypeConstraint(body, new FlatTuple(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
              new Equality(body, var__virtual_0_, var_type);
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
