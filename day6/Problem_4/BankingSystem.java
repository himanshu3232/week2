import java.util.*;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getter and Setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);

    boolean calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04;
    private double minimumBalance;

    public SavingsAccount(String accountNumber, String holderName, double balance, double minimumBalance) {
        super(accountNumber, holderName, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= minimumBalance;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 50000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts typically do not earn interest
    }

    public boolean hasOverdraft() {
        return getBalance() < 0 && Math.abs(getBalance()) <= OVERDRAFT_LIMIT;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        // Create a list of bank accounts
        List<BankAccount> accounts = new ArrayList<>();

        // Add accounts
        accounts.add(new SavingsAccount("SA123", "Alice", 50000, 10000));
        accounts.add(new CurrentAccount("CA456", "Bob", 20000));

        // Process accounts
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());

            if (account instanceof SavingsAccount) {
                SavingsAccount savings = (SavingsAccount) account;
                System.out.println("Interest: " + savings.calculateInterest());
                savings.applyForLoan(20000);
                System.out.println("Loan Eligibility: " + savings.calculateLoanEligibility());
            } else if (account instanceof CurrentAccount) {
                CurrentAccount current = (CurrentAccount) account;
                System.out.println("Overdraft Available: " + current.hasOverdraft());
            }

            System.out.println("-----------------------------------");
        }
    }
}
