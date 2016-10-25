/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.ArtifactManifestationsMatcher;
import eu.supersede.dynadapt.atos.queries.CMSConfigurationInstancesMatcher;
import eu.supersede.dynadapt.atos.queries.ConfigurableServiceInstancesMatcher;
import eu.supersede.dynadapt.atos.queries.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatcher;
import eu.supersede.dynadapt.atos.queries.MaxThreadValuesInCMSConfigurationsMatcher;
import eu.supersede.dynadapt.atos.queries.NodeArtifactsMatcher;
import eu.supersede.dynadapt.atos.queries.NodesMatcher;
import eu.supersede.dynadapt.atos.queries.ServiceConfigurationsMatcher;
import eu.supersede.dynadapt.atos.queries.ServiceInstancesMatcher;
import eu.supersede.dynadapt.atos.queries.ServicesMatcher;
import eu.supersede.dynadapt.atos.queries.util.ArtifactManifestationsQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.CMSConfigurationInstancesQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.ConfigurableServiceInstancesQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.InstanceSpecificationsAsManifestationsOfNodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.MaxThreadValuesInCMSConfigurationsQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.NodeArtifactsQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.NodesQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.ServiceConfigurationsQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.ServiceInstancesQuerySpecification;
import eu.supersede.dynadapt.atos.queries.util.ServicesQuerySpecification;
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
 * <p> From package eu.supersede.dynadapt.atos.queries, the group contains the definition of the following patterns: <ul>
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
}
