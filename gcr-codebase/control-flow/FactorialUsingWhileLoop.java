import java.util.Scanner;

public class FactorialUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;
        while(n>=1){
            fact*=n;
            n--;
        }
        System.out.println("Factorial:"+fact);
    }
}
