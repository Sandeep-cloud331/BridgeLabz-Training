import java.util.Scanner;
public class CharFrequencyNested {

    // method to find frequency using nested loops
    static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        // initialize frequency
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // count valid characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // store result in 1D String array
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " = " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] output = findFrequency(text);

        // Output the results
        System.out.println("\nCharacter Frequency:");
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }

    }
}
