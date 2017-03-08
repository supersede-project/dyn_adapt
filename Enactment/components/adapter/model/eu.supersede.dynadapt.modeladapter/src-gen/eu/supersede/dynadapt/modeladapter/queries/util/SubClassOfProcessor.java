/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.SubClassOfMatch;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.subClassOf pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SubClassOfProcessor implements IMatchProcessor<SubClassOfMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSubclass the value of pattern parameter subclass in the currently processed match
   * @param pSuperclass the value of pattern parameter superclass in the currently processed match
   * 
   */
  public abstract void process(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass);
  
  @Override
  public void process(final SubClassOfMatch match) {
    process(match.getSubclass(), match.getSuperclass());
  }
}
