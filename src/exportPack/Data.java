package exportPack;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
	private ArrayList<Part>parts = new ArrayList<Part>();
	private ArrayList<String>machines = new ArrayList<String>();
/////////////////////////////getters and Setters////////////////////////////////////
	public ArrayList<Part> getParts() {
		return parts;
	}
	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}
	public ArrayList<String> getMachines() {
		return machines;
	}
	public void setMachines(ArrayList<String> machines) {
		this.machines = machines;
	}
	
}
