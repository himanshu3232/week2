// Superclass
class Person {
    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface for Worker
interface Worker {
    void performDuties(); // Method to be implemented by workers
}

// Subclass Chef that inherits from Person and implements Worker
class Chef extends Person implements Worker {
    private String specialty;

    // Constructor
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    // Implement performDuties method
    @Override
    public void performDuties() {
        System.out.println("Performing duties: Cooking delicious meals.");
    }

    // Method to display chef-specific details
    public void displaySpecialty() {
        System.out.println("Specialty: " + specialty);
    }
}

// Subclass Waiter that inherits from Person and implements Worker
class Waiter extends Person implements Worker {
    private String assignedSection;

    // Constructor
    public Waiter(String name, int id, String assignedSection) {
        super(name, id);
        this.assignedSection = assignedSection;
    }

    // Implement performDuties method
    @Override
    public void performDuties() {
        System.out.println("Performing duties: Serving customers and taking orders.");
    }

    // Method to display waiter-specific details
    public void displaySection() {
        System.out.println("Assigned Section: " + assignedSection);
    }
}

// Main class to test the implementation
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Create instances of Chef and Waiter
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 201, "Outdoor Section");

        // Display Chef details and duties
        System.out.println("Chef Details:");
        chef.displayDetails();
        chef.displaySpecialty();
        chef.performDuties();
        System.out.println();

        // Display Waiter details and duties
        System.out.println("Waiter Details:");
        waiter.displayDetails();
        waiter.displaySection();
        waiter.performDuties();
    }
}
