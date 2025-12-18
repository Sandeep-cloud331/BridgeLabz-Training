import java.util.Scanner;

public class RectanglePerimeter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the length : ");
    double l = sc.nextInt(); // input length
    System.out.print("Enter the breadth : ");
    double b = sc.nextInt(); // input breadth
    double p = 2 * (l + b); // calculate perimeter of rectangle
    System.out.print("Perimeter is : " + p); // print perimeter
  }
}