import java.util.Scanner;

//Checks if a string is palindrome
public class PalindromeChecker{

	//Field attribute
	private String text;
	
	//Constructor1
	public PalindromeChecker(){}
	
	//Constructor2
	public PalindromeChecker(String text){
		this.text = text;
	}
	
	//Check palindrome here
	private boolean checkPalindrome(){
		int s = 0;
		int e = this.text.length()-1;
		
		while(s<e){
			if(this.text.charAt(s) != this.text.charAt(e)) return false;
			s++;
			e--;
		}
		return true;
	}
	
	//Print result
	public void getResult(){
		String result = checkPalindrome() ? " is palindrome" : " is not palindrome";
		System.out.println("The text " + text + result);
	}
}

class Main{
	public static void main(String[] args){
	
		//Get input
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		sc.close();
		
		//Make object
		PalindromeChecker palindrome = new PalindromeChecker(text);
		
		//Print result
		palindrome.getResult();
	}
}