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
//  RankComparator.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
//
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package eu.supersede.dynadapt.dm.util;

import java.util.Comparator;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * This class implements a <code>Comparator</code> (a method for comparing
 * <code>Chromosome</code> objects) based on the rank of the solutions.
 * This class is adapted from jMetal.
 */
public class RankComparator implements Comparator {
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

		if (o1 == null)
			return 1;
		else if (o2 == null)
			return -1;

		Chromosome solution1 = (Chromosome) o1;
		Chromosome solution2 = (Chromosome) o2;
		if (solution1.getRank() < solution2.getRank()) {
			return -1;
		}

		if (solution1.getRank() > solution2.getRank()) {
			return 1;
		}

		return 0;
	} // compare
} // RankComparator
