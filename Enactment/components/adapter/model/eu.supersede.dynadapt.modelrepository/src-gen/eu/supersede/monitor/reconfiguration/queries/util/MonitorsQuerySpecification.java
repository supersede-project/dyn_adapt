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

import eu.supersede.monitor.reconfiguration.queries.MonitorsMatch;
import eu.supersede.monitor.reconfiguration.queries.MonitorsMatcher;
import eu.supersede.monitor.reconfiguration.queries.util.ClassGeneralizationsQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MonitorsMatcher in a type-safe way.
 * 
 * @see MonitorsMatcher
 * @see MonitorsMatch
 * 
 */
@SuppressWarnings("all")
public final class MonitorsQuerySpecification extends BaseGeneratedEMFQuerySpecification<MonitorsMatcher> {
  private MonitorsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MonitorsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MonitorsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MonitorsMatcher.on(engine);
  }
  
  @Override
  public MonitorsMatch newEmptyMatch() {
    return MonitorsMatch.newEmptyMatch();
  }
  
  @Override
  public MonitorsMatch newMatch(final Object... parameters) {
    return MonitorsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1], (org.eclipse.uml2.uml.Class) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MonitorsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MonitorsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MonitorsQuerySpecification INSTANCE = new MonitorsQuerySpecification();
    
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
    private final static MonitorsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "queries.monitors";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("client","supplier","generalization");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("client", "org.eclipse.uml2.uml.InstanceSpecification"),
      			 new PParameter("supplier", "org.eclipse.uml2.uml.Class"),
      			 new PParameter("generalization", "org.eclipse.uml2.uml.Class")
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
      		PVariable var_generalization = body.getOrCreateVariableByName("generalization");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		PVariable var_realization = body.getOrCreateVariableByName("realization");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_client, "client"),
      		   new ExportedParameter(body, var_supplier, "supplier"),
      		   new ExportedParameter(body, var_generalization, "generalization")
      		));
      		// 	find classGeneralizations(supplier, generalization)
      		new PositivePatternCall(body, new FlatTuple(var_supplier, var_generalization), ClassGeneralizationsQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Class.name(generalization, name)
      		new TypeConstraint(body, new FlatTuple(var_generalization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_generalization, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name);
      		// 	check(name.equals("AMonitor"))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern monitors";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("name");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.String name = (java.lang.String) provider.getValue("name");
      		                                    return evaluateExpression_1_1(name);
      		                                }
      		
      		                        },  null); // 	Realization.supplier(realization, supplier)
      		new TypeConstraint(body, new FlatTuple(var_realization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Realization")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_realization, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "supplier")));
      		new Equality(body, var__virtual_1_, var_supplier);
      		// 	find instances(client, _)
      		new PositivePatternCall(body, new FlatTuple(var_client, var___0_), InstancesQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Realization.client(realization, client)
      		new TypeConstraint(body, new FlatTuple(var_realization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Realization")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_realization, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Dependency", "client")));
      		new Equality(body, var__virtual_2_, var_client);
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
    boolean _equals = name.equals("AMonitor");
    return _equals;
  }
}
