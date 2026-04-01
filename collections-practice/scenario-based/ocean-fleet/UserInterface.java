import java.util.*;
public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VesselUtil vu = new VesselUtil();
		int noOfVessels = 0;
		boolean decision = true;
		
		while(decision) {
			System.out.println("Enter the number of vessels to be added : ");
			noOfVessels = sc.nextInt();
			if(noOfVessels>0) decision = false;
			else {System.out.println("Enter the positive value");}
			sc.nextLine();
		}
		
		System.out.println("Enter the Vessel details : ");
		for(int i=0;i<noOfVessels;i++) {
			String input = sc.nextLine();
			String[] inputArray = input.trim().split(":");
			
			vu.addVesselPerformance(new Vessel(inputArray[0],inputArray[1],Double.valueOf(inputArray[2]),inputArray[3]));
		}
		
		System.out.println("\nEnter the Vessel Id to check speed : "); 
		String id = sc.next();
		Vessel record = vu.getVesselById(id);
		if(record != null) {
			System.out.println((record.getVesselId()+" | "+ record.getVesselName()+" | " + record.getVesselType()+" | "+record.getAverageSpeed()+" knots"));
		}
		else {
			System.out.println("Vessel Id "+id+" not found");
		}
			
		System.out.println("\nHigh performance vessels are ");
		
		List<Vessel> highPerformerVesselList = vu.getHighPerformanceVessels();
		for(Vessel i : highPerformerVesselList) {
			System.out.println((i.getVesselId()+" | "+ i.getVesselName()+" | " + i.getVesselType()+" | "+ i.getAverageSpeed()+" knots"));
		}
	}
}
