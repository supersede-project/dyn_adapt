/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.GetReferenceToTypeMatch;
import eu.supersede.dynadapt.modeladapter.queries.util.GetReferenceToTypeQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.modeladapter.queries.getReferenceToType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GetReferenceToTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern getReferenceToType(element : Element, type:Class){
 * 	find referencesToType(element, type);
 * 
 * //	Type.name (type, name);
 * //	check (
 * //		name.equals ("UserToAuthenticate")
 * //	);
 * }
 * </pre></code>
 * 
 * @see GetReferenceToTypeMatch
 * @see GetReferenceToTypeProcessor
 * @see GetReferenceToTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GetReferenceToTypeMatcher extends BaseMatcher<GetReferenceToTypeMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GetReferenceToTypeMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    GetReferenceToTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (GetReferenceToTypeMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static GetReferenceToTypeMatcher create() throws ViatraQueryException {
    return new GetReferenceToTypeMatcher();
  }
  
  private final static int POSITION_ELEMENT = 0;
  
  private final static int POSITION_TYPE = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GetReferenceToTypeMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private GetReferenceToTypeMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a GetReferenceToTypeMatch object.
   * 
   */
  public Collection<GetReferenceToTypeMatch> getAllMatches(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return rawGetAllMatches(new Object[]{pElement, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a GetReferenceToTypeMatch object, or null if no match is found.
   * 
   */
  public GetReferenceToTypeMatch getOneArbitraryMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return rawGetOneArbitraryMatch(new Object[]{pElement, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return rawHasMatch(new Object[]{pElement, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return rawCountMatches(new Object[]{pElement, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType, final IMatchProcessor<? super GetReferenceToTypeMatch> processor) {
    rawForEachMatch(new Object[]{pElement, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType, final IMatchProcessor<? super GetReferenceToTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pElement, pType}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GetReferenceToTypeMatch newMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return GetReferenceToTypeMatch.newMatch(pElement, pType);
  }
  
  /**
   * Retrieve the set of values that occur in matches for element.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Element> rawAccumulateAllValuesOfelement(final Object[] parameters) {
    Set<Element> results = new HashSet<Element>();
    rawAccumulateAllValues(POSITION_ELEMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for element.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelement() {
    return rawAccumulateAllValuesOfelement(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for element.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelement(final GetReferenceToTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfelement(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for element.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelement(final org.eclipse.uml2.uml.Class pType) {
    return rawAccumulateAllValuesOfelement(new Object[]{
    null, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOftype(final GetReferenceToTypeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOftype(final Element pElement) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pElement, 
    null
    });
  }
  
  @Override
  protected GetReferenceToTypeMatch tupleToMatch(final Tuple t) {
    try {
        return GetReferenceToTypeMatch.newMatch((Element) t.get(POSITION_ELEMENT), (org.eclipse.uml2.uml.Class) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected GetReferenceToTypeMatch arrayToMatch(final Object[] match) {
    try {
        return GetReferenceToTypeMatch.newMatch((Element) match[POSITION_ELEMENT], (org.eclipse.uml2.uml.Class) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected GetReferenceToTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
        return GetReferenceToTypeMatch.newMutableMatch((Element) match[POSITION_ELEMENT], (org.eclipse.uml2.uml.Class) match[POSITION_TYPE]);
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
  public static IQuerySpecification<GetReferenceToTypeMatcher> querySpecification() throws ViatraQueryException {
    return GetReferenceToTypeQuerySpecification.instance();
  }
}
