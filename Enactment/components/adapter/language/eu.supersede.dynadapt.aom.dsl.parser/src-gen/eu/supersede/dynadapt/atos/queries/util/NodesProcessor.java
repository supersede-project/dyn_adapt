/**
 * Generated from platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries.util;

import eu.supersede.dynadapt.atos.queries.NodesMatch;
import org.eclipse.uml2.uml.Node;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.atos.queries.nodes pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NodesProcessor implements IMatchProcessor<NodesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pNode the value of pattern parameter node in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final Node pNode, final String pName);
  
  @Override
  public void process(final NodesMatch match) {
    process(match.getNode(), match.getName());
  }
}
