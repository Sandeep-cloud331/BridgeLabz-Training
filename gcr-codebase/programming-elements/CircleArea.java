import java.util.Scanner;

public class CircleArea {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the radius of circle : ");
    double r = sc.nextInt(); // input radius of circle
    double area = 3.14 * r * r; // calculate area of circle
    System.out.println("area is : " + area); // print area
  }
}
