package eu.supersede.dm.optimizer.gp.operators;

import java.util.List;

import eu.supersede.dm.optimizer.gp.Parameters;
import eu.supersede.dm.optimizer.gp.chromosome.Chromosome;
import eu.supersede.dm.util.RandomNumber;

public class TournamentSelection extends SelectionFunction {

	@Override
	public int getIndex(List<Chromosome> population) {
		int new_num = RandomNumber.nextInt(population.size());
		int winner = new_num;

		int round = 0;

		while (round < Parameters.TOURNAMENT_SIZE - 1) {
			new_num = RandomNumber.nextInt(population.size());
			Chromosome selected = population.get(new_num);

			if (maximize) {
				if (selected.getFitness() > population.get(winner).getFitness()) {
					winner = new_num;
				}
			} else {
				if (selected.getFitness() < population.get(winner).getFitness()) {
					winner = new_num;
				}
			}
			round++;
		}

		return winner;
	}

}
