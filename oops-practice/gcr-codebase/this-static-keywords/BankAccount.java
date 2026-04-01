public class BankAccount {
    // Static variable 
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;

    // Instance variables
    String accountHolderName;
    final int accountNumber;   

    // Constructor using 'this' keyword
    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    // Static method
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // Instance method to display details using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount acc = (BankAccount) obj;
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + acc.accountHolderName);
            System.out.println("Account Number: " + acc.accountNumber);
        } else {
            System.out.println("Not a BankAccount object");
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Nikhil", 101);
        BankAccount acc2 = new BankAccount("Aman", 102);

        acc1.displayDetails(acc1);
        System.out.println();

        acc2.displayDetails(acc2);
        System.out.println();

        BankAccount.getTotalAccounts();
    }
}
