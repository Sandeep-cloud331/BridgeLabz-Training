public class BankAccount {

	// Class variables
	private String accountHolder;
	private String accountNumber;
	private double balance;
	
	// Constructor
	public BankAccount(String accountHolder,String accountNumber,double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	// Method for displaying bank name
	public static void displayBank() {
		System.out.println("\tState Bank Of India\t");
		
	}
	
	// Method to deopsit amount
	public void deposit(double amount) {
		if(amount > 0) {
			balance+=amount;
			System.out.println("Deposited: "+amount);
		}
		else {
			System.out.println("Amount to deposit must be positive");
		}
	}
	
	// Method to withdraw amount
	public void withdraw(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
			System.out.println("Withdraw amount is : "+amount);
		}
		else if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive");
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
	
	// Method to display balance
	public void displayBalance() {
    	System.out.println("Current balance: " + balance);
   }


	public static void main(String[] args) {

		// Object created
        BankAccount account = new BankAccount("Herry", "873856789", 700.00);
    
		// Calling methods
        displayBank();
		account.displayBalance();
    	account.deposit(200.00);
    	account.displayBalance();
    	account.withdraw(100.00);
    	account.displayBalance();
   		account.withdraw(900.00);
	}
}
