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

import java.util.ArrayList;
import java.util.List;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

;

/**
 * @author fitsum
 * This class is adapted from jMetal.
 */
public class Distance {
	/**
	 * Assigns crowding distances to all solutions in a population of chromosomes .
	 * 
	 * @param solutionSet
	 *            The population
	 * @param nObjs
	 *            Number of objectives.
	 */
	public void crowdingDistanceAssignment(List<Chromosome> solutionSet,
			int nObjs) {
		int size = solutionSet.size();

		if (size == 0)
			return;

		if (size == 1) {
			solutionSet.get(0).setCrowdingDistance(Double.POSITIVE_INFINITY);
			return;
		} // if

		if (size == 2) {
			solutionSet.get(0).setCrowdingDistance(Double.POSITIVE_INFINITY);
			solutionSet.get(1).setCrowdingDistance(Double.POSITIVE_INFINITY);
			return;
		} // if

		// Use a new population to avoid altering the original population
		List<Chromosome> front = new ArrayList<Chromosome>(size);
		for (int i = 0; i < size; i++) {
			front.add(solutionSet.get(i));
		}

		for (int i = 0; i < size; i++)
			front.get(i).setCrowdingDistance(0.0);

		double objetiveMaxn;
		double objetiveMinn;
		double distance;

		for (int i = 0; i < nObjs; i++) {
			// Sort the population by Obj n
			front.sort(new ObjectiveComparator(i));
			objetiveMinn = front.get(0).getObjective()[i];
			objetiveMaxn = front.get(front.size() - 1).getObjective()[i];

			// Set de crowding distance
			front.get(0).setCrowdingDistance(Double.POSITIVE_INFINITY);
			front.get(size - 1).setCrowdingDistance(Double.POSITIVE_INFINITY);

			for (int j = 1; j < size - 1; j++) {
				distance = front.get(j + 1).getObjective()[i]
						- front.get(j - 1).getObjective()[i];
				distance = distance / (objetiveMaxn - objetiveMinn);
				distance += front.get(j).getCrowdingDistance();
				front.get(j).setCrowdingDistance(distance);
			} // for
		} // for
	} // crowdingDistanceAssing
}
