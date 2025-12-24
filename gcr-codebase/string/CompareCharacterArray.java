import java.util.Scanner;

public class CompareCharacterArray {

    // Method to return character array
    static char[] getCharacters(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    // Method to compare two char arrays
    static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //string input
        String text = sc.next();

        // Get char arrays using both methods
        char[] manualArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();

        // Compare the arrays
        boolean areEqual = compareCharArrays(manualArray, builtInArray);

        // Display results
        System.out.print("Manual char array: [");
        for (int i = 0; i < manualArray.length; i++) {
            System.out.print("'" + manualArray[i] + "'");
            if (i < manualArray.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Built-in char array: [");
        for (int i = 0; i < builtInArray.length; i++) {
            System.out.print("'" + builtInArray[i] + "'");
            if (i < builtInArray.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Arrays are equal: " + areEqual);
    }
}
