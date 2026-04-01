import java.util.Scanner;
public class FactorOperations {

    // method to get all factors of n
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }

    // method to find greatest factor
    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) max = Math.max(max, f);
        return max;
    }

    // method to find sum of factors
    public static int sum(int[] arr) {
        int s = 0;
        for (int a : arr) s += a;
        return s;
    }

    // method to find product 
    public static int product(int[] arr) {
        int p = 1;
        for (int a : arr) p *= a;
        return p;
    }

    // method to find cube product
    public static double cubeProduct(int[] arr) {
        double result = 1;
        for (int a : arr) result *= Math.pow(a, 3);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input for any number
        int n = sc.nextInt();
        int[] factors = getFactors(n);
        System.out.print("Factors: ");

        // output the results
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nGreatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum: " + sum(factors));
        System.out.println("Product: " + product(factors));
        System.out.println("Cube Product: " + cubeProduct(factors));
    }
}
