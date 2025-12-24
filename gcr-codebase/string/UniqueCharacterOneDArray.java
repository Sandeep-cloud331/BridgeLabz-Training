import java.util.Scanner;

public class UniqueCharacterOneDArray {

    // Method to find unique characters
    public static char[] findUniqueChars(String text) {
        int len = text.length();
        char[] tempArray = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char currentChar = text.charAt(i);
            boolean isPresent = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        char[] uniqueArray = new char[uniqueCount];
        System.arraycopy(tempArray, 0, uniqueArray, 0, uniqueCount);
        return uniqueArray;
    }

    // Method to find frequency and return a 2D String array
    public static String[][] getFrequencyArray(String text) {
        int[] freqCount = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freqCount[text.charAt(i)]++;
        }
        char[] uniqueChars = findUniqueChars(text);
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]); // Character
            result[i][1] = String.valueOf(freqCount[uniqueChars[i]]); // Frequency
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = input.nextLine();
        String[][] frequencyData = getFrequencyArray(userInput);
        System.out.println("\nCharacter Frequency Table:");
        System.out.println("---------------------------");
        System.out.printf("%-12s | %-10s\n", "Character", "Frequency");
        System.out.println("---------------------------");
        for (String[] row : frequencyData) {
            String displayChar = row[0].equals(" ") ? "[Space]" : row[0];
            System.out.printf("%-12s | %-10s\n", displayChar, row[1]);
        }
        input.close();
    }
}