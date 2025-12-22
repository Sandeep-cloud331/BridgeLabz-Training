import java.util.Scanner;
public class StringCompare {

    // method to compare strings using charAt()
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        boolean resultByCharAt = compareStrings(str1, str2);
        boolean resultByEquals = str1.equals(str2);

        System.out.println("Result using charAt(): " + resultByCharAt);
        System.out.println("Result using equals(): " + resultByEquals);

        if (resultByCharAt == resultByEquals)
            System.out.println("Both results are same");
        else
            System.out.println("Results are different");

    }
}
