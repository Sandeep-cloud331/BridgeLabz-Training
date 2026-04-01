import java.util.*;

public class ExceptionPropagation{

    static void simpleInterest(double amount, double rate, int time) throws IllegalArgumentException{
        if(amount < 0 || rate < 0 || time < 0){
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive.");
        }
        System.out.println("Simple Interest: " + (amount*rate*time/100));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        System.out.println("Enter rate: ");
        double rate = sc.nextDouble();
        System.out.println("Enter time");
        int time = sc.nextInt();

        try{
            simpleInterest(amount, rate, time);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}