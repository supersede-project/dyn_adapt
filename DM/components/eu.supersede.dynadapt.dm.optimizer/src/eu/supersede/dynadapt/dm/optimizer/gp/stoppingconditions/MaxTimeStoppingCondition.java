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
