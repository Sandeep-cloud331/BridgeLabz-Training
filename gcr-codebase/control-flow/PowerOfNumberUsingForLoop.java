import java.util.Scanner;

public class PowerOfNumberUsingForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        // Validating positive integers
        if (number < 0 || power < 0) {
            System.out.println("enter positive integer");
        } else {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + "^" + power + " = " + result);
        }
    }
}