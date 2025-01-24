//A superclass Animal with attributes name and age, and a method makeSound()
public abstract class Animal{
	
	//instance variables
	protected String name;
    protected int age;	
	
	Animal(){}
	Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//property
	protected abstract void makeSound();
}

class Dog extends Animal{
	
	Dog(){}
	
	Dog(String name, int age){
		super(name,age);
	}
	
	//unique implementation of makeSound()
	@Override
	protected void makeSound(){
		System.out.println("Bark");
	}
}
class Cat extends Animal{
	
	Cat(){}
	
	Cat(String name, int age){
		super(name,age);
	}
	
	//unique implementation of makeSound()
	@Override
	protected void makeSound(){
		System.out.println("Meow");
	}
}
class Bird extends Animal{
	
	//unique implementation of makeSound()
	
	@Override
	protected void makeSound(){
		System.out.println("Chirp");
	}
}

class Main{
	public static void main(String[] args){
		Animal dog = new Dog("Kuku", 8);
		Animal cat = new Cat("Khushi",5);
		
		dog.makeSound();
		cat.makeSound();
	}
}
