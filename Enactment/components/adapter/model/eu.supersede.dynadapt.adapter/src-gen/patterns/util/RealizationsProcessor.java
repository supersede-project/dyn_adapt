/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns.util;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import patterns.RealizationsMatch;

/**
 * A match processor tailored for the patterns.realizations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RealizationsProcessor implements IMatchProcessor<RealizationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClient the value of pattern parameter client in the currently processed match
   * @param pSupplier the value of pattern parameter supplier in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier);
  
  @Override
  public void process(final RealizationsMatch match) {
    process(match.getClient(), match.getSupplier());
  }
}
