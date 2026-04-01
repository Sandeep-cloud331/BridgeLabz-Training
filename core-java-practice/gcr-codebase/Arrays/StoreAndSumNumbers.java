import java.util.Scanner;
public class StoreAndSumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to store maximum 10 values
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Infinite loop
        while (true) {

            System.out.print("Enter a number (0 or negative to stop): ");
            double input = sc.nextDouble();

            // Break if input is 0 or negative
            if (input <= 0) {
                break;
            }

            // Break if array size limit reached
            if (index == 10) {
                break;
            }

            // Store value and increment index
            numbers[index] = input;
            index++;
        }

        // Calculate total using for loop
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display all numbers
        System.out.println("\nStored Numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        // Display total
        System.out.println("\nTotal of all numbers = " + total);

    }
}
