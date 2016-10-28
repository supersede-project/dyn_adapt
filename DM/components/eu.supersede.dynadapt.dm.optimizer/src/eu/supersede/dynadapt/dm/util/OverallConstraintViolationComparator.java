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

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 * This class is adapted from jMetal.
 */
public class OverallConstraintViolationComparator {

	/**
	 * Compares two chromosomes.
	 * 
	 * @param o1
	 *            Object representing the first <code>Chromosome</code>.
	 * @param o2
	 *            Object representing the second <code>Chromosome</code>.
	 * @return -1, or 0, or 1 if o1 is less than, equal, or greater than o2,
	 *         respectively.
	 */
	public int compare(Object o1, Object o2) {
		double overall1, overall2;
		overall1 = ((Chromosome) o1).getOverallConstraintViolation();
		overall2 = ((Chromosome) o2).getOverallConstraintViolation();

		if ((overall1 < 0) && (overall2 < 0)) {
			if (overall1 > overall2) {
				return -1;
			} else if (overall2 > overall1) {
				return 1;
			} else {
				return 0;
			}
		} else if ((overall1 == 0) && (overall2 < 0)) {
			return -1;
		} else if ((overall1 < 0) && (overall2 == 0)) {
			return 1;
		} else {
			return 0;
		}
	} // compare

	/**
	 * Returns true if solutions s1 and/or s2 have an overall constraint
	 * violation < 0
	 */
	public boolean needToCompare(Chromosome s1, Chromosome s2) {
		boolean needToCompare;
		needToCompare = (s1.getOverallConstraintViolation() < 0)
				|| (s2.getOverallConstraintViolation() < 0);

		return needToCompare;
	}
}
