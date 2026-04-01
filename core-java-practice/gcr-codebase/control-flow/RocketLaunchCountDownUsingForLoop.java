import java.util.Scanner;

public class RocketLaunchCountDownUsingForLoop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int countDown=sc.nextInt();
        for(int i=countDown;i>=1;i--){
            System.out.println(i);
        }
    }
}
