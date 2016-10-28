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

import eu.fbk.gbtlib.gp.individual.GPIndividual;
import eu.fbk.gbtlib.gp.operators.AnnotatedSubtreeCrossover;
import eu.supersede.dynadapt.dm.optimizer.gp.chromosome.Chromosome;

public class SubtreeCrossover extends CrossoverFunction {

	AnnotatedSubtreeCrossover subtreeCrossover = new AnnotatedSubtreeCrossover();
	
	@Override
	public void crossOver(GPIndividual parent1, GPIndividual parent2) throws Exception {
		subtreeCrossover.crossOver(parent1, parent2);

	}

}
