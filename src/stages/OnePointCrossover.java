package stages;

import java.util.ArrayList;
import java.util.Random;

import system.Individual;

public class OnePointCrossover {
	public static void cross(Individual i1, Individual i2) {
		ArrayList<Integer>father = i1.getMachineChromosome();
		ArrayList<Integer>mother = i2.getMachineChromosome();
		Random random = new Random();
		int split = random.nextInt(father.size());
		for(int i = 0; i < father.size(); i++) {
			if (i < split) {
				Integer alelo1 = father.remove(i);
				Integer alelo2 = mother.remove(i);
				father.add(i, alelo2);
				mother.add(i, alelo1);
			}
		}
		i1.setMachineChromosome(father);
		i2.setMachineChromosome(mother);
	}
}
