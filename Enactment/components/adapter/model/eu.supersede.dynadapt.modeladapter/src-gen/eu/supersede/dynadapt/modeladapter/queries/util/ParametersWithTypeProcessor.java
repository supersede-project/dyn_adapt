/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.ParametersWithTypeMatch;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.parametersWithType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ParametersWithTypeProcessor implements IMatchProcessor<ParametersWithTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Parameter pParameter, final Type pType);
  
  @Override
  public void process(final ParametersWithTypeMatch match) {
    process(match.getParameter(), match.getType());
  }
}
