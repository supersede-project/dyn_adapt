/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.ServiceConfigurationsMatch;
import eu.supersede.dynadapt.model.query.test.util.ServiceConfigurationsQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.model.query.test.serviceConfigurations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ServiceConfigurationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern serviceConfigurations (service, configuration){
 * 	find instanceSpecificationsAsManifestationsOfNodeArtifacts(_, service);
 * 	InstanceSpecification.slot (service, slot);
 * 	Slot.value (slot, instance);
 * 	Slot.definingFeature (slot, feature);
 * 	Property.name (feature, featureName);
 * 	InstanceValue.instance (instance, configuration);
 * 	check (
 * 		featureName == "conf"
 * 	);
 * }
 * </pre></code>
 * 
 * @see ServiceConfigurationsMatch
 * @see ServiceConfigurationsProcessor
 * @see ServiceConfigurationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ServiceConfigurationsMatcher extends BaseMatcher<ServiceConfigurationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ServiceConfigurationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ServiceConfigurationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (ServiceConfigurationsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ServiceConfigurationsMatcher create() throws ViatraQueryException {
    return new ServiceConfigurationsMatcher();
  }
  
  private final static int POSITION_SERVICE = 0;
  
  private final static int POSITION_CONFIGURATION = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ServiceConfigurationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ServiceConfigurationsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return matches represented as a ServiceConfigurationsMatch object.
   * 
   */
  public Collection<ServiceConfigurationsMatch> getAllMatches(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return rawGetAllMatches(new Object[]{pService, pConfiguration});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return a match represented as a ServiceConfigurationsMatch object, or null if no match is found.
   * 
   */
  public ServiceConfigurationsMatch getOneArbitraryMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return rawGetOneArbitraryMatch(new Object[]{pService, pConfiguration});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return rawHasMatch(new Object[]{pService, pConfiguration});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return rawCountMatches(new Object[]{pService, pConfiguration});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration, final IMatchProcessor<? super ServiceConfigurationsMatch> processor) {
    rawForEachMatch(new Object[]{pService, pConfiguration}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration, final IMatchProcessor<? super ServiceConfigurationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pService, pConfiguration}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ServiceConfigurationsMatch newMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return ServiceConfigurationsMatch.newMatch(pService, pConfiguration);
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfservice(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_SERVICE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfservice() {
    return rawAccumulateAllValuesOfservice(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfservice(final ServiceConfigurationsMatch partialMatch) {
    return rawAccumulateAllValuesOfservice(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfservice(final InstanceSpecification pConfiguration) {
    return rawAccumulateAllValuesOfservice(new Object[]{
    null, 
    pConfiguration
    });
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
  
  /**
   * Retrieve the set of values that occur in matches for configuration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfconfiguration(final ServiceConfigurationsMatch partialMatch) {
    return rawAccumulateAllValuesOfconfiguration(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for configuration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfconfiguration(final InstanceSpecification pService) {
    return rawAccumulateAllValuesOfconfiguration(new Object[]{
    pService, 
    null
    });
  }
  
  @Override
  protected ServiceConfigurationsMatch tupleToMatch(final Tuple t) {
    try {
    	return ServiceConfigurationsMatch.newMatch((InstanceSpecification) t.get(POSITION_SERVICE), (InstanceSpecification) t.get(POSITION_CONFIGURATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ServiceConfigurationsMatch arrayToMatch(final Object[] match) {
    try {
    	return ServiceConfigurationsMatch.newMatch((InstanceSpecification) match[POSITION_SERVICE], (InstanceSpecification) match[POSITION_CONFIGURATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ServiceConfigurationsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ServiceConfigurationsMatch.newMutableMatch((InstanceSpecification) match[POSITION_SERVICE], (InstanceSpecification) match[POSITION_CONFIGURATION]);
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
  public static IQuerySpecification<ServiceConfigurationsMatcher> querySpecification() throws ViatraQueryException {
    return ServiceConfigurationsQuerySpecification.instance();
  }
}
