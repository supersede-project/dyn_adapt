/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test.util;

import eu.supersede.dynadapt.model.query.test.ArtifactManifestationsMatch;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.model.query.test.artifactManifestations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ArtifactManifestationsProcessor implements IMatchProcessor<ArtifactManifestationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pArtifact the value of pattern parameter artifact in the currently processed match
   * @param pManifestationTarget the value of pattern parameter manifestationTarget in the currently processed match
   * 
   */
  public abstract void process(final Artifact pArtifact, final NamedElement pManifestationTarget);
  
  @Override
  public void process(final ArtifactManifestationsMatch match) {
    process(match.getArtifact(), match.getManifestationTarget());
  }
}
