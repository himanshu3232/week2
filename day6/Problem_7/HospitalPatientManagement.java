import java.util.*;

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);

    List<String> viewRecords();
}

// Subclass InPatient
class InPatient extends Patient implements MedicalRecord {
    private double roomCharges;
    private int numberOfDays;
    private List<String> medicalRecords;

    public InPatient(String patientId, String name, int age, double roomCharges, int numberOfDays) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
        this.numberOfDays = numberOfDays;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return roomCharges * numberOfDays;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
        System.out.println("Record added: " + record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

// Subclass OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
        System.out.println("Record added: " + record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // Create a list of patients
        List<Patient> patients = new ArrayList<>();

        // Add patients
        InPatient inPatient = new InPatient("P001", "Alice", 30, 2000.0, 5);
        inPatient.addRecord("Admitted for surgery.");
        inPatient.addRecord("Post-surgery recovery.");

        OutPatient outPatient = new OutPatient("P002", "Bob", 40, 500.0);
        outPatient.addRecord("Consulted for flu symptoms.");

        patients.add(inPatient);
        patients.add(outPatient);

        // Display patient details and bills
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Medical Records: " + ((MedicalRecord) patient).viewRecords());
            System.out.println("Total Bill: " + patient.calculateBill());
            System.out.println("-----------------------------------");
        }
    }
}
