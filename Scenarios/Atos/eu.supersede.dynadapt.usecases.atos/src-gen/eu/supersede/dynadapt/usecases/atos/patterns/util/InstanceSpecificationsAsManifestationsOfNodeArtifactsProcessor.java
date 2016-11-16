package eu.supersede.dynadapt.usecases.atos.patterns.util;

import eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.atos.patterns.instanceSpecificationsAsManifestationsOfNodeArtifacts pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceSpecificationsAsManifestationsOfNodeArtifactsProcessor implements IMatchProcessor<InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pArtifact the value of pattern parameter artifact in the currently processed match
   * @param pInstance the value of pattern parameter instance in the currently processed match
   * 
   */
  public abstract void process(final Artifact pArtifact, final InstanceSpecification pInstance);
  
  @Override
  public void process(final InstanceSpecificationsAsManifestationsOfNodeArtifactsMatch match) {
    process(match.getArtifact(), match.getInstance());
  }
}
