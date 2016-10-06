/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.util.ArtifactManifestationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.atos.queries.artifactManifestations pattern,
 * to be used in conjunction with {@link ArtifactManifestationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ArtifactManifestationsMatcher
 * @see ArtifactManifestationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ArtifactManifestationsMatch extends BasePatternMatch {
  private Artifact fArtifact;
  
  private NamedElement fManifestationTarget;
  
  private static List<String> parameterNames = makeImmutableList("artifact", "manifestationTarget");
  
  private ArtifactManifestationsMatch(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    this.fArtifact = pArtifact;
    this.fManifestationTarget = pManifestationTarget;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("artifact".equals(parameterName)) return this.fArtifact;
    if ("manifestationTarget".equals(parameterName)) return this.fManifestationTarget;
    return null;
  }
  
  public Artifact getArtifact() {
    return this.fArtifact;
  }
  
  public NamedElement getManifestationTarget() {
    return this.fManifestationTarget;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("artifact".equals(parameterName) ) {
    	this.fArtifact = (Artifact) newValue;
    	return true;
    }
    if ("manifestationTarget".equals(parameterName) ) {
    	this.fManifestationTarget = (NamedElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setArtifact(final Artifact pArtifact) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fArtifact = pArtifact;
  }
  
  public void setManifestationTarget(final NamedElement pManifestationTarget) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fManifestationTarget = pManifestationTarget;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.atos.queries.artifactManifestations";
  }
  
  @Override
  public List<String> parameterNames() {
    return ArtifactManifestationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fArtifact, fManifestationTarget};
  }
  
  @Override
  public ArtifactManifestationsMatch toImmutable() {
    return isMutable() ? newMatch(fArtifact, fManifestationTarget) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"artifact\"=" + prettyPrintValue(fArtifact) + ", ");
    
    result.append("\"manifestationTarget\"=" + prettyPrintValue(fManifestationTarget)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fArtifact == null) ? 0 : fArtifact.hashCode());
    result = prime * result + ((fManifestationTarget == null) ? 0 : fManifestationTarget.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ArtifactManifestationsMatch)) { // this should be infrequent
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
    ArtifactManifestationsMatch other = (ArtifactManifestationsMatch) obj;
    if (fArtifact == null) {if (other.fArtifact != null) return false;}
    else if (!fArtifact.equals(other.fArtifact)) return false;
    if (fManifestationTarget == null) {if (other.fManifestationTarget != null) return false;}
    else if (!fManifestationTarget.equals(other.fManifestationTarget)) return false;
    return true;
  }
  
  @Override
  public ArtifactManifestationsQuerySpecification specification() {
    try {
    	return ArtifactManifestationsQuerySpecification.instance();
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
  public static ArtifactManifestationsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pArtifact the fixed value of pattern parameter artifact, or null if not bound.
   * @param pManifestationTarget the fixed value of pattern parameter manifestationTarget, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ArtifactManifestationsMatch newMutableMatch(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return new Mutable(pArtifact, pManifestationTarget);
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
  public static ArtifactManifestationsMatch newMatch(final Artifact pArtifact, final NamedElement pManifestationTarget) {
    return new Immutable(pArtifact, pManifestationTarget);
  }
  
  private static final class Mutable extends ArtifactManifestationsMatch {
    Mutable(final Artifact pArtifact, final NamedElement pManifestationTarget) {
      super(pArtifact, pManifestationTarget);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ArtifactManifestationsMatch {
    Immutable(final Artifact pArtifact, final NamedElement pManifestationTarget) {
      super(pArtifact, pManifestationTarget);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
