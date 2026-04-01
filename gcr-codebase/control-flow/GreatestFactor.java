import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int greatestFactor = 1;

        // Finding greatest factor from number-1 down to 1
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;  // Stop at first (largest) factor found
            }
        }
        System.out.println("Greatest factor of " + number + " is " + greatestFactor);
    }
}
