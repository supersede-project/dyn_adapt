/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/health/health.vql
 */
package eu.supersede.dynadapt.usecases.health.util;

import eu.supersede.dynadapt.usecases.health.Authenticated_systemMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.health.authenticated_system pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class Authenticated_systemProcessor implements IMatchProcessor<Authenticated_systemMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClass the value of pattern parameter class in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pClass);
  
  @Override
  public void process(final Authenticated_systemMatch match) {
    process(match.getValueOfClass());
  }
}
