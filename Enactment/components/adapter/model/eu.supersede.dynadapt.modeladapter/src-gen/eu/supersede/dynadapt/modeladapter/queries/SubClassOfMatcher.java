/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.SubClassOfMatch;
import eu.supersede.dynadapt.modeladapter.queries.util.SubClassOfQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.modeladapter.queries.subClassOf pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SubClassOfMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern subClassOf (subclass : Classifier, superclass : Class){
 *     Generalization.general (generalization, superclass);
 * 	Generalization.specific (generalization, subclass);
 * 	
 * //	Class.name (superclass, name);
 * //	check (
 * //		name.equals("SystemToAuthenticate")
 * //	);
 * }
 * </pre></code>
 * 
 * @see SubClassOfMatch
 * @see SubClassOfProcessor
 * @see SubClassOfQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SubClassOfMatcher extends BaseMatcher<SubClassOfMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SubClassOfMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    SubClassOfMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (SubClassOfMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static SubClassOfMatcher create() throws ViatraQueryException {
    return new SubClassOfMatcher();
  }
  
  private final static int POSITION_SUBCLASS = 0;
  
  private final static int POSITION_SUPERCLASS = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SubClassOfMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private SubClassOfMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return matches represented as a SubClassOfMatch object.
   * 
   */
  public Collection<SubClassOfMatch> getAllMatches(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return rawGetAllMatches(new Object[]{pSubclass, pSuperclass});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return a match represented as a SubClassOfMatch object, or null if no match is found.
   * 
   */
  public SubClassOfMatch getOneArbitraryMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return rawGetOneArbitraryMatch(new Object[]{pSubclass, pSuperclass});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return rawHasMatch(new Object[]{pSubclass, pSuperclass});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return rawCountMatches(new Object[]{pSubclass, pSuperclass});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass, final IMatchProcessor<? super SubClassOfMatch> processor) {
    rawForEachMatch(new Object[]{pSubclass, pSuperclass}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass, final IMatchProcessor<? super SubClassOfMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSubclass, pSuperclass}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SubClassOfMatch newMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return SubClassOfMatch.newMatch(pSubclass, pSuperclass);
  }
  
  /**
   * Retrieve the set of values that occur in matches for subclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Classifier> rawAccumulateAllValuesOfsubclass(final Object[] parameters) {
    Set<Classifier> results = new HashSet<Classifier>();
    rawAccumulateAllValues(POSITION_SUBCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for subclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Classifier> getAllValuesOfsubclass() {
    return rawAccumulateAllValuesOfsubclass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for subclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Classifier> getAllValuesOfsubclass(final SubClassOfMatch partialMatch) {
    return rawAccumulateAllValuesOfsubclass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for subclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Classifier> getAllValuesOfsubclass(final org.eclipse.uml2.uml.Class pSuperclass) {
    return rawAccumulateAllValuesOfsubclass(new Object[]{
    null, 
    pSuperclass
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for superclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfsuperclass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_SUPERCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for superclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsuperclass() {
    return rawAccumulateAllValuesOfsuperclass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for superclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsuperclass(final SubClassOfMatch partialMatch) {
    return rawAccumulateAllValuesOfsuperclass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for superclass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsuperclass(final Classifier pSubclass) {
    return rawAccumulateAllValuesOfsuperclass(new Object[]{
    pSubclass, 
    null
    });
  }
  
  @Override
  protected SubClassOfMatch tupleToMatch(final Tuple t) {
    try {
    	return SubClassOfMatch.newMatch((Classifier) t.get(POSITION_SUBCLASS), (org.eclipse.uml2.uml.Class) t.get(POSITION_SUPERCLASS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SubClassOfMatch arrayToMatch(final Object[] match) {
    try {
    	return SubClassOfMatch.newMatch((Classifier) match[POSITION_SUBCLASS], (org.eclipse.uml2.uml.Class) match[POSITION_SUPERCLASS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SubClassOfMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SubClassOfMatch.newMutableMatch((Classifier) match[POSITION_SUBCLASS], (org.eclipse.uml2.uml.Class) match[POSITION_SUPERCLASS]);
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
  public static IQuerySpecification<SubClassOfMatcher> querySpecification() throws ViatraQueryException {
    return SubClassOfQuerySpecification.instance();
  }
}
