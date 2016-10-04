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

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import eu.supersede.monitor.reconfiguration.queries.ClassGeneralizationsMatcher;
import eu.supersede.monitor.reconfiguration.queries.ClassesMatcher;
import eu.supersede.monitor.reconfiguration.queries.InstancesMatcher;
import eu.supersede.monitor.reconfiguration.queries.MonitorsMatcher;
import eu.supersede.monitor.reconfiguration.queries.RealizationsMatcher;
import eu.supersede.monitor.reconfiguration.queries.util.ClassGeneralizationsQuerySpecification;
import eu.supersede.monitor.reconfiguration.queries.util.ClassesQuerySpecification;
import eu.supersede.monitor.reconfiguration.queries.util.InstancesQuerySpecification;
import eu.supersede.monitor.reconfiguration.queries.util.MonitorsQuerySpecification;
import eu.supersede.monitor.reconfiguration.queries.util.RealizationsQuerySpecification;

/**
 * A pattern group formed of all patterns defined in monitoring_reconfiguration_queries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file monitoring_reconfiguration_queries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package queries, the group contains the definition of the following patterns: <ul>
 * <li>classes</li>
 * <li>classGeneralizations</li>
 * <li>instances</li>
 * <li>realizations</li>
 * <li>monitors</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Monitoring_reconfiguration_queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Monitoring_reconfiguration_queries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Monitoring_reconfiguration_queries();
    }
    return INSTANCE;
  }
  
  private static Monitoring_reconfiguration_queries INSTANCE;
  
  private Monitoring_reconfiguration_queries() throws ViatraQueryException {
    querySpecifications.add(ClassesQuerySpecification.instance());
    querySpecifications.add(ClassGeneralizationsQuerySpecification.instance());
    querySpecifications.add(InstancesQuerySpecification.instance());
    querySpecifications.add(RealizationsQuerySpecification.instance());
    querySpecifications.add(MonitorsQuerySpecification.instance());
  }
  
  public ClassesQuerySpecification getClasses() throws ViatraQueryException {
    return ClassesQuerySpecification.instance();
  }
  
  public ClassesMatcher getClasses(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ClassesMatcher.on(engine);
  }
  
  public ClassGeneralizationsQuerySpecification getClassGeneralizations() throws ViatraQueryException {
    return ClassGeneralizationsQuerySpecification.instance();
  }
  
  public ClassGeneralizationsMatcher getClassGeneralizations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ClassGeneralizationsMatcher.on(engine);
  }
  
  public InstancesQuerySpecification getInstances() throws ViatraQueryException {
    return InstancesQuerySpecification.instance();
  }
  
  public InstancesMatcher getInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstancesMatcher.on(engine);
  }
  
  public RealizationsQuerySpecification getRealizations() throws ViatraQueryException {
    return RealizationsQuerySpecification.instance();
  }
  
  public RealizationsMatcher getRealizations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return RealizationsMatcher.on(engine);
  }
  
  public MonitorsQuerySpecification getMonitors() throws ViatraQueryException {
    return MonitorsQuerySpecification.instance();
  }
  
  public MonitorsMatcher getMonitors(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MonitorsMatcher.on(engine);
  }
}
