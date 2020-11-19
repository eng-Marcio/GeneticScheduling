package exportPack;

import java.io.Serializable;
import java.util.ArrayList;

public class Workingstep implements Serializable{
	private String name;
	private String id;
	private ArrayList<Double>timeMatrix;
	private ArrayList<Double>costMatrix;
	private ArrayList<ArrayList<Double>>timePenaltiesMatrix;
	private ArrayList<ArrayList<Double>>costPenaltiesMatrix;
	private Workingstep precedentWorkinstep;
/////////////////////////////////////constructor/////////////////////////////////////
	public Workingstep(String name, String id, ArrayList<Double>timeMatrix, ArrayList<Double>costMatrix, ArrayList<ArrayList<Double>>timePenaltiesMatrix, ArrayList<ArrayList<Double>>costPenaltiesMatrix, Workingstep precedent) {
		setName(name);
		setTimeMatrix(timeMatrix);
		setCostMatrix(costMatrix);
		setTimePenaltiesMatrix(timePenaltiesMatrix);
		setCostPenaltiesMatrix(costPenaltiesMatrix);
		setPrecedentWorkinstep(precedent);
	}
///////////////////////////////////getters and setters////////////////////////////////////
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Double> getTimeMatrix() {
		return timeMatrix;
	}
	public void setTimeMatrix(ArrayList<Double> timeMatrix) {
		this.timeMatrix = timeMatrix;
	}
	public ArrayList<Double> getCostMatrix() {
		return costMatrix;
	}
	public void setCostMatrix(ArrayList<Double> costMatrix) {
		this.costMatrix = costMatrix;
	}
	public ArrayList<ArrayList<Double>> getTimePenaltiesMatrix() {
		return timePenaltiesMatrix;
	}
	public void setTimePenaltiesMatrix(
			ArrayList<ArrayList<Double>> timePenaltiesMatrix) {
		this.timePenaltiesMatrix = timePenaltiesMatrix;
	}
	public ArrayList<ArrayList<Double>> getCostPenaltiesMatrix() {
		return costPenaltiesMatrix;
	}
	public void setCostPenaltiesMatrix(
			ArrayList<ArrayList<Double>> costPenaltiesMatrix) {
		this.costPenaltiesMatrix = costPenaltiesMatrix;
	}
	public Workingstep getPrecedentWorkinstep() {
		return precedentWorkinstep;
	}
	public void setPrecedentWorkinstep(Workingstep precedentWorkinstep) {
		this.precedentWorkinstep = precedentWorkinstep;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
