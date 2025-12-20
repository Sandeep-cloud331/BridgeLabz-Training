import java.util.Scanner;

public class PowerOfNumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        // Validating positive integers
        if (number < 0 || power < 0) {
            System.out.println("enter positive integer");
        } else {
            int result = 1;
            int count=1;
            while (count <= power) {
                result *= number;
                count++;
            }
            System.out.println(number + "^" + power + " = " + result);
        }
    }
}
