import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product[Name: " + name + ", Price: $" + price + "]";
    }
}

// Order class
class Order {
    private int orderId;
    private List<Product> products;

    // Constructor
    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    // Add a product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Display all products in the order
    public void displayProducts() {
        System.out.println("Order ID: " + orderId);
        if (products.isEmpty()) {
            System.out.println("No products in this order.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Place an order
    public void placeOrder(Order order) {
        orders.add(order);
    }

    // Display all orders placed by the customer
    public void displayOrders() {
        System.out.println("Orders placed by: " + name);
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getOrderId() + ", Total: $" + order.calculateTotalPrice());
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Main class to demonstrate relationships
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        // Create a customer
        Customer customer = new Customer("John Doe");

        // Create an order and add products
        Order order1 = new Order(1);
        order1.addProduct(product1);
        order1.addProduct(product2);

        // Place the order
        customer.placeOrder(order1);

        // Create another order
        Order order2 = new Order(2);
        order2.addProduct(product3);

        // Place the second order
        customer.placeOrder(order2);

        // Display customer orders
        customer.displayOrders();

        // Display products in each order
        order1.displayProducts();
        order2.displayProducts();
    }
}
 
