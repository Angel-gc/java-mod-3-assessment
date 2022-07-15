import java.util.List;
import java.util.Map;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class HospitalWorld {
    public static void main(String[] args) throws Exception {
        UserOutputService userOutputService = new SysoutUserOutputService();
        try (UserInputService userInputService = new ScannerUserInputService(userOutputService);) {
            // UserInputService userInputService = new GUIUserInputService();
            DoctorBuilderService doctorBuilderService = new DoctorBuilderService(userInputService);
            PatientBuilderService patientBuilderService = new PatientBuilderService(userInputService);
            HospitalBuilderService hospitalBuilderService = new HospitalBuilderService(userInputService,
                    doctorBuilderService, patientBuilderService);
            Hospital hospital = hospitalBuilderService.createHospital();
            HospitalStringifier hospitalStringifier = new HospitalStringifier();
            String result = hospitalStringifier.getStringFromHospital(hospital);
            userOutputService.printMessage(result);
        }
        // Ask user for hospital name
        // How to ask?
        // How to take in answer?
        // What hospital information do we need?
        // Ask user for 3 doctors
        // How to ask?
        // How to take in answer?
        // What doctor information do we need?
        // Ask user for 5 patients
        // How to ask?
        // How to take in answer?
        // What patient information do we need?
        // How do we match patient to doctor?
        // Print hospital information
        // How to print?
        // What hospital/doctor/patient information do we need to print?

        // Let's think...
        // We need to hold data
        // Hospital
        // Doctor
        // Patient
        // We need logic
        // We need to build a hospital
        // We need to build doctors
        // We need to build patients
        // We need to display the hospital
        // Let's think about *how* to do that last
        // We need I/O code
        // Something to display text to user
        // Something to take in user-typed text

        // Let's think really hard...
        // What's the relationship between hospitals and doctors and patients?
        // What Collections should we use?

    }
}

interface UserInputService extends AutoCloseable {
    String getUserInput(String prompt);

}

interface UserOutputService {
    void printMessage(String message);
}

class SysoutUserOutputService implements UserOutputService {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

}

class ScannerUserInputService implements UserInputService {
    private Scanner scanner;
    private UserOutputService userOutputService;

    public ScannerUserInputService(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }

    public String getUserInput(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserInput(prompt);
        }
        return input;
    }

    @Override
    public void close() throws Exception {
        scanner.close();

    }
}

class GUIUserInputService implements UserInputService {

    @Override
    public String getUserInput(String prompt) {
        String response = JOptionPane.showInputDialog(null, prompt);
        if (response.isBlank()) {
            return getUserInput(prompt);
        }
        return response;
    }

}

class PatientBuilderService {
    private UserInputService userInputService;

    public PatientBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");
        String specialty = userInputService.getUserInput("What's the patient's specialty?");
        Patient patient = new Patient(name, specialty);
        return patient;
    }
}

class DoctorBuilderService {
    private UserInputService userInputService;

    public DoctorBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Doctor createDoctor() {
        String name = userInputService.getUserInput("What's the doc's name?");
        String specialty = userInputService.getUserInput("What's the doc's specialty?");
        Doctor doctor = new Doctor(name, specialty);
        return doctor;
    }
}

class HospitalStringifier {
    public String getStringFromHospital(Hospital hospital) {
        return hospital.toString();
    }
}

class HospitalBuilderService {

    private UserInputService userInputService;
    private DoctorBuilderService doctorBuilderService;
    private PatientBuilderService patientBuilderService;
    private static final int NUMBER_OF_DOCTORS = 3;
    private static final int NUMBER_OF_PATIENTS = 5;

    // constructor injection
    public HospitalBuilderService(UserInputService userInputService, DoctorBuilderService doctorBuilderService,
                                  PatientBuilderService patientBuilderService) {
        this.userInputService = userInputService;
        this.doctorBuilderService = doctorBuilderService;
        this.patientBuilderService = patientBuilderService;
    }

    public Hospital createHospital() {
        String name = userInputService.getUserInput("What's the hospital name?");
        Hospital hospital = new Hospital(name);
        for (int i = 0; i < NUMBER_OF_DOCTORS; i++) {
            Doctor doctor = doctorBuilderService.createDoctor();
            hospital.addDoctor(doctor);
        }
        for (int i = 0; i < NUMBER_OF_PATIENTS; i++) {
            Patient patient = patientBuilderService.createPatient();
            hospital.addPatient(patient);
        }
        return hospital;

    }

}

/**
 * Immutable!
 */
class Patient {
    private String name;
    private String need;

    public Patient(String name, String need) {
        this.name = name;
        this.need = need;
    }

    public String getName() {
        return name;
    }

    public String getNeed() {
        return need;
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + ", need=" + need + "]";
    }

}

class Doctor {
    private String name;
    private String specialty;
    private boolean registered;
    private Queue<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.registered = true;
        this.patients = new ArrayDeque<Patient>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public int getPatientCount() {
        return this.patients.size();
    }

    @Override
    public String toString() {
        return "Doctor [name=" + name + ", patients=" + patients + ", registered=" + registered + ", specialty="
                + specialty + "]";
    }

}

class Hospital {
    private String name;
    private Map<String, Set<Doctor>> specialtyToDoctors;

    public Hospital(String name) {
        this.name = name;
        this.specialtyToDoctors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        // case 1, this specialty already exists in the map
        if (specialtyToDoctors.containsKey(doctor.getSpecialty())) {
            Set<Doctor> withSpecialty = specialtyToDoctors.get(doctor.getSpecialty());
            withSpecialty.add(doctor);
        } else {
            // case 2, this specialty does not already exist in the map
            Set<Doctor> doctors = new HashSet<>();
            doctors.add(doctor);
            specialtyToDoctors.put(doctor.getSpecialty(), doctors);
        }
    }

    public void addPatient(Patient patient) {
        // how? where?
        // assign the patient to a doctor
        // look through the map, find the set of doctors with the required specialty
        Set<Doctor> doctorsWithThatSpecialty = specialtyToDoctors.get(patient.getNeed());
        Doctor chosenDoctor = findDoctorWithShortestQueue(doctorsWithThatSpecialty);
        chosenDoctor.addPatient(patient);
        // which individual doctor should be chosen
        // find the doctor with the shortest queue?

    }

    private Doctor findDoctorWithShortestQueue(Set<Doctor> doctors) {
        Doctor chosenDoctor = null;
        for (Doctor doctor : doctors) {
            if (chosenDoctor == null) {
                chosenDoctor = doctor;
            } else if (chosenDoctor.getPatientCount() > doctor.getPatientCount()) {
                chosenDoctor = doctor;
            }
        }
        return chosenDoctor;
    }

    @Override
    public String toString() {
        return "Hospital [name=" + name + ", specialtyToDoctors=" + specialtyToDoctors + "]";
    }

}