import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HospitalWorld {
    static List<Patient> patients;
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
            selectPatient();
        }
    }
//        Allow the user to select a patient to go through a round of treatment
          public static Patient selectPatient(){
              for (Patient patient: patients){
                System.out.println(patient);
              }
              Input sc = Input.getInstance();
              int i = sc.getInt("Please select a patient from above to undergo treatment by typing in their index.");
              if (patients.contains(patients.get(i))){
                  return patients.get(i);
              }
              System.out.println("Sorry that patient doesn't exist.");
              return null;
        }
        //should be using observer for this, not sure if this works
        public void dismissPatientFromHospital(){
            for (Patient patient: patients){
               int status =  patient.getHealthIndex();
               if (status >= 100){
                   System.out.println("you completely healed, you are discharged!");
                   patients.remove(patient);
                }
               else if (status <= 0){
                   System.out.println("You are deceased, RIP.");
                   patients.remove(patient);
               }
            }
        }

    static void saveListAsJSON(List<Patient> personList) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personList);

        mapper.writeValue(new File("people.json"), personList);
        System.out.println("This is our Json output: " + json);
    }
    public static List<Patient> readJson() throws JsonProcessingException {
        try {
            return Arrays.asList(new ObjectMapper().readValue(new File("people.json"), Patient[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * Immutable!
 */

//        User selects a patient index that's outside the range of existing patients (e.g. user selects a patient not on the patient list)

//        Dismiss a patient from the hospital once their health index reaches 100
//        Allow the user to stop the virtual world and restore it to its last state when they start the virtual world again
//        Allow the user to admit new patients at the hospital



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
