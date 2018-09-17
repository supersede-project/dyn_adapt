/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.PropertiesWithTypeMatch;
import eu.supersede.dynadapt.modeladapter.queries.util.PropertiesWithTypeQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.modeladapter.queries.propertiesWithType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PropertiesWithTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern propertiesWithType (property : Property, type: Type){
 * 	Property.type (property, type);
 * 	
 * //	Type.name (type, name);
 * //	check (
 * //		name.equals("UserRepository")
 * //	);
 * }
 * </pre></code>
 * 
 * @see PropertiesWithTypeMatch
 * @see PropertiesWithTypeProcessor
 * @see PropertiesWithTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PropertiesWithTypeMatcher extends BaseMatcher<PropertiesWithTypeMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PropertiesWithTypeMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    PropertiesWithTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (PropertiesWithTypeMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static PropertiesWithTypeMatcher create() throws ViatraQueryException {
    return new PropertiesWithTypeMatcher();
  }
  
  private final static int POSITION_PROPERTY = 0;
  
  private final static int POSITION_TYPE = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PropertiesWithTypeMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private PropertiesWithTypeMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a PropertiesWithTypeMatch object.
   * 
   */
  public Collection<PropertiesWithTypeMatch> getAllMatches(final Property pProperty, final Type pType) {
    return rawGetAllMatches(new Object[]{pProperty, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a PropertiesWithTypeMatch object, or null if no match is found.
   * 
   */
  public PropertiesWithTypeMatch getOneArbitraryMatch(final Property pProperty, final Type pType) {
    return rawGetOneArbitraryMatch(new Object[]{pProperty, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Property pProperty, final Type pType) {
    return rawHasMatch(new Object[]{pProperty, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Property pProperty, final Type pType) {
    return rawCountMatches(new Object[]{pProperty, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Property pProperty, final Type pType, final IMatchProcessor<? super PropertiesWithTypeMatch> processor) {
    rawForEachMatch(new Object[]{pProperty, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Property pProperty, final Type pType, final IMatchProcessor<? super PropertiesWithTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pProperty, pType}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public PropertiesWithTypeMatch newMatch(final Property pProperty, final Type pType) {
    return PropertiesWithTypeMatch.newMatch(pProperty, pType);
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfproperty(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_PROPERTY, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty() {
    return rawAccumulateAllValuesOfproperty(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final PropertiesWithTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfproperty(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final Type pType) {
    return rawAccumulateAllValuesOfproperty(new Object[]{
    null, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Type> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<Type> results = new HashSet<Type>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final PropertiesWithTypeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Property pProperty) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pProperty, 
    null
    });
  }
  
  @Override
  protected PropertiesWithTypeMatch tupleToMatch(final Tuple t) {
    try {
        return PropertiesWithTypeMatch.newMatch((Property) t.get(POSITION_PROPERTY), (Type) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected PropertiesWithTypeMatch arrayToMatch(final Object[] match) {
    try {
        return PropertiesWithTypeMatch.newMatch((Property) match[POSITION_PROPERTY], (Type) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected PropertiesWithTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
        return PropertiesWithTypeMatch.newMutableMatch((Property) match[POSITION_PROPERTY], (Type) match[POSITION_TYPE]);
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
  public static IQuerySpecification<PropertiesWithTypeMatcher> querySpecification() throws ViatraQueryException {
    return PropertiesWithTypeQuerySpecification.instance();
  }
}
