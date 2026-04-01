import java.util.Scanner;
public class OddEvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // Check for natural number
        if (number <= 0) {
            System.out.println(" Please enter a natural number greater than 0");
            return;
        }

        // Create arrays for odd and even numbers
        int size = number / 2 + 1;
        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];

        // Index variables
        int evenIndex = 0;
        int oddIndex = 0;

        // Store odd and even numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print even numbers
        System.out.println("\n\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

    }
}
