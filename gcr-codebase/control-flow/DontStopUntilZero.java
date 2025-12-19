import java.util.Scanner;

public class DontStopUntilZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double total=0.0;
        double val=sc.nextDouble();
        while(val!=0){
            total+=val;
            val=sc.nextDouble();
        }
        System.out.println("Total value: "+total);
    }
}
