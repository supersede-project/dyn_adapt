/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.util.NodesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Node;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.model.query.test.nodes pattern,
 * to be used in conjunction with {@link NodesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NodesMatcher
 * @see NodesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NodesMatch extends BasePatternMatch {
  private Node fNode;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("node", "name");
  
  private NodesMatch(final Node pNode, final String pName) {
    this.fNode = pNode;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("node".equals(parameterName)) return this.fNode;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public Node getNode() {
    return this.fNode;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("node".equals(parameterName) ) {
    	this.fNode = (Node) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setNode(final Node pNode) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNode = pNode;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.model.query.test.nodes";
  }
  
  @Override
  public List<String> parameterNames() {
    return NodesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fNode, fName};
  }
  
  @Override
  public NodesMatch toImmutable() {
    return isMutable() ? newMatch(fNode, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"node\"=" + prettyPrintValue(fNode) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fNode == null) ? 0 : fNode.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NodesMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    NodesMatch other = (NodesMatch) obj;
    if (fNode == null) {if (other.fNode != null) return false;}
    else if (!fNode.equals(other.fNode)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public NodesQuerySpecification specification() {
    try {
    	return NodesQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static NodesMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NodesMatch newMutableMatch(final Node pNode, final String pName) {
    return new Mutable(pNode, pName);
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
  public static NodesMatch newMatch(final Node pNode, final String pName) {
    return new Immutable(pNode, pName);
  }
  
  private static final class Mutable extends NodesMatch {
    Mutable(final Node pNode, final String pName) {
      super(pNode, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NodesMatch {
    Immutable(final Node pNode, final String pName) {
      super(pNode, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
