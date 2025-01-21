//Bank Account System
public class BankAccount{
	
	//Counts the numbers of instances made
	private static long instances;
	
	//A static variable bankName shared across all accounts.
	public static final String BANK_NAME = "Global Bank";
	
	//Account Holder
	private String accountHolderName;
	
	//Used a final variable accountNumber to ensure it cannot be changed once assigned.
	public final String ACCOUNT_NUMBER;
	
	
	//All args constructor
	public BankAccount(String accountHolderName, String ACCOUNT_NUMBER){
		BankAccount.instances++;
		this.accountHolderName = accountHolderName;
		this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
	}
	
	//A static method  to display the total number of accounts.
	public static long getTotalAccounts(){
		return BankAccount.instances;
	} 
	
	//accountHolderName getter
	public String getAccountHolderName(){
		return this.accountHolderName;
	}
	
	//accountHolderName setter
	public void setAccountHolderName(String accountHolderName){
		this.accountHolderName = accountHolderName;
	}
	
	@Override
	public String toString(){
		return "ACCOUNT NUMBER: " + this.ACCOUNT_NUMBER + ", Account Holder Name: " + accountHolderName + " in " + 
		BankAccount.BANK_NAME;
	}
}

//Class Main 
class Main{
	//main method
	public static void main(String... args){
		BankAccount account1 = new BankAccount("User1", "019283438943");
		
		//Check if an account object is an instance of the BankAccount class before displaying its details.
		if(account1 instanceof BankAccount){
		System.out.println(account1);
		}
		
		var account2 = new BankAccount("User2","6514416548148");
		
		
		//Display total number of account holders
		System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
	}
}

