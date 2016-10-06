/*******************************************************************************
 * Copyright (c) 2016 UPC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
/**
 * Generated from platform:/resource/eu.supersede.monitor.reconfiguration.poc.uml.query/src/queries/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.monitor.reconfiguration.queries.util;

import com.google.common.collect.Sets;

import eu.supersede.monitor.reconfiguration.queries.ClassGeneralizationsMatch;
import eu.supersede.monitor.reconfiguration.queries.ClassGeneralizationsMatcher;
import eu.supersede.monitor.reconfiguration.queries.util.ClassesQuerySpecification;

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
    
    @Override
    public String getFullyQualifiedName() {
      return "queries.classGeneralizations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("class","generalizationTarget");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("class", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class"))),
      			 new PParameter("generalizationTarget", "org.eclipse.uml2.uml.Element", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Element")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
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
      		   new ExportedParameter(body, var_class, "class"),
      		   new ExportedParameter(body, var_generalizationTarget, "generalizationTarget")
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
