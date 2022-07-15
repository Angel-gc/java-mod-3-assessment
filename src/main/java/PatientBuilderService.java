class PatientBuilderService {
    private UserInputService userInputService;

    public PatientBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");
        String specialty = userInputService.getUserInput("What's the patient's specialty?");
        Patient patient = new Patient(name, specialty);
        return patient;
    }
}