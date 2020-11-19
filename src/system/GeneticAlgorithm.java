package system;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingUtilities;

import stages.*;
import visual.EvolutionEvents;

public class GeneticAlgorithm  implements Runnable {
	//system Atributes
	private Controller controller;
	private ArrayList<Individual>population;
	
	//algorithm atributes
	private Fitness fitness; 
	private Individual bestIndividual;
	private double bestScore = 999999999;
	private ArrayList<ProcessCell>scheduleResult;
	private long startTime;
	private boolean stopAlg = true;
	
/////////////////////////////////////constructor////////////////////////////////////////////////////////////////////////
	public GeneticAlgorithm(Controller controller) {
		setController(controller);
		setFitness(new Fitness(this, controller.getObjective()));
	}
/////////////////////////////////////methods///////////////////////////////////////////////////////////////////////////
	public void runAlgorithm() {
		Thread thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() { //runs the algorithm in background to avoid problems with the interface fuctions
		createPopulation();
		evaluatePopulation(population);
		Random random = new Random();
		//loop do ag
		int generation = 1;
		while(continueIteration(generation)) {
			ArrayList<Individual>selectedToReproduce = select();
			ArrayList<Individual>crossTSM = new ArrayList<Individual>();
			ArrayList<Individual>cross1 = new ArrayList<Individual>();
			ArrayList<Individual>cross2 = new ArrayList<Individual>();
			for(int i = 0; i <selectedToReproduce.size(); i++) { //distribui a populacao pelas 3 tecnicas de crossingover
				if((i/(selectedToReproduce.size()+ 0.0)) <= controller.getTsmPop())
					crossTSM.add(selectedToReproduce.get(i));
				else if((i/(selectedToReproduce.size()+ 0.0)) <= (controller.getTsmPop() + controller.getOnePointPop())) 
					cross1.add(selectedToReproduce.get(i));
				else
					cross2.add(selectedToReproduce.get(i));
			}
			//do the crossingovers
			for(int i = 0; i < crossTSM.size(); i=i+2) {
				if(i ==crossTSM.size() - 1) {
					selectedToReproduce.remove(crossTSM.get(i));
					break;
				}
				if(random.nextDouble() <= controller.getTsmProb())
					TSMCrossover.cross(crossTSM.get(i),crossTSM.get(i+1));
				else {
					selectedToReproduce.remove(crossTSM.get(i));
					selectedToReproduce.remove(crossTSM.get(i+1));
				}
			}
			for(int i = 0; i < cross1.size(); i=i+2) {
				if(i ==cross1.size() - 1) {
					selectedToReproduce.remove(cross1.get(i));
					break;
				}
				if(random.nextDouble() <= controller.getOnePointProb())
					TSMCrossover.cross(cross1.get(i),cross1.get(i+1));
				else {
					selectedToReproduce.remove(cross1.get(i));
					selectedToReproduce.remove(cross1.get(i+1));
				}
			}
			for(int i = 0; i < cross2.size(); i=i+2) {
				if(i ==cross2.size() - 1) {
					selectedToReproduce.remove(cross2.get(i));
					break;
				}
				if(random.nextDouble() <= controller.getTwoPointProb())
					TSMCrossover.cross(cross2.get(i),cross2.get(i+1));
				else {
					selectedToReproduce.remove(cross2.get(i));
					selectedToReproduce.remove(cross2.get(i+1));
				}
			}
			//execute mutations
			ArrayList<Individual>shift = new ArrayList<Individual>();
			for(int i = 0; i < selectedToReproduce.size(); i++) {
				if(random.nextDouble() <= controller.getShiftingMutatorProb())
					ShiftingMutator.mutate(this, selectedToReproduce.get(i));
				if(random.nextDouble() <= controller.getSimpleMutatorProb())
					SimpleMutator.mutate(this, selectedToReproduce.get(i));
			}
			//evaluate new individuals
			evaluatePopulation(selectedToReproduce);
			
			//update population, elitism: mantain the best
			population.addAll(selectedToReproduce);
			if(controller.getElitism() == controller.RANDOM) {
				while(population.size() > controller.getPopSize()) {
					int target = random.nextInt(population.size());
					if(!population.get(target).equals(bestIndividual))
						population.remove(target);
				}
			}
			else if(controller.getElitism() == controller.WORST) {
				ArrayList<Individual>extermination = new ArrayList<Individual>();
				for(int i = 0; i < population.size(); i++) {
					boolean add= false;
					if(population.size() > controller.getPopSize())
						add= true;
					if(!extermination.isEmpty()) {
						if(population.get(i).getScore() > extermination.get(0).getScore())
							add = true;
					}
					if(add) {
						if(extermination.isEmpty())
							extermination.add(population.remove(i));
						else {
							for(int j = 0; j <= extermination.size(); j++) {
								if(j == extermination.size())
									extermination.add(population.remove(i));
								else if(population.get(i).getScore() <= extermination.get(j).getScore())
									extermination.add(j, population.remove(i));
								else
									continue;
								if(population.size() < controller.getPopSize()) 
									population.add(i, extermination.remove(0));
								else 
									i--;
								break;
							}
						}
					}
				}
			}
			printIteration(generation);
			generation++;
			System.gc();
		}
		printIteration(generation);
		if(((EvolutionEvents)controller.getWindowController()).executeButton.isSelected())
			((EvolutionEvents)controller.getWindowController()).executeButton.doClick();
	}
	public ArrayList<Individual> select() {
		Random random = new Random();
		ArrayList<Individual>selectedToReproduce = new ArrayList<Individual>();
		ArrayList<Individual>individuals = new ArrayList<Individual>();
		for(int i = 0; i < population.size(); i++) {
			individuals.add((Individual)population.get(i).clone());
		}
		if(controller.getSelection() == Controller.TOURNAMENT) {
			while(individuals.size() > 2) {
				Individual i1 = individuals.remove(random.nextInt(individuals.size()));
				Individual i2 = individuals.remove(random.nextInt(individuals.size()));
				if(i1.getScore() < i2.getScore())
					selectedToReproduce.add(i1);
				else
					selectedToReproduce.add(i2);
			}
		}
		else if(controller.getSelection() == Controller.SIMPLE) {
			while(selectedToReproduce.size() < population.size()/2) {
				selectedToReproduce.add(individuals.remove(random.nextInt(individuals.size())));
			}
		}
		return selectedToReproduce;
	}
	public void evaluatePopulation(ArrayList<Individual>pop) {
		for(int i = 0; i < pop.size(); i++) {
			fitness.evaluate(pop.get(i));
			if(pop.get(i).getScore() < bestScore) { //queremos otimizar tempo, quanto menor melhor
				setBestScore(pop.get(i).getScore());
				setBestIndividual(pop.get(i));
				setScheduleResult(fitness.getScheduleResult());
			}
		}
	}
	public boolean continueIteration(int generation) {
		boolean result = true;
		if(controller.isUseGenLimit()) {
			if(generation > controller.getGenerationLimit()) {
				result = false;
			}
		}
		if(controller.isUseTimeLimit()) {
			if(((System.currentTimeMillis() - startTime)/1000)>= controller.getTimeLimit())
				result = false;
		}
		return result&&(!stopAlg);
	}
	public void createPopulation() {
		setPopulation(new ArrayList<Individual>());
		for(int i = 0; i < controller.getPopSize(); i++) {
			Random random = new Random();
			ArrayList<Integer>machineChromosome = new ArrayList<Integer>();
			ArrayList<Integer>workingstepsChromosome = new ArrayList<Integer>();
			for(int j = 0; j < controller.getWorkingsteps().size(); j++) {
				ArrayList<Integer>possibleMachines = new ArrayList<Integer>();
				for(int k = 0; k < controller.getWorkingsteps().get(j).getCostMatrix().size(); k++) {
					if(controller.getWorkingsteps().get(j).getCostMatrix().get(k) < 9999) {
						possibleMachines.add(k);
					}
				}
				machineChromosome.add(possibleMachines.get(random.nextInt(possibleMachines.size())));
				if(workingstepsChromosome.isEmpty())
					workingstepsChromosome.add(0, j);
				else
					workingstepsChromosome.add(random.nextInt(workingstepsChromosome.size() + 1), j);
			}
//			System.out.println(workingstepsChromosome);
//			System.out.println(machineChromosome);
//			System.out.println("======================================================================================");
			population.add(new Individual(this, workingstepsChromosome, machineChromosome));
		}
	}
	public void printIteration(final int generation) {
		//prints best individual each 20 generations
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				((EvolutionEvents)controller.getWindowController()).printResult(generation, bestScore, scheduleResult);
			}
		});
	}
////////////////////////////////////Getters and Setters/////////////////////////////////////////////////////////////////
	public Individual getBestIndividual() { 
		return bestIndividual;
	}
	public void setBestIndividual(Individual bestIndividual) {
		this.bestIndividual = bestIndividual;
	}
	public double getBestScore() {
		return bestScore;
	}
	public void setBestScore(double bestScore) {
		this.bestScore = bestScore;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public ArrayList<Individual> getPopulation() {
		return population;
	}
	public void setPopulation(ArrayList<Individual> population) {
		this.population = population;
	}
	public Fitness getFitness() {
		return fitness;
	}
	public void setFitness(Fitness fitness) {
		this.fitness = fitness;
	}
	public boolean isStopAlg() {
		return stopAlg;
	}
	public void setStopAlg(boolean stopAlg) {
		this.stopAlg = stopAlg;
	}
	public ArrayList<ProcessCell> getScheduleResult() {
		return scheduleResult;
	}
	public void setScheduleResult(ArrayList<ProcessCell> scheduleResult) {
		this.scheduleResult = scheduleResult;
	}
}
