/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/siemens_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServicesMatch;
import eu.supersede.dynadapt.usecases.patterns.util.GetMeteorologicalDataServicesQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServices pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GetMeteorologicalDataServicesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern GetMeteorologicalDataServices(action : CallBehaviorAction) {
 * 	CallBehaviorAction.name(action, name);
 * 	check(name.equals("GetMteorologicalData"));
 * }
 * </pre></code>
 * 
 * @see GetMeteorologicalDataServicesMatch
 * @see GetMeteorologicalDataServicesProcessor
 * @see GetMeteorologicalDataServicesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GetMeteorologicalDataServicesMatcher extends BaseMatcher<GetMeteorologicalDataServicesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GetMeteorologicalDataServicesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    GetMeteorologicalDataServicesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (GetMeteorologicalDataServicesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static GetMeteorologicalDataServicesMatcher create() throws ViatraQueryException {
    return new GetMeteorologicalDataServicesMatcher();
  }
  
  private final static int POSITION_ACTION = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GetMeteorologicalDataServicesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private GetMeteorologicalDataServicesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return matches represented as a GetMeteorologicalDataServicesMatch object.
   * 
   */
  public Collection<GetMeteorologicalDataServicesMatch> getAllMatches(final CallBehaviorAction pAction) {
    return rawGetAllMatches(new Object[]{pAction});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return a match represented as a GetMeteorologicalDataServicesMatch object, or null if no match is found.
   * 
   */
  public GetMeteorologicalDataServicesMatch getOneArbitraryMatch(final CallBehaviorAction pAction) {
    return rawGetOneArbitraryMatch(new Object[]{pAction});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final CallBehaviorAction pAction) {
    return rawHasMatch(new Object[]{pAction});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final CallBehaviorAction pAction) {
    return rawCountMatches(new Object[]{pAction});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final CallBehaviorAction pAction, final IMatchProcessor<? super GetMeteorologicalDataServicesMatch> processor) {
    rawForEachMatch(new Object[]{pAction}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final CallBehaviorAction pAction, final IMatchProcessor<? super GetMeteorologicalDataServicesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAction}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GetMeteorologicalDataServicesMatch newMatch(final CallBehaviorAction pAction) {
    return GetMeteorologicalDataServicesMatch.newMatch(pAction);
  }
  
  /**
   * Retrieve the set of values that occur in matches for action.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<CallBehaviorAction> rawAccumulateAllValuesOfaction(final Object[] parameters) {
    Set<CallBehaviorAction> results = new HashSet<CallBehaviorAction>();
    rawAccumulateAllValues(POSITION_ACTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for action.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<CallBehaviorAction> getAllValuesOfaction() {
    return rawAccumulateAllValuesOfaction(emptyArray());
  }
  
  @Override
  protected GetMeteorologicalDataServicesMatch tupleToMatch(final Tuple t) {
    try {
    	return GetMeteorologicalDataServicesMatch.newMatch((CallBehaviorAction) t.get(POSITION_ACTION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GetMeteorologicalDataServicesMatch arrayToMatch(final Object[] match) {
    try {
    	return GetMeteorologicalDataServicesMatch.newMatch((CallBehaviorAction) match[POSITION_ACTION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GetMeteorologicalDataServicesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return GetMeteorologicalDataServicesMatch.newMutableMatch((CallBehaviorAction) match[POSITION_ACTION]);
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
  public static IQuerySpecification<GetMeteorologicalDataServicesMatcher> querySpecification() throws ViatraQueryException {
    return GetMeteorologicalDataServicesQuerySpecification.instance();
  }
}
