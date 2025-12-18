import java.util.Scanner;

public class CalculatePower {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int b = sc.nextInt(); // input base number
    int e = sc.nextInt(); // input exponent
    int p = 1;
    for (int i = 1; i <= e; i++) {
      p *= b; // multiply the number by itself
    }
    System.out.println(p); // print output
  }
}