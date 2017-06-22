/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.ArtifactManifestationsMatcher;
import eu.supersede.dynadapt.usecases.patterns.CMSConfigurationInstancesMatcher;
import eu.supersede.dynadapt.usecases.patterns.CMSInstanceToConfigurationLinkMatcher;
import eu.supersede.dynadapt.usecases.patterns.CMSInstancesMatcher;
import eu.supersede.dynadapt.usecases.patterns.HSKExecutionEnvironmentsMatcher;
import eu.supersede.dynadapt.usecases.patterns.HSKVirtualExecutionEnvironmentsMatcher;
import eu.supersede.dynadapt.usecases.patterns.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.usecases.patterns.InstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.usecases.patterns.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher;
import eu.supersede.dynadapt.usecases.patterns.NodeArtifactsMatcher;
import eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServicesMatcher;
import eu.supersede.dynadapt.usecases.patterns.VirtualExecutionEnvContainingAComponentMatcher;
import eu.supersede.dynadapt.usecases.patterns.util.ArtifactManifestationsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.CMSConfigurationInstancesQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.CMSInstanceToConfigurationLinkQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.CMSInstancesQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.HSKExecutionEnvironmentsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.HSKVirtualExecutionEnvironmentsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.InstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.NodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.VMInstancesContainingHSKServicesQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.VirtualExecutionEnvContainingAComponentQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in atos_query_patterns.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file atos_query_patterns.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.usecases.patterns, the group contains the definition of the following patterns: <ul>
 * <li>nodeArtifacts</li>
 * <li>artifactManifestations</li>
 * <li>instanceSpecificationsAsManifestationsOfNodeArtifacts</li>
 * <li>CMSInstances</li>
 * <li>CMSConfigurationInstances</li>
 * <li>InstanceSpecificationLink</li>
 * <li>InstanceOfInstanceSpecificationLink</li>
 * <li>CMSInstanceToConfigurationLink</li>
 * <li>HSKExecutionEnvironments</li>
 * <li>VMInstancesContainingHSKServices</li>
 * <li>VirtualExecutionEnvContainingAComponent</li>
 * <li>HSKVirtualExecutionEnvironments</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Atos_query_patterns extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Atos_query_patterns instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Atos_query_patterns();
    }
    return INSTANCE;
  }
  
  private static Atos_query_patterns INSTANCE;
  
  private Atos_query_patterns() throws ViatraQueryException {
    querySpecifications.add(NodeArtifactsQuerySpecification.instance());
    querySpecifications.add(ArtifactManifestationsQuerySpecification.instance());
    querySpecifications.add(InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification.instance());
    querySpecifications.add(CMSInstancesQuerySpecification.instance());
    querySpecifications.add(CMSConfigurationInstancesQuerySpecification.instance());
    querySpecifications.add(InstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(CMSInstanceToConfigurationLinkQuerySpecification.instance());
    querySpecifications.add(HSKExecutionEnvironmentsQuerySpecification.instance());
    querySpecifications.add(VMInstancesContainingHSKServicesQuerySpecification.instance());
    querySpecifications.add(VirtualExecutionEnvContainingAComponentQuerySpecification.instance());
    querySpecifications.add(HSKVirtualExecutionEnvironmentsQuerySpecification.instance());
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
  
  public CMSInstancesQuerySpecification getCMSInstances() throws ViatraQueryException {
    return CMSInstancesQuerySpecification.instance();
  }
  
  public CMSInstancesMatcher getCMSInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CMSInstancesMatcher.on(engine);
  }
  
  public CMSConfigurationInstancesQuerySpecification getCMSConfigurationInstances() throws ViatraQueryException {
    return CMSConfigurationInstancesQuerySpecification.instance();
  }
  
  public CMSConfigurationInstancesMatcher getCMSConfigurationInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CMSConfigurationInstancesMatcher.on(engine);
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
  
  public HSKExecutionEnvironmentsQuerySpecification getHSKExecutionEnvironments() throws ViatraQueryException {
    return HSKExecutionEnvironmentsQuerySpecification.instance();
  }
  
  public HSKExecutionEnvironmentsMatcher getHSKExecutionEnvironments(final ViatraQueryEngine engine) throws ViatraQueryException {
    return HSKExecutionEnvironmentsMatcher.on(engine);
  }
  
  public VMInstancesContainingHSKServicesQuerySpecification getVMInstancesContainingHSKServices() throws ViatraQueryException {
    return VMInstancesContainingHSKServicesQuerySpecification.instance();
  }
  
  public VMInstancesContainingHSKServicesMatcher getVMInstancesContainingHSKServices(final ViatraQueryEngine engine) throws ViatraQueryException {
    return VMInstancesContainingHSKServicesMatcher.on(engine);
  }
  
  public VirtualExecutionEnvContainingAComponentQuerySpecification getVirtualExecutionEnvContainingAComponent() throws ViatraQueryException {
    return VirtualExecutionEnvContainingAComponentQuerySpecification.instance();
  }
  
  public VirtualExecutionEnvContainingAComponentMatcher getVirtualExecutionEnvContainingAComponent(final ViatraQueryEngine engine) throws ViatraQueryException {
    return VirtualExecutionEnvContainingAComponentMatcher.on(engine);
  }
  
  public HSKVirtualExecutionEnvironmentsQuerySpecification getHSKVirtualExecutionEnvironments() throws ViatraQueryException {
    return HSKVirtualExecutionEnvironmentsQuerySpecification.instance();
  }
  
  public HSKVirtualExecutionEnvironmentsMatcher getHSKVirtualExecutionEnvironments(final ViatraQueryEngine engine) throws ViatraQueryException {
    return HSKVirtualExecutionEnvironmentsMatcher.on(engine);
  }
}
