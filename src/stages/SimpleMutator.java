package stages;

import java.util.ArrayList;
import java.util.Random;

import exportPack.Workingstep;
import system.GeneticAlgorithm;
import system.Individual;

public class SimpleMutator {
	public static void mutate(GeneticAlgorithm geneticAlgorithm,Individual son) {
		int choice = (new Random()).nextInt(son.getMachineChromosome().size());
		Workingstep ws = geneticAlgorithm.getController().getWorkingsteps().get(choice);
		ArrayList<Integer>possibleMachines = new ArrayList<Integer>();
		for(int i = 0; i < ws.getCostMatrix().size(); i++) {
			if(ws.getCostMatrix().get(i) < 9999) {
				possibleMachines.add(i);
			}
		}
		son.getMachineChromosome().set(choice, possibleMachines.get((new Random()).nextInt(possibleMachines.size())));
	}
}
