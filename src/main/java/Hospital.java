import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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