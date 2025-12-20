import java.util.Scanner;
public class MeanHeightOfPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an array of size 11
        double[] heights = new double[11];

        double sum = 0.0;

        // Get height input 
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Calculate the sum of all heights
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Calculate mean height
        double mean = sum / heights.length;

        
        System.out.println("\nMean height of the football team = " + mean);

    }
}
