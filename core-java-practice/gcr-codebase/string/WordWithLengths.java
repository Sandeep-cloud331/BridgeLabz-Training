import java.util.Scanner;

public class WordWithLengths {

    // Split text into words using charAt() without split()
    static String[] splitWords(String text) {
        StringBuilder word = new StringBuilder();
        int wordCount = 0;

        // Count words first
        for (int i = 0; i < manualLength(text); i++) {
            if (text.charAt(i) == ' ') {
                if (word.length() > 0) {
                    wordCount++;
                    word.setLength(0);
                }
            } else {
                word.append(text.charAt(i));
            }
        }
        if (word.length() > 0) wordCount++;

        // Extract words
        String[] words = new String[wordCount];
        word.setLength(0);
        int count = 0;

        for (int i = 0; i < manualLength(text); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (word.length() > 0) {
                    words[count++] = word.toString();
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            words[count] = word.toString();
        }
        return words;
    }

    // Manual length calculation using charAt()
    static int manualLength(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                return count;
            }
        }
    }

    // Create 2D array with words and their lengths
    static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(manualLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] result = wordsWithLengths(words);

        // Display table
        System.out.println("\nWord\t\tLength");
        System.out.println("----\t\t------");
        for (String[] row : result) {
            int lengthInt = Integer.parseInt(row[1]);
            System.out.printf("%-12s\t%d%n", row[0], lengthInt);
        }

        sc.close();
    }
}
