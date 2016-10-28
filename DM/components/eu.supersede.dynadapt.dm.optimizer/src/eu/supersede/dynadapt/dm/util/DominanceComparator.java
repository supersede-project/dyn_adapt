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
package eu.supersede.dynadapt.dm.util;

import java.util.Comparator;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 * This class is adapted from jMetal.
 */
public class DominanceComparator implements Comparator {
	OverallConstraintViolationComparator violationConstraintComparator_;

	/**
	 * Constructor
	 */
	public DominanceComparator() {
		violationConstraintComparator_ = new OverallConstraintViolationComparator();
	}

	/**
	 * Constructor
	 * 
	 * @param comparator
	 */
	public DominanceComparator(OverallConstraintViolationComparator comparator) {
		violationConstraintComparator_ = comparator;
	}

	/**
	 * Compares two solutions.
	 * 
	 * @param object1
	 *            Object representing the first <code>Solution</code>.
	 * @param object2
	 *            Object representing the second <code>Solution</code>.
	 * @return -1, or 0, or 1 if solution1 dominates solution2, both are
	 *         non-dominated, or solution1 is dominated by solution22,
	 *         respectively.
	 */
	public int compare(Object object1, Object object2) {
		if (object1 == null)
			return 1;
		else if (object2 == null)
			return -1;

		Chromosome solution1 = (Chromosome) object1;
		Chromosome solution2 = (Chromosome) object2;

		int dominate1; // dominate1 indicates if some objective of solution1
						// dominates the same objective in solution2. dominate2
		int dominate2; // is the complementary of dominate1.

		dominate1 = 0;
		dominate2 = 0;

		int flag; // stores the result of the comparison

		// Test to determine whether at least a solution violates some
		// constraint
		if (violationConstraintComparator_.needToCompare(solution1, solution2))
			return violationConstraintComparator_.compare(solution1, solution2);
		

		// Equal number of violated constraints. Applying a dominance Test then
		double value1, value2;
		for (int i = 0; i < solution1.getNumberOfObjectives(); i++) {
			value1 = solution1.getObjective()[i];
			value2 = solution2.getObjective()[i];
			if (value1 < value2) {
				flag = -1;
			} else if (value1 > value2) {
				flag = 1;
			} else {
				flag = 0;
			}

			if (flag == -1) {
				dominate1 = 1;
			}

			if (flag == 1) {
				dominate2 = 1;
			}
		}

		if (dominate1 == dominate2) {
			return 0; // No one dominate the other
		}
		if (dominate1 == 1) {
			return -1; // solution1 dominate
		}
		return 1; // solution2 dominate
	} // compare
}
