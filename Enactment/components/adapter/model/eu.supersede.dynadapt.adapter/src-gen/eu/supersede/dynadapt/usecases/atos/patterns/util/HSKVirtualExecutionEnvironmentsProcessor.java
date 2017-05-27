/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns.util;

import eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironmentsMatch;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.atos.patterns.HSKVirtualExecutionEnvironments pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class HSKVirtualExecutionEnvironmentsProcessor implements IMatchProcessor<HSKVirtualExecutionEnvironmentsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pExecEnv the value of pattern parameter execEnv in the currently processed match
   * 
   */
  public abstract void process(final ExecutionEnvironment pExecEnv);
  
  @Override
  public void process(final HSKVirtualExecutionEnvironmentsMatch match) {
    process(match.getExecEnv());
  }
}
