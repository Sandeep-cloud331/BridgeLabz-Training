import java.util.*;

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

class Bank{
    double balance;

    Bank(double balance){
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException{
        if(amount < 0){
            throw new IllegalArgumentException("Invalid amount!");
        }
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdraw successful!! New Balance: " + balance);
    }
}

public class BankSystem{
    public static void main(String[] args){
        Bank bank = new Bank(100);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter balance to withdraw: ");
        double amount = sc.nextDouble();

        try{
            bank.withdraw(amount);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid amount!");
        }
        catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
    }
}