import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Distance in Km");
        double km=sc.nextDouble();
        //formula miles=kilometers*0.621371
        double miles=km*0.621371;
        System.out.println("Distance in Miles: "+miles);
    }
}
