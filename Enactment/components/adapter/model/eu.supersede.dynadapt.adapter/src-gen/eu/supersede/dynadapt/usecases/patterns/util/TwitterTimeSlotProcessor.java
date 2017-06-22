/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import eu.supersede.dynadapt.usecases.patterns.TwitterTimeSlotMatch;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.patterns.twitterTimeSlot pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TwitterTimeSlotProcessor implements IMatchProcessor<TwitterTimeSlotMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSlot the value of pattern parameter slot in the currently processed match
   * 
   */
  public abstract void process(final Slot pSlot);
  
  @Override
  public void process(final TwitterTimeSlotMatch match) {
    process(match.getSlot());
  }
}
