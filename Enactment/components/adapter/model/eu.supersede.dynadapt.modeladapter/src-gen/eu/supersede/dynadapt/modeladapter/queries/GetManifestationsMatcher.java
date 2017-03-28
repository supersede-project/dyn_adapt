/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.GetManifestationsMatch;
import eu.supersede.dynadapt.modeladapter.queries.util.GetManifestationsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.modeladapter.queries.getManifestations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GetManifestationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern getManifestations (manifestation: Manifestation, client: ExecutionEnvironment, supplier: InstanceSpecification){
 * 	Manifestation.client (manifestation, client);
 * 	Manifestation.supplier (manifestation, supplier);
 * }
 * </pre></code>
 * 
 * @see GetManifestationsMatch
 * @see GetManifestationsProcessor
 * @see GetManifestationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GetManifestationsMatcher extends BaseMatcher<GetManifestationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GetManifestationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    GetManifestationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (GetManifestationsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static GetManifestationsMatcher create() throws ViatraQueryException {
    return new GetManifestationsMatcher();
  }
  
  private final static int POSITION_MANIFESTATION = 0;
  
  private final static int POSITION_CLIENT = 1;
  
  private final static int POSITION_SUPPLIER = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GetManifestationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private GetManifestationsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return matches represented as a GetManifestationsMatch object.
   * 
   */
  public Collection<GetManifestationsMatch> getAllMatches(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier) {
    return rawGetAllMatches(new Object[]{pManifestation, pClient, pSupplier});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return a match represented as a GetManifestationsMatch object, or null if no match is found.
   * 
   */
  public GetManifestationsMatch getOneArbitraryMatch(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier) {
    return rawGetOneArbitraryMatch(new Object[]{pManifestation, pClient, pSupplier});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier) {
    return rawHasMatch(new Object[]{pManifestation, pClient, pSupplier});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier) {
    return rawCountMatches(new Object[]{pManifestation, pClient, pSupplier});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier, final IMatchProcessor<? super GetManifestationsMatch> processor) {
    rawForEachMatch(new Object[]{pManifestation, pClient, pSupplier}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier, final IMatchProcessor<? super GetManifestationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pManifestation, pClient, pSupplier}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pManifestation the fixed value of pattern parameter manifestation, or null if not bound.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GetManifestationsMatch newMatch(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier) {
    return GetManifestationsMatch.newMatch(pManifestation, pClient, pSupplier);
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Manifestation> rawAccumulateAllValuesOfmanifestation(final Object[] parameters) {
    Set<Manifestation> results = new HashSet<Manifestation>();
    rawAccumulateAllValues(POSITION_MANIFESTATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Manifestation> getAllValuesOfmanifestation() {
    return rawAccumulateAllValuesOfmanifestation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Manifestation> getAllValuesOfmanifestation(final GetManifestationsMatch partialMatch) {
    return rawAccumulateAllValuesOfmanifestation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Manifestation> getAllValuesOfmanifestation(final ExecutionEnvironment pClient, final InstanceSpecification pSupplier) {
    return rawAccumulateAllValuesOfmanifestation(new Object[]{
    null, 
    pClient, 
    pSupplier
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ExecutionEnvironment> rawAccumulateAllValuesOfclient(final Object[] parameters) {
    Set<ExecutionEnvironment> results = new HashSet<ExecutionEnvironment>();
    rawAccumulateAllValues(POSITION_CLIENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ExecutionEnvironment> getAllValuesOfclient() {
    return rawAccumulateAllValuesOfclient(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ExecutionEnvironment> getAllValuesOfclient(final GetManifestationsMatch partialMatch) {
    return rawAccumulateAllValuesOfclient(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for client.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ExecutionEnvironment> getAllValuesOfclient(final Manifestation pManifestation, final InstanceSpecification pSupplier) {
    return rawAccumulateAllValuesOfclient(new Object[]{
    pManifestation, 
    null, 
    pSupplier
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfsupplier(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_SUPPLIER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfsupplier() {
    return rawAccumulateAllValuesOfsupplier(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfsupplier(final GetManifestationsMatch partialMatch) {
    return rawAccumulateAllValuesOfsupplier(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for supplier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfsupplier(final Manifestation pManifestation, final ExecutionEnvironment pClient) {
    return rawAccumulateAllValuesOfsupplier(new Object[]{
    pManifestation, 
    pClient, 
    null
    });
  }
  
  @Override
  protected GetManifestationsMatch tupleToMatch(final Tuple t) {
    try {
    	return GetManifestationsMatch.newMatch((Manifestation) t.get(POSITION_MANIFESTATION), (ExecutionEnvironment) t.get(POSITION_CLIENT), (InstanceSpecification) t.get(POSITION_SUPPLIER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GetManifestationsMatch arrayToMatch(final Object[] match) {
    try {
    	return GetManifestationsMatch.newMatch((Manifestation) match[POSITION_MANIFESTATION], (ExecutionEnvironment) match[POSITION_CLIENT], (InstanceSpecification) match[POSITION_SUPPLIER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GetManifestationsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return GetManifestationsMatch.newMutableMatch((Manifestation) match[POSITION_MANIFESTATION], (ExecutionEnvironment) match[POSITION_CLIENT], (InstanceSpecification) match[POSITION_SUPPLIER]);
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
  public static IQuerySpecification<GetManifestationsMatcher> querySpecification() throws ViatraQueryException {
    return GetManifestationsQuerySpecification.instance();
  }
}
