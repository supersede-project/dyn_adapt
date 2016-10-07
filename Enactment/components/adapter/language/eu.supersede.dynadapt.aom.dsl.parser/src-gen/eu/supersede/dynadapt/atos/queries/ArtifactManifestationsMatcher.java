/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.ArtifactManifestationsMatch;
import eu.supersede.dynadapt.atos.queries.util.ArtifactManifestationsQuerySpecification;
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
 * Generated pattern matcher API of the eu.supersede.dynadapt.atos.queries.artifactManifestations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ArtifactManifestationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern artifactManifestations (artifact, manifestationTarget){
 * 	find nodeArtifacts(_, artifact);
 * 	Artifact.manifestation (artifact, manifestation);
 * 	Manifestation.supplier (manifestation, manifestationTarget);
 * }
 * </pre></code>
 * 
 * @see ArtifactManifestationsMatch
 * @see ArtifactManifestationsProcessor
 * @see ArtifactManifestationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ArtifactManifestationsMatcher extends BaseMatcher<ArtifactManifestationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ArtifactManifestationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ArtifactManifestationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ArtifactManifestationsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ARTIFACT = 0;
  
  private final static int POSITION_MANIFESTATIONTARGET = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ArtifactManifestationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ArtifactManifestationsMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @return matches represented as a ArtifactManifestationsMatch object.
   * 
   */
  public Collection<ArtifactManifestationsMatch> getAllMatches(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return rawGetAllMatches(new Object[]{pArtifact, pManifestationTarget});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @return a match represented as a ArtifactManifestationsMatch object, or null if no match is found.
   * 
   */
  public ArtifactManifestationsMatch getOneArbitraryMatch(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return rawGetOneArbitraryMatch(new Object[]{pArtifact, pManifestationTarget});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return rawHasMatch(new Object[]{pArtifact, pManifestationTarget});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return rawCountMatches(new Object[]{pArtifact, pManifestationTarget});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Artifact pArtifact, final NamedElement pManifestationTarget, final IMatchProcessor<? super ArtifactManifestationsMatch> processor) {
    rawForEachMatch(new Object[]{pArtifact, pManifestationTarget}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Artifact pArtifact, final NamedElement pManifestationTarget, final IMatchProcessor<? super ArtifactManifestationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pArtifact, pManifestationTarget}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ArtifactManifestationsMatch newMatch(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return ArtifactManifestationsMatch.newMatch(pArtifact, pManifestationTarget);
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Artifact> rawAccumulateAllValuesOfartifact(final Object[] parameters) {
    Set<Artifact> results = new HashSet<Artifact>();
    rawAccumulateAllValues(POSITION_ARTIFACT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact() {
    return rawAccumulateAllValuesOfartifact(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact(final ArtifactManifestationsMatch partialMatch) {
    return rawAccumulateAllValuesOfartifact(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact(final NamedElement pManifestationTarget) {
    return rawAccumulateAllValuesOfartifact(new Object[]{
    null, 
    pManifestationTarget
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<NamedElement> rawAccumulateAllValuesOfmanifestationTarget(final Object[] parameters) {
    Set<NamedElement> results = new HashSet<NamedElement>();
    rawAccumulateAllValues(POSITION_MANIFESTATIONTARGET, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfmanifestationTarget() {
    return rawAccumulateAllValuesOfmanifestationTarget(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfmanifestationTarget(final ArtifactManifestationsMatch partialMatch) {
    return rawAccumulateAllValuesOfmanifestationTarget(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for manifestationTarget.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfmanifestationTarget(final Artifact pArtifact) {
    return rawAccumulateAllValuesOfmanifestationTarget(new Object[]{
    pArtifact, 
    null
    });
  }
  
  @Override
  protected ArtifactManifestationsMatch tupleToMatch(final Tuple t) {
    try {
    	return ArtifactManifestationsMatch.newMatch((Artifact) t.get(POSITION_ARTIFACT), (NamedElement) t.get(POSITION_MANIFESTATIONTARGET));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ArtifactManifestationsMatch arrayToMatch(final Object[] match) {
    try {
    	return ArtifactManifestationsMatch.newMatch((Artifact) match[POSITION_ARTIFACT], (NamedElement) match[POSITION_MANIFESTATIONTARGET]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ArtifactManifestationsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ArtifactManifestationsMatch.newMutableMatch((Artifact) match[POSITION_ARTIFACT], (NamedElement) match[POSITION_MANIFESTATIONTARGET]);
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
  public static IQuerySpecification<ArtifactManifestationsMatcher> querySpecification() throws ViatraQueryException {
    return ArtifactManifestationsQuerySpecification.instance();
  }
}
