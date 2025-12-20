import java.util.Scanner;
public class FriendStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays of names, ages and heights
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3]; 

        for (int i = 0; i < 3; i++) {
            System.out.print("Age: ");
            ages[i] = sc.nextInt();
            System.out.print("Height (in cm): ");
            heights[i] = sc.nextDouble();
        }

        // Find the youngest
        int minAgeIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }

        // Find the tallest
        int maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }

        // Prints the result
        System.out.println("Youngest Friend: " + names[minAgeIndex] + " (Age: " + ages[minAgeIndex] + ")");
        System.out.println("Tallest Friend: " + names[maxHeightIndex] + " (Height: " + heights[maxHeightIndex] + " cm)");
    }
}
