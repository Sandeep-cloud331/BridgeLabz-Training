import java.util.Scanner;
public class UniqueCharFrequency {

    // method to find unique characters using nested loops
    static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (temp[j] == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count++] = ch;
            }
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // method to find frequency using unique characters
    static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII frequency array

        // count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] data = findFrequency(text);

        // Output the results
        System.out.println("\nCharacter  Frequency");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "          " + data[i][1]);
        }

    }
}
