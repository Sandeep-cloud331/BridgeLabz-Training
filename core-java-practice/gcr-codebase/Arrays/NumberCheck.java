import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define an array of 5 size
        int[] numbers = new int[5];

        // Take user input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nNumber Analysis:");

        // Loop through the array
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is Positive and Even");
                } else {
                    System.out.println(numbers[i] + " is Positive and Odd");
                }
            } 
            else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            } 
            else {
                System.out.println(numbers[i] + " is Zero");
            }
        }

        // Compare first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        System.out.println("\nComparison of First and Last Elements:");

        if (first == last) {
            System.out.println("First and last elements are equal");
        } 
        else if (first > last) {
            System.out.println("First element is greater than last element");
        } 
        else {
            System.out.println("First element is less than last element");
        }

    }
}
