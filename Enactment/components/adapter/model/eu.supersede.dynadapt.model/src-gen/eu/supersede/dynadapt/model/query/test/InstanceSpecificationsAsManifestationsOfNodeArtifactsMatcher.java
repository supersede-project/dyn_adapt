/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch;
import eu.supersede.dynadapt.model.query.test.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.model.query.test.instanceSpecificationsAsManifestationsOfNodeArtifacts pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern instanceSpecificationsAsManifestationsOfNodeArtifacts(artifact, instance){
 * 	find artifactManifestations(artifact, instance);
 * 	InstanceSpecification (instance);
 * }
 * </pre></code>
 * 
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsProcessor
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher extends BaseMatcher<InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher create() throws ViatraQueryException {
    return new InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher();
  }
  
  private final static int POSITION_ARTIFACT = 0;
  
  private final static int POSITION_INSTANCE = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return matches represented as a InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch object.
   * 
   */
  public Collection<InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch> getAllMatches(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return rawGetAllMatches(new Object[]{pArtifact, pInstance});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return a match represented as a InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch object, or null if no match is found.
   * 
   */
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch getOneArbitraryMatch(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return rawGetOneArbitraryMatch(new Object[]{pArtifact, pInstance});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return rawHasMatch(new Object[]{pArtifact, pInstance});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return rawCountMatches(new Object[]{pArtifact, pInstance});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Artifact pArtifact, final InstanceSpecification pInstance, final IMatchProcessor<? super InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch> processor) {
    rawForEachMatch(new Object[]{pArtifact, pInstance}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Artifact pArtifact, final InstanceSpecification pInstance, final IMatchProcessor<? super InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pArtifact, pInstance}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch newMatch(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.newMatch(pArtifact, pInstance);
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Artifact> rawAccumulateAllValuesOfartifact(final Object[] parameters) {
    Set<Artifact> results = new HashSet<Artifact>();
    rawAccumulateAllValues(POSITION_ARTIFACT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact() {
    return rawAccumulateAllValuesOfartifact(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact(final InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch partialMatch) {
    return rawAccumulateAllValuesOfartifact(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact(final InstanceSpecification pInstance) {
    return rawAccumulateAllValuesOfartifact(new Object[]{
    null, 
    pInstance
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfinstance(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_INSTANCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance() {
    return rawAccumulateAllValuesOfinstance(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance(final InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch partialMatch) {
    return rawAccumulateAllValuesOfinstance(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfinstance(final Artifact pArtifact) {
    return rawAccumulateAllValuesOfinstance(new Object[]{
    pArtifact, 
    null
    });
  }
  
  @Override
  protected InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch tupleToMatch(final Tuple t) {
    try {
        return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.newMatch((Artifact) t.get(POSITION_ARTIFACT), (InstanceSpecification) t.get(POSITION_INSTANCE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch arrayToMatch(final Object[] match) {
    try {
        return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.newMatch((Artifact) match[POSITION_ARTIFACT], (InstanceSpecification) match[POSITION_INSTANCE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch arrayToMatchMutable(final Object[] match) {
    try {
        return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.newMutableMatch((Artifact) match[POSITION_ARTIFACT], (InstanceSpecification) match[POSITION_INSTANCE]);
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
  public static IQuerySpecification<InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher> querySpecification() throws ViatraQueryException {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.instance();
  }
}
