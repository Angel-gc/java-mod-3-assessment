public class Patient{
    private String name;
    private String specialtyNeeded;
    private Doctor doctor;

    public Patient(String name, String specialtyNeeded) {
        this.name = name;
        this.specialtyNeeded = specialtyNeeded;
    }

    public String getName() {
        return name;
    }

    public String getSpecialtyNeeded() {
        return specialtyNeeded;
    }

    public void setSpecialtyNeeded(String specialtyNeeded) {
        this.specialtyNeeded = specialtyNeeded;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient [doctor=" + doctor + ", name=" + name + ", specialtyNeeded=" + specialtyNeeded + "]";
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}