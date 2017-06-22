/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.GetManifestationsMatch;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.getManifestations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GetManifestationsProcessor implements IMatchProcessor<GetManifestationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pManifestation the value of pattern parameter manifestation in the currently processed match
   * @param pClient the value of pattern parameter client in the currently processed match
   * @param pSupplier the value of pattern parameter supplier in the currently processed match
   * 
   */
  public abstract void process(final Manifestation pManifestation, final ExecutionEnvironment pClient, final InstanceSpecification pSupplier);
  
  @Override
  public void process(final GetManifestationsMatch match) {
    process(match.getManifestation(), match.getClient(), match.getSupplier());
  }
}
