/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

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
import patterns.ClassGeneralizationsMatch;
import patterns.util.ClassGeneralizationsQuerySpecification;

/**
 * Generated pattern matcher API of the patterns.classGeneralizations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ClassGeneralizationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern classGeneralizations(class : Class, generalizationTarget : Element) {
 * 	find classes(class, _name);
 * 	Class.generalization(class, generalization);
 * 	Generalization.general(generalization, generalizationTarget);
 * }
 * </pre></code>
 * 
 * @see ClassGeneralizationsMatch
 * @see ClassGeneralizationsProcessor
 * @see ClassGeneralizationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ClassGeneralizationsMatcher extends BaseMatcher<ClassGeneralizationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ClassGeneralizationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ClassGeneralizationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (ClassGeneralizationsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ClassGeneralizationsMatcher create() throws ViatraQueryException {
    return new ClassGeneralizationsMatcher();
  }
  
  private final static int POSITION_CLASS = 0;
  
  private final static int POSITION_GENERALIZATIONTARGET = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClassGeneralizationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ClassGeneralizationsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return matches represented as a ClassGeneralizationsMatch object.
   * 
   */
  public Collection<ClassGeneralizationsMatch> getAllMatches(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return rawGetAllMatches(new Object[]{pClass, pGeneralizationTarget});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return a match represented as a ClassGeneralizationsMatch object, or null if no match is found.
   * 
   */
  public ClassGeneralizationsMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return rawGetOneArbitraryMatch(new Object[]{pClass, pGeneralizationTarget});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return rawHasMatch(new Object[]{pClass, pGeneralizationTarget});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return rawCountMatches(new Object[]{pClass, pGeneralizationTarget});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget, final IMatchProcessor<? super ClassGeneralizationsMatch> processor) {
    rawForEachMatch(new Object[]{pClass, pGeneralizationTarget}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget, final IMatchProcessor<? super ClassGeneralizationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pClass, pGeneralizationTarget}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ClassGeneralizationsMatch newMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return ClassGeneralizationsMatch.newMatch(pClass, pGeneralizationTarget);
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfclass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfclass() {
    return rawAccumulateAllValuesOfclass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfclass(final ClassGeneralizationsMatch partialMatch) {
    return rawAccumulateAllValuesOfclass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfclass(final Element pGeneralizationTarget) {
    return rawAccumulateAllValuesOfclass(new Object[]{
    null, 
    pGeneralizationTarget
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalizationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Element> rawAccumulateAllValuesOfgeneralizationTarget(final Object[] parameters) {
    Set<Element> results = new HashSet<Element>();
    rawAccumulateAllValues(POSITION_GENERALIZATIONTARGET, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalizationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfgeneralizationTarget() {
    return rawAccumulateAllValuesOfgeneralizationTarget(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalizationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfgeneralizationTarget(final ClassGeneralizationsMatch partialMatch) {
    return rawAccumulateAllValuesOfgeneralizationTarget(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalizationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfgeneralizationTarget(final org.eclipse.uml2.uml.Class pClass) {
    return rawAccumulateAllValuesOfgeneralizationTarget(new Object[]{
    pClass, 
    null
    });
  }
  
  @Override
  protected ClassGeneralizationsMatch tupleToMatch(final Tuple t) {
    try {
    	return ClassGeneralizationsMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLASS), (Element) t.get(POSITION_GENERALIZATIONTARGET));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClassGeneralizationsMatch arrayToMatch(final Object[] match) {
    try {
    	return ClassGeneralizationsMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLASS], (Element) match[POSITION_GENERALIZATIONTARGET]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClassGeneralizationsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ClassGeneralizationsMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLASS], (Element) match[POSITION_GENERALIZATIONTARGET]);
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
  public static IQuerySpecification<ClassGeneralizationsMatcher> querySpecification() throws ViatraQueryException {
    return ClassGeneralizationsQuerySpecification.instance();
  }
}
