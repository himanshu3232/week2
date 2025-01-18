
//Describe a person and some of its attributes
public class Person{
	private String name;
	private int age;
	private String domicile;
	private Person father;
	private Person mother;
	
	//Default constructor
	public Person(){
		this.age = -1;
	}
	
	//All args constructor
	public Person(String name, int age, String domicile, Person father, Person mother){
		this();
		this.name = name;
		this.age = age;
		this.domicile = domicile;
		this.father = father;
		this.mother = mother;
	}
	
	//Required args constructor
	public Person(String name, Person father, Person mother){
		this();
		this.name = name;
		this.father = father;
		this.mother = mother;
	}
	
	public Person(String name, int age){
		this();
		this.name = name;
		this.age = age;
	}
	
	//Copy constructor
	public Person(Person person){
		this();
		this.name = person.name;
		this.age = person.age;
		this.domicile = person.domicile;
		this.father = person.father;
		this.mother = person.mother;
	}
	
	@Override
	public String toString(){
		if(this.name == null) return "Person is null";
		else if(this.age < 0) return "Person " + this.name + " has invalid age";
		
		return "Person name: " + this.name + " , age: " + age + " , domicile: " + domicile
		+ " ,father: " + father + " , mother: " + mother;
	}
}

class Main{
	public static void main(String[] args){
		Person father = new Person("Father", 40);
		Person mother = new Person("Mother", 37);
		Person twin1 = new Person("Twin", 10, null, father, mother);
		Person twin2 = new Person(twin1);
		
		System.out.println(twin1);
		System.out.println(twin2);
	}
}