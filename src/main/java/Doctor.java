import java.util.ArrayList;
import java.util.List;

class Doctor {
    private final String name;
    private final String specialty;
    private List<Patient> patients = new ArrayList<Patient>();
    private int healingPower;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }
    public String getName() {
        return name;
    }
    public String getSpecialty() {
        return specialty;
    }
    public List<Patient> getPatients() {
        return patients;
    }
    @Override
    public String toString() {
        return "Doctor [name=" + name + ", patients=" + patients + ", specialty=" + specialty + "]";
    }
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    public void addPatient(Patient patient){
        this.patients.add(patient);
    }
}