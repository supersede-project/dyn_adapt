/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns.util;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import patterns.InstancesMatch;

/**
 * A match processor tailored for the patterns.instances pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InstancesProcessor implements IMatchProcessor<InstancesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pInstance the value of pattern parameter instance in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pInstance, final String pName);
  
  @Override
  public void process(final InstancesMatch match) {
    process(match.getInstance(), match.getName());
  }
}
