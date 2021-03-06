/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/siemens_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServicesMatch;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServices pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GetMeteorologicalDataServicesProcessor implements IMatchProcessor<GetMeteorologicalDataServicesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAction the value of pattern parameter action in the currently processed match
   * 
   */
  public abstract void process(final CallBehaviorAction pAction);
  
  @Override
  public void process(final GetMeteorologicalDataServicesMatch match) {
    process(match.getAction());
  }
}
