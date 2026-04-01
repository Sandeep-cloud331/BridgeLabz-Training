import java.util.Scanner;

public class SimpleInterest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the principal amount : ");
    double p = sc.nextDouble(); // input principal amount
    System.out.print("Enter the Rate : ");
    double r = sc.nextDouble(); // input rate
    System.out.print("Enter the time in years : ");
    double t = sc.nextDouble(); // input time in years
    double si = (p * r * t) / 100; // calculate simple interest
    System.out.print("Simple Interest : " + si); // print simple interest
  }
}