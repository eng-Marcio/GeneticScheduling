package stages;

import java.util.ArrayList;
import java.util.Random;

import system.GeneticAlgorithm;
import system.Individual;

public class ShiftingMutator {
	public static void mutate(GeneticAlgorithm geneticAlgorithm,Individual son) {
		Random random = new Random();
		Integer choice = son.getWorkingStepChromossome().remove(random.nextInt(son.getWorkingStepChromossome().size()));
		son.getWorkingStepChromossome().add(random.nextInt(son.getWorkingStepChromossome().size()), choice);
	}
}
