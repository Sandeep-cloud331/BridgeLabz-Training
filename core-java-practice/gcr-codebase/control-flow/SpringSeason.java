import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        int date=sc.nextInt();
        boolean isSpring = (month == 3 && date >= 20 && date <= 31) ||
                           (month == 4 && date >= 1 && date <= 30) ||
                           (month == 5 && date >= 1 && date <= 31) ||
                           (month == 6 && date >= 1 && date <= 20);
        if(isSpring){
            System.out.println("It's a Spring Season");
        }else{
            System.out.println("It's not a Spring Season");
        }
    }
}
