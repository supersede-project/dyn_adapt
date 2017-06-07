/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.usecases.patterns.ClassGeneralizationsMatch;
import eu.supersede.dynadapt.usecases.patterns.ClassGeneralizationsMatcher;
import eu.supersede.dynadapt.usecases.patterns.util.ClassesQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ClassGeneralizationsMatcher in a type-safe way.
 * 
 * @see ClassGeneralizationsMatcher
 * @see ClassGeneralizationsMatch
 * 
 */
@SuppressWarnings("all")
public final class ClassGeneralizationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ClassGeneralizationsMatcher> {
  private ClassGeneralizationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClassGeneralizationsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ClassGeneralizationsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ClassGeneralizationsMatcher.on(engine);
  }
  
  @Override
  public ClassGeneralizationsMatcher instantiate() throws ViatraQueryException {
    return ClassGeneralizationsMatcher.create();
  }
  
  @Override
  public ClassGeneralizationsMatch newEmptyMatch() {
    return ClassGeneralizationsMatch.newEmptyMatch();
  }
  
  @Override
  public ClassGeneralizationsMatch newMatch(final Object... parameters) {
    return ClassGeneralizationsMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ClassGeneralizationsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ClassGeneralizationsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ClassGeneralizationsQuerySpecification INSTANCE = new ClassGeneralizationsQuerySpecification();
    
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
    private final static ClassGeneralizationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pClass = new PParameter("class", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pGeneralizationTarget = new PParameter("generalizationTarget", "org.eclipse.uml2.uml.Element", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Element")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pClass, parameter_pGeneralizationTarget);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.usecases.patterns.classGeneralizations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("class","generalizationTarget");
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
      		PVariable var_class = body.getOrCreateVariableByName("class");
      		PVariable var_generalizationTarget = body.getOrCreateVariableByName("generalizationTarget");
      		PVariable var__name = body.getOrCreateVariableByName("_name");
      		PVariable var_generalization = body.getOrCreateVariableByName("generalization");
      		new TypeConstraint(body, new FlatTuple(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_generalizationTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_class, parameter_pClass),
      		   new ExportedParameter(body, var_generalizationTarget, parameter_pGeneralizationTarget)
      		));
      		// 	find classes(class, _name)
      		new PositivePatternCall(body, new FlatTuple(var_class, var__name), ClassesQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Class.generalization(class, generalization)
      		new TypeConstraint(body, new FlatTuple(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_class, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier", "generalization")));
      		new Equality(body, var__virtual_0_, var_generalization);
      		// 	Generalization.general(generalization, generalizationTarget)
      		new TypeConstraint(body, new FlatTuple(var_generalization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_generalization, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "general")));
      		new Equality(body, var__virtual_1_, var_generalizationTarget);
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
