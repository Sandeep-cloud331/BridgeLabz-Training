import java.util.Scanner;
public class StringLengthCheck {

    // method to find length without using length()
    static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // exception occurs when index goes out of range
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        int customLength = findLength(str);
        int builtInLength = str.length();

        System.out.println("Length without using length(): " + customLength);
        System.out.println("Length using length(): " + builtInLength);

        sc.close();
    }
}
