/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/health/health.vql
 */
package eu.supersede.dynadapt.usecases.health;

import eu.supersede.dynadapt.usecases.health.Authenticated_userMatch;
import eu.supersede.dynadapt.usecases.health.util.Authenticated_userQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.health.authenticated_user pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link Authenticated_userMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern authenticated_user(user) {
 * 	Class.name (user, name);
 * 	check (
 * 		name.equals("Employee")
 * 	);
 * }
 * </pre></code>
 * 
 * @see Authenticated_userMatch
 * @see Authenticated_userProcessor
 * @see Authenticated_userQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class Authenticated_userMatcher extends BaseMatcher<Authenticated_userMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static Authenticated_userMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    Authenticated_userMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (Authenticated_userMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static Authenticated_userMatcher create() throws ViatraQueryException {
    return new Authenticated_userMatcher();
  }
  
  private final static int POSITION_USER = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Authenticated_userMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private Authenticated_userMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return matches represented as a Authenticated_userMatch object.
   * 
   */
  public Collection<Authenticated_userMatch> getAllMatches(final org.eclipse.uml2.uml.Class pUser) {
    return rawGetAllMatches(new Object[]{pUser});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return a match represented as a Authenticated_userMatch object, or null if no match is found.
   * 
   */
  public Authenticated_userMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUser) {
    return rawGetOneArbitraryMatch(new Object[]{pUser});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pUser) {
    return rawHasMatch(new Object[]{pUser});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pUser) {
    return rawCountMatches(new Object[]{pUser});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pUser, final IMatchProcessor<? super Authenticated_userMatch> processor) {
    rawForEachMatch(new Object[]{pUser}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUser, final IMatchProcessor<? super Authenticated_userMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pUser}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public Authenticated_userMatch newMatch(final org.eclipse.uml2.uml.Class pUser) {
    return Authenticated_userMatch.newMatch(pUser);
  }
  
  /**
   * Retrieve the set of values that occur in matches for user.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfuser(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_USER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for user.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfuser() {
    return rawAccumulateAllValuesOfuser(emptyArray());
  }
  
  @Override
  protected Authenticated_userMatch tupleToMatch(final Tuple t) {
    try {
    	return Authenticated_userMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_USER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected Authenticated_userMatch arrayToMatch(final Object[] match) {
    try {
    	return Authenticated_userMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_USER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected Authenticated_userMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return Authenticated_userMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_USER]);
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
  public static IQuerySpecification<Authenticated_userMatcher> querySpecification() throws ViatraQueryException {
    return Authenticated_userQuerySpecification.instance();
  }
}
