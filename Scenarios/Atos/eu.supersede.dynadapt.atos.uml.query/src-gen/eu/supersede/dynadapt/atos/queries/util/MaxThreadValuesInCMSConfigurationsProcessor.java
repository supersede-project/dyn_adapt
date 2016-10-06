/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries.util;

import eu.supersede.dynadapt.atos.queries.MaxThreadValuesInCMSConfigurationsMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.atos.queries.maxThreadValuesInCMSConfigurations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MaxThreadValuesInCMSConfigurationsProcessor implements IMatchProcessor<MaxThreadValuesInCMSConfigurationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pConfiguration the value of pattern parameter configuration in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * @param pValue the value of pattern parameter value in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pConfiguration, final String pName, final Integer pValue);
  
  @Override
  public void process(final MaxThreadValuesInCMSConfigurationsMatch match) {
    process(match.getConfiguration(), match.getName(), match.getValue());
  }
}
