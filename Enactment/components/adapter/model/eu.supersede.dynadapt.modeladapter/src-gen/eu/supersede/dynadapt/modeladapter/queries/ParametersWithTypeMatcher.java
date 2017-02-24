/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.ParametersWithTypeMatch;
import eu.supersede.dynadapt.modeladapter.queries.util.ParametersWithTypeQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.modeladapter.queries.parametersWithType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ParametersWithTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern parametersWithType (parameter : Parameter, type: Type){
 * 	Parameter.type (parameter, type);
 * 	
 * //	Type.name (type, name);
 * //	check (
 * //		name.equals("UserToAuthenticate")
 * //	);
 * }
 * </pre></code>
 * 
 * @see ParametersWithTypeMatch
 * @see ParametersWithTypeProcessor
 * @see ParametersWithTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ParametersWithTypeMatcher extends BaseMatcher<ParametersWithTypeMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ParametersWithTypeMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ParametersWithTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (ParametersWithTypeMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ParametersWithTypeMatcher create() throws ViatraQueryException {
    return new ParametersWithTypeMatcher();
  }
  
  private final static int POSITION_PARAMETER = 0;
  
  private final static int POSITION_TYPE = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ParametersWithTypeMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ParametersWithTypeMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a ParametersWithTypeMatch object.
   * 
   */
  public Collection<ParametersWithTypeMatch> getAllMatches(final Parameter pParameter, final Type pType) {
    return rawGetAllMatches(new Object[]{pParameter, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a ParametersWithTypeMatch object, or null if no match is found.
   * 
   */
  public ParametersWithTypeMatch getOneArbitraryMatch(final Parameter pParameter, final Type pType) {
    return rawGetOneArbitraryMatch(new Object[]{pParameter, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Parameter pParameter, final Type pType) {
    return rawHasMatch(new Object[]{pParameter, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Parameter pParameter, final Type pType) {
    return rawCountMatches(new Object[]{pParameter, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Parameter pParameter, final Type pType, final IMatchProcessor<? super ParametersWithTypeMatch> processor) {
    rawForEachMatch(new Object[]{pParameter, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Parameter pParameter, final Type pType, final IMatchProcessor<? super ParametersWithTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pParameter, pType}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ParametersWithTypeMatch newMatch(final Parameter pParameter, final Type pType) {
    return ParametersWithTypeMatch.newMatch(pParameter, pType);
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfparameter(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PARAMETER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter() {
    return rawAccumulateAllValuesOfparameter(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final ParametersWithTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfparameter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final Type pType) {
    return rawAccumulateAllValuesOfparameter(new Object[]{
    null, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Type> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<Type> results = new HashSet<Type>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final ParametersWithTypeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Parameter pParameter) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pParameter, 
    null
    });
  }
  
  @Override
  protected ParametersWithTypeMatch tupleToMatch(final Tuple t) {
    try {
    	return ParametersWithTypeMatch.newMatch((Parameter) t.get(POSITION_PARAMETER), (Type) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ParametersWithTypeMatch arrayToMatch(final Object[] match) {
    try {
    	return ParametersWithTypeMatch.newMatch((Parameter) match[POSITION_PARAMETER], (Type) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ParametersWithTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ParametersWithTypeMatch.newMutableMatch((Parameter) match[POSITION_PARAMETER], (Type) match[POSITION_TYPE]);
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
  public static IQuerySpecification<ParametersWithTypeMatcher> querySpecification() throws ViatraQueryException {
    return ParametersWithTypeQuerySpecification.instance();
  }
}
