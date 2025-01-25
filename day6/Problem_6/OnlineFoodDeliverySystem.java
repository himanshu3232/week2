import java.util.*;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and Setter methods
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double discountPercentage);

    double getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - (getPrice() * getQuantity() * (discount / 100));
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
        System.out.println("Discount of " + discountPercentage + "% applied to VegItem.");
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private static final double ADDITIONAL_CHARGE = 50.0; // Additional charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double basePrice = (getPrice() * getQuantity()) + (ADDITIONAL_CHARGE * getQuantity());
        return basePrice - (basePrice * (discount / 100));
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
        System.out.println("Discount of " + discountPercentage + "% applied to NonVegItem.");
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Create a list of food items
        List<FoodItem> order = new ArrayList<>();

        // Add food items to the order
        order.add(new VegItem("Paneer Butter Masala", 200.0, 2));
        order.add(new NonVegItem("Chicken Biryani", 300.0, 1));

        // Process the order
        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());

            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                discountable.applyDiscount(10.0); // Apply 10% discount
                System.out.println("Discount Applied: " + discountable.getDiscountDetails() + "%");
            }

            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println("-----------------------------------");
        }
    }
}
