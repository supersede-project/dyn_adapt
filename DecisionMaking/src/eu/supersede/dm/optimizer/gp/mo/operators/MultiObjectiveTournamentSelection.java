/**
 * 
 */
package eu.supersede.dm.optimizer.gp.mo.operators;

import java.util.List;

import eu.supersede.dm.optimizer.gp.mo.chromosome.Chromosome;
import eu.supersede.dm.util.DominanceComparator;
import eu.supersede.dm.util.RandomNumber;

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
	 * eu.supersede.dm.optimizer.gp.operators.SelectionFunction#getIndex(java
	 * .util.List)
	 */
	@Override
	public int getIndex(List<Chromosome> population) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chromosome select(List<Chromosome> population) {
		// SolutionSet population = (SolutionSet)object;
		if (index_ == 0) // Create the permutation
		{
			a_ = (new jmetal.util.PermutationUtility())
					.intPermutation(population.size());
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
