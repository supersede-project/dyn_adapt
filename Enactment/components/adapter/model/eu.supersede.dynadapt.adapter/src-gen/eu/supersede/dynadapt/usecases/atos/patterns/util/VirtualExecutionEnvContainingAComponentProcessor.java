/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns.util;

import eu.supersede.dynadapt.usecases.atos.patterns.VirtualExecutionEnvContainingAComponentMatch;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.atos.patterns.VirtualExecutionEnvContainingAComponent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class VirtualExecutionEnvContainingAComponentProcessor implements IMatchProcessor<VirtualExecutionEnvContainingAComponentMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pExecEnv the value of pattern parameter execEnv in the currently processed match
   * @param pInstanceClassifier the value of pattern parameter instanceClassifier in the currently processed match
   * 
   */
  public abstract void process(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier);
  
  @Override
  public void process(final VirtualExecutionEnvContainingAComponentMatch match) {
    process(match.getExecEnv(), match.getInstanceClassifier());
  }
}
