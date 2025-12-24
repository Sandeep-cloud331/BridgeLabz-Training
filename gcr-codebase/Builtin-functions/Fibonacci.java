import java.util.*;
public class Fibonacci {

    // Method to generate fibonacci
    public static void generateFibonacci(int n) {
        int a = 0, b = 1;
        
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for terms
        int terms = sc.nextInt();

        generateFibonacci(terms);
    }
}
