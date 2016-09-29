/**
 * Generated from platform:/resource/eu.supersede.monitor.reconfiguration.poc.uml.query/src/queries/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.monitor.reconfiguration.queries.util;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

import eu.supersede.monitor.reconfiguration.queries.MonitorsMatch;

/**
 * A match processor tailored for the queries.monitors pattern.
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
  public abstract void process(final InstanceSpecification pClient, final NamedElement pSupplier, final org.eclipse.uml2.uml.Class pGeneralization);
  
  @Override
  public void process(final MonitorsMatch match) {
    process(match.getClient(), match.getSupplier(), match.getGeneralization());
  }
}
