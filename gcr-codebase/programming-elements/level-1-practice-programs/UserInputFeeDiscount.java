import java.util.Scanner;

public class UserInputFeeDiscount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter fee amount");
        int fee=sc.nextInt();
        System.out.println("Enter discount");
        int discountPercent=sc.nextInt();
        int discount=(fee/100)*10;
        int feeAfterDiscount=fee-discount;
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+feeAfterDiscount);
    }
}
