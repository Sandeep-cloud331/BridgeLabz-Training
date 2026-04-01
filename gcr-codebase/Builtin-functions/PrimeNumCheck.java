import java.util.Scanner;
public class PrimeNumCheck {

    // Method to check prime number
    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        int num = scanner.nextInt();

        // Method calling
        boolean isPrime = checkPrime(num);
        System.out.print(isPrime);
    }
}
