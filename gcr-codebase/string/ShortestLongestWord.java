import java.util.Scanner;
public class ShortestLongestWord {

    // find length without using length()
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    // split text into words using charAt()
    static String[] splitUsingCharAt(String text) {
        int len = findLength(text);
        int wordCount = 1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        String word = "";

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = word;
                word = "";
            } else {
                word = word + text.charAt(i);
            }
        }
        words[index] = word; // last word

        return words;
    }

    // create 2D array of word and its length
    static String[][] makeWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }
        return table;
    }

    // find shortest and longest word indexes
    static int[] findShortestAndLongest(String[][] table) {
        int minIndex = 0;
        int maxIndex = 0;

        int minLen = Integer.parseInt(table[0][1]);
        int maxLen = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);

            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }

            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitUsingCharAt(text);
        String[][] table = makeWordLengthTable(words);
        int[] result = findShortestAndLongest(table);

        // Output 
        System.out.println("\nShortest word: " + table[result[0]][0]);
        System.out.println("Length: " + table[result[0]][1]);

        System.out.println("\nLongest word: " + table[result[1]][0]);
        System.out.println("Length: " + table[result[1]][1]);

    }
}
