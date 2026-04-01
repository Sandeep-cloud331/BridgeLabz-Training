import java.util.*;

public class IntegerDivision{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by zero!");
        }
        finally{
            System.out.println("Operation completed!");
        }
    }
}