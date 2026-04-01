
import java.util.Scanner;

public class QuotientAndRemainderOfNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int quotient=num2/num1;
        int remainder=num2%num1;
        System.out.println("The Quotient is "+quotient+" and Remainder is "+remainder+" of two number "+num1+" and "+num2);
    }
}
