/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.atos.queries.instanceSpecificationsAsManifestationsOfNodeArtifacts pattern,
 * to be used in conjunction with {@link InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher
 * @see InstanceSpecificationsAsManifestationsOfNodeArtifactsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch extends BasePatternMatch {
  private Artifact fArtifact;
  
  private InstanceSpecification fInstance;
  
  private static List<String> parameterNames = makeImmutableList("artifact", "instance");
  
  private InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch(final Artifact pArtifact, final InstanceSpecification pInstance) {
    this.fArtifact = pArtifact;
    this.fInstance = pInstance;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("artifact".equals(parameterName)) return this.fArtifact;
    if ("instance".equals(parameterName)) return this.fInstance;
    return null;
  }
  
  public Artifact getArtifact() {
    return this.fArtifact;
  }
  
  public InstanceSpecification getInstance() {
    return this.fInstance;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("artifact".equals(parameterName) ) {
    	this.fArtifact = (Artifact) newValue;
    	return true;
    }
    if ("instance".equals(parameterName) ) {
    	this.fInstance = (InstanceSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setArtifact(final Artifact pArtifact) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fArtifact = pArtifact;
  }
  
  public void setInstance(final InstanceSpecification pInstance) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstance = pInstance;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.atos.queries.instanceSpecificationsAsManifestationsOfNodeArtifacts";
  }
  
  @Override
  public List<String> parameterNames() {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fArtifact, fInstance};
  }
  
  @Override
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch toImmutable() {
    return isMutable() ? newMatch(fArtifact, fInstance) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"artifact\"=" + prettyPrintValue(fArtifact) + ", ");
    
    result.append("\"instance\"=" + prettyPrintValue(fInstance)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fArtifact == null) ? 0 : fArtifact.hashCode());
    result = prime * result + ((fInstance == null) ? 0 : fInstance.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch)) { // this should be infrequent
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
    InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch other = (InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch) obj;
    if (fArtifact == null) {if (other.fArtifact != null) return false;}
    else if (!fArtifact.equals(other.fArtifact)) return false;
    if (fInstance == null) {if (other.fInstance != null) return false;}
    else if (!fInstance.equals(other.fInstance)) return false;
    return true;
  }
  
  @Override
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification specification() {
    try {
    	return InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.instance();
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
  public static InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch newMutableMatch(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return new Mutable(pArtifact, pInstance);
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
  public static InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch newMatch(final Artifact pArtifact, final InstanceSpecification pInstance) {
    return new Immutable(pArtifact, pInstance);
  }
  
  private static final class Mutable extends InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch {
    Mutable(final Artifact pArtifact, final InstanceSpecification pInstance) {
      super(pArtifact, pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch {
    Immutable(final Artifact pArtifact, final InstanceSpecification pInstance) {
      super(pArtifact, pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
