import java.util.ArrayList;
import java.util.List;

// Employee class
class Employee {
    private String name;
    private String position;

    // Constructor
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee[Name: " + name + ", Position: " + position + "]";
    }
}

// Department class
class Department {
    private String name;
    private List<Employee> employees;

    // Constructor
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Add an employee to the department
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    // Display employees in the department
    public void displayEmployees() {
        System.out.println("Employees in Department: " + name);
        if (employees.isEmpty()) {
            System.out.println("No employees in this department.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public String toString() {
        return "Department[Name: " + name + ", Employees: " + employees.size() + "]";
    }
}

// Company class
class Company {
    private String name;
    private List<Department> departments;

    // Constructor
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Add a department to the company
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Add an employee to a specific department
    public void addEmployeeToDepartment(String departmentName, String employeeName, String position) {
        for (Department department : departments) {
            if (departmentName.equals(department.toString().split("["]")[1])) {
                department.addEmployee(employeeName, position);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    // Display all departments and their employees
    public void displayCompanyStructure() {
        System.out.println("Company: " + name);
        if (departments.isEmpty()) {
            System.out.println("No departments in the company.");
        } else {
            for (Department department : departments) {
                System.out.println(department);
                department.displayEmployees();
            }
        }
    }
}

// Main class to demonstrate composition
public class CompanyManagement {
    public static void main(String[] args) {
        // Create a company
        Company company = new Company("Tech Solutions Inc.");

        // Add departments
        company.addDepartment("Engineering");
        company.addDepartment("Human Resources");
        company.addDepartment("Marketing");

        // Add employees to departments
        company.addEmployeeToDepartment("Engineering", "Alice", "Software Engineer");
        company.addEmployeeToDepartment("Engineering", "Bob", "DevOps Engineer");
        company.addEmployeeToDepartment("Human Resources", "Charlie", "HR Manager");
        company.addEmployeeToDepartment("Marketing", "Diana", "Marketing Specialist");

        // Display company structure
        company.displayCompanyStructure();

        // Delete company (end of scope implies all departments and employees are also deleted)
        company = null;
        System.out.println("Company object is deleted. Departments and Employees no longer exist.");
    }
}
 
