
import java.util.Scanner;

public class StudentGradePercentage {
    // Method to generate random 2-digit scores for PCM
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int)(Math.random() * 90 + 10);
            }
        }
        return scores;
    }

    // Method to calculate Total, Average, and Percentage
    public static double[][] calculateStats(int[][] scores) {
        double[][] score = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            score[i][0] = total;
            score[i][1] = Math.round(average * 100.0) / 100.0;
            score[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return score;
    }

    // Method to calculate Grade based on Percentage from the table
    public static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double perc = stats[i][2];
            if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B";
            else if (perc >= 60) grades[i] = "C";
            else if (perc >= 50) grades[i] = "D";
            else if (perc >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    // Method to display the scorecard in tabular format
    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.printf("%-10s %-5s %-5s %-5s %-8s %-8s %-12s %-5s\n",
                "Student", "Phy", "Che", "Mat", "Total", "Avg", "Percentage", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %-2d %-5d %-5d %-5d %-8.0f %-8.2f %-12.2f %-5s\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayScorecard(scores, stats, grades);
        input.close();
    }
}