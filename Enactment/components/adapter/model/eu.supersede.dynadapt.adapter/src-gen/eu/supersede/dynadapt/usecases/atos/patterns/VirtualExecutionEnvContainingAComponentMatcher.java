/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.VirtualExecutionEnvContainingAComponentMatch;
import eu.supersede.dynadapt.usecases.atos.patterns.util.VirtualExecutionEnvContainingAComponentQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.usecases.atos.patterns.VirtualExecutionEnvContainingAComponent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link VirtualExecutionEnvContainingAComponentMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern VirtualExecutionEnvContainingAComponent(execEnv : ExecutionEnvironment, instanceClassifier:Component){
 * 	ExecutionEnvironment.nestedClassifier (execEnv, classifier);
 * 	Artifact.manifestation (classifier, manifestation);
 * 	Manifestation.supplier (manifestation, instance);
 * 	InstanceSpecification.classifier (instance, instanceClassifier);
 * }
 * </pre></code>
 * 
 * @see VirtualExecutionEnvContainingAComponentMatch
 * @see VirtualExecutionEnvContainingAComponentProcessor
 * @see VirtualExecutionEnvContainingAComponentQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class VirtualExecutionEnvContainingAComponentMatcher extends BaseMatcher<VirtualExecutionEnvContainingAComponentMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static VirtualExecutionEnvContainingAComponentMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    VirtualExecutionEnvContainingAComponentMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (VirtualExecutionEnvContainingAComponentMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static VirtualExecutionEnvContainingAComponentMatcher create() throws ViatraQueryException {
    return new VirtualExecutionEnvContainingAComponentMatcher();
  }
  
  private final static int POSITION_EXECENV = 0;
  
  private final static int POSITION_INSTANCECLASSIFIER = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VirtualExecutionEnvContainingAComponentMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private VirtualExecutionEnvContainingAComponentMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return matches represented as a VirtualExecutionEnvContainingAComponentMatch object.
   * 
   */
  public Collection<VirtualExecutionEnvContainingAComponentMatch> getAllMatches(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return rawGetAllMatches(new Object[]{pExecEnv, pInstanceClassifier});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return a match represented as a VirtualExecutionEnvContainingAComponentMatch object, or null if no match is found.
   * 
   */
  public VirtualExecutionEnvContainingAComponentMatch getOneArbitraryMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return rawGetOneArbitraryMatch(new Object[]{pExecEnv, pInstanceClassifier});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return rawHasMatch(new Object[]{pExecEnv, pInstanceClassifier});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return rawCountMatches(new Object[]{pExecEnv, pInstanceClassifier});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier, final IMatchProcessor<? super VirtualExecutionEnvContainingAComponentMatch> processor) {
    rawForEachMatch(new Object[]{pExecEnv, pInstanceClassifier}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier, final IMatchProcessor<? super VirtualExecutionEnvContainingAComponentMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pExecEnv, pInstanceClassifier}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public VirtualExecutionEnvContainingAComponentMatch newMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return VirtualExecutionEnvContainingAComponentMatch.newMatch(pExecEnv, pInstanceClassifier);
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
  
  /**
   * Retrieve the set of values that occur in matches for execEnv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ExecutionEnvironment> getAllValuesOfexecEnv(final VirtualExecutionEnvContainingAComponentMatch partialMatch) {
    return rawAccumulateAllValuesOfexecEnv(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for execEnv.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ExecutionEnvironment> getAllValuesOfexecEnv(final Component pInstanceClassifier) {
    return rawAccumulateAllValuesOfexecEnv(new Object[]{
    null, 
    pInstanceClassifier
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for instanceClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Component> rawAccumulateAllValuesOfinstanceClassifier(final Object[] parameters) {
    Set<Component> results = new HashSet<Component>();
    rawAccumulateAllValues(POSITION_INSTANCECLASSIFIER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instanceClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfinstanceClassifier() {
    return rawAccumulateAllValuesOfinstanceClassifier(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instanceClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfinstanceClassifier(final VirtualExecutionEnvContainingAComponentMatch partialMatch) {
    return rawAccumulateAllValuesOfinstanceClassifier(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instanceClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfinstanceClassifier(final ExecutionEnvironment pExecEnv) {
    return rawAccumulateAllValuesOfinstanceClassifier(new Object[]{
    pExecEnv, 
    null
    });
  }
  
  @Override
  protected VirtualExecutionEnvContainingAComponentMatch tupleToMatch(final Tuple t) {
    try {
    	return VirtualExecutionEnvContainingAComponentMatch.newMatch((ExecutionEnvironment) t.get(POSITION_EXECENV), (Component) t.get(POSITION_INSTANCECLASSIFIER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected VirtualExecutionEnvContainingAComponentMatch arrayToMatch(final Object[] match) {
    try {
    	return VirtualExecutionEnvContainingAComponentMatch.newMatch((ExecutionEnvironment) match[POSITION_EXECENV], (Component) match[POSITION_INSTANCECLASSIFIER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected VirtualExecutionEnvContainingAComponentMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return VirtualExecutionEnvContainingAComponentMatch.newMutableMatch((ExecutionEnvironment) match[POSITION_EXECENV], (Component) match[POSITION_INSTANCECLASSIFIER]);
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
  public static IQuerySpecification<VirtualExecutionEnvContainingAComponentMatcher> querySpecification() throws ViatraQueryException {
    return VirtualExecutionEnvContainingAComponentQuerySpecification.instance();
  }
}
