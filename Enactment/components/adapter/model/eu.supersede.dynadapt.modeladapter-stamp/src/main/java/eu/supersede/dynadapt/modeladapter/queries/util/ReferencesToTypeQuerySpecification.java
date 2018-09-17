/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.modeladapter.queries.ReferencesToTypeMatch;
import eu.supersede.dynadapt.modeladapter.queries.ReferencesToTypeMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.ParametersWithTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.PropertiesWithTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.SubClassOfQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReferencesToTypeMatcher in a type-safe way.
 * 
 * @see ReferencesToTypeMatcher
 * @see ReferencesToTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class ReferencesToTypeQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReferencesToTypeMatcher> {
  private ReferencesToTypeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReferencesToTypeQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReferencesToTypeMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ReferencesToTypeMatcher.on(engine);
  }
  
  @Override
  public ReferencesToTypeMatcher instantiate() throws ViatraQueryException {
    return ReferencesToTypeMatcher.create();
  }
  
  @Override
  public ReferencesToTypeMatch newEmptyMatch() {
    return ReferencesToTypeMatch.newEmptyMatch();
  }
  
  @Override
  public ReferencesToTypeMatch newMatch(final Object... parameters) {
    return ReferencesToTypeMatch.newMatch((org.eclipse.uml2.uml.Element) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ReferencesToTypeQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ReferencesToTypeQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ReferencesToTypeQuerySpecification INSTANCE = new ReferencesToTypeQuerySpecification();
    
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
    private final static ReferencesToTypeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pElement = new PParameter("element", "org.eclipse.uml2.uml.Element", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Element")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pType = new PParameter("type", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pElement, parameter_pType);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.modeladapter.queries.referencesToType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("element","type");
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
              PVariable var_element = body.getOrCreateVariableByName("element");
              PVariable var_type = body.getOrCreateVariableByName("type");
              new TypeConstraint(body, new FlatTuple(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
              new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_element, parameter_pElement),
                 new ExportedParameter(body, var_type, parameter_pType)
              ));
              // 	find subClassOf(element, type)
              new PositivePatternCall(body, new FlatTuple(var_element, var_type), SubClassOfQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          {
              PBody body = new PBody(this);
              PVariable var_element = body.getOrCreateVariableByName("element");
              PVariable var_type = body.getOrCreateVariableByName("type");
              new TypeConstraint(body, new FlatTuple(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
              new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_element, parameter_pElement),
                 new ExportedParameter(body, var_type, parameter_pType)
              ));
              // 	find propertiesWithType (element, type)
              new PositivePatternCall(body, new FlatTuple(var_element, var_type), PropertiesWithTypeQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          {
              PBody body = new PBody(this);
              PVariable var_element = body.getOrCreateVariableByName("element");
              PVariable var_type = body.getOrCreateVariableByName("type");
              new TypeConstraint(body, new FlatTuple(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
              new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_element, parameter_pElement),
                 new ExportedParameter(body, var_type, parameter_pType)
              ));
              // 	find parametersWithType(element, type)
              new PositivePatternCall(body, new FlatTuple(var_element, var_type), ParametersWithTypeQuerySpecification.instance().getInternalQueryRepresentation());
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
