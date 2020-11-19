package exportPack;

import java.io.Serializable;
import java.util.ArrayList;

public class Part implements Serializable {
	private String name;
	private ArrayList<Workingstep>workingsteps;
	public Part(String name) {
		setName(name);
		setWorkingsteps(new ArrayList<Workingstep>());
	}
//////////////////////////////////getters and setters////////////////////////////////////
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Workingstep> getWorkingsteps() {
		return workingsteps;
	}
	public void setWorkingsteps(ArrayList<Workingstep> workingsteps) {
		this.workingsteps = workingsteps;
	}
}
