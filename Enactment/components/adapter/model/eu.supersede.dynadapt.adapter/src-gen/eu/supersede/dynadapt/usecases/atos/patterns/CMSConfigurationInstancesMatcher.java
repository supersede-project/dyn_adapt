/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.CMSConfigurationInstancesMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.util.CMSConfigurationInstancesQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.atos.patterns.CMSConfigurationInstances pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link CMSConfigurationInstancesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern CMSConfigurationInstances (configuration){
 * 	find instanceSpecificationsAsManifestationsOfNodeArtifacts(_, service);
 * 	InstanceSpecification.slot (service, slot);
 * 	Slot.value (slot, instance);
 * 	InstanceValue.type (instance, type);
 * 	InstanceValue.instance (instance, configuration);
 * 	Class (type);
 * 	Class.name (type, name);
 * 	check (
 * 		name.equals("CMS_Configuration")
 * 	);
 * }
 * </pre></code>
 * 
 * @see CMSConfigurationInstancesMatch
 * @see CMSConfigurationInstancesProcessor
 * @see CMSConfigurationInstancesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class CMSConfigurationInstancesMatcher extends BaseMatcher<CMSConfigurationInstancesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static CMSConfigurationInstancesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    CMSConfigurationInstancesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (CMSConfigurationInstancesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static CMSConfigurationInstancesMatcher create() throws ViatraQueryException {
    return new CMSConfigurationInstancesMatcher();
  }
  
  private final static int POSITION_CONFIGURATION = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CMSConfigurationInstancesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private CMSConfigurationInstancesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return matches represented as a CMSConfigurationInstancesMatch object.
   * 
   */
  public Collection<CMSConfigurationInstancesMatch> getAllMatches(final InstanceSpecification pConfiguration) {
    return rawGetAllMatches(new Object[]{pConfiguration});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return a match represented as a CMSConfigurationInstancesMatch object, or null if no match is found.
   * 
   */
  public CMSConfigurationInstancesMatch getOneArbitraryMatch(final InstanceSpecification pConfiguration) {
    return rawGetOneArbitraryMatch(new Object[]{pConfiguration});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pConfiguration) {
    return rawHasMatch(new Object[]{pConfiguration});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pConfiguration) {
    return rawCountMatches(new Object[]{pConfiguration});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pConfiguration, final IMatchProcessor<? super CMSConfigurationInstancesMatch> processor) {
    rawForEachMatch(new Object[]{pConfiguration}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pConfiguration, final IMatchProcessor<? super CMSConfigurationInstancesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pConfiguration}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public CMSConfigurationInstancesMatch newMatch(final InstanceSpecification pConfiguration) {
    return CMSConfigurationInstancesMatch.newMatch(pConfiguration);
  }
  
  /**
   * Retrieve the set of values that occur in matches for configuration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfconfiguration(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_CONFIGURATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for configuration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfconfiguration() {
    return rawAccumulateAllValuesOfconfiguration(emptyArray());
  }
  
  @Override
  protected CMSConfigurationInstancesMatch tupleToMatch(final Tuple t) {
    try {
    	return CMSConfigurationInstancesMatch.newMatch((InstanceSpecification) t.get(POSITION_CONFIGURATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CMSConfigurationInstancesMatch arrayToMatch(final Object[] match) {
    try {
    	return CMSConfigurationInstancesMatch.newMatch((InstanceSpecification) match[POSITION_CONFIGURATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CMSConfigurationInstancesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return CMSConfigurationInstancesMatch.newMutableMatch((InstanceSpecification) match[POSITION_CONFIGURATION]);
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
  public static IQuerySpecification<CMSConfigurationInstancesMatcher> querySpecification() throws ViatraQueryException {
    return CMSConfigurationInstancesQuerySpecification.instance();
  }
}
