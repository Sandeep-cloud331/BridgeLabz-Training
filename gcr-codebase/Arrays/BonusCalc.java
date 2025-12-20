import java.util.*;
public class BonusCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays to store salary, experience, bonus, and updated salary of employees
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0, totalOld = 0, totalNew = 0;

        // Taking salary and years of experience input for 10 employees
        for (int i = 0; i < 10; ) {
            System.out.println("Enter the salary : ");
            double s = sc.nextDouble();
            System.out.println("Enter the experience : ");
            double y = sc.nextDouble();

            // Validate input to avoid negative salary or experience
            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            salaries[i] = s;
            years[i] = y;
            i++;
        }

        // Calculating bonus based on experience and updating total values
        for (int i = 0; i < 10; i++) {
            if (years[i] > 5) {
                bonus[i] = salaries[i] * 0.05;
            } else {
                bonus[i] = salaries[i] * 0.02;
            }

            newSalaries[i] = salaries[i] + bonus[i];
            totalBonus += bonus[i];
            totalOld += salaries[i];
            totalNew += newSalaries[i];
        }

        // Displaying final calculated results
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOld);
        System.out.println("Total New Salary = " + totalNew);
    }
}
