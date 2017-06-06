/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns.util;

import org.eclipse.uml2.uml.Element;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import patterns.ClassGeneralizationsMatch;

/**
 * A match processor tailored for the patterns.classGeneralizations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClassGeneralizationsProcessor implements IMatchProcessor<ClassGeneralizationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClass the value of pattern parameter class in the currently processed match
   * @param pGeneralizationTarget the value of pattern parameter generalizationTarget in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget);
  
  @Override
  public void process(final ClassGeneralizationsMatch match) {
    process(match.getValueOfClass(), match.getGeneralizationTarget());
  }
}
