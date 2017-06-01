/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironmentsMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.util.HSKVirtualExecutionEnvironmentsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironments pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link HSKVirtualExecutionEnvironmentsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern HSKVirtualExecutionEnvironments (execEnv : ExecutionEnvironment){
 * 	find VirtualExecutionEnvContainingAComponent(execEnv, component);
 * 	Component.name (component, name);
 * 	
 * 	check (
 * 		name.equalsIgnoreCase("HSK")
 * 	);
 * }
 * </pre></code>
 * 
 * @see HSKVirtualExecutionEnvironmentsMatch
 * @see HSKVirtualExecutionEnvironmentsProcessor
 * @see HSKVirtualExecutionEnvironmentsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class HSKVirtualExecutionEnvironmentsMatcher extends BaseMatcher<HSKVirtualExecutionEnvironmentsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static HSKVirtualExecutionEnvironmentsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    HSKVirtualExecutionEnvironmentsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (HSKVirtualExecutionEnvironmentsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static HSKVirtualExecutionEnvironmentsMatcher create() throws ViatraQueryException {
    return new HSKVirtualExecutionEnvironmentsMatcher();
  }
  
  private final static int POSITION_EXECENV = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HSKVirtualExecutionEnvironmentsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private HSKVirtualExecutionEnvironmentsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return matches represented as a HSKVirtualExecutionEnvironmentsMatch object.
   * 
   */
  public Collection<HSKVirtualExecutionEnvironmentsMatch> getAllMatches(final ExecutionEnvironment pExecEnv) {
    return rawGetAllMatches(new Object[]{pExecEnv});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return a match represented as a HSKVirtualExecutionEnvironmentsMatch object, or null if no match is found.
   * 
   */
  public HSKVirtualExecutionEnvironmentsMatch getOneArbitraryMatch(final ExecutionEnvironment pExecEnv) {
    return rawGetOneArbitraryMatch(new Object[]{pExecEnv});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ExecutionEnvironment pExecEnv) {
    return rawHasMatch(new Object[]{pExecEnv});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ExecutionEnvironment pExecEnv) {
    return rawCountMatches(new Object[]{pExecEnv});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ExecutionEnvironment pExecEnv, final IMatchProcessor<? super HSKVirtualExecutionEnvironmentsMatch> processor) {
    rawForEachMatch(new Object[]{pExecEnv}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ExecutionEnvironment pExecEnv, final IMatchProcessor<? super HSKVirtualExecutionEnvironmentsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pExecEnv}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public HSKVirtualExecutionEnvironmentsMatch newMatch(final ExecutionEnvironment pExecEnv) {
    return HSKVirtualExecutionEnvironmentsMatch.newMatch(pExecEnv);
  }
  
  /**
   * Retrieve the set of values that occur in matches for execEnv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ExecutionEnvironment> rawAccumulateAllValuesOfexecEnv(final Object[] parameters) {
    Set<ExecutionEnvironment> results = new HashSet<ExecutionEnvironment>();
    rawAccumulateAllValues(POSITION_EXECENV, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for execEnv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ExecutionEnvironment> getAllValuesOfexecEnv() {
    return rawAccumulateAllValuesOfexecEnv(emptyArray());
  }
  
  @Override
  protected HSKVirtualExecutionEnvironmentsMatch tupleToMatch(final Tuple t) {
    try {
    	return HSKVirtualExecutionEnvironmentsMatch.newMatch((ExecutionEnvironment) t.get(POSITION_EXECENV));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected HSKVirtualExecutionEnvironmentsMatch arrayToMatch(final Object[] match) {
    try {
    	return HSKVirtualExecutionEnvironmentsMatch.newMatch((ExecutionEnvironment) match[POSITION_EXECENV]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected HSKVirtualExecutionEnvironmentsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return HSKVirtualExecutionEnvironmentsMatch.newMutableMatch((ExecutionEnvironment) match[POSITION_EXECENV]);
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
  public static IQuerySpecification<HSKVirtualExecutionEnvironmentsMatcher> querySpecification() throws ViatraQueryException {
    return HSKVirtualExecutionEnvironmentsQuerySpecification.instance();
  }
}
