/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServicesMatch;
import eu.supersede.dynadapt.usecases.patterns.util.VMInstancesContainingHSKServicesQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServices pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link VMInstancesContainingHSKServicesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern VMInstancesContainingHSKServices (instance : InstanceSpecification){
 * 	find HSKExecutionEnvironments(execEnv);
 * 	Manifestation.client (manifestation, execEnv);
 * 	Manifestation.supplier (manifestation, instance);
 * }
 * </pre></code>
 * 
 * @see VMInstancesContainingHSKServicesMatch
 * @see VMInstancesContainingHSKServicesProcessor
 * @see VMInstancesContainingHSKServicesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class VMInstancesContainingHSKServicesMatcher extends BaseMatcher<VMInstancesContainingHSKServicesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static VMInstancesContainingHSKServicesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    VMInstancesContainingHSKServicesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (VMInstancesContainingHSKServicesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static VMInstancesContainingHSKServicesMatcher create() throws ViatraQueryException {
    return new VMInstancesContainingHSKServicesMatcher();
  }
  
  private final static int POSITION_INSTANCE = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VMInstancesContainingHSKServicesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private VMInstancesContainingHSKServicesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return matches represented as a VMInstancesContainingHSKServicesMatch object.
   * 
   */
  public Collection<VMInstancesContainingHSKServicesMatch> getAllMatches(final InstanceSpecification pInstance) {
    return rawGetAllMatches(new Object[]{pInstance});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return a match represented as a VMInstancesContainingHSKServicesMatch object, or null if no match is found.
   * 
   */
  public VMInstancesContainingHSKServicesMatch getOneArbitraryMatch(final InstanceSpecification pInstance) {
    return rawGetOneArbitraryMatch(new Object[]{pInstance});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pInstance) {
    return rawHasMatch(new Object[]{pInstance});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pInstance) {
    return rawCountMatches(new Object[]{pInstance});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pInstance, final IMatchProcessor<? super VMInstancesContainingHSKServicesMatch> processor) {
    rawForEachMatch(new Object[]{pInstance}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pInstance, final IMatchProcessor<? super VMInstancesContainingHSKServicesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pInstance}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public VMInstancesContainingHSKServicesMatch newMatch(final InstanceSpecification pInstance) {
    return VMInstancesContainingHSKServicesMatch.newMatch(pInstance);
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
  
  @Override
  protected VMInstancesContainingHSKServicesMatch tupleToMatch(final Tuple t) {
    try {
    	return VMInstancesContainingHSKServicesMatch.newMatch((InstanceSpecification) t.get(POSITION_INSTANCE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected VMInstancesContainingHSKServicesMatch arrayToMatch(final Object[] match) {
    try {
    	return VMInstancesContainingHSKServicesMatch.newMatch((InstanceSpecification) match[POSITION_INSTANCE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected VMInstancesContainingHSKServicesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return VMInstancesContainingHSKServicesMatch.newMutableMatch((InstanceSpecification) match[POSITION_INSTANCE]);
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
  public static IQuerySpecification<VMInstancesContainingHSKServicesMatcher> querySpecification() throws ViatraQueryException {
    return VMInstancesContainingHSKServicesQuerySpecification.instance();
  }
}
