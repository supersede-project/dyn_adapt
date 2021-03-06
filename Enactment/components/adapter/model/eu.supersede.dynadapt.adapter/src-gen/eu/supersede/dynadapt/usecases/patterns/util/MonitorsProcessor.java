/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import eu.supersede.dynadapt.usecases.patterns.MonitorsMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.patterns.monitors pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MonitorsProcessor implements IMatchProcessor<MonitorsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClient the value of pattern parameter client in the currently processed match
   * @param pSupplier the value of pattern parameter supplier in the currently processed match
   * @param pGeneralization the value of pattern parameter generalization in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pClient, final org.eclipse.uml2.uml.Class pSupplier, final org.eclipse.uml2.uml.Class pGeneralization);
  
  @Override
  public void process(final MonitorsMatch match) {
    process(match.getClient(), match.getSupplier(), match.getGeneralization());
  }
}
