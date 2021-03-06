/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServicesMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServices pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class VMInstancesContainingHSKServicesProcessor implements IMatchProcessor<VMInstancesContainingHSKServicesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pInstance the value of pattern parameter instance in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pInstance);
  
  @Override
  public void process(final VMInstancesContainingHSKServicesMatch match) {
    process(match.getInstance());
  }
}
