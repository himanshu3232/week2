import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String name;
    private Professor professor;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    // Assign a professor to the course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " has been assigned to the course: " + name);
    }

    // Enroll a student in the course
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
            System.out.println("Student " + student.getName() + " has been enrolled in the course: " + name);
        }
    }

    // Display all students enrolled in the course
    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in course: " + name);
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled yet.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println(student.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return professor;
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Add a course to the student's list
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // Display all courses the student is enrolled in
    public void displayCourses() {
        System.out.println("Courses enrolled by student: " + name);
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled yet.");
        } else {
            for (Course course : courses) {
                System.out.println(course.getName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Professor class
class Professor {
    private String name;
    private List<Course> courses;

    // Constructor
    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Assign a course to the professor
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // Display all courses the professor teaches
    public void displayCourses() {
        System.out.println("Courses taught by professor: " + name);
        if (courses.isEmpty()) {
            System.out.println("No courses assigned yet.");
        } else {
            for (Course course : courses) {
                System.out.println(course.getName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Main class to demonstrate the university management system
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        // Create courses
        Course course1 = new Course("Computer Science 101");
        Course course2 = new Course("Mathematics 101");

        // Assign professors to courses
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        // Add courses to professors
        professor1.addCourse(course1);
        professor2.addCourse(course2);

        // Enroll students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        // Display courses taught by professors
        professor1.displayCourses();
        professor2.displayCourses();

        // Display courses enrolled by students
        student1.displayCourses();
        student2.displayCourses();

        // Display students enrolled in courses
        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();
    }
}
 
