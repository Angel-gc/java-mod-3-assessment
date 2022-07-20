import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Doctor {
    private String name;
    private Specialty specialty;
    private boolean registered;
    List<Patient> patients;

    public Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
        this.registered = true;
        patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
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
        return "Doctor [name=" + name + ", patients=" + ", registered=" + registered + ", specialty="
                + specialty + "]";
    }

}

