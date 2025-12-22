import java.util.Scanner;
public class AnagramCheck {

    // method to check if two texts are anagrams
    static boolean isAnagram(String s1, String s2) {

        // check length
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq1 = new int[256]; // ASCII
        int[] freq2 = new int[256];

        // find frequency of characters
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }

        // compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        boolean result = isAnagram(text1, text2);

        // Output the results
        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }

    }
}
