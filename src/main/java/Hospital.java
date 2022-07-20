import java.util.*;

class Hospital {
    private String name;
    private Map<String, Set<Doctor>> specialtyToDoctors;

    public Hospital(String name) {
        this.name = name;
        this.specialtyToDoctors = new HashMap<>();
    }
    public Hospital (){

    }

//    private Doctor findDoctorWithShortestQueue(Set<Doctor> doctors) {
//        Doctor chosenDoctor = null;
//        for (Doctor doctor : doctors) {
//            if (chosenDoctor == null) {
//                chosenDoctor = doctor;
//            } else if (chosenDoctor.getPatientCount() > doctor.getPatientCount()) {
//                chosenDoctor = doctor;
//            }
//        }
//        return chosenDoctor;
//    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Hospital [name=" + name + ", specialtyToDoctors=" + specialtyToDoctors + "]";
    }

    public void addDoctorToMap(Doctor doctor) {
       String doctorSpec = doctor.getSpecialty().getName();
        if (specialtyToDoctors.containsKey(doctorSpec)) {
            Set<Doctor> specialtySet = specialtyToDoctors.get(doctorSpec);
            specialtySet.add(doctor);
        } else {
            Set<Doctor> doctors = new HashSet<>();
            doctors.add(doctor);
            specialtyToDoctors.put(doctorSpec, doctors);
        }
    }
    public void addPatientToDoctorList(Patient patient, UserOutputService out){
// check if the specialty to doctor map has a specialty key string that matches patient's disease name
        Set<Doctor> doctorSet = specialtyToDoctors.get(patient.getDisease().getName());
        if (doctorSet.isEmpty()){
            out.printMessage("Sorry there isn't currently a doctor for this patient.");
        } else {
            Doctor assignedDoctor = findDoctor(doctorSet);
            assignedDoctor.addPatient(patient);
        }
    }

    private Doctor findDoctor(Set<Doctor> doctors) {
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
}