import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the height and base in cm");
        int height=sc.nextInt();
        int base=sc.nextInt();
        double heightInInches=(double)height/2.54;
        double heightInFoot=heightInInches/12;
        double baseInInches=(double)base/2.54;
        double baseInFoot=baseInInches/12;
        double areaInCm=(1.0/2.0)*base*height;
        double areaInInches=(1.0/2.0)*baseInInches*heightInInches;
        double areaInFoot=(1.0/2.0)*baseInFoot*baseInFoot;
        System.out.println("Your area in cm is "+areaInCm+" while in feet is "+areaInFoot+" and inches is "+areaInInches);
    }
}
