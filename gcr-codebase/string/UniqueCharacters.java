import java.util.Scanner;

public class UniqueCharacters {
    // find length of string
    public static int getLength(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            count++;
        }
        return count;
    }
    // find unique char
    public static char[] findUniqueChars(String text) {
        int len = getLength(text);
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();
        int length = getLength(userInput);
        char[] uniqueChars = findUniqueChars(userInput);
        System.out.println("Length: " + length);
        System.out.print("Unique Characters: ");
        for (char uniqueChar : uniqueChars) {
            System.out.print(uniqueChar + " ");
        }
        sc.close();
    }
}