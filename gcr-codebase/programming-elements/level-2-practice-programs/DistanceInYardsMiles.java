import java.util.Scanner;

public class DistanceInYardsMiles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter distance in feets");
        int distanceInFeet=sc.nextInt();
        double distanceInYards= (double) distanceInFeet /3;
        double distanceInMiles=distanceInYards/1760;
        System.out.println("Distance in Yards is "+distanceInYards+" and in miles is "+distanceInMiles);
    }
}
