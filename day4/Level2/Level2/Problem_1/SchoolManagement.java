import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String name;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    // Enroll a student in the course
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.enrollInCourse(this);
        }
    }

    // Display all students in the course
    public void displayStudents() {
        System.out.println("Students enrolled in course: " + name);
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled in this course.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println(student.getName());
            }
        }
    }

    public String getName() {
        return name;
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

    // Enroll in a course
    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // Display all courses the student is enrolled in
    public void displayCourses() {
        System.out.println("Courses for student: " + name);
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
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

// School class
class School {
    private String name;
    private List<Student> students;

    // Constructor
    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Add a student to the school
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Display all students in the school
    public void displayStudents() {
        System.out.println("Students in school: " + name);
        if (students.isEmpty()) {
            System.out.println("No students in the school.");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }
}

// Main class to demonstrate association and aggregation
public class SchoolManagement {
    public static void main(String[] args) {
        // Create a school
        School school = new School("Greenfield High");

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Add students to the school
        school.addStudent(student1);
        school.addStudent(student2);

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enroll students in courses
        math.enrollStudent(student1);
        math.enrollStudent(student2);
        science.enrollStudent(student1);

        // Display school students
        school.displayStudents();

        // Display student courses
        student1.displayCourses();
        student2.displayCourses();

        // Display course enrollments
        math.displayStudents();
        science.displayStudents();
    }
}
 
