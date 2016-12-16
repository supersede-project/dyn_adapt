/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test.util;

import eu.supersede.dynadapt.model.query.test.CMSInstanceToConfigurationLinkMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.model.query.test.CMSInstanceToConfigurationLink pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CMSInstanceToConfigurationLinkProcessor implements IMatchProcessor<CMSInstanceToConfigurationLinkMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLink the value of pattern parameter link in the currently processed match
   * @param pInstance the value of pattern parameter instance in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pLink, final InstanceSpecification pInstance);
  
  @Override
  public void process(final CMSInstanceToConfigurationLinkMatch match) {
    process(match.getLink(), match.getInstance());
  }
}
