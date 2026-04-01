import java.util.Scanner;

public class MultiplesUnderHundred {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        // Validating input
        if (number <= 0 || number >= 100) {
            System.out.println("enter a positive integer less than 100");
        } else {
            System.out.print("Multiples of " + number + " under 100: ");
            // Backward loop from 100 to 1
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
