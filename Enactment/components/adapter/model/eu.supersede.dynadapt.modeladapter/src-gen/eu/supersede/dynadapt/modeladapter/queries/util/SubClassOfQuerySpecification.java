/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import com.google.common.collect.Sets;
import eu.supersede.dynadapt.modeladapter.queries.SubClassOfMatch;
import eu.supersede.dynadapt.modeladapter.queries.SubClassOfMatcher;
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
 * A pattern-specific query specification that can instantiate SubClassOfMatcher in a type-safe way.
 * 
 * @see SubClassOfMatcher
 * @see SubClassOfMatch
 * 
 */
@SuppressWarnings("all")
public final class SubClassOfQuerySpecification extends BaseGeneratedEMFQuerySpecification<SubClassOfMatcher> {
  private SubClassOfQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static SubClassOfQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SubClassOfMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SubClassOfMatcher.on(engine);
  }
  
  @Override
  public SubClassOfMatcher instantiate() throws ViatraQueryException {
    return SubClassOfMatcher.create();
  }
  
  @Override
  public SubClassOfMatch newEmptyMatch() {
    return SubClassOfMatch.newEmptyMatch();
  }
  
  @Override
  public SubClassOfMatch newMatch(final Object... parameters) {
    return SubClassOfMatch.newMatch((org.eclipse.uml2.uml.Classifier) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link SubClassOfQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link SubClassOfQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static SubClassOfQuerySpecification INSTANCE = new SubClassOfQuerySpecification();
    
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
    private final static SubClassOfQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pSubclass = new PParameter("subclass", "org.eclipse.uml2.uml.Classifier", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pSuperclass = new PParameter("superclass", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pSubclass, parameter_pSuperclass);
    
    @Override
    public String getFullyQualifiedName() {
      return "eu.supersede.dynadapt.modeladapter.queries.subClassOf";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("subclass","superclass");
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
      		PVariable var_subclass = body.getOrCreateVariableByName("subclass");
      		PVariable var_superclass = body.getOrCreateVariableByName("superclass");
      		PVariable var_generalization = body.getOrCreateVariableByName("generalization");
      		new TypeConstraint(body, new FlatTuple(var_subclass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier")));
      		new TypeConstraint(body, new FlatTuple(var_superclass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_subclass, parameter_pSubclass),
      		   new ExportedParameter(body, var_superclass, parameter_pSuperclass)
      		));
      		//     Generalization.general (generalization, superclass)
      		new TypeConstraint(body, new FlatTuple(var_generalization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_generalization, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "general")));
      		new Equality(body, var__virtual_0_, var_superclass);
      		// 	Generalization.specific (generalization, subclass)
      		new TypeConstraint(body, new FlatTuple(var_generalization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_generalization, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "specific")));
      		new Equality(body, var__virtual_1_, var_subclass);
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
