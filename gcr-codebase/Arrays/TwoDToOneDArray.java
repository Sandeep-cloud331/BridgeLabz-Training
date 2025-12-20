import java.util.Scanner;
public class TwoDToOneDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take rows and columns input
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        // Create 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        // Take matrix input
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Create 1D array
        int[] array = new int[rows * columns];
        int index = 0;

        // Copy 2D array elements to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display 1D array
        System.out.println("1D Array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
