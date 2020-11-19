package stages;

import java.util.ArrayList;

import exportPack.Part;

public class PartWP {
	private Part part;
	private Double busyTime = 0.0;
	public PartWP(Part part) {
		setPart(part);
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public Double getBusyTime() {
		return busyTime;
	}
	public void setBusyTime(Double busyTime) {
		this.busyTime = busyTime;
	}
}
