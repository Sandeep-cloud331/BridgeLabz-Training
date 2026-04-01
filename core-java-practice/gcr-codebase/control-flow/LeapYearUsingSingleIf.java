import java.util.Scanner;

public class LeapYearUsingSingleIf {
    static boolean isLeapYear(int year) {
        if (year < 1582) {
            System.out.println("Year must be >= 1582 {Gregorian calendar}");
            return false;
        }
        //the Leap Year is a Year divisible by 4 and not 100 unless it is divisible by 400
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        boolean isLeap=isLeapYear(year);
        System.out.println(year + (isLeap ? " is a Leap Year" : " is not a Leap Year"));
    }
}
