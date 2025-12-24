import java.util.Scanner;

public class Palindrome {

    // Using loop
    static boolean checkPalindromeLoop(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Using recursion
    static boolean checkPalindromeRecursion(String text, int start, int end) {
        if (start >= end)
            return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return checkPalindromeRecursion(text, start + 1, end - 1);
    }

    // Using character array
    static boolean checkPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[text.length()];

        int index = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index++] = text.charAt(i);
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();

        System.out.println("Loop Method: " + checkPalindromeLoop(input));
        System.out.println("Recursion Method: " +
                checkPalindromeRecursion(input, 0, input.length() - 1));
        System.out.println("Array Method: " + checkPalindromeArray(input));

        sc.close();
    }
}