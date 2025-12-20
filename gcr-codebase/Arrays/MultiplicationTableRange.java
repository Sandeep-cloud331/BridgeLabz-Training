import java.util.Scanner;
public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Array to store multiplication results from 6 to 9
        int[] multiplicationResult = new int[4];

        // Store results using for loop (6 to 9)
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }

        // Display the results
        System.out.println("\nMultiplication Table of " + number + " from 6 to 9:");

        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }

    }
}
