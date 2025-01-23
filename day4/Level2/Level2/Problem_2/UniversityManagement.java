import java.util.ArrayList;
import java.util.List;

// Faculty class
class Faculty {
    private String name;
    private String designation;

    // Constructor
    public Faculty(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Faculty[Name: " + name + ", Designation: " + designation + "]";
    }
}

// Department class
class Department {
    private String name;
    private List<Faculty> facultyMembers;

    // Constructor
    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    // Add a faculty member to the department
    public void addFaculty(Faculty faculty) {
        if (!facultyMembers.contains(faculty)) {
            facultyMembers.add(faculty);
        }
    }

    // Display all faculty members in the department
    public void displayFaculty() {
        System.out.println("Faculty members in Department: " + name);
        if (facultyMembers.isEmpty()) {
            System.out.println("No faculty members in this department.");
        } else {
            for (Faculty faculty : facultyMembers) {
                System.out.println(faculty);
            }
        }
    }

    @Override
    public String toString() {
        return "Department[Name: " + name + ", Faculty Members: " + facultyMembers.size() + "]";
    }
}

// University class
class University {
    private String name;
    private List<Department> departments;

    // Constructor
    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Add a department to the university
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Add a faculty member to a specific department
    public void addFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department department : departments) {
            if (departmentName.equals(department.toString().split("["]")[1])) {
                department.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    // Display all departments and their faculty members
    public void displayUniversityStructure() {
        System.out.println("University: " + name);
        if (departments.isEmpty()) {
            System.out.println("No departments in the university.");
        } else {
            for (Department department : departments) {
                System.out.println(department);
                department.displayFaculty();
            }
        }
    }
}

// Main class to demonstrate composition and aggregation
public class UniversityManagement {
    public static void main(String[] args) {
        // Create a university
        University university = new University("Global University");

        // Add departments to the university
        university.addDepartment("Computer Science");
        university.addDepartment("Physics");

        // Create faculty members
        Faculty faculty1 = new Faculty("Dr. Alice", "Professor");
        Faculty faculty2 = new Faculty("Dr. Bob", "Associate Professor");
        Faculty faculty3 = new Faculty("Dr. Charlie", "Lecturer");

        // Add faculty members to departments
        university.addFacultyToDepartment("Computer Science", faculty1);
        university.addFacultyToDepartment("Computer Science", faculty2);
        university.addFacultyToDepartment("Physics", faculty3);

        // Display university structure
        university.displayUniversityStructure();

        // Delete university (end of scope implies all departments are also deleted)
        university = null;
        System.out.println("University object is deleted. Departments no longer exist.");

        // Faculty members still exist independently
        System.out.println("Independent Faculty Members:");
        System.out.println(faculty1);
        System.out.println(faculty2);
        System.out.println(faculty3);
    }
}
 
