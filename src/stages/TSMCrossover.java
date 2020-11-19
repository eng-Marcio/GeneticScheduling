package stages;

import java.util.ArrayList;
import java.util.Random;

import system.Individual;

public class TSMCrossover {
	public static void cross(Individual i1, Individual i2) {
		ArrayList<Integer>father = i1.getWorkingStepChromossome();
		ArrayList<Integer>mother = i2.getWorkingStepChromossome();
		int size = father.size();
		Random random = new Random();
		int splitStart = random.nextInt(size);
		int splitEnd = splitStart + random.nextInt(size - splitStart);
		ArrayList<Integer>changedTo2 = new ArrayList<Integer>();
		ArrayList<Integer>changedTo1 = new ArrayList<Integer>();
		for(int i = 0; i < size; i++) {
			if ((i >= splitStart)&&(i <= splitEnd)) {
				Integer allele1 = father.remove(i);
				Integer allele2 = mother.remove(i);
				changedTo1.add(allele2);
				father.add(i, allele2);
				changedTo2.add(allele1);
				mother.add(i, allele1);
			}
		}
		//find repeated alleles
		ArrayList<Integer>repeated1 = new ArrayList<Integer>();
		ArrayList<Integer>repeated2 = new ArrayList<Integer>();
		ArrayList<Integer>index1 = new ArrayList<Integer>();
		ArrayList<Integer>index2 = new ArrayList<Integer>();
		for(int i = 0; i < splitStart; i++) {
			if(changedTo1.contains(father.get(i))) {
				repeated1.add(father.get(i));
				index1.add(i);
			}
			if(changedTo2.contains(mother.get(i))) {
				repeated2.add(mother.get(i));
				index2.add(i);
			}
		}
		for(int i = splitEnd+1; i < size; i++) {
			if(changedTo1.contains(father.get(i))) {
				repeated1.add(father.get(i));
				index1.add(i);
			}
			if(changedTo2.contains(mother.get(i))) {
				repeated2.add(mother.get(i));
				index2.add(i);
			}
		}
		for(int i = 0; i < repeated1.size(); i++) {
			Integer rep1 = father.remove(index1.get(i).intValue());
			Integer rep2 = mother.remove(index2.get(i).intValue());
			father.add(index1.get(i),rep2);
			mother.add(index2.get(i),rep1);
		}
		i1.setWorkingStepChromossome(father);
		i2.setWorkingStepChromossome(mother);
	}
}
