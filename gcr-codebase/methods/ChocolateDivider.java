import java.util.Scanner;
public class ChocolateDivider {

    // method to chocolate division
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input for children and chocolates
        int chocolates = sc.nextInt();
        int children = sc.nextInt();

        // method calling
        int[] result = findRemainderAndQuotient(chocolates, children);

        // output the results
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
