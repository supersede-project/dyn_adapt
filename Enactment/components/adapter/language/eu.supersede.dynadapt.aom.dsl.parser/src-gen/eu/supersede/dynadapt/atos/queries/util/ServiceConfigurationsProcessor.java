/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries.util;

import eu.supersede.dynadapt.atos.queries.ServiceConfigurationsMatch;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.atos.queries.serviceConfigurations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ServiceConfigurationsProcessor implements IMatchProcessor<ServiceConfigurationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pService the value of pattern parameter service in the currently processed match
   * @param pConfiguration the value of pattern parameter configuration in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pService, final InstanceSpecification pConfiguration);
  
  @Override
  public void process(final ServiceConfigurationsMatch match) {
    process(match.getService(), match.getConfiguration());
  }
}
