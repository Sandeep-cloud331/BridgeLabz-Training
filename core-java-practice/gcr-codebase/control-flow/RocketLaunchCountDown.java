import java.util.Scanner;

public class RocketLaunchCountDown {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int countDown=sc.nextInt();
        while(countDown>=1){
            System.out.println(countDown);
            countDown--;
        }
    }
}
