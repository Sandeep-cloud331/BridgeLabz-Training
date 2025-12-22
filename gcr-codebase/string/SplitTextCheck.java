import java.util.Scanner;
public class SplitTextCheck {

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

        // count words
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // store space indexes
        int[] spaceIndex = new int[wordCount - 1];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }

        // extract words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndex.length; i++) {
            String word = "";
            for (int j = start; j < spaceIndex[i]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
            start = spaceIndex[i] + 1;
        }

        // last word
        String lastWord = "";
        for (int i = start; i < len; i++) {
            lastWord = lastWord + text.charAt(i);
        }
        words[wordCount - 1] = lastWord;

        return words;
    }

    // compare two string arrays
    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input 
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] customSplit = splitUsingCharAt(text);
        String[] builtInSplit = text.split(" ");

        // method calling
        boolean result = compareArrays(customSplit, builtInSplit);

        System.out.println("Words using charAt():");
        for (String w : customSplit) {
            System.out.println(w);
        }

        // Output
        System.out.println("Are both split results same? " + result);
    }
}
