/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/health/health.vql
 */
package eu.supersede.dynadapt.usecases.health;

import eu.supersede.dynadapt.usecases.health.Authenticated_systemMatcher;
import eu.supersede.dynadapt.usecases.health.Authenticated_userMatcher;
import eu.supersede.dynadapt.usecases.health.util.Authenticated_systemQuerySpecification;
import eu.supersede.dynadapt.usecases.health.util.Authenticated_userQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in health.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file health.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.usecases.health, the group contains the definition of the following patterns: <ul>
 * <li>authenticated_system</li>
 * <li>authenticated_user</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Health extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Health instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Health();
    }
    return INSTANCE;
  }
  
  private static Health INSTANCE;
  
  private Health() throws ViatraQueryException {
    querySpecifications.add(Authenticated_systemQuerySpecification.instance());
    querySpecifications.add(Authenticated_userQuerySpecification.instance());
  }
  
  public Authenticated_systemQuerySpecification getAuthenticated_system() throws ViatraQueryException {
    return Authenticated_systemQuerySpecification.instance();
  }
  
  public Authenticated_systemMatcher getAuthenticated_system(final ViatraQueryEngine engine) throws ViatraQueryException {
    return Authenticated_systemMatcher.on(engine);
  }
  
  public Authenticated_userQuerySpecification getAuthenticated_user() throws ViatraQueryException {
    return Authenticated_userQuerySpecification.instance();
  }
  
  public Authenticated_userMatcher getAuthenticated_user(final ViatraQueryEngine engine) throws ViatraQueryException {
    return Authenticated_userMatcher.on(engine);
  }
}
