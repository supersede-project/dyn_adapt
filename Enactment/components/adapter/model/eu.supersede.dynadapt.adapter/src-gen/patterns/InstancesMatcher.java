/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

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
import patterns.InstancesMatch;
import patterns.util.InstancesQuerySpecification;

/**
 * Generated pattern matcher API of the patterns.instances pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InstancesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern instances(instance : InstanceSpecification, name) {
 * 	InstanceSpecification.name(instance, name);
 * }
 * </pre></code>
 * 
 * @see InstancesMatch
 * @see InstancesProcessor
 * @see InstancesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InstancesMatcher extends BaseMatcher<InstancesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InstancesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    InstancesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (InstancesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static InstancesMatcher create() throws ViatraQueryException {
    return new InstancesMatcher();
  }
  
  private final static int POSITION_INSTANCE = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(InstancesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private InstancesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a InstancesMatch object.
   * 
   */
  public Collection<InstancesMatch> getAllMatches(final InstanceSpecification pInstance, final String pName) {
    return rawGetAllMatches(new Object[]{pInstance, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a InstancesMatch object, or null if no match is found.
   * 
   */
  public InstancesMatch getOneArbitraryMatch(final InstanceSpecification pInstance, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pInstance, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pInstance, final String pName) {
    return rawHasMatch(new Object[]{pInstance, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pInstance, final String pName) {
    return rawCountMatches(new Object[]{pInstance, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pInstance, final String pName, final IMatchProcessor<? super InstancesMatch> processor) {
    rawForEachMatch(new Object[]{pInstance, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pInstance, final String pName, final IMatchProcessor<? super InstancesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pInstance, pName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InstancesMatch newMatch(final InstanceSpecification pInstance, final String pName) {
    return InstancesMatch.newMatch(pInstance, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfinstance(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_INSTANCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance() {
    return rawAccumulateAllValuesOfinstance(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance(final InstancesMatch partialMatch) {
    return rawAccumulateAllValuesOfinstance(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance(final String pName) {
    return rawAccumulateAllValuesOfinstance(new Object[]{
    null, 
    pName
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
  public Set<String> getAllValuesOfname(final InstancesMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pInstance) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pInstance, 
    null
    });
  }
  
  @Override
  protected InstancesMatch tupleToMatch(final Tuple t) {
    try {
    	return InstancesMatch.newMatch((InstanceSpecification) t.get(POSITION_INSTANCE), (String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InstancesMatch arrayToMatch(final Object[] match) {
    try {
    	return InstancesMatch.newMatch((InstanceSpecification) match[POSITION_INSTANCE], (String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InstancesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return InstancesMatch.newMutableMatch((InstanceSpecification) match[POSITION_INSTANCE], (String) match[POSITION_NAME]);
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
  public static IQuerySpecification<InstancesMatcher> querySpecification() throws ViatraQueryException {
    return InstancesQuerySpecification.instance();
  }
}
