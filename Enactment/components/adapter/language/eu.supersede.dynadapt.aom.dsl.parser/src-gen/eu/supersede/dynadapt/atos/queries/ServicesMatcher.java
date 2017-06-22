/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.ServicesMatch;
import eu.supersede.dynadapt.atos.queries.util.ServicesQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.atos.queries.services pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ServicesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern services (service){
 * 	find nodeArtifacts(_, service);
 * }
 * </pre></code>
 * 
 * @see ServicesMatch
 * @see ServicesProcessor
 * @see ServicesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ServicesMatcher extends BaseMatcher<ServicesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ServicesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ServicesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (ServicesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ServicesMatcher create() throws ViatraQueryException {
    return new ServicesMatcher();
  }
  
  private final static int POSITION_SERVICE = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ServicesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ServicesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return matches represented as a ServicesMatch object.
   * 
   */
  public Collection<ServicesMatch> getAllMatches(final Artifact pService) {
    return rawGetAllMatches(new Object[]{pService});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return a match represented as a ServicesMatch object, or null if no match is found.
   * 
   */
  public ServicesMatch getOneArbitraryMatch(final Artifact pService) {
    return rawGetOneArbitraryMatch(new Object[]{pService});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Artifact pService) {
    return rawHasMatch(new Object[]{pService});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Artifact pService) {
    return rawCountMatches(new Object[]{pService});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Artifact pService, final IMatchProcessor<? super ServicesMatch> processor) {
    rawForEachMatch(new Object[]{pService}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Artifact pService, final IMatchProcessor<? super ServicesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pService}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ServicesMatch newMatch(final Artifact pService) {
    return ServicesMatch.newMatch(pService);
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Artifact> rawAccumulateAllValuesOfservice(final Object[] parameters) {
    Set<Artifact> results = new HashSet<Artifact>();
    rawAccumulateAllValues(POSITION_SERVICE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfservice() {
    return rawAccumulateAllValuesOfservice(emptyArray());
  }
  
  @Override
  protected ServicesMatch tupleToMatch(final Tuple t) {
    try {
    	return ServicesMatch.newMatch((Artifact) t.get(POSITION_SERVICE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ServicesMatch arrayToMatch(final Object[] match) {
    try {
    	return ServicesMatch.newMatch((Artifact) match[POSITION_SERVICE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ServicesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ServicesMatch.newMutableMatch((Artifact) match[POSITION_SERVICE]);
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
  public static IQuerySpecification<ServicesMatcher> querySpecification() throws ViatraQueryException {
    return ServicesQuerySpecification.instance();
  }
}
