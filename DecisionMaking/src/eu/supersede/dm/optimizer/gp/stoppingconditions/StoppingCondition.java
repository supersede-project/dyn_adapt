/**
 * 
 */
package eu.supersede.dm.optimizer.gp.stoppingconditions;

/**
 * @author fitsum
 *
 */
public interface StoppingCondition {

	/**
	 * get notification about a fitness evaluation
	 */
	public abstract void fitnessEvaluation();
	
    /**
     * How much of the budget have we used up
     *
     * @return a long.
     */
    public abstract long getCurrentValue();

    /**
     * Get upper limit of resources
     *
     * Mainly used for toString()
     *
     * @return limit
     */
    public abstract long getLimit();

    /**
     * <p>isFinished</p>
     *
     * @return a boolean.
     */
    boolean isFinished();

    /**
     * Reset everything
     */
    void reset();

    /**
     * Set new upper limit of resources
     *
     * @param limit a long.
     */
    void setLimit(long limit);
}

