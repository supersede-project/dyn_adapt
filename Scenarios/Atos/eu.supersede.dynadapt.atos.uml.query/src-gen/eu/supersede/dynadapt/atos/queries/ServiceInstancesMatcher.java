/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.ServiceInstancesMatch;
import eu.supersede.dynadapt.atos.queries.util.ServiceInstancesQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.atos.queries.serviceInstances pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ServiceInstancesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern serviceInstances (service, instance){
 * 	find artifactManifestations(service, instance);
 * }
 * </pre></code>
 * 
 * @see ServiceInstancesMatch
 * @see ServiceInstancesProcessor
 * @see ServiceInstancesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ServiceInstancesMatcher extends BaseMatcher<ServiceInstancesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ServiceInstancesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ServiceInstancesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ServiceInstancesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SERVICE = 0;
  
  private final static int POSITION_INSTANCE = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ServiceInstancesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ServiceInstancesMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return matches represented as a ServiceInstancesMatch object.
   * 
   */
  public Collection<ServiceInstancesMatch> getAllMatches(final Artifact pService, final NamedElement pInstance) {
    return rawGetAllMatches(new Object[]{pService, pInstance});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return a match represented as a ServiceInstancesMatch object, or null if no match is found.
   * 
   */
  public ServiceInstancesMatch getOneArbitraryMatch(final Artifact pService, final NamedElement pInstance) {
    return rawGetOneArbitraryMatch(new Object[]{pService, pInstance});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Artifact pService, final NamedElement pInstance) {
    return rawHasMatch(new Object[]{pService, pInstance});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Artifact pService, final NamedElement pInstance) {
    return rawCountMatches(new Object[]{pService, pInstance});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Artifact pService, final NamedElement pInstance, final IMatchProcessor<? super ServiceInstancesMatch> processor) {
    rawForEachMatch(new Object[]{pService, pInstance}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Artifact pService, final NamedElement pInstance, final IMatchProcessor<? super ServiceInstancesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pService, pInstance}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ServiceInstancesMatch newMatch(final Artifact pService, final NamedElement pInstance) {
    return ServiceInstancesMatch.newMatch(pService, pInstance);
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Artifact> rawAccumulateAllValuesOfservice(final Object[] parameters) {
    Set<Artifact> results = new HashSet<Artifact>();
    rawAccumulateAllValues(POSITION_SERVICE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfservice() {
    return rawAccumulateAllValuesOfservice(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfservice(final ServiceInstancesMatch partialMatch) {
    return rawAccumulateAllValuesOfservice(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for service.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfservice(final NamedElement pInstance) {
    return rawAccumulateAllValuesOfservice(new Object[]{
    null, 
    pInstance
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<NamedElement> rawAccumulateAllValuesOfinstance(final Object[] parameters) {
    Set<NamedElement> results = new HashSet<NamedElement>();
    rawAccumulateAllValues(POSITION_INSTANCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfinstance() {
    return rawAccumulateAllValuesOfinstance(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfinstance(final ServiceInstancesMatch partialMatch) {
    return rawAccumulateAllValuesOfinstance(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfinstance(final Artifact pService) {
    return rawAccumulateAllValuesOfinstance(new Object[]{
    pService, 
    null
    });
  }
  
  @Override
  protected ServiceInstancesMatch tupleToMatch(final Tuple t) {
    try {
    	return ServiceInstancesMatch.newMatch((Artifact) t.get(POSITION_SERVICE), (NamedElement) t.get(POSITION_INSTANCE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ServiceInstancesMatch arrayToMatch(final Object[] match) {
    try {
    	return ServiceInstancesMatch.newMatch((Artifact) match[POSITION_SERVICE], (NamedElement) match[POSITION_INSTANCE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ServiceInstancesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ServiceInstancesMatch.newMutableMatch((Artifact) match[POSITION_SERVICE], (NamedElement) match[POSITION_INSTANCE]);
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
  public static IQuerySpecification<ServiceInstancesMatcher> querySpecification() throws ViatraQueryException {
    return ServiceInstancesQuerySpecification.instance();
  }
}
