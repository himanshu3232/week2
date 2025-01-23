import java.util.ArrayList;
import java.util.List;

// Subject Class
class Subject {
    private String subjectName;
    private double score;

    public Subject(String subjectName, double score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getScore() {
        return score;
    }
}

// Student Class
class Student {
    private String name;
    private String studentId;
    private List<Subject> subjects;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}

// GradeCalculator Class
class GradeCalculator {

    public void calculateGrade(Student student) {
        List<Subject> subjects = student.getSubjects();
        double totalScore = 0;
        for (Subject subject : subjects) {
            totalScore += subject.getScore();
        }
        double averageScore = totalScore / subjects.size();
        char grade = getGrade(averageScore);
        System.out.println("Student: " + student.getName() + ", ID: " + student.getStudentId());
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);
    }

    private char getGrade(double averageScore) {
        if (averageScore >= 90) {
            return 'A';
        } else if (averageScore >= 80) {
            return 'B';
        } else if (averageScore >= 70) {
            return 'C';
        } else if (averageScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

// Main Class
public class SchoolResultApplication {
    public static void main(String[] args) {

        ArrayList h= new ArrayList();
        ArrayList<String> h6=new ArrayList<>();
        // Create student
        Student student = new Student("John", "S001");

        // Add subjects and scores
        student.addSubject(new Subject("Mathematics", 85));
        student.addSubject(new Subject("Science", 90));
       

        // Calculate grade
        GradeCalculator gradeCalculator = new GradeCalculator();
        gradeCalculator.calculateGrade(student);
    }
}

 
