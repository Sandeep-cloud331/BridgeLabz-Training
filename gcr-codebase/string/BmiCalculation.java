import java.util.Scanner;

public class BmiCalculation {
    // Method to calculate bmi, status, and return 2D array
    public static String[][] calculateBMI(int[][] details) {
        String[][] results = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = details[i][0];
            double heightCm = details[i][1];
            double heightM = heightCm / 100.0;
            double bmiValue = weight / (heightM * heightM);
            String status;
            if (bmiValue <= 18.4) {
                status = "Underweight";
            } else if (bmiValue <= 24.9) {
                status = "Normal";
            } else if (bmiValue <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            results[i][0] = String.valueOf(heightCm);
            results[i][1] = String.valueOf(weight);
            results[i][2] = String.format("%.2f", bmiValue);
            results[i][3] = status;
        }
        return results;
    }

    public static void displayResults(String[][] results) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");
        for (String[] row : results) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] personDetails = new int[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " - Enter Weight (kg) & Height (cm): ");
            personDetails[i][0] = input.nextInt(); // Weight
            personDetails[i][1] = input.nextInt(); // Height
        }
        String[][] finalData = calculateBMI(personDetails);
        displayResults(finalData);
        input.close();
    }
}