/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries.util;

import eu.supersede.dynadapt.modeladapter.queries.PropertiesWithTypeMatch;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the eu.supersede.dynadapt.modeladapter.queries.propertiesWithType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PropertiesWithTypeProcessor implements IMatchProcessor<PropertiesWithTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pProperty the value of pattern parameter property in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Property pProperty, final Type pType);
  
  @Override
  public void process(final PropertiesWithTypeMatch match) {
    process(match.getProperty(), match.getType());
  }
}
