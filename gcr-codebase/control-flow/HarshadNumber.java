import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0;
        // Temporary copy
        int temp = number;
        while (temp != 0) {
            int digit = temp % 10;  // Get last digit
            sum += digit;           // Add each digit to sum...
            temp = temp / 10;       // Remove last digit
        }

        // Check if number is perfectly divisible by sum
        if (sum != 0 && number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
    }
}
