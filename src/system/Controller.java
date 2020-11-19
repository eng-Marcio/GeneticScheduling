package system;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import stages.Fitness;
import visual.EvolutionEvents;
import visual.SettingEvents;
import exportPack.Data;
import exportPack.Workingstep;

public class Controller {
	//GA parameters
	private String file;
	
	private int popSize;
	private int selection;
	public static int TOURNAMENT = 0;
	public static int SIMPLE = 1;
	
	private double tsmProb;
	private double tsmPop;
	private double onePointProb;
	private double onePointPop;
	private double twoPointProb;
	private double twoPointPop;
	
	private double mutDistribution;
	private double simpleMutatorProb;
	private double shiftingMutatorProb;
	
	private int objective;
	public static int COST = 0;
	public static int PRODUTION = 1;
	public static int BOTH = 2;
	private int elitism = WORST;
	public static int WORST = 0;
	public static int RANDOM = 1;
	
	private boolean useGenLimit;
	private boolean useTimeLimit;
	private int generationLimit = 200;
	private int timeLimit = 60;
	
	//interfaces
	private JFrame windowController;
	
	//data
	private Data gaData;
	private static String directory = "C:/.../dataFiles/";
	
	//GA algorithm atributes
	private GeneticAlgorithm geneticAlgorithm;
	private ArrayList<String>machines;
	private ArrayList<Workingstep>workingsteps;
//////////////////////////////////Constructor////////////////////////////////////////////	
	public Controller() {
		setWindowController(new SettingEvents(this));
	}
	public static void main(String[] args) {
		new Controller();
	}
/////////////////////////////////Mehtods/////////////////////////////////////////////////
	public void setParameters(String file, int popSize, int selection, double tsmProb, double tsmPop, double onePointProb, double onePointPop, double twoPointProb, double twoPointPop,
			                  double mutDistribution, double simpleMutatorProb, double shiftingMutatorProb, int objective, int elitism, boolean gen, boolean time, int genLimit, int timeLimit) {
		setFile(file);
		getData();
		setPopSize(popSize);
		setSelection(selection);
		setTsmProb(tsmProb);
		setTsmPop(tsmPop);
		setOnePointProb(onePointProb);
		setOnePointPop(onePointPop);
		setTwoPointProb(twoPointProb);
		setTwoPointPop(twoPointPop);
		setMutDistribution(mutDistribution);
		setSimpleMutatorProb(simpleMutatorProb);
		setShiftingMutatorProb(shiftingMutatorProb);
		setObjective(objective);
		setUseGenLimit(gen);
		setUseTimeLimit(time);
		setGenerationLimit(genLimit);
		setTimeLimit(timeLimit);
	}
	public void stepForward() {
		setWindowController(new EvolutionEvents(this));
	}
	public void stepBack() {
		setGeneticAlgorithm(null);
		setWindowController(new SettingEvents(this));
	}
	public void evolve() {
		if(geneticAlgorithm == null) {
			getStructure();
			setGeneticAlgorithm(new GeneticAlgorithm(this));
		}
		geneticAlgorithm.setStopAlg(false);
		geneticAlgorithm.runAlgorithm();
	}
	public void stopEvolve() {
		geneticAlgorithm.setStopAlg(true);
	}
	//////////Auxiliary Methods////////////
	public void getData() {
		try {
			FileInputStream fileIn = new FileInputStream(new File(directory + file + ".gad"));
			ObjectInputStream in = new ObjectInputStream(fileIn);
			setGaData((Data)in.readObject());
			in.close();
			fileIn.close();
		} catch (Exception i) {
			i.printStackTrace();
			return;
		}
	}
	public void getStructure() {
		setMachines(gaData.getMachines());
		setWorkingsteps(new ArrayList<Workingstep>());
		for(int i = 0; i < gaData.getParts().size(); i++) {
			workingsteps.addAll(gaData.getParts().get(i).getWorkingsteps());
		}
	}

/////////////////////////////////Getters and Setters/////////////////////////////////////
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getPopSize() {
		return popSize;
	}
	public void setPopSize(int popSize) {
		this.popSize = popSize;
	}
	public int getSelection() {
		return selection;
	}
	public void setSelection(int selection) {
		this.selection = selection;
	}
	public double getTsmProb() {
		return tsmProb;
	}
	public void setTsmProb(double tsmProb) {
		this.tsmProb = tsmProb;
	}
	public double getTsmPop() {
		return tsmPop;
	}
	public void setTsmPop(double tsmPop) {
		this.tsmPop = tsmPop;
	}
	public double getOnePointProb() {
		return onePointProb;
	}
	public void setOnePointProb(double onePointProb) {
		this.onePointProb = onePointProb;
	}
	public double getOnePointPop() {
		return onePointPop;
	}
	public void setOnePointPop(double onePointPop) {
		this.onePointPop = onePointPop;
	}
	public double getTwoPointProb() {
		return twoPointProb;
	}
	public void setTwoPointProb(double twoPointProb) {
		this.twoPointProb = twoPointProb;
	}
	public double getTwoPointPop() {
		return twoPointPop;
	}
	public void setTwoPointPop(double twoPointPop) {
		this.twoPointPop = twoPointPop;
	}
	public double getMutDistribution() {
		return mutDistribution;
	}
	public void setMutDistribution(double mutDistribution) {
		this.mutDistribution = mutDistribution;
	}
	public double getSimpleMutatorProb() {
		return simpleMutatorProb;
	}
	public void setSimpleMutatorProb(double simpleMutatorProb) {
		this.simpleMutatorProb = simpleMutatorProb;
	}
	public double getShiftingMutatorProb() {
		return shiftingMutatorProb;
	}
	public void setShiftingMutatorProb(double shiftingMutatorProb) {
		this.shiftingMutatorProb = shiftingMutatorProb;
	}
	public int getObjective() {
		return objective;
	}
	public void setObjective(int objective) {
		this.objective = objective;
	}
	public boolean isUseGenLimit() {
		return useGenLimit;
	}
	public void setUseGenLimit(boolean useGenLimit) {
		this.useGenLimit = useGenLimit;
	}
	public boolean isUseTimeLimit() {
		return useTimeLimit;
	}
	public void setUseTimeLimit(boolean useTimeLimit) {
		this.useTimeLimit = useTimeLimit;
	}
	public int getGenerationLimit() {
		return generationLimit;
	}
	public void setGenerationLimit(int generationLimit) {
		this.generationLimit = generationLimit;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public JFrame getWindowController() {
		return windowController;
	}
	public void setWindowController(JFrame windowController) {
		this.windowController = windowController;
	}
	public Data getGaData() {
		return gaData;
	}
	public void setGaData(Data gaData) {
		this.gaData = gaData;
	}
	public GeneticAlgorithm getGeneticAlgorithm() {
		return geneticAlgorithm;
	}
	public void setGeneticAlgorithm(GeneticAlgorithm geneticAlgorithm) {
		this.geneticAlgorithm = geneticAlgorithm;
	}
	public ArrayList<Workingstep> getWorkingsteps() {
		return workingsteps;
	}
	public void setWorkingsteps(ArrayList<Workingstep> workingsteps) {
		this.workingsteps = workingsteps;
	}
	public ArrayList<String> getMachines() {
		return machines;
	}
	public void setMachines(ArrayList<String> machines) {
		this.machines = machines;
	}
	public int getElitism() {
		return elitism;
	}
	public void setElitism(int elitism) {
		this.elitism = elitism;
	}
}
