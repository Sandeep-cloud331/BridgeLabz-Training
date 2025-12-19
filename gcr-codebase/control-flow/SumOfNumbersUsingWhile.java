import java.util.Scanner;

public class SumOfNumbersUsingWhile {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num<0){
            System.out.println("The number "+num+" is not a natural number");
        }else{
            //sum of n natural numbers is n * (n+1) / 2
            double sum= (double) (num*(num-1))/2;
            double sumUsingWhile=0.0;
            num-=1;
            while(num>0){
                sumUsingWhile+=num;
                num--;
            }
            System.out.println("The sum of "+num+" natural numbers using formula "+sum+" and using while loop "+sumUsingWhile);
        }
    }
}
