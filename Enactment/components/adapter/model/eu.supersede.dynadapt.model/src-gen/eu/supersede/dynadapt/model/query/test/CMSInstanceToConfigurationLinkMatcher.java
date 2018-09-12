/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.CMSInstanceToConfigurationLinkMatch;
import eu.supersede.dynadapt.model.query.test.util.CMSInstanceToConfigurationLinkQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.model.query.test.CMSInstanceToConfigurationLink pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link CMSInstanceToConfigurationLinkMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern CMSInstanceToConfigurationLink (link, instance){
 * 	find InstanceSpecificationLink(link);
 * 	InstanceSpecification.slot (link, slot);
 * 	Slot.value (slot,value);
 * 	InstanceValue.instance (value, instance);
 * 	InstanceSpecification.name (instance, name);
 * 	check (
 * 		name.equals("CMS  Instance")
 * 	);
 * }
 * </pre></code>
 * 
 * @see CMSInstanceToConfigurationLinkMatch
 * @see CMSInstanceToConfigurationLinkProcessor
 * @see CMSInstanceToConfigurationLinkQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class CMSInstanceToConfigurationLinkMatcher extends BaseMatcher<CMSInstanceToConfigurationLinkMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static CMSInstanceToConfigurationLinkMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    CMSInstanceToConfigurationLinkMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (CMSInstanceToConfigurationLinkMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static CMSInstanceToConfigurationLinkMatcher create() throws ViatraQueryException {
    return new CMSInstanceToConfigurationLinkMatcher();
  }
  
  private final static int POSITION_LINK = 0;
  
  private final static int POSITION_INSTANCE = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CMSInstanceToConfigurationLinkMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private CMSInstanceToConfigurationLinkMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return matches represented as a CMSInstanceToConfigurationLinkMatch object.
   * 
   */
  public Collection<CMSInstanceToConfigurationLinkMatch> getAllMatches(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return rawGetAllMatches(new Object[]{pLink, pInstance});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return a match represented as a CMSInstanceToConfigurationLinkMatch object, or null if no match is found.
   * 
   */
  public CMSInstanceToConfigurationLinkMatch getOneArbitraryMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return rawGetOneArbitraryMatch(new Object[]{pLink, pInstance});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return rawHasMatch(new Object[]{pLink, pInstance});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return rawCountMatches(new Object[]{pLink, pInstance});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance, final IMatchProcessor<? super CMSInstanceToConfigurationLinkMatch> processor) {
    rawForEachMatch(new Object[]{pLink, pInstance}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance, final IMatchProcessor<? super CMSInstanceToConfigurationLinkMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pLink, pInstance}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public CMSInstanceToConfigurationLinkMatch newMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return CMSInstanceToConfigurationLinkMatch.newMatch(pLink, pInstance);
  }
  
  /**
   * Retrieve the set of values that occur in matches for link.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOflink(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_LINK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for link.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOflink() {
    return rawAccumulateAllValuesOflink(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for link.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOflink(final CMSInstanceToConfigurationLinkMatch partialMatch) {
    return rawAccumulateAllValuesOflink(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for link.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOflink(final InstanceSpecification pInstance) {
    return rawAccumulateAllValuesOflink(new Object[]{
    null, 
    pInstance
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfinstance(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_INSTANCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance() {
    return rawAccumulateAllValuesOfinstance(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance(final CMSInstanceToConfigurationLinkMatch partialMatch) {
    return rawAccumulateAllValuesOfinstance(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance(final InstanceSpecification pLink) {
    return rawAccumulateAllValuesOfinstance(new Object[]{
    pLink, 
    null
    });
  }
  
  @Override
  protected CMSInstanceToConfigurationLinkMatch tupleToMatch(final Tuple t) {
    try {
        return CMSInstanceToConfigurationLinkMatch.newMatch((InstanceSpecification) t.get(POSITION_LINK), (InstanceSpecification) t.get(POSITION_INSTANCE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected CMSInstanceToConfigurationLinkMatch arrayToMatch(final Object[] match) {
    try {
        return CMSInstanceToConfigurationLinkMatch.newMatch((InstanceSpecification) match[POSITION_LINK], (InstanceSpecification) match[POSITION_INSTANCE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected CMSInstanceToConfigurationLinkMatch arrayToMatchMutable(final Object[] match) {
    try {
        return CMSInstanceToConfigurationLinkMatch.newMutableMatch((InstanceSpecification) match[POSITION_LINK], (InstanceSpecification) match[POSITION_INSTANCE]);
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
  public static IQuerySpecification<CMSInstanceToConfigurationLinkMatcher> querySpecification() throws ViatraQueryException {
    return CMSInstanceToConfigurationLinkQuerySpecification.instance();
  }
}
