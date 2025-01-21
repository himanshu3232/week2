//Shopping Cart System
public class Product{
    //A static variable  shared by all products.
    private static double discount;
    private String productName;
    private double price;
    private int quantity;

    //All args constructor
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    //getter
    public int getQuantity() {
        return quantity;
    }

    //setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getter
    public double getPrice() {
        return price;
    }

    //setter
    public void setPrice(double price) {
        this.price = price;
    }

    //getter
    public String getProductName() {
        return productName;
    }

    //get discount
    public static double getDiscount() {
        return discount;
    }

    //A static method updateDiscount() to modify the discount percentage.
    public static void updateDiscount(double discount) {
        Product.discount = discount;
    }

    //setter
    public void setProductName(String productName) {
        this.productName = productName;
    }

    //toString
    @Override
    public String toString(){
        return "Product name: " + productName + " , price: " + String.format("%.2f",price) + " , discount: " +
                String.format("%.2f",discount) + " , quantity: " + quantity;
    }
}

class Main{
    public static void main(String[] args) {

        //set initial discount
        Product.updateDiscount(5.5);
        //String productName, double price, int quantity
        Product product1 = new Product("Brush", 45.55, 1686);
		System.out.println(product1);
    }
}
