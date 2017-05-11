/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.MaxThreadValuesInCMSConfigurationsMatch;
import eu.supersede.dynadapt.model.query.test.util.MaxThreadValuesInCMSConfigurationsQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.model.query.test.maxThreadValuesInCMSConfigurations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MaxThreadValuesInCMSConfigurationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern maxThreadValuesInCMSConfigurations (configuration, name, value){
 * 	find CMSConfigurationInstances(configuration);
 * 	InstanceSpecification.slot (configuration, slot);
 * 	Slot.definingFeature (slot, feature);
 * 	Property.name (feature, name);
 * 	Slot.value (slot, integer);
 * 	LiteralInteger.value (integer, value);
 * 	check (
 * 		name.equals("max_threads")
 * 	);
 * }
 * </pre></code>
 * 
 * @see MaxThreadValuesInCMSConfigurationsMatch
 * @see MaxThreadValuesInCMSConfigurationsProcessor
 * @see MaxThreadValuesInCMSConfigurationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MaxThreadValuesInCMSConfigurationsMatcher extends BaseMatcher<MaxThreadValuesInCMSConfigurationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MaxThreadValuesInCMSConfigurationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MaxThreadValuesInCMSConfigurationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (MaxThreadValuesInCMSConfigurationsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static MaxThreadValuesInCMSConfigurationsMatcher create() throws ViatraQueryException {
    return new MaxThreadValuesInCMSConfigurationsMatcher();
  }
  
  private final static int POSITION_CONFIGURATION = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static int POSITION_VALUE = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MaxThreadValuesInCMSConfigurationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MaxThreadValuesInCMSConfigurationsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return matches represented as a MaxThreadValuesInCMSConfigurationsMatch object.
   * 
   */
  public Collection<MaxThreadValuesInCMSConfigurationsMatch> getAllMatches(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return rawGetAllMatches(new Object[]{pConfiguration, pName, pValue});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return a match represented as a MaxThreadValuesInCMSConfigurationsMatch object, or null if no match is found.
   * 
   */
  public MaxThreadValuesInCMSConfigurationsMatch getOneArbitraryMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return rawGetOneArbitraryMatch(new Object[]{pConfiguration, pName, pValue});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return rawHasMatch(new Object[]{pConfiguration, pName, pValue});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return rawCountMatches(new Object[]{pConfiguration, pName, pValue});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue, final IMatchProcessor<? super MaxThreadValuesInCMSConfigurationsMatch> processor) {
    rawForEachMatch(new Object[]{pConfiguration, pName, pValue}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue, final IMatchProcessor<? super MaxThreadValuesInCMSConfigurationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pConfiguration, pName, pValue}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MaxThreadValuesInCMSConfigurationsMatch newMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return MaxThreadValuesInCMSConfigurationsMatch.newMatch(pConfiguration, pName, pValue);
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
  public Set<InstanceSpecification> getAllValuesOfconfiguration(final MaxThreadValuesInCMSConfigurationsMatch partialMatch) {
    return rawAccumulateAllValuesOfconfiguration(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for configuration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfconfiguration(final String pName, final Integer pValue) {
    return rawAccumulateAllValuesOfconfiguration(new Object[]{
    null, 
    pName, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final MaxThreadValuesInCMSConfigurationsMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pConfiguration, final Integer pValue) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pConfiguration, 
    null, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfvalue(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_VALUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue() {
    return rawAccumulateAllValuesOfvalue(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue(final MaxThreadValuesInCMSConfigurationsMatch partialMatch) {
    return rawAccumulateAllValuesOfvalue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue(final InstanceSpecification pConfiguration, final String pName) {
    return rawAccumulateAllValuesOfvalue(new Object[]{
    pConfiguration, 
    pName, 
    null
    });
  }
  
  @Override
  protected MaxThreadValuesInCMSConfigurationsMatch tupleToMatch(final Tuple t) {
    try {
    	return MaxThreadValuesInCMSConfigurationsMatch.newMatch((InstanceSpecification) t.get(POSITION_CONFIGURATION), (String) t.get(POSITION_NAME), (Integer) t.get(POSITION_VALUE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MaxThreadValuesInCMSConfigurationsMatch arrayToMatch(final Object[] match) {
    try {
    	return MaxThreadValuesInCMSConfigurationsMatch.newMatch((InstanceSpecification) match[POSITION_CONFIGURATION], (String) match[POSITION_NAME], (Integer) match[POSITION_VALUE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MaxThreadValuesInCMSConfigurationsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MaxThreadValuesInCMSConfigurationsMatch.newMutableMatch((InstanceSpecification) match[POSITION_CONFIGURATION], (String) match[POSITION_NAME], (Integer) match[POSITION_VALUE]);
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
  public static IQuerySpecification<MaxThreadValuesInCMSConfigurationsMatcher> querySpecification() throws ViatraQueryException {
    return MaxThreadValuesInCMSConfigurationsQuerySpecification.instance();
  }
}
