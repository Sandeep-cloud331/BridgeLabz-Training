import java.util.Scanner;
public class DivisionResult {

    // method for finding division result
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        int number = sc.nextInt(), divisor = sc.nextInt();

        // method calling
        int[] res = findRemainderAndQuotient(number, divisor);

        // output result
        System.out.println(res[0]);
        System.out.println(res[1]);

        sc.close();
    }
}
