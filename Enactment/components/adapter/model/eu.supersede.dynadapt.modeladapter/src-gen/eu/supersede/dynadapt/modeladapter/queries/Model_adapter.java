package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.InstanceOfInstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.InstanceSpecificationLinkMatcher;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import eu.supersede.dynadapt.modeladapter.queries.util.InstanceSpecificationLinkQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in model_adapter.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file model_adapter.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package eu.supersede.dynadapt.modeladapter.queries, the group contains the definition of the following patterns: <ul>
 * <li>InstanceSpecificationLink</li>
 * <li>InstanceOfInstanceSpecificationLink</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Model_adapter extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Model_adapter instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Model_adapter();
    }
    return INSTANCE;
  }
  
  private static Model_adapter INSTANCE;
  
  private Model_adapter() throws ViatraQueryException {
    querySpecifications.add(InstanceSpecificationLinkQuerySpecification.instance());
    querySpecifications.add(InstanceOfInstanceSpecificationLinkQuerySpecification.instance());
  }
  
  public InstanceSpecificationLinkQuerySpecification getInstanceSpecificationLink() throws ViatraQueryException {
    return InstanceSpecificationLinkQuerySpecification.instance();
  }
  
  public InstanceSpecificationLinkMatcher getInstanceSpecificationLink(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceSpecificationLinkMatcher.on(engine);
  }
  
  public InstanceOfInstanceSpecificationLinkQuerySpecification getInstanceOfInstanceSpecificationLink() throws ViatraQueryException {
    return InstanceOfInstanceSpecificationLinkQuerySpecification.instance();
  }
  
  public InstanceOfInstanceSpecificationLinkMatcher getInstanceOfInstanceSpecificationLink(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceOfInstanceSpecificationLinkMatcher.on(engine);
  }
}
