import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class Doctor {
    private String name;
    private String specialty;
    private SpecialtiesEnum enumSpecialty;
    private boolean registered;
    private Queue<Patient> patients;
    private SpecialtiesEnum healing;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.registered = true;
        this.patients = new ArrayDeque<Patient>();
    }
    public Doctor (SpecialtiesEnum healing, SpecialtiesEnum enumSpecialty) {
        this.enumSpecialty = enumSpecialty;
        this.healing = healing;

            switch(enumSpecialty.getNumberOfTreatments()) {
                case 5:
                    healing.setHealingPower(10);
                    break;
                case 2:
                    healing.setHealingPower(15);
                    break;
                case 3:
                    healing.setHealingPower(20);
                    break;
                case 4:
                    healing.setHealingPower(20);
                    break;
                case 1:
                    healing.setHealingPower(50);
                    break;
            }
        }
    // Update the patient's health index when they go through a round of treatment
//    public void treatPatient(Patient patient) {
//        // once user enters patient, check if the patient is in a list
//        if (!patients.contains(patient)) {
//            System.out.println("Sorry Patient doesn't exist.");
//        }
//            treatPatient(patient);
//    }

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

