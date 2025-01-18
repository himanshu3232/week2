class Main{
	 public static void main(String[] args){
		 Circle circle = new Circle(9.8);
		 System.out.println(circle);
	 }
 }

 // Add methods to calculate and display the area and circumference of the circle.
 
 //Program to Compute Area of a Circle
public class Circle{
	//radius attribute
	private double radius;
	
	//Constructor1
	public Circle(double radius){
		//Constructor chaining 
		this();
		
		this.radius = radius;
	}
	
	//Default constructor
	public Circle(){
		//Default value
		this.radius = 10;
	}


	 //Getter
	 public double getRadius() {
		 return radius;
	 }

	 //Setter
	 public void setRadius(double radius) {
		 this.radius = radius;
	 }

	 //Calculate area of circle
	 public double getArea(){
		return Math.PI * radius * radius;
	 }

	 //Calculate circumference
	 public double getCircumference(){
		return 2 * Math.PI * radius;
	 }

	 //To String
	 @Override
	 public String toString(){
		return "Radius is " + radius + " Area is : " + getArea() + " and Circumference is : " + getCircumference();
	 }
 }