import java.util.Scanner;
public class FirstNonRepeatingChar {

    // method to find first non-repeating character
    static char findFirstNonRepeating(String text) {
        int[] freq = new int[256]; // ASCII characters

        // count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // if no non-repeating character found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeating(text);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

    }
}
