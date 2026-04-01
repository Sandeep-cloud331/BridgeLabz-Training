import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Define an array to store multiplication results
        int[] table = new int[10];

        // Store multiplication results from 1 to 10
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        
        System.out.println("\nMultiplication Table of " + number + ":");

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }

    }
}
