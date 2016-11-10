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
package eu.supersede.dynadapt.dm.optimizer.gp.operators;

import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;

public class ReplacementFunction {
	protected boolean maximize = false;

	public ReplacementFunction(boolean maximize) {
		this.maximize = maximize;
	}

	public boolean isBetter(Chromosome chromosome1, Chromosome chromosome2) {
		if (maximize) {
			return chromosome1.compareTo(chromosome2) > 0;
		} else {
			return chromosome1.compareTo(chromosome2) < 0;
		}
	}

	public boolean isBetterOrEqual(Chromosome chromosome1,
			Chromosome chromosome2) {
		if (maximize) {
			return chromosome1.compareTo(chromosome2) >= 0;
		} else {
			return chromosome1.compareTo(chromosome2) <= 0;
		}
	}

	protected Chromosome getBest(Chromosome chromosome1, Chromosome chromosome2) {
		if (isBetter(chromosome1, chromosome2))
			return chromosome1;
		else
			return chromosome2;
	}

	public boolean keepOffspring(Chromosome parent1, Chromosome parent2,
			Chromosome offspring1, Chromosome offspring2) {
		if (maximize) {
			return compareBestOffspringToBestParent(parent1, parent2,
					offspring1, offspring2) >= 0;
		} else {
			return compareBestOffspringToBestParent(parent1, parent2,
					offspring1, offspring2) <= 0;
		}
	}

	public int compareBestOffspringToBestParent(Chromosome parent1,
			Chromosome parent2, Chromosome offspring1, Chromosome offspring2) {

		Chromosome bestOffspring = getBest(offspring1, offspring2);
		Chromosome bestParent = getBest(parent1, parent2);

		return bestOffspring.compareTo(bestParent);
	}

	public boolean keepOffspring(Chromosome parent, Chromosome offspring) {
		return isBetterOrEqual(offspring, parent);
	}
}
