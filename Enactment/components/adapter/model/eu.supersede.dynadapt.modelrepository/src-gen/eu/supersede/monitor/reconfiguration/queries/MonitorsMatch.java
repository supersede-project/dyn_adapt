/*******************************************************************************
 * Copyright (c) 2016 UPC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
/**
 * Generated from platform:/resource/eu.supersede.monitor.reconfiguration.poc.uml.query/src/queries/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.monitor.reconfiguration.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.monitor.reconfiguration.queries.util.MonitorsQuerySpecification;

/**
 * Pattern-specific match representation of the queries.monitors pattern,
 * to be used in conjunction with {@link MonitorsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MonitorsMatcher
 * @see MonitorsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MonitorsMatch extends BasePatternMatch {
  private InstanceSpecification fClient;
  
  private NamedElement fSupplier;
  
  private org.eclipse.uml2.uml.Class fGeneralization;
  
  private static List<String> parameterNames = makeImmutableList("client", "supplier", "generalization");
  
  private MonitorsMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    this.fClient = pClient;
    this.fSupplier = pSupplier;
    this.fGeneralization = pGeneralization;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("client".equals(parameterName)) return this.fClient;
    if ("supplier".equals(parameterName)) return this.fSupplier;
    if ("generalization".equals(parameterName)) return this.fGeneralization;
    return null;
  }
  
  public InstanceSpecification getClient() {
    return this.fClient;
  }
  
  public NamedElement getSupplier() {
    return this.fSupplier;
  }
  
  public org.eclipse.uml2.uml.Class getGeneralization() {
    return this.fGeneralization;
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
    if ("generalization".equals(parameterName) ) {
    	this.fGeneralization = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setClient(final InstanceSpecification pClient) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClient = pClient;
  }
  
  public void setSupplier(final NamedElement pSupplier) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSupplier = pSupplier;
  }
  
  public void setGeneralization(final org.eclipse.uml2.uml.Class pGeneralization) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGeneralization = pGeneralization;
  }
  
  @Override
  public String patternName() {
    return "queries.monitors";
  }
  
  @Override
  public List<String> parameterNames() {
    return MonitorsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClient, fSupplier, fGeneralization};
  }
  
  @Override
  public MonitorsMatch toImmutable() {
    return isMutable() ? newMatch(fClient, fSupplier, fGeneralization) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"client\"=" + prettyPrintValue(fClient) + ", ");
    
    result.append("\"supplier\"=" + prettyPrintValue(fSupplier) + ", ");
    
    result.append("\"generalization\"=" + prettyPrintValue(fGeneralization)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClient == null) ? 0 : fClient.hashCode());
    result = prime * result + ((fSupplier == null) ? 0 : fSupplier.hashCode());
    result = prime * result + ((fGeneralization == null) ? 0 : fGeneralization.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MonitorsMatch)) { // this should be infrequent
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
    MonitorsMatch other = (MonitorsMatch) obj;
    if (fClient == null) {if (other.fClient != null) return false;}
    else if (!fClient.equals(other.fClient)) return false;
    if (fSupplier == null) {if (other.fSupplier != null) return false;}
    else if (!fSupplier.equals(other.fSupplier)) return false;
    if (fGeneralization == null) {if (other.fGeneralization != null) return false;}
    else if (!fGeneralization.equals(other.fGeneralization)) return false;
    return true;
  }
  
  @Override
  public MonitorsQuerySpecification specification() {
    try {
    	return MonitorsQuerySpecification.instance();
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
  public static MonitorsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MonitorsMatch newMutableMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return new Mutable(pClient, pSupplier, pGeneralization);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClient the fixed value of pattern parameter client, or null if not bound.
   * @param pSupplier the fixed value of pattern parameter supplier, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MonitorsMatch newMatch(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
    return new Immutable(pClient, pSupplier, pGeneralization);
  }
  
  private static final class Mutable extends MonitorsMatch {
    Mutable(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
      super(pClient, pSupplier, pGeneralization);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MonitorsMatch {
    Immutable(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization) {
      super(pClient, pSupplier, pGeneralization);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
