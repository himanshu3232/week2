// Base class: Course
class Course {
    private String courseName;
    private int duration; // in hours

    // Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getter methods
    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    // Method to display course details
    public String getDetails() {
        return "Course Name: " + courseName + ", Duration: " + duration + " hours";
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    // Constructor
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Getter methods
    public String getPlatform() {
        return platform;
    }

    public boolean isRecorded() {
        return isRecorded;
    }

    // Overriding getDetails method
    @Override
    public String getDetails() {
        String recordingInfo = isRecorded ? "Recorded" : "Live";
        return super.getDetails() + ", Platform: " + platform + ", Type: " + recordingInfo;
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage

    // Constructor
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Getter methods
    public double getFee() {
        return fee;
    }

    public double getDiscount() {
        return discount;
    }

    // Method to calculate final fee after discount
    public double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    // Overriding getDetails method
    @Override
    public String getDetails() {
        return super.getDetails() + ", Fee: $" + fee + ", Discount: " + discount + "%, Final Fee: $" + getFinalFee();
    }
}

// Main class to test the hierarchy
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        // Creating objects for each class
        Course course = new Course("Mathematics Basics", 30);
        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 40, "Udemy", true);
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Advanced Python", 50, "Coursera", true, 500.0, 20.0);

        // Displaying details of each course
        System.out.println(course.getDetails());
        System.out.println(onlineCourse.getDetails());
        System.out.println(paidOnlineCourse.getDetails());
    }
}
