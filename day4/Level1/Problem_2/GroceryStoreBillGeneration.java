import java.util.ArrayList;
import java.util.List;

class Product {
    int price;
    int quantity;
    private String productName;

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }
}

class Customer {
    private String customerName;
    private List<Product> products;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }

    public void addItem(Product product) {
        products.add(product);
    }

    public void removeItem(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class BillGenerator {
    public void generateBill(Customer customer) {
        List<Product> products = customer.getProducts();
        int totalBill = 0;

        System.out.println("Bill for Customer: " + customer.getCustomerName());
        System.out.println("---------------------------------");
        System.out.println("Product\t\tPrice\t\tQuantity\tTotal");

        for (Product product : products) {
            int totalPrice = product.price * product.quantity;
            totalBill += totalPrice;

            System.out.println(product.getProductName() + "\t\t" + product.price + "\t" + product.quantity + "\t\t" + totalPrice);
        }

        System.out.println("---------------------------------");
        System.out.println("Total Bill: " + totalBill);
    }
}

public class GroceryStoreBillGeneration {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");

        Product product1 = new Product("Apple", 100, 2);
        Product product2 = new Product("Milk", 50, 1);
        Product product3 = new Product("Bread", 40, 3);

        customer.addItem(product1);
        customer.addItem(product2);
        customer.addItem(product3);

        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(customer);
    }
}
 
