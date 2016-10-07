/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries.util;

import eu.supersede.dynadapt.atos.queries.ConfigurableServiceInstancesMatch;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.atos.queries.configurableServiceInstances pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ConfigurableServiceInstancesProcessor implements IMatchProcessor<ConfigurableServiceInstancesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pService the value of pattern parameter service in the currently processed match
   * @param pInstance the value of pattern parameter instance in the currently processed match
   * 
   */
  public abstract void process(final Artifact pService, final InstanceSpecification pInstance);
  
  @Override
  public void process(final ConfigurableServiceInstancesMatch match) {
    process(match.getService(), match.getInstance());
  }
}
