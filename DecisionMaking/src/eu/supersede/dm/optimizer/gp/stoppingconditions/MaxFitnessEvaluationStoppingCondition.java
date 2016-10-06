/**
 * 
 */
package eu.supersede.dm.optimizer.gp.stoppingconditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.dm.optimizer.gp.Parameters;

/**
 * @author fitsum
 *
 */
public class MaxFitnessEvaluationStoppingCondition implements StoppingCondition {

	private static final Logger logger = LoggerFactory.getLogger(MaxFitnessEvaluationStoppingCondition.class);


	protected long maxEvaluations = Parameters.SEARCH_BUDGET;

	protected static long currentEvaluation = 0;

	/**
	 * {@inheritDoc}
	 * 
	 * Stop when maximum number of fitness evaluations has been reached
	 */
	@Override
	public boolean isFinished() {
//		logger.info("Current number of fitness_evaluations: " + currentEvaluation);
		return currentEvaluation >= maxEvaluations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Keep track of the number of fitness evaluations
	 */
	@Override
	public void fitnessEvaluation() {
		currentEvaluation++;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * At the end, reset
	 */
	@Override
	public void reset() {
		currentEvaluation = 0;
	}

	/* (non-Javadoc)
	 * @see org.evosuite.ga.StoppingCondition#setLimit(int)
	 */
	/** {@inheritDoc} */
	@Override
	public void setLimit(long limit) {
		maxEvaluations = limit;
	}

	/** {@inheritDoc} */
	@Override
	public long getLimit() {
		return maxEvaluations;
	}

	/* (non-Javadoc)
	 * @see org.evosuite.ga.StoppingCondition#getCurrentValue()
	 */
	/** {@inheritDoc} */
	@Override
	public long getCurrentValue() {
		return currentEvaluation;
	}

	

}