import java.util.Scanner;

public class TotalPriceCalculation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the unit price and quantity");
        int unitPrice=sc.nextInt();
        int quantity=sc.nextInt();
        int totalPrice=unitPrice*quantity;
        System.out.println("The total purchase price is INR "+totalPrice+" if the quantity is "+quantity+" and unit price is INR "+unitPrice);
    }
}
