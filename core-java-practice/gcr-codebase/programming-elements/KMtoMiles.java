import java.util.Scanner;

public class KMtoMiles {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the kilometers : ");
    int km = sc.nextInt(); // input kilometers
    double miles = km * 0.621371; // calculate miles from kilometers
    System.out.println("Miles : " + miles); // print miles
  }
}