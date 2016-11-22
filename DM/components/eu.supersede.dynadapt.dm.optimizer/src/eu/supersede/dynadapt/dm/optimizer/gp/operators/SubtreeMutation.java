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

import eu.fbk.gbtlib.gp.individual.GPAnnotatedIndividualFactory;
import eu.fbk.gbtlib.gp.individual.GPIndividual;
import eu.fbk.gbtlib.gp.operators.AnnotatedSubtreeMutation;

public class SubtreeMutation extends MutationFunction {

	AnnotatedSubtreeMutation subtreeMutation;
	
	public SubtreeMutation(GPAnnotatedIndividualFactory chromosomeFactory) {
		subtreeMutation = new AnnotatedSubtreeMutation(chromosomeFactory);
	}
	
	@Override
	public void mutate(GPIndividual offspring) throws Exception {
		subtreeMutation.mutate(offspring);

	}

}
