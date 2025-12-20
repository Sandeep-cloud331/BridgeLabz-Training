import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Weight & height (cm): ");
        double weight = sc.nextDouble();
        double heightCm = sc.nextDouble();
        // Converting height from cm to meters {divide by 100}
        double height = heightCm / 100.0;

        // formula of BMI: weight / (height * height)
        double bmi = weight / (height * height);
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        System.out.printf("BMI: %.2f kg/m²\n", bmi);
        System.out.println("Status: " + status);
    }
}
