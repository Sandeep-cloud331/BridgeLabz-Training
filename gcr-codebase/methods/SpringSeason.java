import java.util.Scanner;
public class SpringSeason {

    // method to whether a date is in spring season or not 
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20 && day <= 31) ||
                (month == 4 && day >= 1 && day <= 30) ||
                (month == 5 && day >= 1 && day <= 31) ||
                (month == 6 && day >= 1 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input for month and day
        int month = sc.nextInt();
        int day = sc.nextInt();

        // output the result
        if (isSpringSeason(month, day)) {
            System.out.println("It is Spring Season.");
        } else {
            System.out.println("Not a spring Season");
        }
    }

}
