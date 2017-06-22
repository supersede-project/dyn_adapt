/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.GetManifestationsMatcher;
import eu.supersede.dynadapt.modeladapter.queries.GetReferenceToTypeMatcher;
import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.InstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.ParametersWithTypeMatcher;
import eu.supersede.dynadapt.modeladapter.queries.PropertiesWithTypeMatcher;
import eu.supersede.dynadapt.modeladapter.queries.ReferencesToTypeMatcher;
import eu.supersede.dynadapt.modeladapter.queries.SubClassOfMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.GetManifestationsQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.GetReferenceToTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.ParametersWithTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.PropertiesWithTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.ReferencesToTypeQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.SubClassOfQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in model_adapter.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file model_adapter.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.modeladapter.queries, the group contains the definition of the following patterns: <ul>
 * <li>InstanceSpecificationLink</li>
 * <li>InstanceOfInstanceSpecificationLink</li>
 * <li>subClassOf</li>
 * <li>propertiesWithType</li>
 * <li>parametersWithType</li>
 * <li>referencesToType</li>
 * <li>getReferenceToType</li>
 * <li>getManifestations</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Model_adapter extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Model_adapter instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Model_adapter();
    }
    return INSTANCE;
  }
  
  private static Model_adapter INSTANCE;
  
  private Model_adapter() throws ViatraQueryException {
    querySpecifications.add(InstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(SubClassOfQuerySpecification.instance());
    querySpecifications.add(PropertiesWithTypeQuerySpecification.instance());
    querySpecifications.add(ParametersWithTypeQuerySpecification.instance());
    querySpecifications.add(ReferencesToTypeQuerySpecification.instance());
    querySpecifications.add(GetReferenceToTypeQuerySpecification.instance());
    querySpecifications.add(GetManifestationsQuerySpecification.instance());
  }
  
  public InstanceSpecificationLinkQuerySpecification getInstanceSpecificationLink() throws ViatraQueryException {
    return InstanceSpecificationLinkQuerySpecification.instance();
  }
  
  public InstanceSpecificationLinkMatcher getInstanceSpecificationLink(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceSpecificationLinkMatcher.on(engine);
  }
  
  public InstanceOfInstanceSpecificationLinkQuerySpecification getInstanceOfInstanceSpecificationLink() throws ViatraQueryException {
    return InstanceOfInstanceSpecificationLinkQuerySpecification.instance();
  }
  
  public InstanceOfInstanceSpecificationLinkMatcher getInstanceOfInstanceSpecificationLink(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceOfInstanceSpecificationLinkMatcher.on(engine);
  }
  
  public SubClassOfQuerySpecification getSubClassOf() throws ViatraQueryException {
    return SubClassOfQuerySpecification.instance();
  }
  
  public SubClassOfMatcher getSubClassOf(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SubClassOfMatcher.on(engine);
  }
  
  public PropertiesWithTypeQuerySpecification getPropertiesWithType() throws ViatraQueryException {
    return PropertiesWithTypeQuerySpecification.instance();
  }
  
  public PropertiesWithTypeMatcher getPropertiesWithType(final ViatraQueryEngine engine) throws ViatraQueryException {
    return PropertiesWithTypeMatcher.on(engine);
  }
  
  public ParametersWithTypeQuerySpecification getParametersWithType() throws ViatraQueryException {
    return ParametersWithTypeQuerySpecification.instance();
  }
  
  public ParametersWithTypeMatcher getParametersWithType(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ParametersWithTypeMatcher.on(engine);
  }
  
  public ReferencesToTypeQuerySpecification getReferencesToType() throws ViatraQueryException {
    return ReferencesToTypeQuerySpecification.instance();
  }
  
  public ReferencesToTypeMatcher getReferencesToType(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ReferencesToTypeMatcher.on(engine);
  }
  
  public GetReferenceToTypeQuerySpecification getGetReferenceToType() throws ViatraQueryException {
    return GetReferenceToTypeQuerySpecification.instance();
  }
  
  public GetReferenceToTypeMatcher getGetReferenceToType(final ViatraQueryEngine engine) throws ViatraQueryException {
    return GetReferenceToTypeMatcher.on(engine);
  }
  
  public GetManifestationsQuerySpecification getGetManifestations() throws ViatraQueryException {
    return GetManifestationsQuerySpecification.instance();
  }
  
  public GetManifestationsMatcher getGetManifestations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return GetManifestationsMatcher.on(engine);
  }
}
