package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.ArtifactManifestationsMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.CMSConfigurationInstancesMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.CMSInstancesMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.NodeArtifactsMatcher;
import eu.supersede.dynadapt.usecases.atos.patterns.util.ArtifactManifestationsQuerySpecification;
import eu.supersede.dynadapt.usecases.atos.patterns.util.CMSConfigurationInstancesQuerySpecification;
import eu.supersede.dynadapt.usecases.atos.patterns.util.CMSInstancesQuerySpecification;
import eu.supersede.dynadapt.usecases.atos.patterns.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.usecases.atos.patterns.util.NodeArtifactsQuerySpecification;
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
 * <p> From package eu.supersede.dynadapt.usecases.atos.patterns, the group contains the definition of the following patterns: <ul>
 * <li>nodeArtifacts</li>
 * <li>artifactManifestations</li>
 * <li>instanceSpecificationsAsManifestationsOfNodeArtifacts</li>
 * <li>CMSInstances</li>
 * <li>CMSConfigurationInstances</li>
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
}
