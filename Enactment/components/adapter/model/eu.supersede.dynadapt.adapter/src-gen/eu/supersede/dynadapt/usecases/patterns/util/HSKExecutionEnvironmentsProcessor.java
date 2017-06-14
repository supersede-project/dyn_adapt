/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns.util;

import eu.supersede.dynadapt.usecases.patterns.HSKExecutionEnvironmentsMatch;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.usecases.patterns.HSKExecutionEnvironments pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class HSKExecutionEnvironmentsProcessor implements IMatchProcessor<HSKExecutionEnvironmentsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pExecEnv the value of pattern parameter execEnv in the currently processed match
   * 
   */
  public abstract void process(final ExecutionEnvironment pExecEnv);
  
  @Override
  public void process(final HSKExecutionEnvironmentsMatch match) {
    process(match.getExecEnv());
  }
}
