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
package eu.supersede.monitor.reconfiguration.queries;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

import eu.supersede.monitor.reconfiguration.queries.MonitorsMatch;
import eu.supersede.monitor.reconfiguration.queries.util.MonitorsQuerySpecification;

/**
 * Generated pattern matcher API of the queries.monitors pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MonitorsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern monitors(client, supplier, generalization) {
 * 	find classGeneralizations(supplier, generalization);
 * 	Class.name(generalization, name);
 * 	check(name.equals("AMonitor"));
 * 	Realization.supplier(realization, supplier);
 * 	find instances(client, _);
 * 	Realization.client(realization, client);
 * 
 * }
 * </pre></code>
 * 
 * @see MonitorsMatch
 * @see MonitorsProcessor
 * @see MonitorsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MonitorsMatcher extends BaseMatcher<MonitorsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MonitorsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MonitorsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MonitorsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CLIENT = 0;
  
  private final static int POSITION_SUPPLIER = 1;
  
  private final static int POSITION_GENERALIZATION = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MonitorsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MonitorsMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return matches represented as a MonitorsMatch object.
   * 
   */
  public Collection<MonitorsMatch> getAllMatches(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return rawGetAllMatches(new Object[]{pClient, pSupplier, pGeneralization});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return a match represented as a MonitorsMatch object, or null if no match is found.
   * 
   */
  public MonitorsMatch getOneArbitraryMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return rawGetOneArbitraryMatch(new Object[]{pClient, pSupplier, pGeneralization});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return rawHasMatch(new Object[]{pClient, pSupplier, pGeneralization});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return rawCountMatches(new Object[]{pClient, pSupplier, pGeneralization});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization, final IMatchProcessor<? super MonitorsMatch> processor) {
    rawForEachMatch(new Object[]{pClient, pSupplier, pGeneralization}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization, final IMatchProcessor<? super MonitorsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pClient, pSupplier, pGeneralization}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MonitorsMatch newMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return MonitorsMatch.newMatch(pClient, pSupplier, pGeneralization);
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfclient(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_CLIENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfclient() {
    return rawAccumulateAllValuesOfclient(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfclient(final MonitorsMatch partialMatch) {
    return rawAccumulateAllValuesOfclient(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfclient(final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return rawAccumulateAllValuesOfclient(new Object[]{
    null, 
    pSupplier, 
    pGeneralization
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<NamedElement> rawAccumulateAllValuesOfsupplier(final Object[] parameters) {
    Set<NamedElement> results = new HashSet<NamedElement>();
    rawAccumulateAllValues(POSITION_SUPPLIER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfsupplier() {
    return rawAccumulateAllValuesOfsupplier(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfsupplier(final MonitorsMatch partialMatch) {
    return rawAccumulateAllValuesOfsupplier(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfsupplier(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pGeneralization) {
    return rawAccumulateAllValuesOfsupplier(new Object[]{
    pClient, 
    null, 
    pGeneralization
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfgeneralization(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_GENERALIZATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfgeneralization() {
    return rawAccumulateAllValuesOfgeneralization(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfgeneralization(final MonitorsMatch partialMatch) {
    return rawAccumulateAllValuesOfgeneralization(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfgeneralization(final InstanceSpecification pClient, final NamedElement pSupplier) {
    return rawAccumulateAllValuesOfgeneralization(new Object[]{
    pClient, 
    pSupplier, 
    null
    });
  }
  
  @Override
  protected MonitorsMatch tupleToMatch(final Tuple t) {
    try {
    	return MonitorsMatch.newMatch((InstanceSpecification) t.get(POSITION_CLIENT), (org.eclipse.uml2.uml.Class) t.get(POSITION_SUPPLIER), (org.eclipse.uml2.uml.Class) t.get(POSITION_GENERALIZATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MonitorsMatch arrayToMatch(final Object[] match) {
    try {
    	return MonitorsMatch.newMatch((InstanceSpecification) match[POSITION_CLIENT], (org.eclipse.uml2.uml.Class) match[POSITION_SUPPLIER], (org.eclipse.uml2.uml.Class) match[POSITION_GENERALIZATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MonitorsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MonitorsMatch.newMutableMatch((InstanceSpecification) match[POSITION_CLIENT], (org.eclipse.uml2.uml.Class) match[POSITION_SUPPLIER], (org.eclipse.uml2.uml.Class) match[POSITION_GENERALIZATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<MonitorsMatcher> querySpecification() throws ViatraQueryException {
    return MonitorsQuerySpecification.instance();
  }
}
