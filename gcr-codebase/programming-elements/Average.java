import java.util.Scanner;

public class Average {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(); // input first number
    int b = sc.nextInt(); // input second number
    int c = sc.nextInt(); // input third number
    System.out.println("Average is : " + (a + b + c) / 3); // print average of 3 numbers
  }
}