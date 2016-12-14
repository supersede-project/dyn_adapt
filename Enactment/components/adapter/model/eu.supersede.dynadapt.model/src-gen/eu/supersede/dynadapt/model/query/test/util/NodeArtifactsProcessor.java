/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test.util;

import eu.supersede.dynadapt.model.query.test.NodeArtifactsMatch;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Node;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.model.query.test.nodeArtifacts pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NodeArtifactsProcessor implements IMatchProcessor<NodeArtifactsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pNode the value of pattern parameter node in the currently processed match
   * @param pArtifact the value of pattern parameter artifact in the currently processed match
   * 
   */
  public abstract void process(final Node pNode, final Artifact pArtifact);
  
  @Override
  public void process(final NodeArtifactsMatch match) {
    process(match.getNode(), match.getArtifact());
  }
}
