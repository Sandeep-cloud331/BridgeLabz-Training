import java.util.*;

public class NestedTryCatch{
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        try{
            int idx = sc.nextInt();
            try{
                int divisor = sc.nextInt();
                System.out.println("Result: " + arr[idx]/divisor);
            }
            catch(ArithmeticException e){
                System.out.println("Cannot divide by zero!");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid array index!");
        }
    }
}