/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.ArtifactManifestationsMatcher;
import eu.supersede.dynadapt.model.query.test.CMSConfigurationInstancesMatcher;
import eu.supersede.dynadapt.model.query.test.CMSInstanceToConfigurationLinkMatcher;
import eu.supersede.dynadapt.model.query.test.ConfigurableServiceInstancesMatcher;
import eu.supersede.dynadapt.model.query.test.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.model.query.test.InstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.model.query.test.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher;
import eu.supersede.dynadapt.model.query.test.MaxThreadValuesInCMSConfigurationsMatcher;
import eu.supersede.dynadapt.model.query.test.NodeArtifactsMatcher;
import eu.supersede.dynadapt.model.query.test.NodesMatcher;
import eu.supersede.dynadapt.model.query.test.ServiceConfigurationsMatcher;
import eu.supersede.dynadapt.model.query.test.ServiceInstancesMatcher;
import eu.supersede.dynadapt.model.query.test.ServicesMatcher;
import eu.supersede.dynadapt.model.query.test.util.ArtifactManifestationsQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.CMSConfigurationInstancesQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.CMSInstanceToConfigurationLinkQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.ConfigurableServiceInstancesQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.InstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.MaxThreadValuesInCMSConfigurationsQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.NodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.NodesQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.ServiceConfigurationsQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.ServiceInstancesQuerySpecification;
import eu.supersede.dynadapt.model.query.test.util.ServicesQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in atos_queries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file atos_queries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.model.query.test, the group contains the definition of the following patterns: <ul>
 * <li>nodes</li>
 * <li>nodeArtifacts</li>
 * <li>artifactManifestations</li>
 * <li>instanceSpecificationsAsManifestationsOfNodeArtifacts</li>
 * <li>services</li>
 * <li>serviceInstances</li>
 * <li>configurableServiceInstances</li>
 * <li>serviceConfigurations</li>
 * <li>CMSConfigurationInstances</li>
 * <li>maxThreadValuesInCMSConfigurations</li>
 * <li>InstanceSpecificationLink</li>
 * <li>InstanceOfInstanceSpecificationLink</li>
 * <li>CMSInstanceToConfigurationLink</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Atos_queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Atos_queries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Atos_queries();
    }
    return INSTANCE;
  }
  
  private static Atos_queries INSTANCE;
  
  private Atos_queries() throws ViatraQueryException {
    querySpecifications.add(NodesQuerySpecification.instance());
    querySpecifications.add(NodeArtifactsQuerySpecification.instance());
    querySpecifications.add(ArtifactManifestationsQuerySpecification.instance());
    querySpecifications.add(InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.instance());
    querySpecifications.add(ServicesQuerySpecification.instance());
    querySpecifications.add(ServiceInstancesQuerySpecification.instance());
    querySpecifications.add(ConfigurableServiceInstancesQuerySpecification.instance());
    querySpecifications.add(ServiceConfigurationsQuerySpecification.instance());
    querySpecifications.add(CMSConfigurationInstancesQuerySpecification.instance());
    querySpecifications.add(MaxThreadValuesInCMSConfigurationsQuerySpecification.instance());
    querySpecifications.add(InstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(CMSInstanceToConfigurationLinkQuerySpecification.instance());
  }
  
  public NodesQuerySpecification getNodes() throws ViatraQueryException {
    return NodesQuerySpecification.instance();
  }
  
  public NodesMatcher getNodes(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NodesMatcher.on(engine);
  }
  
  public NodeArtifactsQuerySpecification getNodeArtifacts() throws ViatraQueryException {
    return NodeArtifactsQuerySpecification.instance();
  }
  
  public NodeArtifactsMatcher getNodeArtifacts(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NodeArtifactsMatcher.on(engine);
  }
  
  public ArtifactManifestationsQuerySpecification getArtifactManifestations() throws ViatraQueryException {
    return ArtifactManifestationsQuerySpecification.instance();
  }
  
  public ArtifactManifestationsMatcher getArtifactManifestations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ArtifactManifestationsMatcher.on(engine);
  }
  
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification getInstanceSpecificationsAsManifestationsOfNodeArtifacts() throws ViatraQueryException {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.instance();
  }
  
  public InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher getInstanceSpecificationsAsManifestationsOfNodeArtifacts(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher.on(engine);
  }
  
  public ServicesQuerySpecification getServices() throws ViatraQueryException {
    return ServicesQuerySpecification.instance();
  }
  
  public ServicesMatcher getServices(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ServicesMatcher.on(engine);
  }
  
  public ServiceInstancesQuerySpecification getServiceInstances() throws ViatraQueryException {
    return ServiceInstancesQuerySpecification.instance();
  }
  
  public ServiceInstancesMatcher getServiceInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ServiceInstancesMatcher.on(engine);
  }
  
  public ConfigurableServiceInstancesQuerySpecification getConfigurableServiceInstances() throws ViatraQueryException {
    return ConfigurableServiceInstancesQuerySpecification.instance();
  }
  
  public ConfigurableServiceInstancesMatcher getConfigurableServiceInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ConfigurableServiceInstancesMatcher.on(engine);
  }
  
  public ServiceConfigurationsQuerySpecification getServiceConfigurations() throws ViatraQueryException {
    return ServiceConfigurationsQuerySpecification.instance();
  }
  
  public ServiceConfigurationsMatcher getServiceConfigurations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ServiceConfigurationsMatcher.on(engine);
  }
  
  public CMSConfigurationInstancesQuerySpecification getCMSConfigurationInstances() throws ViatraQueryException {
    return CMSConfigurationInstancesQuerySpecification.instance();
  }
  
  public CMSConfigurationInstancesMatcher getCMSConfigurationInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CMSConfigurationInstancesMatcher.on(engine);
  }
  
  public MaxThreadValuesInCMSConfigurationsQuerySpecification getMaxThreadValuesInCMSConfigurations() throws ViatraQueryException {
    return MaxThreadValuesInCMSConfigurationsQuerySpecification.instance();
  }
  
  public MaxThreadValuesInCMSConfigurationsMatcher getMaxThreadValuesInCMSConfigurations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MaxThreadValuesInCMSConfigurationsMatcher.on(engine);
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
  
  public CMSInstanceToConfigurationLinkQuerySpecification getCMSInstanceToConfigurationLink() throws ViatraQueryException {
    return CMSInstanceToConfigurationLinkQuerySpecification.instance();
  }
  
  public CMSInstanceToConfigurationLinkMatcher getCMSInstanceToConfigurationLink(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CMSInstanceToConfigurationLinkMatcher.on(engine);
  }
}
