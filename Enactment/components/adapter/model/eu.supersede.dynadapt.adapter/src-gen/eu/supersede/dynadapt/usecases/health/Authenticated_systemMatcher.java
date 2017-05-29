/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/health/health.vql
 */
package eu.supersede.dynadapt.usecases.health;

import eu.supersede.dynadapt.usecases.health.Authenticated_systemMatch;
import eu.supersede.dynadapt.usecases.health.util.Authenticated_systemQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.health.authenticated_system pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link Authenticated_systemMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern authenticated_system(class) {
 * 	Class.name (class, name);
 * 	check (
 * 		name.equals("HealthWatcher")
 * 	);
 * }
 * </pre></code>
 * 
 * @see Authenticated_systemMatch
 * @see Authenticated_systemProcessor
 * @see Authenticated_systemQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class Authenticated_systemMatcher extends BaseMatcher<Authenticated_systemMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static Authenticated_systemMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    Authenticated_systemMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (Authenticated_systemMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static Authenticated_systemMatcher create() throws ViatraQueryException {
    return new Authenticated_systemMatcher();
  }
  
  private final static int POSITION_CLASS = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Authenticated_systemMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private Authenticated_systemMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return matches represented as a Authenticated_systemMatch object.
   * 
   */
  public Collection<Authenticated_systemMatch> getAllMatches(final org.eclipse.uml2.uml.Class pClass) {
    return rawGetAllMatches(new Object[]{pClass});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return a match represented as a Authenticated_systemMatch object, or null if no match is found.
   * 
   */
  public Authenticated_systemMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pClass) {
    return rawGetOneArbitraryMatch(new Object[]{pClass});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pClass) {
    return rawHasMatch(new Object[]{pClass});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pClass) {
    return rawCountMatches(new Object[]{pClass});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pClass, final IMatchProcessor<? super Authenticated_systemMatch> processor) {
    rawForEachMatch(new Object[]{pClass}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pClass, final IMatchProcessor<? super Authenticated_systemMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pClass}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public Authenticated_systemMatch newMatch(final org.eclipse.uml2.uml.Class pClass) {
    return Authenticated_systemMatch.newMatch(pClass);
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfclass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfclass() {
    return rawAccumulateAllValuesOfclass(emptyArray());
  }
  
  @Override
  protected Authenticated_systemMatch tupleToMatch(final Tuple t) {
    try {
    	return Authenticated_systemMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLASS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected Authenticated_systemMatch arrayToMatch(final Object[] match) {
    try {
    	return Authenticated_systemMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLASS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected Authenticated_systemMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return Authenticated_systemMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLASS]);
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
  public static IQuerySpecification<Authenticated_systemMatcher> querySpecification() throws ViatraQueryException {
    return Authenticated_systemQuerySpecification.instance();
  }
}
