import java.util.Scanner;
public class LeapYearChecker {

    // method to check leap year
    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input for leap year
        int year = sc.nextInt();

        // results
        System.out.println(isLeapYear(year) ? "Leap Year" : "Not a Leap Year");
    }
}
