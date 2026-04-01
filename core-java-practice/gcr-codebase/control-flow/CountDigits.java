import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        // Handle negative numbers by making positive
        if (number < 0) {
            number = -number;
        }
        // Loop until number != 0
        while (number != 0) {
            number = number / 10;   // Remove last digit
            count++;
        }
        System.out.println("Number of digits: " + count);

    }
}
