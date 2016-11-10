/*******************************************************************************
 * Copyright (c) 2016 FBK
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Fitsum Kifetew (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
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