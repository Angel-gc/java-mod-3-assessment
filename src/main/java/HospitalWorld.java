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
        UserOutputService userOutputService = new SysOutUserOutputService();
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

















/**
 * Immutable!
 */




