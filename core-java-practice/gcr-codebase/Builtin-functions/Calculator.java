import java.util.Scanner;
public class Calculator {

    // Methods to perform different arithmetic operations
    public static int add(int a, int b){
        return a + b;
    }
    public static int subtract(int a, int b){
        return a - b;
    }
    public static int multiply(int a, int b){
        return a * b;
    }
    public static int divide(int a, int b){
        return b != 0 ? a / b : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input of any twwo numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        char operation = sc.next().charAt(0);

        // Choosing operator
        int result = switch (operation) {
            case '+' -> add(a, b);
            case '-' -> subtract(a, b);
            case '*' -> multiply(a, b);
            case '/' -> divide(a, b);
            default -> 0;
        };
        
        // Print the results
        System.out.print(result);
    }
}
