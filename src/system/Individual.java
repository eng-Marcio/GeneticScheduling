package system;

import java.util.ArrayList;

public class Individual implements Cloneable {
	private GeneticAlgorithm geneticAlgorithm;
	private ArrayList<Integer>workingStepChromossome;
	private ArrayList<Integer>machineChromosome;
	private double score = 9999999;
//////////////////////////////////////////////////////Constructor//////////////////////////////////////////////////////////
	public Individual(GeneticAlgorithm geneticAlgorithm, ArrayList<Integer>workingstepChromosome, ArrayList<Integer>machineChromosome) {
		setGeneticAlgorithm(geneticAlgorithm);
		setWorkingStepChromossome(workingstepChromosome);
		setMachineChromosome(machineChromosome);
	}
	@Override
	public Object clone() {
		return new Individual(geneticAlgorithm, (ArrayList<Integer>)workingStepChromossome.clone(), (ArrayList<Integer>) machineChromosome.clone());
	}
/////////////////////////////////////////////////////Getters And Setters///////////////////////////////////////////////////
	public ArrayList<Integer> getWorkingStepChromossome() {
		return workingStepChromossome;
	}
	public void setWorkingStepChromossome(ArrayList<Integer> workingStepChromossome) {
		this.workingStepChromossome = workingStepChromossome;
	}
	public ArrayList<Integer> getMachineChromosome() {
		return machineChromosome;
	}
	public void setMachineChromosome(ArrayList<Integer> machineChromosome) {
		this.machineChromosome = machineChromosome;
	}
	public GeneticAlgorithm getGeneticAlgorithm() {
		return geneticAlgorithm;
	}
	public void setGeneticAlgorithm(GeneticAlgorithm geneticAlgorithm) {
		this.geneticAlgorithm = geneticAlgorithm;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
