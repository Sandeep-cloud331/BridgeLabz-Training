import java.util.Scanner;

public class SwitchCaseCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first & second number: ");
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        sc.nextLine(); // Clear buffer after doubles
        System.out.print("Enter operator (+, -, *, /): ");
        String op = sc.nextLine().trim();

        // Perform operation using switch case
        switch (op) {
            case "+":
                System.out.println(first+" + "+second+" = "+(first + second));
                break;
            case "-":
                System.out.println(first+" - "+second+" = "+(first - second));
                break;
            case "*":
                System.out.println(first+" * "+second+" = "+(first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println(first+" / "+second+" = "+(first / second));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
    }
}
