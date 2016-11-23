package eu.supersede.dynadapt.model.query.test.util;

import eu.supersede.dynadapt.model.query.test.ServicesMatch;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.model.query.test.services pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ServicesProcessor implements IMatchProcessor<ServicesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pService the value of pattern parameter service in the currently processed match
   * 
   */
  public abstract void process(final Artifact pService);
  
  @Override
  public void process(final ServicesMatch match) {
    process(match.getService());
  }
}
