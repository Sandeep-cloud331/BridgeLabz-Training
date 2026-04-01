import java.util.Scanner;

public class CompareSubString {

    // Method to create substring using charAt()
    static String createSubstringCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        // enter start & end  index
        int start = sc.nextInt();
        int end = sc.nextInt();
        // Create substrings
        String manualSub = createSubstringCharAt(text, start, end);
        String builtInSub = text.substring(start, end);

        // Compare using charAt method
        boolean areEqual = compareUsingCharAt(manualSub, builtInSub);
        if(areEqual) {
            System.out.println("both substrings are equal");
        }else{
            System.out.println("both are not equal");
        }


    }
}
