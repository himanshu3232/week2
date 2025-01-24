// Base class: Order
class Order {
    private String orderId;
    private String orderDate;

    // Constructor
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Getter methods
    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    // Method to get order status
    public String getOrderStatus() {
        return "Order Placed";
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    private String trackingNumber;

    // Constructor
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Getter method
    public String getTrackingNumber() {
        return trackingNumber;
    }

    // Overriding getOrderStatus method
    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}

// Subclass: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    // Constructor
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // Getter method
    public String getDeliveryDate() {
        return deliveryDate;
    }

    // Overriding getOrderStatus method
    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }
}

// Main class to test the hierarchy
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        // Creating objects for each class
        Order order = new Order("ORD123", "2025-01-22");
        ShippedOrder shippedOrder = new ShippedOrder("ORD124", "2025-01-22", "TRK56789");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", "2025-01-22", "TRK67890", "2025-01-24");

        // Displaying details and statuses
        System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getOrderStatus());
        System.out.println("Order ID: " + shippedOrder.getOrderId() + ", Tracking Number: " + shippedOrder.getTrackingNumber() + ", Status: " + shippedOrder.getOrderStatus());
        System.out.println("Order ID: " + deliveredOrder.getOrderId() + ", Tracking Number: " + deliveredOrder.getTrackingNumber() + ", Delivery Date: " + deliveredOrder.getDeliveryDate() + ", Status: " + deliveredOrder.getOrderStatus());
    }
}
