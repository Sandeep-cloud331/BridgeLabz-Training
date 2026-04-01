
public class Vessel {
	private String vesselId;
	private String vesselName;
	private double averageSpeed;
	private String vesselType;
	
	public Vessel(String id, String name, double speed, String type) {
		this.vesselId = id;
		this.vesselName = name;
		this.averageSpeed = speed;
		this.vesselType = type;
	}
	
	public String getVesselId() {
		return vesselId; 
	}
	
	public String getVesselName() {
		return vesselName;
	}
	
	public double getAverageSpeed() {
		return averageSpeed;
	}
	
	public String getVesselType() {
		return vesselType; 
	}
}
