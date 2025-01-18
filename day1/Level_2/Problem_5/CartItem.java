import java.util.*;

//Create a class to simulate a shopping cart
public class CartItem{
	//Define attributes
	private String itemName;
	private int price;
	private int quantity;

	//No args Constructor
	public CartItem(){}

	//All args Constructor
	public CartItem(String itemName, int price, int quantity){
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	//Add items to cart
	public boolean addItem(int price){

		//Ignore if argument is invalid
		if(price <= 0) return false;

		this.price += price;
		this.quantity++;

		//Return true if successful
		return true;
	}

	//Remove items from cart
	public boolean removeItem(int price){

		//Ignore if argument is invalid
		if(price <= 0) return false;

		this.price -= price;
		this.quantity--;

		//Return true if successful
		return true;
	}

	//return total price
	public int getTotalCost(){
		return this.price;
	}

}

class Main{
	public static void main(String[] args) {
		CartItem cartItem = new CartItem("Item1", 1200, 2);
		cartItem.addItem(100);
		cartItem.removeItem(200);
		int totalCost = cartItem.getTotalCost();
		System.out.println(totalCost);
	}
}