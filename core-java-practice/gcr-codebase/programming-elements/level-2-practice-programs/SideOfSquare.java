import java.util.Scanner;
public class SideOfSquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the parameter");
        int parameter=sc.nextInt(); // parameter=4*side
        double side= (double) parameter /4;
        System.out.println("The length of the side is "+side+" whose perimeter is "+parameter);

    }
}
