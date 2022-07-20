class HospitalBuilderService {

    private UserInputService userInputService;
    private UserOutputService userOutputService;
    private DoctorBuilderService doctorBuilderService;
    private PatientBuilderService patientBuilderService;
    private static final int NUMBER_OF_DOCTORS = 3;
    private static final int NUMBER_OF_PATIENTS = 5;

    // constructor injection
    public HospitalBuilderService(UserInputService userInputService, UserOutputService userOutputService, DoctorBuilderService doctorBuilderService,
                                  PatientBuilderService patientBuilderService) {
        this.userInputService = userInputService;
        this.userOutputService = userOutputService;
        this.doctorBuilderService = doctorBuilderService;
        this.patientBuilderService = patientBuilderService;
    }

    public Hospital createHospital() {
        String name = userInputService.getUserInput("What's the hospital name?");
        Hospital hospital = new Hospital(name);
        for (int i = 0; i < NUMBER_OF_DOCTORS; i++) {
            Doctor doctor = doctorBuilderService.createDoctor();
            hospital.addDoctorToMap(doctor);
        }
        for (int i = 0; i < NUMBER_OF_PATIENTS; i++) {
            Patient patient = patientBuilderService.createPatient();
            hospital.addPatientToDoctorList(patient, userOutputService);
        }
        return hospital;

    }

}