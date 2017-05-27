/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationLinkMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.util.InstanceSpecificationLinkQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationLink pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InstanceSpecificationLinkMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern InstanceSpecificationLink (link) {
 * 	InstanceSpecification.classifier (link, classifier);
 * 	Association (classifier);
 * }
 * </pre></code>
 * 
 * @see InstanceSpecificationLinkMatch
 * @see InstanceSpecificationLinkProcessor
 * @see InstanceSpecificationLinkQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InstanceSpecificationLinkMatcher extends BaseMatcher<InstanceSpecificationLinkMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InstanceSpecificationLinkMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    InstanceSpecificationLinkMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (InstanceSpecificationLinkMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static InstanceSpecificationLinkMatcher create() throws ViatraQueryException {
    return new InstanceSpecificationLinkMatcher();
  }
  
  private final static int POSITION_LINK = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(InstanceSpecificationLinkMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private InstanceSpecificationLinkMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return matches represented as a InstanceSpecificationLinkMatch object.
   * 
   */
  public Collection<InstanceSpecificationLinkMatch> getAllMatches(final InstanceSpecification pLink) {
    return rawGetAllMatches(new Object[]{pLink});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return a match represented as a InstanceSpecificationLinkMatch object, or null if no match is found.
   * 
   */
  public InstanceSpecificationLinkMatch getOneArbitraryMatch(final InstanceSpecification pLink) {
    return rawGetOneArbitraryMatch(new Object[]{pLink});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pLink) {
    return rawHasMatch(new Object[]{pLink});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pLink) {
    return rawCountMatches(new Object[]{pLink});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pLink, final IMatchProcessor<? super InstanceSpecificationLinkMatch> processor) {
    rawForEachMatch(new Object[]{pLink}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pLink, final IMatchProcessor<? super InstanceSpecificationLinkMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLink}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InstanceSpecificationLinkMatch newMatch(final InstanceSpecification pLink) {
    return InstanceSpecificationLinkMatch.newMatch(pLink);
  }
  
  /**
   * Retrieve the set of values that occur in matches for link.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOflink(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_LINK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for link.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOflink() {
    return rawAccumulateAllValuesOflink(emptyArray());
  }
  
  @Override
  protected InstanceSpecificationLinkMatch tupleToMatch(final Tuple t) {
    try {
    	return InstanceSpecificationLinkMatch.newMatch((InstanceSpecification) t.get(POSITION_LINK));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InstanceSpecificationLinkMatch arrayToMatch(final Object[] match) {
    try {
    	return InstanceSpecificationLinkMatch.newMatch((InstanceSpecification) match[POSITION_LINK]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InstanceSpecificationLinkMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return InstanceSpecificationLinkMatch.newMutableMatch((InstanceSpecification) match[POSITION_LINK]);
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
  public static IQuerySpecification<InstanceSpecificationLinkMatcher> querySpecification() throws ViatraQueryException {
    return InstanceSpecificationLinkQuerySpecification.instance();
  }
}
