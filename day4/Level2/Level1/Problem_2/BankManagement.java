import java.util.ArrayList;
import java.util.List;

// Bank class
class Bank {
    private String name;
    private List<Account> accounts;

    // Constructor
    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Method to open a new account
    public void openAccount(Customer customer, double initialBalance) {
        Account newAccount = new Account(customer, this, initialBalance);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.println("Account opened for " + customer.getName() + " with initial balance: " + initialBalance);
    }

    // Method to display all accounts in the bank
    public void displayAccounts() {
        System.out.println("Accounts in " + name + ":");
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Account> accounts;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Method to add an account to the customer
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to view all accounts and their balances
    public void viewBalance() {
        System.out.println("Accounts for customer: " + name);
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Account class
class Account {
    private Customer customer;
    private Bank bank;
    private double balance;

    // Constructor
    public Account(Customer customer, Bank bank, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account[Customer: " + customer.getName() + ", Bank: " + bank.getName() + ", Balance: " + balance + "]";
    }
}

// Main class to demonstrate association
public class BankManagement {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("National Bank");

        // Create customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Open accounts for customers
        bank.openAccount(customer1, 5000.0);
        bank.openAccount(customer2, 3000.0);
        bank.openAccount(customer1, 2000.0); // Alice opens another account

        // Display accounts in the bank
        bank.displayAccounts();

        // Customers view their balances
        customer1.viewBalance();
        customer2.viewBalance();
    }
}
 
