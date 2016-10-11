/**
 * 
 */
package eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;

/**
 * @author fitsum
 *
 */
public class MaxTimeStoppingCondition implements StoppingCondition {
	
	private static final Logger logger = LoggerFactory.getLogger(MaxTimeStoppingCondition.class);

	protected long maxSeconds = Parameters.SEARCH_BUDGET;
	protected static long currentEvaluation = 0;
	protected long startTime;
	
	/**
	 * 
	 */
	public MaxTimeStoppingCondition() {
		startTime = System.currentTimeMillis();
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition#fitnessEvaluation()
	 */
	@Override
	public void fitnessEvaluation() {
		// not used by the MaxTime stopping condition
		currentEvaluation++;
	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition#getCurrentValue()
	 */
	@Override
	public long getCurrentValue() {
		long currentTime = System.currentTimeMillis();
		long currentValue = (currentTime - startTime) / 1000;
//		logger.info("Current value of time: " + currentEvaluation);
		return currentValue;
	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition#getLimit()
	 */
	@Override
	public long getLimit() {
		return maxSeconds;
	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition#isFinished()
	 */
	@Override
	public boolean isFinished() {
		return getCurrentValue() > maxSeconds;
	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition#reset()
	 */
	@Override
	public void reset() {
		startTime = System.currentTimeMillis();

	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.dm.optimizer.gp.stoppingconditions.StoppingCondition#setLimit(long)
	 */
	@Override
	public void setLimit(long limit) {
		maxSeconds = limit;

	}

}
