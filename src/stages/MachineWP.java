package stages;

import java.util.ArrayList;

public class MachineWP {
	private String name;
	private ArrayList<ArrayList<Double>>workPlan = new ArrayList<ArrayList<Double>>();
	public MachineWP(String name) {
		setName(name);
		setWorkPlan(new ArrayList<ArrayList<Double>>());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<ArrayList<Double>> getWorkPlan() {
		return workPlan;
	}
	public void setWorkPlan(ArrayList<ArrayList<Double>> workPlan) {
		this.workPlan = workPlan;
	}
}
