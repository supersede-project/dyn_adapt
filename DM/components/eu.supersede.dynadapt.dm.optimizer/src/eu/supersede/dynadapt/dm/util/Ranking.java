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
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 * This class is adapted from jMetal.
 */
public class Ranking {
	/**
	 * The population to rank
	 */
	private List<Chromosome> solutionSet_;

	/**
	 * An array containing all the fronts found during the search
	 */
	private List<List<Chromosome>> ranking_;

	/**
	 * stores a <code>Comparator</code> for dominance checking
	 */
	private static final Comparator dominance_ = new DominanceComparator();

	/**
	 * stores a <code>Comparator</code> for Overall Constraint Violation
	 * Comparator checking
	 */
	private static final OverallConstraintViolationComparator constraint_ = new OverallConstraintViolationComparator();

	/**
	 * Constructor.
	 * 
	 * @param solutionSet
	 *            The population of <code>Chromosome</code> to be ranked.
	 */
	public Ranking(List<Chromosome> solutionSet) {
		solutionSet_ = solutionSet;

		// dominateMe[i] contains the number of solutions dominating i
		int[] dominateMe = new int[solutionSet_.size()];

		// iDominate[k] contains the list of solutions dominated by k
		List<Integer>[] iDominate = new List[solutionSet_.size()];

		// front[i] contains the list of individuals belonging to the front i
		List<Integer>[] front = new List[solutionSet_.size() + 1];

		// flagDominate is an auxiliar encodings.variable
		int flagDominate;

		// Initialize the fronts
		for (int i = 0; i < front.length; i++)
			front[i] = new LinkedList<Integer>();

		// -> Fast non dominated sorting algorithm
		// Contribution of Guillaume Jacquenot
		for (int p = 0; p < solutionSet_.size(); p++) {
			// Initialize the list of individuals that i dominate and the number
			// of individuals that dominate me
			iDominate[p] = new LinkedList<Integer>();
			dominateMe[p] = 0;
		}
		for (int p = 0; p < (solutionSet_.size() - 1); p++) {
			// For all q individuals , calculate if p dominates q or vice versa
			for (int q = p + 1; q < solutionSet_.size(); q++) {
				flagDominate = constraint_.compare(solutionSet.get(p),
						solutionSet.get(q));
				if (flagDominate == 0) {
					flagDominate = dominance_.compare(solutionSet.get(p),
							solutionSet.get(q));
				}
				if (flagDominate == -1) {
					iDominate[p].add(q);
					dominateMe[q]++;
				} else if (flagDominate == 1) {
					iDominate[q].add(p);
					dominateMe[p]++;
				}
			}
			// If nobody dominates p, p belongs to the first front
		}
		for (int p = 0; p < solutionSet_.size(); p++) {
			if (dominateMe[p] == 0) {
				front[0].add(p);
				solutionSet.get(p).setRank(0);
			}
		}

		// Obtain the rest of fronts
		int i = 0;
		Iterator<Integer> it1, it2; // Iterators
		while (front[i].size() != 0) {
			i++;
			it1 = front[i - 1].iterator();
			while (it1.hasNext()) {
				it2 = iDominate[it1.next()].iterator();
				while (it2.hasNext()) {
					int index = it2.next();
					dominateMe[index]--;
					if (dominateMe[index] == 0) {
						front[i].add(index);
						solutionSet_.get(index).setRank(i);
					}
				}
			}
		}
		// <-

		ranking_ = new ArrayList<List<Chromosome>>();
		// 0,1,2,....,i-1 are front, then i fronts
		for (int j = 0; j < i; j++) {
			// ranking_[j] = new SolutionSet(front[j].size());
			List<Chromosome> frnt = new ArrayList<Chromosome>();
			it1 = front[j].iterator();
			while (it1.hasNext()) {
				frnt.add(solutionSet.get(it1.next()));
			}
			ranking_.add(frnt);
		}

	} // Ranking

	/**
	 * Returns a population containing the solutions of a given rank.
	 * 
	 * @param rank
	 *            The rank
	 * @return Object representing the population of <code>Chromosome</code>s.
	 */
	public List<Chromosome> getSubfront(int rank) {
		return ranking_.get(rank);
	} // getSubFront

	/**
	 * Returns the total number of subFronts founds.
	 */
	public int getNumberOfSubfronts() {
		return ranking_.size();
	} // getNumberOfSubfronts
}
