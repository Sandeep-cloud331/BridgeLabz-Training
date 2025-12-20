import java.util.Scanner;

public class GreatestFactorUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int greatestFactor = 1;

        // Finding greatest factor from number-1 down to 1
        int i=number-1;
        while (i >= 1) {
            if (number % i == 0) {
                greatestFactor = i;
                break;  // Stop at first (largest) factor found
            }
            i--;
        }
        System.out.println("Greatest factor of " + number + " is " + greatestFactor);
    }
}
