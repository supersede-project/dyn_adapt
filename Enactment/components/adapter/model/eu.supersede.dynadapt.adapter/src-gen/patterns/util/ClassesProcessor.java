/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns.util;

import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import patterns.ClassesMatch;

/**
 * A match processor tailored for the patterns.classes pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClassesProcessor implements IMatchProcessor<ClassesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClass the value of pattern parameter class in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pClass, final String pName);
  
  @Override
  public void process(final ClassesMatch match) {
    process(match.getValueOfClass(), match.getName());
  }
}
