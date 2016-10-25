/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.NodeArtifactsMatch;
import eu.supersede.dynadapt.atos.queries.util.NodeArtifactsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Node;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.atos.queries.nodeArtifacts pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NodeArtifactsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern nodeArtifacts (node, artifact){
 * 	Node.nestedClassifier (node, artifact);
 * 	Artifact.name (artifact, _name);
 * }
 * </pre></code>
 * 
 * @see NodeArtifactsMatch
 * @see NodeArtifactsProcessor
 * @see NodeArtifactsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NodeArtifactsMatcher extends BaseMatcher<NodeArtifactsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NodeArtifactsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    NodeArtifactsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NodeArtifactsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_NODE = 0;
  
  private final static int POSITION_ARTIFACT = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NodeArtifactsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private NodeArtifactsMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @return matches represented as a NodeArtifactsMatch object.
   * 
   */
  public Collection<NodeArtifactsMatch> getAllMatches(final Node pNode, final Artifact pArtifact) {
    return rawGetAllMatches(new Object[]{pNode, pArtifact});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @return a match represented as a NodeArtifactsMatch object, or null if no match is found.
   * 
   */
  public NodeArtifactsMatch getOneArbitraryMatch(final Node pNode, final Artifact pArtifact) {
    return rawGetOneArbitraryMatch(new Object[]{pNode, pArtifact});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Node pNode, final Artifact pArtifact) {
    return rawHasMatch(new Object[]{pNode, pArtifact});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Node pNode, final Artifact pArtifact) {
    return rawCountMatches(new Object[]{pNode, pArtifact});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Node pNode, final Artifact pArtifact, final IMatchProcessor<? super NodeArtifactsMatch> processor) {
    rawForEachMatch(new Object[]{pNode, pArtifact}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Node pNode, final Artifact pArtifact, final IMatchProcessor<? super NodeArtifactsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pNode, pArtifact}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NodeArtifactsMatch newMatch(final Node pNode, final Artifact pArtifact) {
    return NodeArtifactsMatch.newMatch(pNode, pArtifact);
  }
  
  /**
   * Retrieve the set of values that occur in matches for node.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Node> rawAccumulateAllValuesOfnode(final Object[] parameters) {
    Set<Node> results = new HashSet<Node>();
    rawAccumulateAllValues(POSITION_NODE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for node.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Node> getAllValuesOfnode() {
    return rawAccumulateAllValuesOfnode(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for node.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Node> getAllValuesOfnode(final NodeArtifactsMatch partialMatch) {
    return rawAccumulateAllValuesOfnode(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for node.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Node> getAllValuesOfnode(final Artifact pArtifact) {
    return rawAccumulateAllValuesOfnode(new Object[]{
    null, 
    pArtifact
    });
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
  public Set<Artifact> getAllValuesOfartifact(final NodeArtifactsMatch partialMatch) {
    return rawAccumulateAllValuesOfartifact(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for artifact.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Artifact> getAllValuesOfartifact(final Node pNode) {
    return rawAccumulateAllValuesOfartifact(new Object[]{
    pNode, 
    null
    });
  }
  
  @Override
  protected NodeArtifactsMatch tupleToMatch(final Tuple t) {
    try {
    	return NodeArtifactsMatch.newMatch((Node) t.get(POSITION_NODE), (Artifact) t.get(POSITION_ARTIFACT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NodeArtifactsMatch arrayToMatch(final Object[] match) {
    try {
    	return NodeArtifactsMatch.newMatch((Node) match[POSITION_NODE], (Artifact) match[POSITION_ARTIFACT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NodeArtifactsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NodeArtifactsMatch.newMutableMatch((Node) match[POSITION_NODE], (Artifact) match[POSITION_ARTIFACT]);
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
  public static IQuerySpecification<NodeArtifactsMatcher> querySpecification() throws ViatraQueryException {
    return NodeArtifactsQuerySpecification.instance();
  }
}
