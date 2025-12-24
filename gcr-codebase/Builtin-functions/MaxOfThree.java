import java.util.*;
public class MaxOfThree {

    // Method to get input
    public static int getInput(Scanner sc) {
        return sc.nextInt();
    }

    // Method to find max number
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Method calling
        int num1 = getInput(sc);
        int num2 = getInput(sc);
        int num3 = getInput(sc);

        int max = findMax(num1, num2, num3);
        System.out.print(max);

    }
}
