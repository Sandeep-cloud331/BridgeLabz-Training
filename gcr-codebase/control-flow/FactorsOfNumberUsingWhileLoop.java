import java.util.Scanner;

public class FactorsOfNumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // Check if number is positive
        if (number <= 0) {
            System.out.println("enter a positive integer");
        } else {
            // Find factors from 1 to number-1
            int i=1;
            while (i<number) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
                i++;
            }
        }
    }

}
