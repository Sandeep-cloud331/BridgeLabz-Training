import java.util.Scanner;
public class CharacterFrequency {

    // method to find character frequencies and return 2D array
    static char[][] findFrequency(String text) {

        int[] freq = new int[256];   // ASCII frequency array

        // count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // count how many unique characters
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        // store character and frequency
        char[][] result = new char[count][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (freq[ch] != 0) {
                result[index][0] = ch;
                result[index][1] = (char) (freq[ch] + '0');
                freq[ch] = 0;   // avoid duplicates
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[][] data = findFrequency(text);

        System.out.println("\nCharacter  Frequency");

        // Output the results
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "          " + (data[i][1] - '0'));
        }

    }
}
