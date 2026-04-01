import java.util.Scanner;
public class CoffeeCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean decision = true;

        // while loop helps in asking again and again until exit 
        while(decision){

            int price, quantity;
            double GST, totalPrice;

            
            System.out.print("Enter the type of Coffee : ");
            String coffeeType = sc.nextLine(); // Input the Coffee user wants
            
            
            if(decision){

        
                switch(coffeeType){
                    case "Latte" :  // Case for every type of coffee
                        price = 150;
                        System.out.print("One Latte cup cost for 150 \nEnter the quantity : ");
                        quantity = sc.nextInt(); // User input for quantity of coffee
                        sc.nextLine();
                        GST = (0.18*(price*quantity)); // Added GST 
                        totalPrice = GST + (price*quantity);
                        System.out.println("Your calculated bill is "+(totalPrice)+" for "+quantity+" "+coffeeType); // Output the result 
                        break;
                    case "Espresso" :
                        price = 160;
                        System.out.print("One Espresso cup cost for 160 \nEnter the quantity : ");
                        quantity = sc.nextInt();
                        sc.nextLine();
                        GST = (0.18*(price*quantity));
                        totalPrice = GST + (price*quantity);
                        System.out.println("Your calculated bill is "+(totalPrice)+" for "+quantity+" "+coffeeType);
                        break;
                    case "Cold Coffee" :
                        price = 140;
                        System.out.print("One Cold Coffee cup cost for 140 \nEnter the quantity : ");
                        quantity = sc.nextInt();
                        sc.nextLine();
                        GST = (0.18*(price*quantity));
                        totalPrice = GST + (price*quantity);
                        System.out.println("Your calculated bill is "+(totalPrice)+" for "+quantity+" "+coffeeType);
                        break;
                    case "Hot Coffee" :
                        price = 110;
                        System.out.print("One Hot Coffee cup cost for 110 \nEnter the quantity : ");
                        quantity = sc.nextInt();
                        sc.nextLine();
                        GST = (0.18*(price*quantity));
                        totalPrice = GST + (price*quantity);
                        System.out.println("Your calculated bill is "+(totalPrice)+" for "+quantity+" "+coffeeType);
                        break;
                    default : 
                        System.out.println("\nSorry this is not available now!! \nYou can choose another");
                }
            }
            else{
                break;
            }

            System.out.println("What's next \n1. new customer \n2. exit  ");
            int next = sc.nextInt();  // Ask for new user or want to exit
            sc.nextLine();
            if(next == 2) decision = false;

        }
    }
} 