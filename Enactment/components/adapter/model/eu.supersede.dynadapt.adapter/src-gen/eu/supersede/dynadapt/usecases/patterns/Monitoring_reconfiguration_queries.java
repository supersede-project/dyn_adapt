/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.ClassGeneralizationsMatcher;
import eu.supersede.dynadapt.usecases.patterns.ClassesMatcher;
import eu.supersede.dynadapt.usecases.patterns.InstancesMatcher;
import eu.supersede.dynadapt.usecases.patterns.MonitorsMatcher;
import eu.supersede.dynadapt.usecases.patterns.RealizationsMatcher;
import eu.supersede.dynadapt.usecases.patterns.TwitterTimeSlotMatcher;
import eu.supersede.dynadapt.usecases.patterns.util.ClassGeneralizationsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.ClassesQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.InstancesQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.MonitorsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.RealizationsQuerySpecification;
import eu.supersede.dynadapt.usecases.patterns.util.TwitterTimeSlotQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in monitoring_reconfiguration_queries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file monitoring_reconfiguration_queries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.usecases.patterns, the group contains the definition of the following patterns: <ul>
 * <li>classes</li>
 * <li>classGeneralizations</li>
 * <li>instances</li>
 * <li>realizations</li>
 * <li>monitors</li>
 * <li>twitterTimeSlot</li>
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
    querySpecifications.add(TwitterTimeSlotQuerySpecification.instance());
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
  
  public TwitterTimeSlotQuerySpecification getTwitterTimeSlot() throws ViatraQueryException {
    return TwitterTimeSlotQuerySpecification.instance();
  }
  
  public TwitterTimeSlotMatcher getTwitterTimeSlot(final ViatraQueryEngine engine) throws ViatraQueryException {
    return TwitterTimeSlotMatcher.on(engine);
  }
}
