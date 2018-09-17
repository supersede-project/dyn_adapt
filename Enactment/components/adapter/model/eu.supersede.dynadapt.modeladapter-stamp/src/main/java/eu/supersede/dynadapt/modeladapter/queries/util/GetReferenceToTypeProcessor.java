/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.GetReferenceToTypeMatch;
import org.eclipse.uml2.uml.Element;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.getReferenceToType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GetReferenceToTypeProcessor implements IMatchProcessor<GetReferenceToTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pElement the value of pattern parameter element in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Element pElement, final org.eclipse.uml2.uml.Class pType);
  
  @Override
  public void process(final GetReferenceToTypeMatch match) {
    process(match.getElement(), match.getType());
  }
}
