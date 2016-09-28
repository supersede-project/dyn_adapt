package eu.supersede.dm.optimizer.gp.mo.fitness;

import eu.supersede.dm.optimizer.gp.mo.chromosome.Chromosome;

public interface FitnessFunction {
	public boolean evaluate (Chromosome chromosome);

	public boolean isMaximizationFunction();

	/**
	 * @param chromosome
	 * @return true if best individual is better than current configuration, false otherwise
	 */
	public boolean isFinished(Chromosome chromosome);
}
