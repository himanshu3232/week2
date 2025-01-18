import java.util.Scanner;


//Define class MobilePhone
public class MobilePhone {
	
	//Attributes
    String brand, model; double price;

	//Constructor
    MobilePhone(String brand, String model, double price )
    {
        this.brand = brand;
        this.model =model;
        this.price=price;
    }

	//Display results
    public void display( )
    {
     

        System.out.println("Price of Mobile brand  "+brand+ " Model Name "+model+" is "+price);
    }

}


//Main class
class Main
{
    public static void main(String ar[])
    {
     Scanner input = new Scanner(System.in);
 
     System.out.println("Enter Mobile Brand Name ");
     String brand = input.next();
     System.out.println("Enter Model Name ");
     String model = input.next(); 
     System.out.println("Enter Mobile Price");
     double price = input.nextDouble();

     MobilePhone mobilePhone = new MobilePhone(brand, model, price);
     


     mobilePhone.display();
    
    }
      

}
