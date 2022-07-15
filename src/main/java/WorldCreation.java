import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class WorldCreation implements UserInput{
    Input sc = Input.getInstance();

    @Override
    public Hospital createHospital() {
        String name = sc.getString("What is the name of the hospital you would like to build?");
        Hospital hospital = new Hospital(name);
        System.out.println("Hospital " + hospital.getName() + "has been created");
        return hospital;
    }

    @Override
    public void createDoctors(Hospital hospital) {
        //Let user define the number of doctors to create;
        int numberOfDoctors = sc.getInt("How many Doctors would you like to hire?");
        //create doctors;
        sc.getString("");
        for(int i = 0; i < numberOfDoctors; i++){
            String name = sc.getString("What is the doctor's name?");

            //Get valid user definable specialties from our enum;
            String specialtyInput = sc.getString("What is their specialty? You must choose from this list." + "DERMATOLOGY, CARDIOLOGY, NEUROLOGY, RADIOLOGY, PEDIATRICS");
            try {
                //loop through enum values and compare to user input to test validity;
                for (SpecialtiesEnum currentSpecialty : SpecialtiesEnum.values()){
                    if(currentSpecialty.getLabel().equalsIgnoreCase(specialtyInput)){
                        Doctor doctor = new Doctor(name, specialtyInput);
                        hospital.addDoctor(doctor);
                        System.out.println("Doctor " + doctor.getName() + " has been hired at " + hospital.getName());
                        break;
                    }
                }

            } catch(InputMismatchException inputException) {
                throw new InputMismatchException("Specialty must be from the suggested list.");
            }
        }

    }

    @Override
    public void createPatients(Hospital hospital) {
        int numberOfPatients = sc.getInt("How many Patients would you like to register?");
        sc.getString("");

        //Allow for user defined patients and loop to create them;
        for(int i = 0; i < numberOfPatients; i++){
            String name = sc.getString("What is the patient's name?");
            //Get valid user definable specialties from our enum;
            String specialtyInput = sc.getString("What kind of Doctor do they need? You must choose from this list." + "DERMATOLOGY, CARDIOLOGY, NEUROLOGY, RADIOLOGY, PEDIATRICS");
            try {
                //loop through enum values and compare to user input to test validity;
                for (SpecialtiesEnum currentSpecialty : SpecialtiesEnum.values()){
                    if(currentSpecialty.getLabel().equalsIgnoreCase(specialtyInput)){
                        Patient patient = new Patient(name, specialtyInput);
                        //loop through doctors and assign doctor to patient by comparing specialties needed and doctor specialties
                        List<Doctor> doctorList = hospital.getDoctors();
                        for(Doctor currentDoctor: doctorList){
                            String currentDoctorSpecialty = currentDoctor.getSpecialty();
                            if(currentDoctorSpecialty.equals(specialtyInput)){
                                currentDoctor.addPatient(patient);
                                hospital.addPatient(patient);
                                break;
                            }
                        }
                        System.out.println("Patient " + patient.getName() + " has been created.");
                    } else {
                    }
                }
            } catch(InputMismatchException inputException) {
                throw new InputMismatchException("Specialty must be from the suggested list.");
            }
        }
    }
}