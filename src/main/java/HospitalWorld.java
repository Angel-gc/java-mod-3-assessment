import java.util.List;
import java.util.Map;

public class HospitalWorld {
    public static void main(String[] args) {
        // your code here
//       1. The system should create a Hospital with a name property provided by the user.
//       2. The system should create 3 doctors, each with a name and specialty provided by the user. The specialty is user-definable
//       3.The system should establish that the doctors work at the system's hospital.
//       4.The system should ask the user to create 5 patients and match each patient to a doctor based on the specialty they need.
//       5.When the system is done collecting input from the user and building the world, it should "display" the world to the user (text-based display on the command line).
//       6.The system must handle invalid input from the user (at all points where input is gathered from the user).

    }
    public class Hospital {
        private Map<String, List<Doctor>> specialtyToDoctors;

        public Patient createPatient(){
            return;
        }

        public Doctor createDoctor(){
            return;
        }
        public void assignDoctorToSpecialty(Doctor doctor, String specialty){

        }
        public void assignPatientToSpecialist(Patient patient){

        };

    }
    public class Doctor {
        private List <Patient> patients;
        private String mySpecialty;
        private int healingPower;

        public void treatPatient(Patient patient){

        }
        public void removePatient(Patient patient){

        }
    }
    public class Patient {
        private int healthIndex;
        private Ailment myDisease;

        public void receiveTreatment(int healed){

        }
        public void healed(){};

        public void died(){};
    }

    public class Ailment {
       private int startingHealthIndex;
       private String name;
       private String associatedSpecialty;
    }
}
