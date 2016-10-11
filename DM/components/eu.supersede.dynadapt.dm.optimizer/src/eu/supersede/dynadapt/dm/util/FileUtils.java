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
			if (feasibleOnly && !(solution.getOverallConstraintViolation() < Parameters.CONSTRAINT_THRESHOLD))
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
