import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your height in cm");
        int heightInCm=sc.nextInt();
        double heightInInches=(double)heightInCm/2.54;
        double heightInFoot=heightInInches/12;
        System.out.println("Your height in cm is "+heightInCm+" while in feet is "+heightInFoot+" and inches is "+heightInInches);
    }
}
