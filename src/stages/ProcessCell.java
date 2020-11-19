package stages;

import exportPack.Workingstep;

public class ProcessCell {
	private double start;
	private double end;
	private double totalCost = 0;
	private String machine;
	private Workingstep workingstep;
////////////////////////////////////////////////Constructor///////////////////////////////////////////////////////////
	public ProcessCell(String machine, Workingstep workingstep, double start, double end, double cost) {
		setMachine(machine);
		setWorkingstep(workingstep);
		setStart(start);
		setEnd(end);
		setTotalCost(cost);
	}
/////////////////////////////////////////////////Getters and Setters//////////////////////////////////////////////////
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public Workingstep getWorkingstep() {
		return workingstep;
	}
	public void setWorkingstep(Workingstep workingstep) {
		this.workingstep = workingstep;
	}
	public double getStart() {
		return start;
	}
	public void setStart(double start) {
		this.start = start;
	}
	public double getEnd() {
		return end;
	}
	public void setEnd(double end) {
		this.end = end;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}
