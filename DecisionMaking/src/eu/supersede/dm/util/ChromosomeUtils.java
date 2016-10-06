/**
 * 
 */
package eu.supersede.dm.util;

import java.util.List;

import eu.supersede.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 *
 */
public class ChromosomeUtils {
	public static boolean exists (Chromosome chromosome, List<Chromosome> pop){
		for (Chromosome c : pop){
			if (chromosome.toString().equalsIgnoreCase(c.toString())){
				return true;
			}
		}
		return false;
	}
}
