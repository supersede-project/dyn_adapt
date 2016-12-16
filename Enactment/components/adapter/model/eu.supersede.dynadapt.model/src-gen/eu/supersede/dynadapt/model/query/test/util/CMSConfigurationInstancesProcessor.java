/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test.util;

import eu.supersede.dynadapt.model.query.test.CMSConfigurationInstancesMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.model.query.test.CMSConfigurationInstances pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CMSConfigurationInstancesProcessor implements IMatchProcessor<CMSConfigurationInstancesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pConfiguration the value of pattern parameter configuration in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pConfiguration);
  
  @Override
  public void process(final CMSConfigurationInstancesMatch match) {
    process(match.getConfiguration());
  }
}
