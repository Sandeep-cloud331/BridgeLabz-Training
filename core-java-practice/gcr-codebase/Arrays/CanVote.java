import java.util.Scanner;
public class CanVote {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Define an array of size 10
        int[] ages = new int[10];

        // Take user input
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        System.out.println("\nVoting Eligibility Result:");

        // Check voting eligibility
        for (int i = 0; i < ages.length; i++) {

            if (ages[i] < 0) {
                System.out.println("Invalid age");
            } 
            else if (ages[i] >= 18) {
                System.out.println("The student with the age " + ages[i] + " can vote");
            } 
            else {
                System.out.println("The student with the age " + ages[i] + " cannot vote");
            }
        }

    }
}
