import java.util.Scanner;

public class SubstringCheck {

    // create substring using charAt()
    static String makeSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }
        return result;
    }

    // compare two strings using charAt()
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // User input for a string
        System.out.print("Enter a string: ");
        String text = sc.next();

        // User input for starting index
        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        // User input for end index
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // calling methods
        String subByCharAt = makeSubstring(text, start, end);
        String subByBuiltIn = text.substring(start, end);

        boolean result = compareStrings(subByCharAt, subByBuiltIn);

        System.out.println("Substring using charAt(): " + subByCharAt);
        System.out.println("Substring using substring(): " + subByBuiltIn);
        System.out.println("Are both substrings same? " + result);
    }
}
