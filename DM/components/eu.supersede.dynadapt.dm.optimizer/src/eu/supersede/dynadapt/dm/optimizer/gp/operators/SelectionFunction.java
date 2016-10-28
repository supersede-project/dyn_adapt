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

import java.util.ArrayList;
import java.util.List;

import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;

public abstract class SelectionFunction {
	protected boolean maximize = true;

	/**
	 * Return index of next offspring
	 * 
	 * @param population
	 *            a {@link java.util.List} object.
	 * @return a int.
	 */
	public abstract int getIndex(List<Chromosome> population);

	/**
	 * Return two parents
	 * 
	 * @param population
	 *            a {@link java.util.List} object.
	 * @return a {@link eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.optimizer.gp.Chromosome} object.
	 */
	public Chromosome select(List<Chromosome> population) {
		return select(population, 1).get(0);
	}

	/**
	 * Return n parents
	 * 
	 * @param population
	 *            a {@link java.util.List} object.
	 * @param number
	 *            n
	 * @return a {@link java.util.List} object.
	 */
	public List<Chromosome> select(List<Chromosome> population, int number) {
		List<Chromosome> offspring = new ArrayList<Chromosome>();
		for (int i = 0; i < number; i++) {
			offspring.add(population.get(getIndex(population)));
		}
		return offspring;
	}

	/**
	 * Are we maximizing or minimizing fitness?
	 * 
	 * @param max
	 *            a boolean.
	 */
	public void setMaximize(boolean max) {
		maximize = max;
	}

	/**
	 * <p>
	 * isMaximize
	 * </p>
	 * 
	 * @return true is we have to maximize
	 */
	public boolean isMaximize() {
		return maximize;
	}
}
