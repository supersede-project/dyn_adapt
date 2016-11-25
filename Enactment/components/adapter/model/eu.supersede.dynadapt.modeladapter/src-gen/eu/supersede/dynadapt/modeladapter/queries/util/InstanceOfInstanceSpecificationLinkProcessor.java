package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLink pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceOfInstanceSpecificationLinkProcessor implements IMatchProcessor<InstanceOfInstanceSpecificationLinkMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLink the value of pattern parameter link in the currently processed match
   * @param pInstance the value of pattern parameter instance in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pLink, final InstanceSpecification pInstance);
  
  @Override
  public void process(final InstanceOfInstanceSpecificationLinkMatch match) {
    process(match.getLink(), match.getInstance());
  }
}
