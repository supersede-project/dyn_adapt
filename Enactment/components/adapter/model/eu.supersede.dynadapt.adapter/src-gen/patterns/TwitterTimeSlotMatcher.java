/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import patterns.TwitterTimeSlotMatch;
import patterns.util.TwitterTimeSlotQuerySpecification;

/**
 * Generated pattern matcher API of the patterns.twitterTimeSlot pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TwitterTimeSlotMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern twitterTimeSlot(slot) {
 * 	Slot.definingFeature.name(slot, name);
 * 	Slot.owningInstance.classifier.name(slot, instanceName);
 * 	check(name.equals("timeSlot"));
 * 	check(instanceName.equals("SocialNetworks"));
 * }
 * </pre></code>
 * 
 * @see TwitterTimeSlotMatch
 * @see TwitterTimeSlotProcessor
 * @see TwitterTimeSlotQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TwitterTimeSlotMatcher extends BaseMatcher<TwitterTimeSlotMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TwitterTimeSlotMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    TwitterTimeSlotMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (TwitterTimeSlotMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static TwitterTimeSlotMatcher create() throws ViatraQueryException {
    return new TwitterTimeSlotMatcher();
  }
  
  private final static int POSITION_SLOT = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TwitterTimeSlotMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private TwitterTimeSlotMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return matches represented as a TwitterTimeSlotMatch object.
   * 
   */
  public Collection<TwitterTimeSlotMatch> getAllMatches(final Slot pSlot) {
    return rawGetAllMatches(new Object[]{pSlot});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return a match represented as a TwitterTimeSlotMatch object, or null if no match is found.
   * 
   */
  public TwitterTimeSlotMatch getOneArbitraryMatch(final Slot pSlot) {
    return rawGetOneArbitraryMatch(new Object[]{pSlot});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Slot pSlot) {
    return rawHasMatch(new Object[]{pSlot});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Slot pSlot) {
    return rawCountMatches(new Object[]{pSlot});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Slot pSlot, final IMatchProcessor<? super TwitterTimeSlotMatch> processor) {
    rawForEachMatch(new Object[]{pSlot}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Slot pSlot, final IMatchProcessor<? super TwitterTimeSlotMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSlot}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TwitterTimeSlotMatch newMatch(final Slot pSlot) {
    return TwitterTimeSlotMatch.newMatch(pSlot);
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Slot> rawAccumulateAllValuesOfslot(final Object[] parameters) {
    Set<Slot> results = new HashSet<Slot>();
    rawAccumulateAllValues(POSITION_SLOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot() {
    return rawAccumulateAllValuesOfslot(emptyArray());
  }
  
  @Override
  protected TwitterTimeSlotMatch tupleToMatch(final Tuple t) {
    try {
    	return TwitterTimeSlotMatch.newMatch((Slot) t.get(POSITION_SLOT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TwitterTimeSlotMatch arrayToMatch(final Object[] match) {
    try {
    	return TwitterTimeSlotMatch.newMatch((Slot) match[POSITION_SLOT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TwitterTimeSlotMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TwitterTimeSlotMatch.newMutableMatch((Slot) match[POSITION_SLOT]);
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
  public static IQuerySpecification<TwitterTimeSlotMatcher> querySpecification() throws ViatraQueryException {
    return TwitterTimeSlotQuerySpecification.instance();
  }
}
