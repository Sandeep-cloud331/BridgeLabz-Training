import java.util.*;
public class VesselUtil {
	
	private List<Vessel> vesselList = new ArrayList<>();
	
	public void addVesselPerformance(Vessel record) {
		vesselList.add(record);
	}
	
	public Vessel getVesselById(String id) {
		if(vesselList.isEmpty()) {
			System.out.println("There is no vessel record in present");
		}
		for(Vessel i : vesselList) {
			if(id.equals(i.getVesselId())) {
				return i;
			}
		}
		return null; 
	}
	
	public List<Vessel> getHighPerformanceVessels(){
		List<Vessel> highPerformerList = new ArrayList<>();
		
		double max = 0;
		for(Vessel i : vesselList) {
			if((i.getAverageSpeed())>max) {
				max = i.getAverageSpeed();
			}
		}
		for(Vessel i : vesselList) {
			if(i.getAverageSpeed() == max) {
				highPerformerList.add(i); 
			}
		}
		return highPerformerList; 
	}
}
