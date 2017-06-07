/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.RealizationsMatch;
import eu.supersede.dynadapt.usecases.patterns.util.RealizationsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.patterns.realizations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link RealizationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern realizations(client, supplier) {
 * 	find classes(supplier, _);
 * 	Realization.supplier(realization, supplier);
 * 	find instances(client, _);
 * 	Realization.client(realization, client);
 * 
 * }
 * </pre></code>
 * 
 * @see RealizationsMatch
 * @see RealizationsProcessor
 * @see RealizationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class RealizationsMatcher extends BaseMatcher<RealizationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static RealizationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    RealizationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (RealizationsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static RealizationsMatcher create() throws ViatraQueryException {
    return new RealizationsMatcher();
  }
  
  private final static int POSITION_CLIENT = 0;
  
  private final static int POSITION_SUPPLIER = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(RealizationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private RealizationsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return matches represented as a RealizationsMatch object.
   * 
   */
  public Collection<RealizationsMatch> getAllMatches(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return rawGetAllMatches(new Object[]{pClient, pSupplier});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return a match represented as a RealizationsMatch object, or null if no match is found.
   * 
   */
  public RealizationsMatch getOneArbitraryMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return rawGetOneArbitraryMatch(new Object[]{pClient, pSupplier});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return rawHasMatch(new Object[]{pClient, pSupplier});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return rawCountMatches(new Object[]{pClient, pSupplier});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier, final IMatchProcessor<? super RealizationsMatch> processor) {
    rawForEachMatch(new Object[]{pClient, pSupplier}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier, final IMatchProcessor<? super RealizationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pClient, pSupplier}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public RealizationsMatch newMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return RealizationsMatch.newMatch(pClient, pSupplier);
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
  public Set<InstanceSpecification> getAllValuesOfclient(final RealizationsMatch partialMatch) {
    return rawAccumulateAllValuesOfclient(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfclient(final org.eclipse.uml2.uml.Class pSupplier) {
    return rawAccumulateAllValuesOfclient(new Object[]{
    null, 
    pSupplier
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfsupplier(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_SUPPLIER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsupplier() {
    return rawAccumulateAllValuesOfsupplier(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsupplier(final RealizationsMatch partialMatch) {
    return rawAccumulateAllValuesOfsupplier(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsupplier(final InstanceSpecification pClient) {
    return rawAccumulateAllValuesOfsupplier(new Object[]{
    pClient, 
    null
    });
  }
  
  @Override
  protected RealizationsMatch tupleToMatch(final Tuple t) {
    try {
    	return RealizationsMatch.newMatch((InstanceSpecification) t.get(POSITION_CLIENT), (org.eclipse.uml2.uml.Class) t.get(POSITION_SUPPLIER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RealizationsMatch arrayToMatch(final Object[] match) {
    try {
    	return RealizationsMatch.newMatch((InstanceSpecification) match[POSITION_CLIENT], (org.eclipse.uml2.uml.Class) match[POSITION_SUPPLIER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RealizationsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return RealizationsMatch.newMutableMatch((InstanceSpecification) match[POSITION_CLIENT], (org.eclipse.uml2.uml.Class) match[POSITION_SUPPLIER]);
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
  public static IQuerySpecification<RealizationsMatcher> querySpecification() throws ViatraQueryException {
    return RealizationsQuerySpecification.instance();
  }
}
