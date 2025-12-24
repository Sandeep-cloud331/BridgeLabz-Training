import java.util.Scanner;
import java.util.Random;

public class EligibleForVote {
    //method to generate random ages of students
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(20);
        }
        return ages;
    }
    // checking for eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }
    // displaying result
    public static void displayTable(String[][] data) {
        System.out.println("\nAge\tCan Vote");
        System.out.println("---\t--------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students between 1 to 10: ");
        int n = sc.nextInt();

        int[] studentAges = generateAges(n);
        String[][] eligibility = checkVotingEligibility(studentAges);
        displayTable(eligibility);

        sc.close();
    }
}
