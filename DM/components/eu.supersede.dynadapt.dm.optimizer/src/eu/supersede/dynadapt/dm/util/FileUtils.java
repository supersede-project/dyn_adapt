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

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;
import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 *
 */
public class FileUtils {
	public static void writeToFile (String content, String path){
		try {
			/* Open the file */
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(content);
			bw.newLine();
			/* Close the file */
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param solution
	 * @param sol
	 * @return
	 */
	private static String buildLine(Chromosome solution, int sol) {
		double cost = solution.getObjective()[0];
		double value = -1d * solution.getObjective()[1]; // invert minimization to maximization 
		String msg = cost + "," + value + "," + solution.getOverallConstraintViolation() + ",c" + (sol) + "\n";
		return msg;
	}
	
	public static void printObjectivesToFile(List<Chromosome> solutions, String path, boolean feasibleOnly) {
		StringBuffer bw = new StringBuffer();
		bw.append("cost,value,constr,config\n");
		StringBuffer configs = new StringBuffer();
		configs.append("config_id,configuration\n");
		int sol = 1;
		for (Chromosome solution : solutions) {
			if (feasibleOnly && !(solution.getOverallConstraintViolation() < Parameters.CONSTRAINT_THRESHOLD_FEEDBACK))
				continue;
			
			String msg = buildLine (solution, sol);
			bw.append(msg);
			String config = "c" + sol + "," + solution.toString() + "\n"; 
			configs.append(config);
			sol++;
		}
		writeToFile(bw.toString(), path + ".csv");
		writeToFile(configs.toString(), path + ".configs");
	} // printObjectivesToFile
}
