import java.util.Scanner;

public class TemperatureConversion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int celsius = sc.nextInt(); // input celsius from user
    double fahr = ((celsius * 9) / 5) + 32; // calculate fahrenheit
    System.out.println("temperature in fahrenheit is " + fahr); // print fahrenheit
  }
}
