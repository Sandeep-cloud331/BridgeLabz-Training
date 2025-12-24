import java.util.Scanner;
public class SimpleInterest {

    // method declaration to calculate simple interest as per input data
    private static void simpleInterest(int principal, double rate, double year) {
        double simpleInterest = (principal * rate * year) / 100;
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal +
                ", Rate of Interest " + rate + " and Time " + year + " years");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get the principal amount from the user
        System.out.print("Enter principal amount: ");
        int principal = input.nextInt();

        // get the rate of interest from the user
        System.out.print("Enter rate of interest: ");
        double rate = input.nextDouble();

        // get the time from the user
        System.out.print("Enter number of years: ");
        double year = input.nextDouble();

        // calling the method
        simpleInterest(principal, rate, year);

        input.close();
    }
}