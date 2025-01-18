import java.util.Scanner;


//Define props of book
public class Book {


    //feild variables
    String title, author;
    double price;

    //Constructor
    Book(String title , String author  ,double price )
    {
        this.title = title;
        this.author =author;
        this.price=price;
    }
	
	//Default constructor
	Book(){}



    //Display results
    public void display()
    {
        System.out.println("Book Name: "+title+ "\nAuthor: "+author+"\nxPrice:"+price);
    }
}

class Main
{
    public static void main(String[] args)
    {
     Scanner input = new Scanner(System.in);

     System.out.println("Enter Book Title");
     String title = input.next();
     System.out.println("Enter Author Name ");
    String author = input.next();
    System.out.println("Enter Book Price");
     double price = input.nextDouble();

     Book book = new Book(title, author, price);

     book.display();
    }


}
