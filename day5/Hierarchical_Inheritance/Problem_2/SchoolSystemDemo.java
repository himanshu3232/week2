// Base class
class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Method to display role (to be overridden by subclasses)
    public void displayRole() {
        System.out.println("This is a general person.");
    }
}

// Subclass for Teacher
class Teacher extends Person {
    private String subject;

    // Constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Override displayRole method
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }

    // Display specific teacher details
    public void displaySubject() {
        System.out.println("Subject: " + subject);
    }
}

// Subclass for Student
class Student extends Person {
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // Override displayRole method
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    // Display specific student details
    public void displayGrade() {
        System.out.println("Grade: " + grade);
    }
}

// Subclass for Staff
class Staff extends Person {
    private String department;

    // Constructor
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Override displayRole method
    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
    }

    // Display specific staff details
    public void displayDepartment() {
        System.out.println("Department: " + department);
    }
}

// Main class to test the hierarchy
public class SchoolSystemDemo {
    public static void main(String[] args) {
        // Create instances for each role
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        Student student = new Student("Bob", 16, "10th Grade");
        Staff staff = new Staff("Charlie", 40, "Administration");

        // Display details for Teacher
        teacher.displayDetails();
        teacher.displayRole();
        teacher.displaySubject();
        System.out.println();

        // Display details for Student
        student.displayDetails();
        student.displayRole();
        student.displayGrade();
        System.out.println();

        // Display details for Staff
        staff.displayDetails();
        staff.displayRole();
        staff.displayDepartment();
    }
}
