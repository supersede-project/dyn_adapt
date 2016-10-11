/**
 * 
 */
package eu.supersede.dynadapt.dm.util;

import eu.supersede.dynadapt.dm.optimizer.gp.mo.chromosome.Chromosome;

/**
 * @author fitsum
 *
 */
public class OverallConstraintViolationComparator {

	/**
	 * Compares two solutions.
	 * 
	 * @param o1
	 *            Object representing the first <code>Solution</code>.
	 * @param o2
	 *            Object representing the second <code>Solution</code>.
	 * @return -1, or 0, or 1 if o1 is less than, equal, or greater than o2,
	 *         respectively.
	 */
	public int compare(Object o1, Object o2) {
		double overall1, overall2;
		overall1 = ((Chromosome) o1).getOverallConstraintViolation();
		overall2 = ((Chromosome) o2).getOverallConstraintViolation();

		if ((overall1 < 0) && (overall2 < 0)) {
			if (overall1 > overall2) {
				return -1;
			} else if (overall2 > overall1) {
				return 1;
			} else {
				return 0;
			}
		} else if ((overall1 == 0) && (overall2 < 0)) {
			return -1;
		} else if ((overall1 < 0) && (overall2 == 0)) {
			return 1;
		} else {
			return 0;
		}
	} // compare

	/**
	 * Returns true if solutions s1 and/or s2 have an overall constraint
	 * violation < 0
	 */
	public boolean needToCompare(Chromosome s1, Chromosome s2) {
		boolean needToCompare;
		needToCompare = (s1.getOverallConstraintViolation() < 0)
				|| (s2.getOverallConstraintViolation() < 0);

		return needToCompare;
	}
}
