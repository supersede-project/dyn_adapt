/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import eu.supersede.dynadapt.usecases.patterns.CMSConfigurationInstancesMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.patterns.CMSConfigurationInstances pattern.
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
