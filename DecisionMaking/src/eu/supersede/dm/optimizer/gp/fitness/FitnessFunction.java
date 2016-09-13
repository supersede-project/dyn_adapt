package eu.supersede.dm.optimizer.gp.fitness;

import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;

public interface FitnessFunction {
	public boolean evaluate (Chromosome chromosome);

	public boolean isMaximizationFunction();
}
