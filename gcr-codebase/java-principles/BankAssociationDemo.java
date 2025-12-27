import java.util.ArrayList;

// Account class
class Account {
    int accountNumber;
    double balance;
    Bank bank;

    Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    void showAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Bank: " + bank.bankName);
        System.out.println("Balance: Rs." + balance);
    }
}

// Customer class
class Customer {
    String customerName;
    ArrayList<Account> accounts = new ArrayList<>();

    Customer(String customerName) {
        this.customerName = customerName;
    }

    void addAccount(Account account) {
        accounts.add(account);
    }

    void viewBalance() {
        System.out.println("Customer: " + customerName);
        for (Account acc : accounts) {
            acc.showAccountDetails();
            System.out.println();
        }
    }
}

// Bank class
class Bank {
    String bankName;
    ArrayList<Customer> customers = new ArrayList<>();

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Customer customer, int accountNumber, double balance) {
        Account account = new Account(accountNumber, balance, this);
        customer.addAccount(account);
        customers.add(customer);

        System.out.println("Account opened for " + customer.customerName +
                " in " + bankName);
    }
}

// Main class
public class BankAssociationDemo {
    public static void main(String[] args) {

        Bank bank = new Bank("State Bank of India");

        Customer c1 = new Customer("Nikhil");
        Customer c2 = new Customer("Aman");

        bank.openAccount(c1, 101, 5000);
        bank.openAccount(c1, 102, 15000);
        bank.openAccount(c2, 201, 10000);

        System.out.println("\n--- Account Details ---\n");

        c1.viewBalance();
        c2.viewBalance();
    }
}
