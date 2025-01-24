// Base class
class BankAccount {
    private String accountNumber;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // Method to display account type (to be overridden in subclasses)
    public void displayAccountType() {
        System.out.println("This is a generic bank account.");
    }
}

// Subclass for Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Display specific account type
    @Override
    public void displayAccountType() {
        System.out.println("This is a Savings Account.");
    }

    // Method to calculate interest
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Calculated Interest: " + interest);
    }
}

// Subclass for Checking Account
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    // Constructor
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Display specific account type
    @Override
    public void displayAccountType() {
        System.out.println("This is a Checking Account.");
    }

    // Method to display withdrawal limit
    public void displayWithdrawalLimit() {
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

// Subclass for Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    private int depositTerm; // in months

    // Constructor
    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    // Display specific account type
    @Override
    public void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account.");
    }

    // Method to display deposit term
    public void displayDepositTerm() {
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

// Main class to test the implementation
public class BankSystemDemo {
    public static void main(String[] args) {
        // Create instances of different account types
        SavingsAccount savingsAccount = new SavingsAccount("SA12345", 10000, 4.5);
        CheckingAccount checkingAccount = new CheckingAccount("CA67890", 5000, 1000);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD54321", 20000, 12);

        // Display details of each account
        savingsAccount.displayAccountDetails();
        savingsAccount.displayAccountType();
        savingsAccount.calculateInterest();
        System.out.println();

        checkingAccount.displayAccountDetails();
        checkingAccount.displayAccountType();
        checkingAccount.displayWithdrawalLimit();
        System.out.println();

        fixedDepositAccount.displayAccountDetails();
        fixedDepositAccount.displayAccountType();
        fixedDepositAccount.displayDepositTerm();
    }
}
