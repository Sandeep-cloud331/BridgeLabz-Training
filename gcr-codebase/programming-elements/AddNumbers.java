import java.util.Scanner;

public class AddNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(); // first number
    int b = sc.nextInt(); // second number
    int sum = a + b; // calculating sum
    System.out.println("Sum of " + a + " and " + b + " is: " + sum);
  }
}