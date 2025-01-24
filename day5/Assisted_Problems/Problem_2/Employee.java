//An Employee hierarchy for different employee types such as Manager, Developer, and Intern.
public abstract class Employee{
	
	//instance vars
	protected static Long serial = 0L;
	protected Long id;
	protected String name;
	protected int salary;
	
	//No args constructor
	Employee(){
		this.id = ++serial;
	}
	
	//All args constructor
	Employee(String name, int salary){
		this();
		this.name = name;
		this.salary = salary;
	}
	
	//abstract method
	protected abstract void displayDetails();
} 

//subclass Manager
class Manager extends Employee{
	//Unique attribute
	private int teamSize;
	
	//No args constructor
	Manager(){}
	
	//All args constructor
	Manager(String name, int salary, int teamSize){
		super(name,salary);
		this.teamSize = teamSize;
	}
	
	@Override
	protected void displayDetails(){
		System.out.println(" id: " + this.id + " Name: " + this.name + " salary: " + salary
		+ " teamSize: " + teamSize);
	}
}
//subclass Developer
class Developer extends Employee{
	//Unique attribute
	private String programmingLanguage;
	
	//No args constructor
	Developer(){}
	
	//All args constructor
	Developer(String name, int salary, String programmingLanguage){
		super(name,salary);
		this.programmingLanguage = programmingLanguage;
	}
	
	@Override
	protected void displayDetails(){
		System.out.println(" id: " + this.id + " Name: " + this.name + " salary: " + salary
		+ " programmingLanguage: " + programmingLanguage);
	}
}

//subclass Intern
class Intern extends Employee{	
	//No args constructor
	Intern(){}
	
	//All args constructor
	Intern(String name, int salary){
		super(name,salary);
	}
	
	@Override
	protected void displayDetails(){
		System.out.println(" id: " + this.id + " Name: " + this.name + " salary: " + salary);
	}
}

class Main{
	public static void main(String[] args){
		Employee emp1 = new Manager("Subham", 1000, 10);
		Employee emp2 = new Developer("Shriyansh", 10, "Java");
		Employee emp3 = new Intern("Aman", 2000);
		
		emp1.displayDetails();
		emp2.displayDetails();
		emp3.displayDetails();
		
	}
}
