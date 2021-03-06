/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/siemens_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServicesMatcher;
import eu.supersede.dynadapt.usecases.patterns.util.GetMeteorologicalDataServicesQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in siemens_queries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file siemens_queries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.usecases.patterns, the group contains the definition of the following patterns: <ul>
 * <li>GetMeteorologicalDataServices</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Siemens_queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Siemens_queries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Siemens_queries();
    }
    return INSTANCE;
  }
  
  private static Siemens_queries INSTANCE;
  
  private Siemens_queries() throws ViatraQueryException {
    querySpecifications.add(GetMeteorologicalDataServicesQuerySpecification.instance());
  }
  
  public GetMeteorologicalDataServicesQuerySpecification getGetMeteorologicalDataServices() throws ViatraQueryException {
    return GetMeteorologicalDataServicesQuerySpecification.instance();
  }
  
  public GetMeteorologicalDataServicesMatcher getGetMeteorologicalDataServices(final ViatraQueryEngine engine) throws ViatraQueryException {
    return GetMeteorologicalDataServicesMatcher.on(engine);
  }
}
