import java.util.ArrayList;
import java.util.List;

class Hospital {
    private String name;
    private static List<Doctor> doctors = new ArrayList<Doctor>();
    private List<Patient> patients = new ArrayList<Patient>();

    public Hospital(String name) {
        this.name = name;
    }
    public List<Patient> getPatients() {
        return patients;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Doctor> getDoctors() {
        return doctors;
    }
    public static Doctor createDoctor(){
        Input sc = Input.getInstance();
        String name = sc.getString("Provide Doctor name");
        String specialty = sc.getString("Provide specialty");
        Doctor doctor = new Doctor(name, specialty);
        return doctor;
    }
    public void addDoctor(Doctor doctor){
        this.doctors.add(doctor);
    }
    public void addPatient(Patient patient){
        this.patients.add(patient);
    }
    public void printDoctorsPatients(){
        for(Doctor doctor: doctors){
            System.out.println("Doctor: " + doctor.getName());
            System.out.println("Patients: " + doctor.getPatients());
        }
    }
    @Override
    public String toString() {
        return "Hospital [doctors=" + doctors + ", name=" + name + ", patients=" + patients + "]";
    }
}