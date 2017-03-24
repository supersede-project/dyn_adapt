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
package eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome;

import java.util.HashMap;
import java.util.Map;

import eu.fbk.gbtlib.gp.individual.GPAnnotatedIndividualFactory;
import eu.fbk.gbtlib.gp.individual.GPIndividual;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;

public class ChromosomeFactory {
	private Map<Integer, Chromosome> chromosomeCache = new HashMap<Integer, Chromosome>();
	private int duplicates = 0;
	private GPAnnotatedIndividualFactory configurationFactory;
	public ChromosomeFactory(String grammarFile, int depth, double probRecursive) {
		String learnedGrammarFile = "";
		boolean applySmoothing = true;
		setConfigurationFactory(new GPAnnotatedIndividualFactory(grammarFile, learnedGrammarFile, probRecursive, depth, applySmoothing));
	}
	
	public Chromosome getChromosome (){
		Chromosome chromosome = new Chromosome();
		
		GPIndividual configuration = getConfigurationFactory().getNewIndividual();
		
		while (chromosomeCache.containsKey(configuration.toString().hashCode())){
			configuration = getConfigurationFactory().getNewIndividual();
			duplicates++;
			if (duplicates > Parameters.MAX_DUPLICATE_TRIALS){
				break;
			}
		}
		chromosome.setConfiguration(configuration);
		chromosome.setNumberOfObjectives(Parameters.NUM_OBJECTIVES);
		chromosomeCache.put(configuration.toString().hashCode(), chromosome);
		
		return chromosome;
	}

	public int getNumberOfDuplicates(){
		return duplicates;
	}
	
	public GPAnnotatedIndividualFactory getConfigurationFactory() {
		return configurationFactory;
	}

	public void setConfigurationFactory(GPAnnotatedIndividualFactory configurationFactory) {
		this.configurationFactory = configurationFactory;
	}
}
