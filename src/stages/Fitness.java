package stages;

import java.util.ArrayList;

import system.Controller;
import system.GeneticAlgorithm;
import system.Individual;
import exportPack.Part;
import exportPack.Workingstep;

public class Fitness {
	//schedule structure
	private GeneticAlgorithm geneticAlgorithm;
	private ArrayList<ProcessCell>scheduleResult;
	private ArrayList<MachineWP>machinesWorkPlan;
	private ArrayList<PartWP>partsWorkplan;
	
	//objective
	private int objective;
	public static int COST = 0;
	public static int TIME = 1;
	public static int BOTH = 2;
	
//////////////////////////////////////////Constructor////////////////////////////////////////////////////////
	public Fitness(GeneticAlgorithm geneticAlgorithm, int objective) {
		setObjective(objective);
		setGeneticAlgorithm(geneticAlgorithm);
		initializeStructure();
	}
///////////////////////////////////////////Methods///////////////////////////////////////////////////////////
	public void evaluate(Individual individual) {
		resetStructure();
		ArrayList<Integer>machineChromosome = (ArrayList<Integer>)individual.getMachineChromosome();
		ArrayList<Integer>workingStepChromosome = (ArrayList<Integer>)individual.getWorkingStepChromossome().clone();
		reorder(workingStepChromosome);// reordena de forma a respeitar as precedencias
		//Schedule
		for(int i = 0; i < workingStepChromosome.size(); i++) {
			Workingstep workingstep = geneticAlgorithm.getController().getWorkingsteps().get(workingStepChromosome.get(i));
			int wsIndex = workingStepChromosome.get(i);
			PartWP part = findPart(workingstep);
			MachineWP machine = findMachine(geneticAlgorithm.getController().getMachines().get(machineChromosome.get(wsIndex)));
			double processTime = workingstep.getTimeMatrix().get(machineChromosome.get(wsIndex));
			double totalCost = workingstep.getCostMatrix().get(machineChromosome.get(wsIndex));
			if(i != 0) {
				for(int j = i - 1; j >=0; j--) {
					Workingstep ws = geneticAlgorithm.getController().getWorkingsteps().get(workingStepChromosome.get(j));
					if(findPart(ws).equals(part)) {
						processTime += workingstep.getTimePenaltiesMatrix().get(machineChromosome.get(workingStepChromosome.get(j))).get(machineChromosome.get(wsIndex));
						totalCost += workingstep.getCostPenaltiesMatrix().get(machineChromosome.get(workingStepChromosome.get(j))).get(machineChromosome.get(wsIndex));
						break;
					}
				}
			}
			double start = part.getBusyTime();
			double end = start + processTime;
			int index = 0;
			while(true) {
				if(canAllok(start, end, machine.getWorkPlan()))
					break;
				else {
					index = nextEnd(start, machine.getWorkPlan());
					start = machine.getWorkPlan().get(index).get(1);
					end =  start + processTime;
				}
			}
			//aloca a task
			ArrayList<Double> element = new ArrayList<Double>();
			element.add(start);
			element.add(end);
			if(machine.getWorkPlan().isEmpty()) 
				machine.getWorkPlan().add(0, element);
			else
				machine.getWorkPlan().add(index + 1, element);
			part.setBusyTime(end);
			scheduleResult.add(new ProcessCell(geneticAlgorithm.getController().getMachines().get(machineChromosome.get(wsIndex)) ,workingstep, start, end, totalCost));			
		}
		//calcula score
		double tempoTotal = 0;
		double custoTotal = 0;
		for(int i = 0; i < scheduleResult.size(); i++) {
			tempoTotal = Math.max(tempoTotal, scheduleResult.get(i).getEnd());
			custoTotal += scheduleResult.get(i).getTotalCost();
		}
		if(objective == COST)
			individual.setScore(custoTotal);
		else if(objective == TIME)
			individual.setScore(tempoTotal);
		else if(objective == BOTH)
			individual.setScore(0.5*custoTotal + 0.5*tempoTotal);
	}
	public boolean canAllok(double start, double end, ArrayList<ArrayList<Double>>machineWP) {
		for(int i = 0; i < machineWP.size(); i++) {
			if(!(((start <= machineWP.get(i).get(0))&&(end <= machineWP.get(i).get(0)))||((start >= machineWP.get(i).get(1))&&(end >= machineWP.get(i).get(1)))))
					return false;
		}
		return true;
	}
	public int nextEnd(double start, ArrayList<ArrayList<Double>>machineWP) {
		for(int i = 0; i < machineWP.size(); i++) {
			if(machineWP.get(i).get(1) > start)
				return i;
		}
		System.out.println("furou a lista");
		return machineWP.size() - 1;
	}
	public void initializeStructure() {
		setMachinesWorkPlan(new ArrayList<MachineWP>());
		setPartsWorkplan(new ArrayList<PartWP>());
		for(int i =0; i < geneticAlgorithm.getController().getMachines().size(); i++) {
			machinesWorkPlan.add(new MachineWP(geneticAlgorithm.getController().getMachines().get(i)));
		}
		for(int i =0; i < geneticAlgorithm.getController().getGaData().getParts().size(); i++) {
			partsWorkplan.add(new PartWP(geneticAlgorithm.getController().getGaData().getParts().get(i)));
		}
		setScheduleResult(new ArrayList<ProcessCell>());
	}
	public void resetStructure() {
		for(int i =0; i < machinesWorkPlan.size(); i++) {
			machinesWorkPlan.get(i).setWorkPlan(new ArrayList<ArrayList<Double>>());
		}
		for(int i =0; i < partsWorkplan.size(); i++) {
			partsWorkplan.get(i).setBusyTime(0.0);
		}
		setScheduleResult(new ArrayList<ProcessCell>());
	}
	public PartWP findPart(Workingstep workingstep) {
		for(int i = 0; i < partsWorkplan.size(); i++) {
			if(partsWorkplan.get(i).getPart().getWorkingsteps().contains(workingstep))
				return partsWorkplan.get(i);
		}
		return null;
	}
	public MachineWP findMachine(String string) {
		for(int i =0; i <machinesWorkPlan.size(); i++) {
			if(machinesWorkPlan.get(i).getName().equals(string))
				return machinesWorkPlan.get(i);
		}
		return null;
	}
	public void reorder(ArrayList<Integer> wsChromosome) {
		ArrayList<Integer>vistos = new ArrayList<Integer>();
		for(int i = 0; i < wsChromosome.size(); i++) {
			Workingstep workingstep = geneticAlgorithm.getController().getWorkingsteps().get(wsChromosome.get(i));
			Workingstep precedenteObj = workingstep.getPrecedentWorkinstep();
			if(precedenteObj == null) {
				vistos.add(wsChromosome.get(i));
				continue;
			}
			Integer precedente = getWorkingstepIndex(precedenteObj);
			if(vistos.contains(precedente)) {
				vistos.add(wsChromosome.get(i));
				continue;
			}
			//else tem que puxar a operacao precedente para frente da atual
			for(int j = i+1; j < wsChromosome.size(); j++) {
				if(wsChromosome.get(j).equals(precedente)) {
					Integer target = wsChromosome.remove(j);
					wsChromosome.add(i, target);
					i--;
					break;
				}
			}
		}
	}
	public int getWorkingstepIndex(Workingstep ws) {
		return geneticAlgorithm.getController().getWorkingsteps().indexOf(ws);
	}
///////////////////////////////////////////Getters and Setters///////////////////////////////////////////////
	public ArrayList<ProcessCell> getScheduleResult() {
		return scheduleResult;
	}
	public void setScheduleResult(ArrayList<ProcessCell> scheduleResult) {
		this.scheduleResult = scheduleResult;
	}
	public ArrayList<MachineWP> getMachinesWorkPlan() {
		return machinesWorkPlan;
	}
	public void setMachinesWorkPlan(ArrayList<MachineWP> machinesWorkPlan) {
		this.machinesWorkPlan = machinesWorkPlan;
	}
	public ArrayList<PartWP> getPartsWorkplan() {
		return partsWorkplan;
	}
	public void setPartsWorkplan(ArrayList<PartWP> partsWorkplan) {
		this.partsWorkplan = partsWorkplan;
	}
	public int getObjective() {
		return objective;
	}
	public void setObjective(int objective) {
		this.objective = objective;
	}
	public GeneticAlgorithm getGeneticAlgorithm() {
		return geneticAlgorithm;
	}
	public void setGeneticAlgorithm(GeneticAlgorithm geneticAlgorithm) {
		this.geneticAlgorithm = geneticAlgorithm;
	}
}
