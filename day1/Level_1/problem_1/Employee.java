package problem_1;

//Program to Display Employee Details
public class Employee{
	 
	 //Uniquely identifies the employee
	 private Long id;
	 
	 //Employee name
	 private String name;
	 
	 //Employee salary
	 private int salary;
	 
	 
	 //Initialize the Employee
	 public Employee(Long id, String name, int salary){
		 this.name = name;
		 this.id = id;
		 this.salary = salary;
	 }
	 
	 //Default Constructor
	 public Employee(){}
	 
	 
	 //Set employee name
	 public void setName(String name){
		 this.name = name;
	 }
	 
	 
	 //set employee salary
	 public void setSalary(int salary){
		 this.salary = salary;
	 }
	 
	 
	 //get employee name
	 public String getName(){
		 return this.name;
	 }
	 
	 //get employee salary
	 public int getSalary(){
		 return this.salary;
	 }
	 
	 //To string
	 @Override
	 public String toString(){
		 return "Id: " + id + ", name: " + name + ", salary: " + salary;
	 }
 }
 
 
 class Main{
	 public static void main(String[] args){
		 
		 //Employee name
		 String employeeName = "Raju Raj";
		 
		 //Employee id
		 Long id = 123L;
		 
		 //Employee salary
		 int employeeSalary = 100000;
		 
		 //Initialize Employee
		 Employee employee = new Employee(id,employeeName,employeeSalary);
		 
		 System.out.println(employee);
	 }
 }
 