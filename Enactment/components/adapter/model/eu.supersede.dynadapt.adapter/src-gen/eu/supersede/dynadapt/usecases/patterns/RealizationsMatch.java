/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.util.RealizationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.patterns.realizations pattern,
 * to be used in conjunction with {@link RealizationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RealizationsMatcher
 * @see RealizationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RealizationsMatch extends BasePatternMatch {
  private InstanceSpecification fClient;
  
  private org.eclipse.uml2.uml.Class fSupplier;
  
  private static List<String> parameterNames = makeImmutableList("client", "supplier");
  
  private RealizationsMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    this.fClient = pClient;
    this.fSupplier = pSupplier;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("client".equals(parameterName)) return this.fClient;
    if ("supplier".equals(parameterName)) return this.fSupplier;
    return null;
  }
  
  public InstanceSpecification getClient() {
    return this.fClient;
  }
  
  public org.eclipse.uml2.uml.Class getSupplier() {
    return this.fSupplier;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("client".equals(parameterName) ) {
    	this.fClient = (InstanceSpecification) newValue;
    	return true;
    }
    if ("supplier".equals(parameterName) ) {
    	this.fSupplier = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setClient(final InstanceSpecification pClient) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClient = pClient;
  }
  
  public void setSupplier(final org.eclipse.uml2.uml.Class pSupplier) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSupplier = pSupplier;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.patterns.realizations";
  }
  
  @Override
  public List<String> parameterNames() {
    return RealizationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClient, fSupplier};
  }
  
  @Override
  public RealizationsMatch toImmutable() {
    return isMutable() ? newMatch(fClient, fSupplier) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"client\"=" + prettyPrintValue(fClient) + ", ");
    
    result.append("\"supplier\"=" + prettyPrintValue(fSupplier)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClient == null) ? 0 : fClient.hashCode());
    result = prime * result + ((fSupplier == null) ? 0 : fSupplier.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RealizationsMatch)) { // this should be infrequent
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
    RealizationsMatch other = (RealizationsMatch) obj;
    if (fClient == null) {if (other.fClient != null) return false;}
    else if (!fClient.equals(other.fClient)) return false;
    if (fSupplier == null) {if (other.fSupplier != null) return false;}
    else if (!fSupplier.equals(other.fSupplier)) return false;
    return true;
  }
  
  @Override
  public RealizationsQuerySpecification specification() {
    try {
    	return RealizationsQuerySpecification.instance();
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
  public static RealizationsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RealizationsMatch newMutableMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return new Mutable(pClient, pSupplier);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RealizationsMatch newMatch(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
    return new Immutable(pClient, pSupplier);
  }
  
  private static final class Mutable extends RealizationsMatch {
    Mutable(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
      super(pClient, pSupplier);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RealizationsMatch {
    Immutable(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier) {
      super(pClient, pSupplier);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
