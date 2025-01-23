import java.util.ArrayList;
import java.util.List;

// Patient class
class Patient {
    private String name;
    private List<Doctor> consultedDoctors;

    // Constructor
    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }

    // Add a doctor to the list of consulted doctors
    public void addConsultedDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    // Display all doctors the patient has consulted
    public void displayConsultedDoctors() {
        System.out.println("Doctors consulted by patient: " + name);
        if (consultedDoctors.isEmpty()) {
            System.out.println("No doctors consulted yet.");
        } else {
            for (Doctor doctor : consultedDoctors) {
                System.out.println(doctor.getName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

// Doctor class
class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    // Constructor
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Consult a patient
    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addConsultedDoctor(this);
        }
        System.out.println("Doctor " + name + " consulted patient " + patient.getName() + ".");
    }

    // Display all patients the doctor has consulted
    public void displayPatients() {
        System.out.println("Patients consulted by doctor: " + name);
        if (patients.isEmpty()) {
            System.out.println("No patients consulted yet.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

// Hospital class
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    // Constructor
    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add a doctor to the hospital
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    // Add a patient to the hospital
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    // Display all doctors in the hospital
    public void displayDoctors() {
        System.out.println("Doctors in hospital: " + name);
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName() + " - " + doctor.getSpecialization());
            }
        }
    }

    // Display all patients in the hospital
    public void displayPatients() {
        System.out.println("Patients in hospital: " + name);
        if (patients.isEmpty()) {
            System.out.println("No patients admitted.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient.getName());
            }
        }
    }
}

// Main class to demonstrate association and communication
public class HospitalManagement {
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("City General Hospital");

        // Create doctors
        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Johnson", "Neurology");

        // Add doctors to the hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Create patients
        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        // Add patients to the hospital
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Consultations
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        // Display hospital doctors and patients
        hospital.displayDoctors();
        hospital.displayPatients();

        // Display doctor-patient consultations
        doctor1.displayPatients();
        doctor2.displayPatients();

        // Display patient-doctor consultations
        patient1.displayConsultedDoctors();
        patient2.displayConsultedDoctors();
    }
}
 
