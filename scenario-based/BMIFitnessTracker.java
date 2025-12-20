import java.util.Scanner;
public class BMIFitnessTracker {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //greeting message
    System.out.println("Welcome to the BMI Fitness Tracker!");
    // Taking user input for weight and height
    System.out.print("Enter your weight in kg: ");
    double weight = sc.nextDouble();
    System.out.print("Enter your height in meters: ");
    double height = sc.nextDouble();
    // Calculating BMI
    double BMI = weight / (height * height);
    System.out.println("Your BMI is: " + BMI);
    // weight category according to BMI
    if(BMI < 18.5){
      System.out.println("Underweight");
    }else if(BMI >= 18.5 && BMI < 25){
      System.out.println("Normal weight");
    }else{
      System.out.println("Overweight");
    }
  }
}