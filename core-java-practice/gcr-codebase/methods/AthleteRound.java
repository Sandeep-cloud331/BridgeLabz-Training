import java.util.Scanner;
public class AthleteRound {

    // method to find rounds
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input for distance 
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.println(calculateRounds(a, b, c));
    }
}
