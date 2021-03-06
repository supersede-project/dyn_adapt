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
package eu.supersede.dynadapt.dm.optimizer.gp.mo.operators;

import java.util.List;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dynadapt.dm.util.DominanceComparator;
import eu.supersede.dynadapt.dm.util.PermutationUtility;
import eu.supersede.dynadapt.dm.util.RandomNumber;

/**
 * @author fitsum
 *
 */
public class MultiObjectiveTournamentSelection extends SelectionFunction {

	/**
	 * dominance_ store the <code>Comparator</code> for check dominance_
	 */
	private DominanceComparator dominance_;

	/**
	 * a_ stores a permutation of the solutions in the solutionSet used
	 */
	private int a_[];

	/**
	 * index_ stores the actual index for selection
	 */
	private int index_ = 0;

	/**
	 * 
	 */
	public MultiObjectiveTournamentSelection() {
		dominance_ = new DominanceComparator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.supersede.dynadapt.dm.optimizer.gp.operators.SelectionFunction#getIndex(java
	 * .util.List)
	 */
	@Override
	public int getIndex(List<Chromosome> population) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chromosome select(List<Chromosome> population) {
		Chromosome solution1, solution2;
		solution1 = population.get(RandomNumber.nextInt(0, population.size()));
		solution2 = population.get(RandomNumber.nextInt(0, population.size()));

		if (population.size() >= 2)
			while (solution1 == solution2)
				solution2 = population.get(RandomNumber.nextInt(0,
						population.size()));

		int flag = dominance_.compare(solution1, solution2);
		if (flag == -1)
			return solution1;
		else if (flag == 1)
			return solution2;
		else if (RandomNumber.nextDouble() < 0.5)
			return solution1;
		else
			return solution2;
	}

	public Chromosome _select(List<Chromosome> population) {
		// SolutionSet population = (SolutionSet)object;
		if (index_ == 0) // Create the permutation
		{
			a_ = PermutationUtility.intPermutation(population.size());
		}

		Chromosome solution1, solution2;
		solution1 = population.get(a_[index_]);
		solution2 = population.get(a_[index_ + 1]);

		index_ = (index_ + 2) % population.size();

		int flag = dominance_.compare(solution1, solution2);
		if (flag == -1)
			return solution1;
		else if (flag == 1)
			return solution2;
		else if (solution1.getCrowdingDistance() > solution2
				.getCrowdingDistance())
			return solution1;
		else if (solution2.getCrowdingDistance() > solution1
				.getCrowdingDistance())
			return solution2;
		else if (RandomNumber.nextDouble() < 0.5)
			return solution1;
		else
			return solution2;
	} // execute

}
