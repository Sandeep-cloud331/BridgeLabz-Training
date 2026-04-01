import java.util.*;
public class SumOfNaturalNumbers {

    // method to calculate sum
    public static int sum(int num) {
        return num * (num + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for n i.e. upto n natural number
        System.out.println("Enter a natural number: ");
        int num = sc.nextInt();

        // method calling
        int ans = sum(num);

        // output the result
        System.out.println("The sum of natural numbers upto " + num + " is " + ans);
    }
}