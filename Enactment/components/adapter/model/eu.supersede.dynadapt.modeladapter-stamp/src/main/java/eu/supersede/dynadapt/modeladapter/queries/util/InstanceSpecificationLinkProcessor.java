/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.InstanceSpecificationLinkMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.InstanceSpecificationLink pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceSpecificationLinkProcessor implements IMatchProcessor<InstanceSpecificationLinkMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLink the value of pattern parameter link in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pLink);
  
  @Override
  public void process(final InstanceSpecificationLinkMatch match) {
    process(match.getLink());
  }
}
