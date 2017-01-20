/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.NodesMatch;
import eu.supersede.dynadapt.atos.queries.util.NodesQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Node;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the eu.supersede.dynadapt.atos.queries.nodes pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NodesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern nodes (node, name){
 * 	Node.name (node, name);
 * }
 * </pre></code>
 * 
 * @see NodesMatch
 * @see NodesProcessor
 * @see NodesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NodesMatcher extends BaseMatcher<NodesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NodesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    NodesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (NodesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NodesMatcher create() throws ViatraQueryException {
    return new NodesMatcher();
  }
  
  private final static int POSITION_NODE = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NodesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private NodesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a NodesMatch object.
   * 
   */
  public Collection<NodesMatch> getAllMatches(final Node pNode, final String pName) {
    return rawGetAllMatches(new Object[]{pNode, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a NodesMatch object, or null if no match is found.
   * 
   */
  public NodesMatch getOneArbitraryMatch(final Node pNode, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pNode, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Node pNode, final String pName) {
    return rawHasMatch(new Object[]{pNode, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Node pNode, final String pName) {
    return rawCountMatches(new Object[]{pNode, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Node pNode, final String pName, final IMatchProcessor<? super NodesMatch> processor) {
    rawForEachMatch(new Object[]{pNode, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Node pNode, final String pName, final IMatchProcessor<? super NodesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pNode, pName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NodesMatch newMatch(final Node pNode, final String pName) {
    return NodesMatch.newMatch(pNode, pName);
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
  public Set<Node> getAllValuesOfnode(final NodesMatch partialMatch) {
    return rawAccumulateAllValuesOfnode(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for node.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Node> getAllValuesOfnode(final String pName) {
    return rawAccumulateAllValuesOfnode(new Object[]{
    null, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final NodesMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final Node pNode) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pNode, 
    null
    });
  }
  
  @Override
  protected NodesMatch tupleToMatch(final Tuple t) {
    try {
    	return NodesMatch.newMatch((Node) t.get(POSITION_NODE), (String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NodesMatch arrayToMatch(final Object[] match) {
    try {
    	return NodesMatch.newMatch((Node) match[POSITION_NODE], (String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NodesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NodesMatch.newMutableMatch((Node) match[POSITION_NODE], (String) match[POSITION_NAME]);
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
  public static IQuerySpecification<NodesMatcher> querySpecification() throws ViatraQueryException {
    return NodesQuerySpecification.instance();
  }
}
