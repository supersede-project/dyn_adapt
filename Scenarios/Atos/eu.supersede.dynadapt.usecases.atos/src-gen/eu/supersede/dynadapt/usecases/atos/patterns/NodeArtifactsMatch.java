package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.util.NodeArtifactsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Node;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.atos.patterns.nodeArtifacts pattern,
 * to be used in conjunction with {@link NodeArtifactsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NodeArtifactsMatcher
 * @see NodeArtifactsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NodeArtifactsMatch extends BasePatternMatch {
  private Node fNode;
  
  private Artifact fArtifact;
  
  private static List<String> parameterNames = makeImmutableList("node", "artifact");
  
  private NodeArtifactsMatch(final Node pNode, final Artifact pArtifact) {
    this.fNode = pNode;
    this.fArtifact = pArtifact;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("node".equals(parameterName)) return this.fNode;
    if ("artifact".equals(parameterName)) return this.fArtifact;
    return null;
  }
  
  public Node getNode() {
    return this.fNode;
  }
  
  public Artifact getArtifact() {
    return this.fArtifact;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("node".equals(parameterName) ) {
    	this.fNode = (Node) newValue;
    	return true;
    }
    if ("artifact".equals(parameterName) ) {
    	this.fArtifact = (Artifact) newValue;
    	return true;
    }
    return false;
  }
  
  public void setNode(final Node pNode) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNode = pNode;
  }
  
  public void setArtifact(final Artifact pArtifact) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fArtifact = pArtifact;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.atos.patterns.nodeArtifacts";
  }
  
  @Override
  public List<String> parameterNames() {
    return NodeArtifactsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fNode, fArtifact};
  }
  
  @Override
  public NodeArtifactsMatch toImmutable() {
    return isMutable() ? newMatch(fNode, fArtifact) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"node\"=" + prettyPrintValue(fNode) + ", ");
    
    result.append("\"artifact\"=" + prettyPrintValue(fArtifact)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fNode == null) ? 0 : fNode.hashCode());
    result = prime * result + ((fArtifact == null) ? 0 : fArtifact.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NodeArtifactsMatch)) { // this should be infrequent
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
    NodeArtifactsMatch other = (NodeArtifactsMatch) obj;
    if (fNode == null) {if (other.fNode != null) return false;}
    else if (!fNode.equals(other.fNode)) return false;
    if (fArtifact == null) {if (other.fArtifact != null) return false;}
    else if (!fArtifact.equals(other.fArtifact)) return false;
    return true;
  }
  
  @Override
  public NodeArtifactsQuerySpecification specification() {
    try {
    	return NodeArtifactsQuerySpecification.instance();
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
  public static NodeArtifactsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pNode the fixed value of pattern parameter node, or null if not bound.
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NodeArtifactsMatch newMutableMatch(final Node pNode, final Artifact pArtifact) {
    return new Mutable(pNode, pArtifact);
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
  public static NodeArtifactsMatch newMatch(final Node pNode, final Artifact pArtifact) {
    return new Immutable(pNode, pArtifact);
  }
  
  private static final class Mutable extends NodeArtifactsMatch {
    Mutable(final Node pNode, final Artifact pArtifact) {
      super(pNode, pArtifact);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NodeArtifactsMatch {
    Immutable(final Node pNode, final Artifact pArtifact) {
      super(pNode, pArtifact);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
